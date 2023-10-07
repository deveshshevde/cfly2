package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f15515a;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.a$a  reason: collision with other inner class name */
    static final class C0110a extends a {

        /* renamed from: b  reason: collision with root package name */
        public final long f15516b;

        /* renamed from: c  reason: collision with root package name */
        public final List<b> f15517c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final List<C0110a> f15518d = new ArrayList();

        public C0110a(int i2, long j2) {
            super(i2);
            this.f15516b = j2;
        }

        public void a(C0110a aVar) {
            this.f15518d.add(aVar);
        }

        public void a(b bVar) {
            this.f15517c.add(bVar);
        }

        public b d(int i2) {
            int size = this.f15517c.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f15517c.get(i3);
                if (bVar.f15515a == i2) {
                    return bVar;
                }
            }
            return null;
        }

        public C0110a e(int i2) {
            int size = this.f15518d.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0110a aVar = this.f15518d.get(i3);
                if (aVar.f15515a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            String c2 = c(this.f15515a);
            String arrays = Arrays.toString(this.f15517c.toArray());
            String arrays2 = Arrays.toString(this.f15518d.toArray());
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
            sb.append(c2);
            sb.append(" leaves: ");
            sb.append(arrays);
            sb.append(" containers: ");
            sb.append(arrays2);
            return sb.toString();
        }
    }

    static final class b extends a {

        /* renamed from: b  reason: collision with root package name */
        public final q f15519b;

        public b(int i2, q qVar) {
            super(i2);
            this.f15519b = qVar;
        }
    }

    public a(int i2) {
        this.f15515a = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i2 >> 24) & 255));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }

    public String toString() {
        return c(this.f15515a);
    }
}
