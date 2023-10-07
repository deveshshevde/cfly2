package in;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.List;

public interface a {

    /* renamed from: in.a$a  reason: collision with other inner class name */
    public interface C0100a extends Iterable<FileDownloadModel> {
        void a();

        void a(int i2, FileDownloadModel fileDownloadModel);

        void a(FileDownloadModel fileDownloadModel);

        void b(FileDownloadModel fileDownloadModel);
    }

    void a();

    void a(int i2);

    void a(int i2, int i3);

    void a(int i2, int i3, long j2);

    void a(int i2, long j2);

    void a(int i2, long j2, String str, String str2);

    void a(int i2, String str, long j2, long j3, int i3);

    void a(int i2, Throwable th);

    void a(int i2, Throwable th, long j2);

    void a(FileDownloadModel fileDownloadModel);

    void a(com.liulishuo.filedownloader.model.a aVar);

    FileDownloadModel b(int i2);

    C0100a b();

    void b(int i2, long j2);

    List<com.liulishuo.filedownloader.model.a> c(int i2);

    void c(int i2, long j2);

    void d(int i2);

    boolean e(int i2);

    void f(int i2);
}
