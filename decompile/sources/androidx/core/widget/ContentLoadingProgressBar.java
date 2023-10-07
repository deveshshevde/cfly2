package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f3004a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3005b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3006c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3007d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f3008e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f3009f;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3004a = -1;
        this.f3005b = false;
        this.f3006c = false;
        this.f3007d = false;
        this.f3008e = new Runnable() {
            public final void run() {
                ContentLoadingProgressBar.this.c();
            }
        };
        this.f3009f = new Runnable() {
            public final void run() {
                ContentLoadingProgressBar.this.b();
            }
        };
    }

    private void a() {
        removeCallbacks(this.f3008e);
        removeCallbacks(this.f3009f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f3006c = false;
        if (!this.f3007d) {
            this.f3004a = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f3005b = false;
        this.f3004a = -1;
        setVisibility(8);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
