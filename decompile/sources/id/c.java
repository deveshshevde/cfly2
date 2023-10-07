package id;

import java.io.File;

public class c implements com.huawei.android.multiscreen.dlna.sdk.dms.c {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r13.regionMatches(true, r0 + 1, "AlbumArtSmall", 0, 13) == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r13.regionMatches(true, r0 + 1, "Folder", 0, 6) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.lang.String r13) {
        /*
            r12 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r13)
            boolean r0 = r0.isDirectory()
            r1 = 0
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            r0 = 47
            int r0 = r13.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0086
            int r2 = r0 + 2
            int r3 = r13.length()
            if (r2 >= r3) goto L_0x0086
            r5 = 1
            int r2 = r13.length()
            int r6 = r2 + -4
            r8 = 0
            r9 = 4
            java.lang.String r7 = ".jpg"
            r4 = r13
            boolean r2 = r4.regionMatches(r5, r6, r7, r8, r9)
            r3 = 1
            if (r2 == 0) goto L_0x007b
            int r2 = r13.length()
            int r2 = r2 - r0
            int r2 = r2 - r3
            r4 = 17
            if (r2 != r4) goto L_0x0049
            r6 = 1
            int r7 = r0 + 1
            r9 = 0
            r10 = 13
            java.lang.String r8 = "AlbumArtSmall"
            r5 = r13
            boolean r4 = r5.regionMatches(r6, r7, r8, r9, r10)
            if (r4 != 0) goto L_0x005b
        L_0x0049:
            r4 = 10
            if (r2 != r4) goto L_0x005c
            r6 = 1
            int r7 = r0 + 1
            r9 = 0
            r10 = 6
            java.lang.String r8 = "Folder"
            r5 = r13
            boolean r2 = r5.regionMatches(r6, r7, r8, r9, r10)
            if (r2 == 0) goto L_0x005c
        L_0x005b:
            return r3
        L_0x005c:
            r5 = 1
            int r2 = r0 + 1
            r8 = 0
            r9 = 10
            java.lang.String r7 = "AlbumArt_{"
            r4 = r13
            r6 = r2
            boolean r4 = r4.regionMatches(r5, r6, r7, r8, r9)
            if (r4 != 0) goto L_0x007a
            r7 = 1
            r10 = 0
            r11 = 9
            java.lang.String r9 = "AlbumArt."
            r6 = r13
            r8 = r2
            boolean r2 = r6.regionMatches(r7, r8, r9, r10, r11)
            if (r2 == 0) goto L_0x007b
        L_0x007a:
            return r3
        L_0x007b:
            int r0 = r0 + r3
            java.lang.String r2 = "._"
            r4 = 2
            boolean r13 = r13.regionMatches(r0, r2, r1, r4)
            if (r13 == 0) goto L_0x0086
            return r3
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.c.b(java.lang.String):boolean");
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.isDirectory() || (!b(file.getAbsolutePath()) && file.getName().matches("^.*?\\.(?i)(jpg|jpeg|gif|png|bmp|mp3|wma|ogg|aac|m4a|mid|midi|mp4|3gp|3g2|wmv|ts|mpg|mpeg|3gpp|mkv|avi|asf)(?-i)$"));
    }
}
