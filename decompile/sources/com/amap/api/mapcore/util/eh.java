package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.cfly.uav_pro.R;

public final class eh implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f8467a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Context f8468b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f8469c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f8470d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f8471e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8472f;

    /* renamed from: g  reason: collision with root package name */
    private OfflineMapManager f8473g;

    /* renamed from: h  reason: collision with root package name */
    private OfflineMapCity f8474h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8475i = false;

    /* renamed from: j  reason: collision with root package name */
    private Handler f8476j = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                eh.this.a(message.arg1, message.arg2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private View f8477k;

    /* renamed from: l  reason: collision with root package name */
    private DownloadProgressView f8478l;

    public eh(Context context, OfflineMapManager offlineMapManager) {
        this.f8468b = context;
        b();
        this.f8473g = offlineMapManager;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) throws Exception {
        if (this.f8467a != 2 || i3 <= 3 || i3 >= 100) {
            this.f8478l.setVisibility(8);
        } else {
            this.f8478l.setVisibility(0);
            this.f8478l.setProgress(i3);
        }
        if (i2 == -1) {
            f();
        } else if (i2 != 0) {
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                e();
            } else if (i2 == 3) {
                g();
            } else if (i2 == 4) {
                h();
            } else if (i2 == 6) {
                c();
            } else if (i2 != 7) {
                switch (i2) {
                    case 101:
                    case 102:
                    case 103:
                        f();
                        return;
                    default:
                        return;
                }
            } else {
                d();
            }
        } else if (this.f8467a == 1) {
            this.f8471e.setVisibility(8);
            this.f8472f.setText("下载中");
            this.f8472f.setTextColor(Color.parseColor("#4287ff"));
        } else {
            j();
        }
    }

    private void b() {
        View a2 = el.a(this.f8468b, (int) R.array.CoordSource);
        this.f8477k = a2;
        this.f8478l = (DownloadProgressView) a2.findViewById(R.dimen.abc_alert_dialog_button_bar_height);
        this.f8469c = (TextView) this.f8477k.findViewById(R.dimen.abc_action_bar_subtitle_bottom_margin_material);
        this.f8470d = (TextView) this.f8477k.findViewById(R.dimen.abc_action_button_min_width_overflow_material);
        this.f8471e = (ImageView) this.f8477k.findViewById(R.dimen.abc_action_button_min_width_material);
        this.f8472f = (TextView) this.f8477k.findViewById(R.dimen.abc_action_button_min_height_material);
        this.f8471e.setOnClickListener(this);
    }

    private void b(int i2, int i3) {
        OfflineMapCity offlineMapCity = this.f8474h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i2);
            this.f8474h.setCompleteCode(i3);
        }
        Message message = new Message();
        message.arg1 = i2;
        message.arg2 = i3;
        this.f8476j.sendMessage(message);
    }

    private void c() {
        this.f8472f.setVisibility(8);
        this.f8471e.setVisibility(0);
        this.f8471e.setImageResource(R.animator.design_fab_show_motion_spec);
    }

    private void d() {
        this.f8472f.setVisibility(0);
        this.f8471e.setVisibility(0);
        this.f8471e.setImageResource(R.animator.design_fab_show_motion_spec);
        this.f8472f.setText("已下载-有更新");
    }

    private void e() {
        if (this.f8467a == 1) {
            this.f8471e.setVisibility(8);
            this.f8472f.setVisibility(0);
            this.f8472f.setText("等待中");
            this.f8472f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f8472f.setVisibility(0);
        this.f8471e.setVisibility(8);
        this.f8472f.setTextColor(Color.parseColor("#4287ff"));
        this.f8472f.setText("等待中");
    }

    private void f() {
        this.f8472f.setVisibility(0);
        this.f8471e.setVisibility(8);
        this.f8472f.setTextColor(-65536);
        this.f8472f.setText("下载出现异常");
    }

    private void g() {
        this.f8472f.setVisibility(0);
        this.f8471e.setVisibility(8);
        this.f8472f.setTextColor(-7829368);
        this.f8472f.setText("暂停");
    }

    private void h() {
        this.f8472f.setVisibility(0);
        this.f8471e.setVisibility(8);
        this.f8472f.setText("已下载");
        this.f8472f.setTextColor(Color.parseColor("#898989"));
    }

    private void i() {
        if (this.f8467a != 1) {
            this.f8472f.setVisibility(0);
            this.f8471e.setVisibility(8);
            this.f8472f.setText("解压中");
            this.f8472f.setTextColor(Color.parseColor("#898989"));
        }
    }

    private void j() {
        if (this.f8474h != null) {
            this.f8472f.setVisibility(0);
            this.f8472f.setText("下载中");
            this.f8471e.setVisibility(8);
            this.f8472f.setTextColor(Color.parseColor("#4287ff"));
        }
    }

    private synchronized void k() {
        this.f8473g.pause();
        this.f8473g.restart();
    }

    private synchronized boolean l() {
        try {
            this.f8473g.downloadByCityName(this.f8474h.getCity());
        } catch (AMapException e2) {
            e2.printStackTrace();
            Toast.makeText(this.f8468b, e2.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    public final View a() {
        return this.f8477k;
    }

    public final void a(int i2) {
        this.f8467a = i2;
    }

    public final void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.f8474h = offlineMapCity;
            this.f8469c.setText(offlineMapCity.getCity());
            double size = (double) offlineMapCity.getSize();
            Double.isNaN(size);
            double d2 = (double) ((int) (((size / 1024.0d) / 1024.0d) * 100.0d));
            Double.isNaN(d2);
            TextView textView = this.f8470d;
            textView.setText(String.valueOf(d2 / 100.0d) + " M");
            b(this.f8474h.getState(), this.f8474h.getcompleteCode());
        }
    }

    public final void onClick(View view) {
        try {
            if (!dl.d(this.f8468b)) {
                Toast.makeText(this.f8468b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f8474h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f8474h.getcompleteCode();
                if (state == 0) {
                    k();
                    g();
                } else if (state != 1 && state != 4) {
                    if (l()) {
                        e();
                    } else {
                        f();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
