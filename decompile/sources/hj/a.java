package hj;

import android.content.Context;
import androidx.core.content.d;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.models.album.entity.b;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f13326a;

    /* renamed from: b  reason: collision with root package name */
    public com.huantansheng.easyphotos.models.album.entity.a f13327b = new com.huantansheng.easyphotos.models.album.entity.a();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f13328c = true;

    /* renamed from: d  reason: collision with root package name */
    private String[] f13329d;

    /* renamed from: hj.a$a  reason: collision with other inner class name */
    public interface C0095a {
        void a();
    }

    private a() {
    }

    public static a a() {
        if (f13326a == null) {
            synchronized (a.class) {
                if (f13326a == null) {
                    f13326a = new a();
                }
            }
        }
        return f13326a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02ce A[EDGE_INSN: B:149:0x02ce->B:140:0x02ce ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(android.content.Context r35) {
        /*
            r34 = this;
            r1 = r34
            monitor-enter(r34)
            com.huantansheng.easyphotos.models.album.entity.a r0 = r1.f13327b     // Catch:{ all -> 0x02fa }
            r0.b()     // Catch:{ all -> 0x02fa }
            java.util.ArrayList<com.huantansheng.easyphotos.models.album.entity.Photo> r0 = hq.a.f13386j     // Catch:{ all -> 0x02fa }
            int r0 = r0.size()     // Catch:{ all -> 0x02fa }
            int r2 = hq.a.f13380d     // Catch:{ all -> 0x02fa }
            if (r0 > r2) goto L_0x02d3
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02fa }
            r2 = 16
            r3 = 1
            r4 = 0
            if (r0 < r2) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r2 = hq.a.b()     // Catch:{ all -> 0x02fa }
            r5 = 3
            r6 = 2
            r7 = 0
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = "external"
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.getContentUri(r2)     // Catch:{ all -> 0x02fa }
        L_0x002c:
            r11 = r2
            r13 = r7
            r14 = r13
            goto L_0x0054
        L_0x0030:
            boolean r2 = hq.a.f13398v     // Catch:{ all -> 0x02fa }
            if (r2 != 0) goto L_0x003b
            java.lang.String r2 = "external"
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.getContentUri(r2)     // Catch:{ all -> 0x02fa }
            goto L_0x002c
        L_0x003b:
            java.lang.String r2 = "external"
            android.net.Uri r2 = android.provider.MediaStore.Files.getContentUri(r2)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "(media_type=? OR media_type=?)"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ all -> 0x02fa }
            java.lang.String r9 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x02fa }
            r8[r4] = r9     // Catch:{ all -> 0x02fa }
            java.lang.String r9 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x02fa }
            r8[r3] = r9     // Catch:{ all -> 0x02fa }
            r11 = r2
            r13 = r7
            r14 = r8
        L_0x0054:
            android.content.ContentResolver r10 = r35.getContentResolver()     // Catch:{ all -> 0x02fa }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x02fa }
            r2.<init>()     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "_id"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "_data"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "_display_name"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "date_modified"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "mime_type"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "_size"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "bucket_display_name"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            boolean r7 = hq.a.f13385i     // Catch:{ all -> 0x02fa }
            if (r7 != 0) goto L_0x008e
            int r7 = hq.a.f13377a     // Catch:{ all -> 0x02fa }
            if (r7 == r3) goto L_0x008e
            int r7 = hq.a.f13378b     // Catch:{ all -> 0x02fa }
            if (r7 == r3) goto L_0x008e
            hq.a.f13385i = r3     // Catch:{ all -> 0x02fa }
        L_0x008e:
            if (r0 == 0) goto L_0x00a9
            boolean r7 = hq.a.f13385i     // Catch:{ all -> 0x02fa }
            if (r7 == 0) goto L_0x00a9
            java.lang.String r7 = "width"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            java.lang.String r7 = "height"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
            boolean r7 = hq.a.b()     // Catch:{ all -> 0x02fa }
            if (r7 != 0) goto L_0x00a9
            java.lang.String r7 = "orientation"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
        L_0x00a9:
            boolean r7 = hq.a.f13398v     // Catch:{ all -> 0x02fa }
            if (r7 == 0) goto L_0x00b2
            java.lang.String r7 = "duration"
            r2.add(r7)     // Catch:{ all -> 0x02fa }
        L_0x00b2:
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch:{ all -> 0x02fa }
            java.lang.Object[] r2 = r2.toArray(r7)     // Catch:{ all -> 0x02fa }
            r12 = r2
            java.lang.String[] r12 = (java.lang.String[]) r12     // Catch:{ all -> 0x02fa }
            r1.f13329d = r12     // Catch:{ all -> 0x02fa }
            java.lang.String r15 = "date_modified DESC"
            android.database.Cursor r2 = r10.query(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x02fa }
            if (r2 != 0) goto L_0x00c7
            goto L_0x02d1
        L_0x00c7:
            boolean r7 = r2.moveToFirst()     // Catch:{ all -> 0x02fa }
            if (r7 == 0) goto L_0x02d1
            java.lang.String r7 = r34.a((android.content.Context) r35)     // Catch:{ all -> 0x02fa }
            int r8 = com.huantansheng.easyphotos.R.string.selector_folder_video_easy_photos     // Catch:{ all -> 0x02fa }
            r9 = r35
            java.lang.String r8 = r9.getString(r8)     // Catch:{ all -> 0x02fa }
            java.lang.String r9 = "bucket_display_name"
            int r9 = r2.getColumnIndex(r9)     // Catch:{ all -> 0x02fa }
            java.lang.String r10 = "duration"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ all -> 0x02fa }
            if (r0 == 0) goto L_0x00fe
            boolean r12 = hq.a.f13385i     // Catch:{ all -> 0x02fa }
            if (r12 == 0) goto L_0x00fe
            java.lang.String r12 = "width"
            int r12 = r2.getColumnIndex(r12)     // Catch:{ all -> 0x02fa }
            java.lang.String r13 = "height"
            int r13 = r2.getColumnIndex(r13)     // Catch:{ all -> 0x02fa }
            java.lang.String r14 = "orientation"
            int r14 = r2.getColumnIndex(r14)     // Catch:{ all -> 0x02fa }
            goto L_0x0101
        L_0x00fe:
            r12 = 0
            r13 = 0
            r14 = -1
        L_0x0101:
            if (r10 <= 0) goto L_0x0105
            r15 = 1
            goto L_0x0106
        L_0x0105:
            r15 = 0
        L_0x0106:
            r16 = r12
        L_0x0108:
            long r11 = r2.getLong(r4)     // Catch:{ all -> 0x02fa }
            java.lang.String r4 = r2.getString(r3)     // Catch:{ all -> 0x02fa }
            java.lang.String r18 = r2.getString(r6)     // Catch:{ all -> 0x02fa }
            long r21 = r2.getLong(r5)     // Catch:{ all -> 0x02fa }
            r5 = 4
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x02fa }
            r6 = 5
            long r26 = r2.getLong(r6)     // Catch:{ all -> 0x02fa }
            r19 = 0
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x02fa }
            if (r6 != 0) goto L_0x02b1
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02fa }
            if (r6 == 0) goto L_0x0132
            goto L_0x02b1
        L_0x0132:
            long r23 = hq.a.f13379c     // Catch:{ all -> 0x02fa }
            int r6 = (r26 > r23 ? 1 : (r26 == r23 ? 0 : -1))
            if (r6 >= 0) goto L_0x013a
            goto L_0x02b1
        L_0x013a:
            java.lang.String r6 = "video"
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x02fa }
            if (r6 == 0) goto L_0x0166
            if (r15 == 0) goto L_0x0148
            long r19 = r2.getLong(r10)     // Catch:{ all -> 0x02fa }
        L_0x0148:
            long r23 = hq.a.f13400x     // Catch:{ all -> 0x02fa }
            int r17 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r17 <= 0) goto L_0x02b1
            long r23 = hq.a.f13401y     // Catch:{ all -> 0x02fa }
            int r17 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r17 < 0) goto L_0x0156
            goto L_0x02b1
        L_0x0156:
            r31 = r10
            r32 = r16
            r28 = r19
            r23 = 0
            r24 = 0
            r25 = 0
            r16 = r0
            goto L_0x01f5
        L_0x0166:
            r3 = -1
            if (r14 == r3) goto L_0x0170
            int r17 = r2.getInt(r14)     // Catch:{ all -> 0x02fa }
            r3 = r17
            goto L_0x0171
        L_0x0170:
            r3 = 0
        L_0x0171:
            boolean r17 = hq.a.f13397u     // Catch:{ all -> 0x02fa }
            if (r17 != 0) goto L_0x0189
            r31 = r10
            java.lang.String r10 = "gif"
            boolean r10 = r4.endsWith(r10)     // Catch:{ all -> 0x02fa }
            if (r10 != 0) goto L_0x02b3
            java.lang.String r10 = "gif"
            boolean r10 = r5.endsWith(r10)     // Catch:{ all -> 0x02fa }
            if (r10 == 0) goto L_0x018b
            goto L_0x02b3
        L_0x0189:
            r31 = r10
        L_0x018b:
            boolean r10 = hq.a.f13385i     // Catch:{ all -> 0x02fa }
            if (r10 == 0) goto L_0x01e7
            if (r0 == 0) goto L_0x019c
            r10 = r16
            int r16 = r2.getInt(r10)     // Catch:{ all -> 0x02fa }
            int r17 = r2.getInt(r13)     // Catch:{ all -> 0x02fa }
            goto L_0x01a2
        L_0x019c:
            r10 = r16
            r16 = 0
            r17 = 0
        L_0x01a2:
            if (r16 == 0) goto L_0x01ae
            if (r17 != 0) goto L_0x01a7
            goto L_0x01ae
        L_0x01a7:
            r32 = r10
            r10 = r16
            r16 = r0
            goto L_0x01c3
        L_0x01ae:
            r16 = r0
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x02fa }
            r0.<init>()     // Catch:{ all -> 0x02fa }
            r32 = r10
            r10 = 1
            r0.inJustDecodeBounds = r10     // Catch:{ all -> 0x02fa }
            android.graphics.BitmapFactory.decodeFile(r4, r0)     // Catch:{ all -> 0x02fa }
            int r10 = r0.outWidth     // Catch:{ all -> 0x02fa }
            int r0 = r0.outHeight     // Catch:{ all -> 0x02fa }
            r17 = r0
        L_0x01c3:
            r0 = 90
            if (r3 == r0) goto L_0x01cf
            r0 = 270(0x10e, float:3.78E-43)
            if (r3 != r0) goto L_0x01cc
            goto L_0x01cf
        L_0x01cc:
            r0 = r17
            goto L_0x01d2
        L_0x01cf:
            r0 = r10
            r10 = r17
        L_0x01d2:
            r17 = r3
            int r3 = hq.a.f13377a     // Catch:{ all -> 0x02fa }
            if (r10 < r3) goto L_0x02b7
            int r3 = hq.a.f13378b     // Catch:{ all -> 0x02fa }
            if (r0 >= r3) goto L_0x01de
            goto L_0x02b7
        L_0x01de:
            r24 = r0
            r23 = r10
            r25 = r17
            r28 = r19
            goto L_0x01f5
        L_0x01e7:
            r17 = r3
            r32 = r16
            r16 = r0
            r25 = r17
            r28 = r19
            r23 = 0
            r24 = 0
        L_0x01f5:
            if (r6 == 0) goto L_0x01fe
            java.lang.String r0 = "external"
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.getContentUri(r0)     // Catch:{ all -> 0x02fa }
            goto L_0x0204
        L_0x01fe:
            java.lang.String r0 = "external"
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.getContentUri(r0)     // Catch:{ all -> 0x02fa }
        L_0x0204:
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r0, r11)     // Catch:{ all -> 0x02fa }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x02fa }
            r3.<init>(r4)     // Catch:{ all -> 0x02fa }
            boolean r3 = r3.isFile()     // Catch:{ all -> 0x02fa }
            if (r3 != 0) goto L_0x0215
            goto L_0x02b7
        L_0x0215:
            com.huantansheng.easyphotos.models.album.entity.Photo r3 = new com.huantansheng.easyphotos.models.album.entity.Photo     // Catch:{ all -> 0x02fa }
            r17 = r3
            r19 = r0
            r20 = r4
            r30 = r5
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r30)     // Catch:{ all -> 0x02fa }
            java.util.ArrayList<com.huantansheng.easyphotos.models.album.entity.Photo> r5 = hq.a.f13386j     // Catch:{ all -> 0x02fa }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x02fa }
            if (r5 != 0) goto L_0x024d
            java.util.ArrayList<com.huantansheng.easyphotos.models.album.entity.Photo> r5 = hq.a.f13386j     // Catch:{ all -> 0x02fa }
            int r5 = r5.size()     // Catch:{ all -> 0x02fa }
            r10 = 0
        L_0x0231:
            if (r10 >= r5) goto L_0x024d
            java.util.ArrayList<com.huantansheng.easyphotos.models.album.entity.Photo> r11 = hq.a.f13386j     // Catch:{ all -> 0x02fa }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.Photo r11 = (com.huantansheng.easyphotos.models.album.entity.Photo) r11     // Catch:{ all -> 0x02fa }
            java.lang.String r11 = r11.f20303c     // Catch:{ all -> 0x02fa }
            boolean r11 = r4.equals(r11)     // Catch:{ all -> 0x02fa }
            if (r11 == 0) goto L_0x024a
            boolean r11 = hq.a.f13390n     // Catch:{ all -> 0x02fa }
            r3.f20312l = r11     // Catch:{ all -> 0x02fa }
            hp.a.a((com.huantansheng.easyphotos.models.album.entity.Photo) r3)     // Catch:{ all -> 0x02fa }
        L_0x024a:
            int r10 = r10 + 1
            goto L_0x0231
        L_0x024d:
            com.huantansheng.easyphotos.models.album.entity.a r5 = r1.f13327b     // Catch:{ all -> 0x02fa }
            boolean r5 = r5.a()     // Catch:{ all -> 0x02fa }
            if (r5 == 0) goto L_0x025c
            com.huantansheng.easyphotos.models.album.entity.a r5 = r1.f13327b     // Catch:{ all -> 0x02fa }
            java.lang.String r10 = ""
            r5.a(r7, r10, r4, r0)     // Catch:{ all -> 0x02fa }
        L_0x025c:
            com.huantansheng.easyphotos.models.album.entity.a r5 = r1.f13327b     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.b r5 = r5.a((java.lang.String) r7)     // Catch:{ all -> 0x02fa }
            r5.a(r3)     // Catch:{ all -> 0x02fa }
            boolean r5 = hq.a.f13398v     // Catch:{ all -> 0x02fa }
            if (r5 == 0) goto L_0x0281
            if (r6 == 0) goto L_0x0281
            boolean r5 = r8.equals(r7)     // Catch:{ all -> 0x02fa }
            if (r5 != 0) goto L_0x0281
            com.huantansheng.easyphotos.models.album.entity.a r5 = r1.f13327b     // Catch:{ all -> 0x02fa }
            java.lang.String r6 = ""
            r5.a(r8, r6, r4, r0)     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.a r5 = r1.f13327b     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.b r5 = r5.a((java.lang.String) r8)     // Catch:{ all -> 0x02fa }
            r5.a(r3)     // Catch:{ all -> 0x02fa }
        L_0x0281:
            if (r9 <= 0) goto L_0x0289
            java.lang.String r5 = r2.getString(r9)     // Catch:{ all -> 0x02fa }
            r6 = r5
            goto L_0x02a2
        L_0x0289:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x02fa }
            r5.<init>(r4)     // Catch:{ all -> 0x02fa }
            java.io.File r5 = r5.getParentFile()     // Catch:{ all -> 0x02fa }
            if (r5 != 0) goto L_0x0295
            goto L_0x02b7
        L_0x0295:
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x02fa }
            java.lang.String r6 = hu.a.a(r5)     // Catch:{ all -> 0x02fa }
            r33 = r6
            r6 = r5
            r5 = r33
        L_0x02a2:
            com.huantansheng.easyphotos.models.album.entity.a r10 = r1.f13327b     // Catch:{ all -> 0x02fa }
            r10.a(r5, r6, r4, r0)     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.a r0 = r1.f13327b     // Catch:{ all -> 0x02fa }
            com.huantansheng.easyphotos.models.album.entity.b r0 = r0.a((java.lang.String) r5)     // Catch:{ all -> 0x02fa }
            r0.a(r3)     // Catch:{ all -> 0x02fa }
            goto L_0x02b7
        L_0x02b1:
            r31 = r10
        L_0x02b3:
            r32 = r16
            r16 = r0
        L_0x02b7:
            boolean r0 = r2.moveToNext()     // Catch:{ all -> 0x02fa }
            if (r0 == 0) goto L_0x02ce
            boolean r0 = r1.f13328c     // Catch:{ all -> 0x02fa }
            if (r0 != 0) goto L_0x02c2
            goto L_0x02ce
        L_0x02c2:
            r0 = r16
            r10 = r31
            r16 = r32
            r3 = 1
            r4 = 0
            r5 = 3
            r6 = 2
            goto L_0x0108
        L_0x02ce:
            r2.close()     // Catch:{ all -> 0x02fa }
        L_0x02d1:
            monitor-exit(r34)
            return
        L_0x02d3:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x02fa }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fa }
            r2.<init>()     // Catch:{ all -> 0x02fa }
            java.lang.String r3 = "AlbumBuilder: 默认勾选的图片张数不能大于设置的选择数！|默认勾选图片张数："
            r2.append(r3)     // Catch:{ all -> 0x02fa }
            java.util.ArrayList<com.huantansheng.easyphotos.models.album.entity.Photo> r3 = hq.a.f13386j     // Catch:{ all -> 0x02fa }
            int r3 = r3.size()     // Catch:{ all -> 0x02fa }
            r2.append(r3)     // Catch:{ all -> 0x02fa }
            java.lang.String r3 = "|设置的选择数："
            r2.append(r3)     // Catch:{ all -> 0x02fa }
            int r3 = hq.a.f13380d     // Catch:{ all -> 0x02fa }
            r2.append(r3)     // Catch:{ all -> 0x02fa }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02fa }
            r0.<init>(r2)     // Catch:{ all -> 0x02fa }
            throw r0     // Catch:{ all -> 0x02fa }
        L_0x02fa:
            r0 = move-exception
            monitor-exit(r34)
            goto L_0x02fe
        L_0x02fd:
            throw r0
        L_0x02fe:
            goto L_0x02fd
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.a.b(android.content.Context):void");
    }

    public String a(Context context) {
        int i2;
        String string = context.getString(R.string.selector_folder_all_video_photo_easy_photos);
        if (hq.a.b()) {
            i2 = R.string.selector_folder_video_easy_photos;
        } else if (hq.a.f13398v) {
            return string;
        } else {
            i2 = R.string.selector_folder_all_easy_photos;
        }
        return context.getString(i2);
    }

    public ArrayList<Photo> a(int i2) {
        return this.f13327b.a(i2).f20319e;
    }

    public void a(final Context context, final C0095a aVar) {
        if (d.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.f13328c = true;
            new Thread(new Runnable() {
                public void run() {
                    a.this.b(context);
                    C0095a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }).start();
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        this.f13328c = false;
    }

    public ArrayList<b> c() {
        return this.f13327b.f20313a;
    }

    public String[] d() {
        String[] strArr = this.f13329d;
        if (strArr == null || strArr.length == 0) {
            if (hq.a.f13385i) {
                this.f13329d = new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "_size", "bucket_display_name", "width", "height", "orientation"};
            } else {
                this.f13329d = new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "_size", "bucket_display_name"};
            }
        }
        return this.f13329d;
    }
}
