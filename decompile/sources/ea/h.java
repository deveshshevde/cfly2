package ea;

import android.content.Context;
import com.MAVLink.common.msg_rc_channels_override;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class h {
    private static void a(FileOutputStream fileOutputStream) throws IOException {
        fileOutputStream.write(String.format(Locale.ENGLISH, "RECORD\n", new Object[0]).getBytes());
    }

    private static void a(FileOutputStream fileOutputStream, List<msg_rc_channels_override> list) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            msg_rc_channels_override msg_rc_channels_override = list.get(i2);
            fileOutputStream.write(String.format(Locale.ENGLISH, "%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n", new Object[]{Short.valueOf(msg_rc_channels_override.f7095d), Short.valueOf(msg_rc_channels_override.f7096e), Short.valueOf(msg_rc_channels_override.f7097f), Short.valueOf(msg_rc_channels_override.f7098g), Short.valueOf(msg_rc_channels_override.f7099h), Short.valueOf(msg_rc_channels_override.f7100i), Short.valueOf(msg_rc_channels_override.f7101j), Short.valueOf(msg_rc_channels_override.f7102k)}).getBytes());
        }
    }

    public static boolean a(Context context, List<msg_rc_channels_override> list, String str) {
        try {
            if (!c.a()) {
                return false;
            }
            if (!str.endsWith(".rec")) {
                str = str + ".rec";
            }
            FileOutputStream a2 = d.a(context, str);
            a(a2);
            a(a2, list);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
