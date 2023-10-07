package d;

import aj.i;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.w;
import d.b;
import d.e;
import j.h;
import java.io.IOException;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class a extends e implements androidx.core.graphics.drawable.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26616a = "a";

    /* renamed from: b  reason: collision with root package name */
    private b f26617b;

    /* renamed from: c  reason: collision with root package name */
    private f f26618c;

    /* renamed from: d  reason: collision with root package name */
    private int f26619d;

    /* renamed from: e  reason: collision with root package name */
    private int f26620e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26621f;

    /* renamed from: d.a$a  reason: collision with other inner class name */
    private static class C0162a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f26622a;

        C0162a(Animatable animatable) {
            super();
            this.f26622a = animatable;
        }

        public void a() {
            this.f26622a.start();
        }

        public void b() {
            this.f26622a.stop();
        }
    }

    static class b extends e.a {

        /* renamed from: a  reason: collision with root package name */
        j.d<Long> f26623a;

        /* renamed from: b  reason: collision with root package name */
        h<Integer> f26624b;

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            h<Integer> hVar;
            if (bVar != null) {
                this.f26623a = bVar.f26623a;
                hVar = bVar.f26624b;
            } else {
                this.f26623a = new j.d<>();
                hVar = new h<>();
            }
            this.f26624b = hVar;
        }

        private static long f(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.f26624b.a(i2, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3) {
            return (int) this.f26623a.a(f(i2, i3), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3, Drawable drawable, boolean z2) {
            int a2 = super.a(drawable);
            long f2 = f(i2, i3);
            long j2 = z2 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : 0;
            long j3 = (long) a2;
            this.f26623a.c(f2, Long.valueOf(j3 | j2));
            if (z2) {
                this.f26623a.c(f(i3, i2), Long.valueOf(IjkMediaMeta.AV_CH_WIDE_RIGHT | j3 | j2));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr) {
            int b2 = super.b(iArr);
            return b2 >= 0 ? b2 : super.b(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable, int i2) {
            int a2 = super.a(iArr, drawable);
            this.f26624b.b(a2, Integer.valueOf(i2));
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f26623a = this.f26623a.clone();
            this.f26624b = this.f26624b.clone();
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2, int i3) {
            return (this.f26623a.a(f(i2, i3), -1L).longValue() & IjkMediaMeta.AV_CH_WIDE_RIGHT) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i2, int i3) {
            return (this.f26623a.a(f(i2, i3), -1L).longValue() & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    private static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private final aj.c f26625a;

        c(aj.c cVar) {
            super();
            this.f26625a = cVar;
        }

        public void a() {
            this.f26625a.start();
        }

        public void b() {
            this.f26625a.stop();
        }
    }

    private static class d extends f {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f26626a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f26627b;

        d(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z2 ? numberOfFrames - 1 : 0;
            int i3 = z2 ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z2);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i2, i3});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.a());
            ofInt.setInterpolator(eVar);
            this.f26627b = z3;
            this.f26626a = ofInt;
        }

        public void a() {
            this.f26626a.start();
        }

        public void b() {
            this.f26626a.cancel();
        }

        public boolean c() {
            return this.f26627b;
        }

        public void d() {
            this.f26626a.reverse();
        }
    }

    private static class e implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f26628a;

        /* renamed from: b  reason: collision with root package name */
        private int f26629b;

        /* renamed from: c  reason: collision with root package name */
        private int f26630c;

        e(AnimationDrawable animationDrawable, boolean z2) {
            a(animationDrawable, z2);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f26630c;
        }

        /* access modifiers changed from: package-private */
        public int a(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f26629b = numberOfFrames;
            int[] iArr = this.f26628a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f26628a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f26628a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f26630c = i2;
            return i2;
        }

        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.f26630c)) + 0.5f);
            int i3 = this.f26629b;
            int[] iArr = this.f26628a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.f26630c) : 0.0f);
        }
    }

    private static abstract class f {
        private f() {
        }

        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }
    }

    public a() {
        this((b) null, (Resources) null);
    }

    a(b bVar, Resources resources) {
        super((e.a) null);
        this.f26619d = -1;
        this.f26620e = -1;
        a((b.c) new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void a(TypedArray typedArray) {
        b bVar = this.f26617b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f26648f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f26653k));
        bVar.b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.f26656n));
        bVar.c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.f26668z));
    }

    private boolean b(int i2) {
        int i3;
        int a2;
        f fVar;
        f fVar2 = this.f26618c;
        if (fVar2 == null) {
            i3 = d();
        } else if (i2 == this.f26619d) {
            return true;
        } else {
            if (i2 != this.f26620e || !fVar2.c()) {
                i3 = this.f26619d;
                fVar2.b();
            } else {
                fVar2.d();
                this.f26619d = this.f26620e;
                this.f26620e = i2;
                return true;
            }
        }
        this.f26618c = null;
        this.f26620e = -1;
        this.f26619d = -1;
        b bVar = this.f26617b;
        int a3 = bVar.a(i3);
        int a4 = bVar.a(i2);
        if (a4 == 0 || a3 == 0 || (a2 = bVar.a(a3, a4)) < 0) {
            return false;
        }
        boolean c2 = bVar.c(a3, a4);
        a(a2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            fVar = new d((AnimationDrawable) current, bVar.b(a3, a4), c2);
        } else if (current instanceof aj.c) {
            fVar = new c((aj.c) current);
        } else {
            if (current instanceof Animatable) {
                fVar = new C0162a((Animatable) current);
            }
            return false;
        }
        fVar.a();
        this.f26618c = fVar;
        this.f26620e = i3;
        this.f26619d = i2;
        return true;
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        e(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        d(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a3 = resourceId3 > 0 ? w.a().a(context, resourceId3) : null;
        boolean z2 = a2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                a3 = xmlPullParser.getName().equals("animated-vector") ? aj.c.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f26617b.a(resourceId, resourceId2, a3, z2);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a3 = resourceId2 > 0 ? w.a().a(context, resourceId2) : null;
        a2.recycle();
        int[] a4 = a(attributeSet);
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                a3 = xmlPullParser.getName().equals("vector") ? i.a(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (a3 != null) {
            return this.f26617b.a(a4, a3, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private void e() {
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public b c() {
        return new b(this.f26617b, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    public void a(b.c cVar) {
        super.a(cVar);
        if (cVar instanceof b) {
            this.f26617b = (b) cVar;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.f26618c;
        if (fVar != null) {
            fVar.b();
            this.f26618c = null;
            a(this.f26619d);
            this.f26619d = -1;
            this.f26620e = -1;
        }
    }

    public Drawable mutate() {
        if (!this.f26621f && super.mutate() == this) {
            this.f26617b.a();
            this.f26621f = true;
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int a2 = this.f26617b.a(iArr);
        boolean z2 = a2 != d() && (b(a2) || a(a2));
        Drawable current = getCurrent();
        return current != null ? z2 | current.setState(iArr) : z2;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z2) {
        super.setAutoMirrored(z2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z2) {
        super.setDither(z2);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        f fVar = this.f26618c;
        if (fVar != null && (visible || z3)) {
            if (z2) {
                fVar.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }
}
