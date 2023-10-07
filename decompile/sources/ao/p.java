package ao;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.d;
import androidx.work.j;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class p {

    /* renamed from: s  reason: collision with root package name */
    public static final i.a<List<b>, List<WorkInfo>> f5493s = new i.a<List<b>, List<WorkInfo>>() {
        public List<WorkInfo> a(List<b> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (b a2 : list) {
                arrayList.add(a2.a());
            }
            return arrayList;
        }
    };

    /* renamed from: t  reason: collision with root package name */
    private static final String f5494t = j.a("WorkSpec");

    /* renamed from: a  reason: collision with root package name */
    public String f5495a;

    /* renamed from: b  reason: collision with root package name */
    public WorkInfo.State f5496b = WorkInfo.State.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f5497c;

    /* renamed from: d  reason: collision with root package name */
    public String f5498d;

    /* renamed from: e  reason: collision with root package name */
    public d f5499e = d.f5146a;

    /* renamed from: f  reason: collision with root package name */
    public d f5500f = d.f5146a;

    /* renamed from: g  reason: collision with root package name */
    public long f5501g;

    /* renamed from: h  reason: collision with root package name */
    public long f5502h;

    /* renamed from: i  reason: collision with root package name */
    public long f5503i;

    /* renamed from: j  reason: collision with root package name */
    public androidx.work.b f5504j = androidx.work.b.f5126a;

    /* renamed from: k  reason: collision with root package name */
    public int f5505k;

    /* renamed from: l  reason: collision with root package name */
    public BackoffPolicy f5506l = BackoffPolicy.EXPONENTIAL;

    /* renamed from: m  reason: collision with root package name */
    public long f5507m = 30000;

    /* renamed from: n  reason: collision with root package name */
    public long f5508n;

    /* renamed from: o  reason: collision with root package name */
    public long f5509o;

    /* renamed from: p  reason: collision with root package name */
    public long f5510p = -1;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5511q;

    /* renamed from: r  reason: collision with root package name */
    public OutOfQuotaPolicy f5512r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5513a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f5514b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5514b != aVar.f5514b) {
                return false;
            }
            return this.f5513a.equals(aVar.f5513a);
        }

        public int hashCode() {
            return (this.f5513a.hashCode() * 31) + this.f5514b.hashCode();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f5515a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f5516b;

        /* renamed from: c  reason: collision with root package name */
        public d f5517c;

        /* renamed from: d  reason: collision with root package name */
        public int f5518d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f5519e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f5520f;

        public WorkInfo a() {
            List<d> list = this.f5520f;
            return new WorkInfo(UUID.fromString(this.f5515a), this.f5516b, this.f5517c, this.f5519e, (list == null || list.isEmpty()) ? d.f5146a : this.f5520f.get(0), this.f5518d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f5518d != bVar.f5518d) {
                return false;
            }
            String str = this.f5515a;
            if (str == null ? bVar.f5515a != null : !str.equals(bVar.f5515a)) {
                return false;
            }
            if (this.f5516b != bVar.f5516b) {
                return false;
            }
            d dVar = this.f5517c;
            if (dVar == null ? bVar.f5517c != null : !dVar.equals(bVar.f5517c)) {
                return false;
            }
            List<String> list = this.f5519e;
            if (list == null ? bVar.f5519e != null : !list.equals(bVar.f5519e)) {
                return false;
            }
            List<d> list2 = this.f5520f;
            List<d> list3 = bVar.f5520f;
            return list2 != null ? list2.equals(list3) : list3 == null;
        }

        public int hashCode() {
            String str = this.f5515a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            WorkInfo.State state = this.f5516b;
            int hashCode2 = (hashCode + (state != null ? state.hashCode() : 0)) * 31;
            d dVar = this.f5517c;
            int hashCode3 = (((hashCode2 + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.f5518d) * 31;
            List<String> list = this.f5519e;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<d> list2 = this.f5520f;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return hashCode4 + i2;
        }
    }

    public p(p pVar) {
        this.f5495a = pVar.f5495a;
        this.f5497c = pVar.f5497c;
        this.f5496b = pVar.f5496b;
        this.f5498d = pVar.f5498d;
        this.f5499e = new d(pVar.f5499e);
        this.f5500f = new d(pVar.f5500f);
        this.f5501g = pVar.f5501g;
        this.f5502h = pVar.f5502h;
        this.f5503i = pVar.f5503i;
        this.f5504j = new androidx.work.b(pVar.f5504j);
        this.f5505k = pVar.f5505k;
        this.f5506l = pVar.f5506l;
        this.f5507m = pVar.f5507m;
        this.f5508n = pVar.f5508n;
        this.f5509o = pVar.f5509o;
        this.f5510p = pVar.f5510p;
        this.f5511q = pVar.f5511q;
        this.f5512r = pVar.f5512r;
    }

    public p(String str, String str2) {
        this.f5495a = str;
        this.f5497c = str2;
    }

    public boolean a() {
        return this.f5502h != 0;
    }

    public boolean b() {
        return this.f5496b == WorkInfo.State.ENQUEUED && this.f5505k > 0;
    }

    public long c() {
        boolean z2 = false;
        if (b()) {
            if (this.f5506l == BackoffPolicy.LINEAR) {
                z2 = true;
            }
            return this.f5508n + Math.min(18000000, z2 ? this.f5507m * ((long) this.f5505k) : (long) Math.scalb((float) this.f5507m, this.f5505k - 1));
        }
        long j2 = 0;
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f5508n;
            long j4 = j3 == 0 ? currentTimeMillis + this.f5501g : j3;
            long j5 = this.f5503i;
            long j6 = this.f5502h;
            if (j5 != j6) {
                z2 = true;
            }
            int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
            if (z2) {
                if (i2 == 0) {
                    j2 = j5 * -1;
                }
                return j4 + j6 + j2;
            }
            if (i2 != 0) {
                j2 = j6;
            }
            return j4 + j2;
        }
        long j7 = this.f5508n;
        if (j7 == 0) {
            j7 = System.currentTimeMillis();
        }
        return j7 + this.f5501g;
    }

    public boolean d() {
        return !androidx.work.b.f5126a.equals(this.f5504j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f5501g != pVar.f5501g || this.f5502h != pVar.f5502h || this.f5503i != pVar.f5503i || this.f5505k != pVar.f5505k || this.f5507m != pVar.f5507m || this.f5508n != pVar.f5508n || this.f5509o != pVar.f5509o || this.f5510p != pVar.f5510p || this.f5511q != pVar.f5511q || !this.f5495a.equals(pVar.f5495a) || this.f5496b != pVar.f5496b || !this.f5497c.equals(pVar.f5497c)) {
            return false;
        }
        String str = this.f5498d;
        if (str == null ? pVar.f5498d == null : str.equals(pVar.f5498d)) {
            return this.f5499e.equals(pVar.f5499e) && this.f5500f.equals(pVar.f5500f) && this.f5504j.equals(pVar.f5504j) && this.f5506l == pVar.f5506l && this.f5512r == pVar.f5512r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f5495a.hashCode() * 31) + this.f5496b.hashCode()) * 31) + this.f5497c.hashCode()) * 31;
        String str = this.f5498d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j2 = this.f5501g;
        long j3 = this.f5502h;
        long j4 = this.f5503i;
        long j5 = this.f5507m;
        long j6 = this.f5508n;
        long j7 = this.f5509o;
        long j8 = this.f5510p;
        return ((((((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f5499e.hashCode()) * 31) + this.f5500f.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f5504j.hashCode()) * 31) + this.f5505k) * 31) + this.f5506l.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f5511q ? 1 : 0)) * 31) + this.f5512r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f5495a + "}";
    }
}
