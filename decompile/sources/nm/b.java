package nm;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class b extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final Socket f31595a;

    public b(Socket socket, OutputStream outputStream) {
        super(outputStream);
        this.f31595a = socket;
    }

    public void close() throws IOException {
        super.close();
        this.f31595a.close();
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
    }
}
