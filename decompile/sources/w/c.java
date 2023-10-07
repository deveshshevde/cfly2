package w;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f34584j;

    /* renamed from: k  reason: collision with root package name */
    private int f34585k;

    /* renamed from: l  reason: collision with root package name */
    private LayoutInflater f34586l;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f34585k = i2;
        this.f34584j = i2;
        this.f34586l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f34586l.inflate(this.f34584j, viewGroup, false);
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f34586l.inflate(this.f34585k, viewGroup, false);
    }
}
