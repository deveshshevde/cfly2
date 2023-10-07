package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.customview.view.AbsSavedState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.blankj.utilcode.constant.MemoryConstants;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import t.ac;

public class SearchView extends LinearLayoutCompat implements f.c {

    /* renamed from: i  reason: collision with root package name */
    static final d f1256i = (Build.VERSION.SDK_INT < 29 ? new d() : null);
    private b A;
    private a B;
    private c C;
    private View.OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, Drawable.ConstantState> T;
    private final View.OnClickListener U;
    private final TextView.OnEditorActionListener V;
    private final AdapterView.OnItemClickListener W;

    /* renamed from: a  reason: collision with root package name */
    final SearchAutoComplete f1257a;

    /* renamed from: aa  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1258aa;

    /* renamed from: ab  reason: collision with root package name */
    private TextWatcher f1259ab;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f1260b;

    /* renamed from: c  reason: collision with root package name */
    final ImageView f1261c;

    /* renamed from: d  reason: collision with root package name */
    final ImageView f1262d;

    /* renamed from: e  reason: collision with root package name */
    final ImageView f1263e;

    /* renamed from: f  reason: collision with root package name */
    View.OnFocusChangeListener f1264f;

    /* renamed from: g  reason: collision with root package name */
    w.a f1265g;

    /* renamed from: h  reason: collision with root package name */
    SearchableInfo f1266h;

    /* renamed from: j  reason: collision with root package name */
    View.OnKeyListener f1267j;

    /* renamed from: k  reason: collision with root package name */
    private final View f1268k;

    /* renamed from: l  reason: collision with root package name */
    private final View f1269l;

    /* renamed from: m  reason: collision with root package name */
    private final View f1270m;

    /* renamed from: n  reason: collision with root package name */
    private final View f1271n;

    /* renamed from: o  reason: collision with root package name */
    private e f1272o;

    /* renamed from: p  reason: collision with root package name */
    private Rect f1273p;

    /* renamed from: q  reason: collision with root package name */
    private Rect f1274q;

    /* renamed from: r  reason: collision with root package name */
    private int[] f1275r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f1276s;

    /* renamed from: t  reason: collision with root package name */
    private final ImageView f1277t;

    /* renamed from: u  reason: collision with root package name */
    private final Drawable f1278u;

    /* renamed from: v  reason: collision with root package name */
    private final int f1279v;

    /* renamed from: w  reason: collision with root package name */
    private final int f1280w;

    /* renamed from: x  reason: collision with root package name */
    private final Intent f1281x;

    /* renamed from: y  reason: collision with root package name */
    private final Intent f1282y;

