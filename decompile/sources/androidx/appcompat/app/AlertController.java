package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import t.ac;

class AlertController {
    private int A;
    private boolean B = false;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I = 0;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f493c
                if (r3 != r0) goto L_0x0015
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.os.Message r0 = r0.f494d
                if (r0 == 0) goto L_0x0015
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f494d
            L_0x0010:
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x0038
            L_0x0015:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f495e
                if (r3 != r0) goto L_0x0026
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.os.Message r0 = r0.f496f
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f496f
                goto L_0x0010
            L_0x0026:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r0 = r0.f497g
                if (r3 != r0) goto L_0x0037
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f498h
                if (r3 == 0) goto L_0x0037
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Message r3 = r3.f498h
                goto L_0x0010
            L_0x0037:
                r3 = 0
            L_0x0038:
                if (r3 == 0) goto L_0x003d
                r3.sendToTarget()
            L_0x003d:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r3 = r3.f506p
                r0 = 1
                androidx.appcompat.app.AlertController r1 = androidx.appcompat.app.AlertController.this
                androidx.appcompat.app.e r1 = r1.f491a
                android.os.Message r3 = r3.obtainMessage(r0, r1)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AnonymousClass1.onClick(android.view.View):void");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final e f491a;

    /* renamed from: b  reason: collision with root package name */
    ListView f492b;

    /* renamed from: c  reason: collision with root package name */
    Button f493c;

    /* renamed from: d  reason: collision with root package name */
    Message f494d;

    /* renamed from: e  reason: collision with root package name */
    Button f495e;

    /* renamed from: f  reason: collision with root package name */
    Message f496f;

    /* renamed from: g  reason: collision with root package name */
    Button f497g;

    /* renamed from: h  reason: collision with root package name */
    Message f498h;

    /* renamed from: i  reason: collision with root package name */
    NestedScrollView f499i;

    /* renamed from: j  reason: collision with root package name */
    ListAdapter f500j;

    /* renamed from: k  reason: collision with root package name */
    int f501k = -1;

    /* renamed from: l  reason: collision with root package name */
    int f502l;

    /* renamed from: m  reason: collision with root package name */
    int f503m;

    /* renamed from: n  reason: collision with root package name */
    int f504n;

    /* renamed from: o  reason: collision with root package name */
    int f505o;

    /* renamed from: p  reason: collision with root package name */
    Handler f506p;

    /* renamed from: q  reason: collision with root package name */
    private final Context f507q;

    /* renamed from: r  reason: collision with root package name */
    private final Window f508r;

    /* renamed from: s  reason: collision with root package name */
    private final int f509s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f510t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f511u;

    /* renamed from: v  reason: collision with root package name */
    private View f512v;

    /* renamed from: w  reason: collision with root package name */
    private int f513w;

    /* renamed from: x  reason: collision with root package name */
    private int f514x;

    /* renamed from: y  reason: collision with root package name */
    private int f515y;

    /* renamed from: z  reason: collision with root package name */
    private int f516z;

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f530a;

