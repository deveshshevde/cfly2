package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f32287a = $$Lambda$o$RAFHHJR9a_GFpHVu4GFslSACX4.INSTANCE;

    /* renamed from: okhttp3.o$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ List a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            } else {
                throw new UnknownHostException("hostname == null");
            }
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
