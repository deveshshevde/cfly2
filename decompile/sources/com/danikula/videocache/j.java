package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

class j extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Proxy> f11074a = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});

    /* renamed from: b  reason: collision with root package name */
    private final ProxySelector f11075b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11076c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11077d;

    j(ProxySelector proxySelector, String str, int i2) {
        this.f11075b = (ProxySelector) l.a(proxySelector);
        this.f11076c = (String) l.a(str);
        this.f11077d = i2;
    }

    static void a(String str, int i2) {
        ProxySelector.setDefault(new j(ProxySelector.getDefault(), str, i2));
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f11075b.connectFailed(uri, socketAddress, iOException);
    }

    public List<Proxy> select(URI uri) {
        return this.f11076c.equals(uri.getHost()) && this.f11077d == uri.getPort() ? f11074a : this.f11075b.select(uri);
    }
}
