package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.b;
import t.aa;
import t.ac;

public class AppCompatSpinner extends Spinner implements aa {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1128c = {16843505};

    /* renamed from: a  reason: collision with root package name */
    int f1129a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1130b;

    /* renamed from: d  reason: collision with root package name */
    private final d f1131d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f1132e;

    /* renamed from: f  reason: collision with root package name */
    private t f1133f;

    /* renamed from: g  reason: collision with root package name */
    private SpinnerAdapter f1134g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1135h;

    /* renamed from: i  reason: collision with root package name */
    private d f1136i;

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
        boolean f1140a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1140a = parcel.readByte() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f1140a ? (byte) 1 : 0);
        }
    }

    class a implements DialogInterface.OnClickListener, d {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.b f1141a;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1143c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f1144d;

        a() {
        }

        public CharSequence a() {
            return this.f1144d;
        }

        public void a(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void a(int i2, int i3) {
            if (this.f1143c != null) {
                b.a aVar = new b.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1144d;
                if (charSequence != null) {
                    aVar.a(charSequence);
                }
                androidx.appcompat.app.b b2 = aVar.a(this.f1143c, AppCompatSpinner.this.getSelectedItemPosition(), this).b();
                this.f1141a = b2;
                ListView a2 = b2.a();
                if (Build.VERSION.SDK_INT >= 17) {
                    a2.setTextDirection(i2);
                    a2.setTextAlignment(i3);
                }
                this.f1141a.show();
            }
        }

        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void a(ListAdapter listAdapter) {
            this.f1143c = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.f1144d = charSequence;
        }

        public Drawable b() {
            return null;
        }

        public void b(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public int c() {
            return 0;
        }

        public void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void d() {
            androidx.appcompat.app.b bVar = this.f1141a;
            if (bVar != null) {
                bVar.dismiss();
                this.f1141a = null;
            }
        }

        public boolean e() {
            androidx.appcompat.app.b bVar = this.f1141a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        public int f() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i2, this.f1143c.getItemId(i2));
            }
            d();
        }
    }

    private static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f1145a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1146b;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1145a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1146b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ab) {
                ab abVar = (ab) spinnerAdapter;
                if (abVar.a() == null) {
                    abVar.a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1146b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f1146b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1145a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class c extends ListPopupWindow implements d {

        /* renamed from: a  reason: collision with root package name */
        ListAdapter f1147a;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f1149h;

        /* renamed from: i  reason: collision with root package name */
        private final Rect f1150i = new Rect();

        /* renamed from: j  reason: collision with root package name */
        private int f1151j;

        public c(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            b((View) AppCompatSpinner.this);
            a(true);
            d(0);
            a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, c.this.f1147a.getItemId(i2));
                    }
                    c.this.d();
                }
            });
        }

        public CharSequence a() {
            return this.f1149h;
        }

        public void a(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean e2 = e();
            h();
            i(2);
            super.c_();
            ListView g2 = g();
            g2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                g2.setTextDirection(i2);
                g2.setTextAlignment(i3);
            }
            j(AppCompatSpinner.this.getSelectedItemPosition());
            if (!e2 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r6 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        c cVar = c.this;
                        if (!cVar.a((View) AppCompatSpinner.this)) {
                            c.this.d();
                            return;
                        }
                        c.this.h();
                        c.super.c_();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r6);
                a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r6);
                        }
                    }
                });
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f1147a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.f1149h = charSequence;
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view) {
            return ac.J(view) && view.getGlobalVisibleRect(this.f1150i);
        }

        public void c(int i2) {
            this.f1151j = i2;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i2;
            Drawable b2 = b();
            int i3 = 0;
            if (b2 != null) {
                b2.getPadding(AppCompatSpinner.this.f1130b);
                i3 = al.a(AppCompatSpinner.this) ? AppCompatSpinner.this.f1130b.right : -AppCompatSpinner.this.f1130b.left;
            } else {
                Rect rect = AppCompatSpinner.this.f1130b;
                AppCompatSpinner.this.f1130b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f1129a == -2) {
                int a2 = AppCompatSpinner.this.a((SpinnerAdapter) this.f1147a, b());
                int i4 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f1130b.left) - AppCompatSpinner.this.f1130b.right;
                if (a2 > i4) {
                    a2 = i4;
                }
                i2 = Math.max(a2, (width - paddingLeft) - paddingRight);
            } else {
                i2 = AppCompatSpinner.this.f1129a == -1 ? (width - paddingLeft) - paddingRight : AppCompatSpinner.this.f1129a;
            }
            h(i2);
            b(al.a(AppCompatSpinner.this) ? i3 + (((width - paddingRight) - l()) - i()) : i3 + paddingLeft + i());
        }

        public int i() {
            return this.f1151j;
        }
    }

    interface d {
        CharSequence a();

        void a(int i2);

        void a(int i2, int i3);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        Drawable b();

        void b(int i2);

        int c();

        void c(int i2);

        void d();

        boolean e();

        int f();
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r11 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        if (r11 != null) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[SYNTHETIC, Splitter:B:10:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1130b = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.aa.a((android.view.View) r6, (android.content.Context) r0)
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.af r0 = androidx.appcompat.widget.af.a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.d r2 = new androidx.appcompat.widget.d
            r2.<init>(r6)
            r6.f1131d = r2
            if (r11 == 0) goto L_0x0029
            f.d r2 = new f.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
        L_0x0026:
            r6.f1132e = r2
            goto L_0x0039
        L_0x0029:
            int r11 = androidx.appcompat.R.styleable.Spinner_popupTheme
            int r11 = r0.g(r11, r1)
            if (r11 == 0) goto L_0x0037
            f.d r2 = new f.d
            r2.<init>((android.content.Context) r7, (int) r11)
            goto L_0x0026
        L_0x0037:
            r6.f1132e = r7
        L_0x0039:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006b
            int[] r11 = f1128c     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0053 }
            if (r3 == 0) goto L_0x004d
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0053 }
        L_0x004d:
            if (r11 == 0) goto L_0x006b
        L_0x004f:
            r11.recycle()
            goto L_0x006b
        L_0x0053:
            r3 = move-exception
            goto L_0x0059
        L_0x0055:
            r7 = move-exception
            goto L_0x0065
        L_0x0057:
            r3 = move-exception
            r11 = r2
        L_0x0059:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0063 }
            if (r11 == 0) goto L_0x006b
            goto L_0x004f
        L_0x0063:
            r7 = move-exception
            r2 = r11
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.recycle()
        L_0x006a:
            throw r7
        L_0x006b:
            r11 = 1
            if (r10 == 0) goto L_0x00a8
            if (r10 == r11) goto L_0x0071
            goto L_0x00b8
        L_0x0071:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            android.content.Context r3 = r6.f1132e
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f1132e
            int[] r4 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.af r1 = androidx.appcompat.widget.af.a(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.f(r3, r4)
            r6.f1129a = r3
            int r3 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.a(r3)
            r10.a((android.graphics.drawable.Drawable) r3)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r3 = r0.d(r3)
            r10.a((java.lang.CharSequence) r3)
            r1.b()
            r6.f1136i = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r6, r10)
            r6.f1133f = r1
            goto L_0x00b8
        L_0x00a8:
            androidx.appcompat.widget.AppCompatSpinner$a r10 = new androidx.appcompat.widget.AppCompatSpinner$a
            r10.<init>()
            r6.f1136i = r10
            int r1 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r10.a((java.lang.CharSequence) r1)
        L_0x00b8:
            int r10 = androidx.appcompat.R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.f(r10)
            if (r10 == 0) goto L_0x00d0
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d0:
            r0.b()
            r6.f1135h = r11
            android.widget.SpinnerAdapter r7 = r6.f1134g
            if (r7 == 0) goto L_0x00de
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1134g = r2
        L_0x00de:
            androidx.appcompat.widget.d r7 = r6.f1131d
            r7.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f1130b);
        return i3 + this.f1130b.left + this.f1130b.right;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1136i.a(getTextDirection(), getTextAlignment());
        } else {
            this.f1136i.a(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1131d;
        if (dVar != null) {
            dVar.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        d dVar = this.f1136i;
        if (dVar != null) {
            return dVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        d dVar = this.f1136i;
        if (dVar != null) {
            return dVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f1136i != null) {
            return this.f1129a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final d getInternalPopup() {
        return this.f1136i;
    }

    public Drawable getPopupBackground() {
        d dVar = this.f1136i;
        if (dVar != null) {
            return dVar.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f1132e;
    }

    public CharSequence getPrompt() {
        d dVar = this.f1136i;
        return dVar != null ? dVar.a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1131d;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1131d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f1136i;
        if (dVar != null && dVar.e()) {
            this.f1136i.d();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1136i != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1140a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().e()) {
                        AppCompatSpinner.this.a();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.f1136i;
        savedState.f1140a = dVar != null && dVar.e();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar = this.f1133f;
        if (tVar == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        d dVar = this.f1136i;
        if (dVar == null) {
            return super.performClick();
        }
        if (dVar.e()) {
            return true;
        }
        a();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1135h) {
            this.f1134g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1136i != null) {
            Context context = this.f1132e;
            if (context == null) {
                context = getContext();
            }
            this.f1136i.a((ListAdapter) new b(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1131d;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1131d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        d dVar = this.f1136i;
        if (dVar != null) {
            dVar.c(i2);
            this.f1136i.b(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        d dVar = this.f1136i;
        if (dVar != null) {
            dVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f1136i != null) {
            this.f1129a = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        d dVar = this.f1136i;
        if (dVar != null) {
            dVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(c.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        d dVar = this.f1136i;
        if (dVar != null) {
            dVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1131d;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1131d;
        if (dVar != null) {
            dVar.a(mode);
        }
    }
}
