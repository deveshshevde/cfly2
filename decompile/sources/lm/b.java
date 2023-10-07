package lm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;
import lo.a;

public abstract class b<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected List<T> f30942a = null;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f30943b = false;

    /* renamed from: c  reason: collision with root package name */
    protected int f30944c = 3;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f30945d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f30946e = -1;

    /* access modifiers changed from: protected */
    public abstract View a(int i2, View view, ViewGroup viewGroup);

    public final b a(List<T> list) {
        this.f30942a = list;
        super.notifyDataSetChanged();
        return this;
    }

    public final b a(boolean z2) {
        if (z2 != this.f30945d) {
            this.f30945d = z2;
            super.notifyDataSetChanged();
        }
        return this;
    }

    public final void a(int i2) {
        this.f30946e = i2;
    }

    public boolean areAllItemsEnabled() {
        return !this.f30945d;
    }

    public final b b(int i2) {
        this.f30944c = i2;
        super.notifyDataSetChanged();
        return this;
    }

    public final b b(boolean z2) {
        if (z2 != this.f30943b) {
            this.f30943b = z2;
            super.notifyDataSetChanged();
        }
        return this;
    }

    public final int getCount() {
        if (this.f30943b) {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        if (!a.a(this.f30942a)) {
            return (this.f30942a.size() + this.f30944c) - 1;
        }
        return 0;
    }

    public final T getItem(int i2) {
        if (a.a(this.f30942a)) {
            return null;
        }
        List<T> list = this.f30942a;
        return list.get(i2 % list.size());
    }

    public final long getItemId(int i2) {
        if (!a.a(this.f30942a)) {
            i2 %= this.f30942a.size();
        }
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        if (this.f30943b) {
            i3 = i2 % this.f30942a.size();
        } else {
            int i4 = this.f30944c;
            i3 = (i2 >= i4 / 2 && i2 < (i4 / 2) + this.f30942a.size()) ? i2 - (this.f30944c / 2) : -1;
        }
        View a2 = i3 == -1 ? a(0, view, viewGroup) : a(i3, view, viewGroup);
        if (!this.f30943b) {
            if (i3 == -1) {
                a2.setVisibility(4);
            } else {
                a2.setVisibility(0);
            }
        }
        return a2;
    }

    public boolean isEnabled(int i2) {
        if (this.f30945d) {
            return this.f30943b ? i2 % this.f30942a.size() == this.f30946e : i2 == this.f30946e + (this.f30944c / 2);
        }
        return false;
    }

    @Deprecated
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Deprecated
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }
}
