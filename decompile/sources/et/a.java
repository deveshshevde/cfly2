package et;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26966a = "a";

    /* renamed from: b  reason: collision with root package name */
    private PDFView f26967b;

    public a(PDFView pDFView) {
        this.f26967b = pDFView;
    }

    private void a(int i2) {
        this.f26967b.a(i2);
    }

    private void a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.f26967b.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        String str2 = f26966a;
        Log.w(str2, "No activity found for URI: " + str);
    }

    public void a(ev.a aVar) {
        String b2 = aVar.a().b();
        Integer a2 = aVar.a().a();
        if (b2 != null && !b2.isEmpty()) {
            a(b2);
        } else if (a2 != null) {
            a(a2.intValue());
        }
    }
}
