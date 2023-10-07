package ih;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.c;

public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f13555a;

    /* renamed from: b  reason: collision with root package name */
    private int f13556b = 1000;

    public final int a() {
        int i2 = this.f13556b;
        if (i2 < 200) {
            return 200;
        }
        return i2;
    }

    public void a(long j2, long j3, boolean z2) {
    }

    public abstract void a(HttpException httpException, String str);

    public abstract void a(c<T> cVar);

    public final void a(String str) {
        this.f13555a = str;
    }

    public void b() {
    }
}
