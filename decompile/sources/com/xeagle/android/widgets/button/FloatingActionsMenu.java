package com.xeagle.android.widgets.button;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class FloatingActionsMenu extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static Interpolator f25747v = new OvershootInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static Interpolator f25748w = new DecelerateInterpolator(3.0f);
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static Interpolator f25749x = new DecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f25750a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f25751b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f25752c;

    /* renamed from: d  reason: collision with root package name */
    private int f25753d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f25754e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f25755f;

    /* renamed from: g  reason: collision with root package name */
    private int f25756g;

    /* renamed from: h  reason: collision with root package name */
    private int f25757h;

    /* renamed from: i  reason: collision with root package name */
    private int f25758i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25759j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AnimatorSet f25760k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public AnimatorSet f25761l;

    /* renamed from: m  reason: collision with root package name */
    private AddFloatingActionButton f25762m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public c f25763n;

    /* renamed from: o  reason: collision with root package name */
    private int f25764o;

    /* renamed from: p  reason: collision with root package name */
    private int f25765p;

    /* renamed from: q  reason: collision with root package name */
    private int f25766q;

    /* renamed from: r  reason: collision with root package name */
    private int f25767r;

    /* renamed from: s  reason: collision with root package name */
    private int f25768s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f25769t;

    /* renamed from: u  reason: collision with root package name */
    private b f25770u;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public boolean f25773a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f25773a = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f25773a ? 1 : 0);
        }
    }

    private class a extends ViewGroup.LayoutParams {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ObjectAnimator f25775b = new ObjectAnimator();

        /* renamed from: c  reason: collision with root package name */
        private ObjectAnimator f25776c = new ObjectAnimator();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ObjectAnimator f25777d = new ObjectAnimator();

        /* renamed from: e  reason: collision with root package name */
        private ObjectAnimator f25778e = new ObjectAnimator();

        /* renamed from: f  reason: collision with root package name */
        private boolean f25779f;

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Property property;
            ObjectAnimator objectAnimator;
            this.f25775b.setInterpolator(FloatingActionsMenu.f25747v);
            this.f25776c.setInterpolator(FloatingActionsMenu.f25749x);
            this.f25777d.setInterpolator(FloatingActionsMenu.f25748w);
            this.f25778e.setInterpolator(FloatingActionsMenu.f25748w);
            this.f25778e.setProperty(View.ALPHA);
            this.f25778e.setFloatValues(new float[]{1.0f, 0.0f});
            this.f25776c.setProperty(View.ALPHA);
            this.f25776c.setFloatValues(new float[]{0.0f, 1.0f});
            int h2 = FloatingActionsMenu.this.f25755f;
            if (h2 == 0 || h2 == 1) {
                this.f25777d.setProperty(View.TRANSLATION_Y);
                objectAnimator = this.f25775b;
                property = View.TRANSLATION_Y;
            } else if (h2 == 2 || h2 == 3) {
                this.f25777d.setProperty(View.TRANSLATION_X);
                objectAnimator = this.f25775b;
                property = View.TRANSLATION_X;
            } else {
                return;
            }
            objectAnimator.setProperty(property);
        }

        public void a(View view) {
            this.f25778e.setTarget(view);
            this.f25777d.setTarget(view);
            this.f25776c.setTarget(view);
            this.f25775b.setTarget(view);
            if (!this.f25779f) {
                FloatingActionsMenu.this.f25761l.play(this.f25778e);
                FloatingActionsMenu.this.f25761l.play(this.f25777d);
                FloatingActionsMenu.this.f25760k.play(this.f25776c);
                FloatingActionsMenu.this.f25760k.play(this.f25775b);
                this.f25779f = true;
            }
        }
    }

    public interface b {
        void a();

        void b();
    }

    private static class c extends LayerDrawable {

        /* renamed from: a  reason: collision with root package name */
        private float f25780a;

        public c(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        public void a(float f2) {
            this.f25780a = f2;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f25780a, (float) getBounds().centerX(), (float) getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionsMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25760k = new AnimatorSet().setDuration(300);
        this.f25761l = new AnimatorSet().setDuration(300);
        a(context, attributeSet);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25760k = new AnimatorSet().setDuration(300);
        this.f25761l = new AnimatorSet().setDuration(300);
        a(context, attributeSet);
    }

    private int a(int i2) {
        return getResources().getColor(i2);
    }

    private void a(Context context) {
        AnonymousClass1 r0 = new AddFloatingActionButton(context) {
            /* access modifiers changed from: package-private */
            public void a() {
                this.f25727a = FloatingActionsMenu.this.f25750a;
                this.f25729b = FloatingActionsMenu.this.f25751b;
                this.f25730c = FloatingActionsMenu.this.f25752c;
                this.f25733f = FloatingActionsMenu.this.f25754e;
                super.a();
            }

            /* access modifiers changed from: package-private */
            public Drawable getIconDrawable() {
                c cVar = new c(getResources().getDrawable(FloatingActionsMenu.this.f25769t));
                c unused = FloatingActionsMenu.this.f25763n = cVar;
                OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "rotation", new float[]{270.0f, 0.0f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cVar, "rotation", new float[]{0.0f, 270.0f});
                ofFloat.setInterpolator(overshootInterpolator);
                ofFloat2.setInterpolator(overshootInterpolator);
                FloatingActionsMenu.this.f25760k.play(ofFloat2);
                FloatingActionsMenu.this.f25761l.play(ofFloat);
                return cVar;
            }
        };
        this.f25762m = r0;
        r0.setId(R.id.fab_expand_menu_button);
        this.f25762m.setSize(this.f25753d);
        this.f25762m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FloatingActionsMenu.this.b();
            }
        });
        addView(this.f25762m, super.generateDefaultLayoutParams());
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f25756g = (int) ((getResources().getDimension(R.dimen.fab_actions_spacing) - getResources().getDimension(R.dimen.fab_shadow_radius)) - getResources().getDimension(R.dimen.fab_shadow_offset));
        this.f25757h = getResources().getDimensionPixelSize(R.dimen.fab_labels_margin);
        this.f25758i = getResources().getDimensionPixelSize(R.dimen.fab_shadow_offset);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.xeagle.R.styleable.FloatingActionsMenu, 0, 0);
        this.f25750a = obtainStyledAttributes.getColor(2, a(17170443));
        this.f25751b = obtainStyledAttributes.getColor(0, a(17170451));
        this.f25752c = obtainStyledAttributes.getColor(1, a(17170450));
        this.f25753d = obtainStyledAttributes.getInt(3, 0);
        this.f25754e = obtainStyledAttributes.getBoolean(4, true);
        this.f25755f = obtainStyledAttributes.getInt(5, 0);
        this.f25766q = obtainStyledAttributes.getResourceId(6, 0);
        this.f25767r = obtainStyledAttributes.getInt(7, 0);
        this.f25769t = obtainStyledAttributes.getResourceId(8, R.drawable.compass_pre);
        obtainStyledAttributes.recycle();
        if (this.f25766q == 0 || !g()) {
            a(context);
            return;
        }
        throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
    }

    private int b(int i2) {
        return (i2 * 12) / 10;
    }

    private boolean g() {
        int i2 = this.f25755f;
        return i2 == 2 || i2 == 3;
    }

    private void h() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f25766q);
        for (int i2 = 0; i2 < this.f25768s; i2++) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i2);
            String title = floatingActionButton.getTitle();
            if (!(floatingActionButton == this.f25762m || title == null || floatingActionButton.getTag(R.id.fab_label) != null)) {
                TextView textView = new TextView(contextThemeWrapper);
                textView.setText(floatingActionButton.getTitle());
                addView(textView);
                floatingActionButton.setTag(R.id.fab_label, textView);
            }
        }
    }

    public void a() {
        if (this.f25759j) {
            this.f25759j = false;
            this.f25761l.start();
            this.f25760k.cancel();
            b bVar = this.f25770u;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public void b() {
        if (this.f25759j) {
            a();
        } else {
            c();
        }
    }

    public void c() {
        if (!this.f25759j) {
            this.f25759j = true;
            this.f25761l.cancel();
            this.f25760k.start();
            b bVar = this.f25770u;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(super.generateDefaultLayoutParams());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(super.generateLayoutParams(attributeSet));
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(super.generateLayoutParams(layoutParams));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f25762m);
        this.f25768s = getChildCount();
        if (this.f25766q != 0) {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = this.f25755f;
        int i7 = 8;
        float f2 = 0.0f;
        char c2 = 1;
        if (i6 == 0 || i6 == 1) {
            boolean z3 = i6 == 0;
            int measuredHeight = z3 ? (i5 - i3) - this.f25762m.getMeasuredHeight() : 0;
            int i8 = this.f25767r == 0 ? (i4 - i2) - (this.f25764o / 2) : this.f25764o / 2;
            int measuredWidth = i8 - (this.f25762m.getMeasuredWidth() / 2);
            AddFloatingActionButton addFloatingActionButton = this.f25762m;
            addFloatingActionButton.layout(measuredWidth, measuredHeight, addFloatingActionButton.getMeasuredWidth() + measuredWidth, this.f25762m.getMeasuredHeight() + measuredHeight);
            int i9 = (this.f25764o / 2) + this.f25757h;
            int i10 = this.f25767r == 0 ? i8 - i9 : i9 + i8;
            int measuredHeight2 = z3 ? measuredHeight - this.f25756g : this.f25762m.getMeasuredHeight() + measuredHeight + this.f25756g;
            int i11 = this.f25768s - 1;
            while (i11 >= 0) {
                View childAt = getChildAt(i11);
                if (childAt != this.f25762m && childAt.getVisibility() != i7) {
                    int measuredWidth2 = i8 - (childAt.getMeasuredWidth() / 2);
                    if (z3) {
                        measuredHeight2 -= childAt.getMeasuredHeight();
                    }
                    childAt.layout(measuredWidth2, measuredHeight2, childAt.getMeasuredWidth() + measuredWidth2, childAt.getMeasuredHeight() + measuredHeight2);
                    float f3 = (float) (measuredHeight - measuredHeight2);
                    childAt.setTranslationY(this.f25759j ? 0.0f : f3);
                    childAt.setAlpha(this.f25759j ? 1.0f : 0.0f);
                    a aVar = (a) childAt.getLayoutParams();
                    ObjectAnimator a2 = aVar.f25777d;
                    float[] fArr = new float[2];
                    fArr[0] = f2;
                    fArr[c2] = f3;
                    a2.setFloatValues(fArr);
                    ObjectAnimator b2 = aVar.f25775b;
                    float[] fArr2 = new float[2];
                    fArr2[0] = f3;
                    fArr2[c2] = f2;
                    b2.setFloatValues(fArr2);
                    aVar.a(childAt);
                    View view = (View) childAt.getTag(R.id.fab_label);
                    if (view != null) {
                        int measuredWidth3 = this.f25767r == 0 ? i10 - view.getMeasuredWidth() : view.getMeasuredWidth() + i10;
                        int i12 = this.f25767r;
                        int i13 = i12 == 0 ? measuredWidth3 : i10;
                        if (i12 == 0) {
                            measuredWidth3 = i10;
                        }
                        int measuredHeight3 = (measuredHeight2 - this.f25758i) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i13, measuredHeight3, measuredWidth3, measuredHeight3 + view.getMeasuredHeight());
                        view.setTranslationY(this.f25759j ? 0.0f : f3);
                        view.setAlpha(this.f25759j ? 1.0f : 0.0f);
                        a aVar2 = (a) view.getLayoutParams();
                        aVar2.f25777d.setFloatValues(new float[]{0.0f, f3});
                        aVar2.f25775b.setFloatValues(new float[]{f3, 0.0f});
                        aVar2.a(view);
                    }
                    measuredHeight2 = z3 ? measuredHeight2 - this.f25756g : measuredHeight2 + childAt.getMeasuredHeight() + this.f25756g;
                }
                i11--;
                i7 = 8;
                f2 = 0.0f;
                c2 = 1;
            }
        } else if (i6 == 2 || i6 == 3) {
            boolean z4 = i6 == 2;
            int measuredWidth4 = z4 ? (i4 - i2) - this.f25762m.getMeasuredWidth() : 0;
            int i14 = this.f25765p;
            int measuredHeight4 = ((i5 - i3) - i14) + ((i14 - this.f25762m.getMeasuredHeight()) / 2);
            AddFloatingActionButton addFloatingActionButton2 = this.f25762m;
            addFloatingActionButton2.layout(measuredWidth4, measuredHeight4, addFloatingActionButton2.getMeasuredWidth() + measuredWidth4, this.f25762m.getMeasuredHeight() + measuredHeight4);
            int measuredWidth5 = z4 ? measuredWidth4 - this.f25756g : this.f25762m.getMeasuredWidth() + measuredWidth4 + this.f25756g;
            for (int i15 = this.f25768s - 1; i15 >= 0; i15--) {
                View childAt2 = getChildAt(i15);
                if (!(childAt2 == this.f25762m || childAt2.getVisibility() == 8)) {
                    if (z4) {
                        measuredWidth5 -= childAt2.getMeasuredWidth();
                    }
                    int measuredHeight5 = ((this.f25762m.getMeasuredHeight() - childAt2.getMeasuredHeight()) / 2) + measuredHeight4;
                    childAt2.layout(measuredWidth5, measuredHeight5, childAt2.getMeasuredWidth() + measuredWidth5, childAt2.getMeasuredHeight() + measuredHeight5);
                    float f4 = (float) (measuredWidth4 - measuredWidth5);
                    childAt2.setTranslationX(this.f25759j ? 0.0f : f4);
                    childAt2.setAlpha(this.f25759j ? 1.0f : 0.0f);
                    a aVar3 = (a) childAt2.getLayoutParams();
                    aVar3.f25777d.setFloatValues(new float[]{0.0f, f4});
                    aVar3.f25775b.setFloatValues(new float[]{f4, 0.0f});
                    aVar3.a(childAt2);
                    measuredWidth5 = z4 ? measuredWidth5 - this.f25756g : measuredWidth5 + childAt2.getMeasuredWidth() + this.f25756g;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        TextView textView;
        measureChildren(i2, i3);
        int i4 = 0;
        this.f25764o = 0;
        this.f25765p = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < this.f25768s; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int i9 = this.f25755f;
                if (i9 == 0 || i9 == 1) {
                    this.f25764o = Math.max(this.f25764o, childAt.getMeasuredWidth());
                    i6 += childAt.getMeasuredHeight();
                } else if (i9 == 2 || i9 == 3) {
                    i7 += childAt.getMeasuredWidth();
                    this.f25765p = Math.max(this.f25765p, childAt.getMeasuredHeight());
                }
                if (!g() && (textView = (TextView) childAt.getTag(R.id.fab_label)) != null) {
                    i5 = Math.max(i5, textView.getMeasuredWidth());
                }
            }
        }
        if (!g()) {
            int i10 = this.f25764o;
            if (i5 > 0) {
                i4 = this.f25757h + i5;
            }
            i7 = i10 + i4;
        } else {
            i6 = this.f25765p;
        }
        int i11 = this.f25755f;
        if (i11 == 0 || i11 == 1) {
            i6 = b(i6 + (this.f25756g * (getChildCount() - 1)));
        } else if (i11 == 2 || i11 == 3) {
            i7 = b(i7 + (this.f25756g * (getChildCount() - 1)));
        }
        setMeasuredDimension(i7, i6);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            boolean z2 = savedState.f25773a;
            this.f25759j = z2;
            c cVar = this.f25763n;
            if (cVar != null) {
                cVar.a(z2 ? 270.0f : 0.0f);
            }
            parcelable = savedState.getSuperState();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f25773a = this.f25759j;
        return savedState;
    }

    public void setOnFloatingActionsMenuUpdateListener(b bVar) {
        this.f25770u = bVar;
    }
}
