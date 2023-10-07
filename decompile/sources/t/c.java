package t;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import s.f;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final ClipData f34480a;

    /* renamed from: b  reason: collision with root package name */
    final int f34481b;

    /* renamed from: c  reason: collision with root package name */
    final int f34482c;

    /* renamed from: d  reason: collision with root package name */
    final Uri f34483d;

    /* renamed from: e  reason: collision with root package name */
    final Bundle f34484e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        ClipData f34485a;

        /* renamed from: b  reason: collision with root package name */
        int f34486b;

        /* renamed from: c  reason: collision with root package name */
        int f34487c;

        /* renamed from: d  reason: collision with root package name */
        Uri f34488d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f34489e;

        public a(ClipData clipData, int i2) {
            this.f34485a = clipData;
            this.f34486b = i2;
        }

        public a a(int i2) {
            this.f34487c = i2;
            return this;
        }

        public a a(Uri uri) {
            this.f34488d = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.f34489e = bundle;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    c(a aVar) {
        this.f34480a = (ClipData) f.a(aVar.f34485a);
        this.f34481b = f.a(aVar.f34486b, 0, 3, "source");
        this.f34482c = f.a(aVar.f34487c, 1);
        this.f34483d = aVar.f34488d;
        this.f34484e = aVar.f34489e;
    }

    static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    static String b(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    public ClipData a() {
        return this.f34480a;
    }

    public int b() {
        return this.f34481b;
    }

    public int c() {
        return this.f34482c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ContentInfoCompat{clip=");
        sb.append(this.f34480a.getDescription());
        sb.append(", source=");
        sb.append(a(this.f34481b));
        sb.append(", flags=");
        sb.append(b(this.f34482c));
        String str2 = "";
        if (this.f34483d == null) {
            str = str2;
        } else {
            str = ", hasLinkUri(" + this.f34483d.toString().length() + ")";
        }
        sb.append(str);
        if (this.f34484e != null) {
            str2 = ", hasExtras";
        }
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
