package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ac extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1396a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<ac>> f1397b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1398c;

    /* renamed from: d  reason: collision with root package name */
    private final Resources.Theme f1399d;

    private ac(Context context) {
        super(context);
        if (ak.a()) {
            ak akVar = new ak(this, context.getResources());
            this.f1398c = akVar;
            Resources.Theme newTheme = akVar.newTheme();
            this.f1399d = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1398c = new ae(this, context.getResources());
        this.f1399d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f1396a) {
            ArrayList<WeakReference<ac>> arrayList = f1397b;
            if (arrayList == null) {
                f1397b = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1397b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1397b.remove(size);
                    }
                }
                for (int size2 = f1397b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1397b.get(size2);
                    ac acVar = weakReference2 != null ? (ac) weakReference2.get() : null;
                    if (acVar != null && acVar.getBaseContext() == context) {
                        return acVar;
                    }
                }
            }
            ac acVar2 = new ac(context);
            f1397b.add(new WeakReference(acVar2));
            return acVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ac) || (context.getResources() instanceof ae) || (context.getResources() instanceof ak)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || ak.a();
    }

    public AssetManager getAssets() {
        return this.f1398c.getAssets();
    }

    public Resources getResources() {
        return this.f1398c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1399d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i2) {
        Resources.Theme theme = this.f1399d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
