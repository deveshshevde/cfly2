package com.xeagle.android.widgets.spinnerWheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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

public class CardWheelHorizontalView extends LinearLayout implements b, c, d {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f26057a;

    /* renamed from: b  reason: collision with root package name */
    private View f26058b;

    /* renamed from: c  reason: collision with root package name */
    private View f26059c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26060d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f26061e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WheelHorizontalView f26062f;

    public interface a {
        void a(CardWheelHorizontalView cardWheelHorizontalView, int i2, int i3);
    }

    public CardWheelHorizontalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardWheelHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardWheelHorizontalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26057a = new LinkedList();
        a(context, attributeSet);
    }

    private int a(int i2) {
        return this.f26062f.getViewAdapter().c(i2);
    }

    private void a() {
        if (this.f26060d != null && this.f26058b != null && this.f26059c != null) {
            int childCount = getChildCount();
            if (this.f26060d.length() > 0) {
                View view = getOrientation() == 1 ? this.f26058b : this.f26059c;
                if (childCount <= 1) {
                    addView(this.f26060d, 0);
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
        this.f26062f.a(i2, z2);
    }

    private void a(final Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CardWheelHorizontalView, 0, 0);
        try {
            LayoutInflater from = LayoutInflater.from(context);
            this.f26058b = from.inflate(com.cfly.uav_pro.R.layout.card_title_vertical_divider, this, false);
            this.f26059c = from.inflate(com.cfly.uav_pro.R.layout.card_title_horizontal_divider, this, false);
            TextView textView = (TextView) from.inflate(com.cfly.uav_pro.R.layout.card_wheel_horizontal_view_title, this, false);
            this.f26060d = textView;
            textView.setText(obtainStyledAttributes.getString(1));
            this.f26060d.setVisibility(8);
            this.f26059c.setVisibility(8);
            if (obtainStyledAttributes.getInt(0, 1) == 0) {
                setOrientation(0);
            } else {
                setOrientation(1);
            }
            a();
            View inflate = from.inflate(com.cfly.uav_pro.R.layout.card_wheel_horizontal_view, this, false);
            addView(inflate);
            WheelHorizontalView wheelHorizontalView = (WheelHorizontalView) inflate.findViewById(com.cfly.uav_pro.R.id.horizontalSpinnerWheel);
            this.f26062f = wheelHorizontalView;
            wheelHorizontalView.a((b) this);
            this.f26062f.a((c) this);
            this.f26062f.a((d) this);
            EditText editText = (EditText) inflate.findViewById(com.cfly.uav_pro.R.id.numberInputText);
            this.f26061e = editText;
            editText.setVisibility(8);
            this.f26061e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z2) {
                    CardWheelHorizontalView cardWheelHorizontalView = CardWheelHorizontalView.this;
                    if (z2) {
                        cardWheelHorizontalView.f26061e.selectAll();
                    } else {
                        cardWheelHorizontalView.b();
                    }
                }
            });
            this.f26061e.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    if (i2 != 6 && i2 != 0) {
                        return false;
                    }
                    CardWheelHorizontalView.this.b();
                    CharSequence text = textView.getText();
                    if (text != null) {
                        int d2 = CardWheelHorizontalView.this.f26062f.getViewAdapter().d(Integer.parseInt(text.toString()));
                        if (d2 == -1) {
                            Toast.makeText(context, "Entered value is outside of the allowed range.", 1).show();
                        } else {
                            CardWheelHorizontalView.this.a(d2, true);
                        }
                    }
                    return true;
                }
            });
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(String str) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            this.f26061e.setText(str);
            this.f26061e.setVisibility(0);
            this.f26061e.requestFocus();
            inputMethodManager.showSoftInput(this.f26061e, 0);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive(this.f26061e)) {
            inputMethodManager.hideSoftInputFromWindow(this.f26061e.getWindowToken(), 0);
            this.f26061e.setVisibility(4);
        }
    }

    public void a(AbstractWheel abstractWheel) {
        b();
    }

    public void a(AbstractWheel abstractWheel, int i2, int i3) {
        int a2 = a(i2);
        int a3 = a(i3);
        for (a a4 : this.f26057a) {
            a4.a(this, a2, a3);
        }
    }

    public void a(AbstractWheel abstractWheel, int i2, boolean z2) {
        if (z2) {
            a(String.valueOf(this.f26062f.getViewAdapter().c(i2)));
            return;
        }
        b();
        a(i2, true);
    }

    public void a(a aVar) {
        this.f26057a.add(aVar);
    }

    public void b(AbstractWheel abstractWheel) {
    }

    public void b(a aVar) {
        this.f26057a.remove(aVar);
    }

    public int getCurrentValue() {
        return this.f26062f.getViewAdapter().c(this.f26062f.getCurrentItem());
    }

    public CharSequence getText() {
        return this.f26060d.getText();
    }

    public void setCurrentValue(int i2) {
        WheelHorizontalView wheelHorizontalView = this.f26062f;
        wheelHorizontalView.setCurrentItem(wheelHorizontalView.getViewAdapter().d(i2));
    }

    public void setOrientation(int i2) {
        super.setOrientation(i2);
        a();
    }

    public void setText(int i2) {
        this.f26060d.setText(i2);
        a();
    }

    public void setText(CharSequence charSequence) {
        this.f26060d.setText(charSequence);
        a();
    }

    public void setViewAdapter(c cVar) {
        this.f26062f.setViewAdapter(cVar);
    }
}
