package javax.mail.internet;

public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, (String) null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i2, String str) {
            this.type = i2;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str, String str2, boolean z2) {
        str = str == null ? "" : str;
        this.string = str;
        this.skipComments = z2;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = str.length();
    }

    private static String filterToken(String str, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 10 || !z2) {
                if (z3) {
                    stringBuffer.append(charAt);
                    z2 = false;
                    z3 = false;
                } else if (charAt == '\\') {
                    z2 = false;
                    z3 = true;
                } else if (charAt == 13) {
                    z2 = true;
                } else {
                    stringBuffer.append(charAt);
                }
                i2++;
            }
            z2 = false;
            i2++;
        }
        return stringBuffer.toString();
    }

    private Token getNext() throws ParseException {
        char charAt;
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        char charAt2 = this.string.charAt(this.currentPos);
        boolean z2 = false;
        while (charAt2 == '(') {
            int i2 = this.currentPos + 1;
            this.currentPos = i2;
            int i3 = 1;
            while (i3 > 0) {
                int i4 = this.currentPos;
                if (i4 >= this.maxPos) {
                    break;
                }
                char charAt3 = this.string.charAt(i4);
                if (charAt3 == '\\') {
                    this.currentPos++;
                } else if (charAt3 != 13) {
                    if (charAt3 == '(') {
                        i3++;
                    } else if (charAt3 == ')') {
                        i3--;
                    }
                    this.currentPos++;
                }
                z2 = true;
                this.currentPos++;
            }
            if (i3 != 0) {
                throw new ParseException("Unbalanced comments");
            } else if (!this.skipComments) {
                String str = this.string;
                int i5 = this.currentPos - 1;
                return new Token(-3, z2 ? filterToken(str, i2, i5) : str.substring(i2, i5));
            } else if (skipWhiteSpace() == -4) {
                return EOFToken;
            } else {
                charAt2 = this.string.charAt(this.currentPos);
            }
        }
        if (charAt2 == '\"') {
            int i6 = this.currentPos + 1;
            this.currentPos = i6;
            while (true) {
                int i7 = this.currentPos;
                if (i7 < this.maxPos) {
                    char charAt4 = this.string.charAt(i7);
                    if (charAt4 == '\\') {
                        this.currentPos++;
                    } else if (charAt4 != 13) {
                        if (charAt4 == '\"') {
                            int i8 = this.currentPos + 1;
                            this.currentPos = i8;
                            String str2 = this.string;
                            int i9 = i8 - 1;
                            return new Token(-2, z2 ? filterToken(str2, i6, i9) : str2.substring(i6, i9));
                        }
                        this.currentPos++;
                    }
                    z2 = true;
                    this.currentPos++;
                } else {
                    throw new ParseException("Unbalanced quoted string");
                }
            }
        } else if (charAt2 < ' ' || charAt2 >= 127 || this.delimiters.indexOf(charAt2) >= 0) {
            this.currentPos++;
            return new Token(charAt2, new String(new char[]{charAt2}));
        } else {
            int i10 = this.currentPos;
            while (true) {
                int i11 = this.currentPos;
                if (i11 < this.maxPos && (charAt = this.string.charAt(i11)) >= ' ' && charAt < 127 && charAt != '(' && charAt != ' ' && charAt != '\"' && this.delimiters.indexOf(charAt) < 0) {
                    this.currentPos++;
                }
            }
            return new Token(-1, this.string.substring(i10, this.currentPos));
        }
    }

    private int skipWhiteSpace() {
        while (true) {
            int i2 = this.currentPos;
            if (i2 >= this.maxPos) {
                return -4;
            }
            char charAt = this.string.charAt(i2);
            if (charAt != ' ' && charAt != 9 && charAt != 13 && charAt != 10) {
                return this.currentPos;
            }
            this.currentPos++;
        }
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i2 = this.currentPos;
        this.peekPos = i2;
        this.nextPos = i2;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }
}
