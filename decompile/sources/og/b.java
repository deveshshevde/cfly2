package og;

import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.model.ColorSpace;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<ColorSpace, Map<ColorSpace, f>> f31729a = new HashMap();

    public static class a implements f {
        public void a(org.jcodec.common.model.b bVar, org.jcodec.common.model.b bVar2) {
            for (int i2 = 0; i2 < 3; i2++) {
                System.arraycopy(bVar.a(i2), 0, bVar2.a(i2), 0, Math.min(bVar.b(i2) * bVar.c(i2), bVar2.b(i2) * bVar2.c(i2)));
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(ColorSpace.RGB, new a());
        hashMap.put(ColorSpace.YUV420, new d(0, 0));
        hashMap.put(ColorSpace.YUV420J, new c());
        hashMap.put(ColorSpace.YUV422, new e(0, 0));
        hashMap.put(ColorSpace.YUV422_10, new e(2, 0));
        f31729a.put(ColorSpace.RGB, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ColorSpace.YUV420, new a());
        hashMap2.put(ColorSpace.RGB, new i(0, 0));
        hashMap2.put(ColorSpace.YUV422, new j(0, 0));
        hashMap2.put(ColorSpace.YUV422_10, new j(0, 2));
        f31729a.put(ColorSpace.YUV420, hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(ColorSpace.YUV422, new a());
        hashMap3.put(ColorSpace.RGB, new m(0, 0));
        hashMap3.put(ColorSpace.YUV420, new o(0, 0));
        hashMap3.put(ColorSpace.YUV420J, new n(0, 0));
        f31729a.put(ColorSpace.YUV422, hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(ColorSpace.YUV422_10, new a());
        hashMap4.put(ColorSpace.RGB, new m(2, 0));
        hashMap4.put(ColorSpace.YUV420, new o(0, 2));
        hashMap4.put(ColorSpace.YUV420J, new n(0, 2));
        f31729a.put(ColorSpace.YUV422_10, hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(ColorSpace.YUV444, new a());
        hashMap5.put(ColorSpace.RGB, new r(0, 0));
        hashMap5.put(ColorSpace.YUV420, new s(0, 0));
        f31729a.put(ColorSpace.YUV444, hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put(ColorSpace.YUV444_10, new a());
        hashMap6.put(ColorSpace.RGB, new r(2, 0));
        hashMap6.put(ColorSpace.YUV420, new s(0, 2));
        f31729a.put(ColorSpace.YUV444_10, hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put(ColorSpace.YUV420J, new a());
        hashMap7.put(ColorSpace.RGB, new g());
        hashMap7.put(ColorSpace.YUV420, new h());
        f31729a.put(ColorSpace.YUV420J, hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(ColorSpace.YUV422J, new a());
        hashMap8.put(ColorSpace.RGB, new k());
        hashMap8.put(ColorSpace.YUV420, new l());
        hashMap8.put(ColorSpace.YUV420J, new o(0, 0));
        f31729a.put(ColorSpace.YUV422J, hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put(ColorSpace.YUV444J, new a());
        hashMap9.put(ColorSpace.RGB, new p());
        hashMap9.put(ColorSpace.YUV420, new q());
        hashMap9.put(ColorSpace.YUV420J, new s(0, 0));
        f31729a.put(ColorSpace.YUV444J, hashMap9);
    }

    public static f a(ColorSpace colorSpace, ColorSpace colorSpace2) {
        Map map = f31729a.get(colorSpace);
        if (map == null) {
            return null;
        }
        return (f) map.get(colorSpace2);
    }
}
