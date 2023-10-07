package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ay.e;
import ay.f;
import com.afollestad.materialdialogs.R;
import com.blankj.utilcode.constant.MemoryConstants;
import kotlin.jvm.internal.h;
import mr.d;

public final class DialogTitleLayout extends BaseSubLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f7610a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f7611b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7612c = e.f5573a.a(this, R.dimen.md_dialog_frame_margin_vertical);

    /* renamed from: e  reason: collision with root package name */
    private final int f7613e = e.f5573a.a(this, R.dimen.md_dialog_title_layout_margin_bottom);

    /* renamed from: f  reason: collision with root package name */
    private final int f7614f = e.f5573a.a(this, R.dimen.md_dialog_frame_margin_horizontal);

    /* renamed from: g  reason: collision with root package name */
    private final int f7615g = e.f5573a.a(this, R.dimen.md_icon_margin);

    /* renamed from: h  reason: collision with root package name */
    private final int f7616h = e.f5573a.a(this, R.dimen.md_icon_size);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    public final boolean b() {
        ImageView imageView = this.f7610a;
        if (imageView == null) {
            h.b("iconView");
        }
        if (f.b(imageView)) {
            TextView textView = this.f7611b;
            if (textView == null) {
                h.b("titleView");
            }
            if (f.b(textView)) {
                return true;
            }
        }
        return false;
    }

    public final ImageView getIconView$core() {
        ImageView imageView = this.f7610a;
        if (imageView == null) {
            h.b("iconView");
        }
        return imageView;
    }

    public final TextView getTitleView$core() {
        TextView textView = this.f7611b;
        if (textView == null) {
            h.b("titleView");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        h.c(canvas, "canvas");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, ((float) getMeasuredHeight()) - ((float) getDividerHeight()), (float) getMeasuredWidth(), (float) getMeasuredHeight(), a());
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_icon_title);
        h.a((Object) findViewById, "findViewById(R.id.md_icon_title)");
        this.f7610a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.md_text_title);
        h.a((Object) findViewById2, "findViewById(R.id.md_text_title)");
        this.f7611b = (TextView) findViewById2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!b()) {
            int i10 = this.f7612c;
            int measuredHeight = getMeasuredHeight() - this.f7613e;
            int i11 = measuredHeight - ((measuredHeight - i10) / 2);
            TextView textView = this.f7611b;
            if (textView == null) {
                h.b("titleView");
            }
            int measuredHeight2 = textView.getMeasuredHeight() / 2;
            int i12 = i11 - measuredHeight2;
            int i13 = measuredHeight2 + i11;
            e eVar = e.f5573a;
            TextView textView2 = this.f7611b;
            if (textView2 == null) {
                h.b("titleView");
            }
            int a2 = i13 + eVar.a(textView2);
            if (f.c(this)) {
                i6 = getMeasuredWidth() - this.f7614f;
                TextView textView3 = this.f7611b;
                if (textView3 == null) {
                    h.b("titleView");
                }
                i7 = i6 - textView3.getMeasuredWidth();
            } else {
                i7 = this.f7614f;
                TextView textView4 = this.f7611b;
                if (textView4 == null) {
                    h.b("titleView");
                }
                i6 = textView4.getMeasuredWidth() + i7;
            }
            ImageView imageView = this.f7610a;
            if (imageView == null) {
                h.b("iconView");
            }
            if (f.a(imageView)) {
                ImageView imageView2 = this.f7610a;
                if (imageView2 == null) {
                    h.b("iconView");
                }
                int measuredHeight3 = imageView2.getMeasuredHeight() / 2;
                int i14 = i11 - measuredHeight3;
                int i15 = i11 + measuredHeight3;
                if (f.c(this)) {
                    ImageView imageView3 = this.f7610a;
                    if (imageView3 == null) {
                        h.b("iconView");
                    }
                    i7 = i6 - imageView3.getMeasuredWidth();
                    i9 = i7 - this.f7615g;
                    TextView textView5 = this.f7611b;
                    if (textView5 == null) {
                        h.b("titleView");
                    }
                    i8 = i9 - textView5.getMeasuredWidth();
                } else {
                    ImageView imageView4 = this.f7610a;
                    if (imageView4 == null) {
                        h.b("iconView");
                    }
                    i6 = imageView4.getMeasuredWidth() + i7;
                    int i16 = this.f7615g + i6;
                    TextView textView6 = this.f7611b;
                    if (textView6 == null) {
                        h.b("titleView");
                    }
                    int measuredWidth = textView6.getMeasuredWidth() + i16;
                    i8 = i16;
                    i9 = measuredWidth;
                }
                ImageView imageView5 = this.f7610a;
                if (imageView5 == null) {
                    h.b("iconView");
                }
                imageView5.layout(i7, i14, i6, i15);
                i6 = i9;
                i7 = i8;
            }
            TextView textView7 = this.f7611b;
            if (textView7 == null) {
                h.b("titleView");
            }
            textView7.layout(i7, i12, i6, a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = 0;
        if (b()) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = size - (this.f7614f * 2);
        ImageView imageView = this.f7610a;
        if (imageView == null) {
            h.b("iconView");
        }
        if (f.a(imageView)) {
            ImageView imageView2 = this.f7610a;
            if (imageView2 == null) {
                h.b("iconView");
            }
            imageView2.measure(View.MeasureSpec.makeMeasureSpec(this.f7616h, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.f7616h, MemoryConstants.GB));
            ImageView imageView3 = this.f7610a;
            if (imageView3 == null) {
                h.b("iconView");
            }
            i5 -= imageView3.getMeasuredWidth() + this.f7615g;
        }
        TextView textView = this.f7611b;
        if (textView == null) {
            h.b("titleView");
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        ImageView imageView4 = this.f7610a;
        if (imageView4 == null) {
            h.b("iconView");
        }
        if (f.a(imageView4)) {
            ImageView imageView5 = this.f7610a;
            if (imageView5 == null) {
                h.b("iconView");
            }
            i4 = imageView5.getMeasuredHeight();
        }
        TextView textView2 = this.f7611b;
        if (textView2 == null) {
            h.b("titleView");
        }
        setMeasuredDimension(size, d.c(i4, textView2.getMeasuredHeight()) + this.f7612c + this.f7613e);
    }

    public final void setIconView$core(ImageView imageView) {
        h.c(imageView, "<set-?>");
        this.f7610a = imageView;
    }

    public final void setTitleView$core(TextView textView) {
        h.c(textView, "<set-?>");
        this.f7611b = textView;
    }
}
