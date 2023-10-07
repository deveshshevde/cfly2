package hf;

import android.util.Log;

public class b {
    public static long a(String str) {
        return Long.parseLong(str.replace(".", "").replace("-", ""));
    }

    public static int b(String str) {
        String replace;
        if (str.equalsIgnoreCase("N/A")) {
            return 0;
        }
        try {
            Log.i("FTP", "getRepeaterFlag: =====" + str.substring(0, str.indexOf("-")));
            if (str.contains("-")) {
                replace = str.substring(0, str.indexOf("-")).replace(".", "");
            } else if (!str.contains("_")) {
                return 0;
            } else {
                replace = str.substring(0, str.indexOf("_")).replace(".", "");
            }
            return Integer.parseInt(replace);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
