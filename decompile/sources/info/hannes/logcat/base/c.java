package info.hannes.logcat.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import info.hannes.logcat.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;

public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28654a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private String[] f28655b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f28656c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<String> f28657d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ColorStateList a(Context context, int i2) {
            h.d(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i2});
            h.b(obtainStyledAttributes, "context.obtainStyledAttributes(intArrayOf(attr))");
            try {
                return obtainStyledAttributes.getColorStateList(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f28658a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            h.d(view, Promotion.ACTION_VIEW);
            View findViewById = view.findViewById(R.id.logLine);
            h.b(findViewById, "view.findViewById(R.id.logLine)");
            this.f28658a = (TextView) findViewById;
        }

        public final TextView a() {
            return this.f28658a;
        }
    }

    public c(List<String> list, String str) {
        h.d(list, "completeLogs");
        h.d(str, "filter");
        this.f28657d = list;
        a(str);
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        h.d(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_log, viewGroup, false);
        h.b(inflate, Promotion.ACTION_VIEW);
        return new b(inflate);
    }

    public final List<String> a() {
        return this.f28656c;
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i2) {
        TextView textView;
        int i3;
        h.d(bVar, "holder");
        TextView a2 = bVar.a();
        String str = this.f28656c.get(i2);
        String str2 = str;
        CharSequence charSequence = str2;
        if (f.a(charSequence, (CharSequence) " E: ", false, 2, (Object) null) || f.b(str2, "E: ", false, 2, (Object) null) || f.a(charSequence, (CharSequence) " A: ", false, 2, (Object) null) || f.b(str2, "A: ", false, 2, (Object) null)) {
            bVar.a().setTextColor(-65536);
        } else {
            if (f.a(charSequence, (CharSequence) " I: ", false, 2, (Object) null) || f.b(str2, "I: ", false, 2, (Object) null)) {
                textView = bVar.a();
                i3 = -16777216;
            } else if (f.a(charSequence, (CharSequence) " W: ", false, 2, (Object) null) || f.b(str2, "W: ", false, 2, (Object) null)) {
                textView = bVar.a();
                i3 = -65281;
            } else if (f.a(charSequence, (CharSequence) " V: ", false, 2, (Object) null) || f.b(str2, "V: ", false, 2, (Object) null)) {
                textView = bVar.a();
                i3 = -7829368;
            } else {
                TextView a3 = bVar.a();
                a aVar = f28654a;
                Context context = bVar.a().getContext();
                h.b(context, "holder.logContent.context");
                a3.setTextColor(aVar.a(context, 16842808));
            }
            textView.setTextColor(i3);
        }
        l lVar = l.f30254a;
        a2.setText(str);
    }

    public final void a(String str) {
        h.d(str, "addLine");
        List<String> list = this.f28657d;
        list.add(list.size(), str);
        Collection arrayList = new ArrayList();
        for (Object next : this.f28657d) {
            String str2 = (String) next;
            String[] strArr = this.f28655b;
            boolean z2 = false;
            if (strArr != null) {
                boolean z3 = false;
                for (String str3 : strArr) {
                    if (!z3 && f.a((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        this.f28656c = (List) arrayList;
        notifyDataSetChanged();
    }

    public final void a(List<String> list) {
        h.d(list, "newItems");
        this.f28657d = list;
        String[] strArr = this.f28655b;
        h.a((Object) strArr);
        a((String[]) Arrays.copyOf(strArr, strArr.length));
        notifyDataSetChanged();
    }

    public final void a(String... strArr) {
        h.d(strArr, "filters");
        this.f28655b = strArr;
        List<T> synchronizedList = Collections.synchronizedList(this.f28657d);
        h.b(synchronizedList, "Collections.synchronizedList(completeLogs)");
        Collection arrayList = new ArrayList();
        for (Object next : synchronizedList) {
            String str = (String) next;
            boolean z2 = false;
            for (String str2 : strArr) {
                if (str2.length() != 3 || !h.a((Object) f.c(str2, 2), (Object) ": ")) {
                    if (!z2) {
                        h.b(str, "line");
                        if (!f.a((CharSequence) str, (CharSequence) str2, true)) {
                        }
                    }
                } else {
                    if (!z2) {
                        h.b(str, "line");
                        if (!f.a((CharSequence) str, (CharSequence) str2, false)) {
                        }
                    }
                }
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        this.f28656c = (List) arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f28656c.size();
    }
}
