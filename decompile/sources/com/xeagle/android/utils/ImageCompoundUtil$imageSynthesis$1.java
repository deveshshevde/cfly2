package com.xeagle.android.utils;

import android.app.Activity;
import java.util.ArrayList;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import mm.m;
import org.opencv.tracker.ImagesStitchUtil;

@d(b = "ImageCompoundUtil.kt", c = {621}, d = "invokeSuspend", e = "com.xeagle.android.utils.ImageCompoundUtil$imageSynthesis$1")
final class ImageCompoundUtil$imageSynthesis$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f24336a;

    /* renamed from: b  reason: collision with root package name */
    Object f24337b;

    /* renamed from: c  reason: collision with root package name */
    int f24338c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l f24339d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f24340e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ArrayList f24341f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Activity f24342g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ImagesStitchUtil.a f24343h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ String f24344i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCompoundUtil$imageSynthesis$1(l lVar, String str, ArrayList arrayList, Activity activity, ImagesStitchUtil.a aVar, String str2, c cVar) {
        super(2, cVar);
        this.f24339d = lVar;
        this.f24340e = str;
        this.f24341f = arrayList;
        this.f24342g = activity;
        this.f24343h = aVar;
        this.f24344i = str2;
    }

    public final Object a(Object obj, Object obj2) {
        return ((ImageCompoundUtil$imageSynthesis$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new ImageCompoundUtil$imageSynthesis$1(this.f24339d, this.f24340e, this.f24341f, this.f24342g, this.f24343h, this.f24344i, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) {
        /*
            r31 = this;
            r0 = r31
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.a()
            int r2 = r0.f24338c
            r3 = 1
            if (r2 == 0) goto L_0x0024
            if (r2 != r3) goto L_0x001c
            java.lang.Object r2 = r0.f24337b
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f24336a
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            kotlin.i.a((java.lang.Object) r32)
            r6 = r32
            r5 = r0
            goto L_0x006b
        L_0x001c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0024:
            kotlin.i.a((java.lang.Object) r32)
            java.lang.String r2 = r0.f24340e
            java.lang.String r4 = "SAVE_C"
            boolean r2 = kotlin.jvm.internal.h.a((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x00c3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = r0.f24341f
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = r0
            r30 = r4
            r4 = r2
            r2 = r30
        L_0x0044:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            kotlinx.coroutines.aa r7 = kotlinx.coroutines.ap.c()
            kotlin.coroutines.f r7 = (kotlin.coroutines.f) r7
            com.xeagle.android.utils.ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1 r8 = new com.xeagle.android.utils.ImageCompoundUtil$imageSynthesis$1$invokeSuspend$$inlined$forEach$lambda$1
            r9 = 0
            r8.<init>(r6, r9, r5, r4)
            mm.m r8 = (mm.m) r8
            r5.f24336a = r4
            r5.f24337b = r2
            r5.f24338c = r3
            java.lang.Object r6 = kotlinx.coroutines.e.a(r7, r8, r5)
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            java.io.File r6 = (java.io.File) r6
            java.lang.String r7 = "newFile"
            kotlin.jvm.internal.h.b(r6, r7)
            java.lang.String r6 = r6.getAbsolutePath()
            r4.add(r6)
            goto L_0x0044
        L_0x007a:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r1 = r4.iterator()
        L_0x0085:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00b5
            java.lang.Object r2 = r1.next()
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            com.ctoo.mediaedit.MyPhoto r2 = new com.ctoo.mediaedit.MyPhoto
            r11 = r2
            r12 = 0
            r13 = 0
            r15 = 0
            r22 = 2000(0x7d0, double:9.88E-321)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 7659(0x1deb, float:1.0733E-41)
            r29 = 0
            java.lang.String r16 = "image/jpg"
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r24, r26, r27, r28, r29)
            r10.add(r2)
            goto L_0x0085
        L_0x00b5:
            com.xeagle.android.utils.l r7 = r5.f24339d
            android.app.Activity r8 = r5.f24342g
            java.lang.String r11 = r5.f24340e
            org.opencv.tracker.ImagesStitchUtil$a r12 = r5.f24343h
            java.lang.String r9 = "video_"
            r7.a((android.app.Activity) r8, (java.lang.String) r9, (java.util.ArrayList<com.ctoo.mediaedit.MyPhoto>) r10, (java.lang.String) r11, (org.opencv.tracker.ImagesStitchUtil.a) r12)
            goto L_0x00d2
        L_0x00c3:
            com.xeagle.android.utils.l r1 = r0.f24339d
            java.lang.String r2 = r0.f24344i
            java.util.ArrayList r3 = r0.f24341f
            java.lang.String r4 = r0.f24340e
            android.app.Activity r5 = r0.f24342g
            org.opencv.tracker.ImagesStitchUtil$a r6 = r0.f24343h
            r1.a((java.lang.String) r2, (java.util.ArrayList<java.lang.String>) r3, (java.lang.String) r4, (android.app.Activity) r5, (org.opencv.tracker.ImagesStitchUtil.a) r6)
        L_0x00d2:
            kotlin.l r1 = kotlin.l.f30254a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.ImageCompoundUtil$imageSynthesis$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
