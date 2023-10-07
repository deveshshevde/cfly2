package okhttp3;

import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: g  reason: collision with root package name */
    private final String f31805g;

    private Protocol(String str) {
        this.f31805g = str;
    }

    public static Protocol a(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.f31805g)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.f31805g)) {
            return protocol2;
        }
        Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.f31805g)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.f31805g)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.f31805g)) {
            return protocol5;
        }
        Protocol protocol6 = QUIC;
        if (str.equals(protocol6.f31805g)) {
            return protocol6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f31805g;
    }
}
