package nm;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31596a = false;

    public c(OutputStream outputStream) {
        super(outputStream);
    }

    public synchronized void write(int i2) throws IOException {
        if (i2 != 10) {
            if (i2 == 13) {
                this.f31596a = true;
                this.out.write(13);
                return;
            }
        } else if (!this.f31596a) {
            this.out.write(13);
        }
        this.f31596a = false;
        this.out.write(i2);
    }

    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                int i5 = i2 + 1;
                write((int) bArr[i2]);
                i2 = i5;
                i3 = i4;
            }
        }
    }
}
