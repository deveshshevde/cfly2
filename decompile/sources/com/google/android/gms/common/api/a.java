package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final C0118a<?, O> f17387a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f17388b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17389c;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0118a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, O o2, d.b bVar, d.c cVar) {
            return a(context, looper, eVar, o2, (com.google.android.gms.common.api.internal.e) bVar, (m) cVar);
        }

        public T a(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, O o2, com.google.android.gms.common.api.internal.e eVar2, m mVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: i  reason: collision with root package name */
        public static final C0120d f17390i = new C0120d((l) null);

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0119a extends c, e {
            Account a();
        }

        public interface b extends c {
            GoogleSignInAccount a();
        }

        public interface c extends d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d  reason: collision with other inner class name */
        public static final class C0120d implements e {
            private C0120d() {
            }

            /* synthetic */ C0120d(l lVar) {
            }
        }

        public interface e extends d {
        }

        public interface f extends c, e {
        }
    }

    public static abstract class e<T extends b, O> {
        public int a() {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }

        public List<Scope> a(O o2) {
            return Collections.emptyList();
        }
    }

    public interface f extends b {
        void connect(d.c cVar);

        void disconnect();

        void disconnect(String str);

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(h hVar, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(d.e eVar);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, C0118a<C, O> aVar, g<C> gVar) {
        com.google.android.gms.common.internal.m.a(aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        com.google.android.gms.common.internal.m.a(gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.f17389c = str;
        this.f17387a = aVar;
        this.f17388b = gVar;
    }

    public final C0118a<?, O> a() {
        return this.f17387a;
    }

    public final c<?> b() {
        return this.f17388b;
    }

    public final e<?, O> c() {
        return this.f17387a;
    }

    public final String d() {
        return this.f17389c;
    }
}
