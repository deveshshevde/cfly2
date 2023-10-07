package bo;

import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;

public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f5934a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f5935a = new a<>();

        public static <T> a<T> b() {
            return f5935a;
        }

        public n<Model, Model> a(r rVar) {
            return v.a();
        }

        public void a() {
        }
    }

    private static class b<Model> implements d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f5936a;

        b(Model model) {
            this.f5936a = model;
        }

        public Class<Model> a() {
            return this.f5936a.getClass();
        }

        public void a(Priority priority, d.a<? super Model> aVar) {
            aVar.a(this.f5936a);
        }

        public void b() {
        }

        public void c() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static <T> v<T> a() {
        return f5934a;
    }

    public n.a<Model> a(Model model, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(model), new b(model));
    }

    public boolean a(Model model) {
        return true;
    }
}
