package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cfly.uav_pro.R;
import lg.b;

public class f extends b implements View.OnFocusChangeListener {

    private static class a extends a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public EditText f25842c;

        private a(ViewGroup viewGroup, b bVar) {
            super(viewGroup, bVar);
        }

        /* access modifiers changed from: protected */
        public void a(ViewGroup viewGroup, b bVar) {
            this.f25842c = (EditText) viewGroup.findViewById(R.id.lst_note);
        }
    }

    public f(LayoutInflater layoutInflater, b bVar) {
        super(layoutInflater, bVar);
    }

    private void a(a aVar) {
        aVar.f25842c.setOnFocusChangeListener(this);
        aVar.f25842c.setText(this.f25836a.p());
        a(this.f25836a.o());
    }

    public View a(View view) {
        ViewGroup viewGroup;
        if (view == null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f25837b.inflate(R.layout.list_note_item, (ViewGroup) null);
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
        return ListRow_Type.NOTE_ROW.ordinal();
    }

    public void onFocusChange(View view, boolean z2) {
        if (!view.isFocused() && this.f25838c != null) {
            this.f25836a.n(((a) this.f25839d).f25842c.getText().toString());
            a();
        }
    }
}
