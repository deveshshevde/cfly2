package com.google.android.material.internal;

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

class p implements r {

    /* renamed from: a  reason: collision with root package name */
    protected a f19323a;

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f19324a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f19325b;

        /* renamed from: c  reason: collision with root package name */
        View f19326c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f19327d = null;

        /* renamed from: e  reason: collision with root package name */
        p f19328e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19329f;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f19324a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, p pVar) {
            super(context);
            this.f19325b = viewGroup;
            this.f19326c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f19328e = pVar;
        }

        private void a() {
            if (this.f19329f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f19325b.getLocationOnScreen(iArr2);
            this.f19326c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        private void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f19327d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f19329f = true;
                    this.f19325b.removeView(this);
                }
            }
        }

        public void a(Drawable drawable) {
            a();
            if (this.f19327d == null) {
                this.f19327d = new ArrayList<>();
            }
            if (!this.f19327d.contains(drawable)) {
                this.f19327d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f19327d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                b();
            }
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f19325b.getLocationOnScreen(iArr);
            this.f19326c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f19326c.getWidth(), this.f19326c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f19327d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f19327d.get(i2).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f19325b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f19325b != null) {
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
            r0 = r1.f19327d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f19327d
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.p.a.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    p(Context context, ViewGroup viewGroup, View view) {
        this.f19323a = new a(context, viewGroup, view, this);
    }

    static p a(View view) {
        ViewGroup f2 = s.f(view);
        if (f2 == null) {
            return null;
        }
        int childCount = f2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = f2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f19328e;
            }
        }
        return new n(f2.getContext(), f2, view);
    }

    public void a(Drawable drawable) {
        this.f19323a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.f19323a.b(drawable);
    }
}
