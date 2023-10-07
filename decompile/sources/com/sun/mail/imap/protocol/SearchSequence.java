package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;

class SearchSequence {
    private static Calendar cal = new GregorianCalendar();
    private static String[] monthTable = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    SearchSequence() {
    }

    private static Argument and(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        Argument generateSequence = generateSequence(terms[0], str);
        for (int i2 = 1; i2 < terms.length; i2++) {
            generateSequence.append(generateSequence(terms[i2], str));
        }
        return generateSequence;
    }

    private static Argument body(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("BODY");
        argument.writeString(bodyTerm.getPattern(), str);
        return argument;
    }

    private static Argument flag(FlagTerm flagTerm) throws SearchException {
        String str;
        boolean testSet = flagTerm.getTestSet();
        Argument argument = new Argument();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (int i2 = 0; i2 < systemFlags.length; i2++) {
            if (systemFlags[i2] == Flags.Flag.DELETED) {
                str = testSet ? "DELETED" : "UNDELETED";
            } else if (systemFlags[i2] == Flags.Flag.ANSWERED) {
                str = testSet ? "ANSWERED" : "UNANSWERED";
            } else if (systemFlags[i2] == Flags.Flag.DRAFT) {
                str = testSet ? "DRAFT" : "UNDRAFT";
            } else if (systemFlags[i2] == Flags.Flag.FLAGGED) {
                str = testSet ? "FLAGGED" : "UNFLAGGED";
            } else if (systemFlags[i2] == Flags.Flag.RECENT) {
                str = testSet ? "RECENT" : "OLD";
            } else if (systemFlags[i2] != Flags.Flag.SEEN) {
            } else {
                str = testSet ? "SEEN" : "UNSEEN";
            }
            argument.writeAtom(str);
        }
        for (String writeAtom : userFlags) {
            argument.writeAtom(testSet ? "KEYWORD" : "UNKEYWORD");
            argument.writeAtom(writeAtom);
        }
        return argument;
    }

