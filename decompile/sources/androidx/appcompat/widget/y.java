package androidx.appcompat.widget;

class y {

    /* renamed from: a  reason: collision with root package name */
    private int f1598a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1599b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1600c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1601d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1602e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1603f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1604g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1605h = false;

    y() {
    }

    public int a() {
        return this.f1598a;
    }

    public void a(int i2, int i3) {
        this.f1600c = i2;
        this.f1601d = i3;
        this.f1605h = true;
        if (this.f1604g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1598a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1599b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1598a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1599b = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1604g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.f1604g = r2
            boolean r0 = r1.f1605h
            if (r0 == 0) goto L_0x002b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001d
            int r2 = r1.f1601d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f1602e
        L_0x0016:
            r1.f1598a = r2
            int r2 = r1.f1600c
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x001d:
            int r2 = r1.f1600c
            if (r2 == r0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            int r2 = r1.f1602e
        L_0x0024:
            r1.f1598a = r2
            int r2 = r1.f1601d
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x002b:
            int r2 = r1.f1602e
            r1.f1598a = r2
        L_0x002f:
            int r2 = r1.f1603f
        L_0x0031:
            r1.f1599b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.a(boolean):void");
    }

    public int b() {
        return this.f1599b;
    }

    public void b(int i2, int i3) {
        this.f1605h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f1602e = i2;
            this.f1598a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1603f = i3;
            this.f1599b = i3;
        }
    }

    public int c() {
        return this.f1604g ? this.f1599b : this.f1598a;
    }

    public int d() {
        return this.f1604g ? this.f1598a : this.f1599b;
    }
}
