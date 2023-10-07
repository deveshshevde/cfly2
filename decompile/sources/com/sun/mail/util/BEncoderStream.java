package com.sun.mail.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.OutputStream;

public class BEncoderStream extends BASE64EncoderStream {
    public BEncoderStream(OutputStream outputStream) {
        super(outputStream, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int encodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }
}
