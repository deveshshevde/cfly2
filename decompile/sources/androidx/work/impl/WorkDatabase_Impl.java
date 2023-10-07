package androidx.work.impl;

import af.f;
import ag.c;
import androidx.room.RoomDatabase;
import androidx.room.a;
import androidx.room.j;
import ao.b;
import ao.e;
import ao.h;
import ao.i;
import ao.k;
import ao.l;
import ao.n;
import ao.o;
import ao.q;
import ao.r;
import ao.t;
import ao.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: d  reason: collision with root package name */
    private volatile q f5156d;

    /* renamed from: e  reason: collision with root package name */
    private volatile b f5157e;

    /* renamed from: f  reason: collision with root package name */
    private volatile t f5158f;

    /* renamed from: g  reason: collision with root package name */
    private volatile h f5159g;

    /* renamed from: h  reason: collision with root package name */
    private volatile k f5160h;

    /* renamed from: i  reason: collision with root package name */
    private volatile n f5161i;

    /* renamed from: j  reason: collision with root package name */
    private volatile e f5162j;

    /* access modifiers changed from: protected */
    public c b(a aVar) {
        return aVar.f4382a.a(c.b.a(aVar.f4383b).a(aVar.f4384c).a((c.a) new j(aVar, new j.a(12) {
            public void a(ag.b bVar) {
                bVar.c("DROP TABLE IF EXISTS `Dependency`");
                bVar.c("DROP TABLE IF EXISTS `WorkSpec`");
                bVar.c("DROP TABLE IF EXISTS `WorkTag`");
                bVar.c("DROP TABLE IF EXISTS `SystemIdInfo`");
                bVar.c("DROP TABLE IF EXISTS `WorkName`");
                bVar.c("DROP TABLE IF EXISTS `WorkProgress`");
                bVar.c("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.this.f4351c != null) {
                    int size = WorkDatabase_Impl.this.f4351c.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.b) WorkDatabase_Impl.this.f4351c.get(i2)).c(bVar);
                    }
                }
            }

            public void b(ag.b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
            }

            public void c(ag.b bVar) {
                ag.b unused = WorkDatabase_Impl.this.f4349a = bVar;
                bVar.c("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.a(bVar);
                if (WorkDatabase_Impl.this.f4351c != null) {
                    int size = WorkDatabase_Impl.this.f4351c.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.b) WorkDatabase_Impl.this.f4351c.get(i2)).b(bVar);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void d(ag.b bVar) {
                if (WorkDatabase_Impl.this.f4351c != null) {
                    int size = WorkDatabase_Impl.this.f4351c.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.b) WorkDatabase_Impl.this.f4351c.get(i2)).a(bVar);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public j.b f(ag.b bVar) {
                ag.b bVar2 = bVar;
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("prerequisite_id", new f.a("prerequisite_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new f.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                hashSet2.add(new f.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
                f fVar = new f("Dependency", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar2, "Dependency");
                if (!fVar.equals(a2)) {
                    return new j.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(25);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("state", new f.a("state", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("worker_class_name", new f.a("worker_class_name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("input_merger_class_name", new f.a("input_merger_class_name", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("input", new f.a("input", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("output", new f.a("output", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("initial_delay", new f.a("initial_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("interval_duration", new f.a("interval_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("flex_duration", new f.a("flex_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_attempt_count", new f.a("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_policy", new f.a("backoff_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_delay_duration", new f.a("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("period_start_time", new f.a("period_start_time", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("minimum_retention_duration", new f.a("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("schedule_requested_at", new f.a("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_in_foreground", new f.a("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("out_of_quota_policy", new f.a("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("required_network_type", new f.a("required_network_type", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("requires_charging", new f.a("requires_charging", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_device_idle", new f.a("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_battery_not_low", new f.a("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_storage_not_low", new f.a("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_content_update_delay", new f.a("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_max_content_delay", new f.a("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("content_uri_triggers", new f.a("content_uri_triggers", "BLOB", false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new f.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                hashSet4.add(new f.d("index_WorkSpec_period_start_time", false, Arrays.asList(new String[]{"period_start_time"})));
                f fVar2 = new f("WorkSpec", hashMap2, hashSet3, hashSet4);
                f a3 = f.a(bVar2, "WorkSpec");
                if (!fVar2.equals(a3)) {
                    return new j.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new f.a("tag", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new f.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                f fVar3 = new f("WorkTag", hashMap3, hashSet5, hashSet6);
                f a4 = f.a(bVar2, "WorkTag");
                if (!fVar3.equals(a4)) {
                    return new j.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("system_id", new f.a("system_id", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                f fVar4 = new f("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                f a5 = f.a(bVar2, "SystemIdInfo");
                if (!fVar4.equals(a5)) {
                    return new j.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new f.a("name", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new f.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                f fVar5 = new f("WorkName", hashMap5, hashSet8, hashSet9);
                f a6 = f.a(bVar2, "WorkName");
                if (!fVar5.equals(a6)) {
                    return new j.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + fVar5 + "\n Found:\n" + a6);
                }
                HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap6.put("progress", new f.a("progress", "BLOB", true, 0, (String) null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                f fVar6 = new f("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                f a7 = f.a(bVar2, "WorkProgress");
                if (!fVar6.equals(a7)) {
                    return new j.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + fVar6 + "\n Found:\n" + a7);
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new f.a("key", "TEXT", true, 1, (String) null, 1));
                hashMap7.put("long_value", new f.a("long_value", "INTEGER", false, 0, (String) null, 1));
                f fVar7 = new f("Preference", hashMap7, new HashSet(0), new HashSet(0));
                f a8 = f.a(bVar2, "Preference");
                if (fVar7.equals(a8)) {
                    return new j.b(true, (String) null);
                }
                return new j.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + fVar7 + "\n Found:\n" + a8);
            }

            public void g(ag.b bVar) {
                af.c.a(bVar);
            }

            public void h(ag.b bVar) {
            }
        }, "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    /* access modifiers changed from: protected */
    public androidx.room.f c() {
        return new androidx.room.f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public q o() {
        q qVar;
        if (this.f5156d != null) {
            return this.f5156d;
        }
        synchronized (this) {
            if (this.f5156d == null) {
                this.f5156d = new r(this);
            }
            qVar = this.f5156d;
        }
        return qVar;
    }

    public b p() {
        b bVar;
        if (this.f5157e != null) {
            return this.f5157e;
        }
        synchronized (this) {
            if (this.f5157e == null) {
                this.f5157e = new ao.c(this);
            }
            bVar = this.f5157e;
        }
        return bVar;
    }

    public t q() {
        t tVar;
        if (this.f5158f != null) {
            return this.f5158f;
        }
        synchronized (this) {
            if (this.f5158f == null) {
                this.f5158f = new u(this);
            }
            tVar = this.f5158f;
        }
        return tVar;
    }

    public h r() {
        h hVar;
        if (this.f5159g != null) {
            return this.f5159g;
        }
        synchronized (this) {
            if (this.f5159g == null) {
                this.f5159g = new i(this);
            }
            hVar = this.f5159g;
        }
        return hVar;
    }

    public k s() {
        k kVar;
        if (this.f5160h != null) {
            return this.f5160h;
        }
        synchronized (this) {
            if (this.f5160h == null) {
                this.f5160h = new l(this);
            }
            kVar = this.f5160h;
        }
        return kVar;
    }

    public n t() {
        n nVar;
        if (this.f5161i != null) {
            return this.f5161i;
        }
        synchronized (this) {
            if (this.f5161i == null) {
                this.f5161i = new o(this);
            }
            nVar = this.f5161i;
        }
        return nVar;
    }

    public e u() {
        e eVar;
        if (this.f5162j != null) {
            return this.f5162j;
        }
        synchronized (this) {
            if (this.f5162j == null) {
                this.f5162j = new ao.f(this);
            }
            eVar = this.f5162j;
        }
        return eVar;
    }
}
