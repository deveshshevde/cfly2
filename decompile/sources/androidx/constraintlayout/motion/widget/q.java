package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.d;
import fg.i;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k.c;
import org.xmlpull.v1.XmlPullParser;

public class q {

    /* renamed from: a  reason: collision with root package name */
    d f1996a = null;

    /* renamed from: b  reason: collision with root package name */
    a f1997b = null;

    /* renamed from: c  reason: collision with root package name */
    float f1998c;

    /* renamed from: d  reason: collision with root package name */
    float f1999d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final MotionLayout f2000e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2001f = false;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<a> f2002g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private a f2003h = null;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<a> f2004i = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public SparseArray<b> f2005j = new SparseArray<>();

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, Integer> f2006k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private SparseIntArray f2007l = new SparseIntArray();

    /* renamed from: m  reason: collision with root package name */
    private boolean f2008m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f2009n = 400;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f2010o = 0;

    /* renamed from: p  reason: collision with root package name */
    private MotionEvent f2011p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2012q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2013r = false;

    /* renamed from: s  reason: collision with root package name */
    private MotionLayout.d f2014s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2015t;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f2018a = -1;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f2019b = false;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f2020c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f2021d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f2022e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f2023f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f2024g = -1;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f2025h = 400;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public float f2026i = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final q f2027j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public ArrayList<h> f2028k = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public t f2029l = null;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public ArrayList<C0021a> f2030m = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f2031n = 0;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public boolean f2032o = false;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f2033p = -1;

        /* renamed from: q  reason: collision with root package name */
        private int f2034q = 0;

        /* renamed from: r  reason: collision with root package name */
        private int f2035r = 0;

        /* renamed from: androidx.constraintlayout.motion.widget.q$a$a  reason: collision with other inner class name */
        static class C0021a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            int f2036a = -1;

            /* renamed from: b  reason: collision with root package name */
            int f2037b = 17;

            /* renamed from: c  reason: collision with root package name */
            private final a f2038c;

