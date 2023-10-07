package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.e;

public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f32239a = new j() {
        public void a(int i2, ErrorCode errorCode) {
        }

        public boolean a(int i2, List<a> list) {
            return true;
        }

        public boolean a(int i2, List<a> list, boolean z2) {
            return true;
        }

        public boolean a(int i2, e eVar, int i3, boolean z2) throws IOException {
            eVar.h((long) i3);
            return true;
        }
    };

    void a(int i2, ErrorCode errorCode);

    boolean a(int i2, List<a> list);

    boolean a(int i2, List<a> list, boolean z2);

    boolean a(int i2, e eVar, int i3, boolean z2) throws IOException;
}
