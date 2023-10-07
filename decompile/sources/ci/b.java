package ci;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class b extends RecyclerView.v {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public View f6228a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<View> f6229b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<Integer> f6230c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<Integer> f6231d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<Integer> f6232e = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f6233f;

    public b(View view) {
        super(view);
        this.f6228a = view;
    }

    /* access modifiers changed from: private */
    public int a() {
        if (getLayoutPosition() >= this.f6233f.getHeaderLayoutCount()) {
            return getLayoutPosition() - this.f6233f.getHeaderLayoutCount();
        }
        return 0;
    }

    public b a(int i2) {
        this.f6231d.add(Integer.valueOf(i2));
        View c2 = c(i2);
        if (c2 != null) {
            if (!c2.isClickable()) {
                c2.setClickable(true);
            }
            c2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (b.this.f6233f.getOnItemChildClickListener() != null) {
                        b.this.f6233f.getOnItemChildClickListener().a(b.this.f6233f, view, b.this.a());
                    }
                }
            });
        }
        return this;
    }

    public b a(int i2, int i3) {
        ((TextView) c(i2)).setText(i3);
        return this;
    }

    @Deprecated
    public b a(int i2, View.OnClickListener onClickListener) {
        c(i2).setOnClickListener(onClickListener);
        return this;
    }

    public b a(int i2, CharSequence charSequence) {
        ((TextView) c(i2)).setText(charSequence);
        return this;
    }

    public b a(int i2, boolean z2) {
        c(i2).setVisibility(z2 ? 0 : 8);
        return this;
    }

    /* access modifiers changed from: protected */
    public b a(a aVar) {
        this.f6233f = aVar;
        return this;
    }

    public b b(int i2) {
        this.f6232e.add(Integer.valueOf(i2));
        View c2 = c(i2);
        if (c2 != null) {
            if (!c2.isLongClickable()) {
                c2.setLongClickable(true);
            }
            c2.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    return b.this.f6233f.getOnItemChildLongClickListener() != null && b.this.f6233f.getOnItemChildLongClickListener().a(b.this.f6233f, view, b.this.a());
                }
            });
        }
        return this;
    }

    public b b(int i2, int i3) {
        ((ImageView) c(i2)).setImageResource(i3);
        return this;
    }

    public b b(int i2, boolean z2) {
        c(i2).setVisibility(z2 ? 0 : 4);
        return this;
    }

    public <T extends View> T c(int i2) {
        T t2 = (View) this.f6229b.get(i2);
        if (t2 != null) {
            return t2;
        }
        T findViewById = this.itemView.findViewById(i2);
        this.f6229b.put(i2, findViewById);
        return findViewById;
    }

    public b c(int i2, int i3) {
        ((TextView) c(i2)).setTextColor(i3);
        return this;
    }
}
