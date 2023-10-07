package com.sun.mail.imap.protocol;

import java.util.Vector;

public class UIDSet {
    public long end;
    public long start;

    public UIDSet() {
    }

    public UIDSet(long j2, long j3) {
        this.start = j2;
        this.end = j3;
    }

    public static UIDSet[] createUIDSets(long[] jArr) {
        Vector vector = new Vector();
        int i2 = 0;
        while (i2 < jArr.length) {
            UIDSet uIDSet = new UIDSet();
            uIDSet.start = jArr[i2];
            do {
                i2++;
                if (i2 >= jArr.length || jArr[i2] != jArr[i2 - 1] + 1) {
                    int i3 = i2 - 1;
                    uIDSet.end = jArr[i3];
                    vector.addElement(uIDSet);
                    i2 = i3 + 1;
                }
                i2++;
                break;
            } while (jArr[i2] != jArr[i2 - 1] + 1);
            int i32 = i2 - 1;
            uIDSet.end = jArr[i32];
            vector.addElement(uIDSet);
            i2 = i32 + 1;
        }
        UIDSet[] uIDSetArr = new UIDSet[vector.size()];
        vector.copyInto(uIDSetArr);
        return uIDSetArr;
    }

    public static long size(UIDSet[] uIDSetArr) {
        long j2 = 0;
        if (uIDSetArr == null) {
            return 0;
        }
        for (UIDSet size : uIDSetArr) {
            j2 += size.size();
        }
        return j2;
    }

    public static String toString(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null || uIDSetArr.length == 0) {
            return null;
        }
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = uIDSetArr.length;
        while (true) {
            long j2 = uIDSetArr[i2].start;
            long j3 = uIDSetArr[i2].end;
            int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
            stringBuffer.append(j2);
            if (i3 > 0) {
                stringBuffer.append(':');
                stringBuffer.append(j3);
            }
            i2++;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public long size() {
        return (this.end - this.start) + 1;
    }
}
