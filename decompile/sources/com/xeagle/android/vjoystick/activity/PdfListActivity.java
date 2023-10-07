package com.xeagle.android.vjoystick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.flypro.core.database.PdfInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.xeagle.android.activities.MainViewActivity;
import com.xeagle.android.vjoystick.beans.PdfBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import la.d;
import lk.b;
import ok.h;

public class PdfListActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f24969a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f24970b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PdfInfo> f24971c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<PdfInfo> f24972d;

    /* renamed from: e  reason: collision with root package name */
    private e f24973e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24974f;

    /* renamed from: g  reason: collision with root package name */
    private d.a f24975g = new d.a() {
        public void setOnItemClick(int i2) {
            if (!new File(kx.d.m(PdfListActivity.this.getApplicationContext()) + ((PdfInfo) PdfListActivity.this.f24971c.get(i2)).getName() + ".pdf").exists()) {
                PdfListActivity pdfListActivity = PdfListActivity.this;
                Toast.makeText(pdfListActivity, pdfListActivity.getString(R.string.check_wifi_download), 0).show();
                return;
            }
            Intent intent = new Intent(PdfListActivity.this, PdfViewActivity.class);
            intent.putExtra("pdf_name", ((PdfInfo) PdfListActivity.this.f24971c.get(i2)).getName());
            PdfListActivity.this.startActivity(intent);
        }
    };

    private void a() {
        if (this.f24974f) {
            new le.d("http://120.79.204.191/").b("http://120.79.204.191/upload/genii_pdf_info.json", new h<PdfBean>() {
                /* renamed from: a */
                public void onNext(PdfBean pdfBean) {
                    if (pdfBean != null && pdfBean.getPdfList().size() > 0) {
                        PdfListActivity.this.f24972d.addAll(pdfBean.getPdfList());
                        if (PdfListActivity.this.f24971c.size() == 0) {
                            Iterator it2 = PdfListActivity.this.f24972d.iterator();
                            while (it2.hasNext()) {
                                PdfInfo pdfInfo = (PdfInfo) it2.next();
                                if (UserLiteHelper.saveData(pdfInfo)) {
                                    Log.i("LiteHelper", "onFinish:--->>>> save success  first :" + pdfInfo.getFlag());
                                }
                            }
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < PdfListActivity.this.f24971c.size(); i2++) {
                                for (int i3 = 0; i3 < PdfListActivity.this.f24972d.size(); i3++) {
                                    if (((PdfInfo) PdfListActivity.this.f24971c.get(i2)).getFlag().equals(((PdfInfo) PdfListActivity.this.f24972d.get(i3)).getFlag())) {
                                        if (((PdfInfo) PdfListActivity.this.f24971c.get(i2)).getVersion().equals(((PdfInfo) PdfListActivity.this.f24972d.get(i3)).getVersion())) {
                                            break;
                                        } else if (i3 == PdfListActivity.this.f24972d.size() - 1) {
                                            ((PdfInfo) PdfListActivity.this.f24971c.get(i2)).setUpdate(false);
                                            UserLiteHelper.updateIsUpdate(i2, false);
                                        }
                                    } else if (i3 == PdfListActivity.this.f24972d.size() - 1) {
                                        arrayList.add((PdfInfo) PdfListActivity.this.f24971c.get(i2));
                                    }
                                }
                            }
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                PdfInfo pdfInfo2 = (PdfInfo) it3.next();
                                File file = new File(kx.d.m(PdfListActivity.this.getApplicationContext()) + pdfInfo2.getName() + ".pdf");
                                if (file.exists()) {
                                    file.delete();
                                }
                                File file2 = new File(kx.d.m(PdfListActivity.this.getApplicationContext()) + pdfInfo2.getName() + ".png");
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                UserLiteHelper.deleteDataByFlag(pdfInfo2.getFlag());
                            }
                            PdfListActivity.this.f24971c.removeAll(arrayList);
                            if (PdfListActivity.this.f24971c.size() == 0) {
                                Iterator it4 = PdfListActivity.this.f24972d.iterator();
                                while (it4.hasNext()) {
                                    PdfInfo pdfInfo3 = (PdfInfo) it4.next();
                                    if (UserLiteHelper.saveData(pdfInfo3)) {
                                        Log.i("LiteHelper", "onFinish:--->>>> save success:" + pdfInfo3.getFlag());
                                    }
                                }
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int i4 = 0;
                                while (i4 < PdfListActivity.this.f24972d.size()) {
                                    int i5 = 0;
                                    while (i5 < PdfListActivity.this.f24971c.size() && !((PdfInfo) PdfListActivity.this.f24972d.get(i4)).getFlag().equals(((PdfInfo) PdfListActivity.this.f24971c.get(i5)).getFlag())) {
                                        if (i5 == PdfListActivity.this.f24971c.size() - 1) {
                                            arrayList2.add((PdfInfo) PdfListActivity.this.f24972d.get(i4));
                                        }
                                        i5++;
                                    }
                                    i4++;
                                }
                                Iterator it5 = arrayList2.iterator();
                                while (it5.hasNext()) {
                                    PdfInfo pdfInfo4 = (PdfInfo) it5.next();
                                    PdfListActivity.this.f24971c.add(pdfInfo4);
                                    if (UserLiteHelper.saveData(pdfInfo4)) {
                                        Log.i("LiteHelper", "onFinish:add new data success: -->>" + pdfInfo4.getFlag());
                                    }
                                }
                                PdfListActivity.this.f24970b.notifyDataSetChanged();
                            }
                        }
                        PdfListActivity.this.f24971c.addAll(UserLiteHelper.readDatabase(PdfListActivity.this.getApplicationContext()));
                        PdfListActivity.this.f24970b.notifyDataSetChanged();
                    }
                }

                public void onCompleted() {
                }

                public void onError(Throwable th) {
                }
            });
            return;
        }
        ArrayList<PdfInfo> arrayList = this.f24971c;
        if (arrayList != null && arrayList.size() == 0) {
            this.f24971c.addAll(UserLiteHelper.readDatabase(getApplicationContext()));
            this.f24970b.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.pdf_view_layout);
        this.f24973e = new e(getApplicationContext());
        this.f24969a = (RecyclerView) findViewById(R.id.pdf_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.b(1);
        RecyclerView recyclerView = this.f24969a;
        recyclerView.setItemAnimator(new b(recyclerView));
        this.f24969a.setLayoutManager(linearLayoutManager);
        this.f24969a.setHasFixedSize(true);
        this.f24972d = new ArrayList<>();
        this.f24971c = new ArrayList<>();
        findViewById(R.id.pdf_bt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PdfListActivity.this.startActivity(new Intent(PdfListActivity.this, MainViewActivity.class));
                PdfListActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f24971c = UserLiteHelper.readDatabase(getApplicationContext());
        boolean a2 = this.f24973e.a(getApplicationContext());
        this.f24974f = a2;
        d dVar = new d(this, this.f24971c, a2);
        this.f24970b = dVar;
        this.f24969a.setAdapter(dVar);
        this.f24970b.a(this.f24975g);
        this.f24970b.notifyDataSetChanged();
        a();
    }
}
