package ll;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class b extends a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f30930a;

    /* renamed from: b  reason: collision with root package name */
    protected LayoutInflater f30931b;

    /* renamed from: c  reason: collision with root package name */
    protected int f30932c;

    /* renamed from: d  reason: collision with root package name */
    protected int f30933d;

    /* renamed from: e  reason: collision with root package name */
    protected int f30934e;

    /* renamed from: f  reason: collision with root package name */
    private Typeface f30935f;

    /* renamed from: g  reason: collision with root package name */
    private int f30936g;

    /* renamed from: h  reason: collision with root package name */
    private int f30937h;

    protected b(Context context, int i2) {
        this(context, i2, 0);
    }

    protected b(Context context, int i2, int i3) {
        this.f30936g = -15724528;
        this.f30937h = 24;
        this.f30930a = context;
        this.f30932c = i2;
        this.f30933d = i3;
        this.f30931b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private View a(int i2, ViewGroup viewGroup) {
        if (i2 == -1) {
            return new TextView(this.f30930a);
        }
        if (i2 != 0) {
            return this.f30931b.inflate(i2, viewGroup, false);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        if ((r2 instanceof android.widget.TextView) != false) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.widget.TextView a(android.view.View r2, int r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x000b
            boolean r0 = r2 instanceof android.widget.TextView     // Catch:{ ClassCastException -> 0x0009 }
            if (r0 == 0) goto L_0x000b
        L_0x0006:
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ ClassCastException -> 0x0009 }
            goto L_0x0022
        L_0x0009:
            r2 = move-exception
            goto L_0x0012
        L_0x000b:
            if (r3 == 0) goto L_0x0021
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ ClassCastException -> 0x0009 }
            goto L_0x0006
        L_0x0012:
            java.lang.String r3 = "AbstractWheelAdapter"
            java.lang.String r0 = "You must supply a resource ID for a TextView"
            android.util.Log.e(r3, r0)
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "AbstractWheelAdapter requires the resource ID to be a TextView"
            r3.<init>(r0, r2)
            throw r3
        L_0x0021:
            r2 = 0
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ll.b.a(android.view.View, int):android.widget.TextView");
    }

    public View a(int i2, View view, ViewGroup viewGroup) {
        if (i2 < 0 || i2 >= a()) {
            return null;
        }
        if (view == null) {
            view = a(this.f30932c, viewGroup);
        }
        TextView a2 = a(view, this.f30933d);
        if (a2 != null) {
            CharSequence b2 = b(i2);
            if (b2 == null) {
                b2 = "";
            }
            a2.setText(b2);
            a(a2);
        }
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a(this.f30934e, viewGroup);
        }
        if (view instanceof TextView) {
            a((TextView) view);
        }
        return view;
    }

    public void a(int i2) {
        this.f30932c = i2;
    }

    /* access modifiers changed from: protected */
    public void a(TextView textView) {
        if (this.f30932c == -1) {
            textView.setTextColor(this.f30936g);
            textView.setGravity(17);
            textView.setTextSize((float) this.f30937h);
            textView.setLines(1);
        }
        Typeface typeface = this.f30935f;
        if (typeface != null) {
            textView.setTypeface(typeface);
        } else {
            textView.setTypeface(Typeface.SANS_SERIF, 1);
        }
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence b(int i2);
}
