package com.xeagle.android.newUI.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.af;
import com.xeagle.R;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;

public final class NiceMarqueeText extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24040a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private bg f24041b;

    /* renamed from: c  reason: collision with root package name */
    private String f24042c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f24043d;

    /* renamed from: e  reason: collision with root package name */
    private int f24044e;

    /* renamed from: f  reason: collision with root package name */
    private float f24045f;

    /* renamed from: g  reason: collision with root package name */
    private int f24046g;

    /* renamed from: h  reason: collision with root package name */
    private int f24047h;

    /* renamed from: i  reason: collision with root package name */
    private String f24048i;

    /* renamed from: j  reason: collision with root package name */
    private int f24049j;

    /* renamed from: k  reason: collision with root package name */
    private float f24050k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f24051l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24052m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f24053n;

    /* renamed from: o  reason: collision with root package name */
    private int f24054o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f24055p;

    /* renamed from: q  reason: collision with root package name */
    private float f24056q;

    /* renamed from: r  reason: collision with root package name */
    private TextPaint f24057r;

    /* renamed from: s  reason: collision with root package name */
    private Rect f24058s;

    /* renamed from: t  reason: collision with root package name */
    private int f24059t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f24060u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public String f24061v;

    /* renamed from: w  reason: collision with root package name */
    private float f24062w;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NiceMarqueeText f24063a;

        b(NiceMarqueeText niceMarqueeText) {
            this.f24063a = niceMarqueeText;
        }

        public final void onClick(View view) {
            if (!this.f24063a.f24051l) {
                return;
            }
            if (this.f24063a.f24055p) {
                this.f24063a.b();
            } else {
                this.f24063a.a();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NiceMarqueeText(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.h.d(r2, r0)
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r0 = "context.applicationContext"
            kotlin.jvm.internal.h.b(r2, r0)
            r0 = 0
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.NiceMarqueeText.<init>(android.content.Context):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NiceMarqueeText(android.content.Context r2, android.util.AttributeSet r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.h.d(r2, r0)
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r0 = "context.applicationContext"
            kotlin.jvm.internal.h.b(r2, r0)
            r0 = 0
            r1.<init>(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.NiceMarqueeText.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NiceMarqueeText(Context context, AttributeSet attributeSet, int i2) {
        super(context.getApplicationContext(), attributeSet, i2);
        h.d(context, "context");
        this.f24043d = 1.0f;
        this.f24044e = -16777216;
        this.f24045f = 12.0f;
        this.f24047h = 10;
        this.f24048i = "";
        this.f24049j = 1;
        this.f24050k = 1.0f;
        this.f24052m = true;
        this.f24060u = true;
        this.f24061v = "";
        a(attributeSet);
        d();
        c();
    }

    private final float a(String str) {
        if (str == null || str == "") {
            return 0.0f;
        }
        if (this.f24058s == null) {
            this.f24058s = new Rect();
        }
        TextPaint textPaint = this.f24057r;
        h.a((Object) textPaint);
        textPaint.getTextBounds(str, 0, str.length(), this.f24058s);
        this.f24062w = getContentHeight();
        Rect rect = this.f24058s;
        h.a((Object) rect);
        return (float) rect.width();
    }

    private final void a(AttributeSet attributeSet) {
        af a2 = af.a(getContext(), attributeSet, R.styleable.MarqueeView);
        this.f24044e = a2.b(3, this.f24044e);
        this.f24051l = a2.a(1, this.f24051l);
        this.f24052m = a2.a(0, this.f24052m);
        this.f24043d = a2.a(6, this.f24043d);
        this.f24045f = (float) a2.e(5, (int) this.f24045f);
        this.f24047h = a2.e(4, this.f24047h);
        this.f24050k = a2.a(7, this.f24050k);
        this.f24049j = a2.a(2, this.f24049j);
        a2.b();
    }

    private final void c() {
        setOnClickListener(new b(this));
    }

    private final void d() {
        this.f24058s = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.f24057r = textPaint;
        h.a((Object) textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        TextPaint textPaint2 = this.f24057r;
        h.a((Object) textPaint2);
        textPaint2.setColor(this.f24044e);
        TextPaint textPaint3 = this.f24057r;
        h.a((Object) textPaint3);
        textPaint3.setTextSize(this.f24045f);
    }

    private final float getBlacktWidth() {
        return a("en en") - a("enen");
    }

    private final float getContentHeight() {
        TextPaint textPaint = this.f24057r;
        h.a((Object) textPaint);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return Math.abs(fontMetrics.bottom - fontMetrics.top) / ((float) 2);
    }

    private final void setClickStop(boolean z2) {
        this.f24051l = z2;
    }

    private final void setContinueble(int i2) {
        this.f24049j = i2;
    }

    private final void setResetLocation(boolean z2) {
        this.f24052m = z2;
    }

    public final void a() {
        if (!this.f24055p) {
            bg bgVar = this.f24041b;
            if (bgVar != null) {
                bg.a.a(bgVar, (CancellationException) null, 1, (Object) null);
            }
            this.f24055p = true;
            this.f24041b = g.a(az.f30335a, (f) null, (CoroutineStart) null, new NiceMarqueeText$continueRoll$1(this, (c) null), 3, (Object) null);
        }
    }

    public final void b() {
        this.f24055p = false;
        bg bgVar = this.f24041b;
        if (bgVar != null) {
            bg.a.a(bgVar, (CancellationException) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (((float) r5.f24054o) < (-r5.f24053n)) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (((float) r5.f24054o) < (-r5.f24053n)) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.h.d(r6, r0)
            super.onDraw(r6)
            boolean r0 = r5.f24060u
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0033
            int r0 = r5.f24047h
            r5.setTextDistance(r0)
            float r0 = r5.f24050k
            float r3 = (float) r1
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x001e
            r0 = 0
        L_0x001b:
            r5.f24050k = r0
            goto L_0x0026
        L_0x001e:
            float r3 = (float) r2
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0026
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x001b
        L_0x0026:
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r3 = r5.f24050k
            float r0 = r0 * r3
            r5.f24053n = r0
            r5.f24060u = r1
        L_0x0033:
            int r0 = r5.f24049j
            r3 = 2
            if (r0 == 0) goto L_0x0078
            if (r0 == r2) goto L_0x0066
            if (r0 == r3) goto L_0x0047
            int r0 = r5.f24054o
            float r0 = (float) r0
            float r1 = r5.f24053n
            float r1 = -r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0085
            goto L_0x0082
        L_0x0047:
            float r0 = r5.f24053n
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0085
            float r0 = -r0
            int r1 = r5.f24054o
            float r1 = (float) r1
            float r0 = r0 / r1
            int r0 = (int) r0
            int r1 = r5.f24059t
            if (r0 < r1) goto L_0x0085
            int r1 = r1 + r2
            r5.f24059t = r1
            java.lang.String r0 = r5.f24042c
            java.lang.String r1 = r5.f24061v
            java.lang.String r0 = kotlin.jvm.internal.h.a((java.lang.String) r0, (java.lang.Object) r1)
            r5.f24042c = r0
            goto L_0x0085
        L_0x0066:
            int r0 = r5.f24054o
            float r0 = (float) r0
            float r1 = r5.f24053n
            float r1 = -r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0085
            int r0 = r5.getWidth()
            float r0 = (float) r0
            r5.f24053n = r0
            goto L_0x0085
        L_0x0078:
            int r0 = r5.f24054o
            float r0 = (float) r0
            float r1 = r5.f24053n
            float r1 = -r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0085
        L_0x0082:
            r5.b()
        L_0x0085:
            java.lang.String r0 = r5.f24042c
            if (r0 == 0) goto L_0x00a3
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            float r1 = r5.f24053n
            int r2 = r5.getHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r4 = r5.f24062w
            float r3 = (float) r3
            float r4 = r4 / r3
            float r2 = r2 + r4
            android.text.TextPaint r3 = r5.f24057r
            kotlin.jvm.internal.h.a((java.lang.Object) r3)
            android.graphics.Paint r3 = (android.graphics.Paint) r3
            r6.drawText(r0, r1, r2, r3)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.NiceMarqueeText.onDraw(android.graphics.Canvas):void");
    }

    public final void setContent(String str) {
        h.d(str, "content2");
        if (!TextUtils.isEmpty(str)) {
            if (this.f24052m) {
                this.f24053n = ((float) getWidth()) * this.f24050k;
            }
            int i2 = 0;
            if (!kotlin.text.f.c(str, this.f24048i, false, 2, (Object) null)) {
                str = str + this.f24048i;
            }
            this.f24061v = str;
            int i3 = this.f24049j;
            if (i3 == 2) {
                this.f24054o = (int) (a(str) + ((float) this.f24046g));
                this.f24059t = 0;
                int width = (getWidth() / this.f24054o) + 2;
                this.f24042c = "";
                if (width >= 0) {
                    while (true) {
                        this.f24042c = h.a(this.f24042c, (Object) this.f24061v);
                        if (i2 == width) {
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                float f2 = this.f24053n;
                if (f2 < ((float) 0) && i3 == 0 && (-f2) > ((float) this.f24054o)) {
                    this.f24053n = ((float) getWidth()) * this.f24050k;
                }
                this.f24054o = (int) a(this.f24061v);
                this.f24042c = str;
            }
            if (!this.f24055p) {
                a();
            }
        }
    }

    public final void setContent(List<String> list) {
        setTextDistance(this.f24047h);
        String str = "";
        if (!(list == null || list.size() == 0)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                str = str + list.get(i2) + this.f24048i;
            }
        }
        setContent(str);
    }

    public final void setContentWithMarqueeText(List<? extends com.xeagle.android.widgets.marquee.a> list) {
        setTextDistance(this.f24047h);
        StringBuilder sb = new StringBuilder();
        if (!(list == null || list.size() == 0)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(((com.xeagle.android.widgets.marquee.a) list.get(i2)).b());
                sb.append(this.f24048i);
            }
        }
        String sb2 = sb.toString();
        h.b(sb2, "temString.toString()");
        setContent(sb2);
    }

    public final void setRepetType(int i2) {
        this.f24049j = i2;
        this.f24060u = true;
        setContent(this.f24061v);
    }

    public final void setTextColor(int i2) {
        if (i2 != 0) {
            this.f24044e = i2;
            TextPaint textPaint = this.f24057r;
            h.a((Object) textPaint);
            textPaint.setColor(getResources().getColor(i2));
        }
    }

    public final void setTextDistance(int i2) {
        float blacktWidth = getBlacktWidth();
        this.f24056q = blacktWidth;
        int i3 = (int) (((float) i2) / blacktWidth);
        if (i3 == 0) {
            i3 = 1;
        }
        this.f24046g = (int) (blacktWidth * ((float) i3));
        this.f24048i = "";
        int i4 = 0;
        if (i3 >= 0) {
            while (true) {
                this.f24048i += " ";
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        setContent(this.f24061v);
    }

    public final void setTextSize(float f2) {
        if (f2 > ((float) 0)) {
            this.f24045f = f2;
            TextPaint textPaint = this.f24057r;
            h.a((Object) textPaint);
            textPaint.setTextSize(f2);
            this.f24054o = (int) (a(this.f24061v) + ((float) this.f24046g));
        }
    }

    public final void setTextSpeed(float f2) {
        this.f24043d = f2;
    }
}
