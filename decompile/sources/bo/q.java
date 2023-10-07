package bo;

import bo.n;
import cc.k;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import s.e;

class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f5908a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f5909b;

    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d<Data>> f5910a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a<List<Throwable>> f5911b;

        /* renamed from: c  reason: collision with root package name */
        private int f5912c = 0;

        /* renamed from: d  reason: collision with root package name */
        private Priority f5913d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f5914e;

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f5915f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5916g;

        a(List<d<Data>> list, e.a<List<Throwable>> aVar) {
            this.f5911b = aVar;
            k.a(list);
            this.f5910a = list;
        }

        private void e() {
            if (!this.f5916g) {
                if (this.f5912c < this.f5910a.size() - 1) {
                    this.f5912c++;
                    a(this.f5913d, this.f5914e);
                    return;
                }
                k.a(this.f5915f);
                this.f5914e.a((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f5915f)));
            }
        }

        public Class<Data> a() {
            return this.f5910a.get(0).a();
        }

        public void a(Priority priority, d.a<? super Data> aVar) {
            this.f5913d = priority;
            this.f5914e = aVar;
            this.f5915f = this.f5911b.a();
            this.f5910a.get(this.f5912c).a(priority, this);
            if (this.f5916g) {
                c();
            }
        }

        public void a(Exception exc) {
            ((List) k.a(this.f5915f)).add(exc);
            e();
        }

        public void a(Data data) {
            if (data != null) {
                this.f5914e.a(data);
            } else {
                e();
            }
        }

        public void b() {
            List<Throwable> list = this.f5915f;
            if (list != null) {
                this.f5911b.a(list);
            }
            this.f5915f = null;
            for (d<Data> b2 : this.f5910a) {
                b2.b();
            }
        }

        public void c() {
            this.f5916g = true;
            for (d<Data> c2 : this.f5910a) {
                c2.c();
            }
        }

        public DataSource d() {
            return this.f5910a.get(0).d();
        }
    }

    q(List<n<Model, Data>> list, e.a<List<Throwable>> aVar) {
        this.f5908a = list;
        this.f5909b = aVar;
    }

    public n.a<Data> a(Model model, int i2, int i3, f fVar) {
        n.a a2;
        int size = this.f5908a.size();
        ArrayList arrayList = new ArrayList(size);
        c cVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n nVar = this.f5908a.get(i4);
            if (nVar.a(model) && (a2 = nVar.a(model, i2, i3, fVar)) != null) {
                cVar = a2.f5901a;
                arrayList.add(a2.f5903c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f5909b));
    }

    public boolean a(Model model) {
        for (n<Model, Data> a2 : this.f5908a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f5908a.toArray()) + '}';
    }
}
