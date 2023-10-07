package com.amap.api.mapcore.util;

import java.util.Locale;
import java.util.Random;

public final class dd {

    /* renamed from: a  reason: collision with root package name */
    private static String f8242a = "0123456789";

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8243a;

        /* renamed from: b  reason: collision with root package name */
        private int f8244b;

        /* renamed from: c  reason: collision with root package name */
        private int f8245c;

        public a() {
            this((byte) 0);
        }

        private a(byte b2) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        public a(String str, int i2) {
            this.f8244b = 1103515245;
            this.f8245c = 12345;
            this.f8243a = a(str, i2, str.length());
        }

        private char a(int i2) {
            this.f8243a.length();
            return this.f8243a.charAt(i2);
        }

        private int a(char c2) {
            this.f8243a.length();
            return this.f8243a.indexOf(c2);
        }

        private String a(String str, int i2, int i3) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i4 = 0; i4 < i3; i4++) {
                int b2 = b(i2);
                int i5 = b2 % length;
                i2 = b(b2);
                int i6 = i2 % length;
                char charAt = stringBuffer.charAt(i5);
                stringBuffer.setCharAt(i5, stringBuffer.charAt(i6));
                stringBuffer.setCharAt(i6, charAt);
            }
            return stringBuffer.toString();
        }

        private int b(int i2) {
            return (int) (((((long) i2) * ((long) this.f8244b)) + ((long) this.f8245c)) & 2147483647L);
        }

        private String b(int i2, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f8243a.length();
            int length2 = str.length();
            for (int i3 = 0; i3 < length2; i3++) {
                int a2 = a(str.charAt(i3));
                if (a2 < 0) {
                    break;
                }
                sb.append(a(((a2 + i2) + i3) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final String a(int i2, String str) {
            return b(i2, str);
        }
    }

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        String format = String.format(Locale.US, "%05d", new Object[]{Integer.valueOf(nextInt)});
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        String a2 = new a(f8242a, nextInt3).a(nextInt2, format);
        return a2 + String.format(Locale.US, "%01d", new Object[]{Integer.valueOf(nextInt2)}) + String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(nextInt3)});
    }
}
