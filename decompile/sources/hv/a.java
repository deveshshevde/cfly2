package hv;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a {
    public static void a(Activity activity, String str, String str2, Bitmap bitmap, boolean z2, b bVar) {
        final Activity activity2 = activity;
        final String str3 = str;
        final String str4 = str2;
        final Bitmap bitmap2 = bitmap;
        final boolean z3 = z2;
        final b bVar2 = bVar;
        new Thread(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT > 28) {
                    a.c(activity2, str3, str4, bitmap2, z3, bVar2);
                    return;
                }
                File file = new File(str3);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    activity2.runOnUiThread(new Runnable() {
                        public void run() {
                            bVar2.a();
                        }
                    });
                    return;
                }
                try {
                    final File createTempFile = File.createTempFile(str4, ".png", file);
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    bitmap2.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (z3) {
                        com.huantansheng.easyphotos.a.a(activity2, createTempFile);
                    }
                    activity2.runOnUiThread(new Runnable() {
                        public void run() {
                            bVar2.a(createTempFile);
                        }
                    });
                } catch (IOException e2) {
                    activity2.runOnUiThread(new Runnable() {
                        public void run() {
                            bVar2.a(e2);
                        }
                    });
                }
            }
        }).start();
    }

    public static void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        System.gc();
    }

    /* access modifiers changed from: private */
    public static void c(final Activity activity, String str, String str2, Bitmap bitmap, boolean z2, final b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2 + System.currentTimeMillis() + ".png");
        contentValues.put("mime_type", "image/png");
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == str.length()) {
            lastIndexOf = str.substring(0, lastIndexOf - 1).lastIndexOf("/");
        }
        contentValues.put("relative_path", "DCIM/" + str.substring(lastIndexOf + 1));
        ContentResolver contentResolver = activity.getContentResolver();
        final Uri insert = contentResolver.insert(Environment.getExternalStorageState().equals("mounted") ? MediaStore.Images.Media.getContentUri("external") : MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    bVar.a();
                }
            });
            return;
        }
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
            if (openOutputStream != null) {
                openOutputStream.flush();
                openOutputStream.close();
            }
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    String a2 = ib.a.a((Context) activity, insert);
                    if (a2 == null) {
                        bVar.a();
                    } else {
                        bVar.a(new File(a2));
                    }
                }
            });
        } catch (IOException e2) {
            e2.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    bVar.a(e2);
                }
            });
        }
    }
}
