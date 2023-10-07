package w;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import w.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f34572a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f34573b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f34574c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f34575d;

    /* renamed from: e  reason: collision with root package name */
    protected int f34576e;

    /* renamed from: f  reason: collision with root package name */
    protected C0262a f34577f;

    /* renamed from: g  reason: collision with root package name */
    protected DataSetObserver f34578g;

    /* renamed from: h  reason: collision with root package name */
    protected b f34579h;

    /* renamed from: i  reason: collision with root package name */
    protected FilterQueryProvider f34580i;

    /* renamed from: w.a$a  reason: collision with other inner class name */
    private class C0262a extends ContentObserver {
        C0262a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z2) {
            a.this.b();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a.this.f34572a = true;
            a.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a.this.f34572a = false;
            a.this.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z2) {
        a(context, cursor, z2 ? 1 : 2);
    }

    public Cursor a() {
        return this.f34574c;
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f34580i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f34574c;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    public void a(Context context, Cursor cursor, int i2) {
        b bVar;
        boolean z2 = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f34573b = true;
        } else {
            this.f34573b = false;
        }
        if (cursor != null) {
            z2 = true;
        }
        this.f34574c = cursor;
        this.f34572a = z2;
        this.f34575d = context;
        this.f34576e = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f34577f = new C0262a();
            bVar = new b();
        } else {
            bVar = null;
            this.f34577f = null;
        }
        this.f34578g = bVar;
        if (z2) {
            C0262a aVar = this.f34577f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f34578g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* access modifiers changed from: protected */
    public void b() {
        Cursor cursor;
        if (this.f34573b && (cursor = this.f34574c) != null && !cursor.isClosed()) {
            this.f34572a = this.f34574c.requery();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f34574c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0262a aVar = this.f34577f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f34578g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f34574c = cursor;
        if (cursor != null) {
            C0262a aVar2 = this.f34577f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f34578g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f34576e = cursor.getColumnIndexOrThrow("_id");
            this.f34572a = true;
            notifyDataSetChanged();
        } else {
            this.f34576e = -1;
            this.f34572a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f34572a || (cursor = this.f34574c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f34572a) {
            return null;
        }
        this.f34574c.moveToPosition(i2);
        if (view == null) {
            view = b(this.f34575d, this.f34574c, viewGroup);
        }
        a(view, this.f34575d, this.f34574c);
        return view;
    }

    public Filter getFilter() {
        if (this.f34579h == null) {
            this.f34579h = new b(this);
        }
        return this.f34579h;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f34572a || (cursor = this.f34574c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f34574c;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f34572a || (cursor = this.f34574c) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f34574c.getLong(this.f34576e);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f34572a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f34574c.moveToPosition(i2)) {
            if (view == null) {
                view = a(this.f34575d, this.f34574c, viewGroup);
            }
            a(view, this.f34575d, this.f34574c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
