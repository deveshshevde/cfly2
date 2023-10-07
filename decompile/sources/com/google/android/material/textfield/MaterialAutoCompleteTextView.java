package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.d;
import com.google.android.material.internal.l;
import gx.a;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ListPopupWindow f19727a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityManager f19728b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f19729c;

    public MaterialAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, 0), attributeSet, i2);
        this.f19729c = new Rect();
        Context context2 = getContext();
        TypedArray a2 = l.a(context2, attributeSet, R.styleable.MaterialAutoCompleteTextView, i2, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (a2.hasValue(R.styleable.MaterialAutoCompleteTextView_android_inputType) && a2.getInt(R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.f19728b = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f19727a = listPopupWindow;
        listPopupWindow.a(true);
        listPopupWindow.b((View) this);
        listPopupWindow.i(2);
        listPopupWindow.a(getAdapter());
        listPopupWindow.a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                MaterialAutoCompleteTextView.this.a(i2 < 0 ? materialAutoCompleteTextView.f19727a.o() : materialAutoCompleteTextView.getAdapter().getItem(i2));
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i2 < 0) {
                        view = MaterialAutoCompleteTextView.this.f19727a.r();
                        i2 = MaterialAutoCompleteTextView.this.f19727a.p();
                        j2 = MaterialAutoCompleteTextView.this.f19727a.q();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f19727a.g(), view, i2, j2);
                }
                MaterialAutoCompleteTextView.this.f19727a.d();
            }
        });
        a2.recycle();
    }

    private int a() {
        ListAdapter adapter = getAdapter();
        TextInputLayout b2 = b();
        int i2 = 0;
        if (adapter == null || b2 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f19727a.p()) + 15);
        View view = null;
        int i3 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(max, view, b2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        Drawable b3 = this.f19727a.b();
        if (b3 != null) {
            b3.getPadding(this.f19729c);
            i3 += this.f19729c.left + this.f19729c.right;
        }
        return i3 + b2.getEndIconView().getMeasuredWidth();
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter((ListAdapter) null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    private TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public CharSequence getHint() {
        TextInputLayout b2 = b();
        return (b2 == null || !b2.a()) ? super.getHint() : b2.getHint();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b2 = b();
        if (b2 != null && b2.a() && super.getHint() == null && d.a()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t2) {
        super.setAdapter(t2);
        this.f19727a.a(getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f19728b;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f19727a.c_();
        }
    }
}
