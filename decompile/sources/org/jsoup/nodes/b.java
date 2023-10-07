package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;
import org.jsoup.parser.d;

public class b implements Cloneable, Iterable<a> {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f33655c = new String[0];

    /* renamed from: a  reason: collision with root package name */
    String[] f33656a;

    /* renamed from: b  reason: collision with root package name */
    String[] f33657b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f33658d = 0;

    public b() {
        String[] strArr = f33655c;
        this.f33656a = strArr;
        this.f33657b = strArr;
    }

    private void a(int i2) {
        c.a(i2 >= this.f33658d);
        String[] strArr = this.f33656a;
        int length = strArr.length;
        if (length < i2) {
            int i3 = 2;
            if (length >= 2) {
                i3 = this.f33658d * 2;
            }
            if (i2 <= i3) {
                i2 = i3;
            }
            this.f33656a = a(strArr, i2);
            this.f33657b = a(this.f33657b, i2);
        }
    }

    private static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i2));
        return strArr2;
    }

    static String b(String str) {
        return str == null ? "" : str;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        c.b(i2 >= this.f33658d);
        int i3 = (this.f33658d - i2) - 1;
        if (i3 > 0) {
            String[] strArr = this.f33656a;
            int i4 = i2 + 1;
            System.arraycopy(strArr, i4, strArr, i2, i3);
            String[] strArr2 = this.f33657b;
            System.arraycopy(strArr2, i4, strArr2, i2, i3);
        }
        int i5 = this.f33658d - 1;
        this.f33658d = i5;
        this.f33656a[i5] = null;
        this.f33657b[i5] = null;
    }

    static String g(String str) {
        return '/' + str;
    }

    private int h(String str) {
        c.a((Object) str);
        for (int i2 = 0; i2 < this.f33658d; i2++) {
            if (str.equalsIgnoreCase(this.f33656a[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public boolean i(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    public int a() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f33658d; i3++) {
            if (!i(this.f33656a[i3])) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int a(String str) {
        c.a((Object) str);
        for (int i2 = 0; i2 < this.f33658d; i2++) {
            if (str.equals(this.f33656a[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public int a(d dVar) {
        int i2 = 0;
        if (b()) {
            return 0;
        }
        boolean b2 = dVar.b();
        int i3 = 0;
        while (i2 < this.f33656a.length) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                String[] strArr = this.f33656a;
                if (i5 >= strArr.length || strArr[i5] == null) {
                    i2 = i4;
                } else {
                    if (!b2 || !strArr[i2].equals(strArr[i5])) {
                        if (!b2) {
                            String[] strArr2 = this.f33656a;
                            if (!strArr2[i2].equalsIgnoreCase(strArr2[i5])) {
                            }
                        }
                        i5++;
                    }
                    i3++;
                    b(i5);
                    i5--;
                    i5++;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    public b a(String str, String str2) {
        a(this.f33658d + 1);
        String[] strArr = this.f33656a;
        int i2 = this.f33658d;
        strArr[i2] = str;
        this.f33657b[i2] = str2;
        this.f33658d = i2 + 1;
        return this;
    }

    public b a(a aVar) {
        c.a((Object) aVar);
        b(aVar.getKey(), aVar.getValue());
        aVar.f33652a = this;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void a(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i2 = this.f33658d;
        for (int i3 = 0; i3 < i2; i3++) {
            if (!i(this.f33656a[i3])) {
                String str = this.f33656a[i3];
                String str2 = this.f33657b[i3];
                appendable.append(' ').append(str);
                if (!a.a(str, str2, outputSettings)) {
                    appendable.append("=\"");
                    if (str2 == null) {
                        str2 = "";
                    }
                    Entities.a(appendable, str2, outputSettings, true, false, false);
                    appendable.append('\"');
                }
            }
        }
    }

    public void a(b bVar) {
        if (bVar.a() != 0) {
            a(this.f33658d + bVar.f33658d);
            Iterator<a> it2 = bVar.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
    }

    public b b(String str, String str2) {
        c.a((Object) str);
        int a2 = a(str);
        if (a2 != -1) {
            this.f33657b[a2] = str2;
        } else {
            a(str, str2);
        }
        return this;
    }

    public boolean b() {
        return this.f33658d == 0;
    }

    public String c(String str) {
        int a2 = a(str);
        return a2 == -1 ? "" : b(this.f33657b[a2]);
    }

    public List<a> c() {
        ArrayList arrayList = new ArrayList(this.f33658d);
        for (int i2 = 0; i2 < this.f33658d; i2++) {
            if (!i(this.f33656a[i2])) {
                arrayList.add(new a(this.f33656a[i2], this.f33657b[i2], this));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void c(String str, String str2) {
        int h2 = h(str);
        if (h2 != -1) {
            this.f33657b[h2] = str2;
            if (!this.f33656a[h2].equals(str)) {
                this.f33656a[h2] = str;
                return;
            }
            return;
        }
        a(str, str2);
    }

    public String d() {
        StringBuilder a2 = oh.c.a();
        try {
            a((Appendable) a2, new Document("").j());
            return oh.c.a(a2);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public String d(String str) {
        int h2 = h(str);
        return h2 == -1 ? "" : b(this.f33657b[h2]);
    }

    /* renamed from: e */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f33658d = this.f33658d;
            this.f33656a = a(this.f33656a, this.f33658d);
            this.f33657b = a(this.f33657b, this.f33658d);
            return bVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean e(String str) {
        return a(str) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f33658d == bVar.f33658d && Arrays.equals(this.f33656a, bVar.f33656a)) {
            return Arrays.equals(this.f33657b, bVar.f33657b);
        }
        return false;
    }

    public void f() {
        for (int i2 = 0; i2 < this.f33658d; i2++) {
            String[] strArr = this.f33656a;
            strArr[i2] = oh.b.a(strArr[i2]);
        }
    }

    public boolean f(String str) {
        return h(str) != -1;
    }

    public int hashCode() {
        return (((this.f33658d * 31) + Arrays.hashCode(this.f33656a)) * 31) + Arrays.hashCode(this.f33657b);
    }

    public Iterator<a> iterator() {
        return new Iterator<a>() {

            /* renamed from: a  reason: collision with root package name */
            int f33659a = 0;

            /* renamed from: a */
            public a next() {
                a aVar = new a(b.this.f33656a[this.f33659a], b.this.f33657b[this.f33659a], b.this);
                this.f33659a++;
                return aVar;
            }

            public boolean hasNext() {
                while (this.f33659a < b.this.f33658d) {
                    b bVar = b.this;
                    if (!bVar.i(bVar.f33656a[this.f33659a])) {
                        break;
                    }
                    this.f33659a++;
                }
                return this.f33659a < b.this.f33658d;
            }

            public void remove() {
                b bVar = b.this;
                int i2 = this.f33659a - 1;
                this.f33659a = i2;
                bVar.b(i2);
            }
        };
    }

    public String toString() {
        return d();
    }
}
