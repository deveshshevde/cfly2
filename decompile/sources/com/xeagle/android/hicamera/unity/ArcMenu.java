package com.xeagle.android.hicamera.unity;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.xeagle.R;
import java.io.PrintStream;

public class ArcMenu extends ViewGroup implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Position f23653a;

    /* renamed from: b  reason: collision with root package name */
    private int f23654b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Status f23655c;

    /* renamed from: d  reason: collision with root package name */
    private View f23656d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f23657e;

    /* renamed from: com.xeagle.android.hicamera.unity.ArcMenu$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23663a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.xeagle.android.hicamera.unity.ArcMenu$Position[] r0 = com.xeagle.android.hicamera.unity.ArcMenu.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23663a = r0
                com.xeagle.android.hicamera.unity.ArcMenu$Position r1 = com.xeagle.android.hicamera.unity.ArcMenu.Position.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23663a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.hicamera.unity.ArcMenu$Position r1 = com.xeagle.android.hicamera.unity.ArcMenu.Position.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23663a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.hicamera.unity.ArcMenu$Position r1 = com.xeagle.android.hicamera.unity.ArcMenu.Position.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23663a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.hicamera.unity.ArcMenu$Position r1 = com.xeagle.android.hicamera.unity.ArcMenu.Position.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.hicamera.unity.ArcMenu.AnonymousClass3.<clinit>():void");
        }
    }

    public enum Position {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public enum Status {
        OPEN,
        CLOSE
    }

    public interface a {
        void a(View view, int i2);
    }

    public ArcMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArcMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcMenu(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Position position;
        this.f23653a = Position.RIGHT_BOTTOM;
        this.f23655c = Status.CLOSE;
        this.f23654b = (int) TypedValue.applyDimension(1, 100.0f, getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AreMenu, i2, 0);
        int i3 = obtainStyledAttributes.getInt(0, 3);
        if (i3 == 0) {
            position = Position.LEFT_TOP;
        } else if (i3 == 1) {
            position = Position.LEFT_BOTTOM;
        } else if (i3 != 2) {
            if (i3 == 3) {
                position = Position.RIGHT_BOTTOM;
            }
            this.f23654b = (int) obtainStyledAttributes.getDimension(1, TypedValue.applyDimension(1, 100.0f, getResources().getDisplayMetrics()));
            PrintStream printStream = System.out;
            printStream.println("postion=" + this.f23653a);
            PrintStream printStream2 = System.out;
            printStream2.println("Radius=" + this.f23654b);
            obtainStyledAttributes.recycle();
        } else {
            position = Position.RIGHT_TOP;
        }
        this.f23653a = position;
        this.f23654b = (int) obtainStyledAttributes.getDimension(1, TypedValue.applyDimension(1, 100.0f, getResources().getDisplayMetrics()));
        PrintStream printStream3 = System.out;
        printStream3.println("postion=" + this.f23653a);
        PrintStream printStream22 = System.out;
        printStream22.println("Radius=" + this.f23654b);
        obtainStyledAttributes.recycle();
    }

    private void a() {
        int i2;
        int i3 = 0;
        View childAt = getChildAt(0);
        this.f23656d = childAt;
        childAt.setOnClickListener(this);
        int measuredWidth = this.f23656d.getMeasuredWidth();
        int measuredHeight = this.f23656d.getMeasuredHeight();
        int i4 = AnonymousClass3.f23663a[this.f23653a.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                i2 = getMeasuredHeight() - measuredHeight;
            } else if (i4 == 3) {
                i3 = getMeasuredWidth() - measuredWidth;
            } else if (i4 == 4) {
                i3 = getMeasuredWidth() - measuredWidth;
                i2 = getMeasuredHeight() - measuredHeight;
            }
            this.f23656d.layout(i3, i2, i3 + measuredWidth, measuredWidth + i2);
        }
        i2 = 0;
        this.f23656d.layout(i3, i2, i3 + measuredWidth, measuredWidth + i2);
    }

    private void a(int i2) {
        TranslateAnimation translateAnimation;
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount - 1) {
            final int i4 = i3 + 1;
            final View childAt = getChildAt(i4);
            childAt.setVisibility(0);
            double d2 = (double) this.f23654b;
            double d3 = (double) (childCount - 2);
            Double.isNaN(d3);
            double d4 = 1.5707963267948966d / d3;
            double d5 = (double) i3;
            Double.isNaN(d5);
            double d6 = d4 * d5;
            double sin = Math.sin(d6);
            Double.isNaN(d2);
            int i5 = (int) (d2 * sin);
            double d7 = (double) this.f23654b;
            double cos = Math.cos(d6);
            Double.isNaN(d7);
            int i6 = (int) (d7 * cos);
            int i7 = -1;
            int i8 = (this.f23653a == Position.LEFT_TOP || this.f23653a == Position.LEFT_BOTTOM) ? -1 : 1;
            if (!(this.f23653a == Position.LEFT_TOP || this.f23653a == Position.RIGHT_TOP)) {
                i7 = 1;
            }
            AnimationSet animationSet = new AnimationSet(true);
            if (this.f23655c == Status.CLOSE) {
                translateAnimation = new TranslateAnimation((float) (i8 * i5), 0.0f, (float) (i7 * i6), 0.0f);
                childAt.setClickable(true);
                childAt.setFocusable(true);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, (float) (i8 * i5), 0.0f, (float) (i7 * i6));
                childAt.setClickable(false);
                childAt.setFocusable(false);
            }
            translateAnimation.setFillAfter(true);
            long j2 = (long) i2;
            translateAnimation.setDuration(j2);
            translateAnimation.setStartOffset((long) ((i3 * 100) / childCount));
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (ArcMenu.this.f23655c == Status.CLOSE) {
                        childAt.setVisibility(8);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(j2);
            rotateAnimation.setFillAfter(true);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(translateAnimation);
            childAt.startAnimation(animationSet);
            childAt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ArcMenu.this.f23657e != null) {
                        ArcMenu.this.f23657e.a(childAt, i4);
                    }
                    ArcMenu.this.b(i4 - 1);
                    ArcMenu.this.b();
                }
            });
            i3 = i4;
        }
        b();
    }

    private void a(View view, float f2, float f3, int i2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f2, f3, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration((long) i2);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f23655c = this.f23655c == Status.CLOSE ? Status.OPEN : Status.CLOSE;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        int i3 = 0;
        while (i3 < getChildCount() - 1) {
            int i4 = i3 + 1;
            View childAt = getChildAt(i4);
            childAt.startAnimation(i3 == i2 ? d(300) : c(300));
            childAt.setClickable(false);
            childAt.setFocusable(false);
            i3 = i4;
        }
    }

    private Animation c(int i2) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration((long) i2);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    private Animation d(int i2) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 4.0f, 1.0f, 4.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration((long) i2);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    public void onClick(View view) {
        a(view, 0.0f, 360.0f, 300);
        a(300);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (z2) {
            a();
            int childCount = getChildCount();
            int i6 = 0;
            while (i6 < childCount - 1) {
                int i7 = i6 + 1;
                View childAt = getChildAt(i7);
                childAt.setVisibility(8);
                double d2 = (double) this.f23654b;
                double d3 = (double) (childCount - 2);
                Double.isNaN(d3);
                double d4 = 1.5707963267948966d / d3;
                double d5 = (double) i6;
                Double.isNaN(d5);
                double d6 = d4 * d5;
                double sin = Math.sin(d6);
                Double.isNaN(d2);
                int i8 = (int) (d2 * sin);
                double d7 = (double) this.f23654b;
                double cos = Math.cos(d6);
                Double.isNaN(d7);
                int i9 = (int) (d7 * cos);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.f23653a == Position.LEFT_BOTTOM || this.f23653a == Position.RIGHT_BOTTOM) {
                    i9 = (getMeasuredHeight() - measuredHeight) - i9;
                }
                if (this.f23653a == Position.RIGHT_TOP || this.f23653a == Position.RIGHT_BOTTOM) {
                    i8 = (getMeasuredWidth() - measuredWidth) - i8;
                }
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
                i6 = i7;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            measureChild(getChildAt(i4), i2, i3);
        }
        super.onMeasure(i2, i3);
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f23657e = aVar;
    }
}
