package com.afollestad.materialdialogs.color.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ay.e;
import com.afollestad.materialdialogs.color.R;
import fg.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import t.ac;

public final class PreviewFrameView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7541a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private View f7542b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f7543c;

    /* renamed from: d  reason: collision with root package name */
    private ObservableEditText f7544d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7545e = true;

    /* renamed from: f  reason: collision with root package name */
    private mm.b<? super Integer, Boolean> f7546f = PreviewFrameView$onHexChanged$1.f7550a;

    /* renamed from: g  reason: collision with root package name */
    private Integer f7547g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PreviewFrameView f7548a;

        b(PreviewFrameView previewFrameView) {
            this.f7548a = previewFrameView;
        }

        public final void run() {
            PreviewFrameView.a(this.f7548a).setSelection(PreviewFrameView.a(this.f7548a).getTextLength());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        setBackgroundResource(R.drawable.transparent_rect_repeat);
        LayoutInflater.from(context).inflate(R.layout.md_color_chooser_preview_frame, this);
    }

    private final int a(int i2) {
        return (!e.a(e.f5573a, i2, (double) i.f27244a, 1, (Object) null) || Color.alpha(i2) < 50) ? -16777216 : -1;
    }

    public static final /* synthetic */ ObservableEditText a(PreviewFrameView previewFrameView) {
        ObservableEditText observableEditText = previewFrameView.f7544d;
        if (observableEditText == null) {
            h.b("hexValueView");
        }
        return observableEditText;
    }

    public final Integer getColor() {
        return this.f7547g;
    }

    public final mm.b<Integer, Boolean> getOnHexChanged() {
        return this.f7546f;
    }

    public final boolean getSupportCustomAlpha() {
        return this.f7545e;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.argbView);
        h.a((Object) findViewById, "findViewById(R.id.argbView)");
        this.f7542b = findViewById;
        View findViewById2 = findViewById(R.id.hexPrefixView);
        h.a((Object) findViewById2, "findViewById(R.id.hexPrefixView)");
        this.f7543c = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.hexValueView);
        h.a((Object) findViewById3, "findViewById(R.id.hexValueView)");
        ObservableEditText observableEditText = (ObservableEditText) findViewById3;
        this.f7544d = observableEditText;
        if (observableEditText == null) {
            h.b("hexValueView");
        }
        observableEditText.a((mm.b<? super String, l>) new PreviewFrameView$onFinishInflate$1(this));
    }

    public final void setColor(int i2) {
        Integer num = this.f7547g;
        if (num == null || num.intValue() != i2) {
            this.f7547g = Integer.valueOf(i2);
            View view = this.f7542b;
            if (view == null) {
                h.b("argbView");
            }
            view.setBackground(new ColorDrawable(i2));
            ObservableEditText observableEditText = this.f7544d;
            if (observableEditText == null) {
                h.b("hexValueView");
            }
            observableEditText.a((CharSequence) aw.a.a(i2, this.f7545e));
            ObservableEditText observableEditText2 = this.f7544d;
            if (observableEditText2 == null) {
                h.b("hexValueView");
            }
            observableEditText2.post(new b(this));
            int a2 = a(i2);
            TextView textView = this.f7543c;
            if (textView == null) {
                h.b("hexPrefixView");
            }
            textView.setTextColor(a2);
            ObservableEditText observableEditText3 = this.f7544d;
            if (observableEditText3 == null) {
                h.b("hexValueView");
            }
            observableEditText3.setTextColor(a2);
            ObservableEditText observableEditText4 = this.f7544d;
            if (observableEditText4 == null) {
                h.b("hexValueView");
            }
            ac.a((View) observableEditText4, ColorStateList.valueOf(a2));
        }
    }

    public final void setOnHexChanged(mm.b<? super Integer, Boolean> bVar) {
        h.c(bVar, "<set-?>");
        this.f7546f = bVar;
    }

    public final void setSupportCustomAlpha(boolean z2) {
        this.f7545e = z2;
    }
}
