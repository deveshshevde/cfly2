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

public class b extends PopupWindow implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f30854a;

    /* renamed from: b  reason: collision with root package name */
    private a f30855b;

    /* renamed from: c  reason: collision with root package name */
    private CheckedTextView f30856c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f30857d;

    /* renamed from: e  reason: collision with root package name */
    private CheckedTextView f30858e;

    /* renamed from: f  reason: collision with root package name */
    private CheckedTextView f30859f;

    public interface a {
        void a(int i2);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        this.f30855b = aVar;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.metering_pop_layout, (ViewGroup) null);
        this.f30854a = (LinearLayout) inflate.findViewById(R.id.pop_ll);
        this.f30856c = (CheckedTextView) inflate.findViewById(R.id.tv_center);
        this.f30857d = (CheckedTextView) inflate.findViewById(R.id.tv_multi);
        this.f30858e = (CheckedTextView) inflate.findViewById(R.id.tv_spot);
        this.f30859f = (CheckedTextView) inflate.findViewById(R.id.tv_fly);
        this.f30856c.setOnClickListener(this);
        this.f30857d.setOnClickListener(this);
        this.f30858e.setOnClickListener(this);
        this.f30859f.setOnClickListener(this);
        setContentView(inflate);
        setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.roundcorner));
        setWidth(activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dp_100));
        setHeight(-2);
        setFocusable(false);
    }

    private void a() {
        this.f30856c.setChecked(false);
        this.f30857d.setChecked(false);
        this.f30858e.setChecked(false);
        this.f30859f.setChecked(false);
    }

    private void b() {
        LinearLayout linearLayout = this.f30854a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{(float) (-linearLayout.getHeight()), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.start();
    }

    private void c() {
        LinearLayout linearLayout = this.f30854a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) (-linearLayout.getHeight())});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(400);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                b.super.dismiss();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                b.this.f30854a.setVisibility(0);
            }
        });
        ofFloat.start();
    }

    public void a(int i2) {
        CheckedTextView checkedTextView;
        a();
        if (i2 == 0) {
            checkedTextView = this.f30856c;
        } else if (i2 == 1) {
            checkedTextView = this.f30857d;
        } else if (i2 == 2) {
            checkedTextView = this.f30858e;
        } else if (i2 == 3) {
            checkedTextView = this.f30859f;
        } else {
            return;
        }
        checkedTextView.setChecked(true);
    }

    public void a(Context context, String str) {
        a(Arrays.asList(context.getResources().getStringArray(R.array.action_metering_value)).indexOf(str));
    }

    public void dismiss() {
        c();
    }

    public void onClick(View view) {
        int i2;
        a aVar;
        switch (view.getId()) {
            case R.id.tv_center:
                i2 = 0;
                a(0);
                aVar = this.f30855b;
                if (aVar == null) {
                    return;
                }
                break;
            case R.id.tv_fly:
                i2 = 3;
                a(3);
                aVar = this.f30855b;
                if (aVar == null) {
                    return;
                }
                break;
            case R.id.tv_multi:
                i2 = 1;
                a(1);
                aVar = this.f30855b;
                if (aVar == null) {
                    return;
                }
                break;
            case R.id.tv_spot:
                i2 = 2;
                a(2);
                aVar = this.f30855b;
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