            public C0021a(Context context, a aVar, XmlPullParser xmlPullParser) {
                this.f2038c = aVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f2036a = obtainStyledAttributes.getResourceId(index, this.f2036a);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f2037b = obtainStyledAttributes.getInt(index, this.f2037b);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout) {
                int i2 = this.f2036a;
                if (i2 != -1) {
                    View findViewById = motionLayout.findViewById(i2);
                    if (findViewById == null) {
                        Log.e("MotionScene", " (*)  could not find id " + this.f2036a);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public void a(MotionLayout motionLayout, int i2, a aVar) {
                int i3 = this.f2036a;
                View view = motionLayout;
                if (i3 != -1) {
                    view = motionLayout.findViewById(i3);
                }
                if (view == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f2036a);
                    return;
                }
                int b2 = aVar.f2021d;
                int a2 = aVar.f2020c;
                if (b2 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i4 = this.f2037b;
                boolean z2 = false;
                boolean z3 = ((i4 & 1) != 0 && i2 == b2) | ((i4 & 1) != 0 && i2 == b2) | ((i4 & 256) != 0 && i2 == b2) | ((i4 & 16) != 0 && i2 == a2);
                if ((i4 & 4096) != 0 && i2 == a2) {
                    z2 = true;
                }
                if (z3 || z2) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a(a aVar, MotionLayout motionLayout) {
                a aVar2 = this.f2038c;
                if (aVar2 == aVar) {
                    return true;
                }
                int a2 = aVar2.f2020c;
                int b2 = this.f2038c.f2021d;
                return b2 == -1 ? motionLayout.f1722e != a2 : motionLayout.f1722e == b2 || motionLayout.f1722e == a2;
            }

            public void onClick(View view) {
                float f2;
                MotionLayout a2 = this.f2038c.f2027j.f2000e;
                if (a2.g()) {
                    if (this.f2038c.f2021d == -1) {
                        int currentState = a2.getCurrentState();
                        if (currentState == -1) {
                            a2.a(this.f2038c.f2020c);
                            return;
                        }
                        a aVar = new a(this.f2038c.f2027j, this.f2038c);
                        int unused = aVar.f2021d = currentState;
                        int unused2 = aVar.f2020c = this.f2038c.f2020c;
                        a2.setTransition(aVar);
                        a2.c();
                        return;
                    }
                    a aVar2 = this.f2038c.f2027j.f1997b;
                    int i2 = this.f2037b;
                    boolean z2 = false;
                    boolean z3 = ((i2 & 1) == 0 && (i2 & 256) == 0) ? false : true;
                    boolean z4 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                    if (z3 && z4) {
                        a aVar3 = this.f2038c.f2027j.f1997b;
                        a aVar4 = this.f2038c;
                        if (aVar3 != aVar4) {
                            a2.setTransition(aVar4);
                        }
                        if (a2.getCurrentState() != a2.getEndState() && a2.getProgress() <= 0.5f) {
                            z2 = z3;
                            z4 = false;
                        }
                    } else {
                        z2 = z3;
                    }
                    if (!a(aVar2, a2)) {
                        return;
                    }
                    if (z2 && (this.f2037b & 1) != 0) {
                        a2.setTransition(this.f2038c);
                        a2.c();
                    } else if (!z4 || (this.f2037b & 16) == 0) {
                        if (z2 && (this.f2037b & 256) != 0) {
                            a2.setTransition(this.f2038c);
                            f2 = 1.0f;
                        } else if (z4 && (this.f2037b & 4096) != 0) {
                            a2.setTransition(this.f2038c);
                            f2 = 0.0f;
                        } else {
                            return;
                        }
                        a2.setProgress(f2);
                    } else {
                        a2.setTransition(this.f2038c);
                        a2.b();
                    }
                }
            }
        }

        a(q qVar, Context context, XmlPullParser xmlPullParser) {
            this.f2025h = qVar.f2009n;
            this.f2034q = qVar.f2010o;
            this.f2027j = qVar;
            a(qVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        a(q qVar, a aVar) {
            this.f2027j = qVar;
            if (aVar != null) {
                this.f2033p = aVar.f2033p;
                this.f2022e = aVar.f2022e;
                this.f2023f = aVar.f2023f;
                this.f2024g = aVar.f2024g;
                this.f2025h = aVar.f2025h;
                this.f2028k = aVar.f2028k;
                this.f2026i = aVar.f2026i;
                this.f2034q = aVar.f2034q;
            }
        }

        private void a(q qVar, Context context, TypedArray typedArray) {
            b bVar;
            SparseArray d2;
            int i2;
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f2020c = typedArray.getResourceId(index, this.f2020c);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f2020c))) {
                        bVar = new b();
                        bVar.b(context, this.f2020c);
                        d2 = qVar.f2005j;
                        i2 = this.f2020c;
                    }
                } else {
                    if (index == R.styleable.Transition_constraintSetStart) {
                        this.f2021d = typedArray.getResourceId(index, this.f2021d);
                        if ("layout".equals(context.getResources().getResourceTypeName(this.f2021d))) {
                            bVar = new b();
                            bVar.b(context, this.f2021d);
                            d2 = qVar.f2005j;
                            i2 = this.f2021d;
                        }
                    } else if (index == R.styleable.Transition_motionInterpolator) {
                        TypedValue peekValue = typedArray.peekValue(index);
                        if (peekValue.type == 1) {
                            int resourceId = typedArray.getResourceId(index, -1);
                            this.f2024g = resourceId;
                            if (resourceId == -1) {
                            }
                        } else if (peekValue.type == 3) {
                            String string = typedArray.getString(index);
                            this.f2023f = string;
                            if (string.indexOf("/") > 0) {
                                this.f2024g = typedArray.getResourceId(index, -1);
                            } else {
                                this.f2022e = -1;
                            }
                        } else {
                            this.f2022e = typedArray.getInteger(index, this.f2022e);
                        }
                        this.f2022e = -2;
                    } else if (index == R.styleable.Transition_duration) {
                        this.f2025h = typedArray.getInt(index, this.f2025h);
                    } else if (index == R.styleable.Transition_staggered) {
                        this.f2026i = typedArray.getFloat(index, this.f2026i);
                    } else if (index == R.styleable.Transition_autoTransition) {
                        this.f2031n = typedArray.getInteger(index, this.f2031n);
                    } else if (index == R.styleable.Transition_android_id) {
                        this.f2018a = typedArray.getResourceId(index, this.f2018a);
                    } else if (index == R.styleable.Transition_transitionDisable) {
                        this.f2032o = typedArray.getBoolean(index, this.f2032o);
                    } else if (index == R.styleable.Transition_pathMotionArc) {
                        this.f2033p = typedArray.getInteger(index, -1);
                    } else if (index == R.styleable.Transition_layoutDuringTransition) {
                        this.f2034q = typedArray.getInteger(index, 0);
                    } else if (index == R.styleable.Transition_transitionFlags) {
                        this.f2035r = typedArray.getInteger(index, 0);
                    }
                }
                d2.append(i2, bVar);
            }
            if (this.f2021d == -1) {
                this.f2019b = true;
            }
        }

