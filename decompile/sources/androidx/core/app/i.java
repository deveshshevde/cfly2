package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import j.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2894a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f2895b;

    /* renamed from: c  reason: collision with root package name */
    private final h.d f2896c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f2897d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f2898e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f2899f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f2900g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f2901h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f2902i;

    i(h.d dVar) {
        List<String> a2;
        String str;
        Bundle bundle;
        this.f2896c = dVar;
        this.f2894a = dVar.f2864a;
        this.f2895b = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(dVar.f2864a, dVar.K) : new Notification.Builder(dVar.f2864a);
        Notification notification = dVar.S;
        this.f2895b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f2872i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f2868e).setContentText(dVar.f2869f).setContentInfo(dVar.f2874k).setContentIntent(dVar.f2870g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f2871h, (notification.flags & 128) != 0).setLargeIcon(dVar.f2873j).setNumber(dVar.f2875l).setProgress(dVar.f2883t, dVar.f2884u, dVar.f2885v);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2895b.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2895b.setSubText(dVar.f2880q).setUsesChronometer(dVar.f2878o).setPriority(dVar.f2876m);
            Iterator<h.a> it2 = dVar.f2865b.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
            if (dVar.D != null) {
                this.f2900g.putAll(dVar.D);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.f2889z) {
                    this.f2900g.putBoolean("android.support.localOnly", true);
                }
                if (dVar.f2886w != null) {
                    this.f2900g.putString("android.support.groupKey", dVar.f2886w);
                    if (dVar.f2887x) {
                        bundle = this.f2900g;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f2900g;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                if (dVar.f2888y != null) {
                    this.f2900g.putString("android.support.sortKey", dVar.f2888y);
                }
            }
            this.f2897d = dVar.H;
            this.f2898e = dVar.I;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f2895b.setShowWhen(dVar.f2877n);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21 && (a2 = a(a((List<l>) dVar.f2866c), dVar.V)) != null && !a2.isEmpty()) {
            this.f2900g.putStringArray("android.people", (String[]) a2.toArray(new String[a2.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2895b.setLocalOnly(dVar.f2889z).setGroup(dVar.f2886w).setGroupSummary(dVar.f2887x).setSortKey(dVar.f2888y);
            this.f2901h = dVar.P;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2895b.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            List<String> a3 = Build.VERSION.SDK_INT < 28 ? a(a((List<l>) dVar.f2866c), dVar.V) : dVar.V;
            if (a3 != null && !a3.isEmpty()) {
                for (String addPerson : a3) {
                    this.f2895b.addPerson(addPerson);
                }
            }
            this.f2902i = dVar.J;
            if (dVar.f2867d.size() > 0) {
                Bundle bundle2 = dVar.a().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i2 = 0; i2 < dVar.f2867d.size(); i2++) {
                    bundle4.putBundle(Integer.toString(i2), j.a(dVar.f2867d.get(i2)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.a().putBundle("android.car.EXTENSIONS", bundle2);
                this.f2900g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && dVar.U != null) {
            this.f2895b.setSmallIcon(dVar.U);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2895b.setExtras(dVar.D).setRemoteInputHistory(dVar.f2882s);
            if (dVar.H != null) {
                this.f2895b.setCustomContentView(dVar.H);
            }
            if (dVar.I != null) {
                this.f2895b.setCustomBigContentView(dVar.I);
            }
            if (dVar.J != null) {
                this.f2895b.setCustomHeadsUpContentView(dVar.J);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2895b.setBadgeIconType(dVar.L).setSettingsText(dVar.f2881r).setShortcutId(dVar.M).setTimeoutAfter(dVar.O).setGroupAlertBehavior(dVar.P);
            if (dVar.B) {
                this.f2895b.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f2895b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<l> it3 = dVar.f2866c.iterator();
            while (it3.hasNext()) {
                this.f2895b.addPerson(it3.next().a());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2895b.setAllowSystemGeneratedContextualActions(dVar.Q);
            this.f2895b.setBubbleMetadata(h.c.a(dVar.R));
            if (dVar.N != null) {
                this.f2895b.setLocusId(dVar.N.a());
            }
        }
        if (dVar.T) {
            if (this.f2896c.f2887x) {
                this.f2901h = 2;
            } else {
                this.f2901h = 1;
            }
            this.f2895b.setVibrate((long[]) null);
            this.f2895b.setSound((Uri) null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f2895b.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f2896c.f2886w)) {
                    this.f2895b.setGroup("silent");
                }
                this.f2895b.setGroupAlertBehavior(this.f2901h);
            }
        }
    }

    private static List<String> a(List<l> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (l h2 : list) {
            arrayList.add(h2.h());
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    private void a(h.a aVar) {
        Notification.Action.Builder builder;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat a2 = aVar.a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.e() : null, aVar.b(), aVar.c());
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.c() : 0, aVar.b(), aVar.c());
            }
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : m.a(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.j());
            builder.addExtras(bundle);
            this.f2895b.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f2899f.add(j.a(this.f2895b, aVar));
        }
    }

    public Notification.Builder a() {
        return this.f2895b;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews c2;
        h.e eVar = this.f2896c.f2879p;
        if (eVar != null) {
            eVar.a((g) this);
        }
        RemoteViews b2 = eVar != null ? eVar.b(this) : null;
        Notification c3 = c();
        if (b2 == null) {
            if (this.f2896c.H != null) {
                b2 = this.f2896c.H;
            }
            if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (c2 = eVar.c(this)) == null)) {
                c3.bigContentView = c2;
            }
            if (!(Build.VERSION.SDK_INT < 21 || eVar == null || (d2 = this.f2896c.f2879p.d(this)) == null)) {
                c3.headsUpContentView = d2;
            }
            if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (a2 = h.a(c3)) == null)) {
                eVar.a(a2);
            }
            return c3;
        }
        c3.contentView = b2;
        c3.bigContentView = c2;
        c3.headsUpContentView = d2;
        eVar.a(a2);
        return c3;
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2895b.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f2895b.build();
            if (this.f2901h != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2901h != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2901h == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f2895b.setExtras(this.f2900g);
            Notification build2 = this.f2895b.build();
            RemoteViews remoteViews = this.f2897d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2898e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2902i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2901h != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2901h != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2901h == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f2895b.setExtras(this.f2900g);
            Notification build3 = this.f2895b.build();
            RemoteViews remoteViews4 = this.f2897d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2898e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2901h != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2901h != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2901h == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a2 = j.a(this.f2899f);
            if (a2 != null) {
                this.f2900g.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f2895b.setExtras(this.f2900g);
            Notification build4 = this.f2895b.build();
            RemoteViews remoteViews6 = this.f2897d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2898e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT < 16) {
            return this.f2895b.getNotification();
        } else {
            Notification build5 = this.f2895b.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f2900g);
            for (String str : this.f2900g.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.f2899f);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f2897d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2898e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
