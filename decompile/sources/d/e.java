package d;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.w;
import d.b;
import java.io.IOException;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private a f26683a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26684b;

    static class a extends b.c {
        int[][] L;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()][];
            }
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.L[a2] = iArr;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d2 = d();
            for (int i2 = 0; i2 < d2; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public void e(int i2, int i3) {
            super.e(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.L, 0, iArr, 0, i2);
            this.L = iArr;
        }

        public Drawable newDrawable() {
            return new e(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e() {
        this((a) null, (Resources) null);
    }

    e(a aVar) {
        if (aVar != null) {
            a((b.c) aVar);
        }
    }

    e(a aVar, Resources resources) {
        a((b.c) new a(aVar, this, resources));
        onStateChange(getState());
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.f26683a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                    Drawable drawable = null;
                    int resourceId = a2.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = w.a().a(context, resourceId);
                    }
                    a2.recycle();
                    int[] a3 = a(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next == 2) {
                            drawable = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    }
                    aVar.a(a3, drawable);
                }
            } else {
                return;
            }
        }
    }

    private void a(TypedArray typedArray) {
        a aVar = this.f26683a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f26648f |= typedArray.getChangingConfigurations();
        }
        aVar.f26653k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f26653k);
        aVar.f26656n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f26656n);
        aVar.C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.f26668z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f26668z);
    }

    /* access modifiers changed from: package-private */
    public void a(b.c cVar) {
        super.a(cVar);
        if (cVar instanceof a) {
            this.f26683a = (a) cVar;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public a c() {
        return new a(this.f26683a, this, (Resources) null);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(a2.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.f26684b && super.mutate() == this) {
            this.f26683a.a();
            this.f26684b = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b2 = this.f26683a.b(iArr);
        if (b2 < 0) {
            b2 = this.f26683a.b(StateSet.WILD_CARD);
        }
        return a(b2) || onStateChange;
    }
}
