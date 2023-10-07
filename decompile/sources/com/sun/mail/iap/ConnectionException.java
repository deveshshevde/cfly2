package com.sun.mail.iap;

public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;

    /* renamed from: p  reason: collision with root package name */
    private transient Protocol f21755p;

    public ConnectionException() {
    }

    public ConnectionException(Protocol protocol, Response response) {
        super(response);
        this.f21755p = protocol;
    }

    public ConnectionException(String str) {
        super(str);
    }

    public Protocol getProtocol() {
        return this.f21755p;
    }
}