        private void a(q qVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            a(qVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f2034q;
        }

        public String a(Context context) {
            String resourceEntryName = this.f2021d == -1 ? "null" : context.getResources().getResourceEntryName(this.f2021d);
            if (this.f2020c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f2020c);
        }

        public void a(int i2) {
            this.f2025h = i2;
        }

        public void a(Context context, XmlPullParser xmlPullParser) {
            this.f2030m.add(new C0021a(context, this, xmlPullParser));
        }

        public int b() {
            return this.f2031n;
        }

        public boolean b(int i2) {
            return (i2 & this.f2035r) != 0;
        }

        public int c() {
            return this.f2020c;
        }

        public int d() {
            return this.f2021d;
        }

        public int e() {
            return this.f2025h;
        }

        public t f() {
            return this.f2029l;
        }

        public boolean g() {
            return !this.f2032o;
        }
    }

    q(Context context, MotionLayout motionLayout, int i2) {
        this.f2000e = motionLayout;
        a(context, i2);
        this.f2005j.put(R.id.motion_base, new b());
        this.f2006k.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    private int a(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f2008m) {
                PrintStream printStream = System.out;
                printStream.println("id getMap res = " + i2);
            }
        } else {
            i2 = -1;
        }
        if (i2 != -1) {
            return i2;
        }
        if (str != null && str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i2;
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            r1 = 0
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x000d:
            r3 = 1
            if (r2 == r3) goto L_0x0151
            if (r2 == 0) goto L_0x013f
            r4 = 2
            if (r2 == r4) goto L_0x0017
            goto L_0x0142
        L_0x0017:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            boolean r5 = r8.f2008m     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r5 == 0) goto L_0x0035
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r6.append(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x0035:
            int r5 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r6 = -1
            java.lang.String r7 = "MotionScene"
            switch(r5) {
                case -1349929691: goto L_0x0079;
                case -1239391468: goto L_0x006f;
                case 269306229: goto L_0x0066;
                case 312750793: goto L_0x005c;
                case 327855227: goto L_0x0052;
                case 793277014: goto L_0x004a;
                case 1382829617: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0083
        L_0x0040:
            java.lang.String r3 = "StateSet"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 4
            goto L_0x0084
        L_0x004a:
            boolean r3 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 0
            goto L_0x0084
        L_0x0052:
            java.lang.String r3 = "OnSwipe"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 2
            goto L_0x0084
        L_0x005c:
            java.lang.String r3 = "OnClick"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 3
            goto L_0x0084
        L_0x0066:
            java.lang.String r4 = "Transition"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r4 == 0) goto L_0x0083
            goto L_0x0084
        L_0x006f:
            java.lang.String r3 = "KeyFrameSet"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 6
            goto L_0x0084
        L_0x0079:
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r3 == 0) goto L_0x0083
            r3 = 5
            goto L_0x0084
        L_0x0083:
            r3 = -1
        L_0x0084:
            switch(r3) {
                case 0: goto L_0x0126;
                case 1: goto L_0x00e4;
                case 2: goto L_0x00aa;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009c;
                case 5: goto L_0x0097;
                case 6: goto L_0x0089;
                default: goto L_0x0087;
            }     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x0087:
            goto L_0x012a
        L_0x0089:
            androidx.constraintlayout.motion.widget.h r2 = new androidx.constraintlayout.motion.widget.h     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.util.ArrayList r3 = r1.f2028k     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x0097:
            r8.b((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x009c:
            androidx.constraintlayout.widget.d r2 = new androidx.constraintlayout.widget.d     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r8.f1996a = r2     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x00a5:
            r1.a((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x00aa:
            if (r1 != 0) goto L_0x00d9
            android.content.res.Resources r2 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r2 = r2.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r2 = ".xml:"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r2 = ")"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            android.util.Log.v(r7, r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x00d9:
            androidx.constraintlayout.motion.widget.t r2 = new androidx.constraintlayout.motion.widget.t     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f2000e     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r2.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.t unused = r1.f2029l = r2     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x00e4:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.f2002g     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.q$a r2 = new androidx.constraintlayout.motion.widget.q$a     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f1997b     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r1 != 0) goto L_0x010b
            boolean r1 = r2.f2019b     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r1 != 0) goto L_0x010b
            r8.f1997b = r2     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.t r1 = r2.f2029l     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r1 == 0) goto L_0x010b
            androidx.constraintlayout.motion.widget.q$a r1 = r8.f1997b     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            androidx.constraintlayout.motion.widget.t r1 = r1.f2029l     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            boolean r3 = r8.f2015t     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r1.a((boolean) r3)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x010b:
            boolean r1 = r2.f2019b     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r1 == 0) goto L_0x0124
            int r1 = r2.f2020c     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            if (r1 != r6) goto L_0x011a
            r8.f2003h = r2     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x011f
        L_0x011a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.f2004i     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x011f:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r1 = r8.f2002g     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x0124:
            r1 = r2
            goto L_0x0142
        L_0x0126:
            r8.a((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x012a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r4 = "WARNING UNKNOWN ATTRIBUTE "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            java.lang.String r2 = r3.toString()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            android.util.Log.v(r7, r2)     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x0142
        L_0x013f:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
        L_0x0142:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x014d, IOException -> 0x0148 }
            goto L_0x000d
        L_0x0148:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0151
        L_0x014d:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.a(android.content.Context, int):void");
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.f2009n = obtainStyledAttributes.getInt(index, this.f2009n);
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f2010o = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        b bVar = new b();
        bVar.a(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser.getAttributeName(i4);
            String attributeValue = xmlPullParser.getAttributeValue(i4);
            if (this.f2008m) {
                PrintStream printStream = System.out;
                printStream.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i3 = a(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i2 = a(context, attributeValue);
                this.f2006k.put(a(attributeValue), Integer.valueOf(i2));
            }
        }
        if (i2 != -1) {
            if (this.f2000e.f1729l != 0) {
                bVar.b(true);
            }
            bVar.a(context, xmlPullParser);
            if (i3 != -1) {
                this.f2007l.put(i2, i3);
            }
            this.f2005j.put(i2, bVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.a(r3, -1, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int e(int r3) {
        /*
            r2 = this;
            androidx.constraintlayout.widget.d r0 = r2.f1996a
            if (r0 == 0) goto L_0x000c
            r1 = -1
            int r0 = r0.a(r3, r1, r1)
            if (r0 == r1) goto L_0x000c
            return r0
        L_0x000c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.e(int):int");
    }

    private boolean f(int i2) {
        int i3 = this.f2007l.get(i2);
        int size = this.f2007l.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.f2007l.get(i3);
            size = i4;
        }
        return false;
    }

    private void g(int i2) {
        int i3 = this.f2007l.get(i2);
        if (i3 > 0) {
            g(this.f2007l.get(i2));
            b bVar = this.f2005j.get(i2);
            b bVar2 = this.f2005j.get(i3);
            if (bVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + a.a(this.f2000e.getContext(), i3));
                return;
            }
            bVar.a(bVar2);
            this.f2007l.put(i2, -1);
        }
    }

    private boolean n() {
        return this.f2014s != null;
    }

    public a a(int i2, float f2, float f3, MotionEvent motionEvent) {
        RectF a2;
        if (i2 == -1) {
            return this.f1997b;
        }
        List<a> a3 = a(i2);
        float f4 = 0.0f;
        a aVar = null;
        RectF rectF = new RectF();
        for (a next : a3) {
            if (!next.f2032o && next.f2029l != null) {
                next.f2029l.a(this.f2015t);
                RectF a4 = next.f2029l.a((ViewGroup) this.f2000e, rectF);
                if ((a4 == null || motionEvent == null || a4.contains(motionEvent.getX(), motionEvent.getY())) && ((a2 = next.f2029l.a((ViewGroup) this.f2000e, rectF)) == null || motionEvent == null || a2.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float f5 = next.f2029l.f(f2, f3) * (next.f2020c == i2 ? -1.0f : 1.1f);
                    if (f5 > f4) {
                        aVar = next;
                        f4 = f5;
                    }
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3, int i4) {
        Object obj;
        int a2;
        if (this.f2008m) {
            PrintStream printStream = System.out;
            printStream.println("id " + i2);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.f2005j.size());
        }
        d dVar = this.f1996a;
        if (!(dVar == null || (a2 = dVar.a(i2, i3, i4)) == -1)) {
            i2 = a2;
        }
        if (this.f2005j.get(i2) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + a.a(this.f2000e.getContext(), i2) + " In MotionScene");
            SparseArray sparseArray = this.f2005j;
            obj = sparseArray.get(sparseArray.keyAt(0));
        } else {
            obj = this.f2005j.get(i2);
        }
        return (b) obj;
    }

    public ArrayList<a> a() {
        return this.f2002g;
    }

    public List<a> a(int i2) {
        int e2 = e(i2);
        ArrayList arrayList = new ArrayList();
        Iterator<a> it2 = this.f2002g.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.f2021d == e2 || next.f2020c == e2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3) {
        a aVar = this.f1997b;
        if (aVar != null && aVar.f2029l != null) {
            this.f1997b.f2029l.e(f2, f3);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.d r0 = r6.f1996a
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.a(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.d r2 = r6.f1996a
            int r2 = r2.a(r8, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r3 = r6.f2002g
            java.util.Iterator r3 = r3.iterator()
        L_0x001e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$a r4 = (androidx.constraintlayout.motion.widget.q.a) r4
            int r5 = r4.f2020c
            if (r5 != r2) goto L_0x0036
            int r5 = r4.f2021d
            if (r5 == r0) goto L_0x0042
        L_0x0036:
            int r5 = r4.f2020c
            if (r5 != r8) goto L_0x001e
            int r5 = r4.f2021d
            if (r5 != r7) goto L_0x001e
        L_0x0042:
            r6.f1997b = r4
            if (r4 == 0) goto L_0x0057
            androidx.constraintlayout.motion.widget.t r7 = r4.f2029l
            if (r7 == 0) goto L_0x0057
            androidx.constraintlayout.motion.widget.q$a r7 = r6.f1997b
            androidx.constraintlayout.motion.widget.t r7 = r7.f2029l
            boolean r8 = r6.f2015t
            r7.a((boolean) r8)
        L_0x0057:
            return
        L_0x0058:
            androidx.constraintlayout.motion.widget.q$a r7 = r6.f2003h
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r3 = r6.f2004i
            java.util.Iterator r3 = r3.iterator()
        L_0x0060:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0074
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$a r4 = (androidx.constraintlayout.motion.widget.q.a) r4
            int r5 = r4.f2020c
            if (r5 != r8) goto L_0x0060
            r7 = r4
            goto L_0x0060
        L_0x0074:
            androidx.constraintlayout.motion.widget.q$a r8 = new androidx.constraintlayout.motion.widget.q$a
            r8.<init>(r6, r7)
            int unused = r8.f2021d = r0
            int unused = r8.f2020c = r2
            if (r0 == r1) goto L_0x0086
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$a> r7 = r6.f2002g
            r7.add(r8)
        L_0x0086:
            r6.f1997b = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.a(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.d dVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f2014s == null) {
            this.f2014s = this.f2000e.a();
        }
        this.f2014s.a(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.f1998c = motionEvent.getRawX();
                this.f1999d = motionEvent.getRawY();
                this.f2011p = motionEvent;
                this.f2012q = false;
                if (this.f1997b.f2029l != null) {
                    RectF b2 = this.f1997b.f2029l.b((ViewGroup) this.f2000e, rectF);
                    if (b2 == null || b2.contains(this.f2011p.getX(), this.f2011p.getY())) {
                        RectF a2 = this.f1997b.f2029l.a((ViewGroup) this.f2000e, rectF);
                        if (a2 == null || a2.contains(this.f2011p.getX(), this.f2011p.getY())) {
                            this.f2013r = false;
                        } else {
                            this.f2013r = true;
                        }
                        this.f1997b.f2029l.b(this.f1998c, this.f1999d);
                        return;
                    }
                    this.f2011p = null;
                    this.f2012q = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.f2012q) {
                float rawY = motionEvent.getRawY() - this.f1999d;
                float rawX = motionEvent.getRawX() - this.f1998c;
                if ((((double) rawX) != i.f27244a || ((double) rawY) != i.f27244a) && (motionEvent2 = this.f2011p) != null) {
                    a a3 = a(i2, rawX, rawY, motionEvent2);
                    if (a3 != null) {
                        motionLayout.setTransition(a3);
                        RectF a4 = this.f1997b.f2029l.a((ViewGroup) this.f2000e, rectF);
                        if (a4 != null && !a4.contains(this.f2011p.getX(), this.f2011p.getY())) {
                            z2 = true;
                        }
                        this.f2013r = z2;
                        this.f1997b.f2029l.a(this.f1998c, this.f1999d);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.f2012q) {
            a aVar = this.f1997b;
            if (!(aVar == null || aVar.f2029l == null || this.f2013r)) {
                this.f1997b.f2029l.a(motionEvent, this.f2014s, i2, this);
            }
            this.f1998c = motionEvent.getRawX();
            this.f1999d = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (dVar = this.f2014s) != null) {
                dVar.a();
                this.f2014s = null;
                if (motionLayout.f1722e != -1) {
                    b(motionLayout, motionLayout.f1722e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MotionLayout motionLayout) {
        int i2 = 0;
        while (i2 < this.f2005j.size()) {
            int keyAt = this.f2005j.keyAt(i2);
            if (f(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            } else {
                g(keyAt);
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f2005j.size(); i3++) {
            this.f2005j.valueAt(i3).a((ConstraintLayout) motionLayout);
        }
    }

    public void a(MotionLayout motionLayout, int i2) {
        Iterator<a> it2 = this.f2002g.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.f2030m.size() > 0) {
                Iterator it3 = next.f2030m.iterator();
                while (it3.hasNext()) {
                    ((a.C0021a) it3.next()).a(motionLayout);
                }
            }
        }
        Iterator<a> it4 = this.f2004i.iterator();
        while (it4.hasNext()) {
            a next2 = it4.next();
            if (next2.f2030m.size() > 0) {
                Iterator it5 = next2.f2030m.iterator();
                while (it5.hasNext()) {
                    ((a.C0021a) it5.next()).a(motionLayout);
                }
            }
        }
        Iterator<a> it6 = this.f2002g.iterator();
        while (it6.hasNext()) {
            a next3 = it6.next();
            if (next3.f2030m.size() > 0) {
                Iterator it7 = next3.f2030m.iterator();
                while (it7.hasNext()) {
                    ((a.C0021a) it7.next()).a(motionLayout, i2, next3);
                }
            }
        }
        Iterator<a> it8 = this.f2004i.iterator();
        while (it8.hasNext()) {
            a next4 = it8.next();
            if (next4.f2030m.size() > 0) {
                Iterator it9 = next4.f2030m.iterator();
                while (it9.hasNext()) {
                    ((a.C0021a) it9.next()).a(motionLayout, i2, next4);
                }
            }
        }
    }

    public void a(n nVar) {
        a aVar = this.f1997b;
        if (aVar == null) {
            a aVar2 = this.f2003h;
            if (aVar2 != null) {
                Iterator it2 = aVar2.f2028k.iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).a(nVar);
                }
                return;
            }
            return;
        }
        Iterator it3 = aVar.f2028k.iterator();
        while (it3.hasNext()) {
            ((h) it3.next()).a(nVar);
        }
    }

    public void a(a aVar) {
        this.f1997b = aVar;
        if (aVar != null && aVar.f2029l != null) {
            this.f1997b.f2029l.a(this.f2015t);
        }
    }

    public void a(boolean z2) {
        this.f2015t = z2;
        a aVar = this.f1997b;
        if (aVar != null && aVar.f2029l != null) {
            this.f1997b.f2029l.a(this.f2015t);
        }
    }

    public a b(int i2) {
        Iterator<a> it2 = this.f2002g.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.f2018a == i2) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, float f3) {
        a aVar = this.f1997b;
        if (aVar != null && aVar.f2029l != null) {
            this.f1997b.f2029l.d(f2, f3);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(MotionLayout motionLayout, int i2) {
        if (n() || this.f2001f) {
            return false;
        }
        Iterator<a> it2 = this.f2002g.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!(next.f2031n == 0 || this.f1997b == next)) {
                if (i2 == next.f2021d && (next.f2031n == 4 || next.f2031n == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.f2031n == 4) {
                        motionLayout.c();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.a(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.d();
                    }
                    return true;
                } else if (i2 == next.f2020c && (next.f2031n == 3 || next.f2031n == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.f2031n == 3) {
                        motionLayout.b();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.a(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.d();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int[] b() {
        int size = this.f2005j.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.f2005j.keyAt(i2);
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public float c(float f2, float f3) {
        a aVar = this.f1997b;
        if (aVar == null || aVar.f2029l == null) {
            return 0.0f;
        }
        return this.f1997b.f2029l.c(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public b c(int i2) {
        return a(i2, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        Iterator<a> it2 = this.f2002g.iterator();
        while (it2.hasNext()) {
            if (it2.next().f2029l != null) {
                return true;
            }
        }
        a aVar = this.f1997b;
        return (aVar == null || aVar.f2029l == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f1997b;
        if (aVar == null) {
            return -1;
        }
        return aVar.f2021d;
    }

    public void d(int i2) {
        a aVar = this.f1997b;
        if (aVar != null) {
            aVar.a(i2);
        } else {
            this.f2009n = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int e() {
        a aVar = this.f1997b;
        if (aVar == null) {
            return -1;
        }
        return aVar.f2020c;
    }

    public Interpolator f() {
        int k2 = this.f1997b.f2022e;
        if (k2 == -2) {
            return AnimationUtils.loadInterpolator(this.f2000e.getContext(), this.f1997b.f2024g);
        }
        if (k2 == -1) {
            final c a2 = c.a(this.f1997b.f2023f);
            return new Interpolator() {
                public float getInterpolation(float f2) {
                    return (float) a2.a((double) f2);
                }
            };
        } else if (k2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (k2 == 1) {
                return new AccelerateInterpolator();
            }
            if (k2 == 2) {
                return new DecelerateInterpolator();
            }
            if (k2 == 4) {
                return new AnticipateInterpolator();
            }
            if (k2 != 5) {
                return null;
            }
            return new BounceInterpolator();
        }
    }

    public int g() {
        a aVar = this.f1997b;
        return aVar != null ? aVar.f2025h : this.f2009n;
    }

    public int h() {
        a aVar = this.f1997b;
        if (aVar != null) {
            return aVar.f2033p;
        }
        return -1;
    }

    public float i() {
        a aVar = this.f1997b;
        if (aVar != null) {
            return aVar.f2026i;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        a aVar = this.f1997b;
        if (aVar == null || aVar.f2029l == null) {
            return 0.0f;
        }
        return this.f1997b.f2029l.b();
    }

    /* access modifiers changed from: package-private */
    public float k() {
        a aVar = this.f1997b;
        if (aVar == null || aVar.f2029l == null) {
            return 0.0f;
        }
        return this.f1997b.f2029l.c();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        a aVar = this.f1997b;
        if (aVar != null && aVar.f2029l != null) {
            this.f1997b.f2029l.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        a aVar = this.f1997b;
        if (aVar == null || aVar.f2029l == null) {
            return false;
        }
        return this.f1997b.f2029l.d();
    }
}
