package com.xeagle.android.utils;

import com.xeagle.android.login.retrofitLogin.UserGlobal;

public class g {
    public static boolean a(String str) {
        return "D01016B".equalsIgnoreCase(str) || str.equalsIgnoreCase("D01018") || str.equalsIgnoreCase("D01012B") || str.equalsIgnoreCase("D01015A");
    }

    public static boolean b(String str) {
        return UserGlobal.DRONE_NAME_DF809_E.equalsIgnoreCase(str) || UserGlobal.DRONE_NAME_DF812_E.equalsIgnoreCase(str);
    }
}
