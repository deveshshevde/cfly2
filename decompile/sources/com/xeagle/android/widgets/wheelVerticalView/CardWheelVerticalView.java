package com.xeagle.android.widgets.wheelVerticalView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xeagle.R;
import java.util.LinkedList;
import java.util.List;
import ll.c;

public class CardWheelVerticalView extends LinearLayout implements a, b, c {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f26105a;

    /* renamed from: b  reason: collision with root package name */
    private View f26106b;

    /* renamed from: c  reason: collision with root package name */
    private View f26107c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26108d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f26109e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WheelVerticalView f26110f;

    public interface a {
        void a(CardWheelVerticalView cardWheelVerticalView, int i2, int i3);
    }

    public CardWheelVerticalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardWheelVerticalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardWheelVerticalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26105a = new LinkedList();
        a(context, attributeSet);
    }

    private int a(int i2) {
        return this.f26110f.getViewAdapter().c(i2);
    }

    private void a() {
        if (this.f26108d != null && this.f26106b != null && this.f26107c != null) {
            int childCount = getChildCount();
            if (this.f26108d.length() > 0) {
                View view = getOrientation() == 1 ? this.f26106b : this.f26107c;
                if (childCount <= 1) {
                    addView(this.f26108d, 0);
                } else if (getChildAt(1) != view) {
                    removeViewAt(1);
                } else {
                    return;
                }
                addView(view, 1);
            } else if (childCount > 1) {
                removeViewAt(0);
                removeViewAt(1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        this.f26110f.a(i2, z2);
    }

    private void a(final Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CardWheelHorizontalView, 0, 0);
        try {
            setBackgroundResource(com.cfly.uav_pro.R.drawable.bg_cell_white);
            LayoutInflater from = LayoutInflater.from(context);
            this.f26106b = from.inflate(com.cfly.uav_pro.R.layout.card_title_vertical_divider, this, false);
            this.f26107c = from.inflate(com.cfly.uav_pro.R.layout.card_title_horizontal_divider, this, false);
            TextView textView = (TextView) from.inflate(com.cfly.uav_pro.R.layout.card_wheel_horizontal_view_title, this, false);
            this.f26108d = textView;
            textView.setText(obtainStyledAttributes.getString(1));
            if (obtainStyledAttributes.getInt(0, 1) == 0) {
                setOrientation(0);
            } else {
                setOrientation(1);
            }
            a();
            View inflate = from.inflate(com.cfly.uav_pro.R.layout.card_wheel_vertical_view, this, false);
            addView(inflate);
            WheelVerticalView wheelVerticalView = (WheelVerticalView) inflate.findViewById(com.cfly.uav_pro.R.id.verticalSpinnerWheel);
            this.f26110f = wheelVerticalView;
            wheelVerticalView.setBackgroundColor(0);
            this.f26110f.a((a) this);
            this.f26110f.a((b) this);
            this.f26110f.a((c) this);
            EditText editText = (EditText) inflate.findViewById(com.cfly.uav_pro.R.id.numberInputText);
            this.f26109e = editText;
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z2) {
                    CardWheelVerticalView cardWheelVerticalView = CardWheelVerticalView.this;
                    if (z2) {
                        cardWheelVerticalView.f26109e.selectAll();
                    } else {
                        cardWheelVerticalView.b();
                    }
                }
            });
            this.f26109e.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    if (i2 != 6 && i2 != 0) {
                        return false;
                    }
                    CardWheelVerticalView.this.b();
                    CharSequence text = textView.getText();
                    if (text != null) {
                        int d2 = CardWheelVerticalView.this.f26110f.getViewAdapter().d(Integer.parseInt(text.toString()));
                        if (d2 == -1) {
                            Toast.makeText(context, "Entered value is outside of the allowed range.", 1).show();
                        } else {
                            CardWheelVerticalView.this.a(d2, true);
                        }
                    }
                    return true;
                }
            });
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive(this.f26109e)) {
            inputMethodManager.hideSoftInputFromWindow(this.f26109e.getWindowToken(), 0);
            this.f26109e.setVisibility(4);
        }
    }

    public void a(a aVar) {
        this.f26105a.add(aVar);
    }

    public void a(WheelVerticalView wheelVerticalView) {
        b();
    }

    public void a(WheelVerticalView wheelVerticalView, int i2, int i3) {
        int a2 = a(i2);
        int a3 = a(i3);
        for (a a4 : this.f26105a) {
            a4.a(this, a2, a3);
        }
    }

    public void b(a aVar) {
        this.f26105a.remove(aVar);
    }

    public void b(WheelVerticalView wheelVerticalView) {
    }

    public int getCurrentValue() {
        return this.f26110f.getViewAdapter().c(this.f26110f.getCurrentItem());
    }

    public CharSequence getText() {
        return this.f26108d.getText();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setCurrentValue(int i2) {
        WheelVerticalView wheelVerticalView = this.f26110f;
        wheelVerticalView.setCurrentItem(wheelVerticalView.getViewAdapter().d(i2));
    }

    public void setOrientation(int i2) {
        super.setOrientation(i2);
        a();
    }

    public void setText(int i2) {
        this.f26108d.setText(i2);
        a();
    }

    public void setText(CharSequence charSequence) {
        this.f26108d.setText(charSequence);
        a();
    }

    public void setViewAdapter(c cVar) {
        this.f26110f.setViewAdapter(cVar);
    }
}
