package gk;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<com.google.android.gms.signin.internal.a> f28527a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<com.google.android.gms.signin.internal.a> f28528b;

    /* renamed from: c  reason: collision with root package name */
    public static final a.C0118a<com.google.android.gms.signin.internal.a, a> f28529c;

    /* renamed from: d  reason: collision with root package name */
    static final a.C0118a<com.google.android.gms.signin.internal.a, d> f28530d;

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f28531e = new Scope("profile");

    /* renamed from: f  reason: collision with root package name */
    public static final Scope f28532f = new Scope("email");

    /* renamed from: g  reason: collision with root package name */
    public static final a<a> f28533g;

    /* renamed from: h  reason: collision with root package name */
    public static final a<d> f28534h;

    static {
        a.g<com.google.android.gms.signin.internal.a> gVar = new a.g<>();
        f28527a = gVar;
        a.g<com.google.android.gms.signin.internal.a> gVar2 = new a.g<>();
        f28528b = gVar2;
        b bVar = new b();
        f28529c = bVar;
        c cVar = new c();
        f28530d = cVar;
        f28533g = new a<>("SignIn.API", bVar, gVar);
        f28534h = new a<>("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
