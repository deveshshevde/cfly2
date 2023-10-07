package ea;

import android.content.Context;
import android.widget.Toast;
import com.MAVLink.common.msg_rc_channels_override;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private List<msg_rc_channels_override> f26845a = new ArrayList();

    private void a(BufferedReader bufferedReader) throws IOException {
        this.f26845a.clear();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\t");
                msg_rc_channels_override msg_rc_channels_override = new msg_rc_channels_override();
                msg_rc_channels_override.f7095d = Short.parseShort(split[0]);
                msg_rc_channels_override.f7096e = Short.parseShort(split[1]);
                msg_rc_channels_override.f7097f = Short.parseShort(split[2]);
                msg_rc_channels_override.f7098g = Short.parseShort(split[3]);
                msg_rc_channels_override.f7099h = Short.parseShort(split[4]);
                msg_rc_channels_override.f7100i = Short.parseShort(split[5]);
                msg_rc_channels_override.f7101j = Short.parseShort(split[6]);
                msg_rc_channels_override.f7102k = Short.parseShort(split[7]);
                msg_rc_channels_override.f7105n = -1;
                msg_rc_channels_override.f7106o = 1;
                this.f26845a.add(msg_rc_channels_override);
            } else {
                return;
            }
        }
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().contains("RECORD");
    }

    public String a(Context context) {
        return a.b(context);
    }

    public List<msg_rc_channels_override> a() {
        return this.f26845a;
    }

    public boolean a(Context context, String str) {
        if (!c.a()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(a(context) + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            if (!b(bufferedReader)) {
                Toast.makeText(context, "文件内容出错！", 1).show();
                fileInputStream.close();
                return false;
            }
            a(bufferedReader);
            fileInputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> b(Context context) {
        return (ArrayList) Arrays.asList(b.a(context));
    }
}
