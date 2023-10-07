package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import t.ac;

class ag implements ai {

    /* renamed from: a  reason: collision with root package name */
    protected a f4787a;

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f4788a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f4789b;

        /* renamed from: c  reason: collision with root package name */
        View f4790c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f4791d = null;

        /* renamed from: e  reason: collision with root package name */
        ag f4792e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4793f;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f4788a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ag agVar) {
            super(context);
            this.f4789b = viewGroup;
            this.f4790c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4792e = agVar;
        }

        private void a() {
            if (this.f4793f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f4789b.getLocationOnScreen(iArr2);
            this.f4790c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        private void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f4791d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4793f = true;
                    this.f4789b.removeView(this);
                }
            }
        }

        public void a(Drawable drawable) {
            a();
            if (this.f4791d == null) {
                this.f4791d = new ArrayList<>();
            }
            if (!this.f4791d.contains(drawable)) {
                this.f4791d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void a(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f4789b || viewGroup.getParent() == null || !ac.J(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4789b.getLocationOnScreen(iArr2);
                    ac.f(view, iArr[0] - iArr2[0]);
                    ac.e(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f4791d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                b();
            }
        }

        public void b(View view) {
            super.removeView(view);
            b();
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f4789b.getLocationOnScreen(iArr);
            this.f4790c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f4790c.getWidth(), this.f4790c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f4791d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4791d.get(i2).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4789b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f4789b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.f4791d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f4791d
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ag.a.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    ag(Context context, ViewGroup viewGroup, View view) {
        this.f4787a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static ag d(View view) {
        ViewGroup c2 = c(view);
        if (c2 == null) {
            return null;
        }
        int childCount = c2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f4792e;
            }
        }
        return new ab(c2.getContext(), c2, view);
    }

    public void a(Drawable drawable) {
        this.f4787a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.f4787a.b(drawable);
    }
}
