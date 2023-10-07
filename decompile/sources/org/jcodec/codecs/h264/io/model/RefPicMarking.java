package org.jcodec.codecs.h264.io.model;

public class RefPicMarking {

    /* renamed from: a  reason: collision with root package name */
    private a[] f32979a;

    public enum InstrType {
        REMOVE_SHORT,
        REMOVE_LONG,
        CONVERT_INTO_LONG,
        TRUNK_LONG,
        CLEAR,
        MARK_LONG
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private InstrType f32987a;

        /* renamed from: b  reason: collision with root package name */
        private int f32988b;

        /* renamed from: c  reason: collision with root package name */
        private int f32989c;

        public InstrType a() {
            return this.f32987a;
        }

        public int b() {
            return this.f32988b;
        }

        public int c() {
            return this.f32989c;
        }
    }

    public a[] a() {
        return this.f32979a;
    }
}
