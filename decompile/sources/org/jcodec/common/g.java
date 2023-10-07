package org.jcodec.common;

import oc.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final k[] f33155a = {new a(), new ob.a(), new org.jcodec.codecs.h264.a()};

    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i2 = 0; i2 < charArray.length; i2++) {
            bArr[i2] = (byte) charArray[i2];
        }
        return bArr;
    }
}
