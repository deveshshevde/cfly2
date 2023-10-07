package com.xeagle.android.widgets.spinnerWheel;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26070a = "com.xeagle.android.widgets.spinnerWheel.f";

    /* renamed from: b  reason: collision with root package name */
    private List<View> f26071b;

    /* renamed from: c  reason: collision with root package name */
    private List<View> f26072c;

    /* renamed from: d  reason: collision with root package name */
    private AbstractWheel f26073d;

    public f(AbstractWheel abstractWheel) {
        this.f26073d = abstractWheel;
    }

    private View a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = list.get(0);
        list.remove(0);
        return view;
    }

    private List<View> a(View view, List<View> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(view);
        return list;
    }

    private void a(View view, int i2) {
        int a2 = this.f26073d.getViewAdapter().a();
        if ((i2 < 0 || i2 >= a2) && !this.f26073d.g()) {
            this.f26072c = a(view, this.f26072c);
            return;
        }
        while (i2 < 0) {
            i2 += a2;
        }
        int i3 = i2 % a2;
        this.f26071b = a(view, this.f26071b);
    }

    public int a(LinearLayout linearLayout, int i2, a aVar) {
        int i3 = i2;
        int i4 = 0;
        while (i4 < linearLayout.getChildCount()) {
            if (!aVar.a(i3)) {
                a(linearLayout.getChildAt(i4), i3);
                linearLayout.removeViewAt(i4);
                if (i4 == 0) {
                    i2++;
                }
            } else {
                i4++;
            }
            i3++;
        }
        return i2;
    }

    public View a() {
        return a(this.f26071b);
    }

    public View b() {
        return a(this.f26072c);
    }

    public void c() {
        List<View> list = this.f26071b;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.f26072c;
        if (list2 != null) {
            list2.clear();
        }
    }
}
