package com.xeagle.android.login.pickImage.data;

import android.net.Uri;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;

public class VideoDataSource extends CursorDataSource {
    private static final String VIDEO_SELECTION = null;
    private static final String[] VIDEO_SELECTION_ARGS = null;
    private final String[] VIDEO_PROJECTION = {"_display_name", "_data", "_size", "width", "height", "mime_type", "date_added", "_id", "duration"};

    VideoDataSource(FragmentActivity fragmentActivity, String str) {
        super(fragmentActivity, str);
    }

    /* access modifiers changed from: protected */
    public int getBaseId() {
        return 20;
    }

    /* access modifiers changed from: protected */
    public Uri getMediaStoreUri() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    /* access modifiers changed from: protected */
    public String[] getProjection() {
        return this.VIDEO_PROJECTION;
    }

    /* access modifiers changed from: protected */
    public String getSelection() {
        return VIDEO_SELECTION;
    }

    /* access modifiers changed from: protected */
    public String[] getSelectionArgs() {
        return VIDEO_SELECTION_ARGS;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x014b A[LOOP:0: B:3:0x0042->B:31:0x014b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parserRealData(android.database.Cursor r26, java.util.ArrayList<com.xeagle.android.login.pickImage.data.GLImage> r27, java.util.ArrayList<com.xeagle.android.login.pickImage.data.ImageFolder> r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r28
            boolean r3 = r26.moveToFirst()
            if (r3 == 0) goto L_0x015f
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
            java.lang.String r10 = "_id"
            int r10 = r1.getColumnIndexOrThrow(r10)
            java.lang.String r11 = "duration"
            int r11 = r1.getColumnIndexOrThrow(r11)
        L_0x0042:
            java.lang.String r12 = r1.getString(r9)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x0134
            java.lang.String r13 = "tiff"
            boolean r13 = r12.contains(r13)
            if (r13 == 0) goto L_0x0056
            goto L_0x0134
        L_0x0056:
            java.lang.String r13 = r1.getString(r4)
            java.lang.String r14 = r0.filePath
            if (r14 == 0) goto L_0x0080
            java.lang.String r14 = r0.type
            if (r14 == 0) goto L_0x0076
            java.lang.String r14 = r0.filePath
            boolean r14 = r13.contains(r14)
            if (r14 != 0) goto L_0x006c
            goto L_0x0134
        L_0x006c:
            java.lang.String r14 = r0.type
            boolean r14 = r13.contains(r14)
            if (r14 != 0) goto L_0x0080
            goto L_0x0134
        L_0x0076:
            java.lang.String r14 = r0.filePath
            boolean r14 = r13.contains(r14)
            if (r14 != 0) goto L_0x0080
            goto L_0x0134
        L_0x0080:
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            if (r14 == 0) goto L_0x0088
            goto L_0x0134
        L_0x0088:
            long r14 = r1.getLong(r5)
            java.io.File r0 = new java.io.File
            r0.<init>(r13)
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x009b
            long r14 = r0.length()
        L_0x009b:
            r16 = r4
            java.lang.String r4 = r1.getString(r3)
            r17 = r3
            int r3 = r1.getInt(r6)
            r18 = r5
            int r5 = r1.getInt(r7)
            long r19 = r1.getLong(r8)
            r21 = r6
            r22 = r7
            long r6 = r1.getLong(r10)
            r23 = r8
            r24 = r9
            long r8 = r1.getLong(r11)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = com.xeagle.android.login.pickImage.data.GLImage.Builder.newBuilder()
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setName(r4)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setPath(r13)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setSize(r14)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setWidth(r3)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setHeight(r5)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setMimeType(r12)
            r3 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r19
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setAddTime(r3)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setId(r6)
            com.xeagle.android.login.pickImage.data.GLImage$Builder r1 = r1.setDuration(r8)
            com.xeagle.android.login.pickImage.data.GLImage r1 = r1.build()
            r3 = r27
            r3.add(r1)
            java.io.File r0 = r0.getParentFile()
            if (r0 != 0) goto L_0x00fd
            goto L_0x0144
        L_0x00fd:
            com.xeagle.android.login.pickImage.data.ImageFolder r4 = new com.xeagle.android.login.pickImage.data.ImageFolder
            r4.<init>()
            java.lang.String r5 = r0.getName()
            r4.name = r5
            java.lang.String r0 = r0.getAbsolutePath()
            r4.path = r0
            boolean r0 = r2.contains(r4)
            if (r0 != 0) goto L_0x0124
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r1)
            r4.cover = r1
            r4.images = r0
            r2.add(r4)
            goto L_0x0144
        L_0x0124:
            int r0 = r2.indexOf(r4)
            java.lang.Object r0 = r2.get(r0)
            com.xeagle.android.login.pickImage.data.ImageFolder r0 = (com.xeagle.android.login.pickImage.data.ImageFolder) r0
            java.util.ArrayList<com.xeagle.android.login.pickImage.data.GLImage> r0 = r0.images
            r0.add(r1)
            goto L_0x0144
        L_0x0134:
            r17 = r3
            r16 = r4
            r18 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r3 = r27
        L_0x0144:
            boolean r0 = r26.moveToNext()
            if (r0 != 0) goto L_0x014b
            goto L_0x015f
        L_0x014b:
            r0 = r25
            r1 = r26
            r4 = r16
            r3 = r17
            r5 = r18
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            goto L_0x0042
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.data.VideoDataSource.parserRealData(android.database.Cursor, java.util.ArrayList, java.util.ArrayList):void");
    }
}
