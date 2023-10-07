package com.xeagle.android.proxy.updateFirmware;

public class UploadParser {

    /* renamed from: b  reason: collision with root package name */
    static boolean f24288b;

    /* renamed from: a  reason: collision with root package name */
    Parse_states f24289a = Parse_states.PARSE_STATE_UNINIT;

    /* renamed from: c  reason: collision with root package name */
    private UploadPacket f24290c;

    /* renamed from: com.xeagle.android.proxy.updateFirmware.UploadParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24291a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states[] r0 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24291a = r0
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_UNINIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_GOT_STX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_GOT_LENGTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_COUNT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_LAST_COUNT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_STATUS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f24291a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_CRC1     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.UploadParser.AnonymousClass1.<clinit>():void");
        }
    }

    enum Parse_states {
        PARSE_STATE_UNINIT,
        PARSE_STATE_IDLE,
        PARSE_STATE_GOT_STX,
        PARSE_STATE_GOT_LENGTH,
        PARSE_STATE_COUNT,
        PARSE_STATE_LAST_COUNT,
        PARSE_STATE_STATUS,
        PARSE_STATE_PAYLOAD,
        PARSE_STATE_CRC1,
        PARSE_STATE_CRC2
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
        if (r7 == 126) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r6.f24289a = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.f24294c;
        r6.f24290c.f24287f.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0070, code lost:
        if (r6.f24290c.a() != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.f24299h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        r6.f24289a = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        if (f24288b == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b6, code lost:
        return r6.f24290c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r7 == 126) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xeagle.android.proxy.updateFirmware.UploadPacket a(int r7) {
        /*
            r6 = this;
            r0 = 0
            f24288b = r0
            int[] r1 = com.xeagle.android.proxy.updateFirmware.UploadParser.AnonymousClass1.f24291a
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r2 = r6.f24289a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "UPLOAD"
            r3 = 126(0x7e, float:1.77E-43)
            switch(r1) {
                case 1: goto L_0x00a3;
                case 2: goto L_0x00a3;
                case 3: goto L_0x0093;
                case 4: goto L_0x008a;
                case 5: goto L_0x0083;
                case 6: goto L_0x0073;
                case 7: goto L_0x0062;
                case 8: goto L_0x0032;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x00b0
        L_0x0016:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r1 = r6.f24290c
            com.xeagle.android.proxy.updateFirmware.b r1 = r1.f24287f
            int r1 = r1.c()
            if (r7 == r1) goto L_0x002e
            java.lang.String r1 = "upload_parse_char:crc2--->>>fail"
            android.util.Log.i(r2, r1)
            f24288b = r0
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r0 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_IDLE
            r6.f24289a = r0
            if (r7 != r3) goto L_0x00b0
            goto L_0x0053
        L_0x002e:
            r7 = 1
            f24288b = r7
            goto L_0x0099
        L_0x0032:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r1 = r6.f24290c
            r1.c()
            r4 = 25
            android.os.SystemClock.sleep(r4)
            com.xeagle.android.proxy.updateFirmware.UploadPacket r1 = r6.f24290c
            com.xeagle.android.proxy.updateFirmware.b r1 = r1.f24287f
            int r1 = r1.b()
            if (r7 == r1) goto L_0x005f
            java.lang.String r1 = "upload_parse_char:crc1--->>>fail"
            android.util.Log.i(r2, r1)
            f24288b = r0
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r0 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_IDLE
            r6.f24289a = r0
            if (r7 != r3) goto L_0x00b0
        L_0x0053:
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_GOT_STX
            r6.f24289a = r7
            com.xeagle.android.proxy.updateFirmware.UploadPacket r7 = r6.f24290c
            com.xeagle.android.proxy.updateFirmware.b r7 = r7.f24287f
            r7.a()
            goto L_0x00b0
        L_0x005f:
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_CRC1
            goto L_0x0090
        L_0x0062:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r0 = r6.f24290c
            com.xeagle.android.proxy.updateFirmware.a r0 = r0.f24286e
            byte r7 = (byte) r7
            r0.a(r7)
            com.xeagle.android.proxy.updateFirmware.UploadPacket r7 = r6.f24290c
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x00b0
            goto L_0x007d
        L_0x0073:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r0 = r6.f24290c
            r0.f24285d = r7
            com.xeagle.android.proxy.updateFirmware.UploadPacket r7 = r6.f24290c
            int r7 = r7.f24282a
            if (r7 != 0) goto L_0x0080
        L_0x007d:
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_PAYLOAD
            goto L_0x0090
        L_0x0080:
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_STATUS
            goto L_0x0090
        L_0x0083:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r0 = r6.f24290c
            r0.f24284c = r7
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_LAST_COUNT
            goto L_0x0090
        L_0x008a:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r0 = r6.f24290c
            r0.f24283b = r7
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_COUNT
        L_0x0090:
            r6.f24289a = r7
            goto L_0x00b0
        L_0x0093:
            boolean r1 = f24288b
            if (r1 == 0) goto L_0x009c
            f24288b = r0
        L_0x0099:
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_IDLE
            goto L_0x0090
        L_0x009c:
            com.xeagle.android.proxy.updateFirmware.UploadPacket r0 = r6.f24290c
            r0.f24282a = r7
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_GOT_LENGTH
            goto L_0x0090
        L_0x00a3:
            if (r7 != r3) goto L_0x00b0
            com.xeagle.android.proxy.updateFirmware.UploadParser$Parse_states r7 = com.xeagle.android.proxy.updateFirmware.UploadParser.Parse_states.PARSE_STATE_GOT_STX
            r6.f24289a = r7
            com.xeagle.android.proxy.updateFirmware.UploadPacket r7 = new com.xeagle.android.proxy.updateFirmware.UploadPacket
            r7.<init>()
            r6.f24290c = r7
        L_0x00b0:
            boolean r7 = f24288b
            if (r7 == 0) goto L_0x00b7
            com.xeagle.android.proxy.updateFirmware.UploadPacket r7 = r6.f24290c
            return r7
        L_0x00b7:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.UploadParser.a(int):com.xeagle.android.proxy.updateFirmware.UploadPacket");
    }
}
