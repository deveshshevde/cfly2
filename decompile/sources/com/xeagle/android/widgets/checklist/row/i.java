package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.cfly.uav_pro.R;
import lg.b;

public class i extends b implements CompoundButton.OnCheckedChangeListener {

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Switch f25847c;

        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            this.f25847c = (Switch) viewGroup.findViewById(R.id.lst_switch);
        }
    }

    public i(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(a aVar, b bVar) {
        d();
        boolean z2 = true;
        boolean z3 = !this.f25836a.n();
        aVar.f25847c.setOnCheckedChangeListener(this);
        aVar.f25847c.setClickable(this.f25836a.d());
        aVar.f25847c.setChecked(bVar.n());
        aVar.f25847c.getResources().getDrawable(R.drawable.f14091bg);
        if (!this.f25836a.e() || z3) {
            z2 = false;
        }
        a(z2);
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_switch_item, (ViewGroup) null);
            this.f25839d = new a(viewGroup2, this.f25836a);
            viewGroup2.setTag(this.f25839d);
            viewGroup = viewGroup2;
        } else {
            this.f25839d = (a) view.getTag();
            viewGroup = view;
        }
        a((a) this.f25839d, this.f25836a);
        return viewGroup;
    }

    public int c() {
        return ListRow_Type.SWITCH_ROW.ordinal();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        this.f25836a.a(z2);
        a();
    }
}
