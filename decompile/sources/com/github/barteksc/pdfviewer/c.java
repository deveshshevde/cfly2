package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import ew.a;

class c extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14591a = false;

    /* renamed from: b  reason: collision with root package name */
    private PDFView f14592b;

    /* renamed from: c  reason: collision with root package name */
    private PdfiumCore f14593c;

    /* renamed from: d  reason: collision with root package name */
    private String f14594d;

    /* renamed from: e  reason: collision with root package name */
    private a f14595e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f14596f;

    /* renamed from: g  reason: collision with root package name */
    private f f14597g;

    c(a aVar, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f14595e = aVar;
        this.f14596f = iArr;
        this.f14592b = pDFView;
        this.f14594d = str;
        this.f14593c = pdfiumCore;
    }

    private Size a() {
        return new Size(this.f14592b.getWidth(), this.f14592b.getHeight());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Throwable doInBackground(Void... voidArr) {
        try {
            this.f14597g = new f(this.f14593c, this.f14595e.a(this.f14592b.getContext(), this.f14593c, this.f14594d), this.f14592b.getPageFitPolicy(), a(), this.f14596f, this.f14592b.m(), this.f14592b.getSpacingPx(), this.f14592b.p());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Throwable th) {
        if (th != null) {
            this.f14592b.a(th);
        } else if (!this.f14591a) {
            this.f14592b.a(this.f14597g);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.f14591a = true;
    }
}
