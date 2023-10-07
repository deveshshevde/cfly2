package hu;

public class a {
    public static String a(String str) {
        if (!(str == null || str.length() == 0)) {
            String[] split = str.split("/");
            if (split.length > 0) {
                return split[split.length - 1];
            }
        }
        return "";
    }
}
