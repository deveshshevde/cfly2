package ib;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.Objects;

public class a {
    public static Uri a(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        Objects.requireNonNull(hq.a.f13391o, "Setting.fileProviderAuthority must not be null.");
        return FileProvider.getUriForFile(context, hq.a.f13391o, file);
    }

    public static String a(Context context, Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return a(uri) ? uri.getLastPathSegment() : a(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (b(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                if (Build.VERSION.SDK_INT < 29) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
            }
        } else if (c(uri)) {
            return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (d(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.getContentUri("external");
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.getContentUri("external");
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.getContentUri("external");
            }
            return a(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            if (r8 == 0) goto L_0x002b
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r9 == 0) goto L_0x002b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r8 == 0) goto L_0x0051
        L_0x002d:
            r8.close()
            goto L_0x0051
        L_0x0031:
            r9 = move-exception
            goto L_0x0054
        L_0x0033:
            r9 = move-exception
            r8 = r7
        L_0x0035:
            java.lang.String r10 = "UriUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0052 }
            r2 = 0
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0052 }
            r1[r2] = r9     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = java.lang.String.format(r11, r0, r1)     // Catch:{ all -> 0x0052 }
            android.util.Log.i(r10, r9)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0051
            goto L_0x002d
        L_0x0051:
            return r7
        L_0x0052:
            r9 = move-exception
            r7 = r8
        L_0x0054:
            if (r7 == 0) goto L_0x0059
            r7.close()
        L_0x0059:
            goto L_0x005b
        L_0x005a:
            throw r9
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.a.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean a(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static boolean b(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean c(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean d(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
