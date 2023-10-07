package nb;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.internal.http2.a;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okio.ByteString;
import okio.e;
import okio.l;
import okio.r;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f31313a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f31314b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final s f31315c = s.a(new String[0]);

    /* renamed from: d  reason: collision with root package name */
    public static final ac f31316d;

    /* renamed from: e  reason: collision with root package name */
    public static final aa f31317e;

    /* renamed from: f  reason: collision with root package name */
    public static final TimeZone f31318f = TimeZone.getTimeZone("GMT");

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<String> f31319g = $$Lambda$Ds7dtVnGrflEw4LvNOxA0cDT4Y.INSTANCE;

    /* renamed from: h  reason: collision with root package name */
    private static final l f31320h = l.a(ByteString.b("efbbbf"), ByteString.b("feff"), ByteString.b("fffe"), ByteString.b("0000ffff"), ByteString.b("ffff0000"));

    /* renamed from: i  reason: collision with root package name */
    private static final Charset f31321i = Charset.forName("UTF-32BE");

    /* renamed from: j  reason: collision with root package name */
    private static final Charset f31322j = Charset.forName("UTF-32LE");

    /* renamed from: k  reason: collision with root package name */
    private static final Method f31323k;

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f31324l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        f31313a = bArr;
        Method method = null;
        f31316d = ac.create((v) null, bArr);
        f31317e = aa.create((v) null, bArr);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f31323k = method;
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 >= 0) {
            Objects.requireNonNull(timeUnit, "unit == null");
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || j2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new IllegalArgumentException(str + " < 0");
        }
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String a(String str) {
        if (str.contains(":")) {
            InetAddress d2 = (!str.startsWith("[") || !str.endsWith("]")) ? d(str, 0, str.length()) : d(str, 1, str.length() - 1);
            if (d2 == null) {
                return null;
            }
            byte[] address = d2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            if (address.length == 4) {
                return d2.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !d(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String a(t tVar, boolean z2) {
        String str;
        if (tVar.f().contains(":")) {
            str = "[" + tVar.f() + "]";
        } else {
            str = tVar.f();
        }
        if (!z2 && tVar.g() == t.a(tVar.b())) {
            return str;
        }
        return str + ":" + tVar.g();
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        okio.c cVar = new okio.c();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                cVar.i(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.i(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.i(58);
                }
                cVar.k((long) (((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                i2 += 2;
            }
        }
        return cVar.p();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread a(String str, boolean z2, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z2);
        return thread;
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        int a2 = eVar.a(f31320h);
        if (a2 == -1) {
            return charset;
        }
        if (a2 == 0) {
            return StandardCharsets.UTF_8;
        }
        if (a2 == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (a2 == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (a2 == 3) {
            return f31321i;
        }
        if (a2 == 4) {
            return f31322j;
        }
        throw new AssertionError();
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List<a> a(s sVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sVar.a(); i2++) {
            arrayList.add(new a(sVar.a(i2), sVar.b(i2)));
        }
        return arrayList;
    }

    @SafeVarargs
    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String str, boolean z2) {
        return new ThreadFactory(str, z2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Thread newThread(Runnable runnable) {
                return c.a(this.f$0, this.f$1, runnable);
            }
        };
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f31323k;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    public static boolean a(t tVar, t tVar2) {
        return tVar.f().equals(tVar2.f()) && tVar.g() == tVar2.g() && tVar.b().equals(tVar2.b());
    }

    public static boolean a(r rVar, int i2, TimeUnit timeUnit) {
        try {
            return b(rVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static s b(List<a> list) {
        s.a aVar = new s.a();
        for (a next : list) {
            a.f31311a.a(aVar, next.f32081g.a(), next.f32082h.a());
        }
        return aVar.a();
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(r rVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d2 = rVar.timeout().B_() ? rVar.timeout().d() - nanoTime : Long.MAX_VALUE;
        rVar.timeout().a(Math.min(d2, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            okio.c cVar = new okio.c();
            while (rVar.read(cVar, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1) {
                cVar.s();
            }
            int i3 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            okio.s timeout = rVar.timeout();
            if (i3 == 0) {
                timeout.f();
            } else {
                timeout.a(nanoTime + d2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i4 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            okio.s timeout2 = rVar.timeout();
            if (i4 == 0) {
                timeout2.f();
            } else {
                timeout2.a(nanoTime + d2);
            }
            return false;
        } catch (Throwable th) {
            int i5 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            okio.s timeout3 = rVar.timeout();
            if (i5 == 0) {
                timeout3.f();
            } else {
                timeout3.a(nanoTime + d2);
            }
            throw th;
        }
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static boolean c(String str) {
        return f31324l.matcher(str).matches();
    }

    private static InetAddress d(String str, int i2, int i3) {
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= i3) {
                break;
            } else if (i4 == 16) {
                return null;
            } else {
                int i7 = i2 + 2;
                if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                    if (i4 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i6, i3, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i2;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    i5 = i4;
                    if (i7 == i3) {
                        break;
                    }
                    i6 = i7;
                }
                i2 = i6;
                int i8 = 0;
                while (i2 < i3) {
                    int a2 = a(str.charAt(i2));
                    if (a2 == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + a2;
                    i2++;
                }
                int i9 = i2 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
