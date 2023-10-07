package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class z extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f3541a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f3542b = new StringBuilder(128);

    z(String str) {
        this.f3541a = str;
    }

    private void a() {
        if (this.f3542b.length() > 0) {
            Log.d(this.f3541a, this.f3542b.toString());
            StringBuilder sb = this.f3542b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                a();
            } else {
                this.f3542b.append(c2);
            }
        }
    }
}
