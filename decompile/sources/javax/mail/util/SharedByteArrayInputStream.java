package javax.mail.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.mail.internet.SharedInputStream;

public class SharedByteArrayInputStream extends ByteArrayInputStream implements SharedInputStream {
    protected int start = 0;

    public SharedByteArrayInputStream(byte[] bArr) {
        super(bArr);
    }

    public SharedByteArrayInputStream(byte[] bArr, int i2, int i3) {
        super(bArr, i2, i3);
        this.start = i2;
    }

    public long getPosition() {
        return (long) (this.pos - this.start);
    }

    public InputStream newStream(long j2, long j3) {
        if (j2 >= 0) {
            if (j3 == -1) {
                j3 = (long) (this.count - this.start);
            }
            return new SharedByteArrayInputStream(this.buf, this.start + ((int) j2), (int) (j3 - j2));
        }
        throw new IllegalArgumentException("start < 0");
    }
}
