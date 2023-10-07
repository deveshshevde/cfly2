package com.xeagle.android.vjoystick.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import androidx.lifecycle.t;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.xeagle.R;
import com.xeagle.android.vjoystick.gallery.a;
import com.xeagle.android.vjoystick.gallery.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.h;

public final class a extends com.xeagle.android.fragments.a {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.xeagle.android.vjoystick.gallery.a f25042g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f25043h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f25044i;

    /* renamed from: com.xeagle.android.vjoystick.fragment.a$a  reason: collision with other inner class name */
    private final class C0153a implements Comparator<String> {
        public C0153a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                CharSequence charSequence2 = str2;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    try {
                        int b2 = kotlin.text.f.b((CharSequence) str, "_", 0, false, 6, (Object) null) + 1;
                        int length = str.length() - 4;
                        if (str != null) {
                            String substring = str.substring(b2, length);
                            h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            int b3 = kotlin.text.f.b((CharSequence) str2, "_", 0, false, 6, (Object) null) + 1;
                            int length2 = str2.length() - 4;
                            if (str2 != null) {
                                String substring2 = str2.substring(b3, length2);
                                h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (substring.length() > 14) {
                                    if (substring != null) {
                                        substring = substring.substring(0, 14);
                                        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                }
                                if (substring2.length() > 14) {
                                    if (substring2 != null) {
                                        substring2 = substring2.substring(0, 14);
                                        h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                }
                                return Long.parseLong(substring) > Long.parseLong(substring2) ? -1 : 1;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return 0;
        }
    }

    public static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25047b;

        b(a aVar, Ref.ObjectRef objectRef) {
            this.f25046a = aVar;
            this.f25047b = objectRef;
        }

        public void onComplete(List<List<com.xeagle.android.vjoystick.gallery.d>> list) {
            if (this.f25046a.getActivity() != null && ((ArrayList) this.f25047b.f30237a) != null) {
                if (this.f25046a.f25042g == null) {
                    this.f25046a.f25042g = new com.xeagle.android.vjoystick.gallery.a(this.f25046a.getContext());
                }
                com.xeagle.android.vjoystick.gallery.a a2 = this.f25046a.f25042g;
                if (a2 != null) {
                    a2.a(list);
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25048a;

        c(a aVar) {
            this.f25048a = aVar;
        }

        public final void onClick(View view) {
            View a2 = this.f25048a.a(R.id.include_photo_operation_layout);
            h.b(a2, "include_photo_operation_layout");
            a2.setVisibility(8);
            com.xeagle.android.vjoystick.gallery.a a3 = this.f25048a.f25042g;
            h.a((Object) a3);
            a3.b();
            this.f25048a.f25043h = false;
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25049a;

        d(a aVar) {
            this.f25049a = aVar;
        }

        public final void onClick(View view) {
            a aVar = this.f25049a;
            aVar.f25043h = !aVar.f25043h;
            com.xeagle.android.vjoystick.gallery.a a2 = this.f25049a.f25042g;
            h.a((Object) a2);
            a2.a(this.f25049a.f25043h);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25050a;

        e(a aVar) {
            this.f25050a = aVar;
        }

        public final void onClick(View view) {
            View a2 = this.f25050a.a(R.id.include_photo_operation_layout);
            h.b(a2, "include_photo_operation_layout");
            a2.setVisibility(8);
            com.xeagle.android.vjoystick.gallery.a a3 = this.f25050a.f25042g;
            h.a((Object) a3);
            a3.a();
            this.f25050a.e();
        }
    }

    static final class f implements a.C0158a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25051a;

        f(a aVar) {
            this.f25051a = aVar;
        }

        public final void onLongClick() {
            View a2 = this.f25051a.a(R.id.include_photo_operation_layout);
            h.b(a2, "include_photo_operation_layout");
            a2.setVisibility(0);
            com.xeagle.android.vjoystick.gallery.a a3 = this.f25051a.f25042g;
            h.a((Object) a3);
            a3.b(true);
        }
    }

    static final class g<T> implements t<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25052a;

        g(a aVar) {
            this.f25052a = aVar;
        }

        public final void onChanged(Object obj) {
            this.f25052a.e();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f30237a = new ArrayList();
        if (this.f12544e != null) {
            List a2 = com.xeagle.android.vjoystick.utils.d.a(new File(com.xeagle.android.vjoystick.utils.d.a((Context) this.f12544e) + com.xeagle.android.vjoystick.utils.d.f25365a));
            Collections.sort(a2, new C0153a());
            com.xeagle.android.vjoystick.gallery.b.a().a(a2, new b(this, objectRef));
        }
    }

    public View a(int i2) {
        if (this.f25044i == null) {
            this.f25044i = new HashMap();
        }
        View view = (View) this.f25044i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f25044i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a(View view) {
        h.d(view, Promotion.ACTION_VIEW);
        a(R.id.include_photo_operation_layout).findViewById(com.cfly.uav_pro.R.id.tv_operation_cancel).setOnClickListener(new c(this));
        a(R.id.include_photo_operation_layout).findViewById(com.cfly.uav_pro.R.id.tv_operation_choose_all).setOnClickListener(new d(this));
        a(R.id.include_photo_operation_layout).findViewById(com.cfly.uav_pro.R.id.tv_operation_delete).setOnClickListener(new e(this));
        com.xeagle.android.vjoystick.gallery.a aVar = new com.xeagle.android.vjoystick.gallery.a(getContext());
        this.f25042g = aVar;
        h.a((Object) aVar);
        aVar.a((a.C0158a) new f(this));
        ListView listView = (ListView) a(R.id.list_photo);
        h.b(listView, "list_photo");
        listView.setAdapter(this.f25042g);
        e();
        ha.b.a().a("notify_photo").b(this, new g(this));
    }

    public int b() {
        return com.cfly.uav_pro.R.layout.list_photo_fragment;
    }

    public void c() {
        e();
        View a2 = a(R.id.include_photo_operation_layout);
        if (a2 != null) {
            a2.setVisibility(8);
        }
        com.xeagle.android.vjoystick.gallery.a aVar = this.f25042g;
        if (aVar != null) {
            aVar.b();
        }
        this.f25043h = false;
    }

    public void d() {
        HashMap hashMap = this.f25044i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }
}
