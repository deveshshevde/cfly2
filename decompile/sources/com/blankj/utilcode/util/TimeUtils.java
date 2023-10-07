package com.blankj.utilcode.util;

import com.blankj.utilcode.constant.TimeConstants;
import com.xeagle.android.login.common.TimeUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class TimeUtils {
    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final ThreadLocal<Map<String, SimpleDateFormat>> SDF_THREAD_LOCAL = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        /* access modifiers changed from: protected */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    };
    private static final String[] ZODIAC = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    private static final int[] ZODIAC_FLAGS = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    private TimeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static long date2Millis(Date date) {
        return date.getTime();
    }

    public static String date2String(Date date) {
        return date2String(date, (DateFormat) getDefaultFormat());
    }

    public static String date2String(Date date, String str) {
        Objects.requireNonNull(str, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSafeDateFormat(str).format(date);
    }

    public static String date2String(Date date, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return dateFormat.format(date);
    }

    public static String getChineseWeek(long j2) {
        return getChineseWeek(new Date(j2));
    }

    public static String getChineseWeek(String str) {
        return getChineseWeek(string2Date(str, (DateFormat) getDefaultFormat()));
    }

    public static String getChineseWeek(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getChineseWeek(string2Date(str, dateFormat));
    }

    public static String getChineseWeek(Date date) {
        return new SimpleDateFormat("E", Locale.CHINA).format(date);
    }

    public static String getChineseZodiac(int i2) {
        return CHINESE_ZODIAC[i2 % 12];
    }

    public static String getChineseZodiac(long j2) {
        return getChineseZodiac(millis2Date(j2));
    }

    public static String getChineseZodiac(String str) {
        return getChineseZodiac(string2Date(str, (DateFormat) getDefaultFormat()));
    }

    public static String getChineseZodiac(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getChineseZodiac(string2Date(str, dateFormat));
    }

    public static String getChineseZodiac(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return CHINESE_ZODIAC[instance.get(1) % 12];
    }

    public static Date getDate(long j2, long j3, int i2) {
        return millis2Date(j2 + timeSpan2Millis(j3, i2));
    }

    public static Date getDate(String str, long j2, int i2) {
        return getDate(str, getDefaultFormat(), j2, i2);
    }

    public static Date getDate(String str, DateFormat dateFormat, long j2, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2Date(string2Millis(str, dateFormat) + timeSpan2Millis(j2, i2));
    }

    public static Date getDate(Date date, long j2, int i2) {
        return millis2Date(date2Millis(date) + timeSpan2Millis(j2, i2));
    }

    public static Date getDateByNow(long j2, int i2) {
        return getDate(getNowMills(), j2, i2);
    }

    private static SimpleDateFormat getDefaultFormat() {
        return getSafeDateFormat(TimeUtil.DEF_FORMAT);
    }

    public static String getFitTimeSpan(long j2, long j3, int i2) {
        return millis2FitTimeSpan(j2 - j3, i2);
    }

    public static String getFitTimeSpan(String str, String str2, int i2) {
        return millis2FitTimeSpan(string2Millis(str, (DateFormat) getDefaultFormat()) - string2Millis(str2, (DateFormat) getDefaultFormat()), i2);
    }

    public static String getFitTimeSpan(String str, String str2, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2FitTimeSpan(string2Millis(str, dateFormat) - string2Millis(str2, dateFormat), i2);
    }

    public static String getFitTimeSpan(Date date, Date date2, int i2) {
        return millis2FitTimeSpan(date2Millis(date) - date2Millis(date2), i2);
    }

    public static String getFitTimeSpanByNow(long j2, int i2) {
        return getFitTimeSpan(j2, System.currentTimeMillis(), i2);
    }

    public static String getFitTimeSpanByNow(String str, int i2) {
        return getFitTimeSpan(str, getNowString(), getDefaultFormat(), i2);
    }

    public static String getFitTimeSpanByNow(String str, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getFitTimeSpan(str, getNowString(dateFormat), dateFormat, i2);
    }

    public static String getFitTimeSpanByNow(Date date, int i2) {
        return getFitTimeSpan(date, getNowDate(), i2);
    }

    public static String getFriendlyTimeSpanByNow(long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis < 0) {
            return String.format("%tc", new Object[]{Long.valueOf(j2)});
        } else if (currentTimeMillis < 1000) {
            return "刚刚";
        } else {
            if (currentTimeMillis < 60000) {
                return String.format(Locale.getDefault(), "%d秒前", new Object[]{Long.valueOf(currentTimeMillis / 1000)});
            } else if (currentTimeMillis < 3600000) {
                return String.format(Locale.getDefault(), "%d分钟前", new Object[]{Long.valueOf(currentTimeMillis / 60000)});
            } else {
                long weeOfToday = getWeeOfToday();
                if (j2 >= weeOfToday) {
                    return String.format("今天%tR", new Object[]{Long.valueOf(j2)});
                }
                int i2 = (j2 > (weeOfToday - 86400000) ? 1 : (j2 == (weeOfToday - 86400000) ? 0 : -1));
                Object[] objArr = new Object[1];
                Long valueOf = Long.valueOf(j2);
                if (i2 >= 0) {
                    objArr[0] = valueOf;
                    return String.format("昨天%tR", objArr);
                }
                objArr[0] = valueOf;
                return String.format("%tF", objArr);
            }
        }
    }

    public static String getFriendlyTimeSpanByNow(String str) {
        return getFriendlyTimeSpanByNow(str, getDefaultFormat());
    }

    public static String getFriendlyTimeSpanByNow(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getFriendlyTimeSpanByNow(string2Millis(str, dateFormat));
    }

    public static String getFriendlyTimeSpanByNow(Date date) {
        return getFriendlyTimeSpanByNow(date.getTime());
    }

    public static long getMillis(long j2, long j3, int i2) {
        return j2 + timeSpan2Millis(j3, i2);
    }

    public static long getMillis(String str, long j2, int i2) {
        return getMillis(str, getDefaultFormat(), j2, i2);
    }

    public static long getMillis(String str, DateFormat dateFormat, long j2, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return string2Millis(str, dateFormat) + timeSpan2Millis(j2, i2);
    }

    public static long getMillis(Date date, long j2, int i2) {
        return date2Millis(date) + timeSpan2Millis(j2, i2);
    }

    public static long getMillisByNow(long j2, int i2) {
        return getMillis(getNowMills(), j2, i2);
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    public static String getNowString() {
        return millis2String(System.currentTimeMillis(), (DateFormat) getDefaultFormat());
    }

    public static String getNowString(DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2String(System.currentTimeMillis(), dateFormat);
    }

    public static SimpleDateFormat getSafeDateFormat(String str) {
        Map map = SDF_THREAD_LOCAL.get();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String getString(long j2, long j3, int i2) {
        return getString(j2, (DateFormat) getDefaultFormat(), j3, i2);
    }

    public static String getString(long j2, DateFormat dateFormat, long j3, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2String(j2 + timeSpan2Millis(j3, i2), dateFormat);
    }

    public static String getString(String str, long j2, int i2) {
        return getString(str, (DateFormat) getDefaultFormat(), j2, i2);
    }

    public static String getString(String str, DateFormat dateFormat, long j2, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2String(string2Millis(str, dateFormat) + timeSpan2Millis(j2, i2), dateFormat);
    }

    public static String getString(Date date, long j2, int i2) {
        return getString(date, (DateFormat) getDefaultFormat(), j2, i2);
    }

    public static String getString(Date date, DateFormat dateFormat, long j2, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2String(date2Millis(date) + timeSpan2Millis(j2, i2), dateFormat);
    }

    public static String getStringByNow(long j2, int i2) {
        return getStringByNow(j2, getDefaultFormat(), i2);
    }

    public static String getStringByNow(long j2, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(getNowMills(), dateFormat, j2, i2);
    }

    public static long getTimeSpan(long j2, long j3, int i2) {
        return millis2TimeSpan(j2 - j3, i2);
    }

    public static long getTimeSpan(String str, String str2, int i2) {
        return getTimeSpan(str, str2, getDefaultFormat(), i2);
    }

    public static long getTimeSpan(String str, String str2, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2TimeSpan(string2Millis(str, dateFormat) - string2Millis(str2, dateFormat), i2);
    }

    public static long getTimeSpan(Date date, Date date2, int i2) {
        return millis2TimeSpan(date2Millis(date) - date2Millis(date2), i2);
    }

    public static long getTimeSpanByNow(long j2, int i2) {
        return getTimeSpan(j2, System.currentTimeMillis(), i2);
    }

    public static long getTimeSpanByNow(String str, int i2) {
        return getTimeSpan(str, getNowString(), getDefaultFormat(), i2);
    }

    public static long getTimeSpanByNow(String str, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getTimeSpan(str, getNowString(dateFormat), dateFormat, i2);
    }

    public static long getTimeSpanByNow(Date date, int i2) {
        return getTimeSpan(date, new Date(), i2);
    }

    public static String getUSWeek(long j2) {
        return getUSWeek(new Date(j2));
    }

    public static String getUSWeek(String str) {
        return getUSWeek(string2Date(str, (DateFormat) getDefaultFormat()));
    }

    public static String getUSWeek(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getUSWeek(string2Date(str, dateFormat));
    }

    public static String getUSWeek(Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    public static int getValueByCalendarField(int i2) {
        return Calendar.getInstance().get(i2);
    }

    public static int getValueByCalendarField(long j2, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        return instance.get(i2);
    }

    public static int getValueByCalendarField(String str, int i2) {
        return getValueByCalendarField(string2Date(str, (DateFormat) getDefaultFormat()), i2);
    }

    public static int getValueByCalendarField(String str, DateFormat dateFormat, int i2) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getValueByCalendarField(string2Date(str, dateFormat), i2);
    }

    public static int getValueByCalendarField(Date date, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(i2);
    }

    private static long getWeeOfToday() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static String getZodiac(int i2, int i3) {
        String[] strArr = ZODIAC;
        int i4 = i2 - 1;
        if (i3 < ZODIAC_FLAGS[i4]) {
            i4 = (i2 + 10) % 12;
        }
        return strArr[i4];
    }

    public static String getZodiac(long j2) {
        return getZodiac(millis2Date(j2));
    }

    public static String getZodiac(String str) {
        return getZodiac(string2Date(str, (DateFormat) getDefaultFormat()));
    }

    public static String getZodiac(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getZodiac(string2Date(str, dateFormat));
    }

    public static String getZodiac(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return getZodiac(instance.get(2) + 1, instance.get(5));
    }

    public static boolean isAm() {
        return Calendar.getInstance().get(9) == 0;
    }

    public static boolean isAm(long j2) {
        return getValueByCalendarField(j2, 9) == 0;
    }

    public static boolean isAm(String str) {
        return getValueByCalendarField(str, getDefaultFormat(), 9) == 0;
    }

    public static boolean isAm(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getValueByCalendarField(str, dateFormat, 9) == 0;
    }

    public static boolean isAm(Date date) {
        return getValueByCalendarField(date, 9) == 0;
    }

    public static boolean isLeapYear(int i2) {
        return (i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0;
    }

    public static boolean isLeapYear(long j2) {
        return isLeapYear(millis2Date(j2));
    }

    public static boolean isLeapYear(String str) {
        return isLeapYear(string2Date(str, (DateFormat) getDefaultFormat()));
    }

    public static boolean isLeapYear(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isLeapYear(string2Date(str, dateFormat));
    }

    public static boolean isLeapYear(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return isLeapYear(instance.get(1));
    }

    public static boolean isPm() {
        return !isAm();
    }

    public static boolean isPm(long j2) {
        return !isAm(j2);
    }

    public static boolean isPm(String str) {
        return !isAm(str);
    }

    public static boolean isPm(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return !isAm(str, dateFormat);
    }

    public static boolean isPm(Date date) {
        return !isAm(date);
    }

    public static boolean isToday(long j2) {
        long weeOfToday = getWeeOfToday();
        return j2 >= weeOfToday && j2 < weeOfToday + 86400000;
    }

    public static boolean isToday(String str) {
        return isToday(string2Millis(str, (DateFormat) getDefaultFormat()));
    }

    public static boolean isToday(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isToday(string2Millis(str, dateFormat));
    }

    public static boolean isToday(Date date) {
        return isToday(date.getTime());
    }

    public static Date millis2Date(long j2) {
        return new Date(j2);
    }

    static String millis2FitTimeSpan(long j2, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int min = Math.min(i2, 5);
        String[] strArr = {"天", "小时", "分钟", "秒", "毫秒"};
        if (j2 == 0) {
            return 0 + strArr[min - 1];
        }
        StringBuilder sb = new StringBuilder();
        if (j2 < 0) {
            sb.append("-");
            j2 = -j2;
        }
        int[] iArr = {TimeConstants.DAY, TimeConstants.HOUR, 60000, 1000, 1};
        for (int i3 = 0; i3 < min; i3++) {
            if (j2 >= ((long) iArr[i3])) {
                long j3 = j2 / ((long) iArr[i3]);
                j2 -= ((long) iArr[i3]) * j3;
                sb.append(j3);
                sb.append(strArr[i3]);
            }
        }
        return sb.toString();
    }

    public static String millis2String(long j2) {
        return millis2String(j2, (DateFormat) getDefaultFormat());
    }

    public static String millis2String(long j2, String str) {
        Objects.requireNonNull(str, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return millis2String(j2, (DateFormat) getSafeDateFormat(str));
    }

    public static String millis2String(long j2, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return dateFormat.format(new Date(j2));
    }

    private static long millis2TimeSpan(long j2, int i2) {
        return j2 / ((long) i2);
    }

    public static Date string2Date(String str) {
        return string2Date(str, (DateFormat) getDefaultFormat());
    }

    public static Date string2Date(String str, String str2) {
        Objects.requireNonNull(str2, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return string2Date(str, (DateFormat) getSafeDateFormat(str2));
    }

    public static Date string2Date(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long string2Millis(String str) {
        return string2Millis(str, (DateFormat) getDefaultFormat());
    }

    public static long string2Millis(String str, String str2) {
        Objects.requireNonNull(str2, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return string2Millis(str, (DateFormat) getSafeDateFormat(str2));
    }

    public static long string2Millis(String str, DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return dateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static long timeSpan2Millis(long j2, int i2) {
        return j2 * ((long) i2);
    }
}
