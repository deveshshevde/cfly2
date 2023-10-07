package javax.mail.internet;

import java.text.ParseException;

class MailDateParser {
    int index = 0;
    char[] orig = null;

    public MailDateParser(char[] cArr) {
        this.orig = cArr;
    }

    /* access modifiers changed from: package-private */
    public int getIndex() {
        return this.index;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        r3 = r8.index;
        r4 = r3 + 1;
        r8.index = r4;
        r3 = r1[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        if (r3 == 'S') goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r3 != 's') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        if (r3 == 'D') goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r3 != 'd') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
        r8.index = r4 + 1;
        r1 = r1[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if (r1 == 'T') goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if (r1 == 't') goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        throw new java.text.ParseException("Bad Alpha TimeZone", r8.index);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
        r8.index = r4 + 1;
        r1 = r1[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        if (r1 == 'T') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r1 != 't') goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a6, code lost:
        throw new java.text.ParseException("Bad Alpha TimeZone", r8.index);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return r2 - 60;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseAlphaTimeZone() throws java.text.ParseException {
        /*
            r8 = this;
            java.lang.String r0 = "Bad Alpha TimeZone"
            char[] r1 = r8.orig     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            int r2 = r8.index     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            int r3 = r2 + 1
            r8.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            char r2 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            r4 = 0
            r5 = 116(0x74, float:1.63E-43)
            r6 = 84
            r7 = 1
            switch(r2) {
                case 67: goto L_0x005e;
                case 69: goto L_0x0059;
                case 71: goto L_0x0038;
                case 77: goto L_0x0033;
                case 80: goto L_0x002e;
                case 85: goto L_0x0019;
                case 99: goto L_0x005e;
                case 101: goto L_0x0059;
                case 103: goto L_0x0038;
                case 109: goto L_0x0033;
                case 112: goto L_0x002e;
                case 117: goto L_0x0019;
                default: goto L_0x0015;
            }     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
        L_0x0015:
            java.text.ParseException r1 = new java.text.ParseException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            goto L_0x00a8
        L_0x0019:
            int r2 = r3 + 1
            r8.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            char r2 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            if (r2 == r6) goto L_0x002c
            if (r2 != r5) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            java.text.ParseException r1 = new java.text.ParseException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            int r2 = r8.index     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            r1.<init>(r0, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
        L_0x002c:
            r2 = 0
            goto L_0x0063
        L_0x002e:
            r4 = 480(0x1e0, float:6.73E-43)
            r2 = 480(0x1e0, float:6.73E-43)
            goto L_0x0062
        L_0x0033:
            r4 = 420(0x1a4, float:5.89E-43)
            r2 = 420(0x1a4, float:5.89E-43)
            goto L_0x0062
        L_0x0038:
            int r2 = r3 + 1
            r8.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            r7 = 77
            if (r3 == r7) goto L_0x0046
            r7 = 109(0x6d, float:1.53E-43)
            if (r3 != r7) goto L_0x0051
        L_0x0046:
            int r3 = r2 + 1
            r8.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            char r2 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            if (r2 == r6) goto L_0x002c
            if (r2 != r5) goto L_0x0051
            goto L_0x002c
        L_0x0051:
            java.text.ParseException r1 = new java.text.ParseException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            int r2 = r8.index     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            r1.<init>(r0, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
        L_0x0059:
            r4 = 300(0x12c, float:4.2E-43)
            r2 = 300(0x12c, float:4.2E-43)
            goto L_0x0062
        L_0x005e:
            r4 = 360(0x168, float:5.04E-43)
            r2 = 360(0x168, float:5.04E-43)
        L_0x0062:
            r4 = 1
        L_0x0063:
            if (r4 == 0) goto L_0x00a7
            int r3 = r8.index
            int r4 = r3 + 1
            r8.index = r4
            char r3 = r1[r3]
            r7 = 83
            if (r3 == r7) goto L_0x0094
            r7 = 115(0x73, float:1.61E-43)
            if (r3 != r7) goto L_0x0076
            goto L_0x0094
        L_0x0076:
            r7 = 68
            if (r3 == r7) goto L_0x007e
            r7 = 100
            if (r3 != r7) goto L_0x00a7
        L_0x007e:
            int r3 = r4 + 1
            r8.index = r3
            char r1 = r1[r4]
            if (r1 == r6) goto L_0x0091
            if (r1 == r5) goto L_0x0089
            goto L_0x0091
        L_0x0089:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            throw r1
        L_0x0091:
            int r2 = r2 + -60
            goto L_0x00a7
        L_0x0094:
            int r3 = r4 + 1
            r8.index = r3
            char r1 = r1[r4]
            if (r1 == r6) goto L_0x00a7
            if (r1 != r5) goto L_0x009f
            goto L_0x00a7
        L_0x009f:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            throw r1
        L_0x00a7:
            return r2
        L_0x00a8:
            int r2 = r8.index     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            r1.<init>(r0, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00ae }
        L_0x00ae:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            goto L_0x00b7
        L_0x00b6:
            throw r1
        L_0x00b7:
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseAlphaTimeZone():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        return 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r2 = r3 + 1;
        r0.index = r2;
        r3 = r1[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r3 == 'C') goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (r3 != 'c') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
        r0.index = r2 + 1;
        r1 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r1 == 'T') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        if (r1 != 't') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r2 = r3 + 1;
        r0.index = r2;
        r3 = r1[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r3 == 'O') goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0075, code lost:
        if (r3 != 'o') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0077, code lost:
        r0.index = r2 + 1;
        r1 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007f, code lost:
        if (r1 == 'V') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r1 != 'v') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0088, code lost:
        r2 = r3 + 1;
        r0.index = r2;
        r3 = r1[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        if (r3 == 'A') goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        if (r3 != 'a') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0092, code lost:
        r0.index = r2 + 1;
        r1 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        if (r1 == 'R') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r1 != 'r') goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        if (r1 == 'Y') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a3, code lost:
        if (r1 != 'y') goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d2, code lost:
        if (r3 == 'u') goto L_0x00d4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseMonth() throws java.text.ParseException {
        /*
            r16 = this;
            r0 = r16
            char[] r1 = r0.orig     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            int r2 = r0.index     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r2 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r4 = 114(0x72, float:1.6E-43)
            r5 = 82
            r6 = 112(0x70, float:1.57E-43)
            r8 = 85
            r9 = 80
            r10 = 65
            if (r2 == r10) goto L_0x0128
            r11 = 68
            r12 = 99
            r13 = 67
            r14 = 101(0x65, float:1.42E-43)
            r15 = 69
            if (r2 == r11) goto L_0x0111
            r11 = 70
            if (r2 == r11) goto L_0x00f7
            r11 = 74
            r7 = 97
            if (r2 == r11) goto L_0x00c0
            r11 = 83
            if (r2 == r11) goto L_0x00a9
            if (r2 == r7) goto L_0x0128
            r11 = 100
            if (r2 == r11) goto L_0x0111
            r11 = 102(0x66, float:1.43E-43)
            if (r2 == r11) goto L_0x00f7
            r11 = 106(0x6a, float:1.49E-43)
            if (r2 == r11) goto L_0x00c0
            r8 = 115(0x73, float:1.61E-43)
            if (r2 == r8) goto L_0x00a9
            switch(r2) {
                case 77: goto L_0x0088;
                case 78: goto L_0x0069;
                case 79: goto L_0x004e;
                default: goto L_0x0049;
            }     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
        L_0x0049:
            switch(r2) {
                case 109: goto L_0x0088;
                case 110: goto L_0x0069;
                case 111: goto L_0x004e;
                default: goto L_0x004c;
            }     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
        L_0x004c:
            goto L_0x0155
        L_0x004e:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r13) goto L_0x0058
            if (r3 != r12) goto L_0x0155
        L_0x0058:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r2 = 84
            if (r1 == r2) goto L_0x0066
            r2 = 116(0x74, float:1.63E-43)
            if (r1 != r2) goto L_0x0155
        L_0x0066:
            r1 = 9
            return r1
        L_0x0069:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r4 = 79
            if (r3 == r4) goto L_0x0077
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x0155
        L_0x0077:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r2 = 86
            if (r1 == r2) goto L_0x0085
            r2 = 118(0x76, float:1.65E-43)
            if (r1 != r2) goto L_0x0155
        L_0x0085:
            r1 = 10
            return r1
        L_0x0088:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r10) goto L_0x0092
            if (r3 != r7) goto L_0x0155
        L_0x0092:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r5) goto L_0x00a7
            if (r1 != r4) goto L_0x009d
            goto L_0x00a7
        L_0x009d:
            r2 = 89
            if (r1 == r2) goto L_0x00a5
            r2 = 121(0x79, float:1.7E-43)
            if (r1 != r2) goto L_0x0155
        L_0x00a5:
            r1 = 4
            return r1
        L_0x00a7:
            r1 = 2
            return r1
        L_0x00a9:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r15) goto L_0x00b3
            if (r3 != r14) goto L_0x0155
        L_0x00b3:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r9) goto L_0x00bd
            if (r1 != r6) goto L_0x0155
        L_0x00bd:
            r1 = 8
            return r1
        L_0x00c0:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r4 = 110(0x6e, float:1.54E-43)
            r5 = 78
            if (r3 == r10) goto L_0x00eb
            if (r3 == r8) goto L_0x00d4
            if (r3 == r7) goto L_0x00eb
            r6 = 117(0x75, float:1.64E-43)
            if (r3 != r6) goto L_0x0155
        L_0x00d4:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r5) goto L_0x00e9
            if (r1 != r4) goto L_0x00df
            goto L_0x00e9
        L_0x00df:
            r2 = 76
            if (r1 == r2) goto L_0x00e7
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x0155
        L_0x00e7:
            r1 = 6
            return r1
        L_0x00e9:
            r1 = 5
            return r1
        L_0x00eb:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r5) goto L_0x00f5
            if (r1 != r4) goto L_0x0155
        L_0x00f5:
            r1 = 0
            return r1
        L_0x00f7:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r15) goto L_0x0101
            if (r3 != r14) goto L_0x0155
        L_0x0101:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r2 = 66
            if (r1 == r2) goto L_0x010f
            r2 = 98
            if (r1 != r2) goto L_0x0155
        L_0x010f:
            r1 = 1
            return r1
        L_0x0111:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r15) goto L_0x011b
            if (r3 != r14) goto L_0x0155
        L_0x011b:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r13) goto L_0x0125
            if (r1 != r12) goto L_0x0155
        L_0x0125:
            r1 = 11
            return r1
        L_0x0128:
            int r2 = r3 + 1
            r0.index = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r3 = r1[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r3 == r9) goto L_0x0149
            if (r3 != r6) goto L_0x0133
            goto L_0x0149
        L_0x0133:
            if (r3 == r8) goto L_0x0139
            r4 = 117(0x75, float:1.64E-43)
            if (r3 != r4) goto L_0x0155
        L_0x0139:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            r2 = 71
            if (r1 == r2) goto L_0x0147
            r2 = 103(0x67, float:1.44E-43)
            if (r1 != r2) goto L_0x0155
        L_0x0147:
            r1 = 7
            return r1
        L_0x0149:
            int r3 = r2 + 1
            r0.index = r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            char r1 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0155 }
            if (r1 == r5) goto L_0x0153
            if (r1 != r4) goto L_0x0155
        L_0x0153:
            r1 = 3
            return r1
        L_0x0155:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r0.index
            java.lang.String r3 = "Bad Month"
            r1.<init>(r3, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseMonth():int");
    }

    public int parseNumber() throws ParseException {
        int length = this.orig.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            int i3 = this.index;
            if (i3 < length) {
                switch (this.orig[i3]) {
                    case '0':
                        i2 *= 10;
                        break;
                    case '1':
                        i2 = (i2 * 10) + 1;
                        break;
                    case '2':
                        i2 = (i2 * 10) + 2;
                        break;
                    case '3':
                        i2 = (i2 * 10) + 3;
                        break;
                    case '4':
                        i2 = (i2 * 10) + 4;
                        break;
                    case '5':
                        i2 = (i2 * 10) + 5;
                        break;
                    case '6':
                        i2 = (i2 * 10) + 6;
                        break;
                    case '7':
                        i2 = (i2 * 10) + 7;
                        break;
                    case '8':
                        i2 = (i2 * 10) + 8;
                        break;
                    case '9':
                        i2 = (i2 * 10) + 9;
                        break;
                    default:
                        if (z2) {
                            return i2;
                        }
                        throw new ParseException("No Number found", this.index);
                }
                this.index = i3 + 1;
                z2 = true;
            } else if (z2) {
                return i2;
            } else {
                throw new ParseException("No Number found", this.index);
            }
        }
    }

    public int parseNumericTimeZone() throws ParseException {
        boolean z2;
        char[] cArr = this.orig;
        int i2 = this.index;
        this.index = i2 + 1;
        char c2 = cArr[i2];
        if (c2 == '+') {
            z2 = true;
        } else if (c2 == '-') {
            z2 = false;
        } else {
            throw new ParseException("Bad Numeric TimeZone", this.index);
        }
        int parseNumber = parseNumber();
        int i3 = ((parseNumber / 100) * 60) + (parseNumber % 100);
        return z2 ? -i3 : i3;
    }

    public int parseTimeZone() throws ParseException {
        int i2 = this.index;
        char[] cArr = this.orig;
        if (i2 < cArr.length) {
            char c2 = cArr[i2];
            return (c2 == '+' || c2 == '-') ? parseNumericTimeZone() : parseAlphaTimeZone();
        }
        throw new ParseException("No more characters", this.index);
    }

    public int peekChar() throws ParseException {
        int i2 = this.index;
        char[] cArr = this.orig;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw new ParseException("No more characters", this.index);
    }

    public void skipChar(char c2) throws ParseException {
        int i2 = this.index;
        char[] cArr = this.orig;
        if (i2 >= cArr.length) {
            throw new ParseException("No more characters", this.index);
        } else if (cArr[i2] == c2) {
            this.index = i2 + 1;
        } else {
            throw new ParseException("Wrong char", this.index);
        }
    }

    public boolean skipIfChar(char c2) throws ParseException {
        int i2 = this.index;
        char[] cArr = this.orig;
        if (i2 >= cArr.length) {
            throw new ParseException("No more characters", this.index);
        } else if (cArr[i2] != c2) {
            return false;
        } else {
            this.index = i2 + 1;
            return true;
        }
    }

    public void skipUntilNumber() throws ParseException {
        while (true) {
            try {
                char[] cArr = this.orig;
                int i2 = this.index;
                switch (cArr[i2]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return;
                    default:
                        this.index = i2 + 1;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParseException("No Number Found", this.index);
            }
        }
    }

    public void skipWhiteSpace() {
        int length = this.orig.length;
        while (true) {
            int i2 = this.index;
            if (i2 < length) {
                char c2 = this.orig[i2];
                if (c2 == 9 || c2 == 10 || c2 == 13 || c2 == ' ') {
                    this.index = i2 + 1;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
