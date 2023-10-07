package nd;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f31392a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31393b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31394c;

    public k(Protocol protocol, int i2, String str) {
        this.f31392a = protocol;
        this.f31393b = i2;
        this.f31394c = str;
    }

    public static k a(String str) throws IOException {
        Protocol protocol;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f31392a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f31393b);
        if (this.f31394c != null) {
            sb.append(' ');
            sb.append(this.f31394c);
        }
        return sb.toString();
    }
}
