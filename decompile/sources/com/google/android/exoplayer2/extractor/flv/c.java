package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import fg.i;
import fj.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private long f15504b = -9223372036854775807L;

    public c() {
        super(new f());
    }

    private static Object a(q qVar, int i2) {
        if (i2 == 0) {
            return d(qVar);
        }
        if (i2 == 1) {
            return c(qVar);
        }
        if (i2 == 2) {
            return e(qVar);
        }
        if (i2 == 3) {
            return g(qVar);
        }
        if (i2 == 8) {
            return h(qVar);
        }
        if (i2 == 10) {
            return f(qVar);
        }
        if (i2 != 11) {
            return null;
        }
        return i(qVar);
    }

    private static int b(q qVar) {
        return qVar.h();
    }

    private static Boolean c(q qVar) {
        boolean z2 = true;
        if (qVar.h() != 1) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    private static Double d(q qVar) {
        return Double.valueOf(Double.longBitsToDouble(qVar.r()));
    }

    private static String e(q qVar) {
        int i2 = qVar.i();
        int d2 = qVar.d();
        qVar.d(i2);
        return new String(qVar.f17159a, d2, i2);
    }

    private static ArrayList<Object> f(q qVar) {
        int v2 = qVar.v();
        ArrayList<Object> arrayList = new ArrayList<>(v2);
        for (int i2 = 0; i2 < v2; i2++) {
            Object a2 = a(qVar, b(qVar));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(q qVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e2 = e(qVar);
            int b2 = b(qVar);
            if (b2 == 9) {
                return hashMap;
            }
            Object a2 = a(qVar, b2);
            if (a2 != null) {
                hashMap.put(e2, a2);
            }
        }
    }

    private static HashMap<String, Object> h(q qVar) {
        int v2 = qVar.v();
        HashMap<String, Object> hashMap = new HashMap<>(v2);
        for (int i2 = 0; i2 < v2; i2++) {
            String e2 = e(qVar);
            Object a2 = a(qVar, b(qVar));
            if (a2 != null) {
                hashMap.put(e2, a2);
            }
        }
        return hashMap;
    }

    private static Date i(q qVar) {
        Date date = new Date((long) d(qVar).doubleValue());
        qVar.d(2);
        return date;
    }

    public long a() {
        return this.f15504b;
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2) throws ParserException {
        if (b(qVar) != 2) {
            throw new ParserException();
        } else if (!"onMetaData".equals(e(qVar)) || b(qVar) != 8) {
            return false;
        } else {
            HashMap<String, Object> h2 = h(qVar);
            if (h2.containsKey("duration")) {
                double doubleValue = ((Double) h2.get("duration")).doubleValue();
                if (doubleValue > i.f27244a) {
                    this.f15504b = (long) (doubleValue * 1000000.0d);
                }
            }
            return false;
        }
    }
}
