package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

class aj {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1443a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1444b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1445c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1446d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1447e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1448f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1449g = new int[2];

    aj(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1446d = layoutParams;
        this.f1443a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1444b = inflate;
        this.f1445c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    private void a(View view, int i2, int i3, boolean z2, WindowManager.LayoutParams layoutParams) {
        int i4;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1443a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1443a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1443a.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f1447e);
        if (this.f1447e.left < 0 && this.f1447e.top < 0) {
            Resources resources = this.f1443a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1447e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.f1449g);
        view.getLocationOnScreen(this.f1448f);
        int[] iArr = this.f1448f;
        int i6 = iArr[0];
        int[] iArr2 = this.f1449g;
        iArr[0] = i6 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (a2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1444b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1444b.getMeasuredHeight();
        int[] iArr3 = this.f1448f;
        int i7 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i8 = iArr3[1] + i5 + dimensionPixelOffset3;
        if (!z2 ? measuredHeight + i8 > this.f1447e.height() : i7 >= 0) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i8;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (b()) {
            ((WindowManager) this.f1443a.getSystemService("window")).removeView(this.f1444b);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, int i3, boolean z2, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f1445c.setText(charSequence);
        a(view, i2, i3, z2, this.f1446d);
        ((WindowManager) this.f1443a.getSystemService("window")).addView(this.f1444b, this.f1446d);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f1444b.getParent() != null;
    }
}
