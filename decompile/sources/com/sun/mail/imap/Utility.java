package com.sun.mail.imap;

import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.UIDSet;
import java.util.Vector;
import javax.mail.Message;

public final class Utility {

    public interface Condition {
        boolean test(IMAPMessage iMAPMessage);
    }

    private Utility() {
    }

    public static MessageSet[] toMessageSet(Message[] messageArr, Condition condition) {
        Vector vector = new Vector(1);
        int i2 = 0;
        while (i2 < messageArr.length) {
            IMAPMessage iMAPMessage = messageArr[i2];
            if (!iMAPMessage.isExpunged()) {
                int sequenceNumber = iMAPMessage.getSequenceNumber();
                if (condition == null || condition.test(iMAPMessage)) {
                    MessageSet messageSet = new MessageSet();
                    messageSet.start = sequenceNumber;
                    while (true) {
                        i2++;
                        if (i2 >= messageArr.length) {
                            break;
                        }
                        IMAPMessage iMAPMessage2 = messageArr[i2];
                        if (!iMAPMessage2.isExpunged()) {
                            int sequenceNumber2 = iMAPMessage2.getSequenceNumber();
                            if (condition == null || condition.test(iMAPMessage2)) {
                                if (sequenceNumber2 != sequenceNumber + 1) {
                                    i2--;
                                    break;
                                }
                                sequenceNumber = sequenceNumber2;
                            }
                        }
                    }
                    messageSet.end = sequenceNumber;
                    vector.addElement(messageSet);
                }
            }
            i2++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        MessageSet[] messageSetArr = new MessageSet[vector.size()];
        vector.copyInto(messageSetArr);
        return messageSetArr;
    }

    public static UIDSet[] toUIDSet(Message[] messageArr) {
        Vector vector = new Vector(1);
        int i2 = 0;
        while (i2 < messageArr.length) {
            IMAPMessage iMAPMessage = messageArr[i2];
            if (!iMAPMessage.isExpunged()) {
                long uid = iMAPMessage.getUID();
                UIDSet uIDSet = new UIDSet();
                uIDSet.start = uid;
                while (true) {
                    i2++;
                    if (i2 < messageArr.length) {
                        IMAPMessage iMAPMessage2 = messageArr[i2];
                        if (!iMAPMessage2.isExpunged()) {
                            long uid2 = iMAPMessage2.getUID();
                            if (uid2 != 1 + uid) {
                                i2--;
                                break;
                            }
                            uid = uid2;
                        }
                    } else {
                        break;
                    }
                }
                uIDSet.end = uid;
                vector.addElement(uIDSet);
            }
            i2++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        UIDSet[] uIDSetArr = new UIDSet[vector.size()];
        vector.copyInto(uIDSetArr);
        return uIDSetArr;
    }
}
