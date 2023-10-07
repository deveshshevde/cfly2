package com.xeagle.android.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.flypro.core.database.ListenerInfoBeans;
import java.util.ArrayList;

public class LoadMoreAdapter extends RecyclerView.Adapter<RecyclerView.v> implements View.OnClickListener {
    private static final int ITEM_DATA = 2;
    private static final int ITEM_FOOTER = 1;
    private Context context;
    private ArrayList<ListenerInfoBeans> infoBeans;
    private boolean isShow;
    private OnItemClickListener onItemClickListener;
    private RecyclerView recyclerView;

    public static class DataViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public TextView listenerDate;
        /* access modifiers changed from: private */
        public TextView listenerMileage;
        /* access modifiers changed from: private */
        public TextView listenerSecond;
        /* access modifiers changed from: private */
        public TextView listenerTime;

        public DataViewHolder(View view) {
            super(view);
            this.listenerDate = (TextView) view.findViewById(R.id.tv_listener_date);
            this.listenerSecond = (TextView) view.findViewById(R.id.tv_listener_second);
            this.listenerMileage = (TextView) view.findViewById(R.id.tv_listener_mileage);
            this.listenerTime = (TextView) view.findViewById(R.id.tv_listener_time);
        }
    }

    public static class FooterViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public LinearLayout load_ll;

        public FooterViewHolder(View view) {
            super(view);
            this.load_ll = (LinearLayout) view.findViewById(R.id.load_ll);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int i2, ListenerInfoBeans listenerInfoBeans);
    }

    public LoadMoreAdapter(Context context2, ArrayList<ListenerInfoBeans> arrayList) {
        this.context = context2;
        this.infoBeans = arrayList;
    }

    public int getItemCount() {
        return this.infoBeans.size() + 1;
    }

    public int getItemViewType(int i2) {
        return i2 == getItemCount() - 1 ? 1 : 2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        int i4;
        String str;
        TextView textView;
        if (vVar instanceof DataViewHolder) {
            DataViewHolder dataViewHolder = (DataViewHolder) vVar;
            if (this.infoBeans.get(i2).getFlying_off().contains(":")) {
                dataViewHolder.listenerDate.setText(this.infoBeans.get(i2).getFlying_off().substring(0, 10));
                textView = dataViewHolder.listenerSecond;
                str = this.infoBeans.get(i2).getFlying_off();
                i4 = 11;
                i3 = 19;
            } else {
                dataViewHolder.listenerDate.setText(this.infoBeans.get(i2).getFlying_off().substring(0, 8));
                textView = dataViewHolder.listenerSecond;
                str = this.infoBeans.get(i2).getFlying_off();
                i4 = 9;
                i3 = 15;
            }
            textView.setText(str.substring(i4, i3));
            dataViewHolder.listenerTime.setText(this.infoBeans.get(i2).getFly_total_time());
            TextView access$300 = dataViewHolder.listenerMileage;
            access$300.setText(this.infoBeans.get(i2).getMileage() + "m");
        } else if (vVar instanceof FooterViewHolder) {
            boolean z2 = this.isShow;
            LinearLayout access$400 = ((FooterViewHolder) vVar).load_ll;
            if (!z2) {
                access$400.setVisibility(8);
            } else {
                access$400.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        int f2 = this.recyclerView.f(view);
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 != null) {
            onItemClickListener2.onItemClick(this.recyclerView, view, f2, this.infoBeans.get(f2));
        }
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view;
        RecyclerView.v vVar = null;
        if (i2 != 1) {
            if (i2 == 2) {
                view = LayoutInflater.from(this.context).inflate(R.layout.listener_list_item, (ViewGroup) null);
                view.setOnClickListener(this);
                vVar = new DataViewHolder(view);
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            return vVar;
        }
        view = LayoutInflater.from(this.context).inflate(R.layout.load_more_layout, (ViewGroup) null);
        vVar = new FooterViewHolder(view);
        layoutParams = new ViewGroup.LayoutParams(-1, -2);
        view.setLayoutParams(layoutParams);
        return vVar;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView2) {
        super.onDetachedFromRecyclerView(recyclerView2);
        this.recyclerView = null;
    }

    public void setListData(ArrayList<ListenerInfoBeans> arrayList) {
        this.infoBeans = arrayList;
    }

    public void setLoadView(boolean z2) {
        this.isShow = z2;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }
}
