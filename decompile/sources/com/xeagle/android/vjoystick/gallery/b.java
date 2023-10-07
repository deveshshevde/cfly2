package com.xeagle.android.vjoystick.gallery;

import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f25309a;

    public interface a {
        void onComplete(List<List<d>> list);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f25309a == null) {
                f25309a = new b();
            }
            bVar = f25309a;
        }
        return bVar;
    }

    public void a(List<String> list, a aVar) {
        String str = null;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            ArrayList arrayList2 = null;
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = list.get(i2);
                try {
                    int lastIndexOf = str2.lastIndexOf("_");
                    if (lastIndexOf != -1) {
                        int i3 = lastIndexOf + 9;
                        if (str2.length() >= i3) {
                            String substring = str2.substring(lastIndexOf + 1, i3);
                            if (substring.equals(str)) {
                                arrayList2.add(new d(str2.toLowerCase()));
                            } else {
                                ArrayList arrayList3 = new ArrayList();
                                try {
                                    arrayList.add(arrayList3);
                                    arrayList3.add(new d(str2.toLowerCase()));
                                    str = substring;
                                    arrayList2 = arrayList3;
                                } catch (Exception e2) {
                                    e = e2;
                                    arrayList2 = arrayList3;
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
            }
            aVar.onComplete(arrayList);
            list.clear();
        } else if (aVar != null) {
            aVar.onComplete((List<List<d>>) null);
        }
    }
}
