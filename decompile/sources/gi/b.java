package gi;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f28511a;

    public b(Context context) {
        this.f28511a = context;
    }

    public int a(String str) {
        return this.f28511a.checkCallingOrSelfPermission(str);
    }

    public int a(String str, String str2) {
        return this.f28511a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo a(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f28511a.getPackageManager().getApplicationInfo(str, i2);
    }

    public PackageInfo b(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f28511a.getPackageManager().getPackageInfo(str, i2);
    }

    public CharSequence b(String str) throws PackageManager.NameNotFoundException {
        return this.f28511a.getPackageManager().getApplicationLabel(this.f28511a.getPackageManager().getApplicationInfo(str, 0));
    }
}
