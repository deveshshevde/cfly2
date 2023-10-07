package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class k {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f11078a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final String f11079b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11080c;

    private class a implements Callable<Boolean> {
        private a() {
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(k.this.b());
        }
    }

    k(String str, int i2) {
        this.f11079b = (String) l.a(str);
        this.f11080c = i2;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: private */
    public boolean b() throws ProxyCacheException {
        i iVar = new i(c());
        try {
            byte[] bytes = "ping ok".getBytes();
            iVar.a(0);
            byte[] bArr = new byte[bytes.length];
            iVar.a(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            f.a("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (ProxyCacheException e2) {
            f.a("Error reading ping response", (Exception) e2);
            return false;
        } finally {
            iVar.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.f11079b, Integer.valueOf(this.f11080c), "ping"});
    }

    /* access modifiers changed from: package-private */
    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3) {
        l.a(i2 >= 1);
        l.a(i3 > 0);
        int i4 = 0;
        while (i4 < i2) {
            try {
                if (((Boolean) this.f11078a.submit(new a()).get((long) i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i4++;
                i3 *= 2;
            } catch (TimeoutException unused) {
                f.b("Error pinging server (attempt: " + i4 + ", timeout: " + i3 + "). ");
            } catch (InterruptedException | ExecutionException e2) {
                f.a("Error pinging server due to unexpected error", e2);
            }
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3 / 2), a()});
        f.a(format, (Exception) new ProxyCacheException(format));
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        return "ping".equals(str);
    }
}
