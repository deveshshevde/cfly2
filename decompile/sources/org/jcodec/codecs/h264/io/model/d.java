package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import java.util.Arrays;
import od.b;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33010a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f33011b = new int[2];

    /* renamed from: c  reason: collision with root package name */
    public int f33012c;

    /* renamed from: d  reason: collision with root package name */
    public int f33013d;

    /* renamed from: e  reason: collision with root package name */
    public int f33014e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33015f;

    /* renamed from: g  reason: collision with root package name */
    public int f33016g;

    /* renamed from: h  reason: collision with root package name */
    public int f33017h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33018i;

    /* renamed from: j  reason: collision with root package name */
    public int f33019j;

    /* renamed from: k  reason: collision with root package name */
    public int f33020k;

    /* renamed from: l  reason: collision with root package name */
    public int f33021l;

    /* renamed from: m  reason: collision with root package name */
    public int f33022m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f33023n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f33024o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f33025p;

    /* renamed from: q  reason: collision with root package name */
    public int[] f33026q;

    /* renamed from: r  reason: collision with root package name */
    public int[] f33027r;

    /* renamed from: s  reason: collision with root package name */
    public int[] f33028s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f33029t;

    /* renamed from: u  reason: collision with root package name */
    public int[] f33030u;

    /* renamed from: v  reason: collision with root package name */
    public a f33031v;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f33032a;

        /* renamed from: b  reason: collision with root package name */
        public h f33033b;

        /* renamed from: c  reason: collision with root package name */
        public int f33034c;
    }

    public void a(ByteBuffer byteBuffer) {
        g gVar;
        b bVar = new b(byteBuffer);
        nz.a.a(bVar, this.f33013d, "PPS: pic_parameter_set_id");
        nz.a.a(bVar, this.f33014e, "PPS: seq_parameter_set_id");
        nz.a.a(bVar, this.f33010a, "PPS: entropy_coding_mode_flag");
        nz.a.a(bVar, this.f33015f, "PPS: pic_order_present_flag");
        nz.a.a(bVar, this.f33016g, "PPS: num_slice_groups_minus1");
        if (this.f33016g > 0) {
            nz.a.a(bVar, this.f33017h, "PPS: slice_group_map_type");
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            int i2 = this.f33017h;
            if (i2 == 0) {
                for (int i3 = 0; i3 <= this.f33016g; i3++) {
                    nz.a.a(bVar, iArr3[i3], "PPS: ");
                }
            } else if (i2 == 2) {
                for (int i4 = 0; i4 < this.f33016g; i4++) {
                    nz.a.a(bVar, iArr[i4], "PPS: ");
                    nz.a.a(bVar, iArr2[i4], "PPS: ");
                }
            } else {
                int i5 = 3;
                if (i2 == 3 || i2 == 4 || i2 == 5) {
                    nz.a.a(bVar, this.f33029t, "PPS: slice_group_change_direction_flag");
                    nz.a.a(bVar, this.f33012c, "PPS: slice_group_change_rate_minus1");
                } else if (i2 == 6) {
                    int i6 = this.f33016g;
                    if (i6 + 1 <= 4) {
                        i5 = i6 + 1 > 2 ? 2 : 1;
                    }
                    nz.a.a(bVar, this.f33030u.length, "PPS: ");
                    int i7 = 0;
                    while (true) {
                        int[] iArr4 = this.f33030u;
                        if (i7 > iArr4.length) {
                            break;
                        }
                        nz.a.a(bVar, iArr4[i7], i5);
                        i7++;
                    }
                }
            }
        }
        nz.a.a(bVar, this.f33011b[0], "PPS: num_ref_idx_l0_active_minus1");
        nz.a.a(bVar, this.f33011b[1], "PPS: num_ref_idx_l1_active_minus1");
        nz.a.a(bVar, this.f33018i, "PPS: weighted_pred_flag");
        nz.a.a(bVar, (long) this.f33019j, 2, "PPS: weighted_bipred_idc");
        nz.a.b(bVar, this.f33020k, "PPS: pic_init_qp_minus26");
        nz.a.b(bVar, this.f33021l, "PPS: pic_init_qs_minus26");
        nz.a.b(bVar, this.f33022m, "PPS: chroma_qp_index_offset");
        nz.a.a(bVar, this.f33023n, "PPS: deblocking_filter_control_present_flag");
        nz.a.a(bVar, this.f33024o, "PPS: constrained_intra_pred_flag");
        nz.a.a(bVar, this.f33025p, "PPS: redundant_pic_cnt_present_flag");
        a aVar = this.f33031v;
        if (aVar != null) {
            nz.a.a(bVar, aVar.f33032a, "PPS: transform_8x8_mode_flag");
            nz.a.a(bVar, this.f33031v.f33033b != null, "PPS: scalindMatrix");
            if (this.f33031v.f33033b != null) {
                for (int i8 = 0; i8 < ((this.f33031v.f33032a ? 1 : 0) * true) + 6; i8++) {
                    h hVar = this.f33031v.f33033b;
                    if (i8 < 6) {
                        nz.a.a(bVar, hVar.f33045a[i8] != null, "PPS: ");
                        if (this.f33031v.f33033b.f33045a[i8] != null) {
                            gVar = this.f33031v.f33033b.f33045a[i8];
                        }
                    } else {
                        int i9 = i8 - 6;
                        nz.a.a(bVar, hVar.f33046b[i9] != null, "PPS: ");
                        if (this.f33031v.f33033b.f33046b[i9] != null) {
                            gVar = this.f33031v.f33033b.f33046b[i9];
                        }
                    }
                    gVar.a(bVar);
                }
            }
            nz.a.b(bVar, this.f33031v.f33034c, "PPS: ");
        }
        nz.a.a(bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!Arrays.equals(this.f33027r, dVar.f33027r) || this.f33022m != dVar.f33022m || this.f33024o != dVar.f33024o || this.f33023n != dVar.f33023n || this.f33010a != dVar.f33010a) {
            return false;
        }
        a aVar = this.f33031v;
        if (aVar == null) {
            if (dVar.f33031v != null) {
                return false;
            }
        } else if (!aVar.equals(dVar.f33031v)) {
            return false;
        }
        int[] iArr = this.f33011b;
        int i2 = iArr[0];
        int[] iArr2 = dVar.f33011b;
        return i2 == iArr2[0] && iArr[1] == iArr2[1] && this.f33016g == dVar.f33016g && this.f33020k == dVar.f33020k && this.f33021l == dVar.f33021l && this.f33015f == dVar.f33015f && this.f33013d == dVar.f33013d && this.f33025p == dVar.f33025p && Arrays.equals(this.f33028s, dVar.f33028s) && this.f33014e == dVar.f33014e && this.f33029t == dVar.f33029t && this.f33012c == dVar.f33012c && Arrays.equals(this.f33030u, dVar.f33030u) && this.f33017h == dVar.f33017h && Arrays.equals(this.f33026q, dVar.f33026q) && this.f33019j == dVar.f33019j && this.f33018i == dVar.f33018i;
    }

    public int hashCode() {
        int i2 = 1231;
        int hashCode = (((((((((Arrays.hashCode(this.f33027r) + 31) * 31) + this.f33022m) * 31) + (this.f33024o ? 1231 : 1237)) * 31) + (this.f33023n ? 1231 : 1237)) * 31) + (this.f33010a ? 1231 : 1237)) * 31;
        a aVar = this.f33031v;
        int hashCode2 = aVar == null ? 0 : aVar.hashCode();
        int[] iArr = this.f33011b;
        int hashCode3 = (((((((((((((((((((((((((((((((((hashCode + hashCode2) * 31) + iArr[0]) * 31) + iArr[1]) * 31) + this.f33016g) * 31) + this.f33020k) * 31) + this.f33021l) * 31) + (this.f33015f ? 1231 : 1237)) * 31) + this.f33013d) * 31) + (this.f33025p ? 1231 : 1237)) * 31) + Arrays.hashCode(this.f33028s)) * 31) + this.f33014e) * 31) + (this.f33029t ? 1231 : 1237)) * 31) + this.f33012c) * 31) + Arrays.hashCode(this.f33030u)) * 31) + this.f33017h) * 31) + Arrays.hashCode(this.f33026q)) * 31) + this.f33019j) * 31;
        if (!this.f33018i) {
            i2 = 1237;
        }
        return hashCode3 + i2;
    }
}
