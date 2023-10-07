package com.xeagle.android.widgets.checklist.row;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.xeagle.android.widgets.checklist.row.d;

public class b implements View.OnClickListener, View.OnLongClickListener, d {

    /* renamed from: a  reason: collision with root package name */
    protected final lg.b f25836a;

    /* renamed from: b  reason: collision with root package name */
    protected final LayoutInflater f25837b;

    /* renamed from: c  reason: collision with root package name */
    public d.a f25838c;

    /* renamed from: d  reason: collision with root package name */
    public a f25839d;

    public b(LayoutInflater layoutInflater, lg.b bVar) {
        this.f25836a = bVar;
        this.f25837b = layoutInflater;
    }

    public View a(View view) {
        return null;
    }

    public void a() {
        d.a aVar = this.f25838c;
        if (aVar != null) {
            aVar.a(this.f25836a);
        }
    }

    public void a(d.a aVar) {
        this.f25838c = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        this.f25839d.f25834a.setOnLongClickListener(this);
        this.f25839d.f25835b.setOnClickListener(this);
        this.f25839d.f25835b.setText(this.f25836a.a());
        this.f25839d.f25835b.setChecked(z2);
        this.f25839d.f25835b.setClickable(this.f25836a.c() == null ? this.f25836a.d() : !this.f25836a.c().contains("SYS"));
        this.f25836a.b(z2);
    }

    public lg.b b() {
        return this.f25836a;
    }

    public int c() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void d() {
        d.a aVar = this.f25838c;
        if (aVar != null) {
            lg.b bVar = this.f25836a;
            aVar.a(bVar, bVar.c());
        }
    }

    public void onClick(View view) {
        this.f25836a.b(((CheckBox) view).isChecked());
        a();
    }

    public boolean onLongClick(View view) {
        if (view.equals(this.f25839d.f25834a)) {
            Toast.makeText(view.getContext(), this.f25836a.b(), 0).show();
        }
        return false;
    }
}
