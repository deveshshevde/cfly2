package lj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import java.util.Arrays;

public class d extends PopupWindow implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f30872a;

    /* renamed from: b  reason: collision with root package name */
    private a f30873b;

    /* renamed from: c  reason: collision with root package name */
    private CheckedTextView f30874c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f30875d;

    /* renamed from: e  reason: collision with root package name */
    private CheckedTextView f30876e;

    /* renamed from: f  reason: collision with root package name */
    private CheckedTextView f30877f;

    /* renamed from: g  reason: collision with root package name */
    private CheckedTextView f30878g;

    /* renamed from: h  reason: collision with root package name */
    private CheckedTextView f30879h;

    /* renamed from: i  reason: collision with root package name */
    private CheckedTextView f30880i;

    public interface a {
        void a(int i2);
    }

    public d(Activity activity, a aVar) {
        super(activity);
        this.f30873b = aVar;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.wifi_pop_layout, (ViewGroup) null);
        this.f30872a = (LinearLayout) inflate.findViewById(R.id.pop_ll);
        this.f30874c = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_off);
        this.f30875d = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_36);
        this.f30876e = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_149);
        this.f30877f = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_153);
        this.f30878g = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_157);
        this.f30879h = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_161);
        this.f30880i = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_165);
        if (((XEagleApp) activity.getApplicationContext()).j().aH()) {
            this.f30875d.setVisibility(0);
        } else {
            this.f30875d.setVisibility(8);
        }
        this.f30874c.setOnClickListener(this);
        this.f30875d.setOnClickListener(this);
        this.f30876e.setOnClickListener(this);
        this.f30877f.setOnClickListener(this);
        this.f30878g.setOnClickListener(this);
        this.f30879h.setOnClickListener(this);
        this.f30880i.setOnClickListener(this);
        setContentView(inflate);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.roundcorner));
        setWidth(activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dp_100));
        setHeight(-2);
        setFocusable(false);
    }

    private void a() {
        this.f30874c.setChecked(false);
        this.f30875d.setChecked(false);
        this.f30876e.setChecked(false);
        this.f30877f.setChecked(false);
        this.f30878g.setChecked(false);
        this.f30879h.setChecked(false);
        this.f30880i.setChecked(false);
    }

    private void b() {
        LinearLayout linearLayout = this.f30872a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{(float) (-linearLayout.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    private void c() {
        LinearLayout linearLayout = this.f30872a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) (-linearLayout.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                d.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                d.this.f30872a.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    public void a(int i2) {
        CheckedTextView checkedTextView;
        a();
        switch (i2) {
            case 0:
                checkedTextView = this.f30874c;
                break;
            case 1:
                checkedTextView = this.f30876e;
                break;
            case 2:
                checkedTextView = this.f30877f;
                break;
            case 3:
                checkedTextView = this.f30878g;
                break;
            case 4:
                checkedTextView = this.f30879h;
                break;
            case 5:
                checkedTextView = this.f30880i;
                break;
            case 6:
                checkedTextView = this.f30875d;
                break;
            default:
                return;
        }
        checkedTextView.setChecked(true);
    }

    public void a(Context context, String str) {
        a(Arrays.asList(context.getResources().getStringArray(R.array.wifi_channel)).indexOf(str));
    }

    public void dismiss() {
        c();
    }

    public void onClick(View view) {
        int i2;
        a aVar;
        int id2 = view.getId();
        if (id2 != R.id.tv_wifi_off) {
            switch (id2) {
                case R.id.tv_wifi_149:
                    i2 = 1;
                    a(1);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_153:
                    i2 = 2;
                    a(2);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_157:
                    i2 = 3;
                    a(3);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_161:
                    i2 = 4;
                    a(4);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_165:
                    i2 = 5;
                    a(5);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_36:
                    i2 = 6;
                    a(6);
                    aVar = this.f30873b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                default:
                    return;
            }
        } else {
            i2 = 0;
            a(0);
            aVar = this.f30873b;
            if (aVar == null) {
                return;
            }
        }
        aVar.a(i2);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
        b();
    }
}
