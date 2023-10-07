package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.internal.base.zak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f17707a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static HashSet<Uri> f17708b = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f17709c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f17710d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f17711e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final zak f17712f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Map<e, ImageReceiver> f17713g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Map<Uri, ImageReceiver> f17714h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Map<Uri, Long> f17715i;

    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageManager f17716a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f17717b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f17718c;

        public final void onReceiveResult(int i2, Bundle bundle) {
            ImageManager imageManager = this.f17716a;
            imageManager.f17711e.execute(new a(imageManager, this.f17717b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface a {
        void a(Uri uri, Drawable drawable, boolean z2);
    }
}
