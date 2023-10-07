package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import ja.g;
import ja.j;
import java.text.DateFormat;
import java.util.Date;

public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12155a = R.id.srl_classics_update;

    /* renamed from: b  reason: collision with root package name */
    public static String f12156b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f12157c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12158d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f12159e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f12160f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f12161g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f12162h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f12163i = null;

    /* renamed from: j  reason: collision with root package name */
    protected String f12164j;

    /* renamed from: k  reason: collision with root package name */
    protected Date f12165k;

    /* renamed from: l  reason: collision with root package name */
    protected TextView f12166l;

    /* renamed from: m  reason: collision with root package name */
    protected SharedPreferences f12167m;

    /* renamed from: n  reason: collision with root package name */
    protected DateFormat f12168n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f12169o;

    /* renamed from: p  reason: collision with root package name */
    protected String f12170p;

    /* renamed from: q  reason: collision with root package name */
    protected String f12171q;

    /* renamed from: r  reason: collision with root package name */
    protected String f12172r;

    /* renamed from: s  reason: collision with root package name */
    protected String f12173s;

    /* renamed from: t  reason: collision with root package name */
    protected String f12174t;

    /* renamed from: u  reason: collision with root package name */
    protected String f12175u;

    /* renamed from: v  reason: collision with root package name */
    protected String f12176v;

    /* renamed from: w  reason: collision with root package name */
    protected String f12177w;

    /* renamed from: com.scwang.smartrefresh.layout.header.ClassicsHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12178a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12178a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f12178a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.ClassicsHeader.AnonymousClass1.<clinit>():void");
        }
    }

    public ClassicsHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassicsHeader(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r0 = 0
            r9.<init>(r10, r11, r0)
            java.lang.String r1 = "LAST_UPDATE_TIME"
            r9.f12164j = r1
            r1 = 1
            r9.f12169o = r1
            int r1 = com.scwang.smartrefresh.layout.R.layout.srl_classics_header
            android.view.View.inflate(r10, r1, r9)
            int r1 = com.scwang.smartrefresh.layout.R.id.srl_classics_arrow
            android.view.View r1 = r9.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r9.E = r1
            int r2 = com.scwang.smartrefresh.layout.R.id.srl_classics_update
            android.view.View r2 = r9.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r9.f12166l = r2
            int r3 = com.scwang.smartrefresh.layout.R.id.srl_classics_progress
            android.view.View r3 = r9.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r9.F = r3
            int r4 = com.scwang.smartrefresh.layout.R.id.srl_classics_title
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r9.D = r4
            int[] r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader
            android.content.res.TypedArray r11 = r10.obtainStyledAttributes(r11, r4)
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r4 = (android.widget.RelativeLayout.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            int r7 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextTimeMarginTop
            r8 = 0
            int r8 = jc.b.a((float) r8)
            int r7 = r11.getDimensionPixelSize(r7, r8)
            r6.topMargin = r7
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableMarginRight
            r7 = 1101004800(0x41a00000, float:20.0)
            int r7 = jc.b.a((float) r7)
            int r6 = r11.getDimensionPixelSize(r6, r7)
            r5.rightMargin = r6
            int r6 = r5.rightMargin
            r4.rightMargin = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrowSize
            int r7 = r4.width
            int r6 = r11.getLayoutDimension(r6, r7)
            r4.width = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrowSize
            int r7 = r4.height
            int r6 = r11.getLayoutDimension(r6, r7)
            r4.height = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgressSize
            int r7 = r5.width
            int r6 = r11.getLayoutDimension(r6, r7)
            r5.width = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgressSize
            int r7 = r5.height
            int r6 = r11.getLayoutDimension(r6, r7)
            r5.height = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize
            int r7 = r4.width
            int r6 = r11.getLayoutDimension(r6, r7)
            r4.width = r6
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize
            int r7 = r4.height
            int r6 = r11.getLayoutDimension(r6, r7)
            r4.height = r6
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize
            int r6 = r5.width
            int r4 = r11.getLayoutDimension(r4, r6)
            r5.width = r4
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize
            int r6 = r5.height
            int r4 = r11.getLayoutDimension(r4, r6)
            r5.height = r4
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlFinishDuration
            int r5 = r9.M
            int r4 = r11.getInt(r4, r5)
            r9.M = r4
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlEnableLastTime
            boolean r5 = r9.f12169o
            boolean r4 = r11.getBoolean(r4, r5)
            r9.f12169o = r4
            com.scwang.smartrefresh.layout.constant.b[] r4 = com.scwang.smartrefresh.layout.constant.b.f12104f
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlClassicsSpinnerStyle
            com.scwang.smartrefresh.layout.constant.b r6 = r9.f12189y
            int r6 = r6.f12105g
            int r5 = r11.getInt(r5, r6)
            r4 = r4[r5]
            r9.f12189y = r4
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrow
            boolean r4 = r11.hasValue(r4)
            r5 = -10066330(0xffffffffff666666, float:-3.0625412E38)
            if (r4 == 0) goto L_0x00fa
            android.widget.ImageView r4 = r9.E
            int r6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrow
            android.graphics.drawable.Drawable r6 = r11.getDrawable(r6)
        L_0x00f6:
            r4.setImageDrawable(r6)
            goto L_0x0113
        L_0x00fa:
            android.widget.ImageView r4 = r9.E
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            if (r4 != 0) goto L_0x0113
            com.scwang.smartrefresh.layout.internal.a r4 = new com.scwang.smartrefresh.layout.internal.a
            r4.<init>()
            r9.H = r4
            com.scwang.smartrefresh.layout.internal.b r4 = r9.H
            r4.a(r5)
            android.widget.ImageView r4 = r9.E
            com.scwang.smartrefresh.layout.internal.b r6 = r9.H
            goto L_0x00f6
        L_0x0113:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgress
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0127
            android.widget.ImageView r4 = r9.F
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgress
            android.graphics.drawable.Drawable r5 = r11.getDrawable(r5)
        L_0x0123:
            r4.setImageDrawable(r5)
            goto L_0x0140
        L_0x0127:
            android.widget.ImageView r4 = r9.F
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            if (r4 != 0) goto L_0x0140
            com.scwang.smartrefresh.layout.internal.c r4 = new com.scwang.smartrefresh.layout.internal.c
            r4.<init>()
            r9.I = r4
            com.scwang.smartrefresh.layout.internal.b r4 = r9.I
            r4.a(r5)
            android.widget.ImageView r4 = r9.F
            com.scwang.smartrefresh.layout.internal.b r5 = r9.I
            goto L_0x0123
        L_0x0140:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTitle
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x015a
            android.widget.TextView r4 = r9.D
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTitle
            r6 = 1098907648(0x41800000, float:16.0)
            int r6 = jc.b.a((float) r6)
            int r5 = r11.getDimensionPixelSize(r5, r6)
            float r5 = (float) r5
            r4.setTextSize(r0, r5)
        L_0x015a:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTime
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0174
            android.widget.TextView r4 = r9.f12166l
            int r5 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTime
            r6 = 1094713344(0x41400000, float:12.0)
            int r6 = jc.b.a((float) r6)
            int r5 = r11.getDimensionPixelSize(r5, r6)
            float r5 = (float) r5
            r4.setTextSize(r0, r5)
        L_0x0174:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlPrimaryColor
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0185
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlPrimaryColor
            int r4 = r11.getColor(r4, r0)
            super.c(r4)
        L_0x0185:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlAccentColor
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0196
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlAccentColor
            int r4 = r11.getColor(r4, r0)
            r9.b((int) r4)
        L_0x0196:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextPulling
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x01a7
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextPulling
            java.lang.String r4 = r11.getString(r4)
        L_0x01a4:
            r9.f12170p = r4
            goto L_0x01b3
        L_0x01a7:
            java.lang.String r4 = f12156b
            if (r4 == 0) goto L_0x01ac
            goto L_0x01a4
        L_0x01ac:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_pulling
            java.lang.String r4 = r10.getString(r4)
            goto L_0x01a4
        L_0x01b3:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextLoading
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x01c4
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextLoading
            java.lang.String r4 = r11.getString(r4)
        L_0x01c1:
            r9.f12172r = r4
            goto L_0x01d0
        L_0x01c4:
            java.lang.String r4 = f12158d
            if (r4 == 0) goto L_0x01c9
            goto L_0x01c1
        L_0x01c9:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_loading
            java.lang.String r4 = r10.getString(r4)
            goto L_0x01c1
        L_0x01d0:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextRelease
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x01e1
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextRelease
            java.lang.String r4 = r11.getString(r4)
        L_0x01de:
            r9.f12173s = r4
            goto L_0x01ed
        L_0x01e1:
            java.lang.String r4 = f12159e
            if (r4 == 0) goto L_0x01e6
            goto L_0x01de
        L_0x01e6:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_release
            java.lang.String r4 = r10.getString(r4)
            goto L_0x01de
        L_0x01ed:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextFinish
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x01fe
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextFinish
            java.lang.String r4 = r11.getString(r4)
        L_0x01fb:
            r9.f12174t = r4
            goto L_0x020a
        L_0x01fe:
            java.lang.String r4 = f12160f
            if (r4 == 0) goto L_0x0203
            goto L_0x01fb
        L_0x0203:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_finish
            java.lang.String r4 = r10.getString(r4)
            goto L_0x01fb
        L_0x020a:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextFailed
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x021b
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextFailed
            java.lang.String r4 = r11.getString(r4)
        L_0x0218:
            r9.f12175u = r4
            goto L_0x0227
        L_0x021b:
            java.lang.String r4 = f12161g
            if (r4 == 0) goto L_0x0220
            goto L_0x0218
        L_0x0220:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_failed
            java.lang.String r4 = r10.getString(r4)
            goto L_0x0218
        L_0x0227:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSecondary
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0238
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSecondary
            java.lang.String r4 = r11.getString(r4)
        L_0x0235:
            r9.f12177w = r4
            goto L_0x0244
        L_0x0238:
            java.lang.String r4 = f12163i
            if (r4 == 0) goto L_0x023d
            goto L_0x0235
        L_0x023d:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_secondary
            java.lang.String r4 = r10.getString(r4)
            goto L_0x0235
        L_0x0244:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextRefreshing
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0255
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextRefreshing
            java.lang.String r4 = r11.getString(r4)
        L_0x0252:
            r9.f12171q = r4
            goto L_0x0261
        L_0x0255:
            java.lang.String r4 = f12157c
            if (r4 == 0) goto L_0x025a
            goto L_0x0252
        L_0x025a:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_refreshing
            java.lang.String r4 = r10.getString(r4)
            goto L_0x0252
        L_0x0261:
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextUpdate
            boolean r4 = r11.hasValue(r4)
            if (r4 == 0) goto L_0x0272
            int r4 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextUpdate
            java.lang.String r4 = r11.getString(r4)
        L_0x026f:
            r9.f12176v = r4
            goto L_0x027e
        L_0x0272:
            java.lang.String r4 = f12162h
            if (r4 == 0) goto L_0x0277
            goto L_0x026f
        L_0x0277:
            int r4 = com.scwang.smartrefresh.layout.R.string.srl_header_update
            java.lang.String r4 = r10.getString(r4)
            goto L_0x026f
        L_0x027e:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = r9.f12176v
            java.util.Locale r6 = java.util.Locale.getDefault()
            r4.<init>(r5, r6)
            r9.f12168n = r4
            r11.recycle()
            android.view.ViewPropertyAnimator r11 = r3.animate()
            r4 = 0
            r11.setInterpolator(r4)
            boolean r11 = r9.f12169o
            r4 = 8
            if (r11 == 0) goto L_0x029e
            r11 = 0
            goto L_0x02a0
        L_0x029e:
            r11 = 8
        L_0x02a0:
            r2.setVisibility(r11)
            android.widget.TextView r11 = r9.D
            boolean r2 = r9.isInEditMode()
            if (r2 == 0) goto L_0x02ae
            java.lang.String r2 = r9.f12171q
            goto L_0x02b0
        L_0x02ae:
            java.lang.String r2 = r9.f12170p
        L_0x02b0:
            r11.setText(r2)
            boolean r11 = r9.isInEditMode()
            if (r11 == 0) goto L_0x02bd
            r1.setVisibility(r4)
            goto L_0x02c0
        L_0x02bd:
            r3.setVisibility(r4)
        L_0x02c0:
            boolean r11 = r10 instanceof androidx.fragment.app.FragmentActivity     // Catch:{ all -> 0x02e2 }
            if (r11 == 0) goto L_0x02e6
            r11 = r10
            androidx.fragment.app.FragmentActivity r11 = (androidx.fragment.app.FragmentActivity) r11     // Catch:{ all -> 0x02e2 }
            androidx.fragment.app.FragmentManager r11 = r11.getSupportFragmentManager()     // Catch:{ all -> 0x02e2 }
            if (r11 == 0) goto L_0x02e6
            java.util.List r11 = r11.g()     // Catch:{ all -> 0x02e2 }
            if (r11 == 0) goto L_0x02e6
            int r11 = r11.size()     // Catch:{ all -> 0x02e2 }
            if (r11 <= 0) goto L_0x02e6
            java.util.Date r11 = new java.util.Date     // Catch:{ all -> 0x02e2 }
            r11.<init>()     // Catch:{ all -> 0x02e2 }
            r9.a((java.util.Date) r11)     // Catch:{ all -> 0x02e2 }
            return
        L_0x02e2:
            r11 = move-exception
            r11.printStackTrace()
        L_0x02e6:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = r9.f12164j
            r11.append(r1)
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getName()
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            r9.f12164j = r11
            java.lang.String r11 = "ClassicsHeader"
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r11, r0)
            r9.f12167m = r10
            java.util.Date r10 = new java.util.Date
            android.content.SharedPreferences r11 = r9.f12167m
            java.lang.String r0 = r9.f12164j
            long r1 = java.lang.System.currentTimeMillis()
            long r0 = r11.getLong(r0, r1)
            r10.<init>(r0)
            r9.a((java.util.Date) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.ClassicsHeader.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public int a(j jVar, boolean z2) {
        TextView textView = this.D;
        if (z2) {
            textView.setText(this.f12174t);
            if (this.f12165k != null) {
                a(new Date());
            }
        } else {
            textView.setText(this.f12175u);
        }
        return super.a(jVar, z2);
    }

    /* renamed from: a */
    public ClassicsHeader b(int i2) {
        this.f12166l.setTextColor((16777215 & i2) | -872415232);
        return (ClassicsHeader) super.b(i2);
    }

    public ClassicsHeader a(Date date) {
        this.f12165k = date;
        this.f12166l.setText(this.f12168n.format(date));
        if (this.f12167m != null && !isInEditMode()) {
            this.f12167m.edit().putLong(this.f12164j, date.getTime()).apply();
        }
        return this;
    }

    public void a(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.E;
        TextView textView = this.f12166l;
        int i2 = 8;
        switch (AnonymousClass1.f12178a[refreshState2.ordinal()]) {
            case 1:
                if (this.f12169o) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.D.setText(this.f12171q);
                imageView.setVisibility(8);
                return;
            case 5:
                this.D.setText(this.f12173s);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.D.setText(this.f12177w);
                break;
            case 7:
                imageView.setVisibility(8);
                if (this.f12169o) {
                    i2 = 4;
                }
                textView.setVisibility(i2);
                this.D.setText(this.f12172r);
                return;
            default:
                return;
        }
        this.D.setText(this.f12170p);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }
}
