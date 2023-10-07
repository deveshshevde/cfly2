package ju;

import android.content.Context;
import android.content.SharedPreferences;
import com.hoho.android.usb.rtsp.a;
import com.xeagle.android.XEagleApp;
import dx.c;
import java.io.File;
import java.io.IOException;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final c f29776d;

    public b(final Context context) {
        super(context);
        this.f29776d = new c(context) {
            /* access modifiers changed from: protected */
            public void a(File file) {
                b.this.a(file);
            }

            /* access modifiers changed from: protected */
            public en.b e() {
                return b.this.e();
            }

            /* access modifiers changed from: protected */
            public File j() {
                return b.this.j();
            }

            /* access modifiers changed from: protected */
            public int m() {
                return Integer.parseInt(b.this.f29775c.f12775b.getString("pref_udp_server_port", "10005"));
            }

            public boolean n() {
                return ((XEagleApp) context.getApplicationContext()).c();
            }

            /* access modifiers changed from: protected */
            public a o() {
                return ((XEagleApp) context.getApplicationContext()).f();
            }
        };
    }

    /* access modifiers changed from: protected */
    public int a(byte[] bArr) throws IOException {
        return this.f29776d.a(bArr);
    }

    /* access modifiers changed from: protected */
    public void a(SharedPreferences sharedPreferences) {
        this.f29776d.h();
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr) throws IOException {
        if (!this.f29776d.n() || ((XEagleApp) this.f29774b.getApplicationContext()).k().a()) {
            this.f29776d.b(bArr);
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.f29776d.i();
    }

    public int k() {
        return this.f29776d.k();
    }

    /* access modifiers changed from: protected */
    public void m() throws IOException {
        this.f29776d.g();
    }

    /* access modifiers changed from: protected */
    public void n() throws IOException {
        this.f29776d.f();
    }
}
