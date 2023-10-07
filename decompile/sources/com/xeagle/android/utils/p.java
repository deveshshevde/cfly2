package com.xeagle.android.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class p {
    public static String a(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public static String a(byte[] bArr) {
        try {
            return k.a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }
}
