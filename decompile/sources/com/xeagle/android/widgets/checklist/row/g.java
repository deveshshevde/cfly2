package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.cfly.uav_pro.R;
import java.util.List;
import lg.b;

public class g extends b implements RadioGroup.OnCheckedChangeListener {

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public RadioGroup f25843c;

        public a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            RadioGroup radioGroup = (RadioGroup) viewGroup.findViewById(R.id.lst_radioGroup);
            this.f25843c = radioGroup;
            radioGroup.removeAllViews();
            List<String> j2 = bVar.j();
            for (String next : j2) {
                RadioButton radioButton = new RadioButton(viewGroup.getContext());
                radioButton.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                radioButton.setText(next);
                radioButton.setId(j2.indexOf(next));
                this.f25843c.addView(radioButton);
            }
            this.f25843c.check(bVar.i());
        }
    }

    public g(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(a aVar) {
        aVar.f25843c.setOnCheckedChangeListener(this);
        d();
        a(this.f25836a.o());
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_radio_item, (ViewGroup) null);
            this.f25839d = new a(viewGroup2, this.f25836a);
            viewGroup2.setTag(this.f25839d);
            viewGroup = viewGroup2;
        } else {
            this.f25839d = (a) view.getTag();
            viewGroup = view;
        }
        a((a) this.f25839d);
        return viewGroup;
    }

    public int c() {
        return ListRow_Type.RADIO_ROW.ordinal();
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        this.f25836a.a(i2);
        a();
    }
}
