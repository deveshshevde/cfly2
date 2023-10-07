package id;

import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir;
import com.huawei.android.multiscreen.dlna.sdk.jni.a;
import java.io.File;

public class b {
    public boolean a(String str) {
        return new File(str).exists();
    }

    public boolean b(String str) {
        return new File(str).isDirectory();
    }

    public a c(String str) {
        return !a(str) ? new a(str) : b(str) ? new DlnaDmsShareDir(str) : new a(str);
    }
}
