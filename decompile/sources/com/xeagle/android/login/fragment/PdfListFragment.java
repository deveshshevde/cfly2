package com.xeagle.android.login.fragment;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.flypro.core.database.PdfInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.c;
import com.xeagle.android.vjoystick.activity.PdfViewActivity;
import com.xeagle.android.vjoystick.beans.PdfBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import la.d;
import le.b;
import ok.h;

public class PdfListFragment extends LazyLoadFragment {
    /* access modifiers changed from: private */
    public d adapter;
    private e function;
    private boolean isOnline;
    private d.a itemClickListener = new d.a() {
        public void setOnItemClick(int i2) {
            if (!new File(kx.d.m(PdfListFragment.this.getActivity().getApplicationContext()) + ((PdfInfo) PdfListFragment.this.models.get(i2)).getName() + ".pdf").exists()) {
                Toast.makeText(PdfListFragment.this.getActivity(), PdfListFragment.this.getActivity().getString(R.string.check_wifi_download), 0).show();
                return;
            }
            Intent intent = new Intent(PdfListFragment.this.getActivity(), PdfViewActivity.class);
            intent.putExtra("pdf_name", ((PdfInfo) PdfListFragment.this.models.get(i2)).getName());
            PdfListFragment.this.startActivity(intent);
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<PdfInfo> jsonDatas;
    private RecyclerView listView;
    /* access modifiers changed from: private */
    public ArrayList<PdfInfo> models;

    private void gainData() {
        if (this.isOnline) {
            new le.d(UserGlobal.DOWNLOAD_MANUAL_BASE_URL, new b() {
                public void onFail(String str) {
                }

                public void onFinishDownload() {
                }

                public void onFinishDownload(ArrayList<Object> arrayList) {
                }

                public void onProgress(int i2) {
                }

                public void onStartDownload() {
                }
            }).b(c.b(getActivity().getApplicationContext()) ? UserGlobal.DOWNLOAD_MANUAL_CN : UserGlobal.DOWNLOAD_MANUAL_EN, new h<PdfBean>() {
                public void onCompleted() {
                    if (PdfListFragment.this.adapter != null) {
                        PdfListFragment.this.adapter.notifyDataSetChanged();
                    }
                }

                public void onError(Throwable th) {
                }

                public void onNext(PdfBean pdfBean) {
                    if (pdfBean != null && pdfBean.getPdfList().size() > 0) {
                        PdfListFragment.this.jsonDatas.addAll(pdfBean.getPdfList());
                        if (PdfListFragment.this.models.size() == 0) {
                            Log.i("Listener", "onNext:---model add ");
                            Iterator it2 = PdfListFragment.this.jsonDatas.iterator();
                            while (it2.hasNext()) {
                                PdfInfo pdfInfo = (PdfInfo) it2.next();
                                if (UserLiteHelper.saveData(pdfInfo)) {
                                    Log.i("Listener", "onFinish:--->>>> save success  first :" + pdfInfo.getFlag());
                                }
                            }
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < PdfListFragment.this.models.size(); i2++) {
                                for (int i3 = 0; i3 < PdfListFragment.this.jsonDatas.size(); i3++) {
                                    if (((PdfInfo) PdfListFragment.this.models.get(i2)).getFlag().equals(((PdfInfo) PdfListFragment.this.jsonDatas.get(i3)).getFlag())) {
                                        if (((PdfInfo) PdfListFragment.this.models.get(i2)).getVersion().equals(((PdfInfo) PdfListFragment.this.jsonDatas.get(i3)).getVersion())) {
                                            break;
                                        } else if (i3 == PdfListFragment.this.jsonDatas.size() - 1) {
                                            ((PdfInfo) PdfListFragment.this.models.get(i2)).setUpdate(false);
                                            UserLiteHelper.updateIsUpdate(i2, false);
                                        }
                                    } else if (i3 == PdfListFragment.this.jsonDatas.size() - 1) {
                                        arrayList.add((PdfInfo) PdfListFragment.this.models.get(i2));
                                    }
                                }
                            }
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                PdfInfo pdfInfo2 = (PdfInfo) it3.next();
                                File file = new File(kx.d.m(PdfListFragment.this.getActivity().getApplicationContext()) + pdfInfo2.getName() + ".pdf");
                                if (file.exists()) {
                                    file.delete();
                                }
                                File file2 = new File(kx.d.m(PdfListFragment.this.getActivity().getApplicationContext()) + pdfInfo2.getName() + ".png");
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                UserLiteHelper.deleteDataByFlag(pdfInfo2.getFlag());
                            }
                            PdfListFragment.this.models.removeAll(arrayList);
                            if (PdfListFragment.this.models.size() == 0) {
                                Iterator it4 = PdfListFragment.this.jsonDatas.iterator();
                                while (it4.hasNext()) {
                                    PdfInfo pdfInfo3 = (PdfInfo) it4.next();
                                    if (UserLiteHelper.saveData(pdfInfo3)) {
                                        Log.i("Listener", "onFinish:--->>>> save success:" + pdfInfo3.getFlag());
                                    }
                                }
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int i4 = 0;
                                while (i4 < PdfListFragment.this.jsonDatas.size()) {
                                    int i5 = 0;
                                    while (i5 < PdfListFragment.this.models.size() && !((PdfInfo) PdfListFragment.this.jsonDatas.get(i4)).getFlag().equals(((PdfInfo) PdfListFragment.this.models.get(i5)).getFlag())) {
                                        if (i5 == PdfListFragment.this.models.size() - 1) {
                                            arrayList2.add((PdfInfo) PdfListFragment.this.jsonDatas.get(i4));
                                        }
                                        i5++;
                                    }
                                    i4++;
                                }
                                Iterator it5 = arrayList2.iterator();
                                while (it5.hasNext()) {
                                    PdfInfo pdfInfo4 = (PdfInfo) it5.next();
                                    PdfListFragment.this.models.add(pdfInfo4);
                                    if (UserLiteHelper.saveData(pdfInfo4)) {
                                        Log.i("Listener", "onFinish:add new data success: -->>" + pdfInfo4.getFlag());
                                    }
                                }
                                PdfListFragment.this.adapter.notifyDataSetChanged();
                            }
                        }
                        PdfListFragment.this.models.addAll(UserLiteHelper.readDatabase(PdfListFragment.this.getActivity().getApplicationContext()));
                        PdfListFragment.this.adapter.notifyDataSetChanged();
                    }
                }
            });
            return;
        }
        Log.i("Listener", "gainData: ---model null");
        ArrayList<PdfInfo> arrayList = this.models;
        if (arrayList != null && arrayList.size() == 0) {
            this.models.addAll(UserLiteHelper.readDatabase(getActivity().getApplicationContext()));
            this.adapter.notifyDataSetChanged();
        }
    }

    private void initView() {
        this.function = new e(getActivity().getApplicationContext());
        this.listView = (RecyclerView) findViewById(R.id.pdf_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.b(1);
        RecyclerView recyclerView = this.listView;
        recyclerView.setItemAnimator(new lk.b(recyclerView));
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setHasFixedSize(true);
        findViewById(R.id.title_layout).setVisibility(8);
        this.jsonDatas = new ArrayList<>();
        this.models = new ArrayList<>();
        this.models = UserLiteHelper.readDatabase(getActivity());
        this.isOnline = this.function.a(getActivity().getApplicationContext());
        d dVar = new d(getActivity(), this.models, this.isOnline);
        this.adapter = dVar;
        this.listView.setAdapter(dVar);
        this.adapter.a(this.itemClickListener);
        gainData();
    }

    /* access modifiers changed from: protected */
    public void lazyLoad() {
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public int setContentView() {
        return R.layout.pdf_view_layout;
    }
}
