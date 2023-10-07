package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import t.ac;

public class Slide extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeInterpolator f4699a = new DecelerateInterpolator();

    /* renamed from: i  reason: collision with root package name */
    private static final TimeInterpolator f4700i = new AccelerateInterpolator();

    /* renamed from: l  reason: collision with root package name */
    private static final a f4701l = new b() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private static final a f4702m = new b() {
        public float a(ViewGroup viewGroup, View view) {
            boolean z2 = true;
            if (ac.i(viewGroup) != 1) {
                z2 = false;
            }
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return z2 ? translationX + width : translationX - width;
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private static final a f4703n = new c() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private static final a f4704o = new b() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private static final a f4705p = new b() {
        public float a(ViewGroup viewGroup, View view) {
            boolean z2 = true;
            if (ac.i(viewGroup) != 1) {
                z2 = false;
            }
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return z2 ? translationX - width : translationX + width;
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private static final a f4706q = new c() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private a f4707j = f4706q;

    /* renamed from: k  reason: collision with root package name */
    private int f4708k = 80;

    private interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class b implements a {
        private b() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class c implements a {
        private c() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        a(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4869h);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        a(a2);
    }

    private void d(y yVar) {
        int[] iArr = new int[2];
        yVar.f4887b.getLocationOnScreen(iArr);
        yVar.f4886a.put("android:slide:screenPosition", iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) yVar2.f4886a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return aa.a(view, yVar2, iArr[0], iArr[1], this.f4707j.a(viewGroup, view), this.f4707j.b(viewGroup, view), translationX, translationY, f4699a, this);
    }

    public void a(int i2) {
        a aVar;
        if (i2 == 3) {
            aVar = f4701l;
        } else if (i2 == 5) {
            aVar = f4704o;
        } else if (i2 == 48) {
            aVar = f4703n;
        } else if (i2 == 80) {
            aVar = f4706q;
        } else if (i2 == 8388611) {
            aVar = f4702m;
        } else if (i2 == 8388613) {
            aVar = f4705p;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f4707j = aVar;
        this.f4708k = i2;
        s sVar = new s();
        sVar.a(i2);
        a((w) sVar);
    }

    public void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar == null) {
            return null;
        }
        int[] iArr = (int[]) yVar.f4886a.get("android:slide:screenPosition");
        return aa.a(view, yVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f4707j.a(viewGroup, view), this.f4707j.b(viewGroup, view), f4700i, this);
    }

    public void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }
}
