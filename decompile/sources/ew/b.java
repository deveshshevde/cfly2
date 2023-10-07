package ew;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private File f26990a;

    public b(File file) {
        this.f26990a = file;
    }

    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.a(ParcelFileDescriptor.open(this.f26990a, AMapEngineUtils.MAX_P20_WIDTH), str);
    }
}
