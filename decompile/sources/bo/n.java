package bo;

import cc.k;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final c f5901a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f5902b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f5903c;

        public a(c cVar, d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(c cVar, List<c> list, d<Data> dVar) {
            this.f5901a = (c) k.a(cVar);
            this.f5902b = (List) k.a(list);
            this.f5903c = (d) k.a(dVar);
        }
    }

    a<Data> a(Model model, int i2, int i3, f fVar);

    boolean a(Model model);
}
