package zhy.com.highlight.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.List;
import zhy.com.highlight.a;

public class HightLightView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuffXfermode f34770a = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f34771b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f34772c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f34773d;

    /* renamed from: e  reason: collision with root package name */
    private List<a.d> f34774e;

    /* renamed from: f  reason: collision with root package name */
    private a f34775f;

    /* renamed from: g  reason: collision with root package name */
    private int f34776g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f34777h;

    /* renamed from: i  reason: collision with root package name */
    private a.d f34778i;

    private FrameLayout.LayoutParams a(View view, a.d dVar) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin == ((int) dVar.f34766c.f34761b) && layoutParams.topMargin == ((int) dVar.f34766c.f34760a) && layoutParams.rightMargin == ((int) dVar.f34766c.f34762c) && layoutParams.bottomMargin == ((int) dVar.f34766c.f34763d)) {
            return null;
        }
        layoutParams.leftMargin = (int) dVar.f34766c.f34761b;
        layoutParams.topMargin = (int) dVar.f34766c.f34760a;
        layoutParams.rightMargin = (int) dVar.f34766c.f34762c;
        layoutParams.bottomMargin = (int) dVar.f34766c.f34763d;
        if (!(view instanceof RelativeLayout) && !(view instanceof ConstraintLayout)) {
            if (layoutParams.leftMargin == 0 && layoutParams.topMargin == 0) {
                layoutParams.gravity = 85;
            }
            layoutParams.gravity = layoutParams.rightMargin != 0 ? 5 : 3;
            layoutParams.gravity = layoutParams.bottomMargin != 0 ? layoutParams.gravity | 80 : layoutParams.gravity | 48;
        }
        return layoutParams;
    }

    private void a() {
        a(this.f34771b);
        this.f34771b = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.f34771b);
        canvas.drawColor(this.f34776g);
        this.f34773d.setXfermode(f34770a);
        this.f34775f.a();
        a(this.f34772c);
        this.f34772c = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        if (this.f34777h) {
            a(this.f34778i);
        } else {
            for (a.d a2 : this.f34774e) {
                a(a2);
            }
        }
        canvas.drawBitmap(this.f34772c, 0.0f, 0.0f, this.f34773d);
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            System.gc();
        }
    }

    private void a(a.d dVar) {
        dVar.f34769f.a(this.f34772c, dVar);
    }

    private void b() {
        if (this.f34777h) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams a2 = a(childAt, this.f34778i);
            if (a2 != null) {
                childAt.setLayoutParams(a2);
                return;
            }
            return;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = getChildAt(i2);
            FrameLayout.LayoutParams a3 = a(childAt2, this.f34774e.get(i2));
            if (a3 != null) {
                childAt2.setLayoutParams(a3);
            }
        }
    }

    public a.d getCurentViewPosInfo() {
        return this.f34778i;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(this.f34772c);
        a(this.f34771b);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            canvas.drawBitmap(this.f34771b, 0.0f, 0.0f, (Paint) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2 || this.f34777h) {
            a();
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        measureChildren(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(size2, MemoryConstants.GB));
        setMeasuredDimension(size, size2);
    }
}
