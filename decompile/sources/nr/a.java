package nr;

import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.f;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f13991a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13992b;

    static {
        boolean z2 = false;
        try {
            if (Class.forName("android.util.Log") != null) {
                z2 = true;
            }
        } catch (ClassNotFoundException unused) {
        }
        f13991a = z2;
    }

    public a(String str) {
        this.f13992b = str;
    }

    private int a(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }

    public static boolean a() {
        return f13991a;
    }

    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(a(level), this.f13992b, str);
        }
    }

    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int a2 = a(level);
            String str2 = this.f13992b;
            Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
        }
    }
}
