package aj;

import aj.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends h implements b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<b.a> f136a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable.Callback f137b;

    /* renamed from: d  reason: collision with root package name */
    private a f138d;

    /* renamed from: e  reason: collision with root package name */
    private Context f139e;

    /* renamed from: f  reason: collision with root package name */
    private ArgbEvaluator f140f;

    /* renamed from: g  reason: collision with root package name */
    private Animator.AnimatorListener f141g;

    private static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f143a;

        /* renamed from: b  reason: collision with root package name */
        i f144b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f145c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f146d;

        /* renamed from: e  reason: collision with root package name */
        j.a<Animator, String> f147e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f143a = aVar.f143a;
                i iVar = aVar.f144b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    this.f144b = (i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    i iVar2 = (i) this.f144b.mutate();
                    this.f144b = iVar2;
                    iVar2.setCallback(callback);
                    this.f144b.setBounds(aVar.f144b.getBounds());
                    this.f144b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f146d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f146d = new ArrayList<>(size);
                    this.f147e = new j.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = aVar.f146d.get(i2);
                        Animator clone = animator.clone();
                        String str = aVar.f147e.get(animator);
                        clone.setTarget(this.f144b.a(str));
                        this.f146d.add(clone);
                        this.f147e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f145c == null) {
                this.f145c = new AnimatorSet();
            }
            this.f145c.playTogether(this.f146d);
        }

        public int getChangingConfigurations() {
            return this.f143a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f148a;

        public b(Drawable.ConstantState constantState) {
            this.f148a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f148a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f148a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c cVar = new c();
            cVar.f153c = this.f148a.newDrawable();
            cVar.f153c.setCallback(cVar.f137b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.f153c = this.f148a.newDrawable(resources);
            cVar.f153c.setCallback(cVar.f137b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.f153c = this.f148a.newDrawable(resources, theme);
            cVar.f153c.setCallback(cVar.f137b);
            return cVar;
        }
    }

    c() {
        this((Context) null, (a) null, (Resources) null);
    }

    private c(Context context) {
        this(context, (a) null, (Resources) null);
    }

    private c(Context context, a aVar, Resources resources) {
        this.f140f = null;
        this.f141g = null;
        this.f136a = null;
        AnonymousClass1 r0 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
                c.this.scheduleSelf(runnable, j2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.f137b = r0;
        this.f139e = context;
        if (aVar != null) {
            this.f138d = aVar;
        } else {
            this.f138d = new a(context, aVar, r0, resources);
        }
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                a(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f140f == null) {
                    this.f140f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f140f);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f138d.f144b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.f138d.f146d == null) {
            this.f138d.f146d = new ArrayList<>();
            this.f138d.f147e = new j.a<>();
        }
        this.f138d.f146d.add(animator);
        this.f138d.f147e.put(animator, str);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f153c != null) {
            return androidx.core.graphics.drawable.a.d(this.f153c);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.f153c != null) {
            this.f153c.draw(canvas);
            return;
        }
        this.f138d.f144b.draw(canvas);
        if (this.f138d.f145c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.c(this.f153c) : this.f138d.f144b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.f153c != null ? this.f153c.getChangingConfigurations() : super.getChangingConfigurations() | this.f138d.f143a;
    }

    public ColorFilter getColorFilter() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.e(this.f153c) : this.f138d.f144b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f153c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f153c.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f153c != null ? this.f153c.getIntrinsicHeight() : this.f138d.f144b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f153c != null ? this.f153c.getIntrinsicWidth() : this.f138d.f144b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f153c != null ? this.f153c.getOpacity() : this.f138d.f144b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes;
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = g.a(resources, theme, attributeSet, a.f128e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a2 = i.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.f137b);
                        if (this.f138d.f144b != null) {
                            this.f138d.f144b.setCallback((Drawable.Callback) null);
                        }
                        this.f138d.f144b = a2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.f129f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f139e;
                        if (context != null) {
                            a(string, e.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f138d.a();
    }

    public boolean isAutoMirrored() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.b(this.f153c) : this.f138d.f144b.isAutoMirrored();
    }

    public boolean isRunning() {
        return this.f153c != null ? ((AnimatedVectorDrawable) this.f153c).isRunning() : this.f138d.f145c.isRunning();
    }

    public boolean isStateful() {
        return this.f153c != null ? this.f153c.isStateful() : this.f138d.f144b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f153c != null) {
            this.f153c.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f153c != null) {
            this.f153c.setBounds(rect);
        } else {
            this.f138d.f144b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f153c != null ? this.f153c.setLevel(i2) : this.f138d.f144b.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return this.f153c != null ? this.f153c.setState(iArr) : this.f138d.f144b.setState(iArr);
    }

    public void setAlpha(int i2) {
        if (this.f153c != null) {
            this.f153c.setAlpha(i2);
        } else {
            this.f138d.f144b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z2) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, z2);
        } else {
            this.f138d.f144b.setAutoMirrored(z2);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f153c != null) {
            this.f153c.setColorFilter(colorFilter);
        } else {
            this.f138d.f144b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, i2);
        } else {
            this.f138d.f144b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, colorStateList);
        } else {
            this.f138d.f144b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, mode);
        } else {
            this.f138d.f144b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        if (this.f153c != null) {
            return this.f153c.setVisible(z2, z3);
        }
        this.f138d.f144b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    public void start() {
        if (this.f153c != null) {
            ((AnimatedVectorDrawable) this.f153c).start();
        } else if (!this.f138d.f145c.isStarted()) {
            this.f138d.f145c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f153c != null) {
            ((AnimatedVectorDrawable) this.f153c).stop();
        } else {
            this.f138d.f145c.end();
        }
    }
}
