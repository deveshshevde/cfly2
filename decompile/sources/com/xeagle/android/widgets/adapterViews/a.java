package com.xeagle.android.widgets.adapterViews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class a<T> extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f25699a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f25700b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private int f25701c;

    /* renamed from: d  reason: collision with root package name */
    private int f25702d;

    /* renamed from: e  reason: collision with root package name */
    private int f25703e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25704f = true;

    /* renamed from: g  reason: collision with root package name */
    private Context f25705g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<T> f25706h;

    /* renamed from: i  reason: collision with root package name */
    private Filter f25707i;

    /* renamed from: j  reason: collision with root package name */
    private LayoutInflater f25708j;

    public a(Context context, int i2, List<T> list) {
        a(context, i2, 0, list);
    }

    private View a(int i2, View view, ViewGroup viewGroup, int i3) {
        if (view == null) {
            view = this.f25708j.inflate(i3, viewGroup, false);
        }
        try {
            int i4 = this.f25703e;
            TextView textView = i4 == 0 ? (TextView) view : (TextView) view.findViewById(i4);
            Object item = getItem(i2);
            textView.setText(item instanceof CharSequence ? (CharSequence) item : item.toString());
            return view;
        } catch (ClassCastException e2) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", e2);
        }
    }

    private void a(Context context, int i2, int i3, List<T> list) {
        this.f25705g = context;
        this.f25708j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f25702d = i2;
        this.f25701c = i2;
        this.f25699a = list;
        this.f25703e = i3;
    }

    /* access modifiers changed from: protected */
    public Filter a(final ArrayList<T> arrayList, final List<T> list) {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                int i2;
                ArrayList arrayList;
                ArrayList arrayList2;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (a.this.f25700b) {
                        arrayList = new ArrayList(arrayList);
                    }
                    filterResults.values = arrayList;
                    i2 = arrayList.size();
                } else {
                    String[] split = charSequence.toString().trim().toLowerCase().split("\\s+");
                    int length = split.length;
                    synchronized (a.this.f25700b) {
                        arrayList2 = new ArrayList(arrayList);
                    }
                    int size = arrayList2.size();
                    ArrayList arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        Object obj = arrayList2.get(i3);
                        String trim = obj.toString().toLowerCase().trim();
                        boolean z2 = true;
                        for (int i4 = 0; i4 < length && z2; i4++) {
                            z2 = trim.contains(split[i4]);
                        }
                        if (z2) {
                            arrayList3.add(obj);
                        }
                    }
                    filterResults.values = arrayList3;
                    i2 = arrayList3.size();
                }
                filterResults.count = i2;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                list.clear();
                list.addAll((List) filterResults.values);
                a.this.notifyDataSetChanged();
            }
        };
    }

    public void a() {
        synchronized (this.f25700b) {
            ArrayList<T> arrayList = this.f25706h;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.f25699a.clear();
            }
        }
        if (this.f25704f) {
            notifyDataSetChanged();
        }
    }

    public void a(T t2) {
        synchronized (this.f25700b) {
            ArrayList<T> arrayList = this.f25706h;
            if (arrayList != null) {
                arrayList.add(t2);
            } else {
                this.f25699a.add(t2);
            }
        }
        if (this.f25704f) {
            notifyDataSetChanged();
        }
    }

    public Context b() {
        return this.f25705g;
    }

    public List<T> c() {
        ArrayList<T> arrayList = this.f25706h;
        return arrayList == null ? this.f25699a : arrayList;
    }

    public int getCount() {
        return this.f25699a.size();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return a(i2, view, viewGroup, this.f25702d);
    }

    public Filter getFilter() {
        if (this.f25707i == null) {
            if (this.f25706h == null) {
                synchronized (this.f25700b) {
                    this.f25706h = new ArrayList<>(this.f25699a);
                }
            }
            this.f25707i = a(this.f25706h, this.f25699a);
        }
        return this.f25707i;
    }

    public T getItem(int i2) {
        return this.f25699a.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        return a(i2, view, viewGroup, this.f25701c);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f25704f = true;
    }
}
