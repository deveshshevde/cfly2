package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.cfly.uav_pro.R;
import lg.b;

public class h extends b implements AdapterView.OnItemSelectedListener {

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Spinner f25844c;

        /* renamed from: d  reason: collision with root package name */
        private b f25845d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayAdapter<String> f25846e;

        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
            this.f25845d = bVar;
        }

        private void b(ViewGroup viewGroup, b bVar) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(viewGroup.getContext(), 17367048, bVar.j());
            this.f25846e = arrayAdapter;
            arrayAdapter.setDropDownViewResource(17367049);
            this.f25844c.setAdapter(this.f25846e);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            this.f25844c = (Spinner) viewGroup.findViewById(R.id.lst_select);
            b(viewGroup, bVar);
        }
    }

    public h(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(a aVar) {
        aVar.f25844c.setOnItemSelectedListener(this);
        d();
        a(this.f25836a.o());
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_select_item, (ViewGroup) null);
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
        return ListRow_Type.SELECT_ROW.ordinal();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f25836a.a(i2);
        a();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
