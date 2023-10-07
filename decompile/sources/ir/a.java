package ir;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<C0197a> f29074a = null;

    /* renamed from: ir.a$a  reason: collision with other inner class name */
    public interface C0197a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    public abstract a a(long j2);

    public void a() {
    }

    public abstract void a(Interpolator interpolator);

    public void a(C0197a aVar) {
        if (this.f29074a == null) {
            this.f29074a = new ArrayList<>();
        }
        this.f29074a.add(aVar);
    }

    public ArrayList<C0197a> b() {
        return this.f29074a;
    }

    public void b(C0197a aVar) {
        ArrayList<C0197a> arrayList = this.f29074a;
        if (arrayList != null) {
            arrayList.remove(aVar);
            if (this.f29074a.size() == 0) {
                this.f29074a = null;
            }
        }
    }

    /* renamed from: c */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            ArrayList<C0197a> arrayList = this.f29074a;
            if (arrayList != null) {
                aVar.f29074a = new ArrayList<>();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    aVar.f29074a.add(arrayList.get(i2));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
