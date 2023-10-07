package com.bumptech.glide.load.engine;

import cc.k;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import s.e;

public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f10383a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f10384b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends g<Data, ResourceType, Transcode>> f10385c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10386d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, e.a<List<Throwable>> aVar) {
        this.f10383a = cls;
        this.f10384b = aVar;
        this.f10385c = (List) k.a(list);
        this.f10386d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, f fVar, int i2, int i3, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f10385c.size();
        s<Transcode> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                sVar = ((g) this.f10385c.get(i4)).a(eVar, i2, i3, fVar, aVar);
            } catch (GlideException e2) {
                list2.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new GlideException(this.f10386d, (List<Throwable>) new ArrayList(list2));
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, f fVar, int i2, int i3, g.a<ResourceType> aVar) throws GlideException {
        List list = (List) k.a(this.f10384b.a());
        try {
            return a(eVar, fVar, i2, i3, aVar, list);
        } finally {
            this.f10384b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f10385c.toArray()) + '}';
    }
}
