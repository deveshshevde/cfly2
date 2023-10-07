package com.xeagle.android.login.pickImage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.v {
    protected RecyclerView.Adapter adapter;
    protected final Context context;
    /* access modifiers changed from: private */
    public T data;
    private final Runnable refreshTask;

    public BaseViewHolder(View view) {
        super(view);
        this.refreshTask = new Runnable() {
            public void run() {
                BaseViewHolder baseViewHolder = BaseViewHolder.this;
                baseViewHolder.bindViewHolder(baseViewHolder.data);
            }
        };
        this.context = view.getContext();
    }

    public BaseViewHolder(ViewGroup viewGroup, int i2) {
        this(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    /* access modifiers changed from: package-private */
    public final void bindViewHolder(T t2) {
        this.data = t2;
        onBindViewHolder(t2);
    }

    public final <V extends View> V findViewById(int i2) {
        return this.itemView.findViewById(i2);
    }

    public abstract void findViews();

    public boolean isClickable() {
        return true;
    }

    public final boolean isFirstItem() {
        return getAdapterPosition() == 0;
    }

    public final boolean isLastItem() {
        return getAdapterPosition() == this.adapter.getItemCount() - 1;
    }

    /* access modifiers changed from: protected */
    public abstract void onBindViewHolder(T t2);

    /* access modifiers changed from: protected */
    public final void refresh() {
        this.itemView.removeCallbacks(this.refreshTask);
        this.itemView.post(this.refreshTask);
    }
}
