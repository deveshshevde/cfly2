package androidx.work;

import androidx.work.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger extends h {
    public d a(List<d> list) {
        d.a aVar = new d.a();
        HashMap hashMap = new HashMap();
        for (d a2 : list) {
            hashMap.putAll(a2.a());
        }
        aVar.a((Map<String, Object>) hashMap);
        return aVar.a();
    }
}
