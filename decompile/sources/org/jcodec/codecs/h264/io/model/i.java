package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import od.a;
import od.b;
import org.jcodec.codecs.h264.io.model.k;
import org.jcodec.common.model.ColorSpace;

public class i {
    public boolean A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int[] F;
    public k G;
    public h H;
    public int I;

    /* renamed from: a  reason: collision with root package name */
    public int f33047a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33048b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33049c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33050d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33051e;

    /* renamed from: f  reason: collision with root package name */
    public ColorSpace f33052f;

    /* renamed from: g  reason: collision with root package name */
    public int f33053g;

    /* renamed from: h  reason: collision with root package name */
    public int f33054h;

    /* renamed from: i  reason: collision with root package name */
    public int f33055i;

    /* renamed from: j  reason: collision with root package name */
    public int f33056j;

    /* renamed from: k  reason: collision with root package name */
    public int f33057k;

    /* renamed from: l  reason: collision with root package name */
    public int f33058l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f33059m;

    /* renamed from: n  reason: collision with root package name */
    public int f33060n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f33061o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f33062p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f33063q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f33064r;

    /* renamed from: s  reason: collision with root package name */
    public int f33065s;

    /* renamed from: t  reason: collision with root package name */
    public int f33066t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f33067u;

    /* renamed from: v  reason: collision with root package name */
    public int f33068v;

    /* renamed from: w  reason: collision with root package name */
    public int f33069w;

    /* renamed from: x  reason: collision with root package name */
    public int f33070x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f33071y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f33072z;

