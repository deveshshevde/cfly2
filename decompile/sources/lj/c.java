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
import java.util.Arrays;

public class c extends PopupWindow implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f30861a;

    /* renamed from: b  reason: collision with root package name */
    private a f30862b;

    /* renamed from: c  reason: collision with root package name */
    private CheckedTextView f30863c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f30864d;

    /* renamed from: e  reason: collision with root package name */
    private CheckedTextView f30865e;

    /* renamed from: f  reason: collision with root package name */
    private CheckedTextView f30866f;

    /* renamed from: g  reason: collision with root package name */
    private CheckedTextView f30867g;

    /* renamed from: h  reason: collision with root package name */
    private CheckedTextView f30868h;

    /* renamed from: i  reason: collision with root package name */
    private CheckedTextView f30869i;

    /* renamed from: j  reason: collision with root package name */
    private CheckedTextView f30870j;

    public interface a {
        void a(int i2);
    }

    public c(Activity activity, a aVar) {
        super(activity);
        this.f30862b = aVar;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.usb_wifi_pop, (ViewGroup) null);
        this.f30861a = (LinearLayout) inflate.findViewById(R.id.pop_ll);
        this.f30863c = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_off);
        this.f30864d = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_8);
        this.f30865e = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_9);
        this.f30866f = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_10);
        this.f30867g = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_11);
        this.f30868h = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_12);
        this.f30869i = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_13);
        this.f30870j = (CheckedTextView) inflate.findViewById(R.id.tv_wifi_14);
        this.f30863c.setOnClickListener(this);
        this.f30864d.setOnClickListener(this);
        this.f30865e.setOnClickListener(this);
        this.f30866f.setOnClickListener(this);
        this.f30867g.setOnClickListener(this);
        this.f30868h.setOnClickListener(this);
        this.f30869i.setOnClickListener(this);
        this.f30870j.setOnClickListener(this);
        setContentView(inflate);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.roundcorner));
        setWidth(activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dp_100));
        setHeight(-2);
        setFocusable(false);
    }

    private void a() {
        this.f30863c.setChecked(false);
        this.f30864d.setChecked(false);
        this.f30865e.setChecked(false);
        this.f30866f.setChecked(false);
        this.f30867g.setChecked(false);
        this.f30868h.setChecked(false);
        this.f30869i.setChecked(false);
        this.f30870j.setChecked(false);
    }

    private void b() {
        LinearLayout linearLayout = this.f30861a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{(float) (-linearLayout.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    private void c() {
        LinearLayout linearLayout = this.f30861a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) (-linearLayout.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                c.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                c.this.f30861a.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    public void a(int i2) {
        CheckedTextView checkedTextView;
        a();
        switch (i2) {
            case 0:
                checkedTextView = this.f30863c;
                break;
            case 1:
                checkedTextView = this.f30864d;
                break;
            case 2:
                checkedTextView = this.f30865e;
                break;
            case 3:
                checkedTextView = this.f30866f;
                break;
            case 4:
                checkedTextView = this.f30867g;
                break;
            case 5:
                checkedTextView = this.f30868h;
                break;
            case 6:
                checkedTextView = this.f30869i;
                break;
            case 7:
                checkedTextView = this.f30870j;
                break;
            default:
                return;
        }
        checkedTextView.setChecked(true);
    }

    public void a(Context context, String str) {
        a(Arrays.asList(context.getResources().getStringArray(R.array.usb_wifi_channel)).indexOf(str));
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
                case R.id.tv_wifi_10:
                    i2 = 3;
                    a(3);
                    aVar = this.f30862b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_11:
                    i2 = 4;
                    a(4);
                    aVar = this.f30862b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_12:
                    i2 = 5;
                    a(5);
                    aVar = this.f30862b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_13:
                    i2 = 6;
                    a(6);
                    aVar = this.f30862b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                case R.id.tv_wifi_14:
                    i2 = 7;
                    a(7);
                    aVar = this.f30862b;
                    if (aVar == null) {
                        return;
                    }
                    break;
                default:
                    switch (id2) {
                        case R.id.tv_wifi_8:
                            i2 = 1;
                            a(1);
                            aVar = this.f30862b;
                            if (aVar == null) {
                                return;
                            }
                            break;
                        case R.id.tv_wifi_9:
                            i2 = 2;
                            a(2);
                            aVar = this.f30862b;
                            if (aVar == null) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
            }
        } else {
            i2 = 0;
            a(0);
            aVar = this.f30862b;
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
