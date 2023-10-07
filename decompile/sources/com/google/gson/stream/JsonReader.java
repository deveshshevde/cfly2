package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];

    /* renamed from: in  reason: collision with root package name */
    private final Reader f20029in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                int i2;
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i3 = jsonReader.peeked;
                if (i3 == 0) {
                    i3 = jsonReader.doPeek();
                }
                if (i3 == 13) {
                    i2 = 9;
                } else if (i3 == 12) {
                    i2 = 8;
                } else if (i3 == 14) {
                    i2 = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
                jsonReader.peeked = i2;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f20029in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i2 = this.pos - 1;
        this.pos = i2;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i2 + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i3 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i3 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i3] == cArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean fillBuffer(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.buffer;
        int i5 = this.lineStart;
        int i6 = this.pos;
        this.lineStart = i5 - i6;
        int i7 = this.limit;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.limit = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f20029in;
            int i9 = this.limit;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.limit + read;
            this.limit = i3;
            if (this.lineNumber == 0 && (i4 = this.lineStart) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private boolean isLiteral(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r1 != '/') goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r4 != r2) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        if (r2 != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r3 == '*') goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0075, code lost:
        if (r3 == '/') goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (skipTo("*/") == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009c, code lost:
        if (r1 != '#') goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
        checkLenient();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNonWhitespace(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.buffer
        L_0x0002:
            int r1 = r7.pos
        L_0x0004:
            int r2 = r7.limit
        L_0x0006:
            r3 = 1
            if (r1 != r2) goto L_0x0034
            r7.pos = r1
            boolean r1 = r7.fillBuffer(r3)
            if (r1 != 0) goto L_0x0030
            if (r8 != 0) goto L_0x0015
            r8 = -1
            return r8
        L_0x0015:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.locationString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0030:
            int r1 = r7.pos
            int r2 = r7.limit
        L_0x0034:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L_0x0044
            int r1 = r7.lineNumber
            int r1 = r1 + r3
            r7.lineNumber = r1
            r7.lineStart = r4
            goto L_0x00a3
        L_0x0044:
            r5 = 32
            if (r1 == r5) goto L_0x00a3
            r5 = 13
            if (r1 == r5) goto L_0x00a3
            r5 = 9
            if (r1 != r5) goto L_0x0051
            goto L_0x00a3
        L_0x0051:
            r5 = 47
            if (r1 != r5) goto L_0x0098
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L_0x006a
            int r4 = r4 + -1
            r7.pos = r4
            boolean r2 = r7.fillBuffer(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L_0x006a
            return r1
        L_0x006a:
            r7.checkLenient()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L_0x0080
            if (r3 == r5) goto L_0x0078
            return r1
        L_0x0078:
            int r2 = r2 + 1
            r7.pos = r2
        L_0x007c:
            r7.skipToEndOfLine()
            goto L_0x0002
        L_0x0080:
            int r2 = r2 + 1
            r7.pos = r2
            java.lang.String r1 = "*/"
            boolean r1 = r7.skipTo(r1)
            if (r1 == 0) goto L_0x0091
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L_0x0004
        L_0x0091:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.syntaxError(r8)
            throw r8
        L_0x0098:
            r2 = 35
            r7.pos = r4
            if (r1 != r2) goto L_0x00a2
            r7.checkLenient()
            goto L_0x007c
        L_0x00a2:
            return r1
        L_0x00a3:
            r1 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(char c2) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        while (true) {
            int i2 = this.pos;
            int i3 = this.limit;
            int i4 = i2;
            while (true) {
                if (i2 < i3) {
                    int i5 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.pos = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.pos = i5;
                        int i7 = (i5 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i7);
                        sb.append(readEscapeCharacter());
                    } else {
                        if (c3 == 10) {
                            this.lineNumber++;
                            this.lineStart = i5;
                        }
                        i2 = i5;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i2 - i4) * 2, 16));
                    }
                    sb.append(cArr, i4, i2 - i4);
                    this.pos = i2;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.buffer[this.pos];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.pos + i3 >= this.limit && !fillBuffer(i3 + 1)) {
                return 0;
            }
            char c3 = this.buffer[this.pos + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i2;
        return i2;
    }

    private int peekNumber() throws IOException {
        int i2;
        char c2;
        char[] cArr = this.buffer;
        int i3 = this.pos;
        int i4 = this.limit;
        int i5 = 0;
        int i6 = 0;
        char c3 = 0;
        boolean z2 = true;
        long j2 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 + i6 == i4) {
                if (i6 == cArr.length) {
                    return i5;
                }
                if (!fillBuffer(i6 + 1)) {
                    break;
                }
                i3 = this.pos;
                i4 = this.limit;
            }
            c2 = cArr[i3 + i6];
            if (c2 == '+') {
                i5 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i5 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i6++;
            } else {
                if (c2 == '-') {
                    i5 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z3 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i5 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i5 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            z2 &= j2 > MIN_INCOMPLETE_INTEGER || (j2 == MIN_INCOMPLETE_INTEGER && j3 < j2);
                            j2 = j3;
                        } else if (c3 == 3) {
                            i5 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i5 = 0;
                            c3 = 7;
                        }
                        i5 = 0;
                    }
                }
                i6++;
            }
            c3 = 6;
            i6++;
        }
        if (isLiteral(c2)) {
            return 0;
        }
        if (c3 == 2 && z2 && ((j2 != Long.MIN_VALUE || z3) && (j2 != 0 || !z3))) {
            if (!z3) {
                j2 = -j2;
            }
            this.peekedLong = j2;
            this.pos += i6;
            i2 = 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i6;
            i2 = 16;
        }
        this.peeked = i2;
        return i2;
    }

    private void push(int i2) {
        int i3 = this.stackSize;
        int[] iArr = this.stack;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.stack = Arrays.copyOf(iArr, i4);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i4);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i4);
        }
        int[] iArr2 = this.stack;
        int i5 = this.stackSize;
        this.stackSize = i5 + 1;
        iArr2[i5] = i2;
    }

    private char readEscapeCharacter() throws IOException {
        int i2;
        int i3;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 + 1;
            this.pos = i5;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.lineNumber++;
                this.lineStart = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i5 + 4 <= this.limit || fillBuffer(4)) {
                    char c3 = 0;
                    int i6 = this.pos;
                    int i7 = i6 + 4;
                    while (i6 < i7) {
                        char c4 = this.buffer[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (c5 + i3);
                        i6++;
                    }
                    this.pos += 4;
                    return c3;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c2) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i2 = this.pos;
            int i3 = this.limit;
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.pos = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.pos = i4;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.lineNumber++;
                            this.lineStart = i4;
                        }
                        i2 = i4;
                    }
                } else {
                    this.pos = i2;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i3 = this.pos;
            if (cArr[i3] == 10) {
                this.lineNumber++;
                this.lineStart = i3 + 1;
            } else {
                while (i2 < length) {
                    if (this.buffer[this.pos + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i2 = this.pos;
                int i3 = i2 + 1;
                this.pos = i3;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.lineNumber++;
                    this.lineStart = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f20029in.close();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int doPeek() throws java.io.IOException {
        /*
            r15 = this;
            int[] r0 = r15.stack
            int r1 = r15.stackSize
            int r2 = r1 + -1
            r2 = r0[r2]
            r3 = 8
            r4 = 39
            r5 = 34
            r6 = 93
            r7 = 3
            r8 = 7
            r9 = 59
            r10 = 44
            r11 = 4
            r12 = 2
            r13 = 1
            if (r2 != r13) goto L_0x0020
            int r1 = r1 - r13
            r0[r1] = r12
            goto L_0x00a2
        L_0x0020:
            if (r2 != r12) goto L_0x003a
            int r0 = r15.nextNonWhitespace(r13)
            if (r0 == r10) goto L_0x00a2
            if (r0 == r9) goto L_0x0036
            if (r0 != r6) goto L_0x002f
            r15.peeked = r11
            return r11
        L_0x002f:
            java.lang.String r0 = "Unterminated array"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0036:
            r15.checkLenient()
            goto L_0x00a2
        L_0x003a:
            r14 = 5
            if (r2 == r7) goto L_0x0117
            if (r2 != r14) goto L_0x0041
            goto L_0x0117
        L_0x0041:
            if (r2 != r11) goto L_0x0076
            int r1 = r1 - r13
            r0[r1] = r14
            int r0 = r15.nextNonWhitespace(r13)
            r1 = 58
            if (r0 == r1) goto L_0x00a2
            r1 = 61
            if (r0 != r1) goto L_0x006f
            r15.checkLenient()
            int r0 = r15.pos
            int r1 = r15.limit
            if (r0 < r1) goto L_0x0061
            boolean r0 = r15.fillBuffer(r13)
            if (r0 == 0) goto L_0x00a2
        L_0x0061:
            char[] r0 = r15.buffer
            int r1 = r15.pos
            char r0 = r0[r1]
            r14 = 62
            if (r0 != r14) goto L_0x00a2
            int r1 = r1 + r13
            r15.pos = r1
            goto L_0x00a2
        L_0x006f:
            java.lang.String r0 = "Expected ':'"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0076:
            r0 = 6
            if (r2 != r0) goto L_0x0088
            boolean r0 = r15.lenient
            if (r0 == 0) goto L_0x0080
            r15.consumeNonExecutePrefix()
        L_0x0080:
            int[] r0 = r15.stack
            int r1 = r15.stackSize
            int r1 = r1 - r13
            r0[r1] = r8
            goto L_0x00a2
        L_0x0088:
            if (r2 != r8) goto L_0x00a0
            r0 = 0
            int r0 = r15.nextNonWhitespace(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0097
            r0 = 17
        L_0x0094:
            r15.peeked = r0
            return r0
        L_0x0097:
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            goto L_0x00a2
        L_0x00a0:
            if (r2 == r3) goto L_0x010f
        L_0x00a2:
            int r0 = r15.nextNonWhitespace(r13)
            if (r0 == r5) goto L_0x010c
            if (r0 == r4) goto L_0x0106
            if (r0 == r10) goto L_0x00ef
            if (r0 == r9) goto L_0x00ef
            r1 = 91
            if (r0 == r1) goto L_0x00ec
            if (r0 == r6) goto L_0x00e7
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x00e4
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            int r0 = r15.peekKeyword()
            if (r0 == 0) goto L_0x00c4
            return r0
        L_0x00c4:
            int r0 = r15.peekNumber()
            if (r0 == 0) goto L_0x00cb
            return r0
        L_0x00cb:
            char[] r0 = r15.buffer
            int r1 = r15.pos
            char r0 = r0[r1]
            boolean r0 = r15.isLiteral(r0)
            if (r0 == 0) goto L_0x00dd
            r15.checkLenient()
            r0 = 10
            goto L_0x0094
        L_0x00dd:
            java.lang.String r0 = "Expected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x00e4:
            r15.peeked = r13
            return r13
        L_0x00e7:
            if (r2 != r13) goto L_0x00ef
            r15.peeked = r11
            return r11
        L_0x00ec:
            r15.peeked = r7
            return r7
        L_0x00ef:
            if (r2 == r13) goto L_0x00fb
            if (r2 != r12) goto L_0x00f4
            goto L_0x00fb
        L_0x00f4:
            java.lang.String r0 = "Unexpected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x00fb:
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            r15.peeked = r8
            return r8
        L_0x0106:
            r15.checkLenient()
            r15.peeked = r3
            return r3
        L_0x010c:
            r0 = 9
            goto L_0x0094
        L_0x010f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "JsonReader is closed"
            r0.<init>(r1)
            throw r0
        L_0x0117:
            int r1 = r1 - r13
            r0[r1] = r11
            r0 = 125(0x7d, float:1.75E-43)
            if (r2 != r14) goto L_0x0135
            int r1 = r15.nextNonWhitespace(r13)
            if (r1 == r10) goto L_0x0135
            if (r1 == r9) goto L_0x0132
            if (r1 != r0) goto L_0x012b
            r15.peeked = r12
            return r12
        L_0x012b:
            java.lang.String r0 = "Unterminated object"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0132:
            r15.checkLenient()
        L_0x0135:
            int r1 = r15.nextNonWhitespace(r13)
            if (r1 == r5) goto L_0x016a
            if (r1 == r4) goto L_0x0163
            java.lang.String r3 = "Expected name"
            if (r1 == r0) goto L_0x0159
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            char r0 = (char) r1
            boolean r0 = r15.isLiteral(r0)
            if (r0 == 0) goto L_0x0154
            r0 = 14
            goto L_0x0094
        L_0x0154:
            java.io.IOException r0 = r15.syntaxError(r3)
            throw r0
        L_0x0159:
            if (r2 == r14) goto L_0x015e
            r15.peeked = r12
            return r12
        L_0x015e:
            java.io.IOException r0 = r15.syntaxError(r3)
            throw r0
        L_0x0163:
            r15.checkLenient()
            r0 = 12
            goto L_0x0094
        L_0x016a:
            r0 = 13
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.doPeek():int");
    }

    public void endArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 4) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 2) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.stackSize;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.stack[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    /* access modifiers changed from: package-private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        String str;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.peekedLong;
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i2 == 8 || i2 == 9) {
                str = nextQuotedValue(i2 == 8 ? '\'' : '\"');
            } else if (i2 == 10) {
                str = nextUnquotedValue();
            } else if (i2 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = str;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            long j2 = this.peekedLong;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i2 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.peekedLong;
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i2 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String str;
        char c2;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 14) {
            str = nextUnquotedValue();
        } else {
            if (i2 == 12) {
                c2 = '\'';
            } else if (i2 == 13) {
                c2 = '\"';
            } else {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            str = nextQuotedValue(c2);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        char c2;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 10) {
            str = nextUnquotedValue();
        } else {
            if (i2 == 8) {
                c2 = '\'';
            } else if (i2 == 9) {
                c2 = '\"';
            } else if (i2 == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i2 == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i2 == 16) {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = nextQuotedValue(c2);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z2) {
        this.lenient = z2;
    }

    public void skipValue() throws IOException {
        char c2;
        int i2 = 0;
        do {
            int i3 = this.peeked;
            if (i3 == 0) {
                i3 = doPeek();
            }
            if (i3 == 3) {
                push(1);
            } else if (i3 == 1) {
                push(3);
            } else if (i3 == 4 || i3 == 2) {
                this.stackSize--;
                i2--;
                this.peeked = 0;
            } else if (i3 == 14 || i3 == 10) {
                skipUnquotedValue();
                this.peeked = 0;
            } else {
                if (i3 == 8 || i3 == 12) {
                    c2 = '\'';
                } else if (i3 == 9 || i3 == 13) {
                    c2 = '\"';
                } else {
                    if (i3 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                skipQuotedValue(c2);
                this.peeked = 0;
            }
            i2++;
            this.peeked = 0;
        } while (i2 != 0);
        int[] iArr = this.pathIndices;
        int i4 = this.stackSize;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.pathNames[i4 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
