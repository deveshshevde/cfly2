package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.ad;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements j {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f16837a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f16838b;

    /* renamed from: c  reason: collision with root package name */
    private int f16839c;

    /* renamed from: d  reason: collision with root package name */
    private float f16840d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16841e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16842f;

    /* renamed from: g  reason: collision with root package name */
    private a f16843g;

    /* renamed from: h  reason: collision with root package name */
    private float f16844h;

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16837a = new ArrayList();
        this.f16839c = 0;
        this.f16840d = 0.0533f;
        this.f16841e = true;
        this.f16842f = true;
        this.f16843g = a.f16577a;
        this.f16844h = 0.08f;
    }

    private float a(int i2, float f2, int i3, int i4) {
        float f3;
        if (i2 == 0) {
            f3 = (float) i4;
        } else if (i2 == 1) {
            f3 = (float) i3;
        } else if (i2 != 2) {
            return -3.4028235E38f;
        } else {
            return f2;
        }
        return f2 * f3;
    }

    private float a(b bVar, int i2, int i3) {
        if (bVar.f16597n == Integer.MIN_VALUE || bVar.f16598o == -3.4028235E38f) {
            return 0.0f;
        }
        return Math.max(a(bVar.f16597n, bVar.f16598o, i2, i3), 0.0f);
    }

    private void a(int i2, float f2) {
        if (this.f16839c != i2 || this.f16840d != f2) {
            this.f16839c = i2;
            this.f16840d = f2;
            invalidate();
        }
    }

    private boolean c() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).isEnabled();
    }

    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    private a getUserCaptionStyleV19() {
        return a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void a() {
        setFractionalTextSize(((ad.f11755a < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public void a(float f2, boolean z2) {
        a(z2 ? 1 : 0, f2);
    }

    public void a(List<b> list) {
        setCues(list);
    }

    public void b() {
        setStyle((ad.f11755a < 19 || !c() || isInEditMode()) ? a.f16577a : getUserCaptionStyleV19());
    }

    public void dispatchDraw(Canvas canvas) {
        List<b> list = this.f16838b;
        if (list != null && !list.isEmpty()) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int paddingBottom = height - getPaddingBottom();
            if (paddingBottom > paddingTop && width > paddingLeft) {
                int i2 = paddingBottom - paddingTop;
                float a2 = a(this.f16839c, this.f16840d, height, i2);
                if (a2 > 0.0f) {
                    int size = list.size();
                    int i3 = 0;
                    while (i3 < size) {
                        b bVar = list.get(i3);
                        float a3 = a(bVar, height, i2);
                        boolean z2 = this.f16841e;
                        boolean z3 = this.f16842f;
                        a aVar = this.f16843g;
                        int i4 = i3;
                        float f2 = a3;
                        int i5 = size;
                        float f3 = this.f16844h;
                        int i6 = paddingBottom;
                        int i7 = width;
                        this.f16837a.get(i3).a(bVar, z2, z3, aVar, a2, f2, f3, canvas, paddingLeft, paddingTop, i7, i6);
                        i3 = i4 + 1;
                        size = i5;
                        i2 = i2;
                        paddingBottom = i6;
                        width = i7;
                        paddingTop = paddingTop;
                        paddingLeft = paddingLeft;
                    }
                }
            }
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        if (this.f16842f != z2) {
            this.f16842f = z2;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        if (this.f16841e != z2 || this.f16842f != z2) {
            this.f16841e = z2;
            this.f16842f = z2;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f2) {
        if (this.f16844h != f2) {
            this.f16844h = f2;
            invalidate();
        }
    }

    public void setCues(List<b> list) {
        if (this.f16838b != list) {
            this.f16838b = list;
            int size = list == null ? 0 : list.size();
            while (this.f16837a.size() < size) {
                this.f16837a.add(new b(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float f2) {
        a(f2, false);
    }

    public void setStyle(a aVar) {
        if (this.f16843g != aVar) {
            this.f16843g = aVar;
            invalidate();
        }
    }
}
