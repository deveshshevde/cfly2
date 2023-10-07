package com.xeagle.android.maps.providers;

import com.xeagle.android.utils.c;
import java.util.Locale;
import kh.a;
import kj.b;

public enum DPMapProvider {
    GOOGLE_MAP {
        public a a() {
            return new kj.a();
        }

        public a b() {
            return new b();
        }
    },
    LBS_AMAP {
        public a a() {
            return new ki.a();
        }

        public a b() {
            return new b();
        }
    },
    SYSTEM_LOC {
        public a a() {
            return c.a().equals(Locale.CHINA.getCountry()) ? new ki.a() : new kj.a();
        }

        public a b() {
            return new b();
        }
    };
    

    /* renamed from: d  reason: collision with root package name */
    public static final DPMapProvider f23809d = null;

    static {
        AnonymousClass3 r3;
        f23809d = r3;
    }

    public static DPMapProvider a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public abstract a a();

    public abstract a b();
}
