package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import bl.b;
import bl.e;
import bm.h;
import bo.a;
import bo.b;
import bo.d;
import bo.e;
import bo.f;
import bo.k;
import bo.s;
import bo.t;
import bo.u;
import bo.v;
import bo.w;
import bo.x;
import bp.a;
import bp.b;
import bp.c;
import bp.d;
import bp.e;
import br.a;
import bu.j;
import bw.d;
import bw.p;
import cc.l;
import com.bumptech.glide.d;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.request.g;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f10048a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f10049b;

    /* renamed from: c  reason: collision with root package name */
    private final i f10050c;

    /* renamed from: d  reason: collision with root package name */
    private final e f10051d;

    /* renamed from: e  reason: collision with root package name */
    private final h f10052e;

    /* renamed from: f  reason: collision with root package name */
    private final e f10053f;

    /* renamed from: g  reason: collision with root package name */
    private final Registry f10054g;

    /* renamed from: h  reason: collision with root package name */
    private final b f10055h;

    /* renamed from: i  reason: collision with root package name */
    private final p f10056i;

    /* renamed from: j  reason: collision with root package name */
    private final d f10057j;

    /* renamed from: k  reason: collision with root package name */
    private final List<h> f10058k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private final a f10059l;

    /* renamed from: m  reason: collision with root package name */
    private MemoryCategory f10060m = MemoryCategory.NORMAL;

    public interface a {
        com.bumptech.glide.request.h a();
    }

    c(Context context, i iVar, h hVar, e eVar, b bVar, p pVar, d dVar, int i2, a aVar, Map<Class<?>, i<?, ?>> map, List<g<Object>> list, f fVar) {
        com.bumptech.glide.load.resource.bitmap.h hVar2;
        com.bumptech.glide.load.g gVar;
        Context context2 = context;
        e eVar2 = eVar;
        b bVar2 = bVar;
        f fVar2 = fVar;
        Class<byte[]> cls = byte[].class;
        this.f10050c = iVar;
        this.f10051d = eVar2;
        this.f10055h = bVar2;
        this.f10052e = hVar;
        this.f10056i = pVar;
        this.f10057j = dVar;
        this.f10059l = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f10054g = registry;
        registry.a((ImageHeaderParser) new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.a((ImageHeaderParser) new n());
        }
        List<ImageHeaderParser> a2 = registry.a();
        bu.a aVar2 = new bu.a(context2, a2, eVar2, bVar2);
        com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> b2 = VideoDecoder.b(eVar);
        k kVar = new k(registry.a(), resources.getDisplayMetrics(), eVar2, bVar2);
        if (Build.VERSION.SDK_INT < 28 || !fVar2.a(d.b.class)) {
            com.bumptech.glide.load.resource.bitmap.g gVar2 = new com.bumptech.glide.load.resource.bitmap.g(kVar);
            hVar2 = gVar2;
            gVar = new w(kVar, bVar2);
        } else {
            gVar = new r();
            hVar2 = new com.bumptech.glide.load.resource.bitmap.h();
        }
        if (Build.VERSION.SDK_INT >= 28 && fVar2.a(d.a.class)) {
            registry.a("Animation", InputStream.class, Drawable.class, bs.a.a(a2, bVar2));
            registry.a("Animation", ByteBuffer.class, Drawable.class, bs.a.b(a2, bVar2));
        }
        bs.e eVar3 = new bs.e(context2);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        Class<byte[]> cls2 = cls;
        s.b bVar3 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.c cVar2 = new com.bumptech.glide.load.resource.bitmap.c(bVar2);
        s.d dVar3 = dVar2;
        bv.a aVar4 = new bv.a();
        bv.d dVar4 = new bv.d();
        ContentResolver contentResolver = context.getContentResolver();
        s.b bVar4 = bVar3;
        s.c cVar3 = cVar;
        bs.e eVar4 = eVar3;
        registry.a(ByteBuffer.class, new bo.c()).a(InputStream.class, new t(bVar2)).a("Bitmap", ByteBuffer.class, Bitmap.class, hVar2).a("Bitmap", InputStream.class, Bitmap.class, gVar);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.t(kVar));
        }
        bs.e eVar5 = eVar4;
        registry.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.b()).a("Bitmap", Bitmap.class, Bitmap.class, new y()).a(Bitmap.class, cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, hVar2)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVar)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, b2)).a(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar2, cVar2)).a("Animation", InputStream.class, bu.c.class, new j(a2, aVar2, bVar2)).a("Animation", ByteBuffer.class, bu.c.class, aVar2).a(bu.c.class, new bu.d()).a(bj.a.class, bj.a.class, v.a.b()).a("Bitmap", bj.a.class, Bitmap.class, new bu.h(eVar2)).a(Uri.class, Drawable.class, eVar5).a(Uri.class, Bitmap.class, new u(eVar5, eVar2)).a((e.a<?>) new a.C0058a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new bt.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.b()).a((e.a<?>) new k.a(bVar2));
        if (ParcelFileDescriptorRewinder.c()) {
            registry.a((e.a<?>) new ParcelFileDescriptorRewinder.a());
        }
        s.c cVar4 = cVar3;
        s.b bVar5 = bVar4;
        s.d dVar5 = dVar3;
        s.a aVar5 = aVar3;
        Context context3 = context;
        registry.a(Integer.TYPE, InputStream.class, cVar4).a(Integer.TYPE, ParcelFileDescriptor.class, bVar5).a(Integer.class, InputStream.class, cVar4).a(Integer.class, ParcelFileDescriptor.class, bVar5).a(Integer.class, Uri.class, dVar5).a(Integer.TYPE, AssetFileDescriptor.class, aVar5).a(Integer.class, AssetFileDescriptor.class, aVar5).a(Integer.TYPE, Uri.class, dVar5).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new b.a(context3)).a(Uri.class, InputStream.class, new c.a(context3));
        if (Build.VERSION.SDK_INT >= 29) {
            registry.a(Uri.class, InputStream.class, new d.c(context3));
            registry.a(Uri.class, ParcelFileDescriptor.class, new d.b(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls3 = cls2;
        bv.a aVar6 = aVar4;
        bv.d dVar6 = dVar4;
        registry.a(Uri.class, InputStream.class, new w.d(contentResolver2)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver2)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver2)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context3)).a(bo.g.class, InputStream.class, new a.C0056a()).a(cls3, ByteBuffer.class, new b.a()).a(cls3, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.b()).a(Drawable.class, Drawable.class, v.a.b()).a(Drawable.class, Drawable.class, new bs.f()).a(Bitmap.class, BitmapDrawable.class, new bv.b(resources)).a(Bitmap.class, cls3, aVar6).a(Drawable.class, cls3, new bv.c(eVar2, aVar6, dVar6)).a(bu.c.class, cls3, dVar6);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.g<ByteBuffer, Bitmap> c2 = VideoDecoder.c(eVar);
            registry.a(ByteBuffer.class, Bitmap.class, c2);
            registry.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, c2));
        }
        this.f10053f = new e(context, bVar, registry, new bz.g(), aVar, map, list, iVar, fVar, i2);
    }

    public static c a(Context context) {
        if (f10048a == null) {
            GeneratedAppGlideModule c2 = c(context.getApplicationContext());
            synchronized (c.class) {
                if (f10048a == null) {
                    a(context, c2);
                }
            }
        }
        return f10048a;
    }

    public static h a(View view) {
        return d(view.getContext()).a(view);
    }

    public static h a(Fragment fragment) {
        return d(fragment.getContext()).a(fragment);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f10049b) {
            f10049b = true;
            b(context, generatedAppGlideModule);
            f10049b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    private static void a(Context context, d dVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<bx.c> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new bx.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> a2 = generatedAppGlideModule.a();
            Iterator<bx.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                bx.c next = it2.next();
                if (a2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (bx.c cVar : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + cVar.getClass());
            }
        }
        dVar.a(generatedAppGlideModule != null ? generatedAppGlideModule.b() : null);
        for (bx.c a3 : emptyList) {
            a3.a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, dVar);
        }
        c a4 = dVar.a(applicationContext);
        for (bx.c next2 : emptyList) {
            try {
                next2.a(applicationContext, a4, a4.f10054g);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a4, a4.f10054g);
        }
        applicationContext.registerComponentCallbacks(a4);
        f10048a = a4;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static h b(Context context) {
        return d(context).a(context);
    }

    private static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new d(), generatedAppGlideModule);
    }

    private static GeneratedAppGlideModule c(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            a((Exception) e2);
        }
        return null;
    }

    private static p d(Context context) {
        cc.k.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).g();
    }

    public bl.e a() {
        return this.f10051d;
    }

    public void a(int i2) {
        l.a();
        synchronized (this.f10058k) {
            for (h onTrimMemory : this.f10058k) {
                onTrimMemory.onTrimMemory(i2);
            }
        }
        this.f10052e.a(i2);
        this.f10051d.a(i2);
        this.f10055h.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar) {
        synchronized (this.f10058k) {
            if (!this.f10058k.contains(hVar)) {
                this.f10058k.add(hVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(bz.j<?> jVar) {
        synchronized (this.f10058k) {
            for (h b2 : this.f10058k) {
                if (b2.b(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public bl.b b() {
        return this.f10055h;
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar) {
        synchronized (this.f10058k) {
            if (this.f10058k.contains(hVar)) {
                this.f10058k.remove(hVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public Context c() {
        return this.f10053f.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    public bw.d d() {
        return this.f10057j;
    }

    /* access modifiers changed from: package-private */
    public e e() {
        return this.f10053f;
    }

    public void f() {
        l.a();
        this.f10052e.a();
        this.f10051d.a();
        this.f10055h.a();
    }

    public p g() {
        return this.f10056i;
    }

    public Registry h() {
        return this.f10054g;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        f();
    }

    public void onTrimMemory(int i2) {
        a(i2);
    }
}
