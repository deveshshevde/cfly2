package com.xeagle.android.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.s;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import en.a;

public class v extends b implements View.OnClickListener, DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    private Button f23507e;

    /* renamed from: f  reason: collision with root package name */
    private Button f23508f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Button f23509g;

    /* renamed from: h  reason: collision with root package name */
    private Button f23510h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f23511i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f23512j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f23513k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f23514l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public a f23515m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23516n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23517o;

    /* renamed from: com.xeagle.android.fragments.v$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23521a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23521a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.REMOTE_SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(View view) {
        this.f23507e = (Button) view.findViewById(R.id.match_code_bt);
        this.f23508f = (Button) view.findViewById(R.id.stick_request_bt);
        this.f23509g = (Button) view.findViewById(R.id.stick_set_bt);
        this.f23510h = (Button) view.findViewById(R.id.start_calibrate_bt);
        this.f23511i = (TextView) view.findViewById(R.id.match_code_tv);
        this.f23512j = (TextView) view.findViewById(R.id.stick_request_tv);
        this.f23513k = (TextView) view.findViewById(R.id.stick_set_tv);
        this.f23514l = (TextView) view.findViewById(R.id.start_calibrate_tv);
        this.f23507e.setOnClickListener(this);
        this.f23508f.setOnClickListener(this);
        this.f23509g.setOnClickListener(this);
        this.f23510h.setOnClickListener(this);
    }

    private void a(a aVar) {
        TextView textView;
        String str;
        Button button;
        Button button2;
        String str2;
        TextView textView2;
        String str3;
        TextView textView3;
        String str4;
        if (aVar.j().a()) {
            int a2 = aVar.J().a();
            int b2 = aVar.J().b();
            if (a2 == 1 && b2 == 1 && !this.f23517o) {
                this.f23511i.setText("进入对码");
                this.f23517o = true;
                button2 = this.f23507e;
                str2 = "请求完成对码";
            } else {
                String str5 = "请求对码";
                if (a2 == 1 && b2 == 1 && this.f23517o) {
                    textView3 = this.f23511i;
                    str4 = "对码成功";
                } else if (a2 == 1 && b2 == 2 && this.f23517o) {
                    textView3 = this.f23511i;
                    str4 = "对码失败";
                } else if (a2 == 2) {
                    TextView textView4 = this.f23512j;
                    textView4.setText("当前摇杆模式：" + b2);
                    return;
                } else {
                    if (a2 == 3 && b2 == 1) {
                        textView2 = this.f23513k;
                        str3 = "设置成功";
                    } else if (a2 == 3 && b2 == 2) {
                        textView2 = this.f23513k;
                        str3 = "设置失败";
                    } else {
                        str5 = "开始校准";
                        if (a2 == 4 && b2 == 1 && !this.f23516n) {
                            this.f23514l.setText(str5);
                            this.f23516n = true;
                            button2 = this.f23510h;
                            str2 = "完成校准";
                        } else {
                            if (a2 == 4 && b2 == 1 && this.f23516n) {
                                textView = this.f23514l;
                                str = "校准成功";
                            } else if (a2 == 4 && b2 == 2 && this.f23516n) {
                                textView = this.f23514l;
                                str = "校准失败";
                            } else {
                                return;
                            }
                            textView.setText(str);
                            this.f23516n = false;
                            button = this.f23510h;
                            button.setText(str5);
                            return;
                        }
                    }
                    textView2.setText(str3);
                    return;
                }
                textView3.setText(str4);
                this.f23517o = false;
                button = this.f23507e;
                button.setText(str5);
                return;
            }
            button2.setText(str2);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.match_code_bt:
                if (!this.f23517o) {
                    s.a(this.f23515m, 1, 1);
                    return;
                } else {
                    s.a(this.f23515m, 1, 2);
                    return;
                }
            case R.id.start_calibrate_bt:
                if (!this.f23516n) {
                    s.a(this.f23515m, 4, 1);
                    return;
                } else {
                    s.a(this.f23515m, 4, 2);
                    return;
                }
            case R.id.stick_request_bt:
                break;
            case R.id.stick_set_bt:
                new AlertDialog.Builder(getActivity()).setTitle("设置摇杆模式").setAdapter(new ArrayAdapter(getActivity(), R.layout.simple_spinner_item_1, getResources().getStringArray(R.array.remote_stick_mode_entry)), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, final int i2) {
                        v.this.f23509g.setText(v.this.getResources().getStringArray(R.array.remote_stick_mode_entry)[i2]);
                        new Thread(new Runnable() {
                            public void run() {
                                s.a(v.this.f23515m, 3, Integer.parseInt(v.this.getResources().getStringArray(R.array.remote_stick_mode_value)[i2]));
                            }
                        }).start();
                        dialogInterface.dismiss();
                    }
                }).create().show();
                break;
            default:
                return;
        }
        s.a(this.f23515m, 2, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.flight_remote_fragment, viewGroup, false);
        this.f23515m = ((XEagleApp) getActivity().getApplication()).k();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass2.f23521a[droneEventsType.ordinal()] == 1) {
            a(aVar);
        }
    }

    public void onStart() {
        super.onStart();
        a(this.f23515m);
        this.f23515m.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onDestroy();
        this.f23515m.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
