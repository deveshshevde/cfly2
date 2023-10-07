package nf;

import java.io.File;
import java.io.IOException;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f31551a = new a() {
        public void a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void a(File file, File file2) throws IOException {
            a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public boolean b(File file) {
            return file.exists();
        }

        public long c(File file) {
            return file.length();
        }
    };

    void a(File file) throws IOException;

    void a(File file, File file2) throws IOException;

    boolean b(File file);

    long c(File file);
}
