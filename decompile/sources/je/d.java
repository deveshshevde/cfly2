package je;

import com.shuyu.gsyvideoplayer.utils.Debuger;
import db.b;
import java.util.HashMap;
import java.util.Map;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f29492a = new HashMap();

    public Map<String, String> a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("****** proxy addHeaders ****** ");
        Map<String, String> map = f29492a;
        sb.append(map.size());
        Debuger.printfLog(sb.toString());
        return map;
    }
}
