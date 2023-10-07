package com.xeagle.android.utils;

import android.content.Context;
import com.amap.api.mapcore.util.fx;
import com.blankj.utilcode.constant.CacheConstants;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.TimeUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f24544a = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f24545b = new SimpleDateFormat(TimeUtil.DEF_FORMAT);

    public static long a(String str) {
        return a(str, (DateFormat) f24545b);
    }

    public static long a(String str, DateFormat dateFormat) {
        try {
            return dateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String a(int i2) {
        int i3;
        StringBuilder sb;
        if (i2 <= 0) {
            return "00:00";
        }
        int i4 = i2 / 60;
        if (i4 < 60) {
            i3 = i2 % 60;
            sb = new StringBuilder();
        } else {
            int i5 = i4 / 60;
            if (i5 > 99) {
                return "99:59:59";
            }
            i4 %= 60;
            i3 = (i2 - (i5 * CacheConstants.HOUR)) - (i4 * 60);
            sb = new StringBuilder();
            sb.append(b(i5));
            sb.append(":");
        }
        sb.append(b(i4));
        sb.append(":");
        sb.append(b(i3));
        return sb.toString();
    }

    public static String a(long j2) {
        return a(j2, TimeUtil.DEF_FORMAT);
    }

    public static String a(long j2, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j2));
    }

    public static String a(Context context, int i2) {
        if (i2 <= 0) {
            return "00:00";
        }
        int i3 = i2 / 60;
        if (i3 < 60) {
            return b(i3) + ":" + b(i2 % 60);
        }
        int i4 = i3 / 60;
        int i5 = i4 > 99 ? i4 / 24 : 0;
        int i6 = i4 % 24;
        int i7 = i3 % 60;
        return String.format(Locale.US, "%03d%s\t%02d:%02d:%02d", new Object[]{Integer.valueOf(i5), context.getString(R.string.tv_day), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(((i2 - (i6 * CacheConstants.HOUR)) - (i7 * 60)) - ((i5 * 24) * CacheConstants.HOUR))});
    }

    public static String b(int i2) {
        StringBuilder sb;
        if (i2 < 0 || i2 >= 10) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(Integer.toString(i2));
        }
        return sb.toString();
    }

    public static String b(long j2) {
        return a(j2, "yyyyMMddHHmmss");
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 / 1000;
        if (i3 < 1) {
            i3 = 1;
        }
        int i4 = i3 / CacheConstants.HOUR;
        if (i4 != 0) {
            sb.append(i4);
            sb.append(fx.f8866g);
        }
        int i5 = i3 - (i4 * CacheConstants.HOUR);
        int i6 = i5 / 60;
        if (i6 != 0) {
            sb.append(i6);
            sb.append("m");
        }
        int i7 = i5 - (i6 * 60);
        if (i7 != 0) {
            sb.append(i7);
            sb.append("s");
        }
        return sb.toString();
    }

    public static String c(long j2) {
        StringBuilder sb;
        long j3 = j2 / 1000;
        int i2 = (int) (j3 % 60);
        int i3 = (int) ((j3 / 60) % 60);
        int i4 = (int) (j3 / 3600);
        String str = "";
        if (i4 > 0) {
            str = str + i4 + ":";
        }
        if (i3 <= 9) {
            sb.append(str);
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append(str);
        }
        sb.append(i3);
        sb.append(":");
        String sb2 = sb.toString();
        if (i2 <= 9) {
            return sb2 + "0" + i2;
        }
        return sb2 + i2;
    }
}
