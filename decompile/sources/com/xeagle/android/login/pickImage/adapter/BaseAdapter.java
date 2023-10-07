package com.xeagle.android.login.pickImage.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public List<T> dataList;
    private BaseDelegate delegate;
    public OnItemClickListener listener;
    private View.OnClickListener mClickListenerMediator;
    private View.OnLongClickListener mLongClickListenerMediator;

    public BaseAdapter(List<T> list) {
        this(list, (OnItemClickListener) null);
    }

    public BaseAdapter(List<T> list, OnItemClickListener onItemClickListener) {
        this.mClickListenerMediator = new View.OnClickListener() {
            public void onClick(View view) {
                int viewHolderAdapterPosition;
                if (BaseAdapter.this.listener != null && (viewHolderAdapterPosition = BaseAdapter.getViewHolderAdapterPosition(view)) >= 0) {
                    BaseAdapter.this.listener.onClick(view, viewHolderAdapterPosition, BaseAdapter.this.getData(viewHolderAdapterPosition));
                }
            }
        };
        this.mLongClickListenerMediator = new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                int viewHolderAdapterPosition;
                if (BaseAdapter.this.listener == null || (viewHolderAdapterPosition = BaseAdapter.getViewHolderAdapterPosition(view)) < 0) {
                    return false;
                }
                return BaseAdapter.this.listener.onLongClick(view, viewHolderAdapterPosition, BaseAdapter.this.getData(viewHolderAdapterPosition));
            }
        };
        checkData(list);
        this.listener = onItemClickListener;
    }

    private void checkData(List<T> list) {
        if (list == null) {
            list = new ArrayList<>(0);
        }
        this.dataList = list;
    }

    static int getViewHolderAdapterPosition(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return ((RecyclerView) parent).f(view);
        }
        return -1;
    }

    public void appendDataAndNotify(T t2) {
        if (t2 != null) {
            this.dataList.add(t2);
            this.delegate.onDataSetChanged();
            notifyDataSetChanged();
        }
    }

    public void appendDataAndNotify(List<? extends T> list) {
        this.dataList.addAll(list);
        this.delegate.onDataSetChanged();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public T getData(int i2) {
        if (i2 >= 0) {
            return this.dataList.get(i2);
        }
        return null;
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public int getItemViewType(int i2) {
        return this.delegate.getItemViewType(this.dataList.get(i2), i2);
    }

    public T getLastData() {
        List<T> list = this.dataList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<T> list2 = this.dataList;
        return list2.get(list2.size() - 1);
    }

    public void insertHeadDataAndNotify(T t2) {
        if (t2 != null) {
            this.dataList.add(0, t2);
            this.delegate.onDataSetChanged();
            notifyDataSetChanged();
        }
    }

    public boolean isEmpty() {
        return this.dataList.size() == 0;
    }

    /* access modifiers changed from: protected */
    public void listenClick(BaseViewHolder baseViewHolder) {
        if (this.listener != null && baseViewHolder.isClickable()) {
            baseViewHolder.itemView.setOnClickListener(this.mClickListenerMediator);
            baseViewHolder.itemView.setOnLongClickListener(this.mLongClickListenerMediator);
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        baseViewHolder.bindViewHolder(this.dataList.get(i2));
        listenClick(baseViewHolder);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        BaseViewHolder createViewHolder = this.delegate.createViewHolder(this, viewGroup, i2);
        createViewHolder.findViews();
        return createViewHolder;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        if (baseViewHolder instanceof DetachAwareViewHolder) {
            ((DetachAwareViewHolder) baseViewHolder).onViewAttachedToWindow();
        }
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        if (baseViewHolder instanceof DetachAwareViewHolder) {
            ((DetachAwareViewHolder) baseViewHolder).onViewDetachedFromWindow();
        }
    }

    public void onViewRecycled(BaseViewHolder baseViewHolder) {
        super.onViewRecycled(baseViewHolder);
        if (baseViewHolder instanceof RecyclerView.o) {
            ((RecyclerView.o) baseViewHolder).onViewRecycled(baseViewHolder);
        }
    }

    public void removeItem(int i2) {
        this.dataList.remove(i2);
        this.delegate.onDataSetChanged();
        notifyItemRemoved(i2);
    }

    public void setDelegate(BaseDelegate baseDelegate) {
        this.delegate = baseDelegate;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void updateDataAndNotify(List<? extends T> list) {
        this.dataList.clear();
        if (list != null && list.size() > 0) {
            this.dataList.addAll(list);
        }
        this.delegate.onDataSetChanged();
        notifyDataSetChanged();
    }
}
