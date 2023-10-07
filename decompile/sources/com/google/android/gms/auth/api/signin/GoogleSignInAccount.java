package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public static d f17302a = f.c();

    /* renamed from: b  reason: collision with root package name */
    final int f17303b;

    /* renamed from: c  reason: collision with root package name */
    List<Scope> f17304c;

    /* renamed from: d  reason: collision with root package name */
    private String f17305d;

    /* renamed from: e  reason: collision with root package name */
    private String f17306e;

    /* renamed from: f  reason: collision with root package name */
    private String f17307f;

    /* renamed from: g  reason: collision with root package name */
    private String f17308g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f17309h;

    /* renamed from: i  reason: collision with root package name */
    private String f17310i;

    /* renamed from: j  reason: collision with root package name */
    private long f17311j;

    /* renamed from: k  reason: collision with root package name */
    private String f17312k;

    /* renamed from: l  reason: collision with root package name */
    private String f17313l;

    /* renamed from: m  reason: collision with root package name */
    private String f17314m;

    /* renamed from: n  reason: collision with root package name */
    private Set<Scope> f17315n = new HashSet();

    GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f17303b = i2;
        this.f17305d = str;
        this.f17306e = str2;
        this.f17307f = str3;
        this.f17308g = str4;
        this.f17309h = uri;
        this.f17310i = str5;
        this.f17311j = j2;
        this.f17312k = str6;
        this.f17304c = list;
        this.f17313l = str7;
        this.f17314m = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        a2.f17310i = str2;
        return a2;
    }

    public static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l2.longValue(), m.a(str7), new ArrayList((Collection) m.a(set)), str5, str6);
    }

    public Account a() {
        String str = this.f17307f;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public Uri b() {
        return this.f17309h;
    }

    public String c() {
        return this.f17308g;
    }

    public String d() {
        return this.f17307f;
    }

    public String e() {
        return this.f17314m;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f17312k.equals(this.f17312k) && googleSignInAccount.j().equals(j());
    }

    public String f() {
        return this.f17313l;
    }

    public String g() {
        return this.f17305d;
    }

    public String h() {
        return this.f17306e;
    }

    public int hashCode() {
        return ((this.f17312k.hashCode() + 527) * 31) + j().hashCode();
    }

    public String i() {
        return this.f17310i;
    }

    public Set<Scope> j() {
        HashSet hashSet = new HashSet(this.f17304c);
        hashSet.addAll(this.f17315n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17303b);
        a.a(parcel, 2, g(), false);
        a.a(parcel, 3, h(), false);
        a.a(parcel, 4, d(), false);
        a.a(parcel, 5, c(), false);
        a.a(parcel, 6, (Parcelable) b(), i2, false);
        a.a(parcel, 7, i(), false);
        a.a(parcel, 8, this.f17311j);
        a.a(parcel, 9, this.f17312k, false);
        a.c(parcel, 10, this.f17304c, false);
        a.a(parcel, 11, f(), false);
        a.a(parcel, 12, e(), false);
        a.a(parcel, a2);
    }
}
