package il;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

public class d {
    public static long a(String str, String str2) throws UnsupportedEncodingException {
        long j2 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        if (length < 100) {
            return (long) str.getBytes(str2).length;
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 100;
            j2 += (long) a(str, i2, i3 < length ? i3 : length).getBytes(str2).length;
            i2 = i3;
        }
        return j2;
    }

    public static StackTraceElement a() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x001f
            java.lang.String r1 = "com.android.internal.R$string"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "web_user_agent"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x001e }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001e }
            int r1 = r1.intValue()     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r4.getString(r1)     // Catch:{ all -> 0x001e }
            goto L_0x001f
        L_0x001e:
        L_0x001f:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x0027
            java.lang.String r0 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1"
        L_0x0027:
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            java.lang.String r2 = "1.0"
        L_0x003b:
            r1.append(r2)
            java.lang.String r2 = "; "
            r1.append(r2)
            java.lang.String r3 = r4.getLanguage()
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = r3.toLowerCase()
            r1.append(r3)
            java.lang.String r4 = r4.getCountry()
            if (r4 == 0) goto L_0x0065
            java.lang.String r3 = "-"
            r1.append(r3)
            java.lang.String r4 = r4.toLowerCase()
            goto L_0x0062
        L_0x0060:
            java.lang.String r4 = "en"
        L_0x0062:
            r1.append(r4)
        L_0x0065:
            java.lang.String r4 = android.os.Build.VERSION.CODENAME
            java.lang.String r3 = "REL"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x007d
            java.lang.String r4 = android.os.Build.MODEL
            int r3 = r4.length()
            if (r3 <= 0) goto L_0x007d
            r1.append(r2)
            r1.append(r4)
        L_0x007d:
            java.lang.String r4 = android.os.Build.ID
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x008d
            java.lang.String r2 = " Build/"
            r1.append(r2)
            r1.append(r4)
        L_0x008d:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r2 = 0
            r4[r2] = r1
            r1 = 1
            java.lang.String r2 = "Mobile "
            r4[r1] = r2
            java.lang.String r4 = java.lang.String.format(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: il.d.a(android.content.Context):java.lang.String");
    }

    public static String a(String str, int i2, int i3) {
        return new String(str.substring(i2, i3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[SYNTHETIC, Splitter:B:14:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.charset.Charset a(org.apache.http.client.methods.HttpRequestBase r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "Content-Type"
            org.apache.http.Header r6 = r6.getFirstHeader(r1)
            r1 = 0
            if (r6 == 0) goto L_0x0028
            org.apache.http.HeaderElement[] r6 = r6.getElements()
            int r2 = r6.length
            r3 = 0
        L_0x0013:
            if (r3 < r2) goto L_0x0016
            goto L_0x0028
        L_0x0016:
            r4 = r6[r3]
            java.lang.String r5 = "charset"
            org.apache.http.NameValuePair r4 = r4.getParameterByName(r5)
            if (r4 == 0) goto L_0x0025
            java.lang.String r6 = r4.getValue()
            goto L_0x0029
        L_0x0025:
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0028:
            r6 = r0
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 != 0) goto L_0x0035
            boolean r1 = java.nio.charset.Charset.isSupported(r6)     // Catch:{ all -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r1 == 0) goto L_0x003b
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r6)
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: il.d.a(org.apache.http.client.methods.HttpRequestBase):java.nio.charset.Charset");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r3 = r3.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(org.apache.http.HttpResponse r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "Accept-Ranges"
            org.apache.http.Header r1 = r3.getFirstHeader(r1)
            java.lang.String r2 = "bytes"
            if (r1 == 0) goto L_0x0017
            java.lang.String r3 = r1.getValue()
            boolean r3 = r2.equals(r3)
            return r3
        L_0x0017:
            java.lang.String r1 = "Content-Range"
            org.apache.http.Header r3 = r3.getFirstHeader(r1)
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = r3.getValue()
            if (r3 == 0) goto L_0x002d
            boolean r3 = r3.startsWith(r2)
            if (r3 == 0) goto L_0x002d
            r3 = 1
            return r3
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: il.d.a(org.apache.http.HttpResponse):boolean");
    }

    public static String b(HttpResponse httpResponse) {
        Header firstHeader;
        if (httpResponse == null || (firstHeader = httpResponse.getFirstHeader("Content-Disposition")) == null) {
            return null;
        }
        for (HeaderElement parameterByName : firstHeader.getElements()) {
            NameValuePair parameterByName2 = parameterByName.getParameterByName("filename");
            if (parameterByName2 != null) {
                String value = parameterByName2.getValue();
                return a.a(value, "UTF-8", value.length());
            }
        }
        return null;
    }
}
