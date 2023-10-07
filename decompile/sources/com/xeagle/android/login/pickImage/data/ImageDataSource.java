package com.xeagle.android.login.pickImage.data;

import android.net.Uri;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;

public class ImageDataSource extends CursorDataSource {
    private static final String IMAGE_SELECTION = "mime_type!=? and mime_type!=?";
    private static final String[] IMAGE_SELECTION_ARGS = {"image/gif", "image/webp"};
    private final String[] IMAGE_PROJECTION = {"_display_name", "_data", "_size", "width", "height", "mime_type", "date_added", "orientation"};

    ImageDataSource(FragmentActivity fragmentActivity, String str) {
        super(fragmentActivity, str);
    }

    /* access modifiers changed from: protected */
    public int getBaseId() {
        return 10;
    }

    /* access modifiers changed from: protected */
    public Uri getMediaStoreUri() {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    /* access modifiers changed from: protected */
    public String[] getProjection() {
        return this.IMAGE_PROJECTION;
    }

    /* access modifiers changed from: protected */
    public String getSelection() {
        return IMAGE_SELECTION;
    }

    /* access modifiers changed from: protected */
    public String[] getSelectionArgs() {
        return IMAGE_SELECTION_ARGS;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0112 A[LOOP:0: B:3:0x0036->B:31:0x0112, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parserRealData(android.database.Cursor r20, java.util.ArrayList<com.xeagle.android.login.pickImage.data.GLImage> r21, java.util.ArrayList<com.xeagle.android.login.pickImage.data.ImageFolder> r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = r20.moveToFirst()
            if (r3 == 0) goto L_0x011a
            java.lang.String r3 = "_display_name"
            int r3 = r1.getColumnIndexOrThrow(r3)
            java.lang.String r4 = "_data"
            int r4 = r1.getColumnIndexOrThrow(r4)
            java.lang.String r5 = "_size"
            int r5 = r1.getColumnIndexOrThrow(r5)
            java.lang.String r6 = "width"
            int r6 = r1.getColumnIndexOrThrow(r6)
            java.lang.String r7 = "height"
            int r7 = r1.getColumnIndexOrThrow(r7)
            java.lang.String r8 = "date_added"
            int r8 = r1.getColumnIndexOrThrow(r8)
            java.lang.String r9 = "mime_type"
            int r9 = r1.getColumnIndexOrThrow(r9)
        L_0x0036:
            java.lang.String r10 = r1.getString(r4)
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 == 0) goto L_0x0046
        L_0x0040:
            r1 = r21
            r16 = r3
            goto L_0x010b
        L_0x0046:
            java.lang.String r11 = r0.filePath
            if (r11 == 0) goto L_0x0069
            java.lang.String r11 = r0.type
            if (r11 == 0) goto L_0x0060
            java.lang.String r11 = r0.filePath
            boolean r11 = r10.contains(r11)
            if (r11 != 0) goto L_0x0057
            goto L_0x0040
        L_0x0057:
            java.lang.String r11 = r0.type
            boolean r11 = r10.contains(r11)
            if (r11 != 0) goto L_0x0069
            goto L_0x0040
        L_0x0060:
            java.lang.String r11 = r0.filePath
            boolean r11 = r10.contains(r11)
            if (r11 != 0) goto L_0x0069
            goto L_0x0040
        L_0x0069:
            java.lang.String r11 = r1.getString(r9)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x0040
            java.lang.String r12 = "tiff"
            boolean r12 = r11.contains(r12)
            if (r12 == 0) goto L_0x007c
            goto L_0x0040
        L_0x007c:
            java.lang.String r12 = r1.getString(r3)
            long r13 = r1.getLong(r5)
            java.io.File r15 = new java.io.File
            r15.<init>(r10)
            r16 = 0
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x0093
            long r13 = r15.length()
        L_0x0093:
            int r0 = r1.getInt(r6)
            r16 = r3
            int r3 = r1.getInt(r7)
            long r17 = r1.getLong(r8)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = com.xeagle.android.login.pickImage.data.GLImage.Builder.newBuilder()
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setName(r12)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setPath(r10)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setSize(r13)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r0 = r1.setWidth(r0)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r0 = r0.setHeight(r3)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r0 = r0.setMimeType(r11)
            r10 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r17
            com.xeagle.android.login.pickImage.data.GLImage$Builder r0 = r0.setAddTime(r10)
            com.xeagle.android.login.pickImage.data.GLImage r0 = r0.build()
            r1 = r21
            r1.add(r0)
            java.io.File r3 = r15.getParentFile()
            if (r3 != 0) goto L_0x00d5
            goto L_0x010b
        L_0x00d5:
            com.xeagle.android.login.pickImage.data.ImageFolder r10 = new com.xeagle.android.login.pickImage.data.ImageFolder
            r10.<init>()
            java.lang.String r11 = r3.getName()
            r10.name = r11
            java.lang.String r3 = r3.getAbsolutePath()
            r10.path = r3
            boolean r3 = r2.contains(r10)
            if (r3 != 0) goto L_0x00fc
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r3.add(r0)
            r10.cover = r0
            r10.images = r3
            r2.add(r10)
            goto L_0x010b
        L_0x00fc:
            int r3 = r2.indexOf(r10)
            java.lang.Object r3 = r2.get(r3)
            com.xeagle.android.login.pickImage.data.ImageFolder r3 = (com.xeagle.android.login.pickImage.data.ImageFolder) r3
            java.util.ArrayList<com.xeagle.android.login.pickImage.data.GLImage> r3 = r3.images
            r3.add(r0)
        L_0x010b:
            boolean r0 = r20.moveToNext()
            if (r0 != 0) goto L_0x0112
            goto L_0x011a
        L_0x0112:
            r0 = r19
            r1 = r20
            r3 = r16
            goto L_0x0036
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.data.ImageDataSource.parserRealData(android.database.Cursor, java.util.ArrayList, java.util.ArrayList):void");
    }
}
