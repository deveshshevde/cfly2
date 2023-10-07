package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import ja.f;
import ja.j;

public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements f {

    /* renamed from: a  reason: collision with root package name */
    public static String f12117a;

    /* renamed from: b  reason: collision with root package name */
    public static String f12118b;

    /* renamed from: c  reason: collision with root package name */
    public static String f12119c;

    /* renamed from: d  reason: collision with root package name */
    public static String f12120d;

    /* renamed from: e  reason: collision with root package name */
    public static String f12121e;

    /* renamed from: f  reason: collision with root package name */
    public static String f12122f;

    /* renamed from: g  reason: collision with root package name */
    public static String f12123g;

    /* renamed from: h  reason: collision with root package name */
    protected String f12124h;

    /* renamed from: i  reason: collision with root package name */
    protected String f12125i;

    /* renamed from: j  reason: collision with root package name */
    protected String f12126j;

    /* renamed from: k  reason: collision with root package name */
    protected String f12127k;

    /* renamed from: l  reason: collision with root package name */
    protected String f12128l;

    /* renamed from: m  reason: collision with root package name */
    protected String f12129m;

    /* renamed from: n  reason: collision with root package name */
    protected String f12130n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f12131o;

    /* renamed from: com.scwang.smartrefresh.layout.footer.ClassicsFooter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12132a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12132a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12132a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12132a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12132a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12132a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12132a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.footer.ClassicsFooter.AnonymousClass1.<clinit>():void");
        }
    }

    public ClassicsFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassicsFooter(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            r0 = 0
            r7.<init>(r8, r9, r0)
            r7.f12131o = r0
            int r1 = com.scwang.smartrefresh.layout.R.layout.srl_classics_footer
            android.view.View.inflate(r8, r1, r7)
            int r1 = com.scwang.smartrefresh.layout.R.id.srl_classics_arrow
            android.view.View r1 = r7.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r7.E = r1
            int r2 = com.scwang.smartrefresh.layout.R.id.srl_classics_progress
            android.view.View r2 = r7.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r7.F = r2
            int r3 = com.scwang.smartrefresh.layout.R.id.srl_classics_title
            android.view.View r3 = r7.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r7.D = r3
            int[] r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter
            android.content.res.TypedArray r9 = r8.obtainStyledAttributes(r9, r3)
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r4 = (android.widget.RelativeLayout.LayoutParams) r4
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableMarginRight
            r6 = 1101004800(0x41a00000, float:20.0)
            int r6 = jc.b.a((float) r6)
            int r5 = r9.getDimensionPixelSize(r5, r6)
            r4.rightMargin = r5
            int r5 = r4.rightMargin
            r3.rightMargin = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableArrowSize
            int r6 = r3.width
            int r5 = r9.getLayoutDimension(r5, r6)
            r3.width = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableArrowSize
            int r6 = r3.height
            int r5 = r9.getLayoutDimension(r5, r6)
            r3.height = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableProgressSize
            int r6 = r4.width
            int r5 = r9.getLayoutDimension(r5, r6)
            r4.width = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableProgressSize
            int r6 = r4.height
            int r5 = r9.getLayoutDimension(r5, r6)
            r4.height = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableSize
            int r6 = r3.width
            int r5 = r9.getLayoutDimension(r5, r6)
            r3.width = r5
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableSize
            int r6 = r3.height
            int r5 = r9.getLayoutDimension(r5, r6)
            r3.height = r5
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableSize
            int r5 = r4.width
            int r3 = r9.getLayoutDimension(r3, r5)
            r4.width = r3
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableSize
            int r5 = r4.height
            int r3 = r9.getLayoutDimension(r3, r5)
            r4.height = r3
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlFinishDuration
            int r4 = r7.M
            int r3 = r9.getInt(r3, r4)
            r7.M = r3
            com.scwang.smartrefresh.layout.constant.b[] r3 = com.scwang.smartrefresh.layout.constant.b.f12104f
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlClassicsSpinnerStyle
            com.scwang.smartrefresh.layout.constant.b r5 = r7.f12189y
            int r5 = r5.f12105g
            int r4 = r9.getInt(r4, r5)
            r3 = r3[r4]
            r7.f12189y = r3
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableArrow
            boolean r3 = r9.hasValue(r3)
            r4 = -10066330(0xffffffffff666666, float:-3.0625412E38)
            if (r3 == 0) goto L_0x00ce
            android.widget.ImageView r3 = r7.E
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableArrow
            android.graphics.drawable.Drawable r5 = r9.getDrawable(r5)
        L_0x00ca:
            r3.setImageDrawable(r5)
            goto L_0x00e7
        L_0x00ce:
            android.widget.ImageView r3 = r7.E
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            if (r3 != 0) goto L_0x00e7
            com.scwang.smartrefresh.layout.internal.a r3 = new com.scwang.smartrefresh.layout.internal.a
            r3.<init>()
            r7.H = r3
            com.scwang.smartrefresh.layout.internal.b r3 = r7.H
            r3.a(r4)
            android.widget.ImageView r3 = r7.E
            com.scwang.smartrefresh.layout.internal.b r5 = r7.H
            goto L_0x00ca
        L_0x00e7:
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableProgress
            boolean r3 = r9.hasValue(r3)
            if (r3 == 0) goto L_0x00fb
            android.widget.ImageView r3 = r7.F
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableProgress
            android.graphics.drawable.Drawable r4 = r9.getDrawable(r4)
        L_0x00f7:
            r3.setImageDrawable(r4)
            goto L_0x0114
        L_0x00fb:
            android.widget.ImageView r3 = r7.F
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            if (r3 != 0) goto L_0x0114
            com.scwang.smartrefresh.layout.internal.c r3 = new com.scwang.smartrefresh.layout.internal.c
            r3.<init>()
            r7.I = r3
            com.scwang.smartrefresh.layout.internal.b r3 = r7.I
            r3.a(r4)
            android.widget.ImageView r3 = r7.F
            com.scwang.smartrefresh.layout.internal.b r4 = r7.I
            goto L_0x00f7
        L_0x0114:
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextSizeTitle
            boolean r3 = r9.hasValue(r3)
            if (r3 == 0) goto L_0x012e
            android.widget.TextView r3 = r7.D
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextSizeTitle
            r5 = 1098907648(0x41800000, float:16.0)
            int r5 = jc.b.a((float) r5)
            int r4 = r9.getDimensionPixelSize(r4, r5)
            float r4 = (float) r4
            r3.setTextSize(r0, r4)
        L_0x012e:
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlPrimaryColor
            boolean r3 = r9.hasValue(r3)
            if (r3 == 0) goto L_0x013f
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlPrimaryColor
            int r3 = r9.getColor(r3, r0)
            super.c(r3)
        L_0x013f:
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlAccentColor
            boolean r3 = r9.hasValue(r3)
            if (r3 == 0) goto L_0x0150
            int r3 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlAccentColor
            int r0 = r9.getColor(r3, r0)
            super.b(r0)
        L_0x0150:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextPulling
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x0161
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextPulling
            java.lang.String r0 = r9.getString(r0)
        L_0x015e:
            r7.f12124h = r0
            goto L_0x016d
        L_0x0161:
            java.lang.String r0 = f12117a
            if (r0 == 0) goto L_0x0166
            goto L_0x015e
        L_0x0166:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_pulling
            java.lang.String r0 = r8.getString(r0)
            goto L_0x015e
        L_0x016d:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextRelease
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x017e
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextRelease
            java.lang.String r0 = r9.getString(r0)
        L_0x017b:
            r7.f12125i = r0
            goto L_0x018a
        L_0x017e:
            java.lang.String r0 = f12118b
            if (r0 == 0) goto L_0x0183
            goto L_0x017b
        L_0x0183:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_release
            java.lang.String r0 = r8.getString(r0)
            goto L_0x017b
        L_0x018a:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextLoading
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x019b
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextLoading
            java.lang.String r0 = r9.getString(r0)
        L_0x0198:
            r7.f12126j = r0
            goto L_0x01a7
        L_0x019b:
            java.lang.String r0 = f12119c
            if (r0 == 0) goto L_0x01a0
            goto L_0x0198
        L_0x01a0:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_loading
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0198
        L_0x01a7:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextRefreshing
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x01b8
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextRefreshing
            java.lang.String r0 = r9.getString(r0)
        L_0x01b5:
            r7.f12127k = r0
            goto L_0x01c4
        L_0x01b8:
            java.lang.String r0 = f12120d
            if (r0 == 0) goto L_0x01bd
            goto L_0x01b5
        L_0x01bd:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_refreshing
            java.lang.String r0 = r8.getString(r0)
            goto L_0x01b5
        L_0x01c4:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextFinish
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x01d5
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextFinish
            java.lang.String r0 = r9.getString(r0)
        L_0x01d2:
            r7.f12128l = r0
            goto L_0x01e1
        L_0x01d5:
            java.lang.String r0 = f12121e
            if (r0 == 0) goto L_0x01da
            goto L_0x01d2
        L_0x01da:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_finish
            java.lang.String r0 = r8.getString(r0)
            goto L_0x01d2
        L_0x01e1:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextFailed
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x01f2
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextFailed
            java.lang.String r0 = r9.getString(r0)
        L_0x01ef:
            r7.f12129m = r0
            goto L_0x01fe
        L_0x01f2:
            java.lang.String r0 = f12122f
            if (r0 == 0) goto L_0x01f7
            goto L_0x01ef
        L_0x01f7:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_failed
            java.lang.String r0 = r8.getString(r0)
            goto L_0x01ef
        L_0x01fe:
            int r0 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextNothing
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L_0x020f
            int r8 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextNothing
            java.lang.String r8 = r9.getString(r8)
        L_0x020c:
            r7.f12130n = r8
            goto L_0x021d
        L_0x020f:
            java.lang.String r0 = f12123g
            if (r0 == 0) goto L_0x0216
            r7.f12130n = r0
            goto L_0x021d
        L_0x0216:
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_footer_nothing
            java.lang.String r8 = r8.getString(r0)
            goto L_0x020c
        L_0x021d:
            r9.recycle()
            android.view.ViewPropertyAnimator r8 = r2.animate()
            r9 = 0
            r8.setInterpolator(r9)
            android.widget.TextView r8 = r7.D
            boolean r9 = r7.isInEditMode()
            if (r9 == 0) goto L_0x0233
            java.lang.String r9 = r7.f12126j
            goto L_0x0235
        L_0x0233:
            java.lang.String r9 = r7.f12124h
        L_0x0235:
            r8.setText(r9)
            boolean r8 = r7.isInEditMode()
            r9 = 8
            if (r8 == 0) goto L_0x0244
            r1.setVisibility(r9)
            goto L_0x0247
        L_0x0244:
            r2.setVisibility(r9)
        L_0x0247:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.footer.ClassicsFooter.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public int a(j jVar, boolean z2) {
        if (this.f12131o) {
            return 0;
        }
        this.D.setText(z2 ? this.f12128l : this.f12129m);
        return super.a(jVar, z2);
    }

    public void a(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        float f2;
        ViewPropertyAnimator viewPropertyAnimator;
        ImageView imageView = this.E;
        if (!this.f12131o) {
            switch (AnonymousClass1.f12132a[refreshState2.ordinal()]) {
                case 1:
                    imageView.setVisibility(0);
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                    imageView.setVisibility(8);
                    this.D.setText(this.f12126j);
                    return;
                case 5:
                    this.D.setText(this.f12125i);
                    viewPropertyAnimator = imageView.animate();
                    f2 = 0.0f;
                    break;
                case 6:
                    this.D.setText(this.f12127k);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.D.setText(this.f12124h);
            viewPropertyAnimator = imageView.animate();
            f2 = 180.0f;
            viewPropertyAnimator.rotation(f2);
        }
    }

    public boolean a(boolean z2) {
        int i2;
        if (this.f12131o == z2) {
            return true;
        }
        this.f12131o = z2;
        ImageView imageView = this.E;
        if (z2) {
            this.D.setText(this.f12130n);
            i2 = 8;
        } else {
            this.D.setText(this.f12124h);
            i2 = 0;
        }
        imageView.setVisibility(i2);
        return true;
    }

    public void b(j jVar, int i2, int i3) {
        if (!this.f12131o) {
            super.b(jVar, i2, i3);
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f12189y == b.f12101c) {
            super.setPrimaryColors(iArr);
        }
    }
}
