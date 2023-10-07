package fu;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f28133a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f28134b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28135c;

    /* renamed from: d  reason: collision with root package name */
    public final String f28136d;

    public String a() {
        String str = this.f28135c;
        String str2 = this.f28136d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }
}