    /* renamed from: z  reason: collision with root package name */
    private final CharSequence f1283z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f1294a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1294a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1294a + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f1294a));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1295a;

        /* renamed from: b  reason: collision with root package name */
        private int f1296b;

        /* renamed from: c  reason: collision with root package name */
        private SearchView f1297c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1298d;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f1295a = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.f1296b = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 >= 600) {
                return 192;
            }
            if (i2 < 640 || i3 < 480) {
                return GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.f1298d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1298d = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1256i.c(this);
        }

        public boolean enoughToFilter() {
            return this.f1296b <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1298d) {
                removeCallbacks(this.f1295a);
                post(this.f1295a);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z2, int i2, Rect rect) {
            super.onFocusChanged(z2, i2, rect);
            this.f1297c.i();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1297c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        public void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f1297c.hasFocus() && getVisibility() == 0) {
                this.f1298d = true;
                if (SearchView.a(getContext())) {
                    c();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f1298d = false;
                removeCallbacks(this.f1295a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1298d = false;
                removeCallbacks(this.f1295a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1298d = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1297c = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1296b = i2;
        }
    }

    public interface a {
        boolean a();
    }

    public interface b {
        boolean a(String str);

        boolean b(String str);
    }

    public interface c {
        boolean a(int i2);

        boolean b(int i2);
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private Method f1300a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f1301b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f1302c = null;

        d() {
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1300a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1301b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1302c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1300a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1301b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f1302c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{true});
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class e extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1303a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f1304b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1305c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1306d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f1307e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1308f;

        public e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1307e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1303a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1304b.set(rect);
            this.f1306d.set(rect);
            Rect rect3 = this.f1306d;
            int i2 = this.f1307e;
            rect3.inset(-i2, -i2);
            this.f1305c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0032
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f1308f
                r7.f1308f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f1308f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f1306d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r4 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f1304b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f1308f = r4
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r4 = 0
            L_0x003f:
                if (r4 == 0) goto L_0x0070
                if (r2 == 0) goto L_0x005b
                android.graphics.Rect r2 = r7.f1305c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005b
                android.view.View r0 = r7.f1303a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1303a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                goto L_0x0066
            L_0x005b:
                android.graphics.Rect r2 = r7.f1305c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r7.f1305c
                int r2 = r2.top
                int r1 = r1 - r2
            L_0x0066:
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                android.view.View r0 = r7.f1303a
                boolean r5 = r0.dispatchTouchEvent(r8)
            L_0x0070:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1273p = new Rect();
        this.f1274q = new Rect();
        this.f1275r = new int[2];
        this.f1276s = new int[2];
        this.R = new Runnable() {
            public void run() {
                SearchView.this.d();
            }
        };
        this.S = new Runnable() {
            public void run() {
                if (SearchView.this.f1265g instanceof z) {
                    SearchView.this.f1265g.a((Cursor) null);
                }
            }
        };
        this.T = new WeakHashMap<>();
        AnonymousClass6 r1 = new View.OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.f1260b) {
                    SearchView.this.g();
                } else if (view == SearchView.this.f1262d) {
                    SearchView.this.f();
                } else if (view == SearchView.this.f1261c) {
                    SearchView.this.e();
                } else if (view == SearchView.this.f1263e) {
                    SearchView.this.h();
                } else if (view == SearchView.this.f1257a) {
                    SearchView.this.l();
                }
            }
        };
        this.U = r1;
        this.f1267j = new View.OnKeyListener() {
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.f1266h == null) {
                    return false;
                }
                if (SearchView.this.f1257a.isPopupShowing() && SearchView.this.f1257a.getListSelection() != -1) {
                    return SearchView.this.a(view, i2, keyEvent);
                }
                if (SearchView.this.f1257a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView = SearchView.this;
                searchView.a(0, (String) null, searchView.f1257a.getText().toString());
                return true;
            }
        };
        AnonymousClass8 r2 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.e();
                return true;
            }
        };
        this.V = r2;
        AnonymousClass9 r3 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.a(i2, 0, (String) null);
            }
        };
        this.W = r3;
        AnonymousClass10 r4 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.a(i2);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f1258aa = r4;
        this.f1259ab = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.b(charSequence);
            }
        };
        af a2 = af.a(context, attributeSet, R.styleable.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.g(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1257a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1268k = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f1269l = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f1270m = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f1260b = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f1261c = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f1262d = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f1263e = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f1277t = imageView5;
        ac.a(findViewById, a2.a(R.styleable.SearchView_queryBackground));
        ac.a(findViewById2, a2.a(R.styleable.SearchView_submitBackground));
        imageView.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(a2.a(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(a2.a(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(a2.a(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        this.f1278u = a2.a(R.styleable.SearchView_searchHintIcon);
        ah.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f1279v = a2.g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f1280w = a2.g(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(r1);
        imageView3.setOnClickListener(r1);
        imageView2.setOnClickListener(r1);
        imageView4.setOnClickListener(r1);
        searchAutoComplete.setOnClickListener(r1);
        searchAutoComplete.addTextChangedListener(this.f1259ab);
        searchAutoComplete.setOnEditorActionListener(r2);
        searchAutoComplete.setOnItemClickListener(r3);
        searchAutoComplete.setOnItemSelectedListener(r4);
        searchAutoComplete.setOnKeyListener(this.f1267j);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z2) {
                if (SearchView.this.f1264f != null) {
                    SearchView.this.f1264f.onFocusChange(SearchView.this, z2);
                }
            }
        });
        setIconifiedByDefault(a2.a(R.styleable.SearchView_iconifiedByDefault, true));
        int e2 = a2.e(R.styleable.SearchView_android_maxWidth, -1);
        if (e2 != -1) {
            setMaxWidth(e2);
        }
        this.f1283z = a2.c(R.styleable.SearchView_defaultQueryHint);
        this.H = a2.c(R.styleable.SearchView_queryHint);
        int a3 = a2.a(R.styleable.SearchView_android_imeOptions, -1);
        if (a3 != -1) {
            setImeOptions(a3);
        }
        int a4 = a2.a(R.styleable.SearchView_android_inputType, -1);
        if (a4 != -1) {
            setInputType(a4);
        }
        setFocusable(a2.a(R.styleable.SearchView_android_focusable, true));
        a2.b();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1281x = intent;
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1282y = intent2;
        intent2.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1271n = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.k();
                }
            });
        }
        a(this.E);
        r();
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent a(Cursor cursor, int i2, String str) {
        int i3;
        String a2;
        try {
            String a3 = z.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.f1266h.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String str2 = a3;
            String a4 = z.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.f1266h.getSuggestIntentData();
            }
            if (!(a4 == null || (a2 = z.a(cursor, "suggest_intent_data_id")) == null)) {
                a4 = a4 + "/" + Uri.encode(a2);
            }
            return a(str2, a4 == null ? null : Uri.parse(a4), z.a(cursor, "suggest_intent_extra_data"), z.a(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.Q;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1266h.getSearchActivity());
        return intent;
    }

    private void a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.e("SearchView", "Failed launch activity: " + intent, e2);
            }
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.f1275r);
        getLocationInWindow(this.f1276s);
        int[] iArr = this.f1275r;
        int i2 = iArr[1];
        int[] iArr2 = this.f1276s;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private void a(boolean z2) {
        this.F = z2;
        int i2 = 0;
        int i3 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1257a.getText());
        this.f1260b.setVisibility(i3);
        b(z3);
        this.f1268k.setVisibility(z2 ? 8 : 0);
        if (this.f1277t.getDrawable() == null || this.E) {
            i2 = 8;
        }
        this.f1277t.setVisibility(i2);
        p();
        c(!z3);
        o();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, MemoryConstants.GB);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.Q;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private void b(boolean z2) {
        this.f1261c.setVisibility((!this.G || !n() || !hasFocus() || (!z2 && this.L)) ? 8 : 0);
    }

    private boolean b(int i2, int i3, String str) {
        Cursor a2 = this.f1265g.a();
        if (a2 == null || !a2.moveToPosition(i2)) {
            return false;
        }
        a(a(a2, i3, str));
        return true;
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.E || this.f1278u == null) {
            return charSequence;
        }
        double textSize = (double) this.f1257a.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.f1278u.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1278u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void c(boolean z2) {
        int i2 = 8;
        if (this.L && !c() && z2) {
            this.f1261c.setVisibility(8);
            i2 = 0;
        }
        this.f1263e.setVisibility(i2);
    }

    private void e(int i2) {
        CharSequence b2;
        Editable text = this.f1257a.getText();
        Cursor a2 = this.f1265g.a();
        if (a2 != null) {
            if (!a2.moveToPosition(i2) || (b2 = this.f1265g.b(a2)) == null) {
                setQuery(text);
            } else {
                setQuery(b2);
            }
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private boolean m() {
        SearchableInfo searchableInfo = this.f1266h;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1266h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1281x;
        } else if (this.f1266h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1282y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean n() {
        return (this.G || this.L) && !c();
    }

    private void o() {
        this.f1270m.setVisibility((!n() || !(this.f1261c.getVisibility() == 0 || this.f1263e.getVisibility() == 0)) ? 8 : 0);
    }

    private void p() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1257a.getText());
        int i2 = 0;
        if (!z3 && (!this.E || this.O)) {
            z2 = false;
        }
        ImageView imageView = this.f1262d;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1262d.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void q() {
        post(this.R);
    }

    private void r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1257a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void s() {
        this.f1257a.setThreshold(this.f1266h.getSuggestThreshold());
        this.f1257a.setImeOptions(this.f1266h.getImeOptions());
        int inputType = this.f1266h.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1266h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1257a.setInputType(inputType);
        w.a aVar = this.f1265g;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.f1266h.getSuggestAuthority() != null) {
            z zVar = new z(getContext(), this, this.f1266h, this.T);
            this.f1265g = zVar;
            this.f1257a.setAdapter(zVar);
            z zVar2 = (z) this.f1265g;
            if (this.I) {
                i2 = 2;
            }
            zVar2.a(i2);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1257a.setText(charSequence);
        this.f1257a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void t() {
        this.f1257a.dismissDropDown();
    }

    public void a() {
        if (!this.O) {
            this.O = true;
            int imeOptions = this.f1257a.getImeOptions();
            this.P = imeOptions;
            this.f1257a.setImeOptions(imeOptions | 33554432);
            this.f1257a.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    /* access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z2) {
        this.f1257a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1257a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.N = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        c cVar = this.C;
        if (cVar != null && cVar.a(i2)) {
            return false;
        }
        e(i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, String str) {
        c cVar = this.C;
        if (cVar != null && cVar.b(i2)) {
            return false;
        }
        b(i2, 0, (String) null);
        this.f1257a.setImeVisibility(false);
        t();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i2, KeyEvent keyEvent) {
        if (this.f1266h != null && this.f1265g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return a(this.f1257a.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f1257a.setSelection(i2 == 21 ? 0 : this.f1257a.length());
                this.f1257a.setListSelection(0);
                this.f1257a.clearListSelection();
                this.f1257a.c();
                return true;
            } else if (i2 != 19 || this.f1257a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    public void b() {
        a((CharSequence) "", false);
        clearFocus();
        a(true);
        this.f1257a.setImeOptions(this.P);
        this.O = false;
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        Editable text = this.f1257a.getText();
        this.N = text;
        boolean z2 = !TextUtils.isEmpty(text);
        b(z2);
        c(!z2);
        p();
        o();
        if (this.A != null && !TextUtils.equals(charSequence, this.M)) {
            this.A.b(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    public boolean c() {
        return this.F;
    }

    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.f1257a.clearFocus();
        this.f1257a.setImeVisibility(false);
        this.J = false;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int[] iArr = this.f1257a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1269l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1270m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        Editable text = this.f1257a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            b bVar = this.A;
            if (bVar == null || !bVar.a(text.toString())) {
                if (this.f1266h != null) {
                    a(0, (String) null, text.toString());
                }
                this.f1257a.setImeVisibility(false);
                t();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!TextUtils.isEmpty(this.f1257a.getText())) {
            this.f1257a.setText("");
            this.f1257a.requestFocus();
            this.f1257a.setImeVisibility(true);
        } else if (this.E) {
            a aVar = this.B;
            if (aVar == null || !aVar.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(false);
        this.f1257a.requestFocus();
        this.f1257a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.D;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public int getImeOptions() {
        return this.f1257a.getImeOptions();
    }

    public int getInputType() {
        return this.f1257a.getInputType();
    }

    public int getMaxWidth() {
        return this.K;
    }

    public CharSequence getQuery() {
        return this.f1257a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.H;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1266h;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f1283z : getContext().getText(this.f1266h.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f1280w;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f1279v;
    }

    public w.a getSuggestionsAdapter() {
        return this.f1265g;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Intent b2;
        SearchableInfo searchableInfo = this.f1266h;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    b2 = a(this.f1281x, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    b2 = b(this.f1282y, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(b2);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        a(c());
        q();
        if (this.f1257a.hasFocus()) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f1271n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1269l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = al.a(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1257a.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.f1257a.setDropDownHorizontalOffset(a2 ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.f1257a.setDropDownWidth((((this.f1271n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1257a.refreshAutoCompleteResults();
            return;
        }
        d dVar = f1256i;
        dVar.a(this.f1257a);
        dVar.b(this.f1257a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            a((View) this.f1257a, this.f1273p);
            this.f1274q.set(this.f1273p.left, 0, this.f1273p.right, i5 - i3);
            e eVar = this.f1272o;
            if (eVar == null) {
                e eVar2 = new e(this.f1274q, this.f1273p, this.f1257a);
                this.f1272o = eVar2;
                setTouchDelegate(eVar2);
                return;
            }
            eVar.a(this.f1274q, this.f1273p);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.c()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002c
            if (r0 == 0) goto L_0x0022
            if (r0 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            int r0 = r3.K
            if (r0 <= 0) goto L_0x0039
            goto L_0x0030
        L_0x0022:
            int r4 = r3.K
            if (r4 <= 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            int r4 = r3.getPreferredWidth()
            goto L_0x0039
        L_0x002c:
            int r0 = r3.K
            if (r0 <= 0) goto L_0x0031
        L_0x0030:
            goto L_0x0035
        L_0x0031:
            int r0 = r3.getPreferredWidth()
        L_0x0035:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0039:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004b
            if (r0 == 0) goto L_0x0046
            goto L_0x0053
        L_0x0046:
            int r5 = r3.getPreferredHeight()
            goto L_0x0053
        L_0x004b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0053:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        a(savedState.f1294a);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1294a = c();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        q();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.J || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.f1257a.requestFocus(i2, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            f();
        } else {
            g();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            a(z2);
            r();
        }
    }

    public void setImeOptions(int i2) {
        this.f1257a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1257a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.K = i2;
        requestLayout();
    }

    public void setOnCloseListener(a aVar) {
        this.B = aVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1264f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(b bVar) {
        this.A = bVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnSuggestionListener(c cVar) {
        this.C = cVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        r();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.I = z2;
        w.a aVar = this.f1265g;
        if (aVar instanceof z) {
            ((z) aVar).a(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1266h = searchableInfo;
        if (searchableInfo != null) {
            s();
            r();
        }
        boolean m2 = m();
        this.L = m2;
        if (m2) {
            this.f1257a.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.G = z2;
        a(c());
    }

    public void setSuggestionsAdapter(w.a aVar) {
        this.f1265g = aVar;
        this.f1257a.setAdapter(aVar);
    }
}
