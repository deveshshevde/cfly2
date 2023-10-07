package fg;

public class h extends g {
    public h(j jVar) {
        super(jVar);
    }

    public void a(boolean z2) {
        this.f27234b.reset();
        if (!z2) {
            this.f27234b.postTranslate(this.f27235c.a(), this.f27235c.m() - this.f27235c.d());
            return;
        }
        this.f27234b.setTranslate(-(this.f27235c.n() - this.f27235c.b()), this.f27235c.m() - this.f27235c.d());
        this.f27234b.postScale(-1.0f, 1.0f);
    }
}
