package com.flypro.core.util;

import com.amap.api.mapcore.util.fx;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class d {
    public static String a(long j2) {
        return a(j2, false);
    }

    public static String a(long j2, boolean z2) {
        StringBuilder sb;
        String str;
        boolean z3 = j2 < 0;
        long abs = Math.abs(j2) / 1000;
        int i2 = (int) (abs % 60);
        long j3 = abs / 60;
        int i3 = (int) (j3 % 60);
        long j4 = j3 / 60;
        int i4 = (int) j4;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("00");
        String str2 = "-";
        if (z2) {
            if (j4 > 0) {
                if (!z3) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(i4);
                sb.append(fx.f8866g);
                sb.append(decimalFormat.format((long) i3));
            } else if (i3 > 0) {
                if (!z3) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                if (!z3) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append(i2);
                str = "s";
            }
            sb.append("min");
            return sb.toString();
        }
        if (j4 > 0) {
            if (!z3) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(i4);
            sb.append(":");
            sb.append(decimalFormat.format((long) i3));
        } else {
            sb = new StringBuilder();
            if (!z3) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(i3);
        }
        sb.append(":");
        str = decimalFormat.format((long) i2);
        sb.append(str);
        return sb.toString();
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf > -1 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String a(String str, long j2) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String b(String str) {
        try {
            String[] split = new URL(str).getFile().split("/");
            return split[split.length - 1];
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
