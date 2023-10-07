package ih;

import il.b;
import il.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;

public class f {
    /* JADX INFO: finally extract failed */
    public String a(HttpEntity httpEntity, e eVar, String str) throws IOException {
        if (httpEntity == null) {
            return null;
        }
        long j2 = 0;
        long contentLength = httpEntity.getContentLength();
        if (eVar != null && !eVar.a(contentLength, 0, true)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStream content = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content, str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                    j2 += d.a(readLine, str);
                    if (eVar != null && !eVar.a(contentLength, j2, false)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            long j3 = j2;
            if (eVar != null) {
                eVar.a(contentLength, j3, true);
            }
            b.a(content);
            return sb.toString().trim();
        } catch (Throwable th) {
            b.a((Closeable) null);
            throw th;
        }
    }
}
