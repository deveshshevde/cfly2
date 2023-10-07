package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import s.d;

public class b {

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityOptions f2821a;

        a(ActivityOptions activityOptions) {
            this.f2821a = activityOptions;
        }

        public Bundle a() {
            return this.f2821a.toBundle();
        }
    }

    protected b() {
    }

    public static b a(Activity activity, d<View, String>... dVarArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new b();
        }
        Pair[] pairArr = null;
        if (dVarArr != null) {
            pairArr = new Pair[dVarArr.length];
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                pairArr[i2] = Pair.create((View) dVarArr[i2].f34394a, (String) dVarArr[i2].f34395b);
            }
        }
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    public static b a(Context context, int i2, int i3) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeCustomAnimation(context, i2, i3)) : new b();
    }

    public Bundle a() {
        return null;
    }
}
