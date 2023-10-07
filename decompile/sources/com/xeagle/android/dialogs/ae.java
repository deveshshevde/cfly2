package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.login.beans.sochipBeans.CmdListener;
import com.xeagle.android.login.beans.sochipBeans.SochipStatusBean;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.Arrays;
import java.util.List;
import jp.d;
import jp.e;
import jp.f;
import la.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class ae extends c implements View.OnClickListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f12447a = true;

    /* renamed from: o  reason: collision with root package name */
    private static List<Integer> f12448o = Arrays.asList(new Integer[]{0, 1, 2});

    /* renamed from: p  reason: collision with root package name */
    private static List<Integer> f12449p = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6});

    /* renamed from: q  reason: collision with root package name */
    private static List<Integer> f12450q = Arrays.asList(new Integer[]{0, 1, 2, 3, 4});

    /* renamed from: r  reason: collision with root package name */
    private static List<Integer> f12451r = Arrays.asList(new Integer[]{0, 1, 2});

    /* renamed from: s  reason: collision with root package name */
    private static List<Integer> f12452s = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6});

    /* renamed from: t  reason: collision with root package name */
    private static List<Integer> f12453t = Arrays.asList(new Integer[]{1, 0});
    private a A;
    private a B;
    private a C;
    private a D;
    private a E;
    private a F;
    private FlightActionActivity G;
    private SochipPresenter H;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f12454b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f12455c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f12456d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f12457e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f12458f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f12459g;

    /* renamed from: h  reason: collision with root package name */
    private IImageButton f12460h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayoutManager f12461i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayoutManager f12462j;

    /* renamed from: k  reason: collision with root package name */
    private LinearLayoutManager f12463k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayoutManager f12464l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayoutManager f12465m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayoutManager f12466n;

    /* renamed from: u  reason: collision with root package name */
    private List<String> f12467u;

    /* renamed from: v  reason: collision with root package name */
    private List<String> f12468v;

    /* renamed from: w  reason: collision with root package name */
    private List<String> f12469w;

    /* renamed from: x  reason: collision with root package name */
    private List<String> f12470x;

    /* renamed from: y  reason: collision with root package name */
    private List<String> f12471y;

    /* renamed from: z  reason: collision with root package name */
    private List<String> f12472z;

    private void a(View view) {
        this.f12454b = (RecyclerView) view.findViewById(R.id.video_resolution_wheel);
        this.f12455c = (RecyclerView) view.findViewById(R.id.ev_wheel);
        this.f12456d = (RecyclerView) view.findViewById(R.id.bw_wheel);
        this.f12457e = (RecyclerView) view.findViewById(R.id.photo_resolution_wheel);
        this.f12459g = (RecyclerView) view.findViewById(R.id.water_wheel);
        this.f12458f = (RecyclerView) view.findViewById(R.id.saturation_wheel);
        this.f12460h = (IImageButton) view.findViewById(R.id.camera_cancel_ib);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12461i = linearLayoutManager;
        linearLayoutManager.b(0);
        this.f12454b.setLayoutManager(this.f12461i);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12462j = linearLayoutManager2;
        linearLayoutManager2.b(0);
        this.f12455c.setLayoutManager(this.f12462j);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12463k = linearLayoutManager3;
        linearLayoutManager3.b(0);
        this.f12456d.setLayoutManager(this.f12463k);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12464l = linearLayoutManager4;
        linearLayoutManager4.b(0);
        this.f12457e.setLayoutManager(this.f12464l);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12466n = linearLayoutManager5;
        linearLayoutManager5.b(0);
        this.f12459g.setLayoutManager(this.f12466n);
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(this.G.getApplicationContext());
        this.f12465m = linearLayoutManager6;
        linearLayoutManager6.b(0);
        this.f12458f.setLayoutManager(this.f12465m);
        this.f12460h.setOnClickListener(this);
        this.f12467u = Arrays.asList(this.G.getResources().getStringArray(R.array.video_resolution_sochip));
        a aVar = new a(this.f12454b, this.G.getApplicationContext(), this.f12467u);
        this.A = aVar;
        this.f12454b.setAdapter(aVar);
        this.A.a(this.f12461i, 0);
        this.A.a((a.b) this);
        this.f12468v = Arrays.asList(this.G.getResources().getStringArray(R.array.ev_value_sochip));
        a aVar2 = new a(this.f12455c, this.G.getApplicationContext(), this.f12468v);
        this.B = aVar2;
        this.f12455c.setAdapter(aVar2);
        this.B.a(this.f12462j, 0);
        this.B.a((a.b) this);
        this.f12469w = Arrays.asList(this.G.getResources().getStringArray(R.array.awb_value_sochip));
        a aVar3 = new a(this.f12456d, this.G.getApplicationContext(), this.f12469w);
        this.C = aVar3;
        this.f12456d.setAdapter(aVar3);
        this.C.a(this.f12463k, 0);
        this.C.a((a.b) this);
        this.f12470x = Arrays.asList(this.G.getResources().getStringArray(R.array.photo_resolution_sochip));
        a aVar4 = new a(this.f12457e, this.G.getApplicationContext(), this.f12470x);
        this.D = aVar4;
        this.f12457e.setAdapter(aVar4);
        this.D.a(this.f12464l, 0);
        this.D.a((a.b) this);
        this.f12472z = Arrays.asList(this.G.getResources().getStringArray(R.array.water_value_sochip));
        a aVar5 = new a(this.f12459g, this.G.getApplicationContext(), this.f12472z);
        this.F = aVar5;
        this.f12459g.setAdapter(aVar5);
        this.F.a(this.f12466n, 0);
        this.F.a((a.b) this);
        this.f12471y = Arrays.asList(this.G.getResources().getStringArray(R.array.saturation_value_sochip));
        a aVar6 = new a(this.f12458f, this.G.getApplicationContext(), this.f12471y);
        this.E = aVar6;
        this.f12458f.setAdapter(aVar6);
        this.E.a(this.f12465m, 0);
        this.E.a((a.b) this);
        SochipPresenter sochipPresenter = this.H;
        if (sochipPresenter != null) {
            sochipPresenter.getCameraStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_DEVICE_INFO);
        }
    }

    public void a(RecyclerView recyclerView, int i2, String str) {
        SochipPresenter sochipPresenter;
        List<Integer> list;
        int i3;
        Log.i("Wheel", "onClick: ----v--" + recyclerView + "---pos--" + i2);
        switch (recyclerView.getId()) {
            case R.id.bw_wheel /*2131296734*/:
                a aVar = this.C;
                if (aVar != null) {
                    aVar.a(this.f12463k, i2);
                }
                sochipPresenter = this.H;
                if (sochipPresenter != null) {
                    i3 = CameraGlobal.SET_VIDEO_BALANCE;
                    list = f12450q;
                    break;
                } else {
                    return;
                }
            case R.id.ev_wheel /*2131297115*/:
                a aVar2 = this.B;
                if (aVar2 != null) {
                    aVar2.a(this.f12462j, i2);
                    sochipPresenter = this.H;
                    if (sochipPresenter != null) {
                        i3 = CameraGlobal.SET_VIDEO_EXPROTION;
                        list = f12449p;
                        break;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case R.id.photo_resolution_wheel /*2131298361*/:
                a aVar3 = this.D;
                if (aVar3 != null) {
                    aVar3.a(this.f12464l, i2);
                }
                sochipPresenter = this.H;
                if (sochipPresenter != null) {
                    i3 = CameraGlobal.SET_PHOTO_RESOLUTION;
                    list = f12451r;
                    break;
                } else {
                    return;
                }
            case R.id.saturation_wheel /*2131298669*/:
                a aVar4 = this.E;
                if (aVar4 != null) {
                    aVar4.a(this.f12465m, i2);
                }
                sochipPresenter = this.H;
                if (sochipPresenter != null) {
                    i3 = CameraGlobal.SET_SATURATION;
                    list = f12452s;
                    break;
                } else {
                    return;
                }
            case R.id.video_resolution_wheel /*2131299733*/:
                a aVar5 = this.A;
                if (aVar5 != null) {
                    aVar5.a(this.f12461i, i2);
                }
                sochipPresenter = this.H;
                if (sochipPresenter != null) {
                    i3 = 1001;
                    list = f12448o;
                    break;
                } else {
                    return;
                }
            case R.id.water_wheel /*2131299835*/:
                a aVar6 = this.F;
                if (aVar6 != null) {
                    aVar6.a(this.f12466n, i2);
                }
                sochipPresenter = this.H;
                if (sochipPresenter != null) {
                    i3 = 1022;
                    list = f12453t;
                    break;
                } else {
                    return;
                }
            default:
                return;
        }
        sochipPresenter.setCmdAndInt(CameraGlobal.BASE_URL, 1, i3, list.get(i2).intValue());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.G = (FlightActionActivity) context;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.camera_cancel_ib) {
            dismiss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.newDialog).create();
        create.requestWindowFeature(8);
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f12447a || window != null) {
            window.setGravity(5);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 9) / 16, getActivity().getWindowManager().getDefaultDisplay().getHeight());
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sochip_camera_layout, viewGroup, false);
        if (((XEagleApp) this.G.getApplicationContext()).m().a() == 2) {
            this.H = ((XEagleApp) this.G.getApplicationContext()).h();
        }
        a(inflate);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        });
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void socErrorEvent(d dVar) {
        Log.i("rtsp", "regError:---type--- " + dVar.a() + "---error---" + dVar.b());
    }

    @l(a = ThreadMode.MAIN)
    public void socFailureEvent(e eVar) {
    }

    @l(a = ThreadMode.MAIN)
    public void socSuccessEvent(f fVar) {
        SochipPresenter sochipPresenter;
        Log.i("Sochip", "socSuccessEvent: -------sochip status");
        if (fVar.b() instanceof CmdListener) {
            int a2 = fVar.a();
            if ((a2 == 1001 || a2 == 1004 || a2 == 1020 || a2 == 1022 || a2 == 1016 || a2 == 1017) && (sochipPresenter = this.H) != null) {
                sochipPresenter.getCameraStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_DEVICE_INFO);
            }
        } else if (fVar.b() instanceof SochipStatusBean) {
            SochipStatusBean sochipStatusBean = (SochipStatusBean) fVar.b();
            Log.i("Sochip", "socSuccessEvent: --video---result---" + sochipStatusBean.getDevice_name());
            this.A.a(this.f12461i, f12448o.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(0).getStatus())));
            this.B.a(this.f12462j, f12449p.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(3).getStatus())));
            this.C.a(this.f12463k, f12450q.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(15).getStatus())));
            this.D.a(this.f12464l, f12451r.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(19).getStatus())));
            this.E.a(this.f12465m, f12452s.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(16).getStatus())));
            this.F.a(this.f12466n, f12453t.indexOf(Integer.valueOf(sochipStatusBean.getInfo().get(21).getStatus())));
        }
    }
}
