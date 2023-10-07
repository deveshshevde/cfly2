package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.utils.c;
import androidx.work.impl.utils.e;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static ae.a f5282a = new ae.a(1, 2) {
        public void a(ag.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.c("DROP TABLE IF EXISTS alarmInfo");
            bVar.c("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static ae.a f5283b = new ae.a(3, 4) {
        public void a(ag.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.c("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static ae.a f5284c = new ae.a(4, 5) {
        public void a(ag.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static ae.a f5285d = new ae.a(6, 7) {
        public void a(ag.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static ae.a f5286e = new ae.a(7, 8) {
        public void a(ag.b bVar) {
            bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static ae.a f5287f = new ae.a(8, 9) {
        public void a(ag.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static ae.a f5288g = new ae.a(11, 12) {
        public void a(ag.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static class a extends ae.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f5289c;

        public a(Context context, int i2, int i3) {
            super(i2, i3);
            this.f5289c = context;
        }

        public void a(ag.b bVar) {
            if (this.f60b >= 10) {
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f5289c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class b extends ae.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f5290c;

        public b(Context context) {
            super(9, 10);
            this.f5290c = context;
        }

        public void a(ag.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            e.a(this.f5290c, bVar);
            c.a(this.f5290c, bVar);
        }
    }
}
