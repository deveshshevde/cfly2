package com.xeagle.android.utils;

import android.graphics.Bitmap;
import com.nanchen.compresshelper.b;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import mm.m;

@d(b = "ImageCompoundUtil.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.utils.ImageCompoundUtil$imageSynthesis$1$1$newFile$1")
final class ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1 extends SuspendLambda implements m<af, c<? super File>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f24332a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f24333b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ImageCompoundUtil$imageSynthesis$1 f24334c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ArrayList f24335d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1(String str, c cVar, ImageCompoundUtil$imageSynthesis$1 imageCompoundUtil$imageSynthesis$1, ArrayList arrayList) {
        super(2, cVar);
        this.f24333b = str;
        this.f24334c = imageCompoundUtil$imageSynthesis$1;
        this.f24335d = arrayList;
    }

    public final Object a(Object obj, Object obj2) {
        return ((ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1(this.f24333b, cVar, this.f24334c, this.f24335d);
    }

    public final Object invokeSuspend(Object obj) {
        a.a();
        if (this.f24332a == 0) {
            i.a(obj);
            return new b.a(this.f24334c.f24342g).a(1920.0f).b(1080.0f).a(80).a(Bitmap.CompressFormat.JPEG).a(kx.d.u(this.f24334c.f24342g)).a().a(new File(this.f24333b));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
