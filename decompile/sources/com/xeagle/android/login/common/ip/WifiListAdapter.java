package com.xeagle.android.login.common.ip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.beans.WifiBean;
import java.util.List;

public class WifiListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    /* access modifiers changed from: private */
    public onItemClickListener onItemClickListener;
    private List<WifiBean> resultList;

    static class MyViewHolder extends RecyclerView.v {
        View itemview;
        ImageView iv_level;
        TextView tvItemWifiName;
        TextView tvItemWifiStatus;

        public MyViewHolder(View view) {
            super(view);
            this.itemview = view;
            this.tvItemWifiName = (TextView) view.findViewById(R.id.tv_item_wifi_name);
            this.tvItemWifiStatus = (TextView) view.findViewById(R.id.tv_item_wifi_status);
            this.iv_level = (ImageView) view.findViewById(R.id.iv_level);
        }
    }

    public interface onItemClickListener {
        void onItemClick(View view, int i2, Object obj);
    }

    public WifiListAdapter(Context context, List<WifiBean> list) {
        this.mContext = context;
        this.resultList = list;
    }

    public int getItemCount() {
        return this.resultList.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.xeagle.android.login.common.ip.WifiListAdapter.MyViewHolder r5, final int r6) {
        /*
            r4 = this;
            java.util.List<com.xeagle.android.login.beans.WifiBean> r0 = r4.resultList
            java.lang.Object r0 = r0.get(r6)
            com.xeagle.android.login.beans.WifiBean r0 = (com.xeagle.android.login.beans.WifiBean) r0
            android.widget.TextView r1 = r5.tvItemWifiName
            java.lang.String r2 = r0.getWifiName()
            r1.setText(r2)
            android.widget.TextView r1 = r5.tvItemWifiStatus
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "("
            r2.append(r3)
            java.lang.String r3 = r0.getState()
            r2.append(r3)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onBindViewHolder: ---LEVEL---"
            r1.append(r2)
            int r2 = r0.getLevel()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "WIFI"
            android.util.Log.i(r2, r1)
            int r1 = r0.getLevel()
            r2 = 5
            int r1 = android.net.wifi.WifiManager.calculateSignalLevel(r1, r2)
            if (r1 == 0) goto L_0x007a
            r2 = 1
            if (r1 == r2) goto L_0x0074
            r2 = 2
            if (r1 == r2) goto L_0x006e
            r2 = 3
            if (r1 == r2) goto L_0x0068
            r2 = 4
            if (r1 == r2) goto L_0x0062
            goto L_0x0082
        L_0x0062:
            android.widget.ImageView r1 = r5.iv_level
            r2 = 2131232458(0x7f0806ca, float:1.8081026E38)
            goto L_0x007f
        L_0x0068:
            android.widget.ImageView r1 = r5.iv_level
            r2 = 2131232457(0x7f0806c9, float:1.8081024E38)
            goto L_0x007f
        L_0x006e:
            android.widget.ImageView r1 = r5.iv_level
            r2 = 2131232456(0x7f0806c8, float:1.8081022E38)
            goto L_0x007f
        L_0x0074:
            android.widget.ImageView r1 = r5.iv_level
            r2 = 2131232455(0x7f0806c7, float:1.808102E38)
            goto L_0x007f
        L_0x007a:
            android.widget.ImageView r1 = r5.iv_level
            r2 = 2131232454(0x7f0806c6, float:1.8081018E38)
        L_0x007f:
            r1.setImageResource(r2)
        L_0x0082:
            if (r6 != 0) goto L_0x00b6
            android.content.Context r1 = r4.mContext
            r2 = 2131820967(0x7f1101a7, float:1.9274664E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = r0.getState()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00aa
            android.content.Context r1 = r4.mContext
            r2 = 2131820965(0x7f1101a5, float:1.927466E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = r0.getState()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b6
        L_0x00aa:
            android.widget.TextView r1 = r5.tvItemWifiName
            android.content.Context r2 = r4.mContext
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131099842(0x7f0600c2, float:1.7812049E38)
            goto L_0x00c1
        L_0x00b6:
            android.widget.TextView r1 = r5.tvItemWifiName
            android.content.Context r2 = r4.mContext
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131100159(0x7f0601ff, float:1.7812692E38)
        L_0x00c1:
            int r2 = r2.getColor(r3)
            r1.setTextColor(r2)
            android.widget.TextView r1 = r5.tvItemWifiStatus
            android.content.Context r2 = r4.mContext
            android.content.res.Resources r2 = r2.getResources()
            int r2 = r2.getColor(r3)
            r1.setTextColor(r2)
            android.view.View r5 = r5.itemview
            com.xeagle.android.login.common.ip.WifiListAdapter$1 r1 = new com.xeagle.android.login.common.ip.WifiListAdapter$1
            r1.<init>(r6, r0)
            r5.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ip.WifiListAdapter.onBindViewHolder(com.xeagle.android.login.common.ip.WifiListAdapter$MyViewHolder, int):void");
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_wifi_list, viewGroup, false));
    }

    public void replaceAll(List<WifiBean> list) {
        if (this.resultList.size() > 0) {
            this.resultList.clear();
        }
        this.resultList.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(onItemClickListener onitemclicklistener) {
        this.onItemClickListener = onitemclicklistener;
    }
}
