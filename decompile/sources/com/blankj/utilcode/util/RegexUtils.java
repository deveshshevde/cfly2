package com.blankj.utilcode.util;

import com.blankj.utilcode.constant.RegexConstants;
import j.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {
    private static final g<String, String> CITY_MAP = new g<>();

    private RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static List<String> getMatches(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static String getReplaceAll(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceAll(str3);
    }

    public static String getReplaceFirst(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceFirst(str3);
    }

    public static String[] getSplits(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean isDate(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_DATE, charSequence);
    }

    public static boolean isEmail(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_EMAIL, charSequence);
    }

    public static boolean isIDCard15(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_ID_CARD15, charSequence);
    }

    public static boolean isIDCard18(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_ID_CARD18, charSequence);
    }

    public static boolean isIDCard18Exact(CharSequence charSequence) {
        if (!isIDCard18(charSequence)) {
            return false;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        g<String, String> gVar = CITY_MAP;
        if (gVar.isEmpty()) {
            gVar.put("11", "北京");
            gVar.put("12", "天津");
            gVar.put("13", "河北");
            gVar.put("14", "山西");
            gVar.put("15", "内蒙古");
            gVar.put("21", "辽宁");
            gVar.put("22", "吉林");
            gVar.put("23", "黑龙江");
            gVar.put("31", "上海");
            gVar.put("32", "江苏");
            gVar.put("33", "浙江");
            gVar.put("34", "安徽");
            gVar.put("35", "福建");
            gVar.put("36", "江西");
            gVar.put("37", "山东");
            gVar.put("41", "河南");
            gVar.put("42", "湖北");
            gVar.put("43", "湖南");
            gVar.put("44", "广东");
            gVar.put("45", "广西");
            gVar.put("46", "海南");
            gVar.put("50", "重庆");
            gVar.put("51", "四川");
            gVar.put("52", "贵州");
            gVar.put("53", "云南");
            gVar.put("54", "西藏");
            gVar.put("61", "陕西");
            gVar.put("62", "甘肃");
            gVar.put("63", "青海");
            gVar.put("64", "宁夏");
            gVar.put("65", "新疆");
            gVar.put("71", "台湾老");
            gVar.put("81", "香港");
            gVar.put("82", "澳门");
            gVar.put("83", "台湾新");
            gVar.put("91", "国外");
        }
        if (gVar.get(charSequence.subSequence(0, 2).toString()) == null) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            i2 += (charSequence.charAt(i3) - '0') * iArr[i3];
        }
        return charSequence.charAt(17) == cArr[i2 % 11];
    }

    public static boolean isIP(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_IP, charSequence);
    }

    public static boolean isMatch(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static boolean isMobileExact(CharSequence charSequence) {
        return isMobileExact(charSequence, (List<String>) null);
    }

    public static boolean isMobileExact(CharSequence charSequence, List<String> list) {
        if (isMatch(RegexConstants.REGEX_MOBILE_EXACT, charSequence)) {
            return true;
        }
        if (!(list == null || charSequence == null || charSequence.length() != 11)) {
            String charSequence2 = charSequence.toString();
            for (char isDigit : charSequence2.toCharArray()) {
                if (!Character.isDigit(isDigit)) {
                    return false;
                }
            }
            for (String startsWith : list) {
                if (charSequence2.startsWith(startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMobileSimple(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_MOBILE_SIMPLE, charSequence);
    }

    public static boolean isTel(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_TEL, charSequence);
    }

    public static boolean isURL(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_URL, charSequence);
    }

    public static boolean isUsername(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_USERNAME, charSequence);
    }

    public static boolean isZh(CharSequence charSequence) {
        return isMatch(RegexConstants.REGEX_ZH, charSequence);
    }
}
