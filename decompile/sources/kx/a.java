package kx;

import android.content.res.AssetManager;
import java.io.IOException;

public class a {
    public static boolean a(AssetManager assetManager, String str, String str2) throws IOException {
        for (String equals : assetManager.list(str)) {
            if (equals.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
