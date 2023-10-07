package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f15624a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153};

    private static boolean a(int i2) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        for (int i3 : f15624a) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(h hVar) throws IOException, InterruptedException {
        return a(hVar, true);
    }

    private static boolean a(h hVar, boolean z2) throws IOException, InterruptedException {
        boolean z3;
        h hVar2 = hVar;
        long d2 = hVar.d();
        long j2 = IjkMediaMeta.AV_CH_TOP_FRONT_LEFT;
        long j3 = -1;
        if (d2 != -1 && d2 <= IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            j2 = d2;
        }
        int i2 = (int) j2;
        q qVar = new q(64);
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            qVar.a(8);
            hVar2.d(qVar.f17159a, z4 ? 1 : 0, 8);
            long n2 = qVar.n();
            int p2 = qVar.p();
            int i4 = 16;
            if (n2 == 1) {
                hVar2.d(qVar.f17159a, 8, 8);
                qVar.b(16);
                n2 = qVar.r();
            } else {
                if (n2 == 0) {
                    long d3 = hVar.d();
                    if (d3 != j3) {
                        n2 = ((long) 8) + (d3 - hVar.b());
                    }
                }
                i4 = 8;
            }
            long j4 = (long) i4;
            if (n2 < j4) {
                return z4;
            }
            i3 += i4;
            if (p2 == 1836019574) {
                i2 += (int) n2;
                if (d2 != -1 && ((long) i2) > d2) {
                    i2 = (int) d2;
                }
                j3 = -1;
            } else if (p2 == 1836019558 || p2 == 1836475768) {
                z3 = true;
            } else {
                long j5 = d2;
                int i5 = i3;
                if ((((long) i3) + n2) - j4 >= ((long) i2)) {
                    break;
                }
                int i6 = (int) (n2 - j4);
                i3 = i5 + i6;
                if (p2 == 1718909296) {
                    if (i6 < 8) {
                        return false;
                    }
                    qVar.a(i6);
                    hVar2.d(qVar.f17159a, 0, i6);
                    int i7 = i6 / 4;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            break;
                        }
                        if (i8 == 1) {
                            qVar.d(4);
                        } else if (a(qVar.p())) {
                            z5 = true;
                            break;
                        }
                        i8++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i6 != 0) {
                    hVar2.c(i6);
                }
                j3 = -1;
                d2 = j5;
                z4 = false;
            }
        }
        z3 = false;
        return z5 && z2 == z3;
    }

    public static boolean b(h hVar) throws IOException, InterruptedException {
        return a(hVar, false);
    }
}
