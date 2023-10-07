package com.sun.mail.imap.protocol;

import java.util.Vector;

public class MessageSet {
    public int end;
    public int start;

    public MessageSet() {
    }

    public MessageSet(int i2, int i3) {
        this.start = i2;
        this.end = i3;
    }

    public static MessageSet[] createMessageSets(int[] iArr) {
        Vector vector = new Vector();
        int i2 = 0;
        while (i2 < iArr.length) {
            MessageSet messageSet = new MessageSet();
            messageSet.start = iArr[i2];
            do {
                i2++;
                if (i2 >= iArr.length || iArr[i2] != iArr[i2 - 1] + 1) {
                    int i3 = i2 - 1;
                    messageSet.end = iArr[i3];
                    vector.addElement(messageSet);
                    i2 = i3 + 1;
                }
                i2++;
                break;
            } while (iArr[i2] != iArr[i2 - 1] + 1);
            int i32 = i2 - 1;
            messageSet.end = iArr[i32];
            vector.addElement(messageSet);
            i2 = i32 + 1;
        }
        MessageSet[] messageSetArr = new MessageSet[vector.size()];
        vector.copyInto(messageSetArr);
        return messageSetArr;
    }

    public static int size(MessageSet[] messageSetArr) {
        if (messageSetArr == null) {
            return 0;
        }
        int i2 = 0;
        for (MessageSet size : messageSetArr) {
            i2 += size.size();
        }
        return i2;
    }

    public static String toString(MessageSet[] messageSetArr) {
        if (messageSetArr == null || messageSetArr.length == 0) {
            return null;
        }
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = messageSetArr.length;
        while (true) {
            int i3 = messageSetArr[i2].start;
            int i4 = messageSetArr[i2].end;
            stringBuffer.append(i3);
            if (i4 > i3) {
                stringBuffer.append(':');
                stringBuffer.append(i4);
            }
            i2++;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public int size() {
        return (this.end - this.start) + 1;
    }
}
