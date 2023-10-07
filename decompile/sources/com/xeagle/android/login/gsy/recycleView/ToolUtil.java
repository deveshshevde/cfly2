package com.xeagle.android.login.gsy.recycleView;

public class ToolUtil {

    private static final class SingleTon {
        /* access modifiers changed from: private */
        public static final ToolUtil TOOL_UTIL = new ToolUtil();

        private SingleTon() {
        }
    }

    public static ToolUtil getInstance() {
        return SingleTon.TOOL_UTIL;
    }

    public String getAmbaPath(String str) {
        StringBuilder sb;
        String str2;
        int i2;
        int indexOf = str.indexOf("000/");
        int lastIndexOf = str.lastIndexOf("/");
        if (indexOf != -1 && (i2 = indexOf + 3) < lastIndexOf) {
            str = str.replace(str.substring(i2, lastIndexOf), "");
        }
        String replace = str.replace("000/", "");
        if (replace.contains("AA")) {
            replace = replace.replace("AA", "");
        }
        String substring = replace.substring(replace.lastIndexOf(47) + 1, replace.length());
        if (substring.contains("MP4")) {
            sb = new StringBuilder();
            str2 = "video_20";
        } else if (!substring.contains("JPG")) {
            return substring;
        } else {
            sb = new StringBuilder();
            str2 = "image_20";
        }
        sb.append(str2);
        sb.append(substring);
        return sb.toString();
    }
}
