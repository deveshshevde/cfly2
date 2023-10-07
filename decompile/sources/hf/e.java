package hf;

import com.hoho.android.usb.usb.data_proxy.log.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.h;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f13323a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final String f13324b = "RtspResponseUtils";

    private e() {
    }

    public final int a(String str) {
        h.d(str, "response");
        Matcher matcher = Pattern.compile("RTSP/\\d.\\d (\\d+) (\\w+)", 2).matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                group = "-1";
            }
            return Integer.parseInt(group);
        }
        b.h(f13324b, "status code not found", new Object[0]);
        return -1;
    }
}
