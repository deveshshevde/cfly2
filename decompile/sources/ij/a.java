package ij;

import com.lidroid.xutils.http.client.multipart.f;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected f.a f13565a = f.a.f21114a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13566b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13567c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13568d;

    public a(String str) {
        String str2;
        if (str != null) {
            this.f13566b = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                this.f13567c = str.substring(0, indexOf);
                str2 = str.substring(indexOf + 1);
            } else {
                this.f13567c = str;
                str2 = null;
            }
            this.f13568d = str2;
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }

    public String a() {
        return this.f13566b;
    }

    public void a(f.a aVar) {
        this.f13565a = aVar;
    }
}
