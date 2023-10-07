package in;

import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import in.a;
import iq.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    final SparseArray<FileDownloadModel> f13606a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<List<com.liulishuo.filedownloader.model.a>> f13607b = new SparseArray<>();

    class a implements a.C0100a {
        a() {
        }

        public void a() {
        }

        public void a(int i2, FileDownloadModel fileDownloadModel) {
        }

        public void a(FileDownloadModel fileDownloadModel) {
        }

        public void b(FileDownloadModel fileDownloadModel) {
        }

        public Iterator<FileDownloadModel> iterator() {
            return new C0101b();
        }
    }

    /* renamed from: in.b$b  reason: collision with other inner class name */
    class C0101b implements Iterator<FileDownloadModel> {
        C0101b() {
        }

        /* renamed from: a */
        public FileDownloadModel next() {
            return null;
        }

        public boolean hasNext() {
            return false;
        }

        public void remove() {
        }
    }

    public void a() {
        synchronized (this.f13606a) {
            this.f13606a.clear();
        }
    }

    public void a(int i2) {
    }

    public void a(int i2, int i3) {
    }

    public void a(int i2, int i3, long j2) {
        synchronized (this.f13607b) {
            List<com.liulishuo.filedownloader.model.a> list = this.f13607b.get(i2);
            if (list != null) {
                for (com.liulishuo.filedownloader.model.a aVar : list) {
                    if (aVar.b() == i3) {
                        aVar.b(j2);
                        return;
                    }
                }
            }
        }
    }

    public void a(int i2, long j2) {
    }

    public void a(int i2, long j2, String str, String str2) {
    }

    public void a(int i2, String str, long j2, long j3, int i3) {
    }

    public void a(int i2, Throwable th) {
    }

    public void a(int i2, Throwable th, long j2) {
    }

    public void a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            d.d(this, "update but model == null!", new Object[0]);
        } else if (b(fileDownloadModel.a()) != null) {
            synchronized (this.f13606a) {
                this.f13606a.remove(fileDownloadModel.a());
                this.f13606a.put(fileDownloadModel.a(), fileDownloadModel);
            }
        } else {
            b(fileDownloadModel);
        }
    }

    public void a(com.liulishuo.filedownloader.model.a aVar) {
        int a2 = aVar.a();
        synchronized (this.f13607b) {
            List list = this.f13607b.get(a2);
            if (list == null) {
                list = new ArrayList();
                this.f13607b.put(a2, list);
            }
            list.add(aVar);
        }
    }

    public FileDownloadModel b(int i2) {
        FileDownloadModel fileDownloadModel;
        synchronized (this.f13606a) {
            fileDownloadModel = this.f13606a.get(i2);
        }
        return fileDownloadModel;
    }

    public a.C0100a b() {
        return new a();
    }

    public void b(int i2, long j2) {
        e(i2);
    }

    public void b(FileDownloadModel fileDownloadModel) {
        synchronized (this.f13606a) {
            this.f13606a.put(fileDownloadModel.a(), fileDownloadModel);
        }
    }

    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        List list;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f13607b) {
            list = this.f13607b.get(i2);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public void c(int i2, long j2) {
    }

    public void d(int i2) {
        synchronized (this.f13607b) {
            this.f13607b.remove(i2);
        }
    }

    public boolean e(int i2) {
        synchronized (this.f13606a) {
            this.f13606a.remove(i2);
        }
        return true;
    }

    public void f(int i2) {
    }
}
