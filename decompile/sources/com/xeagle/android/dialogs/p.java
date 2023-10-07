package com.xeagle.android.dialogs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.cfly.uav_pro.R;
import java.util.ArrayList;
import java.util.List;

public class p extends a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f22707b;

    /* renamed from: c  reason: collision with root package name */
    private c f22708c;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final p f22710a = new p();
    }

    public interface b {
        void a();

        void a(int i2);

        void a(p pVar);
    }

    private static class c extends ci.a<String, ci.b> {
        public c(int i2, List<String> list) {
            super(i2, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(ci.b bVar, String str) {
            String str2 = TAG;
            Log.i(str2, "convert: ====" + str);
            bVar.a((int) R.id.tv_name, (CharSequence) str);
            bVar.a((int) R.id.tv_name);
        }
    }

    private p() {
    }

    public static p a() {
        return a.f22710a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b bVar = this.f22707b;
        if (bVar != null) {
            bVar.a();
        }
        dismiss();
    }

    public p a(b bVar) {
        this.f22707b = bVar;
        return this;
    }

    public void a(List<String> list) {
        c cVar = this.f22708c;
        if (cVar != null) {
            cVar.addData(list);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.listener_list_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listener_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity().getApplicationContext(), 1, false));
        c cVar = new c(R.layout.list_device_name, new ArrayList());
        this.f22708c = cVar;
        recyclerView.setAdapter(cVar);
        this.f22708c.setOnItemChildClickListener(new a.C0069a() {
            public void a(ci.a aVar, View view, int i2) {
                if (p.this.f22707b != null) {
                    p.this.f22707b.a(i2);
                }
                p.this.dismiss();
            }
        });
        view.findViewById(R.id.ib_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                p.this.a(view);
            }
        });
        b bVar = this.f22707b;
        if (bVar != null) {
            bVar.a(this);
        }
    }
}
