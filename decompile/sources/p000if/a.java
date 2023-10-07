package p000if;

import android.content.Context;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.util.EncodingUtils;

/* renamed from: if.a  reason: invalid package */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f13545a;

    public a(Context context) {
        this.f13545a = context;
    }

    private String a(String str) {
        String str2;
        try {
            InputStream open = this.f13545a.getResources().getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            return open.read(bArr) < 0 ? "" : EncodingUtils.getString(bArr, "utf-8");
        } catch (IOException unused) {
            str2 = "IOException getFromAsset fail!";
            Log.e("XMLUploader", str2);
            return "";
        } catch (Exception unused2) {
            str2 = "Exception getFromAsset fail!";
            Log.e("XMLUploader", str2);
            return "";
        }
    }

    private void a(String str, String str2) {
        String str3;
        try {
            FileOutputStream openFileOutput = this.f13545a.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("utf-8"));
            openFileOutput.close();
        } catch (UnsupportedEncodingException unused) {
            ie.a.d("XMLUploader", "writeFileData hanppened UnsupportedEncodingException");
        } catch (FileNotFoundException e2) {
            e = e2;
            str3 = "writeFileData fail FileNotFoundException";
            Log.e("XMLUploader", str3, e);
        } catch (IOException e3) {
            e = e3;
            str3 = "writeFileData fail IOException";
            Log.e("XMLUploader", str3, e);
        } catch (Exception unused2) {
            Log.e("XMLUploader", "writeFileData fail");
        }
    }

    public void a() {
        a("mirror_sink_configs.xml", a("mirror_sink_configs.xml"));
        a("mirror_source_configs.xml", a("mirror_source_configs.xml"));
    }
}
