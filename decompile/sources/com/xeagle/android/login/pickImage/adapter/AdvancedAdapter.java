package com.xeagle.android.login.pickImage.adapter;

import java.util.ArrayList;
import java.util.Iterator;

public class AdvancedAdapter extends BaseAdapter<BaseViewHolderData> {
    public AdvancedAdapter() {
        super(new ArrayList());
    }

    public AdvancedAdapter(OnItemClickListener onItemClickListener) {
        super(new ArrayList(), onItemClickListener);
    }

    private void remove(int i2, boolean z2) {
        Iterator it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            if (((BaseViewHolderData) it2.next()).getViewType() == i2) {
                it2.remove();
                if (z2) {
                    return;
                }
            }
        }
    }

    public void add(int i2, Object obj) {
        this.dataList.add(new BaseViewHolderData(i2, obj));
    }

    public void add(int i2, Object obj, int i3) {
        this.dataList.add(i3, new BaseViewHolderData(i2, obj));
    }

    public void clear() {
        this.dataList.clear();
    }

    public final int getItemCount() {
        return super.getItemCount();
    }

    public final int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        baseViewHolder.bindViewHolder(((BaseViewHolderData) this.dataList.get(i2)).getData());
        listenClick(baseViewHolder);
    }

    public void removeByType(int i2) {
        remove(i2, true);
    }

    public void removeByTypeAll(int i2) {
        remove(i2, false);
    }
}
