package aj;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import m.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f154a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f155b;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f156d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f157e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f158f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f159g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable.ConstantState f160h;

    /* renamed from: i  reason: collision with root package name */
    private final float[] f161i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f162j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f163k;

    private static class a extends e {
        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f190m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f189l = m.c.b(string2);
            }
            this.f191n = l.g.a(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (l.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = l.g.a(resources, theme, attributeSet, a.f127d);
                a(a2, xmlPullParser);
                a2.recycle();
            }
        }

        public boolean a() {
            return true;
        }
    }

    private static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        l.b f164a;

        /* renamed from: b  reason: collision with root package name */
        float f165b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        l.b f166c;

        /* renamed from: d  reason: collision with root package name */
        float f167d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f168e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f169f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        float f170g = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        float f171h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        Paint.Cap f172i = Paint.Cap.BUTT;

        /* renamed from: j  reason: collision with root package name */
        Paint.Join f173j = Paint.Join.MITER;

        /* renamed from: k  reason: collision with root package name */
        float f174k = 4.0f;

        /* renamed from: p  reason: collision with root package name */
        private int[] f175p;

        b() {
        }

        b(b bVar) {
            super(bVar);
            this.f175p = bVar.f175p;
            this.f164a = bVar.f164a;
            this.f165b = bVar.f165b;
            this.f167d = bVar.f167d;
            this.f166c = bVar.f166c;
            this.f191n = bVar.f191n;
            this.f168e = bVar.f168e;
            this.f169f = bVar.f169f;
            this.f170g = bVar.f170g;
            this.f171h = bVar.f171h;
            this.f172i = bVar.f172i;
            this.f173j = bVar.f173j;
            this.f174k = bVar.f174k;
        }

        private Paint.Cap a(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join a(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f175p = null;
            if (l.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f190m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f189l = m.c.b(string2);
                }
                Resources.Theme theme2 = theme;
                this.f166c = l.g.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f168e = l.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f168e);
                this.f172i = a(l.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f172i);
                this.f173j = a(l.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f173j);
                this.f174k = l.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f174k);
                this.f164a = l.g.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f167d = l.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f167d);
                this.f165b = l.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f165b);
                this.f170g = l.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f170g);
                this.f171h = l.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f171h);
                this.f169f = l.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f169f);
                this.f191n = l.g.a(typedArray, xmlPullParser, "fillType", 13, this.f191n);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = l.g.a(resources, theme, attributeSet, a.f126c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        public boolean a(int[] iArr) {
            return this.f164a.a(iArr) | this.f166c.a(iArr);
        }

        public boolean b() {
            return this.f166c.d() || this.f164a.d();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f168e;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f166c.b();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f167d;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f164a.b();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f165b;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f170g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f171h;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f169f;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.f168e = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.f166c.b(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.f167d = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f164a.b(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f165b = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.f170g = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.f171h = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f169f = f2;
        }
    }

    private static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f176a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f177b;

        /* renamed from: c  reason: collision with root package name */
        float f178c;

        /* renamed from: d  reason: collision with root package name */
        final Matrix f179d;

        /* renamed from: e  reason: collision with root package name */
        int f180e;

        /* renamed from: f  reason: collision with root package name */
        private float f181f;

        /* renamed from: g  reason: collision with root package name */
        private float f182g;

        /* renamed from: h  reason: collision with root package name */
        private float f183h;

        /* renamed from: i  reason: collision with root package name */
        private float f184i;

        /* renamed from: j  reason: collision with root package name */
        private float f185j;

        /* renamed from: k  reason: collision with root package name */
        private float f186k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f187l;

        /* renamed from: m  reason: collision with root package name */
        private String f188m;

        public c() {
            super();
            this.f176a = new Matrix();
            this.f177b = new ArrayList<>();
            this.f178c = 0.0f;
            this.f181f = 0.0f;
            this.f182g = 0.0f;
            this.f183h = 1.0f;
            this.f184i = 1.0f;
            this.f185j = 0.0f;
            this.f186k = 0.0f;
            this.f179d = new Matrix();
            this.f188m = null;
        }

        public c(c cVar, j.a<String, Object> aVar) {
            super();
            e eVar;
            this.f176a = new Matrix();
            this.f177b = new ArrayList<>();
            this.f178c = 0.0f;
            this.f181f = 0.0f;
            this.f182g = 0.0f;
            this.f183h = 1.0f;
            this.f184i = 1.0f;
            this.f185j = 0.0f;
            this.f186k = 0.0f;
            Matrix matrix = new Matrix();
            this.f179d = matrix;
            this.f188m = null;
            this.f178c = cVar.f178c;
            this.f181f = cVar.f181f;
            this.f182g = cVar.f182g;
            this.f183h = cVar.f183h;
            this.f184i = cVar.f184i;
            this.f185j = cVar.f185j;
            this.f186k = cVar.f186k;
            this.f187l = cVar.f187l;
            String str = cVar.f188m;
            this.f188m = str;
            this.f180e = cVar.f180e;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(cVar.f179d);
            ArrayList<d> arrayList = cVar.f177b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = arrayList.get(i2);
                if (dVar instanceof c) {
                    this.f177b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f177b.add(eVar);
                    if (eVar.f190m != null) {
                        aVar.put(eVar.f190m, eVar);
                    }
                }
            }
        }

        private void a() {
            this.f179d.reset();
            this.f179d.postTranslate(-this.f181f, -this.f182g);
            this.f179d.postScale(this.f183h, this.f184i);
            this.f179d.postRotate(this.f178c, 0.0f, 0.0f);
            this.f179d.postTranslate(this.f185j + this.f181f, this.f186k + this.f182g);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f187l = null;
            this.f178c = l.g.a(typedArray, xmlPullParser, "rotation", 5, this.f178c);
            this.f181f = typedArray.getFloat(1, this.f181f);
            this.f182g = typedArray.getFloat(2, this.f182g);
            this.f183h = l.g.a(typedArray, xmlPullParser, "scaleX", 3, this.f183h);
            this.f184i = l.g.a(typedArray, xmlPullParser, "scaleY", 4, this.f184i);
            this.f185j = l.g.a(typedArray, xmlPullParser, "translateX", 6, this.f185j);
            this.f186k = l.g.a(typedArray, xmlPullParser, "translateY", 7, this.f186k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f188m = string;
            }
            a();
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = l.g.a(resources, theme, attributeSet, a.f125b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        public boolean a(int[] iArr) {
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f177b.size(); i2++) {
                z2 |= this.f177b.get(i2).a(iArr);
            }
            return z2;
        }

        public boolean b() {
            for (int i2 = 0; i2 < this.f177b.size(); i2++) {
                if (this.f177b.get(i2).b()) {
                    return true;
                }
            }
            return false;
        }

        public String getGroupName() {
            return this.f188m;
        }

        public Matrix getLocalMatrix() {
            return this.f179d;
        }

        public float getPivotX() {
            return this.f181f;
        }

        public float getPivotY() {
            return this.f182g;
        }

        public float getRotation() {
            return this.f178c;
        }

        public float getScaleX() {
            return this.f183h;
        }

        public float getScaleY() {
            return this.f184i;
        }

        public float getTranslateX() {
            return this.f185j;
        }

        public float getTranslateY() {
            return this.f186k;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f181f) {
                this.f181f = f2;
                a();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f182g) {
                this.f182g = f2;
                a();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f178c) {
                this.f178c = f2;
                a();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f183h) {
                this.f183h = f2;
                a();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f184i) {
                this.f184i = f2;
                a();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f185j) {
                this.f185j = f2;
                a();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f186k) {
                this.f186k = f2;
                a();
            }
        }
    }

    private static abstract class d {
        private d() {
        }

        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }
    }

    private static abstract class e extends d {

        /* renamed from: l  reason: collision with root package name */
        protected c.b[] f189l = null;

        /* renamed from: m  reason: collision with root package name */
        String f190m;

        /* renamed from: n  reason: collision with root package name */
        int f191n = 0;

        /* renamed from: o  reason: collision with root package name */
        int f192o;

        public e() {
            super();
        }

        public e(e eVar) {
            super();
            this.f190m = eVar.f190m;
            this.f192o = eVar.f192o;
            this.f189l = m.c.a(eVar.f189l);
        }

        public void a(Path path) {
            path.reset();
            c.b[] bVarArr = this.f189l;
            if (bVarArr != null) {
                c.b.a(bVarArr, path);
            }
        }

        public boolean a() {
            return false;
        }

        public c.b[] getPathData() {
            return this.f189l;
        }

        public String getPathName() {
            return this.f190m;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!m.c.a(this.f189l, bVarArr)) {
                this.f189l = m.c.a(bVarArr);
            } else {
                m.c.b(this.f189l, bVarArr);
            }
        }
    }

    private static class f {

        /* renamed from: n  reason: collision with root package name */
        private static final Matrix f193n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f194a;

        /* renamed from: b  reason: collision with root package name */
        Paint f195b;

        /* renamed from: c  reason: collision with root package name */
        final c f196c;

        /* renamed from: d  reason: collision with root package name */
        float f197d;

        /* renamed from: e  reason: collision with root package name */
        float f198e;

        /* renamed from: f  reason: collision with root package name */
        float f199f;

        /* renamed from: g  reason: collision with root package name */
        float f200g;

        /* renamed from: h  reason: collision with root package name */
        int f201h;

        /* renamed from: i  reason: collision with root package name */
        String f202i;

        /* renamed from: j  reason: collision with root package name */
        Boolean f203j;

        /* renamed from: k  reason: collision with root package name */
        final j.a<String, Object> f204k;

        /* renamed from: l  reason: collision with root package name */
        private final Path f205l;

        /* renamed from: m  reason: collision with root package name */
        private final Path f206m;

        /* renamed from: o  reason: collision with root package name */
        private final Matrix f207o;

        /* renamed from: p  reason: collision with root package name */
        private PathMeasure f208p;

        /* renamed from: q  reason: collision with root package name */
        private int f209q;

        public f() {
            this.f207o = new Matrix();
            this.f197d = 0.0f;
            this.f198e = 0.0f;
            this.f199f = 0.0f;
            this.f200g = 0.0f;
            this.f201h = 255;
            this.f202i = null;
            this.f203j = null;
            this.f204k = new j.a<>();
            this.f196c = new c();
            this.f205l = new Path();
            this.f206m = new Path();
        }

        public f(f fVar) {
            this.f207o = new Matrix();
            this.f197d = 0.0f;
            this.f198e = 0.0f;
            this.f199f = 0.0f;
            this.f200g = 0.0f;
            this.f201h = 255;
            this.f202i = null;
            this.f203j = null;
            j.a<String, Object> aVar = new j.a<>();
            this.f204k = aVar;
            this.f196c = new c(fVar.f196c, aVar);
            this.f205l = new Path(fVar.f205l);
            this.f206m = new Path(fVar.f206m);
            this.f197d = fVar.f197d;
            this.f198e = fVar.f198e;
            this.f199f = fVar.f199f;
            this.f200g = fVar.f200g;
            this.f209q = fVar.f209q;
            this.f201h = fVar.f201h;
            this.f202i = fVar.f202i;
            String str = fVar.f202i;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f203j = fVar.f203j;
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        private void a(c cVar, e eVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f199f;
            float f3 = ((float) i3) / this.f200g;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f176a;
            this.f207o.set(matrix);
            this.f207o.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 != 0.0f) {
                eVar.a(this.f205l);
                Path path = this.f205l;
                this.f206m.reset();
                if (eVar.a()) {
                    this.f206m.setFillType(eVar.f191n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f206m.addPath(path, this.f207o);
                    canvas.clipPath(this.f206m);
                    return;
                }
                b bVar = (b) eVar;
                if (!(bVar.f169f == 0.0f && bVar.f170g == 1.0f)) {
                    float f4 = (bVar.f169f + bVar.f171h) % 1.0f;
                    float f5 = (bVar.f170g + bVar.f171h) % 1.0f;
                    if (this.f208p == null) {
                        this.f208p = new PathMeasure();
                    }
                    this.f208p.setPath(this.f205l, false);
                    float length = this.f208p.getLength();
                    float f6 = f4 * length;
                    float f7 = f5 * length;
                    path.reset();
                    if (f6 > f7) {
                        this.f208p.getSegment(f6, length, path, true);
                        this.f208p.getSegment(0.0f, f7, path, true);
                    } else {
                        this.f208p.getSegment(f6, f7, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f206m.addPath(path, this.f207o);
                if (bVar.f166c.e()) {
                    l.b bVar2 = bVar.f166c;
                    if (this.f195b == null) {
                        Paint paint = new Paint(1);
                        this.f195b = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f195b;
                    if (bVar2.c()) {
                        Shader a3 = bVar2.a();
                        a3.setLocalMatrix(this.f207o);
                        paint2.setShader(a3);
                        paint2.setAlpha(Math.round(bVar.f168e * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar2.b(), bVar.f168e));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f206m.setFillType(bVar.f191n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f206m, paint2);
                }
                if (bVar.f164a.e()) {
                    l.b bVar3 = bVar.f164a;
                    if (this.f194a == null) {
                        Paint paint3 = new Paint(1);
                        this.f194a = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f194a;
                    if (bVar.f173j != null) {
                        paint4.setStrokeJoin(bVar.f173j);
                    }
                    if (bVar.f172i != null) {
                        paint4.setStrokeCap(bVar.f172i);
                    }
                    paint4.setStrokeMiter(bVar.f174k);
                    if (bVar3.c()) {
                        Shader a4 = bVar3.a();
                        a4.setLocalMatrix(this.f207o);
                        paint4.setShader(a4);
                        paint4.setAlpha(Math.round(bVar.f167d * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(i.a(bVar3.b(), bVar.f167d));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(bVar.f165b * min * a2);
                    canvas.drawPath(this.f206m, paint4);
                }
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.f176a.set(matrix);
            cVar.f176a.preConcat(cVar.f179d);
            canvas.save();
            for (int i4 = 0; i4 < cVar.f177b.size(); i4++) {
                d dVar = cVar.f177b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f176a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.f196c, f193n, canvas, i2, i3, colorFilter);
        }

        public boolean a() {
            if (this.f203j == null) {
                this.f203j = Boolean.valueOf(this.f196c.b());
            }
            return this.f203j.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f196c.a(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f201h;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f201h = i2;
        }
    }

    private static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f210a;

        /* renamed from: b  reason: collision with root package name */
        f f211b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f212c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f213d;

        /* renamed from: e  reason: collision with root package name */
        boolean f214e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f215f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f216g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f217h;

        /* renamed from: i  reason: collision with root package name */
        int f218i;

        /* renamed from: j  reason: collision with root package name */
        boolean f219j;

        /* renamed from: k  reason: collision with root package name */
        boolean f220k;

        /* renamed from: l  reason: collision with root package name */
        Paint f221l;

        public g() {
            this.f212c = null;
            this.f213d = i.f154a;
            this.f211b = new f();
        }

        public g(g gVar) {
            this.f212c = null;
            this.f213d = i.f154a;
            if (gVar != null) {
                this.f210a = gVar.f210a;
                this.f211b = new f(gVar.f211b);
                if (gVar.f211b.f195b != null) {
                    this.f211b.f195b = new Paint(gVar.f211b.f195b);
                }
                if (gVar.f211b.f194a != null) {
                    this.f211b.f194a = new Paint(gVar.f211b.f194a);
                }
                this.f212c = gVar.f212c;
                this.f213d = gVar.f213d;
                this.f214e = gVar.f214e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.f221l == null) {
                Paint paint = new Paint();
                this.f221l = paint;
                paint.setFilterBitmap(true);
            }
            this.f221l.setAlpha(this.f211b.getRootAlpha());
            this.f221l.setColorFilter(colorFilter);
            return this.f221l;
        }

        public void a(int i2, int i3) {
            this.f215f.eraseColor(0);
            this.f211b.a(new Canvas(this.f215f), i2, i3, (ColorFilter) null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f215f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.f211b.getRootAlpha() < 255;
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f211b.a(iArr);
            this.f220k |= a2;
            return a2;
        }

        public void b(int i2, int i3) {
            if (this.f215f == null || !c(i2, i3)) {
                this.f215f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f220k = true;
            }
        }

        public boolean b() {
            return !this.f220k && this.f216g == this.f212c && this.f217h == this.f213d && this.f219j == this.f214e && this.f218i == this.f211b.getRootAlpha();
        }

        public void c() {
            this.f216g = this.f212c;
            this.f217h = this.f213d;
            this.f218i = this.f211b.getRootAlpha();
            this.f219j = this.f214e;
            this.f220k = false;
        }

        public boolean c(int i2, int i3) {
            return i2 == this.f215f.getWidth() && i3 == this.f215f.getHeight();
        }

        public boolean d() {
            return this.f211b.a();
        }

        public int getChangingConfigurations() {
            return this.f210a;
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f222a;

        public h(Drawable.ConstantState constantState) {
            this.f222a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f222a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f222a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f153c = (VectorDrawable) this.f222a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f153c = (VectorDrawable) this.f222a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f153c = (VectorDrawable) this.f222a.newDrawable(resources, theme);
            return iVar;
        }
    }

    i() {
        this.f159g = true;
        this.f161i = new float[9];
        this.f162j = new Matrix();
        this.f163k = new Rect();
        this.f155b = new g();
    }

    i(g gVar) {
        this.f159g = true;
        this.f161i = new float[9];
        this.f162j = new Matrix();
        this.f163k = new Rect();
        this.f155b = gVar;
        this.f156d = a(this.f156d, gVar.f212c, gVar.f213d);
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ IOException | XmlPullParserException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ IOException | XmlPullParserException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static aj.i a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            aj.i r0 = new aj.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = l.f.a((android.content.res.Resources) r6, (int) r7, (android.content.res.Resources.Theme) r8)
            r0.f153c = r6
            aj.i$h r6 = new aj.i$h
            android.graphics.drawable.Drawable r7 = r0.f153c
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f160h = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            aj.i r6 = a(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            goto L_0x0048
        L_0x0047:
            r6 = move-exception
        L_0x0048:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: aj.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):aj.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        g gVar = this.f155b;
        f fVar = gVar.f211b;
        gVar.f213d = a(l.g.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a2 = l.g.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a2 != null) {
            gVar.f212c = a2;
        }
        gVar.f214e = l.g.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f214e);
        fVar.f199f = l.g.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f199f);
        fVar.f200g = l.g.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f200g);
        if (fVar.f199f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.f200g > 0.0f) {
            fVar.f197d = typedArray.getDimension(3, fVar.f197d);
            fVar.f198e = typedArray.getDimension(2, fVar.f198e);
            if (fVar.f197d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.f198e > 0.0f) {
                fVar.setAlpha(l.g.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.f202i = string;
                    fVar.f204k.put(string, fVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.i(this) == 1;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i2;
        int i3;
        g gVar = this.f155b;
        f fVar = gVar.f211b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f196c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if (GLImage.KEY_PATH.equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f177b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.f204k.put(bVar.getPathName(), bVar);
                    }
                    z2 = false;
                    i2 = gVar.f210a;
                    i3 = bVar.f192o;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f177b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.f204k.put(aVar.getPathName(), aVar);
                    }
                    i2 = gVar.f210a;
                    i3 = aVar.f192o;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f177b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.f204k.put(cVar2.getGroupName(), cVar2);
                    }
                    i2 = gVar.f210a;
                    i3 = cVar2.f180e;
                }
                gVar.f210a = i3 | i2;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f155b.f211b.f204k.get(str);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f159g = z2;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.f153c == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.d(this.f153c);
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
        copyBounds(this.f163k);
        if (this.f163k.width() > 0 && this.f163k.height() > 0) {
            ColorFilter colorFilter = this.f157e;
            if (colorFilter == null) {
                colorFilter = this.f156d;
            }
            canvas.getMatrix(this.f162j);
            this.f162j.getValues(this.f161i);
            float abs = Math.abs(this.f161i[0]);
            float abs2 = Math.abs(this.f161i[4]);
            float abs3 = Math.abs(this.f161i[1]);
            float abs4 = Math.abs(this.f161i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f163k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f163k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f163k.left, (float) this.f163k.top);
                if (a()) {
                    canvas.translate((float) this.f163k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f163k.offsetTo(0, 0);
                this.f155b.b(min, min2);
                if (!this.f159g) {
                    this.f155b.a(min, min2);
                } else if (!this.f155b.b()) {
                    this.f155b.a(min, min2);
                    this.f155b.c();
                }
                this.f155b.a(canvas, colorFilter, this.f163k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.c(this.f153c) : this.f155b.f211b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return this.f153c != null ? this.f153c.getChangingConfigurations() : super.getChangingConfigurations() | this.f155b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.e(this.f153c) : this.f157e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f153c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f153c.getConstantState());
        }
        this.f155b.f210a = getChangingConfigurations();
        return this.f155b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f153c != null ? this.f153c.getIntrinsicHeight() : (int) this.f155b.f211b.f198e;
    }

    public int getIntrinsicWidth() {
        return this.f153c != null ? this.f153c.getIntrinsicWidth() : (int) this.f155b.f211b.f197d;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        if (this.f153c != null) {
            return this.f153c.getOpacity();
        }
        return -3;
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
        if (this.f153c != null) {
            this.f153c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f155b;
        gVar.f211b = new f();
        TypedArray a2 = l.g.a(resources, theme, attributeSet, a.f124a);
        a(a2, xmlPullParser, theme);
        a2.recycle();
        gVar.f210a = getChangingConfigurations();
        gVar.f220k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.f156d = a(this.f156d, gVar.f212c, gVar.f213d);
    }

    public void invalidateSelf() {
        if (this.f153c != null) {
            this.f153c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.f153c != null ? androidx.core.graphics.drawable.a.b(this.f153c) : this.f155b.f214e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = r1.f155b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f153c
            if (r0 == 0) goto L_0x000b
            android.graphics.drawable.Drawable r0 = r1.f153c
            boolean r0 = r0.isStateful()
            return r0
        L_0x000b:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x002e
            aj.i$g r0 = r1.f155b
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x002e
            aj.i$g r0 = r1.f155b
            android.content.res.ColorStateList r0 = r0.f212c
            if (r0 == 0) goto L_0x002c
            aj.i$g r0 = r1.f155b
            android.content.res.ColorStateList r0 = r0.f212c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aj.i.isStateful():boolean");
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f153c != null) {
            this.f153c.mutate();
            return this;
        }
        if (!this.f158f && super.mutate() == this) {
            this.f155b = new g(this.f155b);
            this.f158f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f153c != null) {
            this.f153c.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f153c != null) {
            return this.f153c.setState(iArr);
        }
        boolean z2 = false;
        g gVar = this.f155b;
        if (!(gVar.f212c == null || gVar.f213d == null)) {
            this.f156d = a(this.f156d, gVar.f212c, gVar.f213d);
            invalidateSelf();
            z2 = true;
        }
        if (!gVar.d() || !gVar.a(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        if (this.f153c != null) {
            this.f153c.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.f153c != null) {
            this.f153c.setAlpha(i2);
        } else if (this.f155b.f211b.getRootAlpha() != i2) {
            this.f155b.f211b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z2) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, z2);
        } else {
            this.f155b.f214e = z2;
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
            return;
        }
        this.f157e = colorFilter;
        invalidateSelf();
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
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, colorStateList);
            return;
        }
        g gVar = this.f155b;
        if (gVar.f212c != colorStateList) {
            gVar.f212c = colorStateList;
            this.f156d = a(this.f156d, colorStateList, gVar.f213d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f153c != null) {
            androidx.core.graphics.drawable.a.a(this.f153c, mode);
            return;
        }
        g gVar = this.f155b;
        if (gVar.f213d != mode) {
            gVar.f213d = mode;
            this.f156d = a(this.f156d, gVar.f212c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return this.f153c != null ? this.f153c.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f153c != null) {
            this.f153c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
