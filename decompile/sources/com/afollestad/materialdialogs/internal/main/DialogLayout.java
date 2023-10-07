package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import ay.c;
import ay.e;
import ay.f;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.internal.button.a;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class DialogLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public b f7593a;

    /* renamed from: b  reason: collision with root package name */
    public DialogTitleLayout f7594b;

    /* renamed from: c  reason: collision with root package name */
    public DialogContentLayout f7595c;

    /* renamed from: d  reason: collision with root package name */
    private int f7596d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7597e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f7598f = new float[0];

    /* renamed from: g  reason: collision with root package name */
    private Paint f7599g;

    /* renamed from: h  reason: collision with root package name */
    private final int f7600h = e.f5573a.a(this, R.dimen.md_dialog_frame_margin_vertical);

    /* renamed from: i  reason: collision with root package name */
    private final int f7601i = e.f5573a.a(this, R.dimen.md_dialog_frame_margin_vertical_less);

    /* renamed from: j  reason: collision with root package name */
    private DialogActionButtonLayout f7602j;

    /* renamed from: k  reason: collision with root package name */
    private LayoutMode f7603k = LayoutMode.WRAP_CONTENT;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7604l = true;

    /* renamed from: m  reason: collision with root package name */
    private int f7605m = -1;

    /* renamed from: n  reason: collision with root package name */
    private final Path f7606n = new Path();

    /* renamed from: o  reason: collision with root package name */
    private final RectF f7607o = new RectF();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    private final Paint a(int i2, float f2) {
        if (this.f7599g == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(c.a(this, 1));
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            this.f7599g = paint;
        }
        Paint paint2 = this.f7599g;
        if (paint2 == null) {
            h.a();
        }
        paint2.setColor(i2);
        setAlpha(f2);
        return paint2;
    }

    static /* synthetic */ Paint a(DialogLayout dialogLayout, int i2, float f2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = 1.0f;
        }
        return dialogLayout.a(i2, f2);
    }

    private final void a(Canvas canvas, int i2, float f2, float f3) {
        a(canvas, i2, f2, f3, 0.0f, (float) getMeasuredHeight());
    }

    private final void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5) {
        canvas.drawLine(f2, f4, f3, f5, a(this, i2, 0.0f, 2, (Object) null));
    }

    private final void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6) {
        canvas.drawRect(f3, f5, f4, f6, a(i2, f2));
    }

    static /* synthetic */ void a(DialogLayout dialogLayout, Canvas canvas, int i2, float f2, float f3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f3 = f2;
        }
        dialogLayout.a(canvas, i2, f2, f3);
    }

    private final void b(Canvas canvas, int i2, float f2, float f3) {
        a(canvas, i2, 0.0f, (float) getMeasuredWidth(), f2, f3);
    }

    static /* synthetic */ void b(DialogLayout dialogLayout, Canvas canvas, int i2, float f2, float f3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = (float) dialogLayout.getMeasuredHeight();
        }
        if ((i3 & 4) != 0) {
            f3 = f2;
        }
        dialogLayout.b(canvas, i2, f2, f3);
    }

    public final void a(b bVar) {
        h.c(bVar, "dialog");
        DialogTitleLayout dialogTitleLayout = this.f7594b;
        if (dialogTitleLayout == null) {
            h.b("titleLayout");
        }
        dialogTitleLayout.setDialog(bVar);
        DialogActionButtonLayout dialogActionButtonLayout = this.f7602j;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDialog(bVar);
        }
    }

    public final void a(boolean z2, boolean z3) {
        DialogTitleLayout dialogTitleLayout = this.f7594b;
        if (dialogTitleLayout == null) {
            h.b("titleLayout");
        }
        dialogTitleLayout.setDrawDivider(z2);
        DialogActionButtonLayout dialogActionButtonLayout = this.f7602j;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDrawDivider(z3);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        h.c(canvas, "canvas");
        if (!(this.f7598f.length == 0)) {
            canvas.clipPath(this.f7606n);
        }
        super.dispatchDraw(canvas);
    }

    public final DialogActionButtonLayout getButtonsLayout() {
        return this.f7602j;
    }

    public final DialogContentLayout getContentLayout() {
        DialogContentLayout dialogContentLayout = this.f7595c;
        if (dialogContentLayout == null) {
            h.b("contentLayout");
        }
        return dialogContentLayout;
    }

    public final float[] getCornerRadii() {
        return this.f7598f;
    }

    public final boolean getDebugMode() {
        return this.f7597e;
    }

    public final b getDialog() {
        b bVar = this.f7593a;
        if (bVar == null) {
            h.b("dialog");
        }
        return bVar;
    }

    public final int getFrameMarginVertical$core() {
        return this.f7600h;
    }

    public final int getFrameMarginVerticalLess$core() {
        return this.f7601i;
    }

    public final LayoutMode getLayoutMode() {
        return this.f7603k;
    }

    public final int getMaxHeight() {
        return this.f7596d;
    }

    public final DialogTitleLayout getTitleLayout() {
        DialogTitleLayout dialogTitleLayout = this.f7594b;
        if (dialogTitleLayout == null) {
            h.b("titleLayout");
        }
        return dialogTitleLayout;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            this.f7605m = e.f5573a.a((WindowManager) systemService).d().intValue();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Object obj;
        int i2;
        float f2;
        float f3;
        int i3;
        Canvas canvas2;
        DialogLayout dialogLayout;
        h.c(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f7597e) {
            Canvas canvas3 = canvas;
            a(this, canvas3, -16776961, c.a(this, 24), 0.0f, 4, (Object) null);
            b(this, canvas3, -16776961, c.a(this, 24), 0.0f, 4, (Object) null);
            a(this, canvas, -16776961, ((float) getMeasuredWidth()) - c.a(this, 24), 0.0f, 4, (Object) null);
            DialogTitleLayout dialogTitleLayout = this.f7594b;
            if (dialogTitleLayout == null) {
                h.b("titleLayout");
            }
            if (f.a(dialogTitleLayout)) {
                DialogTitleLayout dialogTitleLayout2 = this.f7594b;
                if (dialogTitleLayout2 == null) {
                    h.b("titleLayout");
                }
                b(this, canvas, -65536, (float) dialogTitleLayout2.getBottom(), 0.0f, 4, (Object) null);
            }
            DialogContentLayout dialogContentLayout = this.f7595c;
            if (dialogContentLayout == null) {
                h.b("contentLayout");
            }
            if (f.a(dialogContentLayout)) {
                DialogContentLayout dialogContentLayout2 = this.f7595c;
                if (dialogContentLayout2 == null) {
                    h.b("contentLayout");
                }
                b(this, canvas, -256, (float) dialogContentLayout2.getTop(), 0.0f, 4, (Object) null);
            }
            if (a.a(this.f7602j)) {
                a(this, canvas, -16711681, f.c(this) ? c.a(this, 8) : ((float) getMeasuredWidth()) - c.a(this, 8), 0.0f, 4, (Object) null);
                DialogActionButtonLayout dialogActionButtonLayout = this.f7602j;
                if (dialogActionButtonLayout == null || !dialogActionButtonLayout.getStackButtons$core()) {
                    DialogActionButtonLayout dialogActionButtonLayout2 = this.f7602j;
                    if (dialogActionButtonLayout2 != null) {
                        if (dialogActionButtonLayout2 == null) {
                            h.a();
                        }
                        for (DialogActionButton dialogActionButton : dialogActionButtonLayout2.getVisibleButtons()) {
                            DialogActionButtonLayout dialogActionButtonLayout3 = this.f7602j;
                            if (dialogActionButtonLayout3 == null) {
                                h.a();
                            }
                            float top = ((float) dialogActionButtonLayout3.getTop()) + ((float) dialogActionButton.getTop()) + c.a(this, 8);
                            DialogActionButtonLayout dialogActionButtonLayout4 = this.f7602j;
                            if (dialogActionButtonLayout4 == null) {
                                h.a();
                            }
                            a(canvas, -16711681, 0.4f, ((float) dialogActionButton.getLeft()) + c.a(this, 4), ((float) dialogActionButton.getRight()) - c.a(this, 4), top, ((float) dialogActionButtonLayout4.getBottom()) - c.a(this, 8));
                        }
                        DialogActionButtonLayout dialogActionButtonLayout5 = this.f7602j;
                        if (dialogActionButtonLayout5 == null) {
                            h.a();
                        }
                        f2 = 0.0f;
                        i2 = 4;
                        obj = null;
                        b(this, canvas, -65281, (float) dialogActionButtonLayout5.getTop(), 0.0f, 4, (Object) null);
                        float measuredHeight = ((float) getMeasuredHeight()) - (c.a(this, 52) - c.a(this, 8));
                        float measuredHeight2 = ((float) getMeasuredHeight()) - c.a(this, 8);
                        canvas2 = canvas;
                        b(this, canvas2, -65536, measuredHeight, 0.0f, 4, (Object) null);
                        b(this, canvas2, -65536, measuredHeight2, 0.0f, 4, (Object) null);
                        i3 = -16776961;
                        f3 = measuredHeight - c.a(this, 8);
                        dialogLayout = this;
                    } else {
                        return;
                    }
                } else {
                    DialogActionButtonLayout dialogActionButtonLayout6 = this.f7602j;
                    if (dialogActionButtonLayout6 == null) {
                        h.a();
                    }
                    float top2 = ((float) dialogActionButtonLayout6.getTop()) + c.a(this, 8);
                    DialogActionButtonLayout dialogActionButtonLayout7 = this.f7602j;
                    if (dialogActionButtonLayout7 == null) {
                        h.a();
                    }
                    float f4 = top2;
                    for (DialogActionButton left : dialogActionButtonLayout7.getVisibleButtons()) {
                        float a2 = f4 + c.a(this, 36);
                        a(canvas, -16711681, 0.4f, (float) left.getLeft(), ((float) getMeasuredWidth()) - c.a(this, 8), f4, a2);
                        f4 = a2 + c.a(this, 16);
                    }
                    DialogActionButtonLayout dialogActionButtonLayout8 = this.f7602j;
                    if (dialogActionButtonLayout8 == null) {
                        h.a();
                    }
                    b(this, canvas, -16776961, (float) dialogActionButtonLayout8.getTop(), 0.0f, 4, (Object) null);
                    DialogActionButtonLayout dialogActionButtonLayout9 = this.f7602j;
                    if (dialogActionButtonLayout9 == null) {
                        h.a();
                    }
                    float top3 = ((float) dialogActionButtonLayout9.getTop()) + c.a(this, 8);
                    float measuredHeight3 = ((float) getMeasuredHeight()) - c.a(this, 8);
                    i3 = -65536;
                    f2 = 0.0f;
                    i2 = 4;
                    obj = null;
                    dialogLayout = this;
                    canvas2 = canvas;
                    b(dialogLayout, canvas2, -65536, top3, 0.0f, 4, (Object) null);
                    f3 = measuredHeight3;
                }
                b(dialogLayout, canvas2, i3, f3, f2, i2, obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_title_layout);
        h.a((Object) findViewById, "findViewById(R.id.md_title_layout)");
        this.f7594b = (DialogTitleLayout) findViewById;
        View findViewById2 = findViewById(R.id.md_content_layout);
        h.a((Object) findViewById2, "findViewById(R.id.md_content_layout)");
        this.f7595c = (DialogContentLayout) findViewById2;
        this.f7602j = (DialogActionButtonLayout) findViewById(R.id.md_button_layout);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int measuredWidth = getMeasuredWidth();
        DialogTitleLayout dialogTitleLayout = this.f7594b;
        if (dialogTitleLayout == null) {
            h.b("titleLayout");
        }
        int measuredHeight = dialogTitleLayout.getMeasuredHeight();
        DialogTitleLayout dialogTitleLayout2 = this.f7594b;
        if (dialogTitleLayout2 == null) {
            h.b("titleLayout");
        }
        dialogTitleLayout2.layout(0, 0, measuredWidth, measuredHeight);
        if (this.f7604l) {
            int measuredHeight2 = getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout = this.f7602j;
            i6 = measuredHeight2 - (dialogActionButtonLayout != null ? dialogActionButtonLayout.getMeasuredHeight() : 0);
            if (a.a(this.f7602j)) {
                int measuredWidth2 = getMeasuredWidth();
                int measuredHeight3 = getMeasuredHeight();
                DialogActionButtonLayout dialogActionButtonLayout2 = this.f7602j;
                if (dialogActionButtonLayout2 == null) {
                    h.a();
                }
                dialogActionButtonLayout2.layout(0, i6, measuredWidth2, measuredHeight3);
            }
        } else {
            i6 = getMeasuredHeight();
        }
        int measuredWidth3 = getMeasuredWidth();
        DialogContentLayout dialogContentLayout = this.f7595c;
        if (dialogContentLayout == null) {
            h.b("contentLayout");
        }
        dialogContentLayout.layout(0, measuredHeight, measuredWidth3, i6);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.f7596d;
        if (1 <= i5 && size2 > i5) {
            size2 = i5;
        }
        DialogTitleLayout dialogTitleLayout = this.f7594b;
        if (dialogTitleLayout == null) {
            h.b("titleLayout");
        }
        boolean z2 = false;
        dialogTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (a.a(this.f7602j)) {
            DialogActionButtonLayout dialogActionButtonLayout = this.f7602j;
            if (dialogActionButtonLayout == null) {
                h.a();
            }
            dialogActionButtonLayout.measure(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        DialogTitleLayout dialogTitleLayout2 = this.f7594b;
        if (dialogTitleLayout2 == null) {
            h.b("titleLayout");
        }
        int measuredHeight = dialogTitleLayout2.getMeasuredHeight();
        DialogActionButtonLayout dialogActionButtonLayout2 = this.f7602j;
        int measuredHeight2 = size2 - (measuredHeight + (dialogActionButtonLayout2 != null ? dialogActionButtonLayout2.getMeasuredHeight() : 0));
        DialogContentLayout dialogContentLayout = this.f7595c;
        if (dialogContentLayout == null) {
            h.b("contentLayout");
        }
        dialogContentLayout.measure(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(measuredHeight2, Integer.MIN_VALUE));
        if (this.f7603k == LayoutMode.WRAP_CONTENT) {
            DialogTitleLayout dialogTitleLayout3 = this.f7594b;
            if (dialogTitleLayout3 == null) {
                h.b("titleLayout");
            }
            int measuredHeight3 = dialogTitleLayout3.getMeasuredHeight();
            DialogContentLayout dialogContentLayout2 = this.f7595c;
            if (dialogContentLayout2 == null) {
                h.b("contentLayout");
            }
            int measuredHeight4 = measuredHeight3 + dialogContentLayout2.getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout3 = this.f7602j;
            i4 = measuredHeight4 + (dialogActionButtonLayout3 != null ? dialogActionButtonLayout3.getMeasuredHeight() : 0);
        } else {
            i4 = this.f7605m;
        }
        setMeasuredDimension(size, i4);
        if (this.f7598f.length == 0) {
            z2 = true;
        }
        if (!z2) {
            RectF rectF = this.f7607o;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = (float) getMeasuredWidth();
            rectF.bottom = (float) getMeasuredHeight();
            this.f7606n.addRoundRect(this.f7607o, this.f7598f, Path.Direction.CW);
        }
    }

    public final void setButtonsLayout(DialogActionButtonLayout dialogActionButtonLayout) {
        this.f7602j = dialogActionButtonLayout;
    }

    public final void setContentLayout(DialogContentLayout dialogContentLayout) {
        h.c(dialogContentLayout, "<set-?>");
        this.f7595c = dialogContentLayout;
    }

    public final void setCornerRadii(float[] fArr) {
        h.c(fArr, "value");
        this.f7598f = fArr;
        if (!this.f7606n.isEmpty()) {
            this.f7606n.reset();
        }
        invalidate();
    }

    public final void setDebugMode(boolean z2) {
        this.f7597e = z2;
        setWillNotDraw(!z2);
    }

    public final void setDialog(b bVar) {
        h.c(bVar, "<set-?>");
        this.f7593a = bVar;
    }

    public final void setLayoutMode(LayoutMode layoutMode) {
        h.c(layoutMode, "<set-?>");
        this.f7603k = layoutMode;
    }

    public final void setMaxHeight(int i2) {
        this.f7596d = i2;
    }

    public final void setTitleLayout(DialogTitleLayout dialogTitleLayout) {
        h.c(dialogTitleLayout, "<set-?>");
        this.f7594b = dialogTitleLayout;
    }
}
