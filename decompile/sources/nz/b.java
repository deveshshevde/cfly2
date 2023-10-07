package nz;

import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.h264.io.model.d;
import org.jcodec.codecs.h264.io.model.i;
import org.jcodec.codecs.h264.io.model.j;
import org.jcodec.common.model.ColorSpace;

public class b {

    /* renamed from: nz.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31657a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType[] r0 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31657a = r0
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.REMOVE_SHORT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31657a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.REMOVE_LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31657a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.CONVERT_INTO_LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31657a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.TRUNK_LONG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31657a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.CLEAR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31657a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r1 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.MARK_LONG     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: nz.b.AnonymousClass1.<clinit>():void");
        }
    }

    private static int a(int i2) {
        int i3 = i2 - 1;
        int i4 = 0;
        while (i3 != 0) {
            i3 >>= 1;
            i4++;
        }
        return i4;
    }

    private void a(j jVar, od.b bVar) {
        i iVar = jVar.f33074a;
        a.a(bVar, jVar.f33079f.f33035a, "SH: luma_log2_weight_denom");
        if (iVar.f33052f != ColorSpace.MONO) {
            a.a(bVar, jVar.f33079f.f33036b, "SH: chroma_log2_weight_denom");
        }
        a(jVar, bVar, 0);
        if (jVar.f33082i == SliceType.B) {
            a(jVar, bVar, 1);
        }
    }

    private void a(j jVar, od.b bVar, int i2) {
        i iVar = jVar.f33074a;
        int i3 = 1 << jVar.f33079f.f33035a;
        int i4 = 1 << jVar.f33079f.f33036b;
        for (int i5 = 0; i5 < jVar.f33079f.f33037c[i2].length; i5++) {
            boolean z2 = (jVar.f33079f.f33037c[i2][i5] == i3 && jVar.f33079f.f33039e[i2][i5] == 0) ? false : true;
            a.a(bVar, z2, "SH: luma_weight_l0_flag");
            if (z2) {
                int i6 = jVar.f33079f.f33037c[i2][i5];
                a.b(bVar, i6, "SH: luma_weight_l" + i2);
                int i7 = jVar.f33079f.f33039e[i2][i5];
                a.b(bVar, i7, "SH: luma_offset_l" + i2);
            }
            if (iVar.f33052f != ColorSpace.MONO) {
                boolean z3 = (jVar.f33079f.f33038d[i2][0][i5] == i4 && jVar.f33079f.f33040f[i2][0][i5] == 0 && jVar.f33079f.f33038d[i2][1][i5] == i4 && jVar.f33079f.f33040f[i2][1][i5] == 0) ? false : true;
                a.a(bVar, z3, "SH: chroma_weight_l0_flag");
                if (z3) {
                    for (int i8 = 0; i8 < 2; i8++) {
                        int i9 = jVar.f33079f.f33038d[i2][i8][i5];
                        a.b(bVar, i9, "SH: chroma_weight_l" + i2);
                        int i10 = jVar.f33079f.f33040f[i2][i8][i5];
                        a.b(bVar, i10, "SH: chroma_offset_l" + i2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        nz.a.a(r11, r3, "SH: long_term_frame_idx");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
        nz.a.a(r11, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.jcodec.codecs.h264.io.model.j r9, boolean r10, od.b r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L_0x0018
            org.jcodec.codecs.h264.io.model.f r9 = r9.f33077d
            boolean r10 = r9.a()
            java.lang.String r0 = "SH: no_output_of_prior_pics_flag"
            nz.a.a((od.b) r11, (boolean) r10, (java.lang.String) r0)
            boolean r9 = r9.b()
            java.lang.String r10 = "SH: long_term_reference_flag"
            nz.a.a((od.b) r11, (boolean) r9, (java.lang.String) r10)
            goto L_0x0099
        L_0x0018:
            org.jcodec.codecs.h264.io.model.RefPicMarking r10 = r9.f33076c
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x0020
            r10 = 1
            goto L_0x0021
        L_0x0020:
            r10 = 0
        L_0x0021:
            java.lang.String r2 = "SH: adaptive_ref_pic_marking_mode_flag"
            nz.a.a((od.b) r11, (boolean) r10, (java.lang.String) r2)
            org.jcodec.codecs.h264.io.model.RefPicMarking r10 = r9.f33076c
            if (r10 == 0) goto L_0x0099
            org.jcodec.codecs.h264.io.model.RefPicMarking r9 = r9.f33076c
            org.jcodec.codecs.h264.io.model.RefPicMarking$a[] r9 = r9.a()
            int r10 = r9.length
            r2 = 0
        L_0x0032:
            java.lang.String r3 = "SH: memory_management_control_operation"
            if (r2 >= r10) goto L_0x0096
            r4 = r9[r2]
            int[] r5 = nz.b.AnonymousClass1.f31657a
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r6 = r4.a()
            int r6 = r6.ordinal()
            r5 = r5[r6]
            java.lang.String r6 = "SH: long_term_frame_idx"
            java.lang.String r7 = "SH: difference_of_pic_nums_minus1"
            switch(r5) {
                case 1: goto L_0x0088;
                case 2: goto L_0x007a;
                case 3: goto L_0x0066;
                case 4: goto L_0x005a;
                case 5: goto L_0x0055;
                case 6: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            r5 = 6
            nz.a.a((od.b) r11, (int) r5, (java.lang.String) r3)
            int r3 = r4.b()
            goto L_0x0076
        L_0x0055:
            r4 = 5
            nz.a.a((od.b) r11, (int) r4, (java.lang.String) r3)
            goto L_0x0093
        L_0x005a:
            r5 = 4
            nz.a.a((od.b) r11, (int) r5, (java.lang.String) r3)
            int r3 = r4.b()
            int r3 = r3 + r1
            java.lang.String r4 = "SH: max_long_term_frame_idx_plus1"
            goto L_0x0084
        L_0x0066:
            r5 = 3
            nz.a.a((od.b) r11, (int) r5, (java.lang.String) r3)
            int r3 = r4.b()
            int r3 = r3 - r1
            nz.a.a((od.b) r11, (int) r3, (java.lang.String) r7)
            int r3 = r4.c()
        L_0x0076:
            nz.a.a((od.b) r11, (int) r3, (java.lang.String) r6)
            goto L_0x0093
        L_0x007a:
            r5 = 2
            nz.a.a((od.b) r11, (int) r5, (java.lang.String) r3)
            int r3 = r4.b()
            java.lang.String r4 = "SH: long_term_pic_num"
        L_0x0084:
            nz.a.a((od.b) r11, (int) r3, (java.lang.String) r4)
            goto L_0x0093
        L_0x0088:
            nz.a.a((od.b) r11, (int) r1, (java.lang.String) r3)
            int r3 = r4.b()
            int r3 = r3 - r1
            nz.a.a((od.b) r11, (int) r3, (java.lang.String) r7)
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0032
        L_0x0096:
            nz.a.a((od.b) r11, (int) r0, (java.lang.String) r3)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: nz.b.a(org.jcodec.codecs.h264.io.model.j, boolean, od.b):void");
    }

    private void a(int[][] iArr, od.b bVar) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr[0].length; i2++) {
                a.a(bVar, iArr[0][i2], "SH: reordering_of_pic_nums_idc");
                a.a(bVar, iArr[1][i2], "SH: abs_diff_pic_num_minus1");
            }
            a.a(bVar, 3, "SH: reordering_of_pic_nums_idc");
        }
    }

    private void b(j jVar, od.b bVar) {
        boolean z2 = false;
        if (jVar.f33082i.a()) {
            a.a(bVar, jVar.f33078e[0] != null, "SH: ref_pic_list_reordering_flag_l0");
            a(jVar.f33078e[0], bVar);
        }
        if (jVar.f33082i == SliceType.B) {
            if (jVar.f33078e[1] != null) {
                z2 = true;
            }
            a.a(bVar, z2, "SH: ref_pic_list_reordering_flag_l1");
            a(jVar.f33078e[1], bVar);
        }
    }

    public void a(j jVar, boolean z2, int i2, od.b bVar) {
        i iVar = jVar.f33074a;
        d dVar = jVar.f33075b;
        a.a(bVar, jVar.f33080g, "SH: first_mb_in_slice");
        a.a(bVar, jVar.f33082i.ordinal() + (jVar.f33083j ? 5 : 0), "SH: slice_type");
        a.a(bVar, jVar.f33084k, "SH: pic_parameter_set_id");
        a.a(bVar, jVar.f33085l, iVar.f33053g + 4, "SH: frame_num");
        if (!iVar.f33072z) {
            a.a(bVar, jVar.f33081h, "SH: field_pic_flag");
            if (jVar.f33081h) {
                a.a(bVar, jVar.f33086m, "SH: bottom_field_flag");
            }
        }
        if (z2) {
            a.a(bVar, jVar.f33087n, "SH: idr_pic_id");
        }
        if (iVar.f33047a == 0) {
            a.a(bVar, jVar.f33088o, iVar.f33054h + 4);
            if (dVar.f33015f && !iVar.f33048b) {
                a.b(bVar, jVar.f33089p, "SH: delta_pic_order_cnt_bottom");
            }
        }
        if (iVar.f33047a == 1 && !iVar.f33049c) {
            a.b(bVar, jVar.f33090q[0], "SH: delta_pic_order_cnt");
            if (dVar.f33015f && !iVar.f33048b) {
                a.b(bVar, jVar.f33090q[1], "SH: delta_pic_order_cnt");
            }
        }
        if (dVar.f33025p) {
            a.a(bVar, jVar.f33091r, "SH: redundant_pic_cnt");
        }
        if (jVar.f33082i == SliceType.B) {
            a.a(bVar, jVar.f33092s, "SH: direct_spatial_mv_pred_flag");
        }
        if (jVar.f33082i == SliceType.P || jVar.f33082i == SliceType.SP || jVar.f33082i == SliceType.B) {
            a.a(bVar, jVar.f33093t, "SH: num_ref_idx_active_override_flag");
            if (jVar.f33093t) {
                a.a(bVar, jVar.f33094u[0], "SH: num_ref_idx_l0_active_minus1");
                if (jVar.f33082i == SliceType.B) {
                    a.a(bVar, jVar.f33094u[1], "SH: num_ref_idx_l1_active_minus1");
                }
            }
        }
        b(jVar, bVar);
        if ((dVar.f33018i && (jVar.f33082i == SliceType.P || jVar.f33082i == SliceType.SP)) || (dVar.f33019j == 1 && jVar.f33082i == SliceType.B)) {
            a(jVar, bVar);
        }
        if (i2 != 0) {
            a(jVar, z2, bVar);
        }
        if (dVar.f33010a && jVar.f33082i.a()) {
            a.a(bVar, jVar.f33095v, "SH: cabac_init_idc");
        }
        a.b(bVar, jVar.f33096w, "SH: slice_qp_delta");
        if (jVar.f33082i == SliceType.SP || jVar.f33082i == SliceType.SI) {
            if (jVar.f33082i == SliceType.SP) {
                a.a(bVar, jVar.f33097x, "SH: sp_for_switch_flag");
            }
            a.b(bVar, jVar.f33098y, "SH: slice_qs_delta");
        }
        if (dVar.f33023n) {
            a.a(bVar, jVar.f33099z, "SH: disable_deblocking_filter_idc");
            if (jVar.f33099z != 1) {
                a.b(bVar, jVar.A, "SH: slice_alpha_c0_offset_div2");
                a.b(bVar, jVar.B, "SH: slice_beta_offset_div2");
            }
        }
        if (dVar.f33016g > 0 && dVar.f33017h >= 3 && dVar.f33017h <= 5) {
            int i3 = ((iVar.f33055i + 1) * (iVar.f33056j + 1)) / (dVar.f33012c + 1);
            if (((iVar.f33055i + 1) * (iVar.f33056j + 1)) % (dVar.f33012c + 1) > 0) {
                i3++;
            }
            a.a(bVar, jVar.C, a(i3 + 1));
        }
    }
}
