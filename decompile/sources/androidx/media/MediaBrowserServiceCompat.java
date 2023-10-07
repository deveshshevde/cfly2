package androidx.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3724a = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    final j.a<IBinder, b> f3725b = new j.a<>();

    /* renamed from: c  reason: collision with root package name */
    b f3726c;

    /* renamed from: d  reason: collision with root package name */
    final g f3727d = new g();

    /* renamed from: e  reason: collision with root package name */
    MediaSessionCompat.Token f3728e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f3740a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f3741b;

        public String a() {
            return this.f3740a;
        }

        public Bundle b() {
            return this.f3741b;
        }
    }

    private class b implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f3742a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3743b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3744c;

        /* renamed from: d  reason: collision with root package name */
        public final b.a f3745d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f3746e;

        /* renamed from: f  reason: collision with root package name */
        public final e f3747f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap<String, List<s.d<IBinder, Bundle>>> f3748g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public a f3749h;

        b(String str, int i2, int i3, Bundle bundle, e eVar) {
            this.f3742a = str;
            this.f3743b = i2;
            this.f3744c = i3;
            this.f3745d = new b.a(str, i2, i3);
            this.f3746e = bundle;
            this.f3747f = eVar;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.f3727d.post(new Runnable() {
                public void run() {
                    MediaBrowserServiceCompat.this.f3725b.remove(b.this.f3747f.a());
                }
            });
        }
    }

    public static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3752a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3753b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3754c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3755d;

        /* renamed from: e  reason: collision with root package name */
        private int f3756e;

        c(Object obj) {
            this.f3752a = obj;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f3756e = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(T t2) {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3753b || this.f3754c || this.f3755d;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f3756e;
        }

        /* access modifiers changed from: package-private */
        public void b(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f3752a);
        }

        public void b(T t2) {
            if (this.f3754c || this.f3755d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f3752a);
            }
            this.f3754c = true;
            a(t2);
        }

        public void c(Bundle bundle) {
            if (this.f3754c || this.f3755d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f3752a);
            }
            this.f3755d = true;
            b(bundle);
        }
    }

    private class d {
        d() {
        }

        public void a(final e eVar) {
            MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                public void run() {
                    b remove = MediaBrowserServiceCompat.this.f3725b.remove(eVar.a());
                    if (remove != null) {
                        remove.f3747f.a().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void a(e eVar, String str, int i2, int i3, Bundle bundle) {
            final e eVar2 = eVar;
            final String str2 = str;
            final int i4 = i2;
            final int i5 = i3;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                public void run() {
                    IBinder a2 = eVar2.a();
                    MediaBrowserServiceCompat.this.f3725b.remove(a2);
                    b bVar = new b(str2, i4, i5, bundle2, eVar2);
                    MediaBrowserServiceCompat.this.f3725b.put(a2, bVar);
                    try {
                        a2.linkToDeath(bVar, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void a(String str, int i2, int i3, Bundle bundle, e eVar) {
            if (MediaBrowserServiceCompat.this.a(str, i3)) {
                final e eVar2 = eVar;
                final String str2 = str;
                final int i4 = i2;
                final int i5 = i3;
                final Bundle bundle2 = bundle;
                MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                    public void run() {
                        IBinder a2 = eVar2.a();
                        MediaBrowserServiceCompat.this.f3725b.remove(a2);
                        b bVar = new b(str2, i4, i5, bundle2, eVar2);
                        MediaBrowserServiceCompat.this.f3726c = bVar;
                        bVar.f3749h = MediaBrowserServiceCompat.this.a(str2, i5, bundle2);
                        MediaBrowserServiceCompat.this.f3726c = null;
                        if (bVar.f3749h == null) {
                            Log.i("MBServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                eVar2.b();
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                            }
                        } else {
                            try {
                                MediaBrowserServiceCompat.this.f3725b.put(a2, bVar);
                                a2.linkToDeath(bVar, 0);
                                if (MediaBrowserServiceCompat.this.f3728e != null) {
                                    eVar2.a(bVar.f3749h.a(), MediaBrowserServiceCompat.this.f3728e, bVar.f3749h.b());
                                }
                            } catch (RemoteException unused2) {
                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                                MediaBrowserServiceCompat.this.f3725b.remove(a2);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver, e eVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final e eVar2 = eVar;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                    public void run() {
                        b bVar = MediaBrowserServiceCompat.this.f3725b.get(eVar2.a());
                        if (bVar == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.a(str2, bundle2, bVar, resultReceiver2);
                    }
                });
            }
        }

        public void a(String str, IBinder iBinder, Bundle bundle, e eVar) {
            final e eVar2 = eVar;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.f3725b.get(eVar2.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str2);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str2, bVar, iBinder2, bundle2);
                }
            });
        }

        public void a(final String str, final IBinder iBinder, final e eVar) {
            MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                public void run() {
                    b bVar = MediaBrowserServiceCompat.this.f3725b.get(eVar.a());
                    if (bVar == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.a(str, bVar, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void a(final String str, final ResultReceiver resultReceiver, final e eVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                    public void run() {
                        b bVar = MediaBrowserServiceCompat.this.f3725b.get(eVar.a());
                        if (bVar == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.a(str, bVar, resultReceiver);
                    }
                });
            }
        }

        public void b(final e eVar) {
            MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                public void run() {
                    IBinder a2 = eVar.a();
                    b remove = MediaBrowserServiceCompat.this.f3725b.remove(a2);
                    if (remove != null) {
                        a2.unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void b(String str, Bundle bundle, ResultReceiver resultReceiver, e eVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final e eVar2 = eVar;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f3727d.a(new Runnable() {
                    public void run() {
                        b bVar = MediaBrowserServiceCompat.this.f3725b.get(eVar2.a());
                        if (bVar == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.b(str2, bundle2, bVar, resultReceiver2);
                    }
                });
            }
        }
    }

    private interface e {
        IBinder a();

        void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        void b() throws RemoteException;
    }

    private static class f implements e {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f3797a;

        f(Messenger messenger) {
            this.f3797a = messenger;
        }

        private void a(int i2, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f3797a.send(obtain);
        }

        public IBinder a() {
            return this.f3797a.getBinder();
        }

        public void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            a(3, bundle3);
        }

        public void b() throws RemoteException {
            a(2, (Bundle) null);
        }
    }

    private final class g extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private final d f3799b;

        g() {
            this.f3799b = new d();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.f3799b.a(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, (e) new f(message.replyTo));
                    return;
                case 2:
                    this.f3799b.a(new f(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.f3799b.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), bundle2, (e) new f(message.replyTo));
                    return;
                case 4:
                    this.f3799b.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), (e) new f(message.replyTo));
                    return;
                case 5:
                    this.f3799b.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), (e) new f(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    d dVar = this.f3799b;
                    f fVar = new f(message.replyTo);
                    dVar.a((e) fVar, data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f3799b.b(new f(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    this.f3799b.a(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), (e) new f(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.f3799b.b(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new f(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j2);
        }
    }

    public abstract a a(String str, int i2, Bundle bundle);

    /* access modifiers changed from: package-private */
    public List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Bundle bundle, b bVar, final ResultReceiver resultReceiver) {
        AnonymousClass3 r0 = new c<List<MediaBrowserCompat.MediaItem>>(str) {
            /* access modifiers changed from: package-private */
            public void a(List<MediaBrowserCompat.MediaItem> list) {
                if ((b() & 4) != 0 || list == null) {
                    resultReceiver.b(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.b(0, bundle);
            }
        };
        this.f3726c = bVar;
        a(str, bundle, (c<List<MediaBrowserCompat.MediaItem>>) r0);
        this.f3726c = null;
        if (!r0.a()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public void a(String str, Bundle bundle, c<List<MediaBrowserCompat.MediaItem>> cVar) {
        cVar.a(4);
        cVar.b(null);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, Bundle bundle, Bundle bundle2) {
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        AnonymousClass1 r0 = new c<List<MediaBrowserCompat.MediaItem>>(str) {
            /* access modifiers changed from: package-private */
            public void a(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.f3725b.get(bVar2.f3747f.a()) == bVar2) {
                    if ((b() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.a(list, bundle3);
                    }
                    try {
                        bVar2.f3747f.a(str2, list, bundle3, bundle4);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + bVar2.f3742a);
                    }
                } else if (MediaBrowserServiceCompat.f3724a) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + bVar2.f3742a + " id=" + str2);
                }
            }
        };
        this.f3726c = bVar;
        if (bundle == null) {
            a(str, (c<List<MediaBrowserCompat.MediaItem>>) r0);
        } else {
            a(str, (c<List<MediaBrowserCompat.MediaItem>>) r0, bundle);
        }
        this.f3726c = null;
        if (!r0.a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.f3742a + " id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List<s.d> list = bVar.f3748g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (s.d dVar : list) {
            if (iBinder == dVar.f34394a && a.a(bundle, (Bundle) dVar.f34395b)) {
                return;
            }
        }
        list.add(new s.d(iBinder, bundle));
        bVar.f3748g.put(str, list);
        a(str, bVar, bundle, (Bundle) null);
        this.f3726c = bVar;
        a(str, bundle);
        this.f3726c = null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar, final ResultReceiver resultReceiver) {
        AnonymousClass2 r0 = new c<MediaBrowserCompat.MediaItem>(str) {
            /* access modifiers changed from: package-private */
            public void a(MediaBrowserCompat.MediaItem mediaItem) {
                if ((b() & 2) != 0) {
                    resultReceiver.b(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.b(0, bundle);
            }
        };
        this.f3726c = bVar;
        b(str, r0);
        this.f3726c = null;
        if (!r0.a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    public abstract void a(String str, c<List<MediaBrowserCompat.MediaItem>> cVar);

    public void a(String str, c<List<MediaBrowserCompat.MediaItem>> cVar, Bundle bundle) {
        cVar.a(1);
        a(str, cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i2)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, b bVar, IBinder iBinder) {
        boolean z2 = true;
        boolean z3 = false;
        if (iBinder == null) {
            try {
                if (bVar.f3748g.remove(str) == null) {
                    z2 = false;
                }
                return z2;
            } finally {
                this.f3726c = bVar;
                a(str);
                this.f3726c = null;
            }
        } else {
            List list = bVar.f3748g.get(str);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == ((s.d) it2.next()).f34394a) {
                        it2.remove();
                        z3 = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.f3748g.remove(str);
                }
            }
            this.f3726c = bVar;
            a(str);
            this.f3726c = null;
            return z3;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str, Bundle bundle, b bVar, final ResultReceiver resultReceiver) {
        AnonymousClass4 r0 = new c<Bundle>(str) {
            /* access modifiers changed from: package-private */
            public void a(Bundle bundle) {
                resultReceiver.b(0, bundle);
            }

            /* access modifiers changed from: package-private */
            public void b(Bundle bundle) {
                resultReceiver.b(-1, bundle);
            }
        };
        this.f3726c = bVar;
        b(str, bundle, r0);
        this.f3726c = null;
        if (!r0.a()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void b(String str, Bundle bundle, c<Bundle> cVar) {
        cVar.c((Bundle) null);
    }

    public void b(String str, c<MediaBrowserCompat.MediaItem> cVar) {
        cVar.a(2);
        cVar.b(null);
    }
}
