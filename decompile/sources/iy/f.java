package iy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import iw.a;
import iw.b;
import iw.c;
import iw.d;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    FragmentActivity f29404a;

    /* renamed from: b  reason: collision with root package name */
    Fragment f29405b;

    /* renamed from: c  reason: collision with root package name */
    Dialog f29406c;

    /* renamed from: d  reason: collision with root package name */
    Set<String> f29407d;

    /* renamed from: e  reason: collision with root package name */
    Set<String> f29408e;

    /* renamed from: f  reason: collision with root package name */
    boolean f29409f;

    /* renamed from: g  reason: collision with root package name */
    boolean f29410g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f29411h = false;

    /* renamed from: i  reason: collision with root package name */
    int f29412i = -1;

    /* renamed from: j  reason: collision with root package name */
    int f29413j = -1;

    /* renamed from: k  reason: collision with root package name */
    Set<String> f29414k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    Set<String> f29415l = new HashSet();

    /* renamed from: m  reason: collision with root package name */
    Set<String> f29416m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    Set<String> f29417n = new HashSet();

    /* renamed from: o  reason: collision with root package name */
    Set<String> f29418o = new HashSet();

    /* renamed from: p  reason: collision with root package name */
    d f29419p;

    /* renamed from: q  reason: collision with root package name */
    a f29420q;

    /* renamed from: r  reason: collision with root package name */
    b f29421r;

    /* renamed from: s  reason: collision with root package name */
    c f29422s;

    public f(FragmentActivity fragmentActivity, Fragment fragment, Set<String> set, boolean z2, Set<String> set2) {
        this.f29404a = fragmentActivity;
        this.f29405b = fragment;
        if (fragmentActivity == null && fragment != null) {
            this.f29404a = fragment.getActivity();
        }
        this.f29407d = set;
        this.f29409f = z2;
        this.f29408e = set2;
    }

    /* access modifiers changed from: private */
    public void a(List<String> list) {
        this.f29418o.clear();
        this.f29418o.addAll(list);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f29404a.getPackageName(), (String) null));
        c().startActivityForResult(intent, 2);
    }

    private e c() {
        FragmentManager b2 = b();
        Fragment b3 = b2.b("InvisibleFragment");
        if (b3 != null) {
            return (e) b3;
        }
        e eVar = new e();
        b2.a().a((Fragment) eVar, "InvisibleFragment").f();
        return eVar;
    }

    public f a() {
        this.f29410g = true;
        return this;
    }

    public f a(b bVar) {
        this.f29421r = bVar;
        return this;
    }

    public f a(c cVar) {
        this.f29422s = cVar;
        return this;
    }

    public void a(d dVar) {
        this.f29419p = dVar;
        h hVar = new h();
        hVar.a(new i(this));
        hVar.a(new g(this));
        hVar.a();
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        c().a(this, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(final b bVar, boolean z2, final ix.b bVar2) {
        this.f29411h = true;
        final List<String> c2 = bVar2.c();
        if (c2.isEmpty()) {
            bVar.c();
            return;
        }
        this.f29406c = bVar2;
        bVar2.show();
        View a2 = bVar2.a();
        View b2 = bVar2.b();
        bVar2.setCancelable(false);
        bVar2.setCanceledOnTouchOutside(false);
        a2.setClickable(true);
        final ix.b bVar3 = bVar2;
        final boolean z3 = z2;
        final b bVar4 = bVar;
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bVar3.dismiss();
                if (z3) {
                    bVar4.a(c2);
                } else {
                    f.this.a((List<String>) c2);
                }
            }
        });
        if (b2 != null) {
            b2.setClickable(true);
            b2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    bVar2.dismiss();
                    bVar.c();
                }
            });
        }
        this.f29406c.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.f29406c = null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(Set<String> set, b bVar) {
        c().a(this, set, bVar);
    }

    /* access modifiers changed from: package-private */
    public FragmentManager b() {
        Fragment fragment = this.f29405b;
        return fragment != null ? fragment.getChildFragmentManager() : this.f29404a.getSupportFragmentManager();
    }
}
