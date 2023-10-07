package gd;

import android.text.Layout;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.util.k;

public final class e extends b {

    /* renamed from: p  reason: collision with root package name */
    public final long f28434p;

    /* renamed from: q  reason: collision with root package name */
    public final long f28435q;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f28436a;

        /* renamed from: b  reason: collision with root package name */
        private long f28437b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f28438c;

        /* renamed from: d  reason: collision with root package name */
        private int f28439d;

        /* renamed from: e  reason: collision with root package name */
        private float f28440e;

        /* renamed from: f  reason: collision with root package name */
        private int f28441f;

        /* renamed from: g  reason: collision with root package name */
        private int f28442g;

        /* renamed from: h  reason: collision with root package name */
        private float f28443h;

        /* renamed from: i  reason: collision with root package name */
        private int f28444i;

        /* renamed from: j  reason: collision with root package name */
        private float f28445j;

        public a() {
            a();
        }

        private static float a(float f2, int i2) {
            if (f2 == -3.4028235E38f || i2 != 0 || (f2 >= 0.0f && f2 <= 1.0f)) {
                return f2 != -3.4028235E38f ? f2 : i2 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static float a(int i2, float f2) {
            if (i2 == 0) {
                return 1.0f - f2;
            }
            if (i2 == 1) {
                return f2 <= 0.5f ? f2 * 2.0f : (1.0f - f2) * 2.0f;
            }
            if (i2 == 2) {
                return f2;
            }
            throw new IllegalStateException(String.valueOf(i2));
        }

        private static float e(int i2) {
            if (i2 != 4) {
                return i2 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 3) {
                return 2;
            }
            if (i2 != 4) {
                return i2 != 5 ? 1 : 2;
            }
            return 0;
        }

        private static Layout.Alignment g(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            StringBuilder sb = new StringBuilder(34);
                            sb.append("Unknown textAlignment: ");
                            sb.append(i2);
                            k.c("WebvttCueBuilder", sb.toString());
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public a a(float f2) {
            this.f28440e = f2;
            return this;
        }

        public a a(int i2) {
            this.f28439d = i2;
            return this;
        }

        public a a(long j2) {
            this.f28436a = j2;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f28438c = charSequence;
            return this;
        }

        public void a() {
            this.f28436a = 0;
            this.f28437b = 0;
            this.f28438c = null;
            this.f28439d = 2;
            this.f28440e = -3.4028235E38f;
            this.f28441f = 1;
            this.f28442g = 0;
            this.f28443h = -3.4028235E38f;
            this.f28444i = Integer.MIN_VALUE;
            this.f28445j = 1.0f;
        }

        public a b(float f2) {
            this.f28443h = f2;
            return this;
        }

        public a b(int i2) {
            this.f28441f = i2;
            return this;
        }

        public a b(long j2) {
            this.f28437b = j2;
            return this;
        }

        public e b() {
            this.f28440e = a(this.f28440e, this.f28441f);
            if (this.f28443h == -3.4028235E38f) {
                this.f28443h = e(this.f28439d);
            }
            if (this.f28444i == Integer.MIN_VALUE) {
                this.f28444i = f(this.f28439d);
            }
            this.f28445j = Math.min(this.f28445j, a(this.f28444i, this.f28443h));
            return new e(this.f28436a, this.f28437b, (CharSequence) com.google.android.exoplayer2.util.a.b(this.f28438c), g(this.f28439d), this.f28440e, this.f28441f, this.f28442g, this.f28443h, this.f28444i, this.f28445j);
        }

        public a c(float f2) {
            this.f28445j = f2;
            return this;
        }

        public a c(int i2) {
            this.f28442g = i2;
            return this;
        }

        public a d(int i2) {
            this.f28444i = i2;
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private e(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.f28434p = j2;
        this.f28435q = j3;
    }

    public boolean a() {
        return this.f16588e == -3.4028235E38f && this.f16591h == 0.5f;
    }
}
