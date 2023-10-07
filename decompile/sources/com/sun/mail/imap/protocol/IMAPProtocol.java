package com.sun.mail.imap.protocol;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.sun.mail.iap.Argument;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Literal;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.ACL;
import com.sun.mail.imap.AppendUID;
import com.sun.mail.imap.Rights;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

public class IMAPProtocol extends Protocol {
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DONE = {68, 79, 78, 69, 13, 10};
    private boolean authenticated;
    private List authmechs = null;

    /* renamed from: ba  reason: collision with root package name */
    private ByteArray f21760ba;
    private Map capabilities = null;
    private boolean connected = false;
    private String idleTag;
    private String name;
    private boolean rev1 = false;
    private SaslAuthenticator saslAuthenticator;
    private String[] searchCharsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IMAPProtocol(String str, String str2, int i2, boolean z2, PrintStream printStream, Properties properties, boolean z3) throws IOException, ProtocolException {
        super(str2, i2, z2, printStream, properties, "mail." + str, z3);
        String str3 = str;
        try {
            this.name = str3;
            capability();
            if (hasCapability("IMAP4rev1")) {
                this.rev1 = true;
            }
            String[] strArr = new String[2];
            this.searchCharsets = strArr;
            strArr[0] = "UTF-8";
            strArr[1] = MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset());
            this.connected = true;
        } catch (Throwable th) {
            if (!this.connected) {
                disconnect();
            }
            throw th;
        }
    }

    private void copy(String str, String str2) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeAtom(str);
        argument.writeString(encode);
        simpleCommand("COPY", argument);
    }

    private String createFlagList(Flags flags) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        boolean z2 = true;
        for (Flags.Flag flag : systemFlags) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else if (flag == Flags.Flag.SEEN) {
                str = "\\Seen";
            }
            if (z2) {
                z2 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String append : userFlags) {
            if (z2) {
                z2 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(append);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private ListInfo[] doList(String str, String str2, String str3) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str2);
        String encode2 = BASE64MailboxEncoder.encode(str3);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(encode2);
        Response[] command = command(str, argument);
        ListInfo[] listInfoArr = null;
        Response response = command[command.length - 1];
        if (response.isOK()) {
            Vector vector = new Vector(1);
            int length = command.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (command[i2] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                    if (iMAPResponse.keyEquals(str)) {
                        vector.addElement(new ListInfo(iMAPResponse));
                        command[i2] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                listInfoArr = new ListInfo[vector.size()];
                vector.copyInto(listInfoArr);
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return listInfoArr;
    }

    private Response[] fetch(String str, String str2, boolean z2) throws ProtocolException {
        StringBuilder sb = z2 ? new StringBuilder("UID FETCH ") : new StringBuilder("FETCH ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(")");
        return command(sb.toString(), (Argument) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sun.mail.imap.AppendUID getAppendUID(com.sun.mail.iap.Response r5) {
        /*
            r4 = this;
            boolean r0 = r5.isOK()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            byte r0 = r5.readByte()
            if (r0 <= 0) goto L_0x0012
            r2 = 91
            if (r0 != r2) goto L_0x0008
        L_0x0012:
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r0 = r5.readAtom()
            java.lang.String r2 = "APPENDUID"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            long r0 = r5.readLong()
            long r2 = r5.readLong()
            com.sun.mail.imap.AppendUID r5 = new com.sun.mail.imap.AppendUID
            r5.<init>(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.getAppendUID(com.sun.mail.iap.Response):com.sun.mail.imap.AppendUID");
    }

    private int[] issueSearch(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        Response[] responseArr;
        Argument generateSequence = SearchSequence.generateSequence(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        generateSequence.writeAtom(str);
        if (str2 == null) {
            responseArr = command("SEARCH", generateSequence);
        } else {
            responseArr = command("SEARCH CHARSET " + str2, generateSequence);
        }
        Response response = responseArr[responseArr.length - 1];
        int[] iArr = null;
        if (response.isOK()) {
            Vector vector = new Vector();
            int length = responseArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (responseArr[i2] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArr[i2];
                    if (iMAPResponse.keyEquals("SEARCH")) {
                        while (true) {
                            int readNumber = iMAPResponse.readNumber();
                            if (readNumber == -1) {
                                break;
                            }
                            vector.addElement(new Integer(readNumber));
                        }
                        responseArr[i2] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr2[i3] = ((Integer) vector.elementAt(i3)).intValue();
            }
            iArr = iArr2;
        }
        notifyResponseHandlers(responseArr);
        handleResult(response);
        return iArr;
    }

    private Quota parseQuota(Response response) throws ParsingException {
        Quota quota = new Quota(response.readAtomString());
        response.skipSpaces();
        if (response.readByte() == 40) {
            Vector vector = new Vector();
            while (response.peekByte() != 41) {
                String readAtom = response.readAtom();
                if (readAtom != null) {
                    vector.addElement(new Quota.Resource(readAtom, response.readLong(), response.readLong()));
                }
            }
            response.readByte();
            quota.resources = new Quota.Resource[vector.size()];
            vector.copyInto(quota.resources);
            return quota;
        }
        throw new ParsingException("parse error in QUOTA");
    }

    private int[] search(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (SearchSequence.isAscii(searchTerm)) {
            try {
                return issueSearch(str, searchTerm, (String) null);
            } catch (IOException unused) {
            }
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.searchCharsets;
            if (i2 < strArr.length) {
                if (strArr[i2] != null) {
                    try {
                        return issueSearch(str, searchTerm, strArr[i2]);
                    } catch (CommandFailedException unused2) {
                        this.searchCharsets[i2] = null;
                    } catch (IOException unused3) {
                    } catch (ProtocolException e2) {
                        throw e2;
                    } catch (SearchException e3) {
                        throw e3;
                    }
                }
                i2++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    private void storeFlags(String str, Flags flags, boolean z2) throws ProtocolException {
        StringBuilder sb;
        String str2;
        if (z2) {
            sb = new StringBuilder("STORE ");
            sb.append(str);
            str2 = " +FLAGS ";
        } else {
            sb = new StringBuilder("STORE ");
            sb.append(str);
            str2 = " -FLAGS ";
        }
        sb.append(str2);
        sb.append(createFlagList(flags));
        Response[] command = command(sb.toString(), (Argument) null);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    public void append(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        appenduid(str, flags, date, literal, false);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        return appenduid(str, flags, date, literal, true);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal, boolean z2) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        if (flags != null) {
            if (flags.contains(Flags.Flag.RECENT)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(Flags.Flag.RECENT);
                flags = flags2;
            }
            argument.writeAtom(createFlagList(flags));
        }
        if (date != null) {
            argument.writeString(INTERNALDATE.format(date));
        }
        argument.writeBytes(literal);
        Response[] command = command("APPEND", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        if (z2) {
            return getAppendUID(command[command.length - 1]);
        }
        return null;
    }

    public synchronized void authlogin(String str, String str2) throws ProtocolException {
        boolean z2;
        Response response;
        Response response2;
        String str3;
        Vector vector = new Vector();
        String str4 = null;
        try {
            z2 = false;
            response = null;
            str4 = writeCommand("AUTHENTICATE LOGIN", (Argument) null);
        } catch (Exception e2) {
            response = Response.byeResponse(e2);
            z2 = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        boolean z3 = true;
        while (!z2) {
            try {
                response2 = readResponse();
                if (response2.isContinuation()) {
                    if (z3) {
                        str3 = str;
                        z3 = false;
                    } else {
                        str3 = str2;
                    }
                    bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                    bASE64EncoderStream.flush();
                    byteArrayOutputStream.write(CRLF);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.flush();
                    byteArrayOutputStream.reset();
                } else if (response2.isTagged() && response2.getTag().equals(str4)) {
                    z2 = true;
                } else if (response2.isBYE()) {
                    z2 = true;
                } else {
                    vector.addElement(response2);
                }
            } catch (Exception e3) {
                response2 = Response.byeResponse(e3);
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(response);
        setCapabilities(response);
        this.authenticated = true;
    }

    public synchronized void authplain(String str, String str2, String str3) throws ProtocolException {
        Response response;
        Response response2;
        Vector vector = new Vector();
        boolean z2 = false;
        String str4 = null;
        try {
            response = null;
            str4 = writeCommand("AUTHENTICATE PLAIN", (Argument) null);
        } catch (Exception e2) {
            response = Response.byeResponse(e2);
            z2 = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        while (!z2) {
            try {
                response2 = readResponse();
                if (response2.isContinuation()) {
                    bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                    bASE64EncoderStream.flush();
                    byteArrayOutputStream.write(CRLF);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.flush();
                    byteArrayOutputStream.reset();
                } else if (response2.isTagged() && response2.getTag().equals(str4)) {
                    z2 = true;
                } else if (response2.isBYE()) {
                    z2 = true;
                } else {
                    vector.addElement(response2);
                }
            } catch (Exception e3) {
                response2 = Response.byeResponse(e3);
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(response);
        setCapabilities(response);
        this.authenticated = true;
    }

    public void capability() throws ProtocolException {
        Response[] command = command("CAPABILITY", (Argument) null);
        if (command[command.length - 1].isOK()) {
            this.capabilities = new HashMap(10);
            this.authmechs = new ArrayList(5);
            int length = command.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (command[i2] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                    if (iMAPResponse.keyEquals("CAPABILITY")) {
                        parseCapabilities(iMAPResponse);
                    }
                }
            }
            return;
        }
        throw new ProtocolException(command[command.length - 1].toString());
    }

    public void check() throws ProtocolException {
        simpleCommand("CHECK", (Argument) null);
    }

    public void close() throws ProtocolException {
        simpleCommand("CLOSE", (Argument) null);
    }

    public void copy(int i2, int i3, String str) throws ProtocolException {
        copy(String.valueOf(String.valueOf(i2)) + ":" + String.valueOf(i3), str);
    }

    public void copy(MessageSet[] messageSetArr, String str) throws ProtocolException {
        copy(MessageSet.toString(messageSetArr), str);
    }

    public void create(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        simpleCommand("CREATE", argument);
    }

    public void delete(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        simpleCommand("DELETE", argument);
    }

    public void deleteACL(String str, String str2) throws ProtocolException {
        if (hasCapability("ACL")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            argument.writeString(str2);
            Response[] command = command("DELETEACL", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    public void disconnect() {
        super.disconnect();
        this.authenticated = false;
    }

    public MailboxInfo examine(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("EXAMINE", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        mailboxInfo.mode = 1;
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        return mailboxInfo;
    }

    public void expunge() throws ProtocolException {
        simpleCommand("EXPUNGE", (Argument) null);
    }

    public Response[] fetch(int i2, int i3, String str) throws ProtocolException {
        return fetch(String.valueOf(String.valueOf(i2)) + ":" + String.valueOf(i3), str, false);
    }

    public Response[] fetch(int i2, String str) throws ProtocolException {
        return fetch(String.valueOf(i2), str, false);
    }

    public Response[] fetch(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return fetch(MessageSet.toString(messageSetArr), str, false);
    }

    public BODY fetchBody(int i2, String str) throws ProtocolException {
        return fetchBody(i2, str, false);
    }

    public BODY fetchBody(int i2, String str, int i3, int i4) throws ProtocolException {
        return fetchBody(i2, str, i3, i4, false, (ByteArray) null);
    }

    public BODY fetchBody(int i2, String str, int i3, int i4, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i2, str, i3, i4, false, byteArray);
    }

    /* access modifiers changed from: protected */
    public BODY fetchBody(int i2, String str, int i3, int i4, boolean z2, ByteArray byteArray) throws ProtocolException {
        this.f21760ba = byteArray;
        StringBuilder sb = new StringBuilder(z2 ? "BODY.PEEK[" : "BODY[");
        String str2 = "]<";
        if (str != null) {
            str2 = String.valueOf(str) + str2;
        }
        sb.append(str2);
        sb.append(String.valueOf(i3));
        sb.append(".");
        sb.append(String.valueOf(i4));
        sb.append(">");
        Response[] fetch = fetch(i2, sb.toString());
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (BODY) FetchResponse.getItem(fetch, i2, BODY.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.BODY fetchBody(int r3, java.lang.String r4, boolean r5) throws com.sun.mail.iap.ProtocolException {
        /*
            r2 = this;
            java.lang.String r0 = "]"
            if (r5 == 0) goto L_0x0018
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "BODY.PEEK["
            r5.<init>(r1)
            if (r4 != 0) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.<init>(r4)
            goto L_0x002b
        L_0x0018:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "BODY["
            r5.<init>(r1)
            if (r4 != 0) goto L_0x0022
            goto L_0x0032
        L_0x0022:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.<init>(r4)
        L_0x002b:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0032:
            r5.append(r0)
            java.lang.String r4 = r5.toString()
            com.sun.mail.iap.Response[] r4 = r2.fetch((int) r3, (java.lang.String) r4)
            r2.notifyResponseHandlers(r4)
            int r5 = r4.length
            int r5 = r5 + -1
            r5 = r4[r5]
            boolean r0 = r5.isOK()
            if (r0 == 0) goto L_0x0054
            java.lang.Class<com.sun.mail.imap.protocol.BODY> r5 = com.sun.mail.imap.protocol.BODY.class
            com.sun.mail.imap.protocol.Item r3 = com.sun.mail.imap.protocol.FetchResponse.getItem(r4, r3, r5)
            com.sun.mail.imap.protocol.BODY r3 = (com.sun.mail.imap.protocol.BODY) r3
            return r3
        L_0x0054:
            boolean r3 = r5.isNO()
            r4 = 0
            if (r3 == 0) goto L_0x005c
            return r4
        L_0x005c:
            r2.handleResult(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.fetchBody(int, java.lang.String, boolean):com.sun.mail.imap.protocol.BODY");
    }

    public BODYSTRUCTURE fetchBodyStructure(int i2) throws ProtocolException {
        Response[] fetch = fetch(i2, "BODYSTRUCTURE");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (BODYSTRUCTURE) FetchResponse.getItem(fetch, i2, BODYSTRUCTURE.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public Flags fetchFlags(int i2) throws ProtocolException {
        Response[] fetch = fetch(i2, "FLAGS");
        int length = fetch.length;
        int i3 = 0;
        Flags flags = null;
        while (true) {
            if (i3 < length) {
                if (fetch[i3] != null && (fetch[i3] instanceof FetchResponse) && ((FetchResponse) fetch[i3]).getNumber() == i2 && (flags = (Flags) ((FetchResponse) fetch[i3]).getItem(Flags.class)) != null) {
                    fetch[i3] = null;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        return flags;
    }

    public RFC822DATA fetchRFC822(int i2, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        Response[] fetch = fetch(i2, str2);
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (RFC822DATA) FetchResponse.getItem(fetch, i2, RFC822DATA.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public UID fetchSequenceNumber(long j2) throws ProtocolException {
        Response[] fetch = fetch(String.valueOf(j2), "UID", true);
        int length = fetch.length;
        UID uid = null;
        for (int i2 = 0; i2 < length; i2++) {
            if (!(fetch[i2] == null || !(fetch[i2] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i2]).getItem(UID.class)) == null)) {
                if (uid.uid == j2) {
                    break;
                }
                uid = null;
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        return uid;
    }

    public UID[] fetchSequenceNumbers(long j2, long j3) throws ProtocolException {
        UID uid;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j2)));
        sb.append(":");
        sb.append(j3 == -1 ? "*" : String.valueOf(j3));
        Response[] fetch = fetch(sb.toString(), "UID", true);
        Vector vector = new Vector();
        int length = fetch.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!(fetch[i2] == null || !(fetch[i2] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i2]).getItem(UID.class)) == null)) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    public UID[] fetchSequenceNumbers(long[] jArr) throws ProtocolException {
        UID uid;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i2]));
        }
        Response[] fetch = fetch(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        int length = fetch.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (!(fetch[i3] == null || !(fetch[i3] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i3]).getItem(UID.class)) == null)) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    public UID fetchUID(int i2) throws ProtocolException {
        Response[] fetch = fetch(i2, "UID");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (UID) FetchResponse.getItem(fetch, i2, UID.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public ACL[] getACL(String str) throws ProtocolException {
        String readAtomString;
        if (hasCapability("ACL")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            Response[] command = command("GETACL", argument);
            Response response = command[command.length - 1];
            Vector vector = new Vector();
            if (response.isOK()) {
                int length = command.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("ACL")) {
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString2 = iMAPResponse.readAtomString();
                                if (!(readAtomString2 == null || (readAtomString = iMAPResponse.readAtomString()) == null)) {
                                    vector.addElement(new ACL(readAtomString2, new Rights(readAtomString)));
                                }
                            }
                            command[i2] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            ACL[] aclArr = new ACL[vector.size()];
            vector.copyInto(aclArr);
            return aclArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    public Map getCapabilities() {
        return this.capabilities;
    }

    /* access modifiers changed from: package-private */
    public OutputStream getIMAPOutputStream() {
        return getOutputStream();
    }

    public Quota[] getQuota(String str) throws ProtocolException {
        if (hasCapability("QUOTA")) {
            Argument argument = new Argument();
            argument.writeString(str);
            Response[] command = command("GETQUOTA", argument);
            Vector vector = new Vector();
            Response response = command[command.length - 1];
            if (response.isOK()) {
                int length = command.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("QUOTA")) {
                            vector.addElement(parseQuota(iMAPResponse));
                            command[i2] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            Quota[] quotaArr = new Quota[vector.size()];
            vector.copyInto(quotaArr);
            return quotaArr;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public Quota[] getQuotaRoot(String str) throws ProtocolException {
        if (hasCapability("QUOTA")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            Response[] command = command("GETQUOTAROOT", argument);
            Response response = command[command.length - 1];
            Hashtable hashtable = new Hashtable();
            int i2 = 0;
            if (response.isOK()) {
                int length = command.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (command[i3] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i3];
                        if (iMAPResponse.keyEquals("QUOTAROOT")) {
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString = iMAPResponse.readAtomString();
                                if (readAtomString == null) {
                                    break;
                                }
                                hashtable.put(readAtomString, new Quota(readAtomString));
                            }
                            command[i3] = null;
                        } else if (iMAPResponse.keyEquals("QUOTA")) {
                            Quota parseQuota = parseQuota(iMAPResponse);
                            Quota quota = (Quota) hashtable.get(parseQuota.quotaRoot);
                            if (quota != null) {
                                Quota.Resource[] resourceArr = quota.resources;
                            }
                            hashtable.put(parseQuota.quotaRoot, parseQuota);
                            command[i3] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            Quota[] quotaArr = new Quota[hashtable.size()];
            Enumeration elements = hashtable.elements();
            while (elements.hasMoreElements()) {
                quotaArr[i2] = (Quota) elements.nextElement();
                i2++;
            }
            return quotaArr;
        }
        throw new BadCommandException("GETQUOTAROOT not supported");
    }

    /* access modifiers changed from: protected */
    public ByteArray getResponseBuffer() {
        ByteArray byteArray = this.f21760ba;
        this.f21760ba = null;
        return byteArray;
    }

    public boolean hasCapability(String str) {
        return this.capabilities.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public void idleAbort() throws ProtocolException {
        OutputStream outputStream = getOutputStream();
        try {
            outputStream.write(DONE);
            outputStream.flush();
        } catch (IOException unused) {
        }
    }

    public synchronized void idleStart() throws ProtocolException {
        Response response;
        if (hasCapability("IDLE")) {
            try {
                this.idleTag = writeCommand("IDLE", (Argument) null);
                response = readResponse();
            } catch (LiteralException e2) {
                response = e2.getResponse();
            } catch (Exception e3) {
                response = Response.byeResponse(e3);
            }
            if (!response.isContinuation()) {
                handleResult(response);
            }
        } else {
            throw new BadCommandException("IDLE not supported");
        }
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public boolean isREV1() {
        return this.rev1;
    }

    public ListInfo[] list(String str, String str2) throws ProtocolException {
        return doList("LIST", str, str2);
    }

    public Rights[] listRights(String str, String str2) throws ProtocolException {
        if (hasCapability("ACL")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            argument.writeString(str2);
            Response[] command = command("LISTRIGHTS", argument);
            Response response = command[command.length - 1];
            Vector vector = new Vector();
            if (response.isOK()) {
                int length = command.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("LISTRIGHTS")) {
                            iMAPResponse.readAtomString();
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString = iMAPResponse.readAtomString();
                                if (readAtomString == null) {
                                    break;
                                }
                                vector.addElement(new Rights(readAtomString));
                            }
                            command[i2] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            Rights[] rightsArr = new Rights[vector.size()];
            vector.copyInto(rightsArr);
            return rightsArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    public void login(String str, String str2) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        argument.writeString(str2);
        Response[] command = command("LOGIN", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        setCapabilities(command[command.length - 1]);
        this.authenticated = true;
    }

    public void logout() throws ProtocolException {
        Response[] command = command("LOGOUT", (Argument) null);
        this.authenticated = false;
        notifyResponseHandlers(command);
        disconnect();
    }

    public ListInfo[] lsub(String str, String str2) throws ProtocolException {
        return doList("LSUB", str, str2);
    }

    public Rights myRights(String str) throws ProtocolException {
        if (hasCapability("ACL")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            Response[] command = command("MYRIGHTS", argument);
            Response response = command[command.length - 1];
            Rights rights = null;
            if (response.isOK()) {
                int length = command.length;
                Rights rights2 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("MYRIGHTS")) {
                            iMAPResponse.readAtomString();
                            String readAtomString = iMAPResponse.readAtomString();
                            if (rights2 == null) {
                                rights2 = new Rights(readAtomString);
                            }
                            command[i2] = null;
                        }
                    }
                }
                rights = rights2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return rights;
        }
        throw new BadCommandException("ACL not supported");
    }

    public Namespaces namespace() throws ProtocolException {
        if (hasCapability("NAMESPACE")) {
            Namespaces namespaces = null;
            Response[] command = command("NAMESPACE", (Argument) null);
            Response response = command[command.length - 1];
            if (response.isOK()) {
                int length = command.length;
                Namespaces namespaces2 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("NAMESPACE")) {
                            if (namespaces2 == null) {
                                namespaces2 = new Namespaces(iMAPResponse);
                            }
                            command[i2] = null;
                        }
                    }
                }
                namespaces = namespaces2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return namespaces;
        }
        throw new BadCommandException("NAMESPACE not supported");
    }

    public void noop() throws ProtocolException {
        if (this.debug) {
            this.out.println("IMAP DEBUG: IMAPProtocol noop");
        }
        simpleCommand("NOOP", (Argument) null);
    }

    /* access modifiers changed from: protected */
    public void parseCapabilities(Response response) {
        while (true) {
            String readAtom = response.readAtom(']');
            if (readAtom != null) {
                if (readAtom.length() != 0) {
                    this.capabilities.put(readAtom.toUpperCase(Locale.ENGLISH), readAtom);
                    if (readAtom.regionMatches(true, 0, "AUTH=", 0, 5)) {
                        this.authmechs.add(readAtom.substring(5));
                        if (this.debug) {
                            PrintStream printStream = this.out;
                            printStream.println("IMAP DEBUG: AUTH: " + readAtom.substring(5));
                        }
                    }
                } else if (response.peekByte() != 93) {
                    response.skipToken();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public BODY peekBody(int i2, String str) throws ProtocolException {
        return fetchBody(i2, str, true);
    }

    public BODY peekBody(int i2, String str, int i3, int i4) throws ProtocolException {
        return fetchBody(i2, str, i3, i4, true, (ByteArray) null);
    }

    public BODY peekBody(int i2, String str, int i3, int i4, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i2, str, i3, i4, true, byteArray);
    }

    /* access modifiers changed from: protected */
    public void processGreeting(Response response) throws ProtocolException {
        super.processGreeting(response);
        if (response.isOK()) {
            setCapabilities(response);
        } else if (((IMAPResponse) response).keyEquals("PREAUTH")) {
            this.authenticated = true;
            setCapabilities(response);
        } else {
            throw new ConnectionException(this, response);
        }
    }

    public boolean processIdleResponse(Response response) throws ProtocolException {
        notifyResponseHandlers(new Response[]{response});
        boolean isBYE = response.isBYE();
        if (response.isTagged() && response.getTag().equals(this.idleTag)) {
            isBYE = true;
        }
        if (isBYE) {
            this.idleTag = null;
        }
        handleResult(response);
        return !isBYE;
    }

    public void proxyauth(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        simpleCommand("PROXYAUTH", argument);
    }

    public synchronized Response readIdleResponse() {
        Response response;
        if (this.idleTag == null) {
            return null;
        }
        try {
            response = readResponse();
        } catch (ProtocolException | IOException e2) {
            response = Response.byeResponse(e2);
        }
        return response;
    }

    public Response readResponse() throws IOException, ProtocolException {
        return IMAPResponse.readResponse(this);
    }

    public void rename(String str, String str2) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        String encode2 = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(encode2);
        simpleCommand("RENAME", argument);
    }

    public void sasllogin(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List list;
        if (this.saslAuthenticator == null) {
            try {
                Constructor<?> constructor = Class.forName("com.sun.mail.imap.protocol.IMAPSaslAuthenticator").getConstructor(new Class[]{IMAPProtocol.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class});
                Object[] objArr = new Object[6];
                objArr[0] = this;
                objArr[1] = this.name;
                objArr[2] = this.props;
                objArr[3] = this.debug ? Boolean.TRUE : Boolean.FALSE;
                objArr[4] = this.out;
                objArr[5] = this.host;
                this.saslAuthenticator = (SaslAuthenticator) constructor.newInstance(objArr);
            } catch (Exception e2) {
                if (this.debug) {
                    PrintStream printStream = this.out;
                    printStream.println("IMAP DEBUG: Can't load SASL authenticator: " + e2);
                    return;
                }
                return;
            }
        }
        if (strArr == null || strArr.length <= 0) {
            list = this.authmechs;
        } else {
            list = new ArrayList(strArr.length);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (this.authmechs.contains(strArr[i2])) {
                    list.add(strArr[i2]);
                }
            }
        }
        if (this.saslAuthenticator.authenticate((String[]) list.toArray(new String[list.size()]), str, str2, str3, str4)) {
            this.authenticated = true;
        }
    }

    public int[] search(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return search("ALL", searchTerm);
    }

    public int[] search(MessageSet[] messageSetArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return search(MessageSet.toString(messageSetArr), searchTerm);
    }

    public MailboxInfo select(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("SELECT", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        notifyResponseHandlers(command);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            if (response.toString().indexOf("READ-ONLY") != -1) {
                mailboxInfo.mode = 1;
            } else {
                mailboxInfo.mode = 2;
            }
        }
        handleResult(response);
        return mailboxInfo;
    }

    public void setACL(String str, char c2, ACL acl) throws ProtocolException {
        if (hasCapability("ACL")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            argument.writeString(acl.getName());
            String rights = acl.getRights().toString();
            if (c2 == '+' || c2 == '-') {
                rights = String.valueOf(c2) + rights;
            }
            argument.writeString(rights);
            Response[] command = command("SETACL", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    protected void setCapabilities(com.sun.mail.iap.Response r3) {
        /*
            r2 = this;
        L_0x0000:
            byte r0 = r3.readByte()
            if (r0 <= 0) goto L_0x000a
            r1 = 91
            if (r0 != r1) goto L_0x0000
        L_0x000a:
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r0 = r3.readAtom()
            java.lang.String r1 = "CAPABILITY"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 10
            r0.<init>(r1)
            r2.capabilities = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 5
            r0.<init>(r1)
            r2.authmechs = r0
            r2.parseCapabilities(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.setCapabilities(com.sun.mail.iap.Response):void");
    }

    public void setQuota(Quota quota) throws ProtocolException {
        if (hasCapability("QUOTA")) {
            Argument argument = new Argument();
            argument.writeString(quota.quotaRoot);
            Argument argument2 = new Argument();
            if (quota.resources != null) {
                for (int i2 = 0; i2 < quota.resources.length; i2++) {
                    argument2.writeAtom(quota.resources[i2].name);
                    argument2.writeNumber(quota.resources[i2].limit);
                }
            }
            argument.writeArgument(argument2);
            Response[] command = command("SETQUOTA", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public void startTLS() throws ProtocolException {
        try {
            super.startTLS("STARTTLS");
        } catch (ProtocolException e2) {
            throw e2;
        } catch (Exception e3) {
            notifyResponseHandlers(new Response[]{Response.byeResponse(e3)});
            disconnect();
        }
    }

    public Status status(String str, String[] strArr) throws ProtocolException {
        if (isREV1() || hasCapability("IMAP4SUNVERSION")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            Argument argument2 = new Argument();
            if (strArr == null) {
                strArr = Status.standardItems;
            }
            for (String writeAtom : strArr) {
                argument2.writeAtom(writeAtom);
            }
            argument.writeArgument(argument2);
            Response[] command = command("STATUS", argument);
            Response response = command[command.length - 1];
            Status status = null;
            if (response.isOK()) {
                int length = command.length;
                Status status2 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    if (command[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                        if (iMAPResponse.keyEquals("STATUS")) {
                            if (status2 == null) {
                                status2 = new Status(iMAPResponse);
                            } else {
                                Status.add(status2, new Status(iMAPResponse));
                            }
                            command[i2] = null;
                        }
                    }
                }
                status = status2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return status;
        }
        throw new BadCommandException("STATUS not supported");
    }

    public void storeFlags(int i2, int i3, Flags flags, boolean z2) throws ProtocolException {
        storeFlags(String.valueOf(String.valueOf(i2)) + ":" + String.valueOf(i3), flags, z2);
    }

    public void storeFlags(int i2, Flags flags, boolean z2) throws ProtocolException {
        storeFlags(String.valueOf(i2), flags, z2);
    }

    public void storeFlags(MessageSet[] messageSetArr, Flags flags, boolean z2) throws ProtocolException {
        storeFlags(MessageSet.toString(messageSetArr), flags, z2);
    }

    public void subscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("SUBSCRIBE", argument);
    }

    /* access modifiers changed from: protected */
    public boolean supportsNonSyncLiterals() {
        return hasCapability("LITERAL+");
    }

    public void uidexpunge(UIDSet[] uIDSetArr) throws ProtocolException {
        if (hasCapability("UIDPLUS")) {
            simpleCommand("UID EXPUNGE " + UIDSet.toString(uIDSetArr), (Argument) null);
            return;
        }
        throw new BadCommandException("UID EXPUNGE not supported");
    }

    public void unsubscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("UNSUBSCRIBE", argument);
    }
}
