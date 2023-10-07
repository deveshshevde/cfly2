package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final b f362a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f363b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<a> f364c = new HashSet<>();

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f365a;

        /* renamed from: b  reason: collision with root package name */
        final Object f366b = new Object();

        /* renamed from: c  reason: collision with root package name */
        final MediaSessionCompat.Token f367c;

        /* renamed from: d  reason: collision with root package name */
        private final List<a> f368d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private HashMap<a, a> f369e = new HashMap<>();

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f370a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f370a = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f370a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f366b) {
                        mediaControllerImplApi21.f367c.a(b.a.a(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f367c.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.a();
                    }
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public void a() throws RemoteException {
                throw new AssertionError();
            }

            public void a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }

            public void a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f367c = token;
            Object a2 = c.a(context, token.a());
            this.f365a = a2;
            if (a2 == null) {
                throw new RemoteException();
            } else if (token.b() == null) {
                b();
            }
        }

        private void b() {
            a("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f367c.b() != null) {
                for (a next : this.f368d) {
                    a aVar = new a(next);
                    this.f369e.put(next, aVar);
                    next.f373c = aVar;
                    try {
                        this.f367c.b().a((a) aVar);
                        next.a(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e2) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    }
                }
                this.f368d.clear();
            }
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            c.a(this.f365a, str, bundle, resultReceiver);
        }

        public boolean a(KeyEvent keyEvent) {
            return c.a(this.f365a, keyEvent);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final Object f371a;

        /* renamed from: b  reason: collision with root package name */
        C0009a f372b;

        /* renamed from: c  reason: collision with root package name */
        a f373c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private class C0009a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f374a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f375b;

            public void handleMessage(Message message) {
                if (this.f374a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.f375b.a((String) message.obj, data);
                            return;
                        case 2:
                            this.f375b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f375b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f375b.a((f) message.obj);
                            return;
                        case 5:
                            this.f375b.a((List<MediaSessionCompat.QueueItem>) (List) message.obj);
                            return;
                        case 6:
                            this.f375b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.f375b.a(bundle);
                            return;
                        case 8:
                            this.f375b.b();
                            return;
                        case 9:
                            this.f375b.a(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            this.f375b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f375b.b(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.f375b.a();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f376a;

            b(a aVar) {
                this.f376a = new WeakReference<>(aVar);
            }

            public void a() {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            public void a(int i2, int i3, int i4, int i5, int i6) {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.a(new f(i2, i3, i4, i5, i6));
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            public void a(Object obj) {
                a aVar = (a) this.f376a.get();
                if (aVar != null && aVar.f373c == null) {
                    aVar.a(PlaybackStateCompat.a(obj));
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.f376a.get();
                if (aVar == null) {
                    return;
                }
                if (aVar.f373c == null || Build.VERSION.SDK_INT >= 23) {
                    aVar.a(str, bundle);
                }
            }

            public void a(List<?> list) {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.f376a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }
        }

        private static class c extends a.C0010a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f377a;

            c(a aVar) {
                this.f377a = new WeakReference<>(aVar);
            }

            public void a() throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(8, (Object) null, (Bundle) null);
                }
            }

            public void a(int i2) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, (Bundle) null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new f(parcelableVolumeInfo.f391a, parcelableVolumeInfo.f392b, parcelableVolumeInfo.f393c, parcelableVolumeInfo.f394d, parcelableVolumeInfo.f395e) : null, (Bundle) null);
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, (Bundle) null);
                }
            }

            public void a(String str, Bundle bundle) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(5, list, (Bundle) null);
                }
            }

            public void a(boolean z2) throws RemoteException {
            }

            public void b() throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(13, (Object) null, (Bundle) null);
                }
            }

            public void b(int i2) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void b(boolean z2) throws RemoteException {
                a aVar = (a) this.f377a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z2), (Bundle) null);
                }
            }
        }

        public a() {
            c cVar;
            if (Build.VERSION.SDK_INT >= 21) {
                cVar = c.a(new b(this));
            } else {
                c cVar2 = new c(this);
                this.f373c = cVar2;
                cVar = cVar2;
            }
            this.f371a = cVar;
        }

        public void a() {
        }

        public void a(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, Object obj, Bundle bundle) {
            C0009a aVar = this.f372b;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(f fVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z2) {
        }

        public void b() {
        }

        public void b(int i2) {
        }
    }

    interface b {
        boolean a(KeyEvent keyEvent);
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    static class e implements b {

        /* renamed from: a  reason: collision with root package name */
        private b f378a;

        public e(MediaSessionCompat.Token token) {
            this.f378a = b.a.a((IBinder) token.a());
        }

        public boolean a(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.f378a.a(keyEvent);
                    return false;
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e2);
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f379a;

        /* renamed from: b  reason: collision with root package name */
        private final int f380b;

        /* renamed from: c  reason: collision with root package name */
        private final int f381c;

        /* renamed from: d  reason: collision with root package name */
        private final int f382d;

        /* renamed from: e  reason: collision with root package name */
        private final int f383e;

        f(int i2, int i3, int i4, int i5, int i6) {
            this.f379a = i2;
            this.f380b = i3;
            this.f381c = i4;
            this.f382d = i5;
            this.f383e = i6;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        b mediaControllerImplApi21;
        if (token != null) {
            this.f363b = token;
            if (Build.VERSION.SDK_INT >= 24) {
                mediaControllerImplApi21 = new d(context, token);
            } else if (Build.VERSION.SDK_INT >= 23) {
                mediaControllerImplApi21 = new c(context, token);
            } else if (Build.VERSION.SDK_INT >= 21) {
                mediaControllerImplApi21 = new MediaControllerImplApi21(context, token);
            } else {
                this.f362a = new e(token);
                return;
            }
            this.f362a = mediaControllerImplApi21;
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f362a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
