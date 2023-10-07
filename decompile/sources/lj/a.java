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

public class a extends PopupWindow implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f30849a;

    /* renamed from: b  reason: collision with root package name */
    private C0218a f30850b;

    /* renamed from: c  reason: collision with root package name */
    private CheckedTextView f30851c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f30852d;

    /* renamed from: lj.a$a  reason: collision with other inner class name */
    public interface C0218a {
        void a(int i2);
    }

    public a(Activity activity, C0218a aVar) {
        super(activity);
        this.f30850b = aVar;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.safe_setting_pop_layout, (ViewGroup) null);
        this.f30849a = (LinearLayout) inflate.findViewById(R.id.pop_ll);
        this.f30851c = (CheckedTextView) inflate.findViewById(R.id.tv_action_rtl);
        this.f30852d = (CheckedTextView) inflate.findViewById(R.id.tv_action_land);
        this.f30851c.setOnClickListener(this);
        this.f30852d.setOnClickListener(this);
        setContentView(inflate);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.roundcorner));
        setWidth(activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dp_100));
        setHeight(-2);
        setFocusable(false);
    }

    private void a() {
        this.f30851c.setChecked(false);
        this.f30852d.setChecked(false);
    }

    private void b() {
        LinearLayout linearLayout = this.f30849a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{(float) (-linearLayout.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    private void c() {
        LinearLayout linearLayout = this.f30849a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) (-linearLayout.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                a.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                a.this.f30849a.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    public void a(int i2) {
        CheckedTextView checkedTextView;
        a();
        if (i2 == 0) {
            checkedTextView = this.f30851c;
        } else if (i2 == 1) {
            checkedTextView = this.f30852d;
        } else {
            return;
        }
        checkedTextView.setChecked(true);
    }

    public void a(Context context, String str) {
        a(Arrays.asList(context.getResources().getStringArray(R.array.action_low_battery)).indexOf(str));
    }

    public void dismiss() {
        c();
    }

    public void onClick(View view) {
        int i2;
        C0218a aVar;
        switch (view.getId()) {
            case R.id.tv_action_land:
                i2 = 1;
                a(1);
                aVar = this.f30850b;
                if (aVar == null) {
                    return;
                }
                break;
            case R.id.tv_action_rtl:
                i2 = 0;
                a(0);
                aVar = this.f30850b;
                if (aVar == null) {
                    return;
                }
                break;
            default:
                return;
        }
        aVar.a(i2);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
        b();
    }
}
