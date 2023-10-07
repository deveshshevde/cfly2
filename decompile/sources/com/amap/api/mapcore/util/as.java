package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public final class as {

    /* renamed from: a  reason: collision with root package name */
    private Context f7869a;

    public as(Context context) {
        this.f7869a = context;
    }

    private static boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b2 = dl.b(context);
        try {
            File file = new File(b2 + str2 + str + ".dat");
            if (file.exists() && !bj.b(file)) {
                return false;
            }
            try {
                bj.a(b2 + str2);
                bj.b(str, context);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    private boolean b(al alVar) {
        if (alVar != null) {
            String pinyin = alVar.getPinyin();
            boolean a2 = a(pinyin, this.f7869a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z2 = true;
            boolean z3 = a(pinyin, this.f7869a, "map/") || a2;
            if (!b(bj.b(alVar.getUrl()), this.f7869a, "map/") && !z3) {
                z2 = false;
            }
            if (z2) {
                alVar.i();
                return z2;
            }
            alVar.h();
        }
        return false;
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a2 = dl.a(context);
        try {
            File file = new File(a2 + str2 + str);
            if (file.exists() && !bj.b(file)) {
                return false;
            }
            try {
                bj.a(a2 + str2);
                bj.b(str, context);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public final void a(al alVar) {
        b(alVar);
    }
}
