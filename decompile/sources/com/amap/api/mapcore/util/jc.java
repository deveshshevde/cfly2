package com.amap.api.mapcore.util;

public final class jc {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f9433a = new StringBuilder();

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r2.has("info") == false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.mapcore.util.iz a(java.lang.String r7, android.content.Context r8, com.amap.api.mapcore.util.he r9) {
        /*
            r6 = this;
            java.lang.String r0 = "status"
            com.amap.api.mapcore.util.iz r1 = new com.amap.api.mapcore.util.iz
            java.lang.String r2 = ""
            r1.<init>(r2)
            r2 = 7
            r1.setErrorCode(r2)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x004f }
            r2.<init>(r7)     // Catch:{ all -> 0x004f }
            boolean r3 = r2.has(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "info"
            if (r3 == 0) goto L_0x0020
            boolean r3 = r2.has(r4)     // Catch:{ all -> 0x004f }
            if (r3 != 0) goto L_0x002f
        L_0x0020:
            java.lang.StringBuilder r3 = r6.f9433a     // Catch:{ all -> 0x004f }
            java.lang.String r5 = "json is error "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x004f }
            java.lang.String r7 = r5.concat(r7)     // Catch:{ all -> 0x004f }
            r3.append(r7)     // Catch:{ all -> 0x004f }
        L_0x002f:
            java.lang.String r7 = r2.getString(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r2.getString(r4)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "0"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x004f }
            if (r7 == 0) goto L_0x006e
            java.lang.StringBuilder r7 = r6.f9433a     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "auth fail:"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x004f }
            r7.append(r0)     // Catch:{ all -> 0x004f }
            goto L_0x006e
        L_0x004f:
            r7 = move-exception
            java.lang.StringBuilder r0 = r6.f9433a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "json exception error:"
            r2.<init>(r3)
            java.lang.String r3 = r7.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = "MapParser"
            java.lang.String r2 = "paseAuthFailurJson"
            com.amap.api.mapcore.util.io.a(r7, r0, r2)
        L_0x006e:
            r7 = 0
            java.lang.StringBuilder r0 = r6.f9433a     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "#SHA1AndPackage#"
            r0.append(r2)     // Catch:{ all -> 0x00b5 }
            java.lang.String r8 = com.amap.api.mapcore.util.ev.e(r8)     // Catch:{ all -> 0x00b5 }
            r0.append(r8)     // Catch:{ all -> 0x00b5 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8 = r9.f9118b     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = "gsid"
            java.lang.Object r8 = r8.get(r0)     // Catch:{ all -> 0x00b5 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x00b5 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x00b5 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00b5 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00b5 }
            if (r0 != 0) goto L_0x009d
            java.lang.StringBuilder r0 = r6.f9433a     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = " #gsid#"
            r0.append(r2)     // Catch:{ all -> 0x00b5 }
            r0.append(r8)     // Catch:{ all -> 0x00b5 }
        L_0x009d:
            java.lang.String r8 = r9.f9119c     // Catch:{ all -> 0x00b5 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00b5 }
            if (r9 != 0) goto L_0x00b6
            java.lang.StringBuilder r9 = r6.f9433a     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = " #csid#"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00b5 }
            java.lang.String r8 = r0.concat(r8)     // Catch:{ all -> 0x00b5 }
            r9.append(r8)     // Catch:{ all -> 0x00b5 }
            goto L_0x00b6
        L_0x00b5:
        L_0x00b6:
            java.lang.StringBuilder r8 = r6.f9433a
            java.lang.String r8 = r8.toString()
            r1.setLocationDetail(r8)
            java.lang.StringBuilder r8 = r6.f9433a
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x00d0
            java.lang.StringBuilder r8 = r6.f9433a
            int r9 = r8.length()
            r8.delete(r7, r9)
        L_0x00d0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jc.a(java.lang.String, android.content.Context, com.amap.api.mapcore.util.he):com.amap.api.mapcore.util.iz");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(58:22|23|24|25|26|27|(4:28|29|30|31)|34|35|36|37|38|39|42|43|44|45|46|47|50|51|(4:52|53|54|55)|58|59|60|61|62|63|64|65|66|67|70|71|72|73|74|75|(4:76|77|78|79)|82|83|84|85|86|87|88|(2:90|91)|92|(1:98)|99|(1:101)|102|(1:104)|105|(3:107|(1:109)|110)|111|(1:117)(1:115)|116) */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0284, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        r3 = new com.amap.api.mapcore.util.iz("");
        r3.setErrorCode(5);
        r2 = r1.f9433a;
        r2.append("parser data error:" + r0.getMessage());
        r3.setLocationDetail(r1.f9433a.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02ad, code lost:
        if (r5 != null) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02af, code lost:
        r5.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02b2, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02c7, code lost:
        if (r5 != null) goto L_0x02c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02c9, code lost:
        r5.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02cd, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:126:0x023c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:130:0x024f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00a8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00ff */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0112 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x0127 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x013a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x014f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x0162 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0195 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a1 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ad A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f8 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0204 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0255 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0264 A[Catch:{ all -> 0x0284, all -> 0x02c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x016f A[SYNTHETIC, Splitter:B:90:0x016f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.mapcore.util.iz a(byte[] r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = ""
            r3 = 0
            r4 = 5
            r5 = 0
            com.amap.api.mapcore.util.iz r0 = new com.amap.api.mapcore.util.iz     // Catch:{ all -> 0x0284 }
            r0.<init>(r2)     // Catch:{ all -> 0x0284 }
            if (r17 != 0) goto L_0x002b
            r0.setErrorCode(r4)     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r6 = r1.f9433a     // Catch:{ all -> 0x0284 }
            java.lang.String r7 = "byte[] is null"
            r6.append(r7)     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r6 = r1.f9433a     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0284 }
            r0.setLocationDetail(r6)     // Catch:{ all -> 0x0284 }
            java.lang.StringBuilder r6 = r1.f9433a     // Catch:{ all -> 0x0284 }
            int r7 = r6.length()     // Catch:{ all -> 0x0284 }
            r6.delete(r3, r7)     // Catch:{ all -> 0x0284 }
            return r0
        L_0x002b:
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r17)     // Catch:{ all -> 0x0284 }
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            if (r6 != 0) goto L_0x0049
            short r6 = r5.getShort()     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0284 }
            r0.b(r6)     // Catch:{ all -> 0x0284 }
            r5.clear()     // Catch:{ all -> 0x0284 }
            if (r5 == 0) goto L_0x0048
            r5.clear()
        L_0x0048:
            return r0
        L_0x0049:
            int r6 = r5.getInt()     // Catch:{ all -> 0x0284 }
            double r6 = (double) r6
            r8 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r8
            double r6 = com.amap.api.mapcore.util.is.a((double) r6)     // Catch:{ all -> 0x0284 }
            r0.setLongitude(r6)     // Catch:{ all -> 0x0284 }
            int r6 = r5.getInt()     // Catch:{ all -> 0x0284 }
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r8
            double r6 = com.amap.api.mapcore.util.is.a((double) r6)     // Catch:{ all -> 0x0284 }
            r0.setLatitude(r6)     // Catch:{ all -> 0x0284 }
            short r6 = r5.getShort()     // Catch:{ all -> 0x0284 }
            float r6 = (float) r6     // Catch:{ all -> 0x0284 }
            r0.setAccuracy(r6)     // Catch:{ all -> 0x0284 }
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0284 }
            r0.c(r6)     // Catch:{ all -> 0x0284 }
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0284 }
            r0.d(r6)     // Catch:{ all -> 0x0284 }
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r7 = 1
            java.lang.String r8 = "UTF-8"
            if (r6 != r7) goto L_0x0209
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00a8 }
            r9.<init>(r6, r8)     // Catch:{ all -> 0x00a8 }
            r0.setCountry(r9)     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00bc }
            r9.<init>(r6, r8)     // Catch:{ all -> 0x00bc }
            r0.setProvince(r9)     // Catch:{ all -> 0x00bd }
            goto L_0x00bd
        L_0x00bc:
            r9 = r2
        L_0x00bd:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00d1 }
            r10.<init>(r6, r8)     // Catch:{ all -> 0x00d1 }
            r0.setCity(r10)     // Catch:{ all -> 0x00d2 }
            goto L_0x00d2
        L_0x00d1:
            r10 = r2
        L_0x00d2:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00e6 }
            r11.<init>(r6, r8)     // Catch:{ all -> 0x00e6 }
            r0.setDistrict(r11)     // Catch:{ all -> 0x00e7 }
            goto L_0x00e7
        L_0x00e6:
            r11 = r2
        L_0x00e7:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x00fe }
            r12.<init>(r6, r8)     // Catch:{ all -> 0x00fe }
            r0.setStreet(r12)     // Catch:{ all -> 0x00ff }
            r0.setRoad(r12)     // Catch:{ all -> 0x00ff }
            goto L_0x00ff
        L_0x00fe:
            r12 = r2
        L_0x00ff:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r13 = new java.lang.String     // Catch:{ all -> 0x0112 }
            r13.<init>(r6, r8)     // Catch:{ all -> 0x0112 }
            r0.setNumber(r13)     // Catch:{ all -> 0x0112 }
        L_0x0112:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r13 = new java.lang.String     // Catch:{ all -> 0x0126 }
            r13.<init>(r6, r8)     // Catch:{ all -> 0x0126 }
            r0.setPoiName(r13)     // Catch:{ all -> 0x0127 }
            goto L_0x0127
        L_0x0126:
            r13 = r2
        L_0x0127:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x013a }
            r14.<init>(r6, r8)     // Catch:{ all -> 0x013a }
            r0.setAoiName(r14)     // Catch:{ all -> 0x013a }
        L_0x013a:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r14 = new java.lang.String     // Catch:{ all -> 0x014e }
            r14.<init>(r6, r8)     // Catch:{ all -> 0x014e }
            r0.setAdCode(r14)     // Catch:{ all -> 0x014f }
            goto L_0x014f
        L_0x014e:
            r14 = r2
        L_0x014f:
            byte r6 = r5.get()     // Catch:{ all -> 0x0284 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0284 }
            r5.get(r6)     // Catch:{ all -> 0x0284 }
            java.lang.String r15 = new java.lang.String     // Catch:{ all -> 0x0162 }
            r15.<init>(r6, r8)     // Catch:{ all -> 0x0162 }
            r0.setCityCode(r15)     // Catch:{ all -> 0x0162 }
        L_0x0162:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r6.<init>()     // Catch:{ all -> 0x0284 }
            boolean r15 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = " "
            if (r15 != 0) goto L_0x0175
            r6.append(r9)     // Catch:{ all -> 0x0284 }
            r6.append(r3)     // Catch:{ all -> 0x0284 }
        L_0x0175:
            boolean r15 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0284 }
            if (r15 != 0) goto L_0x018f
            java.lang.String r15 = "市"
            boolean r15 = r9.contains(r15)     // Catch:{ all -> 0x0284 }
            if (r15 == 0) goto L_0x0189
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0284 }
            if (r9 != 0) goto L_0x018f
        L_0x0189:
            r6.append(r10)     // Catch:{ all -> 0x0284 }
            r6.append(r3)     // Catch:{ all -> 0x0284 }
        L_0x018f:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0284 }
            if (r9 != 0) goto L_0x019b
            r6.append(r11)     // Catch:{ all -> 0x0284 }
            r6.append(r3)     // Catch:{ all -> 0x0284 }
        L_0x019b:
            boolean r9 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0284 }
            if (r9 != 0) goto L_0x01a7
            r6.append(r12)     // Catch:{ all -> 0x0284 }
            r6.append(r3)     // Catch:{ all -> 0x0284 }
        L_0x01a7:
            boolean r9 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0284 }
            if (r9 != 0) goto L_0x01be
            boolean r9 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0284 }
            if (r9 != 0) goto L_0x01b8
            java.lang.String r9 = "靠近"
            r6.append(r9)     // Catch:{ all -> 0x0284 }
        L_0x01b8:
            r6.append(r13)     // Catch:{ all -> 0x0284 }
            r6.append(r3)     // Catch:{ all -> 0x0284 }
        L_0x01be:
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0284 }
            r9.<init>()     // Catch:{ all -> 0x0284 }
            java.lang.String r10 = "citycode"
            java.lang.String r11 = r0.getCityCode()     // Catch:{ all -> 0x0284 }
            r9.putString(r10, r11)     // Catch:{ all -> 0x0284 }
            java.lang.String r10 = "desc"
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x0284 }
            r9.putString(r10, r11)     // Catch:{ all -> 0x0284 }
            java.lang.String r10 = "adcode"
            java.lang.String r11 = r0.getAdCode()     // Catch:{ all -> 0x0284 }
            r9.putString(r10, r11)     // Catch:{ all -> 0x0284 }
            r0.setExtras(r9)     // Catch:{ all -> 0x0284 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0284 }
            r0.e(r9)     // Catch:{ all -> 0x0284 }
            java.lang.String r9 = r0.getAdCode()     // Catch:{ all -> 0x0284 }
            if (r9 == 0) goto L_0x0204
            java.lang.String r9 = r9.trim()     // Catch:{ all -> 0x0284 }
            int r9 = r9.length()     // Catch:{ all -> 0x0284 }
            if (r9 <= 0) goto L_0x0204
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = r6.replace(r3, r2)     // Catch:{ all -> 0x0284 }
        L_0x0200:
            r0.setAddress(r3)     // Catch:{ all -> 0x0284 }
            goto L_0x0209
        L_0x0204:
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0284 }
            goto L_0x0200
        L_0x0209:
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0284 }
            r5.get(r3)     // Catch:{ all -> 0x0284 }
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            if (r3 != r7) goto L_0x0223
            r5.getInt()     // Catch:{ all -> 0x0284 }
            r5.getInt()     // Catch:{ all -> 0x0284 }
            r5.getShort()     // Catch:{ all -> 0x0284 }
        L_0x0223:
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            if (r3 != r7) goto L_0x024f
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0284 }
            r5.get(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x023c }
            r6.<init>(r3, r8)     // Catch:{ all -> 0x023c }
            r0.setBuildingId(r6)     // Catch:{ all -> 0x023c }
        L_0x023c:
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0284 }
            r5.get(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x024f }
            r6.<init>(r3, r8)     // Catch:{ all -> 0x024f }
            r0.setFloor(r6)     // Catch:{ all -> 0x024f }
        L_0x024f:
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            if (r3 != r7) goto L_0x025e
            r5.get()     // Catch:{ all -> 0x0284 }
            r5.getInt()     // Catch:{ all -> 0x0284 }
            r5.get()     // Catch:{ all -> 0x0284 }
        L_0x025e:
            byte r3 = r5.get()     // Catch:{ all -> 0x0284 }
            if (r3 != r7) goto L_0x026b
            long r6 = r5.getLong()     // Catch:{ all -> 0x0284 }
            r0.setTime(r6)     // Catch:{ all -> 0x0284 }
        L_0x026b:
            short r3 = r5.getShort()     // Catch:{ all -> 0x0284 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0284 }
            r5.get(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x027d }
            r2.<init>(r3, r8)     // Catch:{ all -> 0x027d }
            r0.a(r2)     // Catch:{ all -> 0x027d }
            goto L_0x027e
        L_0x027d:
        L_0x027e:
            if (r5 == 0) goto L_0x02b3
            r5.clear()
            goto L_0x02b3
        L_0x0284:
            r0 = move-exception
            com.amap.api.mapcore.util.iz r3 = new com.amap.api.mapcore.util.iz     // Catch:{ all -> 0x02c6 }
            r3.<init>(r2)     // Catch:{ all -> 0x02c6 }
            r3.setErrorCode(r4)     // Catch:{ all -> 0x02c6 }
            java.lang.StringBuilder r2 = r1.f9433a     // Catch:{ all -> 0x02c6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c6 }
            java.lang.String r6 = "parser data error:"
            r4.<init>(r6)     // Catch:{ all -> 0x02c6 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02c6 }
            r4.append(r0)     // Catch:{ all -> 0x02c6 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x02c6 }
            r2.append(r0)     // Catch:{ all -> 0x02c6 }
            java.lang.StringBuilder r0 = r1.f9433a     // Catch:{ all -> 0x02c6 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02c6 }
            r3.setLocationDetail(r0)     // Catch:{ all -> 0x02c6 }
            if (r5 == 0) goto L_0x02b2
            r5.clear()
        L_0x02b2:
            r0 = r3
        L_0x02b3:
            java.lang.StringBuilder r2 = r1.f9433a
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x02c5
            java.lang.StringBuilder r2 = r1.f9433a
            int r3 = r2.length()
            r4 = 0
            r2.delete(r4, r3)
        L_0x02c5:
            return r0
        L_0x02c6:
            r0 = move-exception
            if (r5 == 0) goto L_0x02cc
            r5.clear()
        L_0x02cc:
            goto L_0x02ce
        L_0x02cd:
            throw r0
        L_0x02ce:
            goto L_0x02cd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jc.a(byte[]):com.amap.api.mapcore.util.iz");
    }
}
