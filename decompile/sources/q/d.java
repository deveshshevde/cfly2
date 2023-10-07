package q;

import android.util.Base64;
import java.util.List;
import s.f;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f34121a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34122b;

    /* renamed from: c  reason: collision with root package name */
    private final String f34123c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f34124d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34125e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f34126f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f34121a = (String) f.a(str);
        this.f34122b = (String) f.a(str2);
        this.f34123c = (String) f.a(str3);
        this.f34124d = (List) f.a(list);
        this.f34126f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public String a() {
        return this.f34121a;
    }

    public String b() {
        return this.f34122b;
    }

    public String c() {
        return this.f34123c;
    }

    public List<List<byte[]>> d() {
        return this.f34124d;
    }

    public int e() {
        return this.f34125e;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f34126f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f34121a + ", mProviderPackage: " + this.f34122b + ", mQuery: " + this.f34123c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f34124d.size(); i2++) {
            sb.append(" [");
            List list = this.f34124d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f34125e);
        return sb.toString();
    }
}
