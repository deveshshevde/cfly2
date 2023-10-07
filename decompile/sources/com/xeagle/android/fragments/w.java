package com.xeagle.android.fragments;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.s;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.activities.helpers.b;
import en.a;

public class w extends b implements View.OnClickListener, DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    Runnable f23522e = new Runnable() {
        public void run() {
            s.a(w.this.f12363c, 1, 2);
            boolean unused = w.this.f23530m = false;
            boolean unused2 = w.this.f23531n = true;
            w.this.f23529l.stop();
            w.this.f23527j.dismiss();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f23523f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f23524g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f23525h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f23526i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Dialog f23527j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f23528k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public AnimationDrawable f23529l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f23530m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f23531n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f23532o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f23533p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f23534q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23535r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f23536s = new Handler();

    /* renamed from: com.xeagle.android.fragments.w$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23538a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23538a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.REMOTE_SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(View view) {
        this.f23523f = (RelativeLayout) view.findViewById(R.id.match_code_rl);
        this.f23524g = (RelativeLayout) view.findViewById(R.id.remote_calibrate_rl);
        this.f23525h = (RelativeLayout) view.findViewById(R.id.switch_handle_rl);
        this.f23526i = (RelativeLayout) view.findViewById(R.id.gimbal_update_rl);
        this.f23532o = (TextView) view.findViewById(R.id.sub_txt);
        this.f23533p = (TextView) view.findViewById(R.id.sub_info);
        this.f23527j = new Dialog(getActivity(), R.style.dialog);
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.match_code_dialog, (ViewGroup) null);
        this.f23527j.setContentView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.remote_animate);
        this.f23528k = imageView;
        imageView.setImageResource(R.drawable.match_code_radar);
        this.f23529l = (AnimationDrawable) this.f23528k.getDrawable();
        this.f23527j.setCanceledOnTouchOutside(false);
        this.f23523f.setOnClickListener(this);
        this.f23524g.setOnClickListener(this);
        this.f23525h.setOnClickListener(this);
        this.f23526i.setOnClickListener(this);
        this.f23532o.setOnClickListener(this);
        this.f23533p.setOnClickListener(this);
    }

    private void a(a aVar) {
        FragmentActivity activity;
        String str;
        int a2 = aVar.J().a();
        int b2 = aVar.J().b();
        if (a2 != 0 && b2 != 0) {
            if (a2 == 5 && b2 == 1) {
                this.f23534q = true;
                activity = getActivity();
                str = "子控已插入";
            } else if (a2 == 5 && b2 == 2) {
                this.f23534q = false;
                activity = getActivity();
                str = "子控未插入";
            } else if (a2 == 6 && b2 == 1) {
                this.f23535r = true;
                activity = getActivity();
                str = "子控已开启";
            } else if (a2 == 6 && b2 == 2) {
                this.f23535r = false;
                activity = getActivity();
                str = "子控未开启";
            } else {
                return;
            }
            Toast.makeText(activity, str, 1).show();
        }
    }

    private void b(a aVar) {
        FragmentActivity activity;
        String str;
        int a2 = aVar.J().a();
        int b2 = aVar.J().b();
        if (a2 != 0 && b2 != 0) {
            if (a2 == 1 && b2 == 1 && this.f23530m) {
                activity = getActivity();
                str = "进入对码";
            } else if (a2 == 1 && b2 == 1 && this.f23531n) {
                activity = getActivity();
                str = "对码完成";
            } else if (a2 == 1 && b2 == 2) {
                activity = getActivity();
                str = "对码失败";
            } else {
                return;
            }
            Toast.makeText(activity, str, 0).show();
        }
    }

    public void onClick(View view) {
        Fragment fragment;
        a aVar;
        int i2;
        androidx.fragment.app.s a2 = getFragmentManager().a();
        switch (view.getId()) {
            case R.id.match_code_rl:
                this.f23527j.show();
                this.f23529l.start();
                s.a(this.f12363c, 1, 1);
                this.f23530m = true;
                this.f23531n = false;
                this.f23536s.postDelayed(this.f23522e, 3000);
                return;
            case R.id.remote_calibrate_rl:
                fragment = new o();
                break;
            case R.id.sub_info:
                if (!this.f23535r) {
                    s.a(this.f12363c, 7, 1);
                    return;
                } else {
                    s.a(this.f12363c, 7, 2);
                    return;
                }
            case R.id.sub_txt:
                if (!this.f23534q) {
                    aVar = this.f12363c;
                    i2 = 5;
                } else {
                    aVar = this.f12363c;
                    i2 = 6;
                }
                s.a(aVar, i2, 0);
                return;
            case R.id.switch_handle_rl:
                fragment = new p();
                break;
            default:
                return;
        }
        a2.b(R.id.dialog_content, fragment);
        a2.c(4097);
        a2.c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.remote_setting_fragment, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        if (AnonymousClass2.f23538a[droneEventsType.ordinal()] == 1) {
            b(aVar);
            a(aVar);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
