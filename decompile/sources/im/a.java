package im;

import com.xeagle.android.login.common.StorageUtil;
import iq.c;

public class a implements c.a {
    public int a(int i2, String str, String str2, long j2) {
        if (j2 < StorageUtil.M) {
            return 1;
        }
        if (j2 < 5242880) {
            return 2;
        }
        if (j2 < 52428800) {
            return 3;
        }
        return j2 < 104857600 ? 4 : 5;
    }
}
