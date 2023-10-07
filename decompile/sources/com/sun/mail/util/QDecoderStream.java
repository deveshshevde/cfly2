package com.sun.mail.util;

import java.io.IOException;
import java.io.InputStream;

public class QDecoderStream extends QPDecoderStream {
    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read == 95) {
            return 32;
        }
        if (read != 61) {
            return read;
        }
        this.f21763ba[0] = (byte) this.in.read();
        this.f21763ba[1] = (byte) this.in.read();
        try {
            return ASCIIUtility.parseInt(this.f21763ba, 0, 2, 16);
        } catch (NumberFormatException e2) {
            throw new IOException("Error in QP stream " + e2.getMessage());
        }
    }
}
