package bu;

import android.graphics.Bitmap;
import bj.a;
import bl.e;

public final class b implements a.C0050a {

    /* renamed from: a  reason: collision with root package name */
    private final e f5997a;

    /* renamed from: b  reason: collision with root package name */
    private final bl.b f5998b;

    public b(e eVar, bl.b bVar) {
        this.f5997a = eVar;
        this.f5998b = bVar;
    }

    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f5997a.b(i2, i3, config);
    }

    public void a(Bitmap bitmap) {
        this.f5997a.a(bitmap);
    }

    public void a(byte[] bArr) {
        bl.b bVar = this.f5998b;
        if (bVar != null) {
            bVar.a(bArr);
        }
    }

    public void a(int[] iArr) {
        bl.b bVar = this.f5998b;
        if (bVar != null) {
            bVar.a(iArr);
        }
    }

    public byte[] a(int i2) {
        bl.b bVar = this.f5998b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.a(i2, byte[].class);
    }

    public int[] b(int i2) {
        bl.b bVar = this.f5998b;
        return bVar == null ? new int[i2] : (int[]) bVar.a(i2, int[].class);
    }
}
