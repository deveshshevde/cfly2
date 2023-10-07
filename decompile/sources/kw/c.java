package kw;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c {
    public static String a(long j2) {
        if (j2 <= 0) {
            return "0";
        }
        double d2 = (double) j2;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
        double pow = Math.pow(1024.0d, (double) log10);
        Double.isNaN(d2);
        sb.append(decimalFormat.format(d2 / pow));
        sb.append(" ");
        sb.append(new String[]{"B", "KiB", "MiB", "GiB", "TiB"}[log10]);
        return sb.toString();
    }

    public static String a(String str, long j2) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[1][23456789]\\d{9}");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$")) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }
}
