package ao;

import af.c;
import af.e;
import ag.f;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.k;
import androidx.room.n;
import androidx.work.WorkInfo;
import androidx.work.d;
import ao.p;
import java.util.ArrayList;
import java.util.List;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5521a;

    /* renamed from: b  reason: collision with root package name */
    private final b<p> f5522b;

    /* renamed from: c  reason: collision with root package name */
    private final n f5523c;

    /* renamed from: d  reason: collision with root package name */
    private final n f5524d;

    /* renamed from: e  reason: collision with root package name */
    private final n f5525e;

    /* renamed from: f  reason: collision with root package name */
    private final n f5526f;

    /* renamed from: g  reason: collision with root package name */
    private final n f5527g;

    /* renamed from: h  reason: collision with root package name */
    private final n f5528h;

    /* renamed from: i  reason: collision with root package name */
    private final n f5529i;

    /* renamed from: j  reason: collision with root package name */
    private final n f5530j;

    public r(RoomDatabase roomDatabase) {
        this.f5521a = roomDatabase;
        this.f5522b = new b<p>(roomDatabase) {
            public String a() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void a(f fVar, p pVar) {
                if (pVar.f5495a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, pVar.f5495a);
                }
                fVar.a(2, (long) v.a(pVar.f5496b));
                if (pVar.f5497c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, pVar.f5497c);
                }
                if (pVar.f5498d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, pVar.f5498d);
                }
                byte[] a2 = d.a(pVar.f5499e);
                if (a2 == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, a2);
                }
                byte[] a3 = d.a(pVar.f5500f);
                if (a3 == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, a3);
                }
                fVar.a(7, pVar.f5501g);
                fVar.a(8, pVar.f5502h);
                fVar.a(9, pVar.f5503i);
                fVar.a(10, (long) pVar.f5505k);
                fVar.a(11, (long) v.a(pVar.f5506l));
                fVar.a(12, pVar.f5507m);
                fVar.a(13, pVar.f5508n);
                fVar.a(14, pVar.f5509o);
                fVar.a(15, pVar.f5510p);
                fVar.a(16, pVar.f5511q ? 1 : 0);
                fVar.a(17, (long) v.a(pVar.f5512r));
                androidx.work.b bVar = pVar.f5504j;
                if (bVar != null) {
                    fVar.a(18, (long) v.a(bVar.a()));
                    fVar.a(19, bVar.b() ? 1 : 0);
                    fVar.a(20, bVar.c() ? 1 : 0);
                    fVar.a(21, bVar.d() ? 1 : 0);
                    fVar.a(22, bVar.e() ? 1 : 0);
                    fVar.a(23, bVar.f());
                    fVar.a(24, bVar.g());
                    byte[] a4 = v.a(bVar.h());
                    if (a4 != null) {
                        fVar.a(25, a4);
                        return;
                    }
                } else {
                    fVar.a(18);
                    fVar.a(19);
                    fVar.a(20);
                    fVar.a(21);
                    fVar.a(22);
                    fVar.a(23);
                    fVar.a(24);
                }
                fVar.a(25);
            }
        };
        this.f5523c = new n(roomDatabase) {
            public String a() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f5524d = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f5525e = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f5526f = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f5527g = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f5528h = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f5529i = new n(roomDatabase) {
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.f5530j = new n(roomDatabase) {
            public String a() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public int a(WorkInfo.State state, String... strArr) {
        this.f5521a.f();
        StringBuilder a2 = e.a();
        a2.append("UPDATE workspec SET state=");
        a2.append("?");
        a2.append(" WHERE id IN (");
        e.a(a2, strArr.length);
        a2.append(")");
        f a3 = this.f5521a.a(a2.toString());
        a3.a(1, (long) v.a(state));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                a3.a(i2);
            } else {
                a3.a(i2, str);
            }
            i2++;
        }
        this.f5521a.g();
        try {
            int a4 = a3.a();
            this.f5521a.j();
            return a4;
        } finally {
            this.f5521a.h();
        }
    }

    public List<p> a(int i2) {
        k kVar;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        a2.a(1, (long) i2);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                int i3 = a17;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(a12);
                    int i4 = a12;
                    String string2 = a3.getString(a14);
                    int i5 = a14;
                    androidx.work.b bVar = new androidx.work.b();
                    int i6 = a4;
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    int i7 = a5;
                    int i8 = a6;
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar = new p(string, string2);
                    pVar.f5496b = v.a(a3.getInt(a13));
                    pVar.f5498d = a3.getString(a15);
                    pVar.f5499e = d.a(a3.getBlob(a16));
                    int i9 = i3;
                    pVar.f5500f = d.a(a3.getBlob(i9));
                    int i10 = i7;
                    i3 = i9;
                    int i11 = a18;
                    pVar.f5501g = a3.getLong(i11);
                    int i12 = a15;
                    int i13 = a19;
                    pVar.f5502h = a3.getLong(i13);
                    int i14 = i11;
                    int i15 = a7;
                    int i16 = a20;
                    pVar.f5503i = a3.getLong(i16);
                    int i17 = a21;
                    pVar.f5505k = a3.getInt(i17);
                    int i18 = a22;
                    int i19 = i13;
                    pVar.f5506l = v.b(a3.getInt(i18));
                    a20 = i16;
                    int i20 = i15;
                    int i21 = a23;
                    pVar.f5507m = a3.getLong(i21);
                    int i22 = i17;
                    int i23 = i18;
                    int i24 = a24;
                    pVar.f5508n = a3.getLong(i24);
                    int i25 = i21;
                    a24 = i24;
                    int i26 = a25;
                    pVar.f5509o = a3.getLong(i26);
                    int i27 = i22;
                    int i28 = a26;
                    pVar.f5510p = a3.getLong(i28);
                    int i29 = a27;
                    pVar.f5511q = a3.getInt(i29) != 0;
                    int i30 = a28;
                    int i31 = i28;
                    pVar.f5512r = v.d(a3.getInt(i30));
                    pVar.f5504j = bVar;
                    arrayList.add(pVar);
                    a28 = i30;
                    a5 = i10;
                    a15 = i12;
                    a18 = i14;
                    a19 = i19;
                    a21 = i27;
                    a26 = i31;
                    a12 = i4;
                    a14 = i5;
                    a4 = i6;
                    a27 = i29;
                    a25 = i26;
                    a6 = i8;
                    int i32 = i23;
                    a23 = i25;
                    a7 = i20;
                    a22 = i32;
                }
                a3.close();
                kVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public List<p> a(long j2) {
        k kVar;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        a2.a(1, j2);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                int i2 = a17;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(a12);
                    int i3 = a12;
                    String string2 = a3.getString(a14);
                    int i4 = a14;
                    androidx.work.b bVar = new androidx.work.b();
                    int i5 = a4;
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    int i6 = a5;
                    int i7 = a6;
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar = new p(string, string2);
                    pVar.f5496b = v.a(a3.getInt(a13));
                    pVar.f5498d = a3.getString(a15);
                    pVar.f5499e = d.a(a3.getBlob(a16));
                    int i8 = i2;
                    pVar.f5500f = d.a(a3.getBlob(i8));
                    int i9 = a18;
                    int i10 = i6;
                    i2 = i8;
                    pVar.f5501g = a3.getLong(i9);
                    int i11 = a15;
                    int i12 = a19;
                    pVar.f5502h = a3.getLong(i12);
                    int i13 = i9;
                    int i14 = a7;
                    int i15 = a20;
                    pVar.f5503i = a3.getLong(i15);
                    int i16 = a21;
                    pVar.f5505k = a3.getInt(i16);
                    int i17 = a22;
                    int i18 = i12;
                    pVar.f5506l = v.b(a3.getInt(i17));
                    a20 = i15;
                    int i19 = i14;
                    int i20 = a23;
                    pVar.f5507m = a3.getLong(i20);
                    int i21 = i16;
                    int i22 = i17;
                    int i23 = a24;
                    pVar.f5508n = a3.getLong(i23);
                    int i24 = i20;
                    a24 = i23;
                    int i25 = a25;
                    pVar.f5509o = a3.getLong(i25);
                    int i26 = i21;
                    int i27 = a26;
                    pVar.f5510p = a3.getLong(i27);
                    int i28 = a27;
                    pVar.f5511q = a3.getInt(i28) != 0;
                    int i29 = a28;
                    int i30 = i27;
                    pVar.f5512r = v.d(a3.getInt(i29));
                    pVar.f5504j = bVar;
                    arrayList.add(pVar);
                    a5 = i10;
                    a28 = i29;
                    a15 = i11;
                    a18 = i13;
                    a19 = i18;
                    a21 = i26;
                    a26 = i30;
                    a12 = i3;
                    a14 = i4;
                    a4 = i5;
                    a27 = i28;
                    a25 = i25;
                    a6 = i7;
                    int i31 = i22;
                    a23 = i24;
                    a7 = i19;
                    a22 = i31;
                }
                a3.close();
                kVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public void a(p pVar) {
        this.f5521a.f();
        this.f5521a.g();
        try {
            this.f5522b.a(pVar);
            this.f5521a.j();
        } finally {
            this.f5521a.h();
        }
    }

    public void a(String str) {
        this.f5521a.f();
        f c2 = this.f5523c.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f5521a.g();
        try {
            c2.a();
            this.f5521a.j();
        } finally {
            this.f5521a.h();
            this.f5523c.a(c2);
        }
    }

    public void a(String str, long j2) {
        this.f5521a.f();
        f c2 = this.f5525e.c();
        c2.a(1, j2);
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f5521a.g();
        try {
            c2.a();
            this.f5521a.j();
        } finally {
            this.f5521a.h();
            this.f5525e.a(c2);
        }
    }

    public void a(String str, d dVar) {
        this.f5521a.f();
        f c2 = this.f5524d.c();
        byte[] a2 = d.a(dVar);
        if (a2 == null) {
            c2.a(1);
        } else {
            c2.a(1, a2);
        }
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f5521a.g();
        try {
            c2.a();
            this.f5521a.j();
        } finally {
            this.f5521a.h();
            this.f5524d.a(c2);
        }
    }

    public boolean a() {
        boolean z2 = false;
        k a2 = k.a("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            if (a3.moveToFirst() && a3.getInt(0) != 0) {
                z2 = true;
            }
            return z2;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public int b() {
        this.f5521a.f();
        f c2 = this.f5529i.c();
        this.f5521a.g();
        try {
            int a2 = c2.a();
            this.f5521a.j();
            return a2;
        } finally {
            this.f5521a.h();
            this.f5529i.a(c2);
        }
    }

    public int b(String str, long j2) {
        this.f5521a.f();
        f c2 = this.f5528h.c();
        c2.a(1, j2);
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f5521a.g();
        try {
            int a2 = c2.a();
            this.f5521a.j();
            return a2;
        } finally {
            this.f5521a.h();
            this.f5528h.a(c2);
        }
    }

    public p b(String str) {
        k kVar;
        p pVar;
        String str2 = str;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                if (a3.moveToFirst()) {
                    String string = a3.getString(a12);
                    String string2 = a3.getString(a14);
                    int i2 = a28;
                    androidx.work.b bVar = new androidx.work.b();
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar2 = new p(string, string2);
                    pVar2.f5496b = v.a(a3.getInt(a13));
                    pVar2.f5498d = a3.getString(a15);
                    pVar2.f5499e = d.a(a3.getBlob(a16));
                    pVar2.f5500f = d.a(a3.getBlob(a17));
                    pVar2.f5501g = a3.getLong(a18);
                    pVar2.f5502h = a3.getLong(a19);
                    pVar2.f5503i = a3.getLong(a20);
                    pVar2.f5505k = a3.getInt(a21);
                    pVar2.f5506l = v.b(a3.getInt(a22));
                    pVar2.f5507m = a3.getLong(a23);
                    pVar2.f5508n = a3.getLong(a24);
                    pVar2.f5509o = a3.getLong(a25);
                    pVar2.f5510p = a3.getLong(a26);
                    pVar2.f5511q = a3.getInt(a27) != 0;
                    pVar2.f5512r = v.d(a3.getInt(i2));
                    pVar2.f5504j = bVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                a3.close();
                kVar.a();
                return pVar;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public List<p> b(int i2) {
        k kVar;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        a2.a(1, (long) i2);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                int i3 = a17;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(a12);
                    int i4 = a12;
                    String string2 = a3.getString(a14);
                    int i5 = a14;
                    androidx.work.b bVar = new androidx.work.b();
                    int i6 = a4;
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    int i7 = a5;
                    int i8 = a6;
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar = new p(string, string2);
                    pVar.f5496b = v.a(a3.getInt(a13));
                    pVar.f5498d = a3.getString(a15);
                    pVar.f5499e = d.a(a3.getBlob(a16));
                    int i9 = i3;
                    pVar.f5500f = d.a(a3.getBlob(i9));
                    int i10 = i7;
                    i3 = i9;
                    int i11 = a18;
                    pVar.f5501g = a3.getLong(i11);
                    int i12 = a15;
                    int i13 = a19;
                    pVar.f5502h = a3.getLong(i13);
                    int i14 = i11;
                    int i15 = a7;
                    int i16 = a20;
                    pVar.f5503i = a3.getLong(i16);
                    int i17 = a21;
                    pVar.f5505k = a3.getInt(i17);
                    int i18 = a22;
                    int i19 = i13;
                    pVar.f5506l = v.b(a3.getInt(i18));
                    a20 = i16;
                    int i20 = i15;
                    int i21 = a23;
                    pVar.f5507m = a3.getLong(i21);
                    int i22 = i17;
                    int i23 = i18;
                    int i24 = a24;
                    pVar.f5508n = a3.getLong(i24);
                    int i25 = i21;
                    a24 = i24;
                    int i26 = a25;
                    pVar.f5509o = a3.getLong(i26);
                    int i27 = i22;
                    int i28 = a26;
                    pVar.f5510p = a3.getLong(i28);
                    int i29 = a27;
                    pVar.f5511q = a3.getInt(i29) != 0;
                    int i30 = a28;
                    int i31 = i28;
                    pVar.f5512r = v.d(a3.getInt(i30));
                    pVar.f5504j = bVar;
                    arrayList.add(pVar);
                    a28 = i30;
                    a5 = i10;
                    a15 = i12;
                    a18 = i14;
                    a19 = i19;
                    a21 = i27;
                    a26 = i31;
                    a12 = i4;
                    a14 = i5;
                    a4 = i6;
                    a27 = i29;
                    a25 = i26;
                    a6 = i8;
                    int i32 = i23;
                    a23 = i25;
                    a7 = i20;
                    a22 = i32;
                }
                a3.close();
                kVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public List<p> c() {
        k kVar;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                int i2 = a17;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(a12);
                    int i3 = a12;
                    String string2 = a3.getString(a14);
                    int i4 = a14;
                    androidx.work.b bVar = new androidx.work.b();
                    int i5 = a4;
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    int i6 = a5;
                    int i7 = a6;
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar = new p(string, string2);
                    pVar.f5496b = v.a(a3.getInt(a13));
                    pVar.f5498d = a3.getString(a15);
                    pVar.f5499e = d.a(a3.getBlob(a16));
                    int i8 = i2;
                    pVar.f5500f = d.a(a3.getBlob(i8));
                    int i9 = i6;
                    i2 = i8;
                    int i10 = a18;
                    pVar.f5501g = a3.getLong(i10);
                    int i11 = a16;
                    int i12 = a19;
                    pVar.f5502h = a3.getLong(i12);
                    int i13 = i10;
                    int i14 = a7;
                    int i15 = a20;
                    pVar.f5503i = a3.getLong(i15);
                    int i16 = a21;
                    pVar.f5505k = a3.getInt(i16);
                    int i17 = a22;
                    int i18 = i12;
                    pVar.f5506l = v.b(a3.getInt(i17));
                    a20 = i15;
                    int i19 = i14;
                    int i20 = a23;
                    pVar.f5507m = a3.getLong(i20);
                    int i21 = i16;
                    int i22 = i17;
                    int i23 = a24;
                    pVar.f5508n = a3.getLong(i23);
                    int i24 = i20;
                    a24 = i23;
                    int i25 = a25;
                    pVar.f5509o = a3.getLong(i25);
                    int i26 = i21;
                    int i27 = a26;
                    pVar.f5510p = a3.getLong(i27);
                    int i28 = a27;
                    pVar.f5511q = a3.getInt(i28) != 0;
                    int i29 = a28;
                    int i30 = i27;
                    pVar.f5512r = v.d(a3.getInt(i29));
                    pVar.f5504j = bVar;
                    arrayList.add(pVar);
                    a28 = i29;
                    a5 = i9;
                    a16 = i11;
                    a18 = i13;
                    a19 = i18;
                    a21 = i26;
                    a26 = i30;
                    a12 = i3;
                    a14 = i4;
                    a4 = i5;
                    a27 = i28;
                    a25 = i25;
                    a6 = i7;
                    int i31 = i22;
                    a23 = i24;
                    a7 = i19;
                    a22 = i31;
                }
                a3.close();
                kVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public List<p.a> c(String str) {
        k a2 = k.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "id");
            int a5 = af.b.a(a3, "state");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                p.a aVar = new p.a();
                aVar.f5513a = a3.getString(a4);
                aVar.f5514b = v.a(a3.getInt(a5));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public int d(String str) {
        this.f5521a.f();
        f c2 = this.f5526f.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f5521a.g();
        try {
            int a2 = c2.a();
            this.f5521a.j();
            return a2;
        } finally {
            this.f5521a.h();
            this.f5526f.a(c2);
        }
    }

    public List<p> d() {
        k kVar;
        k a2 = k.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "required_network_type");
            int a5 = af.b.a(a3, "requires_charging");
            int a6 = af.b.a(a3, "requires_device_idle");
            int a7 = af.b.a(a3, "requires_battery_not_low");
            int a8 = af.b.a(a3, "requires_storage_not_low");
            int a9 = af.b.a(a3, "trigger_content_update_delay");
            int a10 = af.b.a(a3, "trigger_max_content_delay");
            int a11 = af.b.a(a3, "content_uri_triggers");
            int a12 = af.b.a(a3, "id");
            int a13 = af.b.a(a3, "state");
            int a14 = af.b.a(a3, "worker_class_name");
            int a15 = af.b.a(a3, "input_merger_class_name");
            int a16 = af.b.a(a3, "input");
            int a17 = af.b.a(a3, "output");
            kVar = a2;
            try {
                int a18 = af.b.a(a3, "initial_delay");
                int a19 = af.b.a(a3, "interval_duration");
                int a20 = af.b.a(a3, "flex_duration");
                int a21 = af.b.a(a3, "run_attempt_count");
                int a22 = af.b.a(a3, "backoff_policy");
                int a23 = af.b.a(a3, "backoff_delay_duration");
                int a24 = af.b.a(a3, "period_start_time");
                int a25 = af.b.a(a3, "minimum_retention_duration");
                int a26 = af.b.a(a3, "schedule_requested_at");
                int a27 = af.b.a(a3, "run_in_foreground");
                int a28 = af.b.a(a3, "out_of_quota_policy");
                int i2 = a17;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(a12);
                    int i3 = a12;
                    String string2 = a3.getString(a14);
                    int i4 = a14;
                    androidx.work.b bVar = new androidx.work.b();
                    int i5 = a4;
                    bVar.a(v.c(a3.getInt(a4)));
                    bVar.a(a3.getInt(a5) != 0);
                    bVar.b(a3.getInt(a6) != 0);
                    bVar.c(a3.getInt(a7) != 0);
                    bVar.d(a3.getInt(a8) != 0);
                    int i6 = a5;
                    int i7 = a6;
                    bVar.a(a3.getLong(a9));
                    bVar.b(a3.getLong(a10));
                    bVar.a(v.a(a3.getBlob(a11)));
                    p pVar = new p(string, string2);
                    pVar.f5496b = v.a(a3.getInt(a13));
                    pVar.f5498d = a3.getString(a15);
                    pVar.f5499e = d.a(a3.getBlob(a16));
                    int i8 = i2;
                    pVar.f5500f = d.a(a3.getBlob(i8));
                    int i9 = i6;
                    i2 = i8;
                    int i10 = a18;
                    pVar.f5501g = a3.getLong(i10);
                    int i11 = a16;
                    int i12 = a19;
                    pVar.f5502h = a3.getLong(i12);
                    int i13 = i10;
                    int i14 = a7;
                    int i15 = a20;
                    pVar.f5503i = a3.getLong(i15);
                    int i16 = a21;
                    pVar.f5505k = a3.getInt(i16);
                    int i17 = a22;
                    int i18 = i12;
                    pVar.f5506l = v.b(a3.getInt(i17));
                    a20 = i15;
                    int i19 = i14;
                    int i20 = a23;
                    pVar.f5507m = a3.getLong(i20);
                    int i21 = i16;
                    int i22 = i17;
                    int i23 = a24;
                    pVar.f5508n = a3.getLong(i23);
                    int i24 = i20;
                    a24 = i23;
                    int i25 = a25;
                    pVar.f5509o = a3.getLong(i25);
                    int i26 = i21;
                    int i27 = a26;
                    pVar.f5510p = a3.getLong(i27);
                    int i28 = a27;
                    pVar.f5511q = a3.getInt(i28) != 0;
                    int i29 = a28;
                    int i30 = i27;
                    pVar.f5512r = v.d(a3.getInt(i29));
                    pVar.f5504j = bVar;
                    arrayList.add(pVar);
                    a28 = i29;
                    a5 = i9;
                    a16 = i11;
                    a18 = i13;
                    a19 = i18;
                    a21 = i26;
                    a26 = i30;
                    a12 = i3;
                    a14 = i4;
                    a4 = i5;
                    a27 = i28;
                    a25 = i25;
                    a6 = i7;
                    int i31 = i22;
                    a23 = i24;
                    a7 = i19;
                    a22 = i31;
                }
                a3.close();
                kVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a3.close();
                kVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = a2;
            a3.close();
            kVar.a();
            throw th;
        }
    }

    public int e(String str) {
        this.f5521a.f();
        f c2 = this.f5527g.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f5521a.g();
        try {
            int a2 = c2.a();
            this.f5521a.j();
            return a2;
        } finally {
            this.f5521a.h();
            this.f5527g.a(c2);
        }
    }

    public WorkInfo.State f(String str) {
        k a2 = k.a("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5521a.f();
        WorkInfo.State state = null;
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            if (a3.moveToFirst()) {
                state = v.a(a3.getInt(0));
            }
            return state;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public List<d> g(String str) {
        k a2 = k.a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(d.a(a3.getBlob(0)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public List<String> h(String str) {
        k a2 = k.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5521a.f();
        Cursor a3 = c.a(this.f5521a, a2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(a3.getString(0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
