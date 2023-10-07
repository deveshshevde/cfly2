package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f3273a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f3274b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3275c;

    /* renamed from: d  reason: collision with root package name */
    private FragmentManager f3276d;

    /* renamed from: e  reason: collision with root package name */
    private int f3277e;

    /* renamed from: f  reason: collision with root package name */
    private TabHost.OnTabChangeListener f3278f;

    /* renamed from: g  reason: collision with root package name */
    private b f3279g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3280h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f3281a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3281a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3281a + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3281a);
        }
    }

    static class a implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3282a;

        public a(Context context) {
            this.f3282a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f3282a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f3283a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f3284b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f3285c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f3286d;

        b(String str, Class<?> cls, Bundle bundle) {
            this.f3283a = str;
            this.f3284b = cls;
            this.f3285c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private b a(String str) {
        int size = this.f3273a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f3273a.get(i2);
            if (bVar.f3283a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private s a(String str, s sVar) {
        b a2 = a(str);
        if (this.f3279g != a2) {
            if (sVar == null) {
                sVar = this.f3276d.a();
            }
            b bVar = this.f3279g;
            if (!(bVar == null || bVar.f3286d == null)) {
                sVar.d(this.f3279g.f3286d);
            }
            if (a2 != null) {
                if (a2.f3286d == null) {
                    a2.f3286d = this.f3276d.E().c(this.f3275c.getClassLoader(), a2.f3284b.getName());
                    a2.f3286d.setArguments(a2.f3285c);
                    sVar.a(this.f3277e, a2.f3286d, a2.f3283a);
                } else {
                    sVar.e(a2.f3286d);
                }
            }
            this.f3279g = a2;
        }
        return sVar;
    }

    private void a() {
        if (this.f3274b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f3277e);
            this.f3274b = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f3277e);
            }
        }
    }

    private void a(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f3274b = frameLayout2;
            frameLayout2.setId(this.f3277e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f3277e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void a(Context context, FragmentManager fragmentManager, int i2) {
        a(context);
        super.setup();
        this.f3275c = context;
        this.f3276d = fragmentManager;
        this.f3277e = i2;
        a();
        this.f3274b.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    @Deprecated
    public void a(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new a(this.f3275c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f3280h) {
            bVar.f3286d = this.f3276d.b(tag);
            if (bVar.f3286d != null && !bVar.f3286d.isDetached()) {
                s a2 = this.f3276d.a();
                a2.d(bVar.f3286d);
                a2.c();
            }
        }
        this.f3273a.add(bVar);
        addTab(tabSpec);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3273a.size();
        s sVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f3273a.get(i2);
            bVar.f3286d = this.f3276d.b(bVar.f3283a);
            if (bVar.f3286d != null && !bVar.f3286d.isDetached()) {
                if (bVar.f3283a.equals(currentTabTag)) {
                    this.f3279g = bVar;
                } else {
                    if (sVar == null) {
                        sVar = this.f3276d.a();
                    }
                    sVar.d(bVar.f3286d);
                }
            }
        }
        this.f3280h = true;
        s a2 = a(currentTabTag, sVar);
        if (a2 != null) {
            a2.c();
            this.f3276d.b();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3280h = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f3281a);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3281a = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(String str) {
        s a2;
        if (this.f3280h && (a2 = a(str, (s) null)) != null) {
            a2.c();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3278f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3278f = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
