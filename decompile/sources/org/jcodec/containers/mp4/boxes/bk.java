package org.jcodec.containers.mp4.boxes;

import java.util.HashMap;
import java.util.Map;

public class bk extends al {

    /* renamed from: a  reason: collision with root package name */
    private static final a f33450a = new a();

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Class<? extends c>> f33451a;

        public a() {
            HashMap hashMap = new HashMap();
            this.f33451a = hashMap;
            hashMap.put(t.a(), t.class);
            this.f33451a.put(EndianBox.a(), EndianBox.class);
        }
    }

    public static String a() {
        return "wave";
    }
}
