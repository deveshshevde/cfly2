package com.ctoo.mediaedit.tools;

import android.os.Build;
import com.ctoo.mediaedit.tools.e;
import cz.b;

public class d {
    public static b a(e.h hVar, e.i iVar, e.j jVar) {
        return Build.VERSION.SDK_INT >= 20 ? new c(hVar, iVar, jVar) : new b(hVar, iVar, jVar);
    }
}
