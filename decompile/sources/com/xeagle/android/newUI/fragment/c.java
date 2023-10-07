package com.xeagle.android.newUI.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.cfly.uav_pro.R;
import com.flypro.core.util.e;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.xeagle.android.activities.OpenVideoActivity;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.beans.b;
import ja.j;
import java.util.ArrayList;
import jb.d;
import kk.i;
import ok.h;

public class c extends Fragment implements a.c {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<b> f23999a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f24000b;

    /* renamed from: c  reason: collision with root package name */
    private j f24001c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i f24002d;

    /* renamed from: e  reason: collision with root package name */
    private e f24003e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24004f;

    /* renamed from: g  reason: collision with root package name */
    private HostManagerActivity f24005g;

    private void a(View view) {
        e eVar = new e(this.f24005g.getApplicationContext());
        this.f24003e = eVar;
        this.f24004f = eVar.a(this.f24005g.getApplicationContext());
        this.f23999a = new ArrayList<>();
        this.f24000b = (RecyclerView) view.findViewById(R.id.recyclerview);
        i iVar = new i(R.layout.newui_video_item_layout, new ArrayList());
        this.f24002d = iVar;
        this.f24000b.setAdapter(iVar);
        this.f24000b.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f24002d.setOnItemClickListener(this);
        j jVar = (j) view.findViewById(R.id.refreshLayout);
        this.f24001c = jVar;
        jVar.a((d) new d() {
            public final void onRefresh(j jVar) {
                c.this.a(jVar);
            }
        });
        this.f24001c.a((jb.b) new jb.b() {
            public void onLoadMore(j jVar) {
                c.this.a(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(j jVar) {
        a(true);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.f24004f) {
            new le.d(UserGlobal.DOWNLOAD_MANUAL_BASE_URL, new le.b() {
                public void onFail(String str) {
                }

                public void onFinishDownload() {
                }

                public void onProgress(int i2) {
                }

                public void onStartDownload() {
                }
            }).a(com.xeagle.android.utils.c.b(this.f24005g.getApplicationContext()) ? UserGlobal.DOWNLOAD_VIDEO_CN : UserGlobal.DOWNLOAD_VIDEO_EN, (h<ArrayList<b>>) new h<ArrayList<b>>() {
                /* renamed from: a */
                public void onNext(ArrayList<b> arrayList) {
                    if (arrayList != null && arrayList.size() > 0) {
                        c.this.f23999a.addAll(arrayList);
                    }
                    c.this.f24002d.replaceData(arrayList);
                }

                public void onCompleted() {
                }

                public void onError(Throwable th) {
                }
            });
        }
        if (z2) {
            this.f24002d.replaceData(this.f23999a);
            this.f24001c.b(GSYVideoView.CHANGE_DELAY_TIME);
            return;
        }
        this.f24002d.replaceData(this.f23999a);
        this.f24001c.c(GSYVideoView.CHANGE_DELAY_TIME);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f24005g = (HostManagerActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.newui_fragment_video, (ViewGroup) null);
        a(inflate);
        a(true);
        return inflate;
    }

    public void onItemClick(a aVar, View view, int i2) {
        String b2 = ((b) this.f24002d.getData().get(i2)).b();
        Intent intent = new Intent(this.f24005g, OpenVideoActivity.class);
        intent.putExtra("open_video", b2);
        Log.i("newUI", "onItemClick: ---url--" + b2);
        intent.putExtra("video_info", ((b) this.f24002d.getData().get(i2)).a());
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        this.f24004f = this.f24003e.a(this.f24005g.getApplicationContext());
    }
}
