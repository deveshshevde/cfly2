package com.xeagle.android.vjoystick.fragment;

import android.view.View;
import android.widget.ListView;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.gallery.a;
import com.xeagle.android.vjoystick.gallery.b;
import com.xeagle.android.vjoystick.gallery.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class b extends com.xeagle.android.fragments.a {

    /* renamed from: g  reason: collision with root package name */
    private ListView f25053g;

    /* renamed from: h  reason: collision with root package name */
    private View f25054h;

    /* renamed from: i  reason: collision with root package name */
    private com.xeagle.android.vjoystick.gallery.a f25055i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25056j = false;

    private class a implements Comparator<String> {
        private a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (str != null && str2 != null && str.length() > 0 && str2.length() > 0) {
                try {
                    String substring = str.substring(str.lastIndexOf("_") + 1, str.length() - 4);
                    String substring2 = str2.substring(str2.lastIndexOf("_") + 1, str2.length() - 4);
                    if (substring.length() > 14) {
                        substring = substring.substring(0, 14);
                    }
                    if (substring2.length() > 14) {
                        substring2 = substring2.substring(0, 14);
                    }
                    return Long.parseLong(substring) > Long.parseLong(substring2) ? -1 : 1;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (this.f25055i == null) {
            this.f25055i = new com.xeagle.android.vjoystick.gallery.a(getContext());
        }
        this.f25055i.a((List<List<d>>) list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f25054h.setVisibility(8);
        this.f25055i.a();
        d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        boolean z2 = !this.f25056j;
        this.f25056j = z2;
        this.f25055i.a(z2);
    }

    private void d() {
        ArrayList<String> c2 = com.xeagle.android.vjoystick.utils.d.c(new File(com.xeagle.android.vjoystick.utils.d.a(getContext()) + com.xeagle.android.vjoystick.utils.d.f25366b));
        if (c2 != null) {
            Collections.sort(c2, new a());
            com.xeagle.android.vjoystick.gallery.b.a().a(c2, new b.a() {
                public final void onComplete(List list) {
                    b.this.a(list);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.f25054h.setVisibility(8);
        this.f25055i.b();
        this.f25056j = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f25054h.setVisibility(0);
        this.f25055i.b(true);
    }

    public void a(View view) {
        this.f25053g = (ListView) view.findViewById(R.id.list_video);
        View findViewById = view.findViewById(R.id.include_video_operation_layout);
        this.f25054h = findViewById;
        findViewById.findViewById(R.id.tv_operation_cancel).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.d(view);
            }
        });
        this.f25054h.findViewById(R.id.tv_operation_choose_all).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.c(view);
            }
        });
        this.f25054h.findViewById(R.id.tv_operation_delete).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        com.xeagle.android.vjoystick.gallery.a aVar = new com.xeagle.android.vjoystick.gallery.a(getContext());
        this.f25055i = aVar;
        aVar.a((a.C0158a) new a.C0158a() {
            public final void onLongClick() {
                b.this.e();
            }
        });
        this.f25053g.setAdapter(this.f25055i);
        d();
    }

    public int b() {
        return R.layout.list_video_fragment;
    }

    public void c() {
        d();
        View view = this.f25054h;
        if (view != null) {
            view.setVisibility(8);
        }
        com.xeagle.android.vjoystick.gallery.a aVar = this.f25055i;
        if (aVar != null) {
            aVar.b();
        }
        this.f25056j = false;
    }
}
