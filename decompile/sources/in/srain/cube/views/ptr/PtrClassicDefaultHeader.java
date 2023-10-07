package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xeagle.android.login.common.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PtrClassicDefaultHeader extends FrameLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f13628a = new SimpleDateFormat(TimeUtil.DEF_FORMAT);

    /* renamed from: b  reason: collision with root package name */
    private int f13629b = 150;

    /* renamed from: c  reason: collision with root package name */
    private RotateAnimation f13630c;

    /* renamed from: d  reason: collision with root package name */
    private RotateAnimation f13631d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13632e;

    /* renamed from: f  reason: collision with root package name */
    private View f13633f;

    /* renamed from: g  reason: collision with root package name */
    private View f13634g;

    /* renamed from: h  reason: collision with root package name */
    private long f13635h = -1;

    /* renamed from: i  reason: collision with root package name */
    private TextView f13636i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f13637j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13638k;

    /* renamed from: l  reason: collision with root package name */
    private a f13639l = new a();

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f13641b;

        private a() {
            this.f13641b = false;
        }

        /* access modifiers changed from: private */
        public void a() {
            if (!TextUtils.isEmpty(PtrClassicDefaultHeader.this.f13637j)) {
                this.f13641b = true;
                run();
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f13641b = false;
            PtrClassicDefaultHeader.this.removeCallbacks(this);
        }

        public void run() {
            PtrClassicDefaultHeader.this.d();
            if (this.f13641b) {
                PtrClassicDefaultHeader.this.postDelayed(this, 1000);
            }
        }
    }

    public PtrClassicDefaultHeader(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f13630c = rotateAnimation;
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f13630c.setDuration((long) this.f13629b);
        this.f13630c.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f13631d = rotateAnimation2;
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        this.f13631d.setDuration((long) this.f13629b);
        this.f13631d.setFillAfter(true);
    }

    private void b() {
        c();
        this.f13634g.setVisibility(4);
    }

    private void c() {
        this.f13633f.clearAnimation();
        this.f13633f.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (!TextUtils.isEmpty(this.f13637j) && this.f13638k) {
            String lastUpdateTime = getLastUpdateTime();
            if (!TextUtils.isEmpty(lastUpdateTime)) {
                this.f13636i.setVisibility(0);
                this.f13636i.setText(lastUpdateTime);
                return;
            }
        }
        this.f13636i.setVisibility(8);
    }

    private void e(PtrFrameLayout ptrFrameLayout) {
        if (!ptrFrameLayout.f()) {
            this.f13632e.setVisibility(0);
            this.f13632e.setText(R.string.cube_ptr_release_to_refresh);
        }
    }

    private void f(PtrFrameLayout ptrFrameLayout) {
        TextView textView;
        int i2;
        Resources resources;
        this.f13632e.setVisibility(0);
        if (ptrFrameLayout.f()) {
            textView = this.f13632e;
            resources = getResources();
            i2 = R.string.cube_ptr_pull_down_to_refresh;
        } else {
            textView = this.f13632e;
            resources = getResources();
            i2 = R.string.cube_ptr_pull_down;
        }
        textView.setText(resources.getString(i2));
    }

    private String getLastUpdateTime() {
        StringBuilder sb;
        Context context;
        int i2;
        String format;
        if (this.f13635h == -1 && !TextUtils.isEmpty(this.f13637j)) {
            this.f13635h = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0).getLong(this.f13637j, -1);
        }
        if (this.f13635h == -1) {
            return null;
        }
        long time = new Date().getTime() - this.f13635h;
        int i3 = (int) (time / 1000);
        if (time < 0 || i3 <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getContext().getString(R.string.cube_ptr_last_update));
        if (i3 < 60) {
            sb = new StringBuilder();
            sb.append(i3);
            context = getContext();
            i2 = R.string.cube_ptr_seconds_ago;
        } else {
            int i4 = i3 / 60;
            if (i4 > 60) {
                int i5 = i4 / 60;
                if (i5 > 24) {
                    format = f13628a.format(new Date(this.f13635h));
                    sb2.append(format);
                    return sb2.toString();
                }
                sb = new StringBuilder();
                sb.append(i5);
                context = getContext();
                i2 = R.string.cube_ptr_hours_ago;
            } else {
                sb = new StringBuilder();
                sb.append(i4);
                context = getContext();
                i2 = R.string.cube_ptr_minutes_ago;
            }
        }
        sb.append(context.getString(i2));
        format = sb.toString();
        sb2.append(format);
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PtrClassicHeader, 0, 0);
        if (obtainStyledAttributes != null) {
            this.f13629b = obtainStyledAttributes.getInt(R.styleable.PtrClassicHeader_ptr_rotate_ani_time, this.f13629b);
        }
        a();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cube_ptr_classic_default_header, this);
        this.f13633f = inflate.findViewById(R.id.ptr_classic_header_rotate_view);
        this.f13632e = (TextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_title);
        this.f13636i = (TextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_last_update);
        this.f13634g = inflate.findViewById(R.id.ptr_classic_header_rotate_view_progressbar);
        b();
    }

    public void a(PtrFrameLayout ptrFrameLayout) {
        b();
        this.f13638k = true;
        d();
    }

    public void a(PtrFrameLayout ptrFrameLayout, boolean z2, byte b2, lq.a aVar) {
        View view;
        RotateAnimation rotateAnimation;
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        int k2 = aVar.k();
        int j2 = aVar.j();
        if (k2 >= offsetToRefresh || j2 < offsetToRefresh) {
            if (k2 > offsetToRefresh && j2 <= offsetToRefresh && z2 && b2 == 2) {
                e(ptrFrameLayout);
                View view2 = this.f13633f;
                if (view2 != null) {
                    view2.clearAnimation();
                    view = this.f13633f;
                    rotateAnimation = this.f13630c;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (z2 && b2 == 2) {
            f(ptrFrameLayout);
            View view3 = this.f13633f;
            if (view3 != null) {
                view3.clearAnimation();
                view = this.f13633f;
                rotateAnimation = this.f13631d;
            } else {
                return;
            }
        } else {
            return;
        }
        view.startAnimation(rotateAnimation);
    }

    public void b(PtrFrameLayout ptrFrameLayout) {
        TextView textView;
        int i2;
        Resources resources;
        this.f13638k = true;
        d();
        this.f13639l.a();
        this.f13634g.setVisibility(4);
        this.f13633f.setVisibility(0);
        this.f13632e.setVisibility(0);
        if (ptrFrameLayout.f()) {
            textView = this.f13632e;
            resources = getResources();
            i2 = R.string.cube_ptr_pull_down_to_refresh;
        } else {
            textView = this.f13632e;
            resources = getResources();
            i2 = R.string.cube_ptr_pull_down;
        }
        textView.setText(resources.getString(i2));
    }

    public void c(PtrFrameLayout ptrFrameLayout) {
        this.f13638k = false;
        c();
        this.f13634g.setVisibility(0);
        this.f13632e.setVisibility(0);
        this.f13632e.setText(R.string.cube_ptr_refreshing);
        d();
        this.f13639l.b();
    }

    public void d(PtrFrameLayout ptrFrameLayout) {
        c();
        this.f13634g.setVisibility(4);
        this.f13632e.setVisibility(0);
        this.f13632e.setText(getResources().getString(R.string.cube_ptr_refresh_complete));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0);
        if (!TextUtils.isEmpty(this.f13637j)) {
            this.f13635h = new Date().getTime();
            sharedPreferences.edit().putLong(this.f13637j, this.f13635h).commit();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f13639l;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setLastUpdateTimeKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13637j = str;
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        setLastUpdateTimeKey(obj.getClass().getName());
    }

    public void setRotateAniTime(int i2) {
        if (i2 != this.f13629b && i2 != 0) {
            this.f13629b = i2;
            a();
        }
    }
}
