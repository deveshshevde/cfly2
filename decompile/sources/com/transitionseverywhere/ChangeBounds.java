package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.utils.g;
import com.transitionseverywhere.utils.h;
import com.transitionseverywhere.utils.k;
import com.transitionseverywhere.utils.l;
import com.transitionseverywhere.utils.m;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final String[] F = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final g<Drawable> G;
    private static final g<a> H;
    private static final g<a> I;
    private static final g<View> J;
    private static final g<View> K;
    private static final g<View> L;
    private static h M;

    /* renamed from: a  reason: collision with root package name */
    int[] f21771a = new int[2];

    /* renamed from: b  reason: collision with root package name */
    boolean f21772b = false;

    /* renamed from: c  reason: collision with root package name */
    boolean f21773c = false;

    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f21791a;

        /* renamed from: b  reason: collision with root package name */
        private int f21792b;

        /* renamed from: c  reason: collision with root package name */
        private int f21793c;

        /* renamed from: d  reason: collision with root package name */
        private int f21794d;

        /* renamed from: e  reason: collision with root package name */
        private int f21795e;

        /* renamed from: f  reason: collision with root package name */
        private int f21796f;

        /* renamed from: g  reason: collision with root package name */
        private View f21797g;

        public a(View view) {
            this.f21797g = view;
        }

        private void a() {
            m.a(this.f21797g, this.f21791a, this.f21792b, this.f21793c, this.f21794d);
            this.f21795e = 0;
            this.f21796f = 0;
        }

        public void a(PointF pointF) {
            this.f21791a = Math.round(pointF.x);
            this.f21792b = Math.round(pointF.y);
            int i2 = this.f21795e + 1;
            this.f21795e = i2;
            if (i2 == this.f21796f) {
                a();
            }
        }

        public void b(PointF pointF) {
            this.f21793c = Math.round(pointF.x);
            this.f21794d = Math.round(pointF.y);
            int i2 = this.f21796f + 1;
            this.f21796f = i2;
            if (this.f21795e == i2) {
                a();
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f21795e > 0 || this.f21796f > 0) {
                a();
            }
        }
    }

    static {
        AnonymousClass6 r0;
        if (Build.VERSION.SDK_INT >= 14) {
            G = new g<Drawable>() {

                /* renamed from: a  reason: collision with root package name */
                private Rect f21774a = new Rect();

                /* renamed from: a */
                public PointF get(Drawable drawable) {
                    drawable.copyBounds(this.f21774a);
                    return new PointF((float) this.f21774a.left, (float) this.f21774a.top);
                }

                /* renamed from: a */
                public void set(Drawable drawable, PointF pointF) {
                    drawable.copyBounds(this.f21774a);
                    this.f21774a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                    drawable.setBounds(this.f21774a);
                }
            };
            H = new g<a>() {
                /* renamed from: a */
                public void set(a aVar, PointF pointF) {
                    aVar.a(pointF);
                }
            };
            I = new g<a>() {
                /* renamed from: a */
                public void set(a aVar, PointF pointF) {
                    aVar.b(pointF);
                }
            };
            J = new g<View>() {
                /* renamed from: a */
                public void set(View view, PointF pointF) {
                    m.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                }
            };
            K = new g<View>() {
                /* renamed from: a */
                public void set(View view, PointF pointF) {
                    m.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
                }
            };
            r0 = new g<View>() {
                /* renamed from: a */
                public void set(View view, PointF pointF) {
                    int round = Math.round(pointF.x);
                    int round2 = Math.round(pointF.y);
                    m.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
                }
            };
        } else {
            r0 = null;
            G = null;
            H = null;
            I = null;
            J = null;
            K = null;
        }
        L = r0;
    }

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChangeBounds);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.ChangeBounds_resizeClip, false);
        obtainStyledAttributes.recycle();
        a(z2);
    }

    private boolean a(View view, View view2) {
        if (!this.f21773c) {
            return true;
        }
        h b2 = b(view, true);
        if (b2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b2.f21926a) {
            return true;
        }
        return false;
    }

    private void d(h hVar) {
        View view = hVar.f21926a;
        if (m.a(view, false) || view.getWidth() != 0 || view.getHeight() != 0) {
            hVar.f21927b.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            hVar.f21927b.put("android:changeBounds:parent", hVar.f21926a.getParent());
            if (this.f21773c) {
                hVar.f21926a.getLocationInWindow(this.f21771a);
                hVar.f21927b.put("android:changeBounds:windowX", Integer.valueOf(this.f21771a[0]));
                hVar.f21927b.put("android:changeBounds:windowY", Integer.valueOf(this.f21771a[1]));
            }
            if (this.f21772b) {
                hVar.f21927b.put("android:changeBounds:clip", m.a(view));
            }
        }
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        int i2;
        boolean z2;
        View view;
        Animator animator;
        float f2;
        float f3;
        float f4;
        float f5;
        PathMotion pathMotion;
        g<View> gVar;
        View view2;
        int i3;
        int i4;
        Animator animator2;
        int i5;
        int i6;
        int i7;
        View view3;
        ObjectAnimator objectAnimator;
        ViewGroup viewGroup2 = viewGroup;
        h hVar3 = hVar;
        h hVar4 = hVar2;
        if (hVar3 == null || hVar4 == null) {
            return null;
        }
        if (M == null) {
            M = new h();
        }
        Map<String, Object> map = hVar3.f21927b;
        Map<String, Object> map2 = hVar4.f21927b;
        ViewGroup viewGroup3 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup4 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup3 == null || viewGroup4 == null) {
            return null;
        }
        View view4 = hVar4.f21926a;
        if (a(viewGroup3, viewGroup4)) {
            Rect rect = (Rect) hVar3.f21927b.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) hVar4.f21927b.get("android:changeBounds:bounds");
            int i8 = rect.left;
            int i9 = rect2.left;
            int i10 = rect.top;
            int i11 = rect2.top;
            int i12 = rect.right;
            int i13 = rect2.right;
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            int i16 = i12 - i8;
            int i17 = i14 - i10;
            int i18 = i13 - i9;
            int i19 = i15 - i11;
            View view5 = view4;
            Rect rect3 = (Rect) hVar3.f21927b.get("android:changeBounds:clip");
            Rect rect4 = (Rect) hVar4.f21927b.get("android:changeBounds:clip");
            if ((i16 == 0 || i17 == 0) && (i18 == 0 || i19 == 0)) {
                i2 = 0;
            } else {
                i2 = (i8 == i9 && i10 == i11) ? 0 : 1;
                if (!(i12 == i13 && i14 == i15)) {
                    i2++;
                }
            }
            if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                i2++;
            }
            if (i2 > 0) {
                int i20 = i15;
                if (!this.f21772b || (rect3 == null && rect4 == null)) {
                    int i21 = i16;
                    int i22 = i13;
                    int i23 = i11;
                    int i24 = i9;
                    View view6 = view5;
                    int i25 = i20;
                    m.a(view6, i8, i10, i12, i14);
                    if (i2 != 2) {
                        int i26 = i23;
                        int i27 = i24;
                        view = view6;
                        z2 = true;
                        if (i8 == i27 && i10 == i26) {
                            gVar = J;
                            float f6 = (float) i12;
                            f3 = (float) i22;
                            f2 = (float) i25;
                            view2 = view;
                            pathMotion = k();
                            f5 = f6;
                            f4 = (float) i14;
                        } else {
                            g<View> gVar2 = K;
                            pathMotion = k();
                            f5 = (float) i8;
                            f4 = (float) i10;
                            f3 = (float) i27;
                            f2 = (float) i26;
                            view2 = view;
                            gVar = gVar2;
                        }
                    } else if (i21 == i18 && i17 == i19) {
                        g<View> gVar3 = L;
                        pathMotion = k();
                        f5 = (float) i8;
                        f4 = (float) i10;
                        view2 = view6;
                        gVar = gVar3;
                        view = view6;
                        f3 = (float) i24;
                        z2 = true;
                        f2 = (float) i23;
                    } else {
                        view = view6;
                        z2 = true;
                        a aVar = new a(view);
                        Animator a2 = com.transitionseverywhere.utils.a.a(aVar, H, k(), (float) i8, (float) i10, (float) i24, (float) i23);
                        Animator a3 = com.transitionseverywhere.utils.a.a(aVar, I, k(), (float) i12, (float) i14, (float) i22, (float) i25);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(aVar);
                        animator = animatorSet;
                    }
                    animator = com.transitionseverywhere.utils.a.a(view2, gVar, pathMotion, f5, f4, f3, f2);
                } else {
                    View view7 = view5;
                    m.a(view7, i8, i10, Math.max(i16, i18) + i8, Math.max(i17, i19) + i10);
                    if (i8 == i9 && i10 == i11) {
                        i6 = i16;
                        i5 = i13;
                        i4 = i11;
                        i3 = i9;
                        animator2 = null;
                    } else {
                        float f7 = (float) i8;
                        float f8 = (float) i10;
                        i6 = i16;
                        float f9 = f7;
                        i5 = i13;
                        i4 = i11;
                        i3 = i9;
                        animator2 = com.transitionseverywhere.utils.a.a(view7, L, k(), f9, f8, (float) i9, (float) i11);
                    }
                    if (rect3 == null) {
                        i7 = 0;
                        rect3 = new Rect(0, 0, i6, i17);
                    } else {
                        i7 = 0;
                    }
                    Rect rect5 = rect4 == null ? new Rect(i7, i7, i18, i19) : rect4;
                    if (!rect3.equals(rect5)) {
                        m.a(view7, rect3);
                        Property<View, Rect> property = ChangeClipBounds.f21798a;
                        h hVar5 = M;
                        Rect[] rectArr = new Rect[2];
                        rectArr[i7] = rect3;
                        rectArr[1] = rect5;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view7, property, hVar5, rectArr);
                        int i28 = i5;
                        final View view8 = view7;
                        final Rect rect6 = rect4;
                        View view9 = view7;
                        final int i29 = i3;
                        final int i30 = i4;
                        final int i31 = i28;
                        view3 = view9;
                        final int i32 = i20;
                        ofObject.addListener(new AnimatorListenerAdapter() {

                            /* renamed from: h  reason: collision with root package name */
                            private boolean f21782h;

                            public void onAnimationCancel(Animator animator) {
                                this.f21782h = true;
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (!this.f21782h) {
                                    m.a(view8, rect6);
                                    m.a(view8, i29, i30, i31, i32);
                                }
                            }
                        });
                        objectAnimator = ofObject;
                    } else {
                        view3 = view7;
                        objectAnimator = null;
                    }
                    animator = g.a(animator2, objectAnimator);
                    view = view3;
                    z2 = true;
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup5 = (ViewGroup) view.getParent();
                    k.a(viewGroup5, z2);
                    a((Transition.c) new Transition.d() {

                        /* renamed from: a  reason: collision with root package name */
                        boolean f21783a = false;

                        public void a(Transition transition) {
                            k.a(viewGroup5, false);
                            this.f21783a = true;
                        }

                        public void b(Transition transition) {
                            if (!this.f21783a) {
                                k.a(viewGroup5, false);
                            }
                            transition.b((Transition.c) this);
                        }

                        public void c(Transition transition) {
                            k.a(viewGroup5, false);
                        }

                        public void d(Transition transition) {
                            k.a(viewGroup5, true);
                        }
                    });
                }
                return animator;
            }
            return null;
        }
        final View view10 = view4;
        viewGroup2.getLocationInWindow(this.f21771a);
        int intValue = ((Integer) hVar3.f21927b.get("android:changeBounds:windowX")).intValue() - this.f21771a[0];
        int intValue2 = ((Integer) hVar3.f21927b.get("android:changeBounds:windowY")).intValue() - this.f21771a[1];
        int intValue3 = ((Integer) hVar4.f21927b.get("android:changeBounds:windowX")).intValue() - this.f21771a[0];
        int intValue4 = ((Integer) hVar4.f21927b.get("android:changeBounds:windowY")).intValue() - this.f21771a[1];
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        int width = view10.getWidth();
        int height = view10.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        view10.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(viewGroup.getContext().getResources(), createBitmap);
        bitmapDrawable.setBounds(intValue, intValue2, width + intValue, height + intValue2);
        Animator a4 = com.transitionseverywhere.utils.a.a(bitmapDrawable, G, k(), (float) intValue, (float) intValue2, (float) intValue3, (float) intValue4);
        if (a4 != null) {
            final float alpha = view10.getAlpha();
            view10.setAlpha(0.0f);
            l.a(viewGroup2, bitmapDrawable);
            final ViewGroup viewGroup6 = viewGroup;
            final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
            a4.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    l.b(viewGroup6, bitmapDrawable2);
                    view10.setAlpha(alpha);
                }
            });
        }
        return a4;
    }

    public void a(h hVar) {
        d(hVar);
    }

    public void a(boolean z2) {
        this.f21772b = z2;
    }

    public String[] a() {
        return F;
    }

    public void b(h hVar) {
        d(hVar);
    }
}
