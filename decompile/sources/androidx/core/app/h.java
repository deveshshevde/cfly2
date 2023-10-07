package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public class h {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2845a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2846b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public int f2847c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f2848d;

        /* renamed from: e  reason: collision with root package name */
        public PendingIntent f2849e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f2850f;

        /* renamed from: g  reason: collision with root package name */
        private final m[] f2851g;

        /* renamed from: h  reason: collision with root package name */
        private final m[] f2852h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2853i;

        /* renamed from: j  reason: collision with root package name */
        private final int f2854j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f2855k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.a((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (m[]) null, (m[]) null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, m[] mVarArr, m[] mVarArr2, boolean z2, int i2, boolean z3, boolean z4) {
            this.f2846b = true;
            this.f2850f = iconCompat;
            if (iconCompat != null && iconCompat.a() == 2) {
                this.f2847c = iconCompat.c();
            }
            this.f2848d = d.f(charSequence);
            this.f2849e = pendingIntent;
            this.f2845a = bundle == null ? new Bundle() : bundle;
            this.f2851g = mVarArr;
            this.f2852h = mVarArr2;
            this.f2853i = z2;
            this.f2854j = i2;
            this.f2846b = z3;
            this.f2855k = z4;
        }

        public IconCompat a() {
            int i2;
            if (this.f2850f == null && (i2 = this.f2847c) != 0) {
                this.f2850f = IconCompat.a((Resources) null, "", i2);
            }
            return this.f2850f;
        }

        public CharSequence b() {
            return this.f2848d;
        }

        public PendingIntent c() {
            return this.f2849e;
        }

        public Bundle d() {
            return this.f2845a;
        }

        public boolean e() {
            return this.f2853i;
        }

        public m[] f() {
            return this.f2851g;
        }

        public int g() {
            return this.f2854j;
        }

        public boolean h() {
            return this.f2855k;
        }

        public m[] i() {
            return this.f2852h;
        }

        public boolean j() {
            return this.f2846b;
        }
    }

    public static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2856e;

        public b a(CharSequence charSequence) {
            this.f2856e = d.f(charSequence);
            return this;
        }

        /* access modifiers changed from: protected */
        public String a() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f2856e);
            }
        }

        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f2891b).bigText(this.f2856e);
                if (this.f2893d) {
                    bigText.setSummaryText(this.f2892c);
                }
            }
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f2857a;

        /* renamed from: b  reason: collision with root package name */
        private PendingIntent f2858b;

        /* renamed from: c  reason: collision with root package name */
        private IconCompat f2859c;

        /* renamed from: d  reason: collision with root package name */
        private int f2860d;

        /* renamed from: e  reason: collision with root package name */
        private int f2861e;

        /* renamed from: f  reason: collision with root package name */
        private int f2862f;

        /* renamed from: g  reason: collision with root package name */
        private String f2863g;

        private static class a {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null || cVar.a() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(cVar.d().e()).setIntent(cVar.a()).setDeleteIntent(cVar.c()).setAutoExpandBubble(cVar.g()).setSuppressNotification(cVar.h());
                if (cVar.e() != 0) {
                    suppressNotification.setDesiredHeight(cVar.e());
                }
                if (cVar.f() != 0) {
                    suppressNotification.setDesiredHeightResId(cVar.f());
                }
                return suppressNotification.build();
            }
        }

        private static class b {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = cVar.b() != null ? new Notification.BubbleMetadata.Builder(cVar.b()) : new Notification.BubbleMetadata.Builder(cVar.a(), cVar.d().e());
                builder.setDeleteIntent(cVar.c()).setAutoExpandBubble(cVar.g()).setSuppressNotification(cVar.h());
                if (cVar.e() != 0) {
                    builder.setDesiredHeight(cVar.e());
                }
                if (cVar.f() != 0) {
                    builder.setDesiredHeightResId(cVar.f());
                }
                return builder.build();
            }
        }

        public static Notification.BubbleMetadata a(c cVar) {
            if (cVar == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return b.a(cVar);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return a.a(cVar);
            }
            return null;
        }

        public PendingIntent a() {
            return this.f2857a;
        }

        public String b() {
            return this.f2863g;
        }

        public PendingIntent c() {
            return this.f2858b;
        }

        public IconCompat d() {
            return this.f2859c;
        }

        public int e() {
            return this.f2860d;
        }

        public int f() {
            return this.f2861e;
        }

        public boolean g() {
            return (this.f2862f & 1) != 0;
        }

        public boolean h() {
            return (this.f2862f & 2) != 0;
        }
    }

    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        androidx.core.content.c N;
        long O;
        int P;
        boolean Q;
        c R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a  reason: collision with root package name */
        public Context f2864a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f2865b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<l> f2866c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f2867d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f2868e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f2869f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f2870g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f2871h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f2872i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f2873j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f2874k;

        /* renamed from: l  reason: collision with root package name */
        int f2875l;

        /* renamed from: m  reason: collision with root package name */
        int f2876m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2877n;

        /* renamed from: o  reason: collision with root package name */
        boolean f2878o;

        /* renamed from: p  reason: collision with root package name */
        e f2879p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f2880q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f2881r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f2882s;

        /* renamed from: t  reason: collision with root package name */
        int f2883t;

        /* renamed from: u  reason: collision with root package name */
        int f2884u;

        /* renamed from: v  reason: collision with root package name */
        boolean f2885v;

        /* renamed from: w  reason: collision with root package name */
        String f2886w;

        /* renamed from: x  reason: collision with root package name */
        boolean f2887x;

        /* renamed from: y  reason: collision with root package name */
        String f2888y;

        /* renamed from: z  reason: collision with root package name */
        boolean f2889z;

        @Deprecated
        public d(Context context) {
            this(context, (String) null);
        }

        public d(Context context, String str) {
            this.f2865b = new ArrayList<>();
            this.f2866c = new ArrayList<>();
            this.f2867d = new ArrayList<>();
            this.f2877n = true;
            this.f2889z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f2864a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f2876m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        private void a(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.S;
                i3 = i2 | notification.flags;
            } else {
                notification = this.S;
                i3 = (i2 ^ -1) & notification.flags;
            }
            notification.flags = i3;
        }

        protected static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Bundle a() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d a(int i2) {
            this.S.icon = i2;
            return this;
        }

        public d a(int i2, int i3, boolean z2) {
            this.f2883t = i2;
            this.f2884u = i3;
            this.f2885v = z2;
            return this;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2865b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public d a(long j2) {
            this.S.when = j2;
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f2870g = pendingIntent;
            return this;
        }

        public d a(e eVar) {
            if (this.f2879p != eVar) {
                this.f2879p = eVar;
                if (eVar != null) {
                    eVar.a(this);
                }
            }
            return this;
        }

        public d a(CharSequence charSequence) {
            this.f2868e = f(charSequence);
            return this;
        }

        public d a(String str) {
            this.K = str;
            return this;
        }

        public d a(boolean z2) {
            a(16, z2);
            return this;
        }

        public Notification b() {
            return new i(this).b();
        }

        public d b(int i2) {
            this.f2875l = i2;
            return this;
        }

        public d b(CharSequence charSequence) {
            this.f2869f = f(charSequence);
            return this;
        }

        public d b(boolean z2) {
            this.f2889z = z2;
            return this;
        }

        public d c(int i2) {
            this.f2876m = i2;
            return this;
        }

        public d c(CharSequence charSequence) {
            this.f2880q = f(charSequence);
            return this;
        }

        public d d(CharSequence charSequence) {
            this.f2874k = f(charSequence);
            return this;
        }

        public d e(CharSequence charSequence) {
            this.S.tickerText = f(charSequence);
            return this;
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f2890a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f2891b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2892c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2893d = false;

        /* access modifiers changed from: protected */
        public String a() {
            return null;
        }

        public void a(Bundle bundle) {
            if (this.f2893d) {
                bundle.putCharSequence("android.summaryText", this.f2892c);
            }
            CharSequence charSequence = this.f2891b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String a2 = a();
            if (a2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", a2);
            }
        }

        public void a(g gVar) {
        }

        public void a(d dVar) {
            if (this.f2890a != dVar) {
                this.f2890a = dVar;
                if (dVar != null) {
                    dVar.a(this);
                }
            }
        }

        public RemoteViews b(g gVar) {
            return null;
        }

        public RemoteViews c(g gVar) {
            return null;
        }

        public RemoteViews d(g gVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return j.a(notification);
        }
        return null;
    }
}
