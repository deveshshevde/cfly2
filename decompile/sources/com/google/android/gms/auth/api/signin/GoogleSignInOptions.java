package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.f, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public static final GoogleSignInOptions f17316a;

    /* renamed from: b  reason: collision with root package name */
    public static final GoogleSignInOptions f17317b;

    /* renamed from: c  reason: collision with root package name */
    public static final Scope f17318c = new Scope("profile");

    /* renamed from: d  reason: collision with root package name */
    public static final Scope f17319d = new Scope("email");

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f17320e = new Scope("openid");

    /* renamed from: f  reason: collision with root package name */
    public static final Scope f17321f;

    /* renamed from: g  reason: collision with root package name */
    public static final Scope f17322g = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: j  reason: collision with root package name */
    private static Comparator<Scope> f17323j = new b();

    /* renamed from: h  reason: collision with root package name */
    final int f17324h;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<Scope> f17325k;

    /* renamed from: l  reason: collision with root package name */
    private Account f17326l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17327m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f17328n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f17329o;

    /* renamed from: p  reason: collision with root package name */
    private String f17330p;

    /* renamed from: q  reason: collision with root package name */
    private String f17331q;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<GoogleSignInOptionsExtensionParcelable> f17332r;

    /* renamed from: s  reason: collision with root package name */
    private String f17333s;

    /* renamed from: t  reason: collision with root package name */
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> f17334t;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set<Scope> f17335a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f17336b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17337c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f17338d;

        /* renamed from: e  reason: collision with root package name */
        private String f17339e;

        /* renamed from: f  reason: collision with root package name */
        private Account f17340f;

        /* renamed from: g  reason: collision with root package name */
        private String f17341g;

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f17342h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private String f17343i;

        public a a() {
            this.f17335a.add(GoogleSignInOptions.f17320e);
            return this;
        }

        public a a(Scope scope, Scope... scopeArr) {
            this.f17335a.add(scope);
            this.f17335a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a b() {
            this.f17335a.add(GoogleSignInOptions.f17318c);
            return this;
        }

        public GoogleSignInOptions c() {
            if (this.f17335a.contains(GoogleSignInOptions.f17322g) && this.f17335a.contains(GoogleSignInOptions.f17321f)) {
                this.f17335a.remove(GoogleSignInOptions.f17321f);
            }
            if (this.f17338d && (this.f17340f == null || !this.f17335a.isEmpty())) {
                a();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f17335a), this.f17340f, this.f17338d, this.f17336b, this.f17337c, this.f17339e, this.f17341g, this.f17342h, this.f17343i, (c) null);
        }
    }

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f17321f = scope;
        a aVar = new a();
        aVar.a();
        aVar.b();
        f17316a = aVar.c();
        a aVar2 = new a();
        aVar2.a(scope, new Scope[0]);
        f17317b = aVar2.c();
    }

    GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z2, boolean z3, boolean z4, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String str3) {
        this(i2, arrayList, account, z2, z3, z4, str, str2, a(arrayList2), str3);
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z2, boolean z3, boolean z4, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.f17324h = i2;
        this.f17325k = arrayList;
        this.f17326l = account;
        this.f17327m = z2;
        this.f17328n = z3;
        this.f17329o = z4;
        this.f17330p = str;
        this.f17331q = str2;
        this.f17332r = new ArrayList<>(map.values());
        this.f17334t = map;
        this.f17333s = str3;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z2, boolean z3, boolean z4, String str, String str2, Map map, String str3, c cVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z2, z3, z4, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> a(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.a()), next);
        }
        return hashMap;
    }

    public Account a() {
        return this.f17326l;
    }

    public String b() {
        return this.f17333s;
    }

    public String c() {
        return this.f17330p;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> d() {
        return this.f17332r;
    }

    public ArrayList<Scope> e() {
        return new ArrayList<>(this.f17325k);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.a()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.f17332r     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 > 0) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.f17332r     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f17325k     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.e()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f17325k     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.e()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.f17326l     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.a()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.a()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.f17330p     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.f17330p     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.f17329o     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.f()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f17327m     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.g()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f17328n     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.h()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.f17333s     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.b()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public boolean f() {
        return this.f17329o;
    }

    public boolean g() {
        return this.f17327m;
    }

    public boolean h() {
        return this.f17328n;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f17325k;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(arrayList2.get(i2).a());
        }
        Collections.sort(arrayList);
        com.google.android.gms.auth.api.signin.internal.a aVar = new com.google.android.gms.auth.api.signin.internal.a();
        aVar.a((Object) arrayList);
        aVar.a((Object) this.f17326l);
        aVar.a((Object) this.f17330p);
        aVar.a(this.f17329o);
        aVar.a(this.f17327m);
        aVar.a(this.f17328n);
        aVar.a((Object) this.f17333s);
        return aVar.a();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 1, this.f17324h);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 2, e(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, (Parcelable) a(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, g());
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 5, h());
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 6, f());
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 7, c(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 8, this.f17331q, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, d(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 10, b(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
    }
}
