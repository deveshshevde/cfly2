package org.litepal.util.cipher;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CipherUtil {
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String aesKey = "LitePalKey";

    public static String aesDecrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AESCrypt.decrypt(aesKey, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String aesEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AESCrypt.encrypt(aesKey, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String md5Encrypt(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(Charset.defaultCharset()));
            return new String(toHex(instance.digest()));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static char[] toHex(byte[] bArr) {
        char[] cArr = DIGITS_UPPER;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & 15];
        }
        return cArr2;
    }
}
