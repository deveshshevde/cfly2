package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.Map;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import t.ac;

public class ChangeBounds extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4613a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: i  reason: collision with root package name */
    private static final Property<Drawable, PointF> f4614i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a  reason: collision with root package name */
        private Rect f4624a = new Rect();

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f4624a);
            return new PointF((float) this.f4624a.left, (float) this.f4624a.top);
        }

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f4624a);
            this.f4624a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f4624a);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private static final Property<a, PointF> f4615j = new Property<a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static final Property<a, PointF> f4616k = new Property<a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private static final Property<View, PointF> f4617l = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private static final Property<View, PointF> f4618m = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private static final Property<View, PointF> f4619n = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            aj.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private static p f4620r = new p();

    /* renamed from: o  reason: collision with root package name */
    private int[] f4621o = new int[2];

    /* renamed from: p  reason: collision with root package name */
    private boolean f4622p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4623q = false;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f4643a;

        /* renamed from: b  reason: collision with root package name */
        private int f4644b;

        /* renamed from: c  reason: collision with root package name */
        private int f4645c;

        /* renamed from: d  reason: collision with root package name */
        private int f4646d;

        /* renamed from: e  reason: collision with root package name */
        private View f4647e;

        /* renamed from: f  reason: collision with root package name */
        private int f4648f;

        /* renamed from: g  reason: collision with root package name */
        private int f4649g;

        a(View view) {
            this.f4647e = view;
        }

        private void a() {
            aj.a(this.f4647e, this.f4643a, this.f4644b, this.f4645c, this.f4646d);
            this.f4648f = 0;
            this.f4649g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f4643a = Math.round(pointF.x);
            this.f4644b = Math.round(pointF.y);
            int i2 = this.f4648f + 1;
            this.f4648f = i2;
            if (i2 == this.f4649g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f4645c = Math.round(pointF.x);
            this.f4646d = Math.round(pointF.y);
            int i2 = this.f4649g + 1;
            this.f4649g = i2;
            if (this.f4648f == i2) {
                a();
            }
        }
    }

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4865d);
        boolean a2 = g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        a(a2);
    }

    private boolean a(View view, View view2) {
        if (!this.f4623q) {
            return true;
        }
        y b2 = b(view, true);
        if (b2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b2.f4887b) {
            return true;
        }
        return false;
    }

    private void d(y yVar) {
        View view = yVar.f4887b;
        if (ac.G(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            yVar.f4886a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            yVar.f4886a.put("android:changeBounds:parent", yVar.f4887b.getParent());
            if (this.f4623q) {
                yVar.f4887b.getLocationInWindow(this.f4621o);
                yVar.f4886a.put("android:changeBounds:windowX", Integer.valueOf(this.f4621o[0]));
                yVar.f4886a.put("android:changeBounds:windowY", Integer.valueOf(this.f4621o[1]));
            }
            if (this.f4622p) {
                yVar.f4886a.put("android:changeBounds:clip", ac.I(view));
            }
        }
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        int i2;
        View view;
        Animator animator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        y yVar3 = yVar;
        y yVar4 = yVar2;
        if (yVar3 == null || yVar4 == null) {
            return null;
        }
        Map<String, Object> map = yVar3.f4886a;
        Map<String, Object> map2 = yVar4.f4886a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = yVar4.f4887b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) yVar3.f4886a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) yVar4.f4886a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect4 = (Rect) yVar3.f4886a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) yVar4.f4886a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.f4622p) {
                view = view3;
                aj.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        path = m().a((float) i4, (float) i6, (float) i5, (float) i7);
                        property = f4619n;
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator a2 = m.a(aVar, f4615j, m().a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = m.a(aVar, f4616k, m().a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new AnimatorListenerAdapter(aVar) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f4633a;
                            private a mViewBounds;

                            {
                                this.f4633a = r2;
                                this.mViewBounds = r2;
                            }
                        });
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    path = m().a((float) i8, (float) i10, (float) i9, (float) i11);
                    property = f4617l;
                } else {
                    path = m().a((float) i4, (float) i6, (float) i5, (float) i7);
                    property = f4618m;
                }
                animator = m.a(view, property, path);
            } else {
                view = view3;
                aj.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : m.a(view, f4619n, m().a((float) i4, (float) i6, (float) i5, (float) i7));
                if (rect7 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i3, i3, i14, i15) : rect6;
                if (!rect.equals(rect8)) {
                    ac.a(view, rect);
                    p pVar = f4620r;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect8;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", pVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i9;
                    final int i19 = i11;
                    ofObject.addListener(new AnimatorListenerAdapter() {

                        /* renamed from: h  reason: collision with root package name */
                        private boolean f4642h;

                        public void onAnimationCancel(Animator animator) {
                            this.f4642h = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.f4642h) {
                                ac.a(view4, rect9);
                                aj.a(view4, i16, i17, i18, i19);
                            }
                        }
                    });
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = x.a(a4, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ae.a(viewGroup4, true);
                a((Transition.c) new u() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f4625a = false;

                    public void a(Transition transition) {
                        ae.a(viewGroup4, false);
                        this.f4625a = true;
                    }

                    public void b(Transition transition) {
                        if (!this.f4625a) {
                            ae.a(viewGroup4, false);
                        }
                        transition.b((Transition.c) this);
                    }

                    public void c(Transition transition) {
                        ae.a(viewGroup4, false);
                    }

                    public void d(Transition transition) {
                        ae.a(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) yVar3.f4886a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) yVar3.f4886a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) yVar4.f4886a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) yVar4.f4886a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f4621o);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = aj.c(view2);
        aj.a(view2, 0.0f);
        aj.a(viewGroup).a(bitmapDrawable);
        PathMotion m2 = m();
        int[] iArr = this.f4621o;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{o.a(f4614i, m2.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = c2;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                aj.a(viewGroup5).b(bitmapDrawable2);
                aj.a(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }

    public void a(y yVar) {
        d(yVar);
    }

    public void a(boolean z2) {
        this.f4622p = z2;
    }

    public String[] a() {
        return f4613a;
    }

    public void b(y yVar) {
        d(yVar);
    }
}
