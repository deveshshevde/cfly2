package com.bumptech.glide.load.engine;

import android.util.Log;
import bv.e;
import cc.k;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import s.e;

public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f10296a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> f10297b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f10298c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a<List<Throwable>> f10299d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10300e;

    interface a<ResourceType> {
        s<ResourceType> a(s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> list, bv.e<ResourceType, Transcode> eVar, e.a<List<Throwable>> aVar) {
        this.f10296a = cls;
        this.f10297b = list;
        this.f10298c = eVar;
        this.f10299d = aVar;
        this.f10300e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, f fVar) throws GlideException {
        List list = (List) k.a(this.f10299d.a());
        try {
            return a(eVar, i2, i3, fVar, (List<Throwable>) list);
        } finally {
            this.f10299d.a(list);
        }
    }

    private s<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, f fVar, List<Throwable> list) throws GlideException {
        int size = this.f10297b.size();
        s<ResourceType> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.g gVar = (com.bumptech.glide.load.g) this.f10297b.get(i4);
            try {
                if (gVar.a(eVar.a(), fVar)) {
                    sVar = gVar.a(eVar.a(), i2, i3, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + gVar, e2);
                }
                list.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new GlideException(this.f10300e, (List<Throwable>) new ArrayList(list));
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i2, int i3, f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f10298c.a(aVar.a(a(eVar, i2, i3, fVar)), fVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f10296a + ", decoders=" + this.f10297b + ", transcoder=" + this.f10298c + '}';
    }
}
