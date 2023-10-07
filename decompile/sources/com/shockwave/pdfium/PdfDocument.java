package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PdfDocument {

    /* renamed from: a  reason: collision with root package name */
    long f21581a;

    /* renamed from: b  reason: collision with root package name */
    ParcelFileDescriptor f21582b;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, Long> f21583c = new a();

    public static class Bookmark {

        /* renamed from: a  reason: collision with root package name */
        String f21584a;

        /* renamed from: b  reason: collision with root package name */
        long f21585b;

        /* renamed from: c  reason: collision with root package name */
        long f21586c;

        /* renamed from: d  reason: collision with root package name */
        private List<Bookmark> f21587d = new ArrayList();

        public List<Bookmark> a() {
            return this.f21587d;
        }
    }

    public static class Link {

        /* renamed from: a  reason: collision with root package name */
        private RectF f21588a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f21589b;

        /* renamed from: c  reason: collision with root package name */
        private String f21590c;

        public Link(RectF rectF, Integer num, String str) {
            this.f21588a = rectF;
            this.f21589b = num;
            this.f21590c = str;
        }

        public Integer a() {
            return this.f21589b;
        }

        public String b() {
            return this.f21590c;
        }

        public RectF c() {
            return this.f21588a;
        }
    }

    public static class Meta {

        /* renamed from: a  reason: collision with root package name */
        String f21591a;

        /* renamed from: b  reason: collision with root package name */
        String f21592b;

        /* renamed from: c  reason: collision with root package name */
        String f21593c;

        /* renamed from: d  reason: collision with root package name */
        String f21594d;

        /* renamed from: e  reason: collision with root package name */
        String f21595e;

        /* renamed from: f  reason: collision with root package name */
        String f21596f;

        /* renamed from: g  reason: collision with root package name */
        String f21597g;

        /* renamed from: h  reason: collision with root package name */
        String f21598h;
    }

    PdfDocument() {
    }
}
