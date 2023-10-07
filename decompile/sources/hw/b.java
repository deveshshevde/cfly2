package hw;

import android.content.Context;
import android.media.MediaScannerConnection;
import java.io.File;

public class b {
    public static void a(Context context, File... fileArr) {
        int length = fileArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            a(context, fileArr[i2].getAbsolutePath());
        }
    }

    public static void a(Context context, String... strArr) {
        MediaScannerConnection.scanFile(context.getApplicationContext(), strArr, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
    }
}
