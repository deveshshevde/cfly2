package org.jcodec.common.tools;

import java.util.regex.Pattern;

public class MainUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33243a = (System.console() != null || Boolean.parseBoolean(System.getProperty("jcodec.colorPrint")));

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f33244b = Pattern.compile("^--([^=]+)=(.*)$");

    public enum ANSIColor {
        BLACK,
        RED,
        GREEN,
        BROWN,
        BLUE,
        MAGENTA,
        CYAN,
        GREY
    }

    public static String a(String str) {
        if (!f33243a) {
            return str;
        }
        return "\u001b[1m" + str + "\u001b[0m";
    }

    public static String a(String str, String str2) {
        if (!f33243a) {
            return str;
        }
        return "\u001b[" + str2 + "m" + str + "\u001b[0m";
    }
}
