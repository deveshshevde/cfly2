package com.sun.mail.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.OutputStream;

public class QEncoderStream extends QPEncoderStream {
    private static String TEXT_SPECIALS = "=_?";
    private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
    private String specials;

    public QEncoderStream(OutputStream outputStream, boolean z2) {
        super(outputStream, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        this.specials = z2 ? WORD_SPECIALS : TEXT_SPECIALS;
    }

    public static int encodedLength(byte[] bArr, boolean z2) {
        String str = z2 ? WORD_SPECIALS : TEXT_SPECIALS;
        int i2 = 0;
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            i2 = (b3 < 32 || b3 >= Byte.MAX_VALUE || str.indexOf(b3) >= 0) ? i2 + 3 : i2 + 1;
        }
        return i2;
    }

    public void write(int i2) throws IOException {
        int i3 = i2 & 255;
        boolean z2 = false;
        if (i3 == 32) {
            i3 = 95;
        } else if (i3 < 32 || i3 >= 127 || this.specials.indexOf(i3) >= 0) {
            z2 = true;
        }
        output(i3, z2);
    }
}