    private static Argument from(String str, String str2) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("FROM");
        argument.writeString(str, str2);
        return argument;
    }

    static Argument generateSequence(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return and((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return or((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return not((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return header((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return flag((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return from(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return from(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return recipient(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        } else if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return recipient(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        } else if (searchTerm instanceof SubjectTerm) {
            return subject((SubjectTerm) searchTerm, str);
        } else {
            if (searchTerm instanceof BodyTerm) {
                return body((BodyTerm) searchTerm, str);
            }
            if (searchTerm instanceof SizeTerm) {
                return size((SizeTerm) searchTerm);
            }
            if (searchTerm instanceof SentDateTerm) {
                return sentdate((SentDateTerm) searchTerm);
            }
            if (searchTerm instanceof ReceivedDateTerm) {
                return receiveddate((ReceivedDateTerm) searchTerm);
            }
            if (searchTerm instanceof MessageIDTerm) {
                return messageid((MessageIDTerm) searchTerm, str);
            }
            throw new SearchException("Search too complex");
        }
    }

    private static Argument header(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString(headerTerm.getHeaderName());
        argument.writeString(headerTerm.getPattern(), str);
        return argument;
    }

    private static boolean isAscii(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) > 127) {
                return false;
            }
        }
        return true;
    }

    static boolean isAscii(SearchTerm searchTerm) {
        boolean z2 = searchTerm instanceof AndTerm;
        if (z2 || (searchTerm instanceof OrTerm)) {
            SearchTerm[] terms = z2 ? ((AndTerm) searchTerm).getTerms() : ((OrTerm) searchTerm).getTerms();
            for (SearchTerm isAscii : terms) {
                if (!isAscii(isAscii)) {
                    return false;
                }
            }
            return true;
        } else if (searchTerm instanceof NotTerm) {
            return isAscii(((NotTerm) searchTerm).getTerm());
        } else {
            if (searchTerm instanceof StringTerm) {
                return isAscii(((StringTerm) searchTerm).getPattern());
            }
            if (searchTerm instanceof AddressTerm) {
                return isAscii(((AddressTerm) searchTerm).getAddress().toString());
            }
            return true;
        }
    }

    private static Argument messageid(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString("Message-ID");
        argument.writeString(messageIDTerm.getPattern(), str);
        return argument;
    }

    private static Argument not(NotTerm notTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("NOT");
        SearchTerm term = notTerm.getTerm();
        if ((term instanceof AndTerm) || (term instanceof FlagTerm)) {
            argument.writeArgument(generateSequence(term, str));
        } else {
            argument.append(generateSequence(term, str));
        }
        return argument;
    }

    private static Argument or(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            OrTerm orTerm2 = terms[0];
            int i2 = 1;
            while (i2 < terms.length) {
                i2++;
                orTerm2 = new OrTerm(orTerm2, terms[i2]);
            }
            terms = ((OrTerm) orTerm2).getTerms();
        }
        Argument argument = new Argument();
        if (terms.length > 1) {
            argument.writeAtom("OR");
        }
        if ((terms[0] instanceof AndTerm) || (terms[0] instanceof FlagTerm)) {
            argument.writeArgument(generateSequence(terms[0], str));
        } else {
            argument.append(generateSequence(terms[0], str));
        }
        if (terms.length > 1) {
            if ((terms[1] instanceof AndTerm) || (terms[1] instanceof FlagTerm)) {
                argument.writeArgument(generateSequence(terms[1], str));
            } else {
                argument.append(generateSequence(terms[1], str));
            }
        }
        return argument;
    }

    private static Argument receiveddate(DateTerm dateTerm) throws SearchException {
        StringBuilder sb;
        Argument argument = new Argument();
        String iMAPDate = toIMAPDate(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                sb = new StringBuilder("OR BEFORE ");
                break;
            case 2:
                sb = new StringBuilder("BEFORE ");
                break;
            case 3:
                sb = new StringBuilder("ON ");
                break;
            case 4:
                sb = new StringBuilder("NOT ON ");
                break;
            case 5:
                sb = new StringBuilder("SINCE ");
                break;
            case 6:
                sb = new StringBuilder("OR SINCE ");
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        sb.append(iMAPDate);
        sb.append(" ON ");
        sb.append(iMAPDate);
        argument.writeAtom(sb.toString());
        return argument;
    }

    private static Argument recipient(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        String str3;
        Argument argument = new Argument();
        if (recipientType == Message.RecipientType.TO) {
            str3 = "TO";
        } else if (recipientType == Message.RecipientType.CC) {
            str3 = "CC";
        } else if (recipientType == Message.RecipientType.BCC) {
            str3 = "BCC";
        } else {
            throw new SearchException("Illegal Recipient type");
        }
        argument.writeAtom(str3);
        argument.writeString(str, str2);
        return argument;
    }

    private static Argument sentdate(DateTerm dateTerm) throws SearchException {
        StringBuilder sb;
        Argument argument = new Argument();
        String iMAPDate = toIMAPDate(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                sb = new StringBuilder("OR SENTBEFORE ");
                break;
            case 2:
                sb = new StringBuilder("SENTBEFORE ");
                break;
            case 3:
                sb = new StringBuilder("SENTON ");
                break;
            case 4:
                sb = new StringBuilder("NOT SENTON ");
                break;
            case 5:
                sb = new StringBuilder("SENTSINCE ");
                break;
            case 6:
                sb = new StringBuilder("OR SENTSINCE ");
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        sb.append(iMAPDate);
        sb.append(" SENTON ");
        sb.append(iMAPDate);
        argument.writeAtom(sb.toString());
        return argument;
    }

    private static Argument size(SizeTerm sizeTerm) throws SearchException {
        String str;
        Argument argument = new Argument();
        int comparison = sizeTerm.getComparison();
        if (comparison == 2) {
            str = "SMALLER";
        } else if (comparison == 5) {
            str = "LARGER";
        } else {
            throw new SearchException("Cannot handle Comparison");
        }
        argument.writeAtom(str);
        argument.writeNumber(sizeTerm.getNumber());
        return argument;
    }

    private static Argument subject(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("SUBJECT");
        argument.writeString(subjectTerm.getPattern(), str);
        return argument;
    }

    private static String toIMAPDate(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        cal.setTime(date);
        stringBuffer.append(cal.get(5));
        stringBuffer.append("-");
        stringBuffer.append(monthTable[cal.get(2)]);
        stringBuffer.append('-');
        stringBuffer.append(cal.get(1));
        return stringBuffer.toString();
    }
}
