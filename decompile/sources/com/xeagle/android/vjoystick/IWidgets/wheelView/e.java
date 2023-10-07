package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView;

class e extends RecyclerView.Adapter<f> {

    /* renamed from: a  reason: collision with root package name */
    final int f24769a;

    /* renamed from: b  reason: collision with root package name */
    final int f24770b;

    /* renamed from: c  reason: collision with root package name */
    final int f24771c;

    /* renamed from: d  reason: collision with root package name */
    WheelView.c f24772d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24773e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f24774f;

    e(LinearLayoutManager linearLayoutManager, int i2, int i3, int i4) {
        this.f24774f = linearLayoutManager;
        this.f24769a = i2;
        this.f24770b = i3;
        this.f24771c = i4;
        this.f24773e = i4 * 2;
    }

    /* renamed from: a */
    public f onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(d.a(this.f24769a, this.f24770b));
        return new f(view);
    }

    /* access modifiers changed from: package-private */
    public String a(int i2) {
        WheelView.c cVar = this.f24772d;
        return cVar == null ? "" : cVar.a(i2);
    }

    /* renamed from: a */
    public void onBindViewHolder(f fVar, final int i2) {
        fVar.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f24774f.b(i2 - e.this.f24771c, 0);
            }
        });
    }

    public int getItemCount() {
        int i2 = this.f24773e;
        WheelView.c cVar = this.f24772d;
        return i2 + (cVar == null ? 0 : cVar.a());
    }
}
