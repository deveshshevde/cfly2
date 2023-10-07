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
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.IWidgets.wheelView.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g extends c implements View.OnClickListener, WheelView.b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f22632a = true;

    /* renamed from: b  reason: collision with root package name */
    private WheelView f22633b;

    /* renamed from: c  reason: collision with root package name */
    private WheelView f22634c;

    /* renamed from: d  reason: collision with root package name */
    private WheelView f22635d;

    /* renamed from: e  reason: collision with root package name */
    private WheelView f22636e;

    /* renamed from: f  reason: collision with root package name */
    private WheelView f22637f;

    /* renamed from: g  reason: collision with root package name */
    private WheelView f22638g;

    /* renamed from: h  reason: collision with root package name */
    private WheelView f22639h;

    /* renamed from: i  reason: collision with root package name */
    private WheelView f22640i;

    /* renamed from: j  reason: collision with root package name */
    private WheelView f22641j;

    /* renamed from: k  reason: collision with root package name */
    private WheelView f22642k;

    /* renamed from: l  reason: collision with root package name */
    private WheelView f22643l;

    /* renamed from: m  reason: collision with root package name */
    private IImageButton f22644m;

    /* renamed from: n  reason: collision with root package name */
    private a f22645n;

    /* renamed from: o  reason: collision with root package name */
    private a f22646o;

    /* renamed from: p  reason: collision with root package name */
    private a f22647p;

    /* renamed from: q  reason: collision with root package name */
    private a f22648q;

    /* renamed from: r  reason: collision with root package name */
    private a f22649r;

    /* renamed from: s  reason: collision with root package name */
    private a f22650s;

    /* renamed from: t  reason: collision with root package name */
    private a f22651t;

    /* renamed from: u  reason: collision with root package name */
    private a f22652u;

    /* renamed from: v  reason: collision with root package name */
    private a f22653v;

    /* renamed from: w  reason: collision with root package name */
    private a f22654w;

    /* renamed from: x  reason: collision with root package name */
    private WheelView.c f22655x;

    /* renamed from: y  reason: collision with root package name */
    private FlightActionActivity f22656y;

    private class a extends WheelView.c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<String> f22660b = new ArrayList();

        a() {
        }

        /* access modifiers changed from: protected */
        public int a() {
            return this.f22660b.size();
        }

        /* access modifiers changed from: protected */
        public String a(int i2) {
            return this.f22660b.get(i2);
        }
    }

    private void a(int i2, a aVar, WheelView wheelView) {
        List asList = Arrays.asList(this.f22656y.getResources().getStringArray(i2));
        aVar.f22660b.clear();
        aVar.f22660b.addAll(asList);
        wheelView.setAdapter(aVar);
        wheelView.setCurrentItem(0);
    }

    private void a(View view) {
        this.f22633b = (WheelView) view.findViewById(R.id.video_resolution_wheel);
        this.f22634c = (WheelView) view.findViewById(R.id.ev_wheel);
        this.f22635d = (WheelView) view.findViewById(R.id.bw_wheel);
        this.f22636e = (WheelView) view.findViewById(R.id.video_water_wheel);
        this.f22637f = (WheelView) view.findViewById(R.id.photo_water_wheel);
        this.f22638g = (WheelView) view.findViewById(R.id.photo_resolution_wheel);
        this.f22639h = (WheelView) view.findViewById(R.id.iso_wheel);
        this.f22640i = (WheelView) view.findViewById(R.id.fov_wheel);
        this.f22641j = (WheelView) view.findViewById(R.id.scene_mode_wheel);
        this.f22642k = (WheelView) view.findViewById(R.id.effect_mode_wheel);
        this.f22643l = (WheelView) view.findViewById(R.id.saturation_wheel);
        IImageButton iImageButton = (IImageButton) view.findViewById(R.id.camera_cancel_ib);
        this.f22644m = iImageButton;
        iImageButton.setOnClickListener(this);
        this.f22633b.setOnItemSelectedListener(this);
        this.f22634c.setOnItemSelectedListener(this);
        this.f22635d.setOnItemSelectedListener(this);
        this.f22636e.setOnItemSelectedListener(this);
        this.f22637f.setOnItemSelectedListener(this);
        this.f22638g.setOnItemSelectedListener(this);
        this.f22639h.setOnItemSelectedListener(this);
        this.f22640i.setOnItemSelectedListener(this);
        this.f22641j.setOnItemSelectedListener(this);
        this.f22642k.setOnItemSelectedListener(this);
        this.f22643l.setOnItemSelectedListener(this);
        a aVar = new a();
        this.f22645n = aVar;
        a(R.array.video_resolution, aVar, this.f22633b);
        a aVar2 = new a();
        this.f22646o = aVar2;
        a(R.array.ev_value, aVar2, this.f22634c);
        a aVar3 = new a();
        this.f22647p = aVar3;
        a(R.array.awb_value, aVar3, this.f22635d);
        a aVar4 = new a();
        this.f22648q = aVar4;
        a(R.array.video_watermark, aVar4, this.f22636e);
        a aVar5 = new a();
        this.f22649r = aVar5;
        a(R.array.photo_watermark, aVar5, this.f22637f);
        a aVar6 = new a();
        this.f22650s = aVar6;
        a(R.array.photo_resolution, aVar6, this.f22638g);
        a aVar7 = new a();
        this.f22651t = aVar7;
        a(R.array.iso_value, aVar7, this.f22639h);
        a aVar8 = new a();
        this.f22652u = aVar8;
        a(R.array.fov_value, aVar8, this.f22640i);
        a aVar9 = new a();
        this.f22653v = aVar9;
        a(R.array.scene_mode, aVar9, this.f22641j);
        a aVar10 = new a();
        this.f22654w = aVar10;
        a(R.array.effect_mode, aVar10, this.f22642k);
        AnonymousClass2 r3 = new WheelView.c() {
            /* access modifiers changed from: protected */
            public int a() {
                return 256;
            }

            /* access modifiers changed from: protected */
            public String a(int i2) {
                return String.valueOf(i2);
            }
        };
        this.f22655x = r3;
        this.f22643l.setAdapter(r3);
        this.f22643l.setCurrentItem(0);
    }

    public void a(WheelView wheelView, int i2) {
        Log.i("Wheel", "onItemSelected: ----index---" + i2);
        wheelView.getId();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f22656y = (FlightActionActivity) context;
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
        if (f22632a || window != null) {
            window.setGravity(5);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5, getActivity().getWindowManager().getDefaultDisplay().getHeight());
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.camera_dlg_fragment, viewGroup, false);
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
}
