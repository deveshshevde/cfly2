package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Surface;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PdfiumCore {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21599a = "com.shockwave.pdfium.PdfiumCore";

    /* renamed from: b  reason: collision with root package name */
    private static final Class f21600b = FileDescriptor.class;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f21601c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Field f21602d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f21603e;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e2) {
            String str = f21599a;
            Log.e(str, "Native libraries failed to load - " + e2);
        }
    }

    public PdfiumCore(Context context) {
        this.f21603e = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(f21599a, "Starting PdfiumAndroid 1.9.0");
    }

    public static int a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f21602d == null) {
                Field declaredField = f21600b.getDeclaredField("descriptor");
                f21602d = declaredField;
                declaredField.setAccessible(true);
            }
            return f21602d.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return -1;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    private void a(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j2) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.f21586c = j2;
        bookmark.f21584a = nativeGetBookmarkTitle(j2);
        bookmark.f21585b = nativeGetBookmarkDestIndex(pdfDocument.f21581a, j2);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f21581a, Long.valueOf(j2));
        if (nativeGetFirstChildBookmark != null) {
            a(bookmark.a(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.f21581a, j2);
        if (nativeGetSiblingBookmark != null) {
            a(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    private native void nativeCloseDocument(long j2);

    private native void nativeClosePage(long j2);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j2, long j3);

    private native String nativeGetBookmarkTitle(long j2);

    private native Integer nativeGetDestPageIndex(long j2, long j3);

    private native String nativeGetDocumentMetaText(long j2, String str);

    private native Long nativeGetFirstChildBookmark(long j2, Long l2);

    private native RectF nativeGetLinkRect(long j2);

    private native String nativeGetLinkURI(long j2, long j3);

    private native int nativeGetPageCount(long j2);

    private native int nativeGetPageHeightPixel(long j2, int i2);

    private native int nativeGetPageHeightPoint(long j2);

    private native long[] nativeGetPageLinks(long j2);

    private native Size nativeGetPageSizeByIndex(long j2, int i2, int i3);

    private native int nativeGetPageWidthPixel(long j2, int i2);

    private native int nativeGetPageWidthPoint(long j2);

    private native Long nativeGetSiblingBookmark(long j2, long j3);

    private native long nativeLoadPage(long j2, int i2);

    private native long[] nativeLoadPages(long j2, int i2, int i3);

    private native long nativeOpenDocument(int i2, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j2, int i2, int i3, int i4, int i5, int i6, double d2, double d3);

    private native void nativeRenderPage(long j2, Surface surface, int i2, int i3, int i4, int i5, int i6, boolean z2);

    private native void nativeRenderPageBitmap(long j2, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6, boolean z2);

    public int a(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (f21601c) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.f21581a);
        }
        return nativeGetPageCount;
    }

    public long a(PdfDocument pdfDocument, int i2) {
        long nativeLoadPage;
        synchronized (f21601c) {
            nativeLoadPage = nativeLoadPage(pdfDocument.f21581a, i2);
            pdfDocument.f21583c.put(Integer.valueOf(i2), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public Point a(PdfDocument pdfDocument, int i2, int i3, int i4, int i5, int i6, int i7, double d2, double d3) {
        return nativePageCoordsToDevice(pdfDocument.f21583c.get(Integer.valueOf(i2)).longValue(), i3, i4, i5, i6, i7, d2, d3);
    }

    public RectF a(PdfDocument pdfDocument, int i2, int i3, int i4, int i5, int i6, int i7, RectF rectF) {
        RectF rectF2 = rectF;
        Point a2 = a(pdfDocument, i2, i3, i4, i5, i6, i7, (double) rectF2.left, (double) rectF2.top);
        Point a3 = a(pdfDocument, i2, i3, i4, i5, i6, i7, (double) rectF2.right, (double) rectF2.bottom);
        return new RectF((float) a2.x, (float) a2.y, (float) a3.x, (float) a3.y);
    }

    public PdfDocument a(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.f21582b = parcelFileDescriptor;
        synchronized (f21601c) {
            pdfDocument.f21581a = nativeOpenDocument(a(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    public void a(PdfDocument pdfDocument, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        synchronized (f21601c) {
            try {
                try {
                    nativeRenderPageBitmap(pdfDocument.f21583c.get(Integer.valueOf(i2)).longValue(), bitmap, this.f21603e, i3, i4, i5, i6, z2);
                } catch (NullPointerException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                    Log.e(f21599a, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (NullPointerException e4) {
                e = e4;
                Log.e(f21599a, "mContext may be null");
                e.printStackTrace();
            } catch (Exception e5) {
                e = e5;
                Log.e(f21599a, "Exception throw from native");
                e.printStackTrace();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public Size b(PdfDocument pdfDocument, int i2) {
        Size nativeGetPageSizeByIndex;
        synchronized (f21601c) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.f21581a, i2, this.f21603e);
        }
        return nativeGetPageSizeByIndex;
    }

    public void b(PdfDocument pdfDocument) {
        synchronized (f21601c) {
            for (Integer num : pdfDocument.f21583c.keySet()) {
                nativeClosePage(pdfDocument.f21583c.get(num).longValue());
            }
            pdfDocument.f21583c.clear();
            nativeCloseDocument(pdfDocument.f21581a);
            if (pdfDocument.f21582b != null) {
                try {
                    pdfDocument.f21582b.close();
                } catch (IOException unused) {
                }
                pdfDocument.f21582b = null;
            }
        }
    }

    public PdfDocument.Meta c(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (f21601c) {
            meta = new PdfDocument.Meta();
            meta.f21591a = nativeGetDocumentMetaText(pdfDocument.f21581a, "Title");
            meta.f21592b = nativeGetDocumentMetaText(pdfDocument.f21581a, "Author");
            meta.f21593c = nativeGetDocumentMetaText(pdfDocument.f21581a, "Subject");
            meta.f21594d = nativeGetDocumentMetaText(pdfDocument.f21581a, "Keywords");
            meta.f21595e = nativeGetDocumentMetaText(pdfDocument.f21581a, Creator.TAG);
            meta.f21596f = nativeGetDocumentMetaText(pdfDocument.f21581a, "Producer");
            meta.f21597g = nativeGetDocumentMetaText(pdfDocument.f21581a, "CreationDate");
            meta.f21598h = nativeGetDocumentMetaText(pdfDocument.f21581a, "ModDate");
        }
        return meta;
    }

    public List<PdfDocument.Link> c(PdfDocument pdfDocument, int i2) {
        synchronized (f21601c) {
            ArrayList arrayList = new ArrayList();
            Long l2 = pdfDocument.f21583c.get(Integer.valueOf(i2));
            if (l2 == null) {
                return arrayList;
            }
            for (long j2 : nativeGetPageLinks(l2.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.f21581a, j2);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.f21581a, j2);
                RectF nativeGetLinkRect = nativeGetLinkRect(j2);
                if (!(nativeGetLinkRect == null || (nativeGetDestPageIndex == null && nativeGetLinkURI == null))) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    public List<PdfDocument.Bookmark> d(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (f21601c) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f21581a, (Long) null);
            if (nativeGetFirstChildBookmark != null) {
                a(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }
}
