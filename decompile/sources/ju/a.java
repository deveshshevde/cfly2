package ju;

import android.content.Context;
import android.content.SharedPreferences;
import com.MAVLink.MAVLinkPacket;
import en.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kx.g;

public abstract class a extends dx.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f29773d = "a";

    /* renamed from: b  reason: collision with root package name */
    protected final Context f29774b;

    /* renamed from: c  reason: collision with root package name */
    protected final com.xeagle.android.utils.prefs.a f29775c;

    public a(Context context) {
        this.f29774b = context.getApplicationContext();
        this.f29775c = new com.xeagle.android.utils.prefs.a(context);
    }

    /* access modifiers changed from: protected */
    public abstract void a(SharedPreferences sharedPreferences);

    /* access modifiers changed from: protected */
    public final void a(File file) {
        g.a(file);
    }

    /* access modifiers changed from: protected */
    public final void b(MAVLinkPacket mAVLinkPacket) throws IOException {
    }

    /* access modifiers changed from: protected */
    public final b e() {
        return com.xeagle.android.utils.b.a();
    }

    /* access modifiers changed from: protected */
    public final void f() throws IOException {
        n();
        kt.a.a(this.f29774b);
    }

    /* access modifiers changed from: protected */
    public final void g() throws IOException {
        m();
    }

    /* access modifiers changed from: protected */
    public final void h() {
        a(this.f29775c.f12775b);
    }

    /* access modifiers changed from: protected */
    public final File j() {
        try {
            return g.a(this.f29774b);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void m() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void n() throws IOException;
}
