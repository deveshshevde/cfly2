package com.sun.mail.imap.protocol;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

public class BASE64MailboxEncoder {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};
    protected byte[] buffer = new byte[4];
    protected int bufsize = 0;
    protected Writer out = null;
    protected boolean started = false;

    public BASE64MailboxEncoder(Writer writer) {
        this.out = writer;
    }

    public static String encode(String str) {
        CharArrayWriter charArrayWriter = new CharArrayWriter(r1);
        BASE64MailboxEncoder bASE64MailboxEncoder = null;
        boolean z2 = false;
        for (char c2 : str.toCharArray()) {
            if (c2 < ' ' || c2 > '~') {
                if (bASE64MailboxEncoder == null) {
                    bASE64MailboxEncoder = new BASE64MailboxEncoder(charArrayWriter);
                    z2 = true;
                }
                bASE64MailboxEncoder.write(c2);
            } else {
                if (bASE64MailboxEncoder != null) {
                    bASE64MailboxEncoder.flush();
                }
                if (c2 == '&') {
                    charArrayWriter.write(38);
                    charArrayWriter.write(45);
                    z2 = true;
                } else {
                    charArrayWriter.write(c2);
                }
            }
        }
        if (bASE64MailboxEncoder != null) {
            bASE64MailboxEncoder.flush();
        }
        return z2 ? charArrayWriter.toString() : str;
    }

    /* access modifiers changed from: protected */
    public void encode() throws IOException {
        Writer writer;
        char c2;
        int i2 = this.bufsize;
        if (i2 == 1) {
            byte b2 = this.buffer[0];
            Writer writer2 = this.out;
            char[] cArr = pem_array;
            writer2.write(cArr[(b2 >>> 2) & 63]);
            writer = this.out;
            c2 = cArr[((b2 << 4) & 48) + 0];
        } else if (i2 == 2) {
            byte[] bArr = this.buffer;
            byte b3 = bArr[0];
            byte b4 = bArr[1];
            Writer writer3 = this.out;
            char[] cArr2 = pem_array;
            writer3.write(cArr2[(b3 >>> 2) & 63]);
            this.out.write(cArr2[((b3 << 4) & 48) + ((b4 >>> 4) & 15)]);
            writer = this.out;
            c2 = cArr2[((b4 << 2) & 60) + 0];
        } else {
            byte[] bArr2 = this.buffer;
            byte b5 = bArr2[0];
            byte b6 = bArr2[1];
            byte b7 = bArr2[2];
            Writer writer4 = this.out;
            char[] cArr3 = pem_array;
            writer4.write(cArr3[(b5 >>> 2) & 63]);
            this.out.write(cArr3[((b5 << 4) & 48) + ((b6 >>> 4) & 15)]);
            this.out.write(cArr3[((b6 << 2) & 60) + ((b7 >>> 6) & 3)]);
            this.out.write(cArr3[b7 & 63]);
            if (this.bufsize == 4) {
                byte[] bArr3 = this.buffer;
                bArr3[0] = bArr3[3];
                return;
            }
            return;
        }
        writer.write(c2);
    }

    public void flush() {
        try {
            if (this.bufsize > 0) {
                encode();
                this.bufsize = 0;
            }
            if (this.started) {
                this.out.write(45);
                this.started = false;
            }
        } catch (IOException unused) {
        }
    }

    public void write(int i2) {
        try {
            if (!this.started) {
                this.started = true;
                this.out.write(38);
            }
            byte[] bArr = this.buffer;
            int i3 = this.bufsize;
            int i4 = i3 + 1;
            this.bufsize = i4;
            bArr[i3] = (byte) (i2 >> 8);
            int i5 = i4 + 1;
            this.bufsize = i5;
            bArr[i4] = (byte) (i2 & 255);
            if (i5 >= 3) {
                encode();
                this.bufsize -= 3;
            }
        } catch (IOException unused) {
        }
    }
}
