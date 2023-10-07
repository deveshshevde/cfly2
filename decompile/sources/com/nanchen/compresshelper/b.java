package com.nanchen.compresshelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f21489a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f21490b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f21491c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bitmap.CompressFormat f21492d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap.Config f21493e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f21494f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f21495g;

    /* renamed from: h  reason: collision with root package name */
    private String f21496h;

    /* renamed from: i  reason: collision with root package name */
    private String f21497i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private b f21498a;

        public a(Context context) {
            this.f21498a = new b(context);
        }

        public a a(float f2) {
            float unused = this.f21498a.f21490b = f2;
            return this;
        }

        public a a(int i2) {
            int unused = this.f21498a.f21494f = i2;
            return this;
        }

        public a a(Bitmap.CompressFormat compressFormat) {
            Bitmap.CompressFormat unused = this.f21498a.f21492d = compressFormat;
            return this;
        }

        public a a(String str) {
            String unused = this.f21498a.f21495g = str;
            return this;
        }

        public b a() {
            return this.f21498a;
        }

        public a b(float f2) {
            float unused = this.f21498a.f21491c = f2;
            return this;
        }
    }

    private b(Context context) {
        this.f21490b = 720.0f;
        this.f21491c = 960.0f;
        this.f21492d = Bitmap.CompressFormat.JPEG;
        this.f21493e = Bitmap.Config.ARGB_8888;
        this.f21494f = 80;
        this.f21489a = context;
        this.f21495g = context.getCacheDir().getPath() + File.pathSeparator + "CompressHelper";
    }

    public File a(File file) {
        return a.a(this.f21489a, Uri.fromFile(file), this.f21490b, this.f21491c, this.f21492d, this.f21493e, this.f21494f, this.f21495g, this.f21496h, this.f21497i);
    }
}
