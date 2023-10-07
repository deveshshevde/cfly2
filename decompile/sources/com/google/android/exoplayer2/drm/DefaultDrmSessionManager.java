package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class DefaultDrmSessionManager<T extends d> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    volatile DefaultDrmSessionManager<T>.b f15438a;

    /* renamed from: c  reason: collision with root package name */
    private final UUID f15439c;

    /* renamed from: d  reason: collision with root package name */
    private final e.c<T> f15440d;

    /* renamed from: e  reason: collision with root package name */
    private final g f15441e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f15442f;

    /* renamed from: g  reason: collision with root package name */
    private final g<a> f15443g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f15444h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f15445i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f15446j;

    /* renamed from: k  reason: collision with root package name */
    private final DefaultDrmSessionManager<T>.c f15447k;

    /* renamed from: l  reason: collision with root package name */
    private final p f15448l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final List<DefaultDrmSession<T>> f15449m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final List<DefaultDrmSession<T>> f15450n;

    /* renamed from: o  reason: collision with root package name */
    private int f15451o;

    /* renamed from: p  reason: collision with root package name */
    private e<T> f15452p;

    /* renamed from: q  reason: collision with root package name */
    private DefaultDrmSession<T> f15453q;

    /* renamed from: r  reason: collision with root package name */
    private DefaultDrmSession<T> f15454r;

    /* renamed from: s  reason: collision with root package name */
    private Looper f15455s;

    /* renamed from: t  reason: collision with root package name */
    private int f15456t;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f15457u;

    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private MissingSchemeDataException(java.util.UUID r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.String r0 = java.lang.String.valueOf(r3)
                int r0 = r0.length()
                int r0 = r0 + 29
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Media does not support uuid: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException.<init>(java.util.UUID):void");
        }
    }

    private class a implements e.b<T> {
        private a() {
        }
    }

    private class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f15449m) {
                    if (defaultDrmSession.a(bArr)) {
                        defaultDrmSession.a(message.what);
                        return;
                    }
                }
            }
        }
    }

    private class c implements DefaultDrmSession.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DefaultDrmSessionManager f15460a;

        public void a() {
            for (DefaultDrmSession b2 : this.f15460a.f15450n) {
                b2.b();
            }
            this.f15460a.f15450n.clear();
        }

        public void a(DefaultDrmSession<T> defaultDrmSession) {
            if (!this.f15460a.f15450n.contains(defaultDrmSession)) {
                this.f15460a.f15450n.add(defaultDrmSession);
                if (this.f15460a.f15450n.size() == 1) {
                    defaultDrmSession.a();
                }
            }
        }

        public void a(Exception exc) {
            for (DefaultDrmSession a2 : this.f15460a.f15450n) {
                a2.a(exc);
            }
            this.f15460a.f15450n.clear();
        }
    }

    private DefaultDrmSession<T> a(List<DrmInitData.SchemeData> list, boolean z2) {
        com.google.android.exoplayer2.util.a.b(this.f15452p);
        return new DefaultDrmSession(this.f15439c, this.f15452p, this.f15447k, new DefaultDrmSession.b() {
            public final void onSessionReleased(DefaultDrmSession defaultDrmSession) {
                DefaultDrmSessionManager.this.a(defaultDrmSession);
            }
        }, list, this.f15456t, this.f15446j | z2, z2, this.f15457u, this.f15442f, this.f15441e, (Looper) com.google.android.exoplayer2.util.a.b(this.f15455s), this.f15443g, this.f15448l);
    }

    private static List<DrmInitData.SchemeData> a(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.f15462b);
        for (int i2 = 0; i2 < drmInitData.f15462b; i2++) {
            DrmInitData.SchemeData a2 = drmInitData.a(i2);
            if ((a2.a(uuid) || (com.google.android.exoplayer2.e.f15479c.equals(uuid) && a2.a(com.google.android.exoplayer2.e.f15478b))) && (a2.f15467c != null || z2)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private void a(Looper looper) {
        Looper looper2 = this.f15455s;
        com.google.android.exoplayer2.util.a.b(looper2 == null || looper2 == looper);
        this.f15455s = looper;
    }

    /* access modifiers changed from: private */
    public void a(DefaultDrmSession<T> defaultDrmSession) {
        this.f15449m.remove(defaultDrmSession);
        if (this.f15453q == defaultDrmSession) {
            this.f15453q = null;
        }
        if (this.f15454r == defaultDrmSession) {
            this.f15454r = null;
        }
        if (this.f15450n.size() > 1 && this.f15450n.get(0) == defaultDrmSession) {
            this.f15450n.get(1).a();
        }
        this.f15450n.remove(defaultDrmSession);
    }

    private void b(Looper looper) {
        if (this.f15438a == null) {
            this.f15438a = new b(looper);
        }
    }

    public DrmSession<T> a(Looper looper, int i2) {
        a(looper);
        e eVar = (e) com.google.android.exoplayer2.util.a.b(this.f15452p);
        if ((f.class.equals(eVar.d()) && f.f15473a) || ad.a(this.f15445i, i2) == -1 || eVar.d() == null) {
            return null;
        }
        b(looper);
        if (this.f15453q == null) {
            DefaultDrmSession<T> a2 = a((List<DrmInitData.SchemeData>) Collections.emptyList(), true);
            this.f15449m.add(a2);
            this.f15453q = a2;
        }
        this.f15453q.h();
        return this.f15453q;
    }

    public DrmSession<T> a(Looper looper, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> list;
        a(looper);
        b(looper);
        DefaultDrmSession<T> defaultDrmSession = null;
        if (this.f15457u == null) {
            list = a(drmInitData, this.f15439c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f15439c);
                this.f15443g.a(new g.a() {
                    public final void sendTo(Object obj) {
                        ((a) obj).a(DefaultDrmSessionManager.MissingSchemeDataException.this);
                    }
                });
                return new c(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            list = null;
        }
        if (this.f15444h) {
            Iterator<DefaultDrmSession<T>> it2 = this.f15449m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DefaultDrmSession<T> next = it2.next();
                if (ad.a((Object) next.f11635a, (Object) list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f15454r;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = a(list, false);
            if (!this.f15444h) {
                this.f15454r = defaultDrmSession;
            }
            this.f15449m.add(defaultDrmSession);
        }
        defaultDrmSession.h();
        return defaultDrmSession;
    }

    public final void a() {
        int i2 = this.f15451o;
        this.f15451o = i2 + 1;
        if (i2 == 0) {
            com.google.android.exoplayer2.util.a.b(this.f15452p == null);
            e<T> a2 = this.f15440d.a(this.f15439c);
            this.f15452p = a2;
            a2.a((e.b<? super T>) new a());
        }
    }

    public final void a(Handler handler, a aVar) {
        this.f15443g.a(handler, aVar);
    }

    public boolean a(DrmInitData drmInitData) {
        if (this.f15457u != null) {
            return true;
        }
        if (a(drmInitData, this.f15439c, true).isEmpty()) {
            if (drmInitData.f15462b != 1 || !drmInitData.a(0).a(com.google.android.exoplayer2.e.f15478b)) {
                return false;
            }
            String valueOf = String.valueOf(this.f15439c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72);
            sb.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb.append(valueOf);
            k.c("DefaultDrmSessionMgr", sb.toString());
        }
        String str = drmInitData.f15461a;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return (!"cbc1".equals(str) && !"cbcs".equals(str) && !"cens".equals(str)) || ad.f11755a >= 25;
    }

    public Class<T> b(DrmInitData drmInitData) {
        if (a(drmInitData)) {
            return ((e) com.google.android.exoplayer2.util.a.b(this.f15452p)).d();
        }
        return null;
    }

    public final void b() {
        int i2 = this.f15451o - 1;
        this.f15451o = i2;
        if (i2 == 0) {
            ((e) com.google.android.exoplayer2.util.a.b(this.f15452p)).c();
            this.f15452p = null;
        }
    }
}
