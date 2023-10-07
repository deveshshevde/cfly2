package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.xeagle.android.vjoystick.utils.transformation.OkHttpAppGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpAppGlideModule f10026a = new OkHttpAppGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.xeagle.android.vjoystick.utils.transformation.OkHttpAppGlideModule");
        }
    }

    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    public void a(Context context, c cVar, Registry registry) {
        this.f10026a.a(context, cVar, registry);
    }

    public void a(Context context, d dVar) {
        this.f10026a.a(context, dVar);
    }

    public boolean c() {
        return this.f10026a.c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public a b() {
        return new a();
    }
}
