package com.MAVLink;

import com.MAVLink.Messages.b;

public class Parser {

    /* renamed from: b  reason: collision with root package name */
    static boolean f6287b;

    /* renamed from: a  reason: collision with root package name */
    MAV_states f6288a = MAV_states.MAVLINK_PARSE_STATE_UNINIT;

    /* renamed from: c  reason: collision with root package name */
    public b f6289c = new b();

    /* renamed from: d  reason: collision with root package name */
    private MAVLinkPacket f6290d;

    /* renamed from: com.MAVLink.Parser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6291a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.MAVLink.Parser$MAV_states[] r0 = com.MAVLink.Parser.MAV_states.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6291a = r0
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_UNINIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f6291a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.MAVLink.Parser.AnonymousClass1.<clinit>():void");
        }
    }

    enum MAV_states {
        MAVLINK_PARSE_STATE_UNINIT,
        MAVLINK_PARSE_STATE_IDLE,
        MAVLINK_PARSE_STATE_GOT_STX,
        MAVLINK_PARSE_STATE_GOT_LENGTH,
        MAVLINK_PARSE_STATE_GOT_SEQ,
        MAVLINK_PARSE_STATE_GOT_SYSID,
        MAVLINK_PARSE_STATE_GOT_COMPID,
        MAVLINK_PARSE_STATE_GOT_MSGID,
        MAVLINK_PARSE_STATE_GOT_CRC1,
        MAVLINK_PARSE_STATE_GOT_PAYLOAD
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r4 == 254) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        r3.f6288a = com.MAVLink.Parser.MAV_states.f6294c;
        r3.f6290d.f6251g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r3.f6289c.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r3.f6290d.a() != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        r4 = com.MAVLink.Parser.MAV_states.f6301j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0093, code lost:
        r3.f6288a = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (f6287b == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        return r3.f6290d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ba, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        if (r4 == 254) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.MAVLink.MAVLinkPacket a(int r4) {
        /*
            r3 = this;
            r0 = 0
            f6287b = r0
            int[] r1 = com.MAVLink.Parser.AnonymousClass1.f6291a
            com.MAVLink.Parser$MAV_states r2 = r3.f6288a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 254(0xfe, float:3.56E-43)
            switch(r1) {
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a6;
                case 3: goto L_0x0096;
                case 4: goto L_0x008d;
                case 5: goto L_0x0086;
                case 6: goto L_0x007f;
                case 7: goto L_0x006f;
                case 8: goto L_0x005e;
                case 9: goto L_0x0033;
                case 10: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x00b3
        L_0x0014:
            com.MAVLink.MAVLinkPacket r1 = r3.f6290d
            com.MAVLink.ardupilotmega.a r1 = r1.f6251g
            int r1 = r1.b()
            if (r4 == r1) goto L_0x0027
            f6287b = r0
            com.MAVLink.Parser$MAV_states r0 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE
            r3.f6288a = r0
            if (r4 != r2) goto L_0x0055
            goto L_0x004a
        L_0x0027:
            com.MAVLink.Messages.b r4 = r3.f6289c
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r4.a(r0)
            r4 = 1
            f6287b = r4
            goto L_0x009c
        L_0x0033:
            com.MAVLink.MAVLinkPacket r1 = r3.f6290d
            r1.b()
            com.MAVLink.MAVLinkPacket r1 = r3.f6290d
            com.MAVLink.ardupilotmega.a r1 = r1.f6251g
            int r1 = r1.c()
            if (r4 == r1) goto L_0x005b
            f6287b = r0
            com.MAVLink.Parser$MAV_states r0 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE
            r3.f6288a = r0
            if (r4 != r2) goto L_0x0055
        L_0x004a:
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX
            r3.f6288a = r4
            com.MAVLink.MAVLinkPacket r4 = r3.f6290d
            com.MAVLink.ardupilotmega.a r4 = r4.f6251g
            r4.a()
        L_0x0055:
            com.MAVLink.Messages.b r4 = r3.f6289c
            r4.a()
            goto L_0x00b3
        L_0x005b:
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1
            goto L_0x0093
        L_0x005e:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            com.MAVLink.Messages.a r0 = r0.f6250f
            byte r4 = (byte) r4
            r0.a((byte) r4)
            com.MAVLink.MAVLinkPacket r4 = r3.f6290d
            boolean r4 = r4.a()
            if (r4 == 0) goto L_0x00b3
            goto L_0x0079
        L_0x006f:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r0.f6249e = r4
            com.MAVLink.MAVLinkPacket r4 = r3.f6290d
            int r4 = r4.f6245a
            if (r4 != 0) goto L_0x007c
        L_0x0079:
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD
            goto L_0x0093
        L_0x007c:
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID
            goto L_0x0093
        L_0x007f:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r0.f6248d = r4
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID
            goto L_0x0093
        L_0x0086:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r0.f6247c = r4
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID
            goto L_0x0093
        L_0x008d:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r0.f6246b = r4
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ
        L_0x0093:
            r3.f6288a = r4
            goto L_0x00b3
        L_0x0096:
            boolean r1 = f6287b
            if (r1 == 0) goto L_0x009f
            f6287b = r0
        L_0x009c:
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE
            goto L_0x0093
        L_0x009f:
            com.MAVLink.MAVLinkPacket r0 = r3.f6290d
            r0.f6245a = r4
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH
            goto L_0x0093
        L_0x00a6:
            if (r4 != r2) goto L_0x00b3
            com.MAVLink.Parser$MAV_states r4 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX
            r3.f6288a = r4
            com.MAVLink.MAVLinkPacket r4 = new com.MAVLink.MAVLinkPacket
            r4.<init>()
            r3.f6290d = r4
        L_0x00b3:
            boolean r4 = f6287b
            if (r4 == 0) goto L_0x00ba
            com.MAVLink.MAVLinkPacket r4 = r3.f6290d
            return r4
        L_0x00ba:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.MAVLink.Parser.a(int):com.MAVLink.MAVLinkPacket");
    }
}
