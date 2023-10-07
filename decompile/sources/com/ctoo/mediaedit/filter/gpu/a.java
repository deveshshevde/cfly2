package com.ctoo.mediaedit.filter.gpu;

import ct.aa;
import ct.ab;
import ct.ac;
import ct.ad;
import ct.ae;
import ct.af;
import ct.ag;
import ct.ah;
import ct.ai;
import ct.aj;
import ct.ak;
import ct.al;
import ct.am;
import ct.an;
import ct.ao;
import ct.ap;
import ct.aq;
import ct.b;
import ct.c;
import ct.f;
import ct.g;
import ct.h;
import ct.i;
import ct.j;
import ct.k;
import ct.l;
import ct.m;
import ct.n;
import ct.o;
import ct.p;
import ct.q;
import ct.r;
import ct.s;
import ct.t;
import ct.u;
import ct.w;
import ct.x;
import ct.y;
import ct.z;
import cu.d;
import cu.e;

public class a {
    public static e a(GPUImageFilterType gPUImageFilterType) {
        switch (gPUImageFilterType) {
            case WHITECAT:
                return new ap();
            case BLACKCAT:
                return new c();
            case SUNRISE:
                return new ag();
            case SUNSET:
                return new ah();
            case COOL:
                return new h();
            case EMERALD:
                return new k();
            case EVERGREEN:
                return new l();
            case FAIRYTALE:
                return new m();
            case ROMANCE:
                return new ab();
            case SAKURA:
                return new ac();
            case WARM:
                return new ao();
            case AMARO:
                return new ct.a();
            case BRANNAN:
                return new ct.e();
            case BROOKLYN:
                return new f();
            case EARLYBIRD:
                return new j();
            case FREUD:
                return new n();
            case HEFE:
                return new p();
            case HUDSON:
                return new q();
            case INKWELL:
                return new r();
            case KEVIN:
                return new s();
            case LOMO:
                return new u();
            case N1977:
                return new w();
            case NASHVILLE:
                return new x();
            case PIXAR:
                return new z();
            case RISE:
                return new aa();
            case SIERRA:
                return new ad();
            case SUTRO:
                return new ai();
            case TOASTER2:
                return new al();
            case VALENCIA:
                return new am();
            case WALDEN:
                return new an();
            case XPROII:
                return new aq();
            case ANTIQUE:
                return new b();
            case NOSTALGIA:
                return new y();
            case SKINWHITEN:
                return new af();
            case HEALTHY:
                return new o();
            case SWEETS:
                return new aj();
            case CALM:
                return new g();
            case LATTE:
                return new t();
            case TENDER:
                return new ak();
            case CRAYON:
                return new i();
            case SKETCH:
                return new ae();
            case CONTRAST:
                return new cu.c();
            case BRIGHTNESS:
                return new cu.b();
            case EXPOSURE:
                return new d();
            case HUE:
                return new cu.f();
            case SATURATION:
                return new cu.g();
            case SHARPEN:
                return new cu.h();
            case SHAKE:
                return new cv.c();
            case WHITEMASK:
                return new cv.e();
            case BLACKMASK:
                return new cv.a();
            case CROSSZOOM:
                return new cv.b();
            default:
                return new e();
        }
    }
}
