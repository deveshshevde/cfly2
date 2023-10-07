package com.xeagle.android.login.common;

import android.content.Context;
import com.blankj.utilcode.constant.CacheConstants;
import com.cfly.uav_pro.R;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {
    public static final String DEF_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEF_HH_MM_SS = "HH:mm:ss";
    public static final String DEF_MM_SS = "mm:ss";
    public static final int MIN_IN_MS = 60000;

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static int currentTimeSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String getBeijingNowTime(String str) {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        Date date = new Date(currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public static String getBeijingNowTimeString(String str) {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        Date date = new Date(currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(timeZone);
        String str2 = gregorianCalendar.get(9) == 0 ? "上午" : "下午";
        return str2 + simpleDateFormat.format(date);
    }

    public static Date getDateFromFormatString(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDateString(long j2) {
        return getDateTimeString(j2, "yyyyMMdd");
    }

    public static String getDateTimeString(long j2, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j2));
    }

    public static String getElapseTimeForShow(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 / 1000;
        if (i3 < 1) {
            i3 = 1;
        }
        int i4 = i3 / CacheConstants.HOUR;
        if (i4 != 0) {
            sb.append(i4);
            sb.append(context.getString(R.string.unit_hour));
        }
        int i5 = i3 - (i4 * CacheConstants.HOUR);
        int i6 = i5 / 60;
        if (i6 != 0) {
            sb.append(i6);
            sb.append(context.getString(R.string.unit_minute));
        }
        int i7 = i5 - (i6 * 60);
        if (i7 != 0) {
            sb.append(i7);
            sb.append(context.getString(R.string.unit_second));
        }
        return sb.toString();
    }

    public static String getFavoriteCollectTime(long j2) {
        Date date = new Date();
        Date date2 = new Date(j2);
        return (!date2.before(new Date(date.getYear(), 0, 0)) ? new SimpleDateFormat("MM-dd", Locale.getDefault()) : new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())).format(date2);
    }

    public static String getFormatDatetime(int i2, int i3, int i4) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new GregorianCalendar(i2, i3, i4).getTime());
    }

    public static Date getLongFormatString(String str) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getNow() {
        return (int) (new Date().getTime() / 1000);
    }

    public static String getNowDateTime(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    public static String getNowDatetime() {
        return new SimpleDateFormat(DEF_FORMAT, Locale.getDefault()).format(new Date());
    }

    public static long getNow_millisecond() {
        return new Date().getTime();
    }

    public static long getSecondsByMilliseconds(long j2) {
        return (long) new BigDecimal((double) (((float) j2) / 1000.0f)).setScale(0, 4).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getTimeShowString(android.content.Context r8, long r9, boolean r11) {
        /*
            java.util.Date r0 = new java.util.Date
            r0.<init>(r9)
            java.util.Date r9 = new java.util.Date
            r9.<init>()
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            r1 = 11
            r2 = 0
            r10.set(r1, r2)
            r1 = 12
            r10.set(r1, r2)
            r1 = 13
            r10.set(r1, r2)
            r1 = 14
            r10.set(r1, r2)
            java.util.Date r10 = r10.getTime()
            java.util.Date r1 = new java.util.Date
            long r2 = r10.getTime()
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r2 - r4
            r1.<init>(r2)
            java.util.Date r2 = new java.util.Date
            long r6 = r1.getTime()
            long r6 = r6 - r4
            r2.<init>(r6)
            boolean r3 = r0.before(r10)
            if (r3 != 0) goto L_0x004c
            r9 = 2131822946(0x7f110962, float:1.9278678E38)
        L_0x0047:
            java.lang.String r9 = r8.getString(r9)
            goto L_0x007a
        L_0x004c:
            boolean r1 = r0.before(r1)
            if (r1 != 0) goto L_0x0056
            r9 = 2131822949(0x7f110965, float:1.9278684E38)
            goto L_0x0047
        L_0x0056:
            boolean r1 = r0.before(r2)
            if (r1 != 0) goto L_0x0060
            r9 = 2131822929(0x7f110951, float:1.9278643E38)
            goto L_0x0047
        L_0x0060:
            boolean r9 = isSameWeekDates(r0, r9)
            if (r9 == 0) goto L_0x006b
            java.lang.String r9 = getWeekOfDate(r8, r0)
            goto L_0x007a
        L_0x006b:
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "yyyy-MM-dd"
            r9.<init>(r2, r1)
            java.lang.String r9 = r9.format(r0)
        L_0x007a:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "HH:mm"
            r1.<init>(r3, r2)
            java.lang.String r1 = r1.format(r0)
            if (r11 == 0) goto L_0x0097
            boolean r10 = r0.before(r10)
            if (r10 != 0) goto L_0x0096
            java.lang.String r8 = getTodayTimeBucket(r8, r0)
            return r8
        L_0x0096:
            return r9
        L_0x0097:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            java.lang.String r9 = " "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.TimeUtil.getTimeShowString(android.content.Context, long, boolean):java.lang.String");
    }

    public static String getTimeString(long j2) {
        return getDateTimeString(j2, "HHmmss");
    }

    public static String getTodayTimeBucket(Context context, Date date) {
        StringBuilder sb;
        int i2;
        StringBuilder sb2;
        String format;
        int i3;
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("KK:mm", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm", Locale.getDefault());
        int i4 = instance.get(11);
        if (i4 >= 0 && i4 < 5) {
            sb2 = new StringBuilder();
            i3 = R.string.time_early_morning;
        } else if (i4 < 5 || i4 >= 12) {
            if (i4 >= 12 && i4 < 18) {
                sb = new StringBuilder();
                i2 = R.string.time_afternoon;
            } else if (i4 < 18 || i4 >= 24) {
                return "";
            } else {
                sb = new StringBuilder();
                i2 = R.string.time_evening;
            }
            sb2.append(context.getString(i2));
            format = simpleDateFormat2.format(date);
            sb2.append(format);
            return sb2.toString();
        } else {
            sb2 = new StringBuilder();
            i3 = R.string.time_morning;
        }
        sb2.append(context.getString(i3));
        format = simpleDateFormat.format(date);
        sb2.append(format);
        return sb2.toString();
    }

    public static long[] getTsTimes() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return new long[]{instance.getTimeInMillis() / 1000, instance.getTimeInMillis() / 1000};
    }

    public static String getWeekOfDate(Context context, Date date) {
        String[] strArr = {context.getString(R.string.time_sunday), context.getString(R.string.time_monday), context.getString(R.string.time_tuesday), context.getString(R.string.time_wednesday), context.getString(R.string.time_thursday), context.getString(R.string.time_friday), context.getString(R.string.time_saturday)};
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return strArr[instance.get(7) - 1];
    }

    public static boolean isEarly(int i2, long j2) {
        return currentTimeMillis() - j2 > ((long) (((i2 * 24) * CacheConstants.HOUR) * 1000));
    }

    public static boolean isSameDay(long j2, long j3) {
        return isSameDay(new Date(j2), new Date(j3));
    }

    public static boolean isSameDay(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(date);
        instance2.setTime(date2);
        return instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6);
    }

    public static boolean isSameWeekDates(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(date);
        instance2.setTime(date2);
        int i2 = instance.get(1) - instance2.get(1);
        return i2 == 0 ? instance.get(3) == instance2.get(3) : (1 == i2 && 11 == instance2.get(2)) ? instance.get(3) == instance2.get(3) : -1 == i2 && 11 == instance.get(2) && instance.get(3) == instance2.get(3);
    }

    public static String secToTime(int i2) {
        int i3;
        StringBuilder sb;
        if (i2 <= 0) {
            return "00:00:00";
        }
        int i4 = i2 / 60;
        if (i4 < 60) {
            i3 = i2 % 60;
            sb = new StringBuilder();
            sb.append("00:");
        } else {
            int i5 = i4 / 60;
            i4 %= 60;
            i3 = (i2 - (i5 * CacheConstants.HOUR)) - (i4 * 60);
            sb = new StringBuilder();
            sb.append(unitFormat(i5));
            sb.append(":");
        }
        sb.append(unitFormat(i4));
        sb.append(":");
        sb.append(unitFormat(i3));
        return sb.toString();
    }

    public static String unitFormat(int i2) {
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
}
