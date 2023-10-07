package javax.mail.internet;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;

class AsciiOutputStream extends OutputStream {
    private int ascii = 0;
    private boolean badEOL = false;
    private boolean breakOnNonAscii;
    private boolean checkEOL = false;
    private int lastb = 0;
    private int linelen = 0;
    private boolean longLine = false;
    private int non_ascii = 0;
    private int ret = 0;

    public AsciiOutputStream(boolean z2, boolean z3) {
        boolean z4 = false;
        this.breakOnNonAscii = z2;
        if (z3 && z2) {
            z4 = true;
        }
        this.checkEOL = z4;
    }

    private final void check(int i2) throws IOException {
        int i3;
        int i4 = i2 & 255;
        if (this.checkEOL && (((i3 = this.lastb) == 13 && i4 != 10) || (i3 != 13 && i4 == 10))) {
            this.badEOL = true;
        }
        if (i4 == 13 || i4 == 10) {
            this.linelen = 0;
        } else {
            int i5 = this.linelen + 1;
            this.linelen = i5;
            if (i5 > 998) {
                this.longLine = true;
            }
        }
        if (MimeUtility.nonascii(i4)) {
            this.non_ascii++;
            if (this.breakOnNonAscii) {
                this.ret = 3;
                throw new EOFException();
            }
        } else {
            this.ascii++;
        }
        this.lastb = i4;
    }

    public int getAscii() {
        int i2 = this.ret;
        if (i2 != 0) {
            return i2;
        }
        if (this.badEOL) {
            return 3;
        }
        int i3 = this.non_ascii;
        return i3 == 0 ? this.longLine ? 2 : 1 : this.ascii > i3 ? 2 : 3;
    }

    public void write(int i2) throws IOException {
        check(i2);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i3 + i2;
        while (i2 < i4) {
            check(bArr[i2]);
            i2++;
        }
    }
}
