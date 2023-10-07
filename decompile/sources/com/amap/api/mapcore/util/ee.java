package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.cfly.uav_pro.R;
import java.util.ArrayList;
import java.util.List;

public final class ee extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<OfflineMapCity> f8447a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OfflineMapManager f8448b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f8449c;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f8453a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f8454b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f8455c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f8456d;

        public a() {
        }
    }

    public ee(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f8448b = offlineMapManager;
        this.f8449c = offlineMapActivity;
    }

    public final void a(List<OfflineMapCity> list) {
        this.f8447a = list;
    }

    public final int getCount() {
        return this.f8447a.size();
    }

    public final Object getItem(int i2) {
        return this.f8447a.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        final a aVar;
        TextView textView;
        String str;
        try {
            final OfflineMapCity offlineMapCity = this.f8447a.get(i2);
            if (view == null) {
                aVar = new a();
                view = el.a((Context) this.f8449c, (int) R.array.CoordSource);
                aVar.f8453a = (TextView) view.findViewById(R.dimen.abc_action_bar_subtitle_bottom_margin_material);
                aVar.f8454b = (TextView) view.findViewById(R.dimen.abc_action_button_min_width_overflow_material);
                aVar.f8455c = (TextView) view.findViewById(R.dimen.abc_action_button_min_height_material);
                aVar.f8456d = (ImageView) view.findViewById(R.dimen.abc_action_button_min_width_material);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f8456d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.f8456d.setVisibility(8);
                    aVar.f8455c.setVisibility(0);
                    aVar.f8455c.setText("下载中");
                    try {
                        ee.this.f8448b.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            aVar.f8455c.setVisibility(0);
            aVar.f8453a.setText(offlineMapCity.getCity());
            double size = (double) offlineMapCity.getSize();
            Double.isNaN(size);
            double d2 = (double) ((int) (((size / 1024.0d) / 1024.0d) * 100.0d));
            Double.isNaN(d2);
            double d3 = d2 / 100.0d;
            TextView textView2 = aVar.f8454b;
            textView2.setText(String.valueOf(d3) + " M");
            int state = offlineMapCity.getState();
            if (state != -1) {
                if (state == 0 || state == 1) {
                    aVar.f8456d.setVisibility(8);
                    textView = aVar.f8455c;
                    str = "下载中";
                    textView.setText(str);
                    return view;
                }
                if (state == 2) {
                    aVar.f8456d.setVisibility(8);
                    textView = aVar.f8455c;
                    str = "等待下载";
                } else if (state == 3) {
                    aVar.f8456d.setVisibility(8);
                    textView = aVar.f8455c;
                    str = "暂停中";
                } else if (state != 4) {
                    if (state != 6) {
                        switch (state) {
                            case 101:
                            case 102:
                            case 103:
                                break;
                        }
                    } else {
                        aVar.f8456d.setVisibility(0);
                        aVar.f8455c.setVisibility(8);
                    }
                    return view;
                } else {
                    aVar.f8456d.setVisibility(8);
                    textView = aVar.f8455c;
                    str = "已下载";
                }
                textView.setText(str);
                return view;
            }
            aVar.f8456d.setVisibility(8);
            textView = aVar.f8455c;
            str = "下载失败";
            textView.setText(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return view;
    }
}
