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
import com.amap.api.mapcore.util.fx;
import com.blankj.utilcode.util.ToastUtils;
import com.flypro.core.database.PdfData;
import com.flypro.core.database.PdfInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.liulishuo.filedownloader.i;
import com.liulishuo.filedownloader.q;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.xeagle.R;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.widgets.RoundProgressBar;
import com.xeagle.android.vjoystick.activity.PdfViewActivity;
import com.xeagle.android.vjoystick.beans.PdfBean;
import ja.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d;
import kotlin.m;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;
import ok.h;

public final class a extends Fragment implements a.c {

    /* renamed from: a  reason: collision with root package name */
    private e f23986a;

    /* renamed from: b  reason: collision with root package name */
    private final d f23987b = kotlin.e.a(InstructionFragment$instructionAdapter$2.f23985a);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HostManagerActivity f23988c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RoundProgressBar f23989d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, RoundProgressBar> f23990e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f23991f;

    /* renamed from: com.xeagle.android.newUI.fragment.a$a  reason: collision with other inner class name */
    public static final class C0149a extends h<PdfBean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23992a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f23993b;

        C0149a(a aVar, View view) {
            this.f23992a = aVar;
            this.f23993b = view;
        }

        /* renamed from: a */
        public void onNext(PdfBean pdfBean) {
            kotlin.jvm.internal.h.d(pdfBean, "pdfInfos");
            ((SmartRefreshLayout) this.f23993b.findViewById(R.id.refreshLayout)).b();
            if (pdfBean.getPdfList().size() > 0) {
                Log.i("Listener", "onNext:---model add ");
                bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new InstructionFragment$getData$1$onNext$1(this, pdfBean, (kotlin.coroutines.c) null), 2, (Object) null);
            } else if (pdfBean.getPdfList().size() == 0) {
                this.f23992a.c();
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th) {
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            ((SmartRefreshLayout) this.f23993b.findViewById(R.id.refreshLayout)).b();
            this.f23992a.c();
        }
    }

    static final class b implements jb.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23994a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f23995b;

        b(a aVar, View view) {
            this.f23994a = aVar;
            this.f23995b = view;
        }

        public final void onRefresh(j jVar) {
            kotlin.jvm.internal.h.d(jVar, "it");
            this.f23994a.a(this.f23995b);
        }
    }

    public static final class c extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23996a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23997b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f23998c;

        c(a aVar, int i2, ArrayList arrayList) {
            this.f23996a = aVar;
            this.f23997b = i2;
            this.f23998c = arrayList;
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, int i2, int i3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(str, "etag");
            super.a(aVar, str, z2, i2, i3);
            a aVar2 = this.f23996a;
            kk.e b2 = aVar2.b();
            kotlin.jvm.internal.h.a((Object) b2);
            aVar2.f23989d = (RoundProgressBar) b2.getViewByPosition((RecyclerView) this.f23996a.a(R.id.recyclerview), this.f23997b, com.cfly.uav_pro.R.id.download_pb);
            boolean z3 = this.f23996a.f23989d != null;
            if (!m.f30255a || z3) {
                RoundProgressBar d2 = this.f23996a.f23989d;
                kotlin.jvm.internal.h.a((Object) d2);
                d2.setVisibility(0);
                RoundProgressBar d3 = this.f23996a.f23989d;
                kotlin.jvm.internal.h.a((Object) d3);
                d3.setMax(100);
                RoundProgressBar d4 = this.f23996a.f23989d;
                kotlin.jvm.internal.h.a((Object) d4);
                d4.setProgress(0);
                String valueOf = String.valueOf(this.f23997b);
                RoundProgressBar d5 = this.f23996a.f23989d;
                kotlin.jvm.internal.h.a((Object) d5);
                this.f23996a.f23990e.put(valueOf, d5);
                return;
            }
            throw new AssertionError("Assertion failed");
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            Object obj = this.f23996a.f23990e.get(String.valueOf(this.f23997b));
            kotlin.jvm.internal.h.a(obj);
            kotlin.jvm.internal.h.b(obj, "pbMap[position.toString()]!!");
            ((RoundProgressBar) obj).setVisibility(8);
            Log.i("newUI", "error:----- " + th.getMessage());
            HostManagerActivity c2 = this.f23996a.f23988c;
            kotlin.jvm.internal.h.a((Object) c2);
            ToastUtils.showShort(c2.getString(com.cfly.uav_pro.R.string.down_failed), new Object[0]);
        }

        /* access modifiers changed from: protected */
        public void b(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            Object obj = this.f23996a.f23990e.get(String.valueOf(this.f23997b));
            kotlin.jvm.internal.h.a(obj);
            kotlin.jvm.internal.h.b(obj, "pbMap[position.toString()]!!");
            ((RoundProgressBar) obj).setProgress((int) ((((float) i2) / ((float) i3)) * ((float) 100)));
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            ArrayList arrayList = this.f23998c;
            kotlin.jvm.internal.h.a((Object) arrayList);
            ((PdfInfo) arrayList.get(this.f23997b)).setUpdate(true);
            Object obj = this.f23996a.f23990e.get(String.valueOf(this.f23997b));
            kotlin.jvm.internal.h.a(obj);
            kotlin.jvm.internal.h.b(obj, "pbMap[position.toString()]!!");
            ((RoundProgressBar) obj).setVisibility(8);
            Intent intent = new Intent(this.f23996a.f23988c, PdfViewActivity.class);
            ArrayList arrayList2 = this.f23998c;
            kotlin.jvm.internal.h.a((Object) arrayList2);
            intent.putExtra("pdf_name", ((PdfInfo) arrayList2.get(this.f23997b)).getName());
            this.f23996a.startActivity(intent);
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void d(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }
    }

    /* access modifiers changed from: private */
    public final void a(View view) {
        if (kw.b.a(this.f23988c)) {
            HostManagerActivity hostManagerActivity = this.f23988c;
            kotlin.jvm.internal.h.a((Object) hostManagerActivity);
            new le.d(UserGlobal.DOWNLOAD_MANUAL_BASE_URL).b(com.xeagle.android.utils.c.b(hostManagerActivity.getApplicationContext()) ? UserGlobal.DOWNLOAD_MANUAL_CN : UserGlobal.DOWNLOAD_MANUAL_EN, new C0149a(this, view));
        } else {
            kk.e b2 = b();
            HostManagerActivity hostManagerActivity2 = this.f23988c;
            kotlin.jvm.internal.h.a((Object) hostManagerActivity2);
            b2.setNewData(UserLiteHelper.readDatabase(hostManagerActivity2.getApplicationContext()));
        }
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        kotlin.jvm.internal.h.a((Object) smartRefreshLayout);
        smartRefreshLayout.b((int) GSYVideoView.CHANGE_DELAY_TIME);
    }

    /* access modifiers changed from: private */
    public final kk.e b() {
        return (kk.e) this.f23987b.a();
    }

    private final void b(View view) {
        HostManagerActivity hostManagerActivity = this.f23988c;
        kotlin.jvm.internal.h.a((Object) hostManagerActivity);
        this.f23986a = new e(hostManagerActivity.getApplicationContext());
        ((RecyclerView) view.findViewById(R.id.recyclerview)).setLayoutManager(new LinearLayoutManager(this.f23988c, 1, false));
        ((RecyclerView) view.findViewById(R.id.recyclerview)).setAdapter(b());
        b().setOnItemClickListener(this);
        ((SmartRefreshLayout) view.findViewById(R.id.refreshLayout)).a((jb.d) new b(this, view));
        ((SmartRefreshLayout) view.findViewById(R.id.refreshLayout)).b(false);
    }

    /* access modifiers changed from: private */
    public final void c() {
        UserLiteHelper.deleteClass(PdfData.class);
    }

    public View a(int i2) {
        if (this.f23991f == null) {
            this.f23991f = new HashMap();
        }
        View view = (View) this.f23991f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23991f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f23991f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onAttach(Activity activity) {
        kotlin.jvm.internal.h.d(activity, "activity");
        super.onAttach(activity);
        this.f23988c = (HostManagerActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.cfly.uav_pro.R.layout.newui_fragment_instruction, (ViewGroup) null);
        HostManagerActivity hostManagerActivity = this.f23988c;
        kotlin.jvm.internal.h.a((Object) hostManagerActivity);
        q.a(hostManagerActivity.getApplicationContext());
        q.a().a(1);
        kotlin.jvm.internal.h.b(inflate, Promotion.ACTION_VIEW);
        b(inflate);
        a(inflate);
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onItemClick(ci.a<?, ?> aVar, View view, int i2) {
        kotlin.jvm.internal.h.d(view, Promotion.ACTION_VIEW);
        HostManagerActivity hostManagerActivity = this.f23988c;
        kotlin.jvm.internal.h.a((Object) hostManagerActivity);
        ArrayList<PdfInfo> readDatabase = UserLiteHelper.readDatabase(hostManagerActivity.getApplicationContext());
        Log.i("newUI", "onItemChildClick:---- " + i2);
        StringBuilder sb = new StringBuilder();
        HostManagerActivity hostManagerActivity2 = this.f23988c;
        kotlin.jvm.internal.h.a((Object) hostManagerActivity2);
        sb.append(kx.d.m(hostManagerActivity2.getApplicationContext()));
        kotlin.jvm.internal.h.a((Object) readDatabase);
        sb.append(readDatabase.get(i2).getName());
        sb.append(".pdf");
        String sb2 = sb.toString();
        if (new File(sb2).exists()) {
            Intent intent = new Intent(this.f23988c, PdfViewActivity.class);
            intent.putExtra("pdf_name", readDatabase.get(i2).getName());
            startActivity(intent);
        } else if (kw.b.a(this.f23988c)) {
            q.a().a(readDatabase.get(i2).getPdf_url()).a((i) new c(this, i2, readDatabase)).a(sb2).c();
        } else {
            HostManagerActivity hostManagerActivity3 = this.f23988c;
            kotlin.jvm.internal.h.a((Object) hostManagerActivity3);
            ToastUtils.showShort(hostManagerActivity3.getString(com.cfly.uav_pro.R.string.check_wifi_download), new Object[0]);
        }
    }

    public void onStop() {
        super.onStop();
        q.a().b();
        q.a().e();
    }
}