    /* renamed from: org.jcodec.codecs.h264.io.model.i$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33073a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.jcodec.common.model.ColorSpace[] r0 = org.jcodec.common.model.ColorSpace.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33073a = r0
                org.jcodec.common.model.ColorSpace r1 = org.jcodec.common.model.ColorSpace.MONO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33073a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jcodec.common.model.ColorSpace r1 = org.jcodec.common.model.ColorSpace.YUV420     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33073a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jcodec.common.model.ColorSpace r1 = org.jcodec.common.model.ColorSpace.YUV422     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33073a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jcodec.common.model.ColorSpace r1 = org.jcodec.common.model.ColorSpace.YUV444     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.io.model.i.AnonymousClass1.<clinit>():void");
        }
    }

    public static int a(ColorSpace colorSpace) {
        int i2 = AnonymousClass1.f33073a[colorSpace.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    public static i a(ByteBuffer byteBuffer) {
        a aVar = new a(byteBuffer);
        i iVar = new i();
        iVar.f33060n = nw.a.a(aVar, 8, "SPS: profile_idc");
        iVar.f33061o = nw.a.c(aVar, "SPS: constraint_set_0_flag");
        iVar.f33062p = nw.a.c(aVar, "SPS: constraint_set_1_flag");
        iVar.f33063q = nw.a.c(aVar, "SPS: constraint_set_2_flag");
        iVar.f33064r = nw.a.c(aVar, "SPS: constraint_set_3_flag");
        nw.a.a(aVar, 4, "SPS: reserved_zero_4bits");
        iVar.f33065s = nw.a.a(aVar, 8, "SPS: level_idc");
        iVar.f33066t = nw.a.a(aVar, "SPS: seq_parameter_set_id");
        int i2 = iVar.f33060n;
        if (i2 == 100 || i2 == 110 || i2 == 122 || i2 == 144) {
            ColorSpace a2 = a(nw.a.a(aVar, "SPS: chroma_format_idc"));
            iVar.f33052f = a2;
            if (a2 == ColorSpace.YUV444) {
                iVar.f33067u = nw.a.c(aVar, "SPS: residual_color_transform_flag");
            }
            iVar.f33057k = nw.a.a(aVar, "SPS: bit_depth_luma_minus8");
            iVar.f33058l = nw.a.a(aVar, "SPS: bit_depth_chroma_minus8");
            iVar.f33059m = nw.a.c(aVar, "SPS: qpprime_y_zero_transform_bypass_flag");
            if (nw.a.c(aVar, "SPS: seq_scaling_matrix_present_lag")) {
                a(aVar, iVar);
            }
        } else {
            iVar.f33052f = ColorSpace.YUV420;
        }
        iVar.f33053g = nw.a.a(aVar, "SPS: log2_max_frame_num_minus4");
        int a3 = nw.a.a(aVar, "SPS: pic_order_cnt_type");
        iVar.f33047a = a3;
        if (a3 == 0) {
            iVar.f33054h = nw.a.a(aVar, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (a3 == 1) {
            iVar.f33049c = nw.a.c(aVar, "SPS: delta_pic_order_always_zero_flag");
            iVar.f33068v = nw.a.b(aVar, "SPS: offset_for_non_ref_pic");
            iVar.f33069w = nw.a.b(aVar, "SPS: offset_for_top_to_bottom_field");
            int a4 = nw.a.a(aVar, "SPS: num_ref_frames_in_pic_order_cnt_cycle");
            iVar.I = a4;
            iVar.F = new int[a4];
            for (int i3 = 0; i3 < iVar.I; i3++) {
                int[] iArr = iVar.F;
                iArr[i3] = nw.a.b(aVar, "SPS: offsetForRefFrame [" + i3 + "]");
            }
        }
        iVar.f33070x = nw.a.a(aVar, "SPS: num_ref_frames");
        iVar.f33071y = nw.a.c(aVar, "SPS: gaps_in_frame_num_value_allowed_flag");
        iVar.f33056j = nw.a.a(aVar, "SPS: pic_width_in_mbs_minus1");
        iVar.f33055i = nw.a.a(aVar, "SPS: pic_height_in_map_units_minus1");
        boolean c2 = nw.a.c(aVar, "SPS: frame_mbs_only_flag");
        iVar.f33072z = c2;
        if (!c2) {
            iVar.f33050d = nw.a.c(aVar, "SPS: mb_adaptive_frame_field_flag");
        }
        iVar.f33051e = nw.a.c(aVar, "SPS: direct_8x8_inference_flag");
        boolean c3 = nw.a.c(aVar, "SPS: frame_cropping_flag");
        iVar.A = c3;
        if (c3) {
            iVar.B = nw.a.a(aVar, "SPS: frame_crop_left_offset");
            iVar.C = nw.a.a(aVar, "SPS: frame_crop_right_offset");
            iVar.D = nw.a.a(aVar, "SPS: frame_crop_top_offset");
            iVar.E = nw.a.a(aVar, "SPS: frame_crop_bottom_offset");
        }
        if (nw.a.c(aVar, "SPS: vui_parameters_present_flag")) {
            iVar.G = a(aVar);
        }
        return iVar;
    }

    private static k a(a aVar) {
        k kVar = new k();
        kVar.f33100a = nw.a.c(aVar, "VUI: aspect_ratio_info_present_flag");
        if (kVar.f33100a) {
            kVar.f33124y = a.a(nw.a.a(aVar, 8, "VUI: aspect_ratio"));
            if (kVar.f33124y == a.f32996a) {
                kVar.f33101b = nw.a.a(aVar, 16, "VUI: sar_width");
                kVar.f33102c = nw.a.a(aVar, 16, "VUI: sar_height");
            }
        }
        kVar.f33103d = nw.a.c(aVar, "VUI: overscan_info_present_flag");
        if (kVar.f33103d) {
            kVar.f33104e = nw.a.c(aVar, "VUI: overscan_appropriate_flag");
        }
        kVar.f33105f = nw.a.c(aVar, "VUI: video_signal_type_present_flag");
        if (kVar.f33105f) {
            kVar.f33106g = nw.a.a(aVar, 3, "VUI: video_format");
            kVar.f33107h = nw.a.c(aVar, "VUI: video_full_range_flag");
            kVar.f33108i = nw.a.c(aVar, "VUI: colour_description_present_flag");
            if (kVar.f33108i) {
                kVar.f33109j = nw.a.a(aVar, 8, "VUI: colour_primaries");
                kVar.f33110k = nw.a.a(aVar, 8, "VUI: transfer_characteristics");
                kVar.f33111l = nw.a.a(aVar, 8, "VUI: matrix_coefficients");
            }
        }
        kVar.f33112m = nw.a.c(aVar, "VUI: chroma_loc_info_present_flag");
        if (kVar.f33112m) {
            kVar.f33113n = nw.a.a(aVar, "VUI chroma_sample_loc_type_top_field");
            kVar.f33114o = nw.a.a(aVar, "VUI chroma_sample_loc_type_bottom_field");
        }
        kVar.f33115p = nw.a.c(aVar, "VUI: timing_info_present_flag");
        if (kVar.f33115p) {
            kVar.f33116q = nw.a.a(aVar, 32, "VUI: num_units_in_tick");
            kVar.f33117r = nw.a.a(aVar, 32, "VUI: time_scale");
            kVar.f33118s = nw.a.c(aVar, "VUI: fixed_frame_rate_flag");
        }
        boolean c2 = nw.a.c(aVar, "VUI: nal_hrd_parameters_present_flag");
        if (c2) {
            kVar.f33121v = b(aVar);
        }
        boolean c3 = nw.a.c(aVar, "VUI: vcl_hrd_parameters_present_flag");
        if (c3) {
            kVar.f33122w = b(aVar);
        }
        if (c2 || c3) {
            kVar.f33119t = nw.a.c(aVar, "VUI: low_delay_hrd_flag");
        }
        kVar.f33120u = nw.a.c(aVar, "VUI: pic_struct_present_flag");
        if (nw.a.c(aVar, "VUI: bitstream_restriction_flag")) {
            kVar.f33123x = new k.a();
            kVar.f33123x.f33125a = nw.a.c(aVar, "VUI: motion_vectors_over_pic_boundaries_flag");
            kVar.f33123x.f33126b = nw.a.a(aVar, "VUI max_bytes_per_pic_denom");
            kVar.f33123x.f33127c = nw.a.a(aVar, "VUI max_bits_per_mb_denom");
            kVar.f33123x.f33128d = nw.a.a(aVar, "VUI log2_max_mv_length_horizontal");
            kVar.f33123x.f33129e = nw.a.a(aVar, "VUI log2_max_mv_length_vertical");
            kVar.f33123x.f33130f = nw.a.a(aVar, "VUI num_reorder_frames");
            kVar.f33123x.f33131g = nw.a.a(aVar, "VUI max_dec_frame_buffering");
        }
        return kVar;
    }

    public static ColorSpace a(int i2) {
        if (i2 == 0) {
            return ColorSpace.MONO;
        }
        if (i2 == 1) {
            return ColorSpace.YUV420;
        }
        if (i2 == 2) {
            return ColorSpace.YUV422;
        }
        if (i2 == 3) {
            return ColorSpace.YUV444;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    private static void a(a aVar, i iVar) {
        iVar.H = new h();
        for (int i2 = 0; i2 < 8; i2++) {
            if (nw.a.c(aVar, "SPS: seqScalingListPresentFlag")) {
                iVar.H.f33045a = new g[8];
                iVar.H.f33046b = new g[8];
                if (i2 < 6) {
                    iVar.H.f33045a[i2] = g.a(aVar, 16);
                } else {
                    iVar.H.f33046b[i2 - 6] = g.a(aVar, 64);
                }
            }
        }
    }

    private void a(b bVar, b bVar2) {
        nz.a.a(bVar2, bVar.f32998a, "HRD: cpb_cnt_minus1");
        nz.a.a(bVar2, (long) bVar.f32999b, 4, "HRD: bit_rate_scale");
        nz.a.a(bVar2, (long) bVar.f33000c, 4, "HRD: cpb_size_scale");
        for (int i2 = 0; i2 <= bVar.f32998a; i2++) {
            nz.a.a(bVar2, bVar.f33001d[i2], "HRD: ");
            nz.a.a(bVar2, bVar.f33002e[i2], "HRD: ");
            nz.a.a(bVar2, bVar.f33003f[i2], "HRD: ");
        }
        nz.a.a(bVar2, (long) bVar.f33004g, 5, "HRD: initial_cpb_removal_delay_length_minus1");
        nz.a.a(bVar2, (long) bVar.f33005h, 5, "HRD: cpb_removal_delay_length_minus1");
        nz.a.a(bVar2, (long) bVar.f33006i, 5, "HRD: dpb_output_delay_length_minus1");
        nz.a.a(bVar2, (long) bVar.f33007j, 5, "HRD: time_offset_length");
    }

    private void a(k kVar, b bVar) {
        nz.a.a(bVar, kVar.f33100a, "VUI: aspect_ratio_info_present_flag");
        if (kVar.f33100a) {
            nz.a.a(bVar, (long) kVar.f33124y.a(), 8, "VUI: aspect_ratio");
            if (kVar.f33124y == a.f32996a) {
                nz.a.a(bVar, (long) kVar.f33101b, 16, "VUI: sar_width");
                nz.a.a(bVar, (long) kVar.f33102c, 16, "VUI: sar_height");
            }
        }
        nz.a.a(bVar, kVar.f33103d, "VUI: overscan_info_present_flag");
        if (kVar.f33103d) {
            nz.a.a(bVar, kVar.f33104e, "VUI: overscan_appropriate_flag");
        }
        nz.a.a(bVar, kVar.f33105f, "VUI: video_signal_type_present_flag");
        if (kVar.f33105f) {
            nz.a.a(bVar, (long) kVar.f33106g, 3, "VUI: video_format");
            nz.a.a(bVar, kVar.f33107h, "VUI: video_full_range_flag");
            nz.a.a(bVar, kVar.f33108i, "VUI: colour_description_present_flag");
            if (kVar.f33108i) {
                nz.a.a(bVar, (long) kVar.f33109j, 8, "VUI: colour_primaries");
                nz.a.a(bVar, (long) kVar.f33110k, 8, "VUI: transfer_characteristics");
                nz.a.a(bVar, (long) kVar.f33111l, 8, "VUI: matrix_coefficients");
            }
        }
        nz.a.a(bVar, kVar.f33112m, "VUI: chroma_loc_info_present_flag");
        if (kVar.f33112m) {
            nz.a.a(bVar, kVar.f33113n, "VUI: chroma_sample_loc_type_top_field");
            nz.a.a(bVar, kVar.f33114o, "VUI: chroma_sample_loc_type_bottom_field");
        }
        nz.a.a(bVar, kVar.f33115p, "VUI: timing_info_present_flag");
        if (kVar.f33115p) {
            nz.a.a(bVar, (long) kVar.f33116q, 32, "VUI: num_units_in_tick");
            nz.a.a(bVar, (long) kVar.f33117r, 32, "VUI: time_scale");
            nz.a.a(bVar, kVar.f33118s, "VUI: fixed_frame_rate_flag");
        }
        boolean z2 = true;
        nz.a.a(bVar, kVar.f33121v != null, "VUI: ");
        if (kVar.f33121v != null) {
            a(kVar.f33121v, bVar);
        }
        nz.a.a(bVar, kVar.f33122w != null, "VUI: ");
        if (kVar.f33122w != null) {
            a(kVar.f33122w, bVar);
        }
        if (!(kVar.f33121v == null && kVar.f33122w == null)) {
            nz.a.a(bVar, kVar.f33119t, "VUI: low_delay_hrd_flag");
        }
        nz.a.a(bVar, kVar.f33120u, "VUI: pic_struct_present_flag");
        if (kVar.f33123x == null) {
            z2 = false;
        }
        nz.a.a(bVar, z2, "VUI: ");
        if (kVar.f33123x != null) {
            nz.a.a(bVar, kVar.f33123x.f33125a, "VUI: motion_vectors_over_pic_boundaries_flag");
            nz.a.a(bVar, kVar.f33123x.f33126b, "VUI: max_bytes_per_pic_denom");
            nz.a.a(bVar, kVar.f33123x.f33127c, "VUI: max_bits_per_mb_denom");
            nz.a.a(bVar, kVar.f33123x.f33128d, "VUI: log2_max_mv_length_horizontal");
            nz.a.a(bVar, kVar.f33123x.f33129e, "VUI: log2_max_mv_length_vertical");
            nz.a.a(bVar, kVar.f33123x.f33130f, "VUI: num_reorder_frames");
            nz.a.a(bVar, kVar.f33123x.f33131g, "VUI: max_dec_frame_buffering");
        }
    }

    private static b b(a aVar) {
        b bVar = new b();
        bVar.f32998a = nw.a.a(aVar, "SPS: cpb_cnt_minus1");
        bVar.f32999b = nw.a.a(aVar, 4, "HRD: bit_rate_scale");
        bVar.f33000c = nw.a.a(aVar, 4, "HRD: cpb_size_scale");
        bVar.f33001d = new int[(bVar.f32998a + 1)];
        bVar.f33002e = new int[(bVar.f32998a + 1)];
        bVar.f33003f = new boolean[(bVar.f32998a + 1)];
        for (int i2 = 0; i2 <= bVar.f32998a; i2++) {
            bVar.f33001d[i2] = nw.a.a(aVar, "HRD: bit_rate_value_minus1");
            bVar.f33002e[i2] = nw.a.a(aVar, "HRD: cpb_size_value_minus1");
            bVar.f33003f[i2] = nw.a.c(aVar, "HRD: cbr_flag");
        }
        bVar.f33004g = nw.a.a(aVar, 5, "HRD: initial_cpb_removal_delay_length_minus1");
        bVar.f33005h = nw.a.a(aVar, 5, "HRD: cpb_removal_delay_length_minus1");
        bVar.f33006i = nw.a.a(aVar, 5, "HRD: dpb_output_delay_length_minus1");
        bVar.f33007j = nw.a.a(aVar, 5, "HRD: time_offset_length");
        return bVar;
    }

    public void b(ByteBuffer byteBuffer) {
        g gVar;
        b bVar = new b(byteBuffer);
        nz.a.a(bVar, (long) this.f33060n, 8, "SPS: profile_idc");
        nz.a.a(bVar, this.f33061o, "SPS: constraint_set_0_flag");
        nz.a.a(bVar, this.f33062p, "SPS: constraint_set_1_flag");
        nz.a.a(bVar, this.f33063q, "SPS: constraint_set_2_flag");
        nz.a.a(bVar, this.f33064r, "SPS: constraint_set_3_flag");
        nz.a.a(bVar, 0, 4, "SPS: reserved");
        nz.a.a(bVar, (long) this.f33065s, 8, "SPS: level_idc");
        nz.a.a(bVar, this.f33066t, "SPS: seq_parameter_set_id");
        int i2 = this.f33060n;
        boolean z2 = false;
        if (i2 == 100 || i2 == 110 || i2 == 122 || i2 == 144) {
            nz.a.a(bVar, a(this.f33052f), "SPS: chroma_format_idc");
            if (this.f33052f == ColorSpace.YUV444) {
                nz.a.a(bVar, this.f33067u, "SPS: residual_color_transform_flag");
            }
            nz.a.a(bVar, this.f33057k, "SPS: ");
            nz.a.a(bVar, this.f33058l, "SPS: ");
            nz.a.a(bVar, this.f33059m, "SPS: qpprime_y_zero_transform_bypass_flag");
            nz.a.a(bVar, this.H != null, "SPS: ");
            if (this.H != null) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if (i3 < 6) {
                        nz.a.a(bVar, this.H.f33045a[i3] != null, "SPS: ");
                        if (this.H.f33045a[i3] != null) {
                            gVar = this.H.f33045a[i3];
                        }
                    } else {
                        int i4 = i3 - 6;
                        nz.a.a(bVar, this.H.f33046b[i4] != null, "SPS: ");
                        if (this.H.f33046b[i4] != null) {
                            gVar = this.H.f33046b[i4];
                        }
                    }
                    gVar.a(bVar);
                }
            }
        }
        nz.a.a(bVar, this.f33053g, "SPS: log2_max_frame_num_minus4");
        nz.a.a(bVar, this.f33047a, "SPS: pic_order_cnt_type");
        int i5 = this.f33047a;
        if (i5 == 0) {
            nz.a.a(bVar, this.f33054h, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (i5 == 1) {
            nz.a.a(bVar, this.f33049c, "SPS: delta_pic_order_always_zero_flag");
            nz.a.b(bVar, this.f33068v, "SPS: offset_for_non_ref_pic");
            nz.a.b(bVar, this.f33069w, "SPS: offset_for_top_to_bottom_field");
            nz.a.a(bVar, this.F.length, "SPS: ");
            int i6 = 0;
            while (true) {
                int[] iArr = this.F;
                if (i6 >= iArr.length) {
                    break;
                }
                nz.a.b(bVar, iArr[i6], "SPS: ");
                i6++;
            }
        }
        nz.a.a(bVar, this.f33070x, "SPS: num_ref_frames");
        nz.a.a(bVar, this.f33071y, "SPS: gaps_in_frame_num_value_allowed_flag");
        nz.a.a(bVar, this.f33056j, "SPS: pic_width_in_mbs_minus1");
        nz.a.a(bVar, this.f33055i, "SPS: pic_height_in_map_units_minus1");
        nz.a.a(bVar, this.f33072z, "SPS: frame_mbs_only_flag");
        if (!this.f33072z) {
            nz.a.a(bVar, this.f33050d, "SPS: mb_adaptive_frame_field_flag");
        }
        nz.a.a(bVar, this.f33051e, "SPS: direct_8x8_inference_flag");
        nz.a.a(bVar, this.A, "SPS: frame_cropping_flag");
        if (this.A) {
            nz.a.a(bVar, this.B, "SPS: frame_crop_left_offset");
            nz.a.a(bVar, this.C, "SPS: frame_crop_right_offset");
            nz.a.a(bVar, this.D, "SPS: frame_crop_top_offset");
            nz.a.a(bVar, this.E, "SPS: frame_crop_bottom_offset");
        }
        if (this.G != null) {
            z2 = true;
        }
        nz.a.a(bVar, z2, "SPS: ");
        k kVar = this.G;
        if (kVar != null) {
            a(kVar, bVar);
        }
        nz.a.a(bVar);
    }
}
