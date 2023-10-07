package fq;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;
import fj.i;
import java.util.Collections;
import java.util.List;

public interface ac {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f27701a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27702b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f27703c;

        public a(String str, int i2, byte[] bArr) {
            this.f27701a = str;
            this.f27702b = i2;
            this.f27703c = bArr;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f27704a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27705b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f27706c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f27707d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            this.f27704a = i2;
            this.f27705b = str;
            this.f27706c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f27707d = bArr;
        }
    }

    public interface c {
        SparseArray<ac> a();

        ac a(int i2, b bVar);
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f27708a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27709b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27710c;

        /* renamed from: d  reason: collision with root package name */
        private int f27711d;

        /* renamed from: e  reason: collision with root package name */
        private String f27712e;

        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        public d(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(12);
                sb.append(i2);
                sb.append("/");
                str = sb.toString();
            } else {
                str = "";
            }
            this.f27708a = str;
            this.f27709b = i3;
            this.f27710c = i4;
            this.f27711d = Integer.MIN_VALUE;
        }

        private void d() {
            if (this.f27711d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2 = this.f27711d;
            int i3 = i2 == Integer.MIN_VALUE ? this.f27709b : i2 + this.f27710c;
            this.f27711d = i3;
            String str = this.f27708a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
            sb.append(str);
            sb.append(i3);
            this.f27712e = sb.toString();
        }

        public int b() {
            d();
            return this.f27711d;
        }

        public String c() {
            d();
            return this.f27712e;
        }
    }

    void a();

    void a(aa aaVar, i iVar, d dVar);

    void a(q qVar, int i2) throws ParserException;
}
