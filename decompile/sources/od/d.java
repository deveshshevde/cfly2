package od;

import org.jcodec.common.e;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f31680a = new e();

    /* renamed from: b  reason: collision with root package name */
    private e f31681b = new e();

    /* renamed from: c  reason: collision with root package name */
    private org.jcodec.common.d f31682c = new org.jcodec.common.d();

    /* renamed from: d  reason: collision with root package name */
    private org.jcodec.common.d f31683d = new org.jcodec.common.d();

    public c a() {
        return new c(this.f31682c.a(), this.f31683d.a()) {
            public void a(b bVar, int i2) {
                super.a(bVar, d.this.f31680a.a(i2));
            }
        };
    }

    public d a(int i2, int i3, int i4) {
        this.f31682c.a(i2 << (32 - i3));
        this.f31683d.a(i3);
        this.f31680a.a(i4, this.f31682c.c() - 1);
        this.f31681b.a(this.f31682c.c() - 1, i4);
        return this;
    }

    public d a(int i2, String str) {
        a(Integer.parseInt(str, 2), str.length(), i2);
        return this;
    }
}
