package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import lg.b;

public class c extends b {

    private static class a extends a {
        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }
    }

    public c(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void e() {
        d();
        a(this.f25836a.o());
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_check_item, (ViewGroup) null);
            this.f25839d = new a(viewGroup2, this.f25836a);
            viewGroup2.setTag(this.f25839d);
            viewGroup = viewGroup2;
        } else {
            this.f25839d = (a) view.getTag();
            viewGroup = view;
        }
        e();
        return viewGroup;
    }

    public int c() {
        return ListRow_Type.CHECKBOX_ROW.ordinal();
    }
}
