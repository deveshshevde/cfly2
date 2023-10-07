package kn;

import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<ko.a> f30159a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a> f30160b = new ArrayList();

    public interface a {
        void a(List<ko.a> list);
    }

    public List<ko.a> a() {
        return this.f30159a;
    }

    public void a(List<ko.a> list) {
        if (list != null && !list.isEmpty()) {
            for (ko.a remove : list) {
                this.f30159a.remove(remove);
            }
            c();
        }
    }

    public void a(a aVar) {
        this.f30160b.add(aVar);
    }

    public void a(ko.a aVar) {
        this.f30159a.remove(aVar);
        c();
    }

    public void b() {
        this.f30159a.clear();
        c();
    }

    public void b(List<ko.a> list) {
        this.f30159a.clear();
        this.f30159a.addAll(list);
        c();
    }

    public void b(a aVar) {
        this.f30160b.remove(aVar);
    }

    public void b(ko.a aVar) {
        this.f30159a.clear();
        this.f30159a.add(aVar);
        c();
    }

    public void c() {
        for (a a2 : this.f30160b) {
            a2.a(this.f30159a);
        }
    }

    public void c(List<ko.a> list) {
        this.f30159a.addAll(list);
        c();
    }

    public void c(ko.a aVar) {
        this.f30159a.add(aVar);
        c();
    }

    public boolean d(ko.a aVar) {
        return this.f30159a.contains(aVar);
    }
}
