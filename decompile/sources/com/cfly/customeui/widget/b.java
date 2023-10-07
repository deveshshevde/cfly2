package com.cfly.customeui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cfly.customeui.R;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f10670a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f10671b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<a> f10672c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f10673d;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f10675b;

        /* renamed from: c  reason: collision with root package name */
        private View f10676c;

        public a(String str, View view) {
            this.f10675b = str;
            this.f10676c = view;
        }

        public String a() {
            return this.f10675b;
        }

        public void run() {
            b.this.f10671b.removeView(this.f10676c);
            if (this.f10675b.equals(b.this.f10673d)) {
                String unused = b.this.f10673d = null;
            }
            synchronized (b.this.f10672c) {
                b.this.f10672c.remove(this);
            }
        }
    }

    public b(Context context, LinearLayout linearLayout) {
        this.f10670a = context;
        this.f10671b = linearLayout;
    }

    public void a(String str) {
        if (str != null) {
            String str2 = this.f10673d;
            if (str2 == null || !str2.equals(str)) {
                synchronized (this.f10672c) {
                    for (a a2 : this.f10672c) {
                        if (a2.a().equals(str)) {
                            return;
                        }
                    }
                    View inflate = View.inflate(this.f10670a, R.layout.toast_view_layout, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
                    this.f10671b.addView(inflate, 0);
                    a aVar = new a(str, inflate);
                    synchronized (this.f10672c) {
                        this.f10672c.add(aVar);
                    }
                    this.f10671b.postDelayed(aVar, 4000);
                    this.f10673d = str;
                }
            }
        }
    }
}
