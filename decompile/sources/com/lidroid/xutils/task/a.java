package com.lidroid.xutils.task;

class a<T> {

    /* renamed from: a  reason: collision with root package name */
    a<T> f21138a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21139b = false;

    /* renamed from: c  reason: collision with root package name */
    private d<?> f21140c;

    a(T t2) {
        a(t2);
    }

    public Priority a() {
        return this.f21140c.f21158a;
    }

    public void a(T t2) {
        if (t2 == null) {
            this.f21140c = null;
        } else if (t2 instanceof d) {
            this.f21140c = (d) t2;
            this.f21139b = true;
        } else {
            this.f21140c = new d<>(Priority.DEFAULT, t2);
        }
    }

    public T b() {
        T t2 = this.f21140c;
        if (t2 == null) {
            return null;
        }
        return this.f21139b ? t2 : t2.f21159b;
    }
}
