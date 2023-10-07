package ku;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okio.k;

public class b {
    public static ContentValues a(Context context, File file, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("orientation", 0);
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    private static void a(ContentResolver contentResolver, Uri uri, InputStream inputStream) {
        int read;
        if (uri != null && inputStream != null) {
            try {
                OutputStream openOutputStream = contentResolver.openOutputStream(uri);
                byte[] bArr = new byte[1024];
                do {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                        openOutputStream.write(bArr, 0, read);
                        openOutputStream.flush();
                        continue;
                    }
                } while (read != -1);
                inputStream.close();
                openOutputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, File file) {
        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a(context, file, System.currentTimeMillis()));
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str, ContentValues contentValues, ContentResolver contentResolver, Uri uri) {
        OutputStream openOutputStream;
        Cursor query;
        try {
            openOutputStream = contentResolver.openOutputStream(uri, "rw");
            k.a(k.a(new File(str))).a(k.a(openOutputStream));
            contentValues.put("is_pending", 0);
            contentValues.putNull("date_expires");
            contentResolver.update(uri, contentValues, (String) null, (String[]) null);
            if (Build.VERSION.SDK_INT >= 26 && (query = context.getContentResolver().query(uri, (String[]) null, (Bundle) null, (CancellationSignal) null)) != null) {
                int count = query.getCount();
                Log.e("Media", "writeFile result :" + count + "--path--" + uri.getPath());
                query.close();
            }
            if (openOutputStream != null) {
                openOutputStream.close();
                return;
            }
            return;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return;
        } catch (IOException e3) {
            e3.printStackTrace();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void a(File file, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", 1);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            a(contentResolver, insert, (InputStream) new FileInputStream(file));
            contentValues.clear();
            contentValues.put("is_pending", 0);
            contentResolver.update(insert, contentValues, (String) null, (String[]) null);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, Context context) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        String name = file.getName();
        String name2 = file.getName();
        ContentValues contentValues = new ContentValues(9);
        contentValues.put("title", name);
        contentValues.put("_display_name", name2);
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis / 1000));
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("_data", str);
        contentValues.put("width", Integer.valueOf(parseInt));
        contentValues.put("height", Integer.valueOf(parseInt2));
        contentValues.put("resolution", Integer.toString(parseInt) + "x" + Integer.toString(parseInt2));
        contentValues.put("_size", Long.valueOf(new File(str).length()));
        contentValues.put("duration", Integer.valueOf(parseInt3));
        ContentResolver contentResolver = context.getContentResolver();
        a(context, str, contentValues, contentResolver, contentResolver.insert(Uri.parse("content://media/external/video/media"), contentValues));
    }

    public static ContentValues b(Context context, File file, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static void b(Context context, File file) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, b(context, file, System.currentTimeMillis()))));
    }
}
