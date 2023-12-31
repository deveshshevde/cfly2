package org.jcodec.containers.mp4.boxes.channel;

import java.util.regex.Pattern;

public enum Label {
    Unknown(-1),
    Unused(0),
    UseCoordinates(100),
    Left(1),
    Right(2),
    Center(3),
    LFEScreen(4),
    LeftSurround(5),
    RightSurround(6),
    LeftCenter(7),
    RightCenter(8),
    CenterSurround(9),
    LeftSurroundDirect(10),
    RightSurroundDirect(11),
    TopCenterSurround(12),
    VerticalHeightLeft(13),
    VerticalHeightCenter(14),
    VerticalHeightRight(15),
    TopBackLeft(16),
    TopBackCenter(17),
    TopBackRight(18),
    RearSurroundLeft(33),
    RearSurroundRight(34),
    LeftWide(35),
    RightWide(36),
    LFE2(37),
    LeftTotal(38),
    RightTotal(39),
    HearingImpaired(40),
    Narration(41),
    Mono(42),
    DialogCentricMix(43),
    CenterSurroundDirect(44),
    Ambisonic_W(200),
    Ambisonic_X(201),
    Ambisonic_Y(202),
    Ambisonic_Z(203),
    MS_Mid(204),
    MS_Side(205),
    XY_X(206),
    XY_Y(207),
    HeadphonesLeft(301),
    HeadphonesRight(302),
    ClickTrack(304),
    ForeignLanguage(305),
    Discrete(400),
    Discrete_0(65536),
    Discrete_1(65537),
    Discrete_2(65538),
    Discrete_3(65539),
    Discrete_4(65540),
    Discrete_5(65541),
    Discrete_6(65542),
    Discrete_7(65543),
    Discrete_8(65544),
    Discrete_9(65545),
    Discrete_10(65546),
    Discrete_11(65547),
    Discrete_12(65548),
    Discrete_13(65549),
    Discrete_14(65550),
    Discrete_15(65551),
    Discrete_65535(131071);
    

    /* renamed from: an  reason: collision with root package name */
    public static final Pattern f33465an = null;

    /* renamed from: al  reason: collision with root package name */
    final int f33492al;

    /* renamed from: am  reason: collision with root package name */
    final long f33493am;

    static {
        f33465an = Pattern.compile("[_\\ \\.][a-zA-Z]+$");
    }

    private Label(int i2) {
        this.f33492al = i2;
        this.f33493am = (i2 > 18 || i2 < 1) ? 0 : (long) (1 << (i2 - 1));
    }
}
