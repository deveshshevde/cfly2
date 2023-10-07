package ev;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f26985a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f26986b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f26987c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26988d;

    /* renamed from: e  reason: collision with root package name */
    private int f26989e;

    public b(int i2, Bitmap bitmap, RectF rectF, boolean z2, int i3) {
        this.f26985a = i2;
        this.f26986b = bitmap;
        this.f26987c = rectF;
        this.f26988d = z2;
        this.f26989e = i3;
    }

    public int a() {
        return this.f26989e;
    }

    public void a(int i2) {
        this.f26989e = i2;
    }

    public int b() {
        return this.f26985a;
    }

    public Bitmap c() {
        return this.f26986b;
    }

    public RectF d() {
        return this.f26987c;
    }

    public boolean e() {
        return this.f26988d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.b() == this.f26985a && bVar.d().left == this.f26987c.left && bVar.d().right == this.f26987c.right && bVar.d().top == this.f26987c.top && bVar.d().bottom == this.f26987c.bottom;
    }
}
