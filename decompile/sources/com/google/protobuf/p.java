package com.google.protobuf;

final class p {

    private interface a {
        byte a(int i2);

        int a();
    }

    static String a(final ByteString byteString) {
        return a((a) new a() {
            public byte a(int i2) {
                return byteString.a(i2);
            }

            public int a() {
                return byteString.b();
            }
        });
    }

    static String a(a aVar) {
        String str;
        StringBuilder sb = new StringBuilder(aVar.a());
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            int a2 = aVar.a(i2);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a2 < 32 || a2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static String a(String str) {
        return a(ByteString.a(str));
    }
}