        /* renamed from: b  reason: collision with root package name */
        private final int f531b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f531b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f530a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z2, boolean z3) {
            if (!z3 || !z2) {
                setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f530a, getPaddingRight(), z3 ? getPaddingBottom() : this.f531b);
            }
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public C0016a O;
        public boolean P = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f532a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f533b;

        /* renamed from: c  reason: collision with root package name */
        public int f534c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f535d;

        /* renamed from: e  reason: collision with root package name */
        public int f536e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f537f;

        /* renamed from: g  reason: collision with root package name */
        public View f538g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f539h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f540i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f541j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f542k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f543l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f544m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f545n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f546o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f547p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f548q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f549r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f550s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f551t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f552u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f553v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f554w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f555x;

        /* renamed from: y  reason: collision with root package name */
        public int f556y;

        /* renamed from: z  reason: collision with root package name */
        public View f557z;

        /* renamed from: androidx.appcompat.app.AlertController$a$a  reason: collision with other inner class name */
        public interface C0016a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f532a = context;
            this.f549r = true;
            this.f533b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v25, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(final androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f533b
                int r1 = r11.f502l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$a$1 r9 = new androidx.appcompat.app.AlertController$a$1
                android.content.Context r3 = r10.f532a
                int r4 = r11.f503m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f553v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$a$2 r9 = new androidx.appcompat.app.AlertController$a$2
                android.content.Context r3 = r10.f532a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.f504n
                goto L_0x003e
            L_0x003c:
                int r1 = r11.f505o
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f532a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f554w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$c r9 = new androidx.appcompat.app.AlertController$c
                android.content.Context r1 = r10.f532a
                java.lang.CharSequence[] r3 = r10.f553v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$a$a r1 = r10.O
                if (r1 == 0) goto L_0x0072
                r1.a(r0)
            L_0x0072:
                r11.f500j = r9
                int r1 = r10.I
                r11.f501k = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f555x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$a$3 r1 = new androidx.appcompat.app.AlertController$a$3
                r1.<init>(r11)
            L_0x0081:
                r0.setOnItemClickListener(r1)
                goto L_0x008f
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x008f
                androidx.appcompat.app.AlertController$a$4 r1 = new androidx.appcompat.app.AlertController$a$4
                r1.<init>(r0, r11)
                goto L_0x0081
            L_0x008f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L_0x0096
                r0.setOnItemSelectedListener(r1)
            L_0x0096:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x009e
                r0.setChoiceMode(r8)
                goto L_0x00a6
            L_0x009e:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a6
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a6:
                r11.f492b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.a.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f538g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f537f;
                if (charSequence != null) {
                    alertController.a(charSequence);
                }
                Drawable drawable = this.f535d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i2 = this.f534c;
                if (i2 != 0) {
                    alertController.b(i2);
                }
                int i3 = this.f536e;
                if (i3 != 0) {
                    alertController.b(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.f539h;
            if (charSequence2 != null) {
                alertController.b(charSequence2);
            }
            CharSequence charSequence3 = this.f540i;
            if (!(charSequence3 == null && this.f541j == null)) {
                alertController.a(-1, charSequence3, this.f542k, (Message) null, this.f541j);
            }
            CharSequence charSequence4 = this.f543l;
            if (!(charSequence4 == null && this.f544m == null)) {
                alertController.a(-2, charSequence4, this.f545n, (Message) null, this.f544m);
            }
            CharSequence charSequence5 = this.f546o;
            if (!(charSequence5 == null && this.f547p == null)) {
                alertController.a(-3, charSequence5, this.f548q, (Message) null, this.f547p);
            }
            if (!(this.f553v == null && this.K == null && this.f554w == null)) {
                b(alertController);
            }
            View view2 = this.f557z;
            if (view2 == null) {
                int i4 = this.f556y;
                if (i4 != 0) {
                    alertController.a(i4);
                }
            } else if (this.E) {
                alertController.a(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.c(view2);
            }
        }
    }

    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f570a;

        public b(DialogInterface dialogInterface) {
            this.f570a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f570a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, e eVar, Window window) {
        this.f507q = context;
        this.f491a = eVar;
        this.f508r = window;
        this.f506p = new b(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f502l = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f503m = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f504n = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f505o = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f509s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        eVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    private void a(ViewGroup viewGroup) {
        View view = this.f512v;
        boolean z2 = false;
        if (view == null) {
            view = this.f513w != 0 ? LayoutInflater.from(this.f507q).inflate(this.f513w, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f508r.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f508r.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.f514x, this.f515y, this.f516z, this.A);
            }
            if (this.f492b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i2, int i3) {
        final View findViewById = this.f508r.findViewById(R.id.scrollIndicatorUp);
        final View findViewById2 = this.f508r.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ac.a(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        } else {
            if (findViewById != null && (i2 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i2 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById != null || findViewById2 != null) {
                if (this.f511u != null) {
                    this.f499i.setOnScrollChangeListener(new NestedScrollView.b() {
                        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                            AlertController.a(nestedScrollView, findViewById, findViewById2);
                        }
                    });
                    this.f499i.post(new Runnable() {
                        public void run() {
                            AlertController.a(AlertController.this.f499i, findViewById, findViewById2);
                        }
                    });
                    return;
                }
                ListView listView = this.f492b;
                if (listView != null) {
                    listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                            AlertController.a(absListView, findViewById, findViewById2);
                        }

                        public void onScrollStateChanged(AbsListView absListView, int i2) {
                        }
                    });
                    this.f492b.post(new Runnable() {
                        public void run() {
                            AlertController.a(AlertController.this.f492b, findViewById, findViewById2);
                        }
                    });
                    return;
                }
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 == null) {
                    return;
                }
            } else {
                return;
            }
        }
        viewGroup.removeView(findViewById2);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f508r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.f508r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f510t)) || !this.Q) {
            this.f508r.findViewById(R.id.title_template).setVisibility(8);
            this.K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f508r.findViewById(R.id.alertTitle);
        this.L = textView;
        textView.setText(this.f510t);
        int i2 = this.I;
        if (i2 != 0) {
            this.K.setImageResource(i2);
            return;
        }
        Drawable drawable = this.J;
        if (drawable != null) {
            this.K.setImageDrawable(drawable);
            return;
        }
        this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
        this.K.setVisibility(8);
    }

    private int c() {
        int i2 = this.P;
        return i2 == 0 ? this.O : this.R == 1 ? i2 : this.O;
    }

    private void c(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f508r.findViewById(R.id.scrollView);
        this.f499i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f499i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.M = textView;
        if (textView != null) {
            CharSequence charSequence = this.f511u;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.f499i.removeView(this.M);
            if (this.f492b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f499i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f499i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f492b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void d() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f508r.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        a(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        c(a3);
        d(a4);
        b(a2);
        char c2 = 0;
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z3 = (a2 == null || a2.getVisibility() == 8) ? false : true;
        boolean z4 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!(z4 || a3 == null || (findViewById2 = a3.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.f499i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f511u == null && this.f492b == null)) {
                view = a2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a3 == null || (findViewById = a3.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f492b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.f492b;
            if (view2 == null) {
                view2 = this.f499i;
            }
            if (view2 != null) {
                if (z4) {
                    c2 = 2;
                }
                a(a3, view2, z3 | c2 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f492b;
        if (listView2 != null && (listAdapter = this.f500j) != null) {
            listView2.setAdapter(listAdapter);
            int i2 = this.f501k;
            if (i2 > -1) {
                listView2.setItemChecked(i2, true);
                listView2.setSelection(i2);
            }
        }
    }

    private void d(ViewGroup viewGroup) {
        boolean z2;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.f493c = button2;
        button2.setOnClickListener(this.S);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.C) || this.D != null) {
            this.f493c.setText(this.C);
            Drawable drawable = this.D;
            if (drawable != null) {
                int i2 = this.f509s;
                drawable.setBounds(0, 0, i2, i2);
                this.f493c.setCompoundDrawables(this.D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f493c.setVisibility(0);
            z2 = true;
        } else {
            this.f493c.setVisibility(8);
            z2 = false;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.f495e = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.E) || this.F != null) {
            this.f495e.setText(this.E);
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                int i3 = this.f509s;
                drawable2.setBounds(0, 0, i3, i3);
                this.f495e.setCompoundDrawables(this.F, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f495e.setVisibility(0);
            z2 |= true;
        } else {
            this.f495e.setVisibility(8);
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.f497g = button4;
        button4.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.G) || this.H != null) {
            this.f497g.setText(this.G);
            Drawable drawable3 = this.H;
            if (drawable3 != null) {
                int i4 = this.f509s;
                drawable3.setBounds(0, 0, i4, i4);
                this.f497g.setCompoundDrawables(this.H, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f497g.setVisibility(0);
            z2 |= true;
        } else {
            this.f497g.setVisibility(8);
        }
        if (a(this.f507q)) {
            if (z2) {
                button = this.f493c;
            } else if (z2) {
                button = this.f495e;
            } else if (z2) {
                button = this.f497g;
            }
            a(button);
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        this.f491a.setContentView(c());
        d();
    }

    public void a(int i2) {
        this.f512v = null;
        this.f513w = i2;
        this.B = false;
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f506p.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.G = charSequence;
            this.f498h = message;
            this.H = drawable;
        } else if (i2 == -2) {
            this.E = charSequence;
            this.f496f = message;
            this.F = drawable;
        } else if (i2 == -1) {
            this.C = charSequence;
            this.f494d = message;
            this.D = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.K.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f512v = view;
        this.f513w = 0;
        this.B = true;
        this.f514x = i2;
        this.f515y = i3;
        this.f516z = i4;
        this.A = i5;
    }

    public void a(CharSequence charSequence) {
        this.f510t = charSequence;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f499i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public ListView b() {
        return this.f492b;
    }

    public void b(int i2) {
        this.J = null;
        this.I = i2;
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.K.setImageResource(this.I);
            return;
        }
        imageView.setVisibility(8);
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.f511u = charSequence;
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f499i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f507q.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.f512v = view;
        this.f513w = 0;
        this.B = false;
    }
}
