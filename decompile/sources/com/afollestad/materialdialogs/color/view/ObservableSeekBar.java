package com.afollestad.materialdialogs.color.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class ObservableSeekBar extends AppCompatSeekBar {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b<? super Integer, l> f7536a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7537b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f7538c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7539d = new a(this);

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ObservableSeekBar f7540a;

        a(ObservableSeekBar observableSeekBar) {
            this.f7540a = observableSeekBar;
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            b b2;
            h.c(seekBar, "seekBar");
            if ((!this.f7540a.f7538c || z2) && (b2 = this.f7540a.f7536a) != null) {
                l lVar = (l) b2.invoke(Integer.valueOf(i2));
            }
            this.f7540a.f7537b = false;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObservableSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnSeekBarChangeListener(this.f7539d);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        super.onDetachedFromWindow();
    }
}
