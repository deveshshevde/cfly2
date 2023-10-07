package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.b;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayList;
import java.util.Iterator;

public final class o implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f2948a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f2949b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private o(Context context) {
        this.f2949b = context;
    }

    public static o a(Context context) {
        return new o(context);
    }

    public o a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.b(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f2949b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public o a(ComponentName componentName) {
        int size = this.f2948a.size();
        try {
            Context context = this.f2949b;
            while (true) {
                Intent a2 = f.a(context, componentName);
                if (a2 == null) {
                    return this;
                }
                this.f2948a.add(size, a2);
                context = this.f2949b;
                componentName = a2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public o a(Intent intent) {
        this.f2948a.add(intent);
        return this;
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f2948a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2948a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!b.a(this.f2949b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                this.f2949b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2948a.iterator();
    }
}
