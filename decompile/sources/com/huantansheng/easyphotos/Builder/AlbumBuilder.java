package com.huantansheng.easyphotos.Builder;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huantansheng.easyphotos.ui.EasyPhotosActivity;
import hi.a;
import java.lang.ref.WeakReference;

public class AlbumBuilder {

    /* renamed from: a  reason: collision with root package name */
    private static AlbumBuilder f20287a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f20288b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Fragment> f20289c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<android.app.Fragment> f20290d;

    /* renamed from: e  reason: collision with root package name */
    private StartupType f20291e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<a> f20292f;

    /* renamed from: com.huantansheng.easyphotos.Builder.AlbumBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20293a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huantansheng.easyphotos.Builder.AlbumBuilder$StartupType[] r0 = com.huantansheng.easyphotos.Builder.AlbumBuilder.StartupType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20293a = r0
                com.huantansheng.easyphotos.Builder.AlbumBuilder$StartupType r1 = com.huantansheng.easyphotos.Builder.AlbumBuilder.StartupType.f20294a     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20293a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huantansheng.easyphotos.Builder.AlbumBuilder$StartupType r1 = com.huantansheng.easyphotos.Builder.AlbumBuilder.StartupType.ALBUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20293a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huantansheng.easyphotos.Builder.AlbumBuilder$StartupType r1 = com.huantansheng.easyphotos.Builder.AlbumBuilder.StartupType.ALBUM_CAMERA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.Builder.AlbumBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private enum StartupType {
        f20294a,
        ALBUM,
        ALBUM_CAMERA
    }

    private AlbumBuilder(FragmentActivity fragmentActivity, StartupType startupType) {
        this.f20288b = new WeakReference<>(fragmentActivity);
        this.f20291e = startupType;
    }

    private static AlbumBuilder a(FragmentActivity fragmentActivity, StartupType startupType) {
        b();
        AlbumBuilder albumBuilder = new AlbumBuilder(fragmentActivity, startupType);
        f20287a = albumBuilder;
        return albumBuilder;
    }

    public static AlbumBuilder a(FragmentActivity fragmentActivity, boolean z2, hh.a aVar) {
        if (hq.a.f13402z != aVar) {
            hq.a.f13402z = aVar;
        }
        return a(fragmentActivity, z2 ? StartupType.ALBUM_CAMERA : StartupType.ALBUM);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0 != 3) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r4 = this;
            int[] r0 = com.huantansheng.easyphotos.Builder.AlbumBuilder.AnonymousClass1.f20293a
            com.huantansheng.easyphotos.Builder.AlbumBuilder$StartupType r1 = r4.f20291e
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0018
            r3 = 2
            if (r0 == r3) goto L_0x0015
            r3 = 3
            if (r0 == r3) goto L_0x001a
            goto L_0x001c
        L_0x0015:
            hq.a.f13392p = r1
            goto L_0x001c
        L_0x0018:
            hq.a.f13394r = r2
        L_0x001a:
            hq.a.f13392p = r2
        L_0x001c:
            java.util.List<java.lang.String> r0 = hq.a.f13396t
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = "gif"
            boolean r0 = hq.a.a(r0)
            if (r0 == 0) goto L_0x002e
            hq.a.f13397u = r2
        L_0x002e:
            java.lang.String r0 = "video"
            boolean r0 = hq.a.a(r0)
            if (r0 == 0) goto L_0x0038
            hq.a.f13398v = r2
        L_0x0038:
            boolean r0 = hq.a.b()
            if (r0 == 0) goto L_0x0046
            hq.a.f13392p = r1
            hq.a.f13395s = r1
            hq.a.f13397u = r1
            hq.a.f13398v = r2
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.Builder.AlbumBuilder.a():void");
    }

    public static void a(a aVar) {
        AlbumBuilder albumBuilder = f20287a;
        if (albumBuilder != null && albumBuilder.f20291e != StartupType.f20294a) {
            f20287a.f20292f = new WeakReference<>(aVar);
        }
    }

    private static void b() {
        hp.a.c();
        hq.a.a();
        f20287a = null;
    }

    private void c(int i2) {
        WeakReference<Activity> weakReference = this.f20288b;
        if (weakReference == null || weakReference.get() == null) {
            WeakReference<android.app.Fragment> weakReference2 = this.f20290d;
            if (weakReference2 == null || weakReference2.get() == null) {
                WeakReference<Fragment> weakReference3 = this.f20289c;
                if (weakReference3 != null && weakReference3.get() != null) {
                    EasyPhotosActivity.a((Fragment) this.f20289c.get(), i2);
                    return;
                }
                return;
            }
            EasyPhotosActivity.a((android.app.Fragment) this.f20290d.get(), i2);
            return;
        }
        EasyPhotosActivity.a((Activity) this.f20288b.get(), i2);
    }

    public AlbumBuilder a(int i2) {
        if (hq.a.A) {
            return this;
        }
        hq.a.f13380d = i2;
        return this;
    }

    public AlbumBuilder a(boolean z2) {
        hq.a.f13385i = z2;
        return this;
    }

    public void b(int i2) {
        a();
        c(i2);
    }
}
