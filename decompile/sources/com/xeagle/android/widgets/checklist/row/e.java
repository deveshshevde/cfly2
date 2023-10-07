package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import lg.b;

public class e extends b {

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f25840c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f25841d;

        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            this.f25840c = (ProgressBar) viewGroup.findViewById(R.id.lst_level);
            this.f25841d = (TextView) viewGroup.findViewById(R.id.lst_unit);
            this.f25840c.setMax((int) bVar.h());
        }
    }

    public e(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(View view, a aVar, b bVar) {
        double f2 = (double) bVar.f();
        double g2 = (double) bVar.g();
        double m2 = bVar.m();
        String l2 = bVar.l();
        d();
        boolean z2 = true;
        boolean z3 = m2 <= f2;
        int i2 = m2 <= f2 ? R.drawable.pstate_poor : (m2 <= f2 || m2 > g2) ? R.drawable.pstate_good : R.drawable.pstate_warning;
        aVar.f25840c.setMax((int) bVar.h());
        aVar.f25840c.setProgressDrawable(view.getResources().getDrawable(i2));
        aVar.f25840c.setProgress((int) m2);
        try {
            aVar.f25841d.setText(String.format(l2, new Object[]{Double.valueOf(m2)}));
        } catch (Exception e2) {
            aVar.f25841d.setText("Error");
            e2.printStackTrace();
        }
        if (!this.f25836a.e() || z3) {
            z2 = false;
        }
        a(z2);
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_level_item, (ViewGroup) null);
            this.f25839d = new a(viewGroup2, this.f25836a);
            viewGroup2.setTag(this.f25839d);
            viewGroup = viewGroup2;
        } else {
            this.f25839d = (a) view.getTag();
            viewGroup = view;
        }
        a(viewGroup, (a) this.f25839d, this.f25836a);
        return viewGroup;
    }

    public int c() {
        return ListRow_Type.LEVEL_ROW.ordinal();
    }
}
