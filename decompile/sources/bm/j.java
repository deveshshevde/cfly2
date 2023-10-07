package bm;

import cc.h;
import cc.k;
import cc.l;
import cd.a;
import com.bumptech.glide.load.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import s.e;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final h<c, String> f5823a = new h<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e.a<a> f5824b = cd.a.a(10, new a.C0067a<a>() {
        /* renamed from: a */
        public a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    private static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f5826a;

        /* renamed from: b  reason: collision with root package name */
        private final cd.c f5827b = cd.c.a();

        a(MessageDigest messageDigest) {
            this.f5826a = messageDigest;
        }

        public cd.c f_() {
            return this.f5827b;
        }
    }

    private String b(c cVar) {
        a aVar = (a) k.a(this.f5824b.a());
        try {
            cVar.a(aVar.f5826a);
            return l.a(aVar.f5826a.digest());
        } finally {
            this.f5824b.a(aVar);
        }
    }

    public String a(c cVar) {
        String b2;
        synchronized (this.f5823a) {
            b2 = this.f5823a.b(cVar);
        }
        if (b2 == null) {
            b2 = b(cVar);
        }
        synchronized (this.f5823a) {
            this.f5823a.b(cVar, b2);
        }
        return b2;
    }
}
