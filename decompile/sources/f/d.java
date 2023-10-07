package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f27012a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f27013b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f27014c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f27015d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f27016e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i2) {
        super(context);
        this.f27012a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f27013b = theme;
    }

    private Resources b() {
        Resources resources;
        if (this.f27016e == null) {
            if (this.f27015d == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(this.f27015d).getResources();
            } else {
                Resources resources2 = super.getResources();
                Configuration configuration = new Configuration(resources2.getConfiguration());
                configuration.updateFrom(this.f27015d);
                this.f27016e = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration);
            }
            this.f27016e = resources;
        }
        return this.f27016e;
    }

    private void c() {
        boolean z2 = this.f27013b == null;
        if (z2) {
            this.f27013b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f27013b.setTo(theme);
            }
        }
        a(this.f27013b, this.f27012a, z2);
    }

    public int a() {
        return this.f27012a;
    }

    public void a(Configuration configuration) {
        if (this.f27016e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f27015d == null) {
            this.f27015d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i2, boolean z2) {
        theme.applyStyle(i2, true);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f27014c == null) {
            this.f27014c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f27014c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f27013b;
        if (theme != null) {
            return theme;
        }
        if (this.f27012a == 0) {
            this.f27012a = R.style.Theme_AppCompat_Light;
        }
        c();
        return this.f27013b;
    }

    public void setTheme(int i2) {
        if (this.f27012a != i2) {
            this.f27012a = i2;
            c();
        }
    }
}
