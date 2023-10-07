package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cfly.uav_pro.R;
import lg.b;

public class k extends b implements View.OnFocusChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private boolean f25849e;

    /* renamed from: f  reason: collision with root package name */
    private float f25850f;

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public EditText f25851c;

        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            EditText editText = (EditText) viewGroup.findViewById(R.id.lst_editText);
            this.f25851c = editText;
            editText.setInputType(12290);
        }
    }

    public k(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(View view, a aVar, b bVar) {
        double f2 = (double) bVar.f();
        bVar.g();
        double m2 = bVar.m();
        bVar.l();
        boolean z2 = true;
        boolean z3 = m2 <= f2;
        d();
        EditText unused = aVar.f25851c;
        if (aVar.f25851c.getText().toString() == null) {
            aVar.f25851c.setText("0.0");
        }
        aVar.f25851c.setOnFocusChangeListener(this);
        aVar.f25851c.setText(String.valueOf(this.f25836a.q()));
        if (!this.f25836a.e() || z3) {
            z2 = false;
        }
        a(z2);
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_value_item, (ViewGroup) null);
            this.f25839d = new a(viewGroup2, this.f25836a);
            viewGroup2.setTag(this.f25839d);
            this.f25850f = this.f25836a.q();
            viewGroup = viewGroup2;
        } else {
            this.f25839d = (a) view.getTag();
            viewGroup = view;
        }
        a(viewGroup, (a) this.f25839d, this.f25836a);
        return viewGroup;
    }

    public int c() {
        return ListRow_Type.VALUE_ROW.ordinal();
    }

    public void onFocusChange(View view, boolean z2) {
        if (!z2) {
            if (this.f25849e) {
                this.f25849e = false;
                float f2 = 0.0f;
                try {
                    f2 = Float.parseFloat(((EditText) view).getText().toString());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                if (f2 != this.f25850f) {
                    this.f25850f = f2;
                    this.f25836a.n(((EditText) view).getText().toString());
                }
                if (this.f25838c != null) {
                    this.f25838c.a(this.f25836a);
                }
            }
        } else if (z2) {
            this.f25849e = !this.f25849e;
        }
    }
}
