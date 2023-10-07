package ew;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

public interface a {
    PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException;
}
