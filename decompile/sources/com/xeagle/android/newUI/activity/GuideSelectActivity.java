package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.bean.GuideSelectBean;
import com.xeagle.android.login.HostManagerActivity;
import java.util.ArrayList;
import kk.d;

public class GuideSelectActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f23874a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<GuideSelectBean> f23875b;

    /* renamed from: c  reason: collision with root package name */
    private d f23876c;

    private void a() {
        ArrayList<GuideSelectBean> arrayList = new ArrayList<>();
        this.f23875b = arrayList;
        arrayList.add(new GuideSelectBean("Faith 2S", R.drawable.guide_808_head));
        this.f23875b.add(new GuideSelectBean("Arno SE", R.drawable.guide_809d_head));
        this.f23875b.add(new GuideSelectBean("Faith 2", R.drawable.guide_808));
        this.f23874a = (RecyclerView) findViewById(R.id.select_guide_list);
        d dVar = new d(R.layout.guide_select_item, this.f23875b);
        this.f23876c = dVar;
        this.f23874a.setAdapter(dVar);
        this.f23874a.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.f23876c.setOnItemClickListener(new a.c() {
            public void onItemClick(a aVar, View view, int i2) {
                Intent intent = new Intent(GuideSelectActivity.this, GuideActivity.class);
                intent.putExtra("position", i2);
                GuideSelectActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GuideSelectActivity.this.b(view);
            }
        });
        findViewById(R.id.tv_guide_flying).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GuideSelectActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
        startActivity(new Intent(this, FlightActionActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        startActivity(new Intent(this, HostManagerActivity.class));
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_guide_select);
        a();
    }
}
