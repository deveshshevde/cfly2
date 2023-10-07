package org.jcodec.codecs.h264;

import com.xeagle.android.login.amba.connectivity.IChannelListener;
import ny.a;
import od.c;
import od.d;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.b;

public class H264Const {
    public static int[] A = {0, 16, 1, 2, 4, 8, 32, 3, 5, 10, 12, 15, 47, 7, 11, 13, 14, 6, 9, 31, 35, 37, 42, 44, 33, 34, 36, 40, 39, 43, 45, 46, 17, 18, 20, 24, 19, 21, 26, 28, 23, 27, 29, 30, 22, 25, 38, 41};
    public static int[] B = {0, 1, 2, 4, 8, 3, 5, 10, 12, 15, 7, 11, 13, 14, 6, 9};
    public static int[] C = {0, 1, 2, 3, 4, 5, 5, 4, 4, 3, 3, 4, 4, 4, 5, 5, 4, 4, 4, 4, 3, 3, 6, 7, 7, 7, 8, 9, 10, 9, 8, 7, 7, 6, 11, 12, 13, 11, 6, 7, 8, 9, 14, 10, 9, 8, 6, 11, 12, 13, 11, 6, 9, 14, 10, 9, 11, 12, 13, 11, 14, 10, 12};
    public static int[] D = {0, 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7, 8, 4, 5, 6, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 13, 13, 9, 9, 10, 10, 8, 13, 13, 9, 9, 10, 10, 14, 14, 14, 14, 14};
    public static int[] E = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8};
    public static int[] F = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static int[] G = {0, 1, 2, 3};
    public static PartPred[] H = {PartPred.Direct, PartPred.L0, PartPred.L1, PartPred.Bi, PartPred.L0, PartPred.L0, PartPred.L1, PartPred.L1, PartPred.Bi, PartPred.Bi, PartPred.L0, PartPred.L1, PartPred.Bi};
    public static int[] I = {0, 0, 0, 0, 1, 2, 1, 2, 1, 2, 3, 3, 3};

    /* renamed from: a  reason: collision with root package name */
    public static c[] f32894a = new c[10];

    /* renamed from: b  reason: collision with root package name */
    public static c f32895b;

    /* renamed from: c  reason: collision with root package name */
    public static c f32896c;

    /* renamed from: d  reason: collision with root package name */
    public static c[] f32897d = {new d().a(0, "1").a(1, "0").a(), new d().a(0, "1").a(1, "01").a(2, "00").a(), new d().a(0, "11").a(1, "10").a(2, "01").a(3, "00").a(), new d().a(0, "11").a(1, "10").a(2, "01").a(3, "001").a(4, "000").a(), new d().a(0, "11").a(1, "10").a(2, "011").a(3, "010").a(4, "001").a(5, "000").a(), new d().a(0, "11").a(1, "000").a(2, "001").a(3, "011").a(4, "010").a(5, "101").a(6, "100").a(), new d().a(0, "111").a(1, "110").a(2, "101").a(3, "100").a(4, "011").a(5, "010").a(6, "001").a(7, "0001").a(8, "00001").a(9, "000001").a(10, "0000001").a(11, "00000001").a(12, "000000001").a(13, "0000000001").a(14, "00000000001").a()};

    /* renamed from: e  reason: collision with root package name */
    public static c[] f32898e = {new d().a(0, "1").a(1, "011").a(2, "010").a(3, "0011").a(4, "0010").a(5, "00011").a(6, "00010").a(7, "000011").a(8, "000010").a(9, "0000011").a(10, "0000010").a(11, "00000011").a(12, "00000010").a(13, "000000011").a(14, "000000010").a(15, "000000001").a(), new d().a(0, "111").a(1, "110").a(2, "101").a(3, "100").a(4, "011").a(5, "0101").a(6, "0100").a(7, "0011").a(8, "0010").a(9, "00011").a(10, "00010").a(11, "000011").a(12, "000010").a(13, "000001").a(14, "000000").a(), new d().a(0, "0101").a(1, "111").a(2, "110").a(3, "101").a(4, "0100").a(5, "0011").a(6, "100").a(7, "011").a(8, "0010").a(9, "00011").a(10, "00010").a(11, "000001").a(12, "00001").a(13, "000000").a(), new d().a(0, "00011").a(1, "111").a(2, "0101").a(3, "0100").a(4, "110").a(5, "101").a(6, "100").a(7, "0011").a(8, "011").a(9, "0010").a(10, "00010").a(11, "00001").a(12, "00000").a(), new d().a(0, "0101").a(1, "0100").a(2, "0011").a(3, "111").a(4, "110").a(5, "101").a(6, "100").a(7, "011").a(8, "0010").a(9, "00001").a(10, "0001").a(11, "00000").a(), new d().a(0, "000001").a(1, "00001").a(2, "111").a(3, "110").a(4, "101").a(5, "100").a(6, "011").a(7, "010").a(8, "0001").a(9, "001").a(10, "000000").a(), new d().a(0, "000001").a(1, "00001").a(2, "101").a(3, "100").a(4, "011").a(5, "11").a(6, "010").a(7, "0001").a(8, "001").a(9, "000000").a(), new d().a(0, "000001").a(1, "0001").a(2, "00001").a(3, "011").a(4, "11").a(5, "10").a(6, "010").a(7, "001").a(8, "000000").a(), new d().a(0, "000001").a(1, "000000").a(2, "0001").a(3, "11").a(4, "10").a(5, "001").a(6, "01").a(7, "00001").a(), new d().a(0, "00001").a(1, "00000").a(2, "001").a(3, "11").a(4, "10").a(5, "01").a(6, "0001").a(), new d().a(0, "0000").a(1, "0001").a(2, "001").a(3, "010").a(4, "1").a(5, "011").a(), new d().a(0, "0000").a(1, "0001").a(2, "01").a(3, "1").a(4, "001").a(), new d().a(0, "000").a(1, "001").a(2, "1").a(3, "01").a(), new d().a(0, "00").a(1, "01").a(2, "1").a(), new d().a(0, "0").a(1, "1").a()};

    /* renamed from: f  reason: collision with root package name */
    public static c[] f32899f = {new d().a(0, "1").a(1, "01").a(2, "001").a(3, "000").a(), new d().a(0, "1").a(1, "01").a(2, "00").a(), new d().a(0, "1").a(1, "0").a()};

    /* renamed from: g  reason: collision with root package name */
    public static c[] f32900g = {new d().a(0, "1").a(1, "010").a(2, "011").a(3, "0010").a(4, "0011").a(5, "0001").a(6, "00001").a(7, "00000").a(), new d().a(0, "000").a(1, "01").a(2, "001").a(3, "100").a(4, "101").a(5, "110").a(6, "111").a(), new d().a(0, "000").a(1, "001").a(2, "01").a(3, "10").a(4, "110").a(5, "111").a(), new d().a(0, "110").a(1, "00").a(2, "01").a(3, "10").a(4, "111").a(), new d().a(0, "00").a(1, "01").a(2, "10").a(3, "11").a(), new d().a(0, "00").a(1, "01").a(2, "1").a(), new d().a(0, "0").a(1, "1").a()};

    /* renamed from: h  reason: collision with root package name */
    public static PartPred[][] f32901h = {null, new PartPred[]{PartPred.L0}, new PartPred[]{PartPred.L1}, new PartPred[]{PartPred.Bi}, new PartPred[]{PartPred.L0, PartPred.L0}, new PartPred[]{PartPred.L0, PartPred.L0}, new PartPred[]{PartPred.L1, PartPred.L1}, new PartPred[]{PartPred.L1, PartPred.L1}, new PartPred[]{PartPred.L0, PartPred.L1}, new PartPred[]{PartPred.L0, PartPred.L1}, new PartPred[]{PartPred.L1, PartPred.L0}, new PartPred[]{PartPred.L1, PartPred.L0}, new PartPred[]{PartPred.L0, PartPred.Bi}, new PartPred[]{PartPred.L0, PartPred.Bi}, new PartPred[]{PartPred.L1, PartPred.Bi}, new PartPred[]{PartPred.L1, PartPred.Bi}, new PartPred[]{PartPred.Bi, PartPred.L0}, new PartPred[]{PartPred.Bi, PartPred.L0}, new PartPred[]{PartPred.Bi, PartPred.L1}, new PartPred[]{PartPred.Bi, PartPred.L1}, new PartPred[]{PartPred.Bi, PartPred.Bi}, new PartPred[]{PartPred.Bi, PartPred.Bi}};

    /* renamed from: i  reason: collision with root package name */
    public static MBType[] f32902i = {MBType.B_Direct_16x16, MBType.B_L0_16x16, MBType.B_L1_16x16, MBType.B_Bi_16x16, MBType.B_L0_L0_16x8, MBType.B_L0_L0_8x16, MBType.B_L1_L1_16x8, MBType.B_L1_L1_8x16, MBType.B_L0_L1_16x8, MBType.B_L0_L1_8x16, MBType.B_L1_L0_16x8, MBType.B_L1_L0_8x16, MBType.B_L0_Bi_16x8, MBType.B_L0_Bi_8x16, MBType.B_L1_Bi_16x8, MBType.B_L1_Bi_8x16, MBType.B_Bi_L0_16x8, MBType.B_Bi_L0_8x16, MBType.B_Bi_L1_16x8, MBType.B_Bi_L1_8x16, MBType.B_Bi_Bi_16x8, MBType.B_Bi_Bi_8x16, MBType.B_8x8};

    /* renamed from: j  reason: collision with root package name */
    public static int[] f32903j = {0, 16, 16, 16, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8};

    /* renamed from: k  reason: collision with root package name */
    public static int[] f32904k = {0, 16, 16, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16};

    /* renamed from: l  reason: collision with root package name */
    public static int[] f32905l = {0, 4, 0, 4, 8, 12, 8, 12, 0, 4, 0, 4, 8, 12, 8, 12};

    /* renamed from: m  reason: collision with root package name */
    public static int[] f32906m = {0, 0, 4, 4, 0, 0, 4, 4, 8, 8, 12, 12, 8, 8, 12, 12};

    /* renamed from: n  reason: collision with root package name */
    public static int[] f32907n = {0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 10, 11, 14, 15};

    /* renamed from: o  reason: collision with root package name */
    public static int[] f32908o = {0, 1, 0, 1, 2, 3, 2, 3, 0, 1, 0, 1, 2, 3, 2, 3};

    /* renamed from: p  reason: collision with root package name */
    public static int[] f32909p = {0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 3, 3};

    /* renamed from: q  reason: collision with root package name */
    public static final int[] f32910q = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 38, 39, 39, 39, 39};

    /* renamed from: r  reason: collision with root package name */
    public static final b f32911r = new b(0, 0, (int[][]) null, (ColorSpace) null);

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f32912s = {0, 8, 128, IChannelListener.CMD_CHANNEL_CARD_PROTECTED};

    /* renamed from: t  reason: collision with root package name */
    public static final int[] f32913t = {0, 4, 32, 36};

    /* renamed from: u  reason: collision with root package name */
    public static final int[] f32914u = {0, 4, 8, 12, 64, 68, 72, 76, 128, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 140, 192, 196, 200, 204};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f32915v = {0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 3, 3};

    /* renamed from: w  reason: collision with root package name */
    public static final int[][] f32916w = {new int[]{0, 1, 4, 5}, new int[]{2, 3, 6, 7}, new int[]{8, 9, 12, 13}, new int[]{10, 11, 14, 15}};

    /* renamed from: x  reason: collision with root package name */
    public static final int[][] f32917x = {new int[]{0}, new int[]{1}, new int[]{2}, new int[]{3}};

    /* renamed from: y  reason: collision with root package name */
    public static int[] f32918y = {47, 31, 15, 0, 23, 27, 29, 30, 7, 11, 13, 14, 39, 43, 45, 46, 16, 3, 5, 10, 12, 19, 21, 26, 28, 35, 37, 42, 44, 1, 2, 4, 8, 17, 18, 20, 24, 6, 9, 22, 25, 32, 33, 34, 36, 40, 38, 41};

    /* renamed from: z  reason: collision with root package name */
    public static int[] f32919z = {15, 0, 7, 11, 13, 14, 3, 5, 10, 12, 1, 2, 4, 8, 6, 9};

    public enum PartPred {
        L0,
        L1,
        Bi,
        Direct
    }

    static {
        d dVar = new d();
        dVar.a(0, "1");
        dVar.a(a.a(1, 0), "000101");
        dVar.a(a.a(1, 1), "01");
        dVar.a(a.a(2, 0), "00000111");
        dVar.a(a.a(2, 1), "000100");
        dVar.a(a.a(2, 2), "001");
        dVar.a(a.a(3, 0), "000000111");
        dVar.a(a.a(3, 1), "00000110");
        dVar.a(a.a(3, 2), "0000101");
        dVar.a(a.a(3, 3), "00011");
        dVar.a(a.a(4, 0), "0000000111");
        dVar.a(a.a(4, 1), "000000110");
        dVar.a(a.a(4, 2), "00000101");
        dVar.a(a.a(4, 3), "000011");
        dVar.a(a.a(5, 0), "00000000111");
        dVar.a(a.a(5, 1), "0000000110");
        dVar.a(a.a(5, 2), "000000101");
        dVar.a(a.a(5, 3), "0000100");
        dVar.a(a.a(6, 0), "0000000001111");
        dVar.a(a.a(6, 1), "00000000110");
        dVar.a(a.a(6, 2), "0000000101");
        dVar.a(a.a(6, 3), "00000100");
        dVar.a(a.a(7, 0), "0000000001011");
        dVar.a(a.a(7, 1), "0000000001110");
        dVar.a(a.a(7, 2), "00000000101");
        dVar.a(a.a(7, 3), "000000100");
        dVar.a(a.a(8, 0), "0000000001000");
        dVar.a(a.a(8, 1), "0000000001010");
        dVar.a(a.a(8, 2), "0000000001101");
        dVar.a(a.a(8, 3), "0000000100");
        dVar.a(a.a(9, 0), "00000000001111");
        dVar.a(a.a(9, 1), "00000000001110");
        dVar.a(a.a(9, 2), "0000000001001");
        dVar.a(a.a(9, 3), "00000000100");
        dVar.a(a.a(10, 0), "00000000001011");
        dVar.a(a.a(10, 1), "00000000001010");
        dVar.a(a.a(10, 2), "00000000001101");
        dVar.a(a.a(10, 3), "0000000001100");
        dVar.a(a.a(11, 0), "000000000001111");
        dVar.a(a.a(11, 1), "000000000001110");
        dVar.a(a.a(11, 2), "00000000001001");
        dVar.a(a.a(11, 3), "00000000001100");
        dVar.a(a.a(12, 0), "000000000001011");
        dVar.a(a.a(12, 1), "000000000001010");
        dVar.a(a.a(12, 2), "000000000001101");
        dVar.a(a.a(12, 3), "00000000001000");
        dVar.a(a.a(13, 0), "0000000000001111");
        dVar.a(a.a(13, 1), "000000000000001");
        dVar.a(a.a(13, 2), "000000000001001");
        dVar.a(a.a(13, 3), "000000000001100");
        dVar.a(a.a(14, 0), "0000000000001011");
        dVar.a(a.a(14, 1), "0000000000001110");
        dVar.a(a.a(14, 2), "0000000000001101");
        dVar.a(a.a(14, 3), "000000000001000");
        dVar.a(a.a(15, 0), "0000000000000111");
        dVar.a(a.a(15, 1), "0000000000001010");
        dVar.a(a.a(15, 2), "0000000000001001");
        dVar.a(a.a(15, 3), "0000000000001100");
        dVar.a(a.a(16, 0), "0000000000000100");
        dVar.a(a.a(16, 1), "0000000000000110");
        dVar.a(a.a(16, 2), "0000000000000101");
        dVar.a(a.a(16, 3), "0000000000001000");
        c[] cVarArr = f32894a;
        c a2 = dVar.a();
        cVarArr[1] = a2;
        cVarArr[0] = a2;
        d dVar2 = new d();
        dVar2.a(a.a(0, 0), "11");
        dVar2.a(a.a(1, 0), "001011");
        dVar2.a(a.a(1, 1), "10");
        dVar2.a(a.a(2, 0), "000111");
        dVar2.a(a.a(2, 1), "00111");
        dVar2.a(a.a(2, 2), "011");
        dVar2.a(a.a(3, 0), "0000111");
        dVar2.a(a.a(3, 1), "001010");
        dVar2.a(a.a(3, 2), "001001");
        dVar2.a(a.a(3, 3), "0101");
        dVar2.a(a.a(4, 0), "00000111");
        dVar2.a(a.a(4, 1), "000110");
        dVar2.a(a.a(4, 2), "000101");
        dVar2.a(a.a(4, 3), "0100");
        dVar2.a(a.a(5, 0), "00000100");
        dVar2.a(a.a(5, 1), "0000110");
        dVar2.a(a.a(5, 2), "0000101");
        dVar2.a(a.a(5, 3), "00110");
        dVar2.a(a.a(6, 0), "000000111");
        dVar2.a(a.a(6, 1), "00000110");
        dVar2.a(a.a(6, 2), "00000101");
        dVar2.a(a.a(6, 3), "001000");
        dVar2.a(a.a(7, 0), "00000001111");
        dVar2.a(a.a(7, 1), "000000110");
        dVar2.a(a.a(7, 2), "000000101");
        dVar2.a(a.a(7, 3), "000100");
        dVar2.a(a.a(8, 0), "00000001011");
        dVar2.a(a.a(8, 1), "00000001110");
        dVar2.a(a.a(8, 2), "00000001101");
        dVar2.a(a.a(8, 3), "0000100");
        dVar2.a(a.a(9, 0), "000000001111");
        dVar2.a(a.a(9, 1), "00000001010");
        dVar2.a(a.a(9, 2), "00000001001");
        dVar2.a(a.a(9, 3), "000000100");
        dVar2.a(a.a(10, 0), "000000001011");
        dVar2.a(a.a(10, 1), "000000001110");
        dVar2.a(a.a(10, 2), "000000001101");
        dVar2.a(a.a(10, 3), "00000001100");
        dVar2.a(a.a(11, 0), "000000001000");
        dVar2.a(a.a(11, 1), "000000001010");
        dVar2.a(a.a(11, 2), "000000001001");
        dVar2.a(a.a(11, 3), "00000001000");
        dVar2.a(a.a(12, 0), "0000000001111");
        dVar2.a(a.a(12, 1), "0000000001110");
        dVar2.a(a.a(12, 2), "0000000001101");
        dVar2.a(a.a(12, 3), "000000001100");
        dVar2.a(a.a(13, 0), "0000000001011");
        dVar2.a(a.a(13, 1), "0000000001010");
        dVar2.a(a.a(13, 2), "0000000001001");
        dVar2.a(a.a(13, 3), "0000000001100");
        dVar2.a(a.a(14, 0), "0000000000111");
        dVar2.a(a.a(14, 1), "00000000001011");
        dVar2.a(a.a(14, 2), "0000000000110");
        dVar2.a(a.a(14, 3), "0000000001000");
        dVar2.a(a.a(15, 0), "00000000001001");
        dVar2.a(a.a(15, 1), "00000000001000");
        dVar2.a(a.a(15, 2), "00000000001010");
        dVar2.a(a.a(15, 3), "0000000000001");
        dVar2.a(a.a(16, 0), "00000000000111");
        dVar2.a(a.a(16, 1), "00000000000110");
        dVar2.a(a.a(16, 2), "00000000000101");
        dVar2.a(a.a(16, 3), "00000000000100");
        c[] cVarArr2 = f32894a;
        c a3 = dVar2.a();
        cVarArr2[3] = a3;
        cVarArr2[2] = a3;
        d dVar3 = new d();
        dVar3.a(a.a(0, 0), "1111");
        dVar3.a(a.a(1, 0), "001111");
        dVar3.a(a.a(1, 1), "1110");
        dVar3.a(a.a(2, 0), "001011");
        dVar3.a(a.a(2, 1), "01111");
        dVar3.a(a.a(2, 2), "1101");
        dVar3.a(a.a(3, 0), "001000");
        dVar3.a(a.a(3, 1), "01100");
        dVar3.a(a.a(3, 2), "01110");
        dVar3.a(a.a(3, 3), "1100");
        dVar3.a(a.a(4, 0), "0001111");
        dVar3.a(a.a(4, 1), "01010");
        dVar3.a(a.a(4, 2), "01011");
        dVar3.a(a.a(4, 3), "1011");
        dVar3.a(a.a(5, 0), "0001011");
        dVar3.a(a.a(5, 1), "01000");
        dVar3.a(a.a(5, 2), "01001");
        dVar3.a(a.a(5, 3), "1010");
        dVar3.a(a.a(6, 0), "0001001");
        dVar3.a(a.a(6, 1), "001110");
        dVar3.a(a.a(6, 2), "001101");
        dVar3.a(a.a(6, 3), "1001");
        dVar3.a(a.a(7, 0), "0001000");
        dVar3.a(a.a(7, 1), "001010");
        dVar3.a(a.a(7, 2), "001001");
        dVar3.a(a.a(7, 3), "1000");
        dVar3.a(a.a(8, 0), "00001111");
        dVar3.a(a.a(8, 1), "0001110");
        dVar3.a(a.a(8, 2), "0001101");
        dVar3.a(a.a(8, 3), "01101");
        dVar3.a(a.a(9, 0), "00001011");
        dVar3.a(a.a(9, 1), "00001110");
        dVar3.a(a.a(9, 2), "0001010");
        dVar3.a(a.a(9, 3), "001100");
        dVar3.a(a.a(10, 0), "000001111");
        dVar3.a(a.a(10, 1), "00001010");
        dVar3.a(a.a(10, 2), "00001101");
        dVar3.a(a.a(10, 3), "0001100");
        dVar3.a(a.a(11, 0), "000001011");
        dVar3.a(a.a(11, 1), "000001110");
        dVar3.a(a.a(11, 2), "00001001");
        dVar3.a(a.a(11, 3), "00001100");
        dVar3.a(a.a(12, 0), "000001000");
        dVar3.a(a.a(12, 1), "000001010");
        dVar3.a(a.a(12, 2), "000001101");
        dVar3.a(a.a(12, 3), "00001000");
        dVar3.a(a.a(13, 0), "0000001101");
        dVar3.a(a.a(13, 1), "000000111");
        dVar3.a(a.a(13, 2), "000001001");
        dVar3.a(a.a(13, 3), "000001100");
        dVar3.a(a.a(14, 0), "0000001001");
        dVar3.a(a.a(14, 1), "0000001100");
        dVar3.a(a.a(14, 2), "0000001011");
        dVar3.a(a.a(14, 3), "0000001010");
        dVar3.a(a.a(15, 0), "0000000101");
        dVar3.a(a.a(15, 1), "0000001000");
        dVar3.a(a.a(15, 2), "0000000111");
        dVar3.a(a.a(15, 3), "0000000110");
        dVar3.a(a.a(16, 0), "0000000001");
        dVar3.a(a.a(16, 1), "0000000100");
        dVar3.a(a.a(16, 2), "0000000011");
        dVar3.a(a.a(16, 3), "0000000010");
        c[] cVarArr3 = f32894a;
        c a4 = dVar3.a();
        cVarArr3[7] = a4;
        cVarArr3[6] = a4;
        cVarArr3[5] = a4;
        cVarArr3[4] = a4;
        d dVar4 = new d();
        dVar4.a(a.a(0, 0), "000011");
        dVar4.a(a.a(1, 0), "000000");
        dVar4.a(a.a(1, 1), "000001");
        dVar4.a(a.a(2, 0), "000100");
        dVar4.a(a.a(2, 1), "000101");
        dVar4.a(a.a(2, 2), "000110");
        dVar4.a(a.a(3, 0), "001000");
        dVar4.a(a.a(3, 1), "001001");
        dVar4.a(a.a(3, 2), "001010");
        dVar4.a(a.a(3, 3), "001011");
        dVar4.a(a.a(4, 0), "001100");
        dVar4.a(a.a(4, 1), "001101");
        dVar4.a(a.a(4, 2), "001110");
        dVar4.a(a.a(4, 3), "001111");
        dVar4.a(a.a(5, 0), "010000");
        dVar4.a(a.a(5, 1), "010001");
        dVar4.a(a.a(5, 2), "010010");
        dVar4.a(a.a(5, 3), "010011");
        dVar4.a(a.a(6, 0), "010100");
        dVar4.a(a.a(6, 1), "010101");
        dVar4.a(a.a(6, 2), "010110");
        dVar4.a(a.a(6, 3), "010111");
        dVar4.a(a.a(7, 0), "011000");
        dVar4.a(a.a(7, 1), "011001");
        dVar4.a(a.a(7, 2), "011010");
        dVar4.a(a.a(7, 3), "011011");
        dVar4.a(a.a(8, 0), "011100");
        dVar4.a(a.a(8, 1), "011101");
        dVar4.a(a.a(8, 2), "011110");
        dVar4.a(a.a(8, 3), "011111");
        dVar4.a(a.a(9, 0), "100000");
        dVar4.a(a.a(9, 1), "100001");
        dVar4.a(a.a(9, 2), "100010");
        dVar4.a(a.a(9, 3), "100011");
        dVar4.a(a.a(10, 0), "100100");
        dVar4.a(a.a(10, 1), "100101");
        dVar4.a(a.a(10, 2), "100110");
        dVar4.a(a.a(10, 3), "100111");
        dVar4.a(a.a(11, 0), "101000");
        dVar4.a(a.a(11, 1), "101001");
        dVar4.a(a.a(11, 2), "101010");
        dVar4.a(a.a(11, 3), "101011");
        dVar4.a(a.a(12, 0), "101100");
        dVar4.a(a.a(12, 1), "101101");
        dVar4.a(a.a(12, 2), "101110");
        dVar4.a(a.a(12, 3), "101111");
        dVar4.a(a.a(13, 0), "110000");
        dVar4.a(a.a(13, 1), "110001");
        dVar4.a(a.a(13, 2), "110010");
        dVar4.a(a.a(13, 3), "110011");
        dVar4.a(a.a(14, 0), "110100");
        dVar4.a(a.a(14, 1), "110101");
        dVar4.a(a.a(14, 2), "110110");
        dVar4.a(a.a(14, 3), "110111");
        dVar4.a(a.a(15, 0), "111000");
        dVar4.a(a.a(15, 1), "111001");
        dVar4.a(a.a(15, 2), "111010");
        dVar4.a(a.a(15, 3), "111011");
        dVar4.a(a.a(16, 0), "111100");
        dVar4.a(a.a(16, 1), "111101");
        dVar4.a(a.a(16, 2), "111110");
        dVar4.a(a.a(16, 3), "111111");
        f32894a[8] = dVar4.a();
        d dVar5 = new d();
        dVar5.a(a.a(0, 0), "01");
        dVar5.a(a.a(1, 0), "000111");
        dVar5.a(a.a(1, 1), "1");
        dVar5.a(a.a(2, 0), "000100");
        dVar5.a(a.a(2, 1), "000110");
        dVar5.a(a.a(2, 2), "001");
        dVar5.a(a.a(3, 0), "000011");
        dVar5.a(a.a(3, 1), "0000011");
        dVar5.a(a.a(3, 2), "0000010");
        dVar5.a(a.a(3, 3), "000101");
        dVar5.a(a.a(4, 0), "000010");
        dVar5.a(a.a(4, 1), "00000011");
        dVar5.a(a.a(4, 2), "00000010");
        dVar5.a(a.a(4, 3), "0000000");
        f32895b = dVar5.a();
        d dVar6 = new d();
        dVar6.a(a.a(0, 0), "1");
        dVar6.a(a.a(1, 0), "0001111");
        dVar6.a(a.a(1, 1), "01");
        dVar6.a(a.a(2, 0), "0001110");
        dVar6.a(a.a(2, 1), "0001101");
        dVar6.a(a.a(2, 2), "001");
        dVar6.a(a.a(3, 0), "000000111");
        dVar6.a(a.a(3, 1), "0001100");
        dVar6.a(a.a(3, 2), "0001011");
        dVar6.a(a.a(3, 3), "00001");
        dVar6.a(a.a(4, 0), "000000110");
        dVar6.a(a.a(4, 1), "000000101");
        dVar6.a(a.a(4, 2), "0001010");
        dVar6.a(a.a(4, 3), "000001");
        dVar6.a(a.a(5, 0), "0000000111");
        dVar6.a(a.a(5, 1), "0000000110");
        dVar6.a(a.a(5, 2), "000000100");
        dVar6.a(a.a(5, 3), "0001001");
        dVar6.a(a.a(6, 0), "00000000111");
        dVar6.a(a.a(6, 1), "00000000110");
        dVar6.a(a.a(6, 2), "0000000101");
        dVar6.a(a.a(6, 3), "0001000");
        dVar6.a(a.a(7, 0), "000000000111");
        dVar6.a(a.a(7, 1), "000000000110");
        dVar6.a(a.a(7, 2), "00000000101");
        dVar6.a(a.a(7, 3), "0000000100");
        dVar6.a(a.a(8, 0), "0000000000111");
        dVar6.a(a.a(8, 1), "000000000101");
        dVar6.a(a.a(8, 2), "000000000100");
        dVar6.a(a.a(8, 3), "00000000100");
        f32896c = dVar6.a();
    }
}
