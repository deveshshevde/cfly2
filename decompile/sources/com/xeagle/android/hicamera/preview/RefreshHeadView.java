package com.xeagle.android.hicamera.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class RefreshHeadView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f23638a;

    /* renamed from: b  reason: collision with root package name */
    private View f23639b;

    /* renamed from: c  reason: collision with root package name */
    private HiGridView f23640c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f23641d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f23642e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f23643f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup.MarginLayoutParams f23644g;

    /* renamed from: h  reason: collision with root package name */
    private int f23645h;

    /* renamed from: i  reason: collision with root package name */
    private int f23646i = 3;

    /* renamed from: j  reason: collision with root package name */
    private int f23647j = 3;

    /* renamed from: k  reason: collision with root package name */
    private float f23648k = -1.0f;

    /* renamed from: l  reason: collision with root package name */
    private int f23649l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23650m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23651n;

    /* renamed from: o  reason: collision with root package name */
    private DisplayMetrics f23652o = new DisplayMetrics();

    public interface a {
    }

    public RefreshHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh, (ViewGroup) null, true);
        this.f23639b = inflate;
        this.f23641d = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f23642e = (ImageView) this.f23639b.findViewById(R.id.arrow);
        this.f23643f = (TextView) this.f23639b.findViewById(R.id.tvHeadViewMsg);
        this.f23649l = ViewConfiguration.get(context).getScaledTouchSlop();
        setOrientation(1);
        addView(this.f23639b, 0);
        this.f23652o = context.getResources().getDisplayMetrics();
    }

    private void setIsAbleToPull(MotionEvent motionEvent) {
        View childAt = this.f23640c.getChildAt(0);
        if (childAt != null) {
            if (this.f23640c.getFirstVisiblePosition() != 0 || ((-childAt.getTop()) > 10 && !this.f23651n)) {
                int i2 = this.f23644g.topMargin;
                int i3 = this.f23645h;
                if (i2 != i3) {
                    this.f23644g.topMargin = i3;
                    this.f23639b.setLayoutParams(this.f23644g);
                }
                this.f23651n = false;
                return;
            } else if (!this.f23651n) {
                this.f23648k = motionEvent.getRawY();
            }
        }
        this.f23651n = true;
    }

    public HiGridView getScrollView() {
        return this.f23640c;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2 && !this.f23650m) {
            this.f23645h = -this.f23639b.getHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f23639b.getLayoutParams();
            this.f23644g = marginLayoutParams;
            marginLayoutParams.topMargin = this.f23645h;
            this.f23650m = true;
        }
    }

    public void setOnRefreshListener(a aVar) {
        this.f23638a = aVar;
    }
}
