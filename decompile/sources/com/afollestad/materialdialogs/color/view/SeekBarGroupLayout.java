package com.afollestad.materialdialogs.color.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import ay.e;
import com.afollestad.materialdialogs.color.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.h;

public final class SeekBarGroupLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f7551a = e.f5573a.a(this, R.dimen.seekbar_grouplayout_tolerance);

    /* renamed from: b  reason: collision with root package name */
    private List<? extends SeekBar> f7552b = h.a();

    /* renamed from: c  reason: collision with root package name */
    private SeekBar f7553c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekBarGroupLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.h.c(context, "context");
    }

    private final float a(View view) {
        return view.getY() + (((float) view.getMeasuredHeight()) / 2.0f);
    }

    private final SeekBar a(MotionEvent motionEvent) {
        float y2 = motionEvent.getY();
        String str = null;
        SeekBar seekBar = null;
        int i2 = -1;
        for (SeekBar seekBar2 : this.f7552b) {
            int abs = (int) Math.abs(y2 - a((View) seekBar2));
            a("Diff from " + a(seekBar2) + " = " + abs + ", tolerance = " + this.f7551a);
            if (abs <= this.f7551a && (i2 == -1 || abs < i2)) {
                a("New closest: " + a(seekBar2));
                seekBar = seekBar2;
                i2 = abs;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Final closest: ");
        if (seekBar != null) {
            str = a(seekBar);
        }
        sb.append(str);
        a(sb.toString());
        return seekBar;
    }

    private final String a(SeekBar seekBar) {
        if (seekBar == null) {
            return "";
        }
        String resourceEntryName = seekBar.getResources().getResourceEntryName(seekBar.getId());
        kotlin.jvm.internal.h.a((Object) resourceEntryName, "this.resources.getResourceEntryName(this.id)");
        return resourceEntryName;
    }

    private final void a(String str) {
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        List<? extends SeekBar> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof SeekBar)) {
                childAt = null;
            }
            SeekBar seekBar = (SeekBar) childAt;
            if (seekBar != null) {
                arrayList.add(seekBar);
            }
        }
        this.f7552b = arrayList;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SeekBar seekBar;
        kotlin.jvm.internal.h.c(motionEvent, "event");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            SeekBar a2 = a(motionEvent);
            if (a2 != null) {
                a("Grabbed: " + a(a2));
                this.f7553c = a2;
                a2.dispatchTouchEvent(motionEvent);
                return true;
            }
        } else if (actionMasked != 1) {
            if (actionMasked == 2 && (seekBar = this.f7553c) != null) {
                if (seekBar == null) {
                    kotlin.jvm.internal.h.a();
                }
                seekBar.dispatchTouchEvent(motionEvent);
                return true;
            }
        } else if (this.f7553c != null) {
            a("Released: " + a(this.f7553c));
            SeekBar seekBar2 = this.f7553c;
            if (seekBar2 == null) {
                kotlin.jvm.internal.h.a();
            }
            seekBar2.dispatchTouchEvent(motionEvent);
            this.f7553c = null;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
