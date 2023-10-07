package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transitionseverywhere.utils.d;

public class ChangeImageTransform extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f21800a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: b  reason: collision with root package name */
    private static final Property<ImageView, Matrix> f21801b = (Build.VERSION.SDK_INT >= 14 ? new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* renamed from: a */
        public void set(ImageView imageView, Matrix matrix) {
            d.a(imageView, matrix);
        }
    } : null);

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ObjectAnimator a(ImageView imageView, TypeEvaluator<Matrix> typeEvaluator, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, f21801b, typeEvaluator, new Matrix[]{matrix, matrix2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = (android.widget.ImageView) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.transitionseverywhere.h r8) {
        /*
            r7 = this;
            android.view.View r0 = r8.f21926a
            boolean r1 = r0 instanceof android.widget.ImageView
            if (r1 == 0) goto L_0x0080
            int r1 = r0.getVisibility()
            if (r1 == 0) goto L_0x000e
            goto L_0x0080
        L_0x000e:
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.graphics.drawable.Drawable r2 = r1.getDrawable()
            if (r2 != 0) goto L_0x0018
            return
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r8.f21927b
            int r3 = r0.getLeft()
            int r4 = r0.getTop()
            int r5 = r0.getRight()
            int r0 = r0.getBottom()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r3, r4, r5, r0)
            java.lang.String r0 = "android:changeImageTransform:bounds"
            r8.put(r0, r6)
            android.widget.ImageView$ScaleType r0 = r1.getScaleType()
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_XY
            if (r0 != r3) goto L_0x0071
            android.graphics.Matrix r0 = r1.getImageMatrix()
            boolean r1 = r0.isIdentity()
            if (r1 != 0) goto L_0x004c
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>(r0)
            goto L_0x007b
        L_0x004c:
            int r0 = r2.getIntrinsicWidth()
            int r1 = r2.getIntrinsicHeight()
            if (r0 <= 0) goto L_0x006f
            if (r1 <= 0) goto L_0x006f
            int r2 = r6.width()
            float r2 = (float) r2
            float r0 = (float) r0
            float r2 = r2 / r0
            int r0 = r6.height()
            float r0 = (float) r0
            float r1 = (float) r1
            float r0 = r0 / r1
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r1.setScale(r2, r0)
            goto L_0x007b
        L_0x006f:
            r0 = 0
            goto L_0x007a
        L_0x0071:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            android.graphics.Matrix r1 = r1.getImageMatrix()
            r0.<init>(r1)
        L_0x007a:
            r1 = r0
        L_0x007b:
            java.lang.String r0 = "android:changeImageTransform:matrix"
            r8.put(r0, r1)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.ChangeImageTransform.d(com.transitionseverywhere.h):void");
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        if (hVar == null || hVar2 == null) {
            return null;
        }
        Rect rect = (Rect) hVar.f21927b.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) hVar2.f21927b.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) hVar.f21927b.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) hVar2.f21927b.get("android:changeImageTransform:matrix");
        boolean z2 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z2) {
            return null;
        }
        ImageView imageView = (ImageView) hVar2.f21926a;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            return a(imageView, new d.b(), d.f21951a, d.f21951a);
        }
        if (matrix == null) {
            matrix = d.f21951a;
        }
        if (matrix2 == null) {
            matrix2 = d.f21951a;
        }
        d.a(imageView, matrix);
        return a(imageView, new d.a(), matrix, matrix2);
    }

    public void a(h hVar) {
        d(hVar);
    }

    public String[] a() {
        return f21800a;
    }

    public void b(h hVar) {
        d(hVar);
    }
}
