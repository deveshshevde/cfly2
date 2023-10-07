package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f279a = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    private final e f280b;

    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f281d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f282e;

        /* renamed from: f  reason: collision with root package name */
        private final c f283f;

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            if (this.f283f != null) {
                MediaSessionCompat.a(bundle);
                if (i2 == -1) {
                    this.f283f.c(this.f281d, this.f282e, bundle);
                } else if (i2 == 0) {
                    this.f283f.b(this.f281d, this.f282e, bundle);
                } else if (i2 != 1) {
                    Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f282e + ", resultData=" + bundle + ")");
                } else {
                    this.f283f.a(this.f281d, this.f282e, bundle);
                }
            }
        }
    }

    private static class ItemReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f284d;

        /* renamed from: e  reason: collision with root package name */
        private final d f285e;

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f285e.a(this.f284d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f285e.a((MediaItem) parcelable);
            } else {
                this.f285e.a(this.f284d);
            }
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final int f286a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f287b;

        MediaItem(Parcel parcel) {
            this.f286a = parcel.readInt();
            this.f287b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(mediaDescriptionCompat.a())) {
                this.f286a = i2;
                this.f287b = mediaDescriptionCompat;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }

        public static MediaItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.a(mediaItem.getDescription()), mediaItem.getFlags());
        }

        public static List<MediaItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object a2 : list) {
                arrayList.add(a((Object) a2));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f286a + ", mDescription=" + this.f287b + '}';
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f286a);
            this.f287b.writeToParcel(parcel, i2);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f288d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f289e;

        /* renamed from: f  reason: collision with root package name */
        private final k f290f;

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f290f.a(this.f288d, this.f289e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f290f.a(this.f288d, this.f289e, arrayList);
        }
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<j> f291a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Messenger> f292b;

        a(j jVar) {
            this.f291a = new WeakReference<>(jVar);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            this.f292b = new WeakReference<>(messenger);
        }

        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f292b;
            if (weakReference != null && weakReference.get() != null && this.f291a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                j jVar = (j) this.f291a.get();
                Messenger messenger = (Messenger) this.f292b.get();
                try {
                    int i2 = message.what;
                    if (i2 == 1) {
                        Bundle bundle = data.getBundle("data_root_hints");
                        MediaSessionCompat.a(bundle);
                        jVar.a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                    } else if (i2 == 2) {
                        jVar.a(messenger);
                    } else if (i2 != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle("data_options");
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                        MediaSessionCompat.a(bundle3);
                        jVar.a(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        jVar.a(messenger);
                    }
                }
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.ConnectionCallback f293a;

        /* renamed from: b  reason: collision with root package name */
        C0007b f294b;

        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            public void onConnected() {
                if (b.this.f294b != null) {
                    b.this.f294b.a();
                }
                b.this.a();
            }

            public void onConnectionFailed() {
                if (b.this.f294b != null) {
                    b.this.f294b.c();
                }
                b.this.c();
            }

            public void onConnectionSuspended() {
                if (b.this.f294b != null) {
                    b.this.f294b.b();
                }
                b.this.b();
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        interface C0007b {
            void a();

            void b();

            void c();
        }

        public b() {
            this.f293a = Build.VERSION.SDK_INT >= 21 ? new a() : null;
        }

        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(C0007b bVar) {
            this.f294b = bVar;
        }

        public void b() {
        }

        public void c() {
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class d {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    interface e {
        void d();

        void e();

        MediaSessionCompat.Token f();
    }

    static class f implements b.C0007b, e, j {

        /* renamed from: a  reason: collision with root package name */
        final Context f296a;

        /* renamed from: b  reason: collision with root package name */
        protected final MediaBrowser f297b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f298c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f299d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        protected int f300e;

        /* renamed from: f  reason: collision with root package name */
        protected l f301f;

        /* renamed from: g  reason: collision with root package name */
        protected Messenger f302g;

        /* renamed from: h  reason: collision with root package name */
        private final j.a<String, m> f303h = new j.a<>();

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f304i;

        /* renamed from: j  reason: collision with root package name */
        private Bundle f305j;

        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            Bundle bundle2;
            this.f296a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f298c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bVar.a(this);
            this.f297b = new MediaBrowser(context, componentName, bVar.f293a, bundle2);
        }

        public void a() {
            try {
                Bundle extras = this.f297b.getExtras();
                if (extras != null) {
                    this.f300e = extras.getInt("extra_service_version", 0);
                    IBinder a2 = androidx.core.app.e.a(extras, "extra_messenger");
                    if (a2 != null) {
                        this.f301f = new l(a2, this.f298c);
                        Messenger messenger = new Messenger(this.f299d);
                        this.f302g = messenger;
                        this.f299d.a(messenger);
                        try {
                            this.f301f.b(this.f296a, this.f302g);
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        }
                    }
                    android.support.v4.media.session.b a3 = b.a.a(androidx.core.app.e.a(extras, "extra_session_binder"));
                    if (a3 != null) {
                        this.f304i = MediaSessionCompat.Token.a(this.f297b.getSessionToken(), a3);
                    }
                }
            } catch (IllegalStateException e2) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e2);
            }
        }

        public void a(Messenger messenger) {
        }

        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f302g == messenger) {
                m mVar = this.f303h.get(str);
                if (mVar != null) {
                    n a2 = mVar.a(bundle);
                    if (a2 != null) {
                        if (bundle == null) {
                            if (list == null) {
                                a2.a(str);
                                return;
                            } else {
                                this.f305j = bundle2;
                                a2.a(str, (List<MediaItem>) list);
                            }
                        } else if (list == null) {
                            a2.a(str, bundle);
                            return;
                        } else {
                            this.f305j = bundle2;
                            a2.a(str, list, bundle);
                        }
                        this.f305j = null;
                    }
                } else if (MediaBrowserCompat.f279a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public void b() {
            this.f301f = null;
            this.f302g = null;
            this.f304i = null;
            this.f299d.a((Messenger) null);
        }

        public void c() {
        }

        public void d() {
            this.f297b.connect();
        }

        public void e() {
            Messenger messenger;
            l lVar = this.f301f;
            if (!(lVar == null || (messenger = this.f302g) == null)) {
                try {
                    lVar.b(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.f297b.disconnect();
        }

        public MediaSessionCompat.Token f() {
            if (this.f304i == null) {
                this.f304i = MediaSessionCompat.Token.a((Object) this.f297b.getSessionToken());
            }
            return this.f304i;
        }
    }

    static class g extends f {
        g(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class h extends g {
        h(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class i implements e, j {

        /* renamed from: a  reason: collision with root package name */
        final Context f306a;

        /* renamed from: b  reason: collision with root package name */
        final ComponentName f307b;

        /* renamed from: c  reason: collision with root package name */
        final b f308c;

        /* renamed from: d  reason: collision with root package name */
        final Bundle f309d;

        /* renamed from: e  reason: collision with root package name */
        final a f310e = new a(this);

        /* renamed from: f  reason: collision with root package name */
        int f311f = 1;

        /* renamed from: g  reason: collision with root package name */
        a f312g;

        /* renamed from: h  reason: collision with root package name */
        l f313h;

        /* renamed from: i  reason: collision with root package name */
        Messenger f314i;

        /* renamed from: j  reason: collision with root package name */
        private final j.a<String, m> f315j = new j.a<>();

        /* renamed from: k  reason: collision with root package name */
        private String f316k;

        /* renamed from: l  reason: collision with root package name */
        private MediaSessionCompat.Token f317l;

        /* renamed from: m  reason: collision with root package name */
        private Bundle f318m;

        /* renamed from: n  reason: collision with root package name */
        private Bundle f319n;

        private class a implements ServiceConnection {
            a() {
            }

            private void a(Runnable runnable) {
                if (Thread.currentThread() == i.this.f310e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    i.this.f310e.post(runnable);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a(String str) {
                if (i.this.f312g == this && i.this.f311f != 0 && i.this.f311f != 1) {
                    return true;
                }
                if (i.this.f311f == 0 || i.this.f311f == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + i.this.f307b + " with mServiceConnection=" + i.this.f312g + " this=" + this);
                return false;
            }

            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                a((Runnable) new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.f279a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            i.this.c();
                        }
                        if (a.this.a("onServiceConnected")) {
                            i.this.f313h = new l(iBinder, i.this.f309d);
                            i.this.f314i = new Messenger(i.this.f310e);
                            i.this.f310e.a(i.this.f314i);
                            i.this.f311f = 2;
                            try {
                                if (MediaBrowserCompat.f279a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    i.this.c();
                                }
                                i.this.f313h.a(i.this.f306a, i.this.f314i);
                            } catch (RemoteException unused) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + i.this.f307b);
                                if (MediaBrowserCompat.f279a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    i.this.c();
                                }
                            }
                        }
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName componentName) {
                a((Runnable) new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.f279a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + i.this.f312g);
                            i.this.c();
                        }
                        if (a.this.a("onServiceDisconnected")) {
                            i.this.f313h = null;
                            i.this.f314i = null;
                            i.this.f310e.a((Messenger) null);
                            i.this.f311f = 4;
                            i.this.f308c.b();
                        }
                    }
                });
            }
        }

        public i(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (bVar != null) {
                this.f306a = context;
                this.f307b = componentName;
                this.f308c = bVar;
                this.f309d = bundle == null ? null : new Bundle(bundle);
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        private static String a(int i2) {
            if (i2 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i2 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i2 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i2 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i2 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i2;
        }

        private boolean a(Messenger messenger, String str) {
            int i2;
            if (this.f314i == messenger && (i2 = this.f311f) != 0 && i2 != 1) {
                return true;
            }
            int i3 = this.f311f;
            if (i3 == 0 || i3 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.f307b + " with mCallbacksMessenger=" + this.f314i + " this=" + this);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a aVar = this.f312g;
            if (aVar != null) {
                this.f306a.unbindService(aVar);
            }
            this.f311f = 1;
            this.f312g = null;
            this.f313h = null;
            this.f314i = null;
            this.f310e.a((Messenger) null);
            this.f316k = null;
            this.f317l = null;
        }

        public void a(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f307b);
            if (a(messenger, "onConnectFailed")) {
                if (this.f311f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f311f) + "... ignoring");
                    return;
                }
                a();
                this.f308c.c();
            }
        }

        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.f311f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f311f) + "... ignoring");
                    return;
                }
                this.f316k = str;
                this.f317l = token;
                this.f318m = bundle;
                this.f311f = 3;
                if (MediaBrowserCompat.f279a) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    c();
                }
                this.f308c.a();
                try {
                    for (Map.Entry next : this.f315j.entrySet()) {
                        String str2 = (String) next.getKey();
                        m mVar = (m) next.getValue();
                        List<n> b2 = mVar.b();
                        List<Bundle> a2 = mVar.a();
                        for (int i2 = 0; i2 < b2.size(); i2++) {
                            this.f313h.a(str2, b2.get(i2).f333b, a2.get(i2), this.f314i);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        public void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f279a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f307b + " id=" + str);
                }
                m mVar = this.f315j.get(str);
                if (mVar != null) {
                    n a2 = mVar.a(bundle);
                    if (a2 != null) {
                        if (bundle == null) {
                            if (list == null) {
                                a2.a(str);
                                return;
                            } else {
                                this.f319n = bundle2;
                                a2.a(str, (List<MediaItem>) list);
                            }
                        } else if (list == null) {
                            a2.a(str, bundle);
                            return;
                        } else {
                            this.f319n = bundle2;
                            a2.a(str, list, bundle);
                        }
                        this.f319n = null;
                    }
                } else if (MediaBrowserCompat.f279a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public boolean b() {
            return this.f311f == 3;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f307b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f308c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f309d);
            Log.d("MediaBrowserCompat", "  mState=" + a(this.f311f));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f312g);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f313h);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f314i);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f316k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f317l);
        }

        public void d() {
            int i2 = this.f311f;
            if (i2 == 0 || i2 == 1) {
                this.f311f = 2;
                this.f310e.post(new Runnable() {
                    public void run() {
                        if (i.this.f311f != 0) {
                            i.this.f311f = 2;
                            if (MediaBrowserCompat.f279a && i.this.f312g != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + i.this.f312g);
                            } else if (i.this.f313h != null) {
                                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + i.this.f313h);
                            } else if (i.this.f314i == null) {
                                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                                intent.setComponent(i.this.f307b);
                                i iVar = i.this;
                                iVar.f312g = new a();
                                boolean z2 = false;
                                try {
                                    z2 = i.this.f306a.bindService(intent, i.this.f312g, 1);
                                } catch (Exception unused) {
                                    Log.e("MediaBrowserCompat", "Failed binding to service " + i.this.f307b);
                                }
                                if (!z2) {
                                    i.this.a();
                                    i.this.f308c.c();
                                }
                                if (MediaBrowserCompat.f279a) {
                                    Log.d("MediaBrowserCompat", "connect...");
                                    i.this.c();
                                }
                            } else {
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + i.this.f314i);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f311f) + ")");
        }

        public void e() {
            this.f311f = 0;
            this.f310e.post(new Runnable() {
                public void run() {
                    if (i.this.f314i != null) {
                        try {
                            i.this.f313h.a(i.this.f314i);
                        } catch (RemoteException unused) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + i.this.f307b);
                        }
                    }
                    int i2 = i.this.f311f;
                    i.this.a();
                    if (i2 != 0) {
                        i.this.f311f = i2;
                    }
                    if (MediaBrowserCompat.f279a) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        i.this.c();
                    }
                }
            });
        }

        public MediaSessionCompat.Token f() {
            if (b()) {
                return this.f317l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f311f + ")");
        }
    }

    interface j {
        void a(Messenger messenger);

        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    public static abstract class k {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    private static class l {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f328a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f329b;

        public l(IBinder iBinder, Bundle bundle) {
            this.f328a = new Messenger(iBinder);
            this.f329b = bundle;
        }

        private void a(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f328a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f329b);
            a(1, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) throws RemoteException {
            a(2, (Bundle) null, messenger);
        }

        /* access modifiers changed from: package-private */
        public void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            androidx.core.app.e.a(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            a(3, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f329b);
            a(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void b(Messenger messenger) throws RemoteException {
            a(7, (Bundle) null, messenger);
        }
    }

    private static class m {

        /* renamed from: a  reason: collision with root package name */
        private final List<n> f330a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<Bundle> f331b = new ArrayList();

        public n a(Bundle bundle) {
            for (int i2 = 0; i2 < this.f331b.size(); i2++) {
                if (androidx.media.a.a(this.f331b.get(i2), bundle)) {
                    return this.f330a.get(i2);
                }
            }
            return null;
        }

        public List<Bundle> a() {
            return this.f331b;
        }

        public List<n> b() {
            return this.f330a;
        }
    }

    public static abstract class n {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.SubscriptionCallback f332a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f333b = new Binder();

        /* renamed from: c  reason: collision with root package name */
        WeakReference<m> f334c;

        private class a extends MediaBrowser.SubscriptionCallback {
            a() {
            }

            /* access modifiers changed from: package-private */
            public List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i2 == -1 && i3 == -1) {
                    return list;
                }
                int i4 = i3 * i2;
                int i5 = i4 + i3;
                if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i5 > list.size()) {
                    i5 = list.size();
                }
                return list.subList(i4, i5);
            }

            public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
                m mVar = n.this.f334c == null ? null : (m) n.this.f334c.get();
                if (mVar == null) {
                    n.this.a(str, MediaItem.a((List<?>) list));
                    return;
                }
                List<MediaItem> a2 = MediaItem.a((List<?>) list);
                List<n> b2 = mVar.b();
                List<Bundle> a3 = mVar.a();
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    Bundle bundle = a3.get(i2);
                    if (bundle == null) {
                        n.this.a(str, a2);
                    } else {
                        n.this.a(str, a(a2, bundle), bundle);
                    }
                }
            }

            public void onError(String str) {
                n.this.a(str);
            }
        }

        private class b extends a {
            b() {
                super();
            }

            public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                n.this.a(str, MediaItem.a((List<?>) list), bundle);
            }

            public void onError(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                n.this.a(str, bundle);
            }
        }

        public n() {
            this.f332a = Build.VERSION.SDK_INT >= 26 ? new b() : Build.VERSION.SDK_INT >= 21 ? new a() : null;
        }

        public void a(String str) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(String str, List<MediaItem> list) {
        }

        public void a(String str, List<MediaItem> list, Bundle bundle) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        this.f280b = Build.VERSION.SDK_INT >= 26 ? new h(context, componentName, bVar, bundle) : Build.VERSION.SDK_INT >= 23 ? new g(context, componentName, bVar, bundle) : Build.VERSION.SDK_INT >= 21 ? new f(context, componentName, bVar, bundle) : new i(context, componentName, bVar, bundle);
    }

    public void a() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.f280b.d();
    }

    public void b() {
        this.f280b.e();
    }

    public MediaSessionCompat.Token c() {
        return this.f280b.f();
    }
}
