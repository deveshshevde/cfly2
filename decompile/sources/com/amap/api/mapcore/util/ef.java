package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.cfly.uav_pro.R;

public final class ef extends eg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private OfflineMapManager f8458a;

    /* renamed from: b  reason: collision with root package name */
    private View f8459b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f8460c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f8461d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f8462e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8463f;

    /* renamed from: g  reason: collision with root package name */
    private int f8464g;

    /* renamed from: h  reason: collision with root package name */
    private String f8465h;

    public ef(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f8458a = offlineMapManager;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        View a2 = el.a(getContext(), (int) R.array.CH_Options);
        this.f8459b = a2;
        setContentView(a2);
        this.f8459b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ef.this.dismiss();
            }
        });
        this.f8460c = (TextView) this.f8459b.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
        TextView textView = (TextView) this.f8459b.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
        this.f8461d = textView;
        textView.setText("暂停下载");
        this.f8462e = (TextView) this.f8459b.findViewById(R.dimen.abc_action_bar_stacked_max_height);
        this.f8463f = (TextView) this.f8459b.findViewById(R.dimen.abc_action_bar_stacked_tab_max_width);
        this.f8461d.setOnClickListener(this);
        this.f8462e.setOnClickListener(this);
        this.f8463f.setOnClickListener(this);
    }

    public final void a(int i2, String str) {
        this.f8460c.setText(str);
        if (i2 == 0) {
            this.f8461d.setText("暂停下载");
            this.f8461d.setVisibility(0);
            this.f8462e.setText("取消下载");
        }
        if (i2 == 2) {
            this.f8461d.setVisibility(8);
        } else if (i2 == -1 || i2 == 101 || i2 == 102 || i2 == 103) {
            this.f8461d.setText("继续下载");
            this.f8461d.setVisibility(0);
            this.f8464g = i2;
            this.f8465h = str;
        } else if (i2 == 3) {
            this.f8461d.setVisibility(0);
            this.f8461d.setText("继续下载");
        } else {
            if (i2 == 4) {
                this.f8462e.setText("删除");
                this.f8461d.setVisibility(8);
            }
            this.f8464g = i2;
            this.f8465h = str;
        }
        this.f8462e.setText("取消下载");
        this.f8464g = i2;
        this.f8465h = str;
    }

    public final void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.dimen.abc_action_bar_overflow_padding_start_material) {
                int i2 = this.f8464g;
                if (i2 == 0) {
                    this.f8461d.setText("继续下载");
                    this.f8458a.pause();
                } else if (i2 == 3 || i2 == -1 || i2 == 101 || i2 == 102 || i2 == 103) {
                    this.f8461d.setText("暂停下载");
                    this.f8458a.downloadByCityName(this.f8465h);
                }
                dismiss();
            } else if (id2 == R.dimen.abc_action_bar_stacked_max_height) {
                if (!TextUtils.isEmpty(this.f8465h)) {
                    this.f8458a.remove(this.f8465h);
                    dismiss();
                }
            } else if (id2 == R.dimen.abc_action_bar_stacked_tab_max_width) {
                dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
