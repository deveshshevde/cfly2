package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.af;

public final class ag extends af {

    public static abstract class a implements af.a {
        public final boolean a(af afVar) {
            return a((ag) afVar);
        }

        public abstract boolean a(ag agVar);

        public final boolean b(af afVar) {
            return b((ag) afVar);
        }

        public abstract boolean b(ag agVar);

        public final void c(af afVar) {
            c((ag) afVar);
        }

        public abstract void c(ag agVar);
    }

    public ag(Context context, a aVar) {
        super(context, aVar);
    }

    public final float j() {
        return (float) (((Math.atan2((double) g(), (double) f()) - Math.atan2((double) e(), (double) d())) * 180.0d) / 3.141592653589793d);
    }
}
