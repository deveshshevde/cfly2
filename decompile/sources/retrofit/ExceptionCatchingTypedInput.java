package retrofit;

import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

class ExceptionCatchingTypedInput implements TypedInput {
    private final TypedInput delegate;
    private final ExceptionCatchingInputStream delegateStream;

    private static class ExceptionCatchingInputStream extends InputStream {
        private final InputStream delegate;
        /* access modifiers changed from: private */
        public IOException thrownException;

        ExceptionCatchingInputStream(InputStream inputStream) {
            this.delegate = inputStream;
        }

        public int available() throws IOException {
            try {
                return this.delegate.available();
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public void close() throws IOException {
            try {
                this.delegate.close();
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public synchronized void mark(int i2) {
            this.delegate.mark(i2);
        }

        public boolean markSupported() {
            return this.delegate.markSupported();
        }

        public int read() throws IOException {
            try {
                return this.delegate.read();
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public int read(byte[] bArr) throws IOException {
            try {
                return this.delegate.read(bArr);
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            try {
                return this.delegate.read(bArr, i2, i3);
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public synchronized void reset() throws IOException {
            try {
                this.delegate.reset();
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }

        public long skip(long j2) throws IOException {
            try {
                return this.delegate.skip(j2);
            } catch (IOException e2) {
                this.thrownException = e2;
                throw e2;
            }
        }
    }

    ExceptionCatchingTypedInput(TypedInput typedInput) throws IOException {
        this.delegate = typedInput;
        this.delegateStream = new ExceptionCatchingInputStream(typedInput.in());
    }

    /* access modifiers changed from: package-private */
    public IOException getThrownException() {
        return this.delegateStream.thrownException;
    }

    public InputStream in() throws IOException {
        return this.delegateStream;
    }

    public long length() {
        return this.delegate.length();
    }

    public String mimeType() {
        return this.delegate.mimeType();
    }

    /* access modifiers changed from: package-private */
    public boolean threwException() {
        return this.delegateStream.thrownException != null;
    }
}
