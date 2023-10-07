package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public class l {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f2934a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f2935b;

    /* renamed from: c  reason: collision with root package name */
    String f2936c;

    /* renamed from: d  reason: collision with root package name */
    String f2937d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2938e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2939f;

    public Person a() {
        return new Person.Builder().setName(b()).setIcon(c() != null ? c().e() : null).setUri(d()).setKey(e()).setBot(f()).setImportant(g()).build();
    }

    public CharSequence b() {
        return this.f2934a;
    }

    public IconCompat c() {
        return this.f2935b;
    }

    public String d() {
        return this.f2936c;
    }

    public String e() {
        return this.f2937d;
    }

    public boolean f() {
        return this.f2938e;
    }

    public boolean g() {
        return this.f2939f;
    }

    public String h() {
        String str = this.f2936c;
        if (str != null) {
            return str;
        }
        if (this.f2934a == null) {
            return "";
        }
        return "name:" + this.f2934a;
    }
}
