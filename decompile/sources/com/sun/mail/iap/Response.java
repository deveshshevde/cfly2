package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

public class Response {
    public static final int BAD = 12;
    public static final int BYE = 16;
    public static final int CONTINUATION = 1;
    public static final int NO = 8;
    public static final int OK = 4;
    public static final int SYNTHETIC = 32;
    public static final int TAGGED = 2;
    public static final int TAG_MASK = 3;
    public static final int TYPE_MASK = 28;
    public static final int UNTAGGED = 3;
    private static final int increment = 100;
    protected byte[] buffer = null;
    protected int index;
    protected int pindex;
    protected int size;
    protected String tag = null;
    protected int type = 0;

    public Response(Protocol protocol) throws IOException, ProtocolException {
        ByteArray readResponse = protocol.getInputStream().readResponse(protocol.getResponseBuffer());
        this.buffer = readResponse.getBytes();
        this.size = readResponse.getCount() - 2;
        parse();
    }

    public Response(Response response) {
        this.index = response.index;
        this.size = response.size;
        this.buffer = response.buffer;
        this.type = response.type;
        this.tag = response.tag;
    }

    public Response(String str) {
        byte[] bytes = ASCIIUtility.getBytes(str);
        this.buffer = bytes;
        this.size = bytes.length;
        parse();
    }

    public static Response byeResponse(Exception exc) {
        Response response = new Response(("* BYE JavaMail Exception: " + exc.toString()).replace(13, ' ').replace(10, ' '));
        response.type = response.type | 32;
        return response;
    }

    private void parse() {
        int i2;
        this.index = 0;
        byte[] bArr = this.buffer;
        if (bArr[0] == 43) {
            this.type |= 1;
            this.index = 0 + 1;
            return;
        }
        if (bArr[0] == 42) {
            this.type |= 3;
            this.index = 0 + 1;
        } else {
            this.type |= 2;
            this.tag = readAtom();
        }
        int i3 = this.index;
        String readAtom = readAtom();
        if (readAtom == null) {
            readAtom = "";
        }
        if (readAtom.equalsIgnoreCase("OK")) {
            i2 = this.type | 4;
        } else if (readAtom.equalsIgnoreCase("NO")) {
            i2 = this.type | 8;
        } else if (readAtom.equalsIgnoreCase("BAD")) {
            i2 = this.type | 12;
        } else if (readAtom.equalsIgnoreCase("BYE")) {
            i2 = this.type | 16;
        } else {
            this.index = i3;
            this.pindex = this.index;
        }
        this.type = i2;
        this.pindex = this.index;
    }

    private Object parseString(boolean z2, boolean z3) {
        byte[] bArr;
        int i2;
        byte[] bArr2;
        int i3;
        skipSpaces();
        byte[] bArr3 = this.buffer;
        int i4 = this.index;
        byte b2 = bArr3[i4];
        if (b2 == 34) {
            int i5 = i4 + 1;
            this.index = i5;
            int i6 = i5;
            while (true) {
                bArr2 = this.buffer;
                i3 = this.index;
                byte b3 = bArr2[i3];
                if (b3 == 34) {
                    break;
                }
                if (b3 == 92) {
                    this.index = i3 + 1;
                }
                int i7 = this.index;
                if (i7 != i6) {
                    bArr2[i6] = bArr2[i7];
                }
                i6++;
                this.index = i7 + 1;
            }
            this.index = i3 + 1;
            return z3 ? ASCIIUtility.toString(bArr2, i5, i6) : new ByteArray(bArr2, i5, i6 - i5);
        } else if (b2 == 123) {
            int i8 = i4 + 1;
            this.index = i8;
            while (true) {
                bArr = this.buffer;
                i2 = this.index;
                if (bArr[i2] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                } else {
                    this.index = i2 + 1;
                }
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i8, i2);
            int i9 = this.index + 3;
            int i10 = i9 + parseInt;
            this.index = i10;
            return z3 ? ASCIIUtility.toString(this.buffer, i9, i10) : new ByteArray(this.buffer, i9, parseInt);
        } else if (z2) {
            return z3 ? readAtom() : new ByteArray(this.buffer, i4, this.index);
        } else if (b2 != 78 && b2 != 110) {
            return null;
        } else {
            this.index = i4 + 3;
            return null;
        }
    }

    public String getRest() {
        skipSpaces();
        return ASCIIUtility.toString(this.buffer, this.index, this.size);
    }

    public String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBAD() {
        return (this.type & 28) == 12;
    }

    public boolean isBYE() {
        return (this.type & 28) == 16;
    }

    public boolean isContinuation() {
        return (this.type & 3) == 1;
    }

    public boolean isNO() {
        return (this.type & 28) == 8;
    }

    public boolean isOK() {
        return (this.type & 28) == 4;
    }

    public boolean isSynthetic() {
        return (this.type & 32) == 32;
    }

    public boolean isTagged() {
        return (this.type & 3) == 2;
    }

    public boolean isUnTagged() {
        return (this.type & 3) == 3;
    }

    public byte peekByte() {
        int i2 = this.index;
        if (i2 < this.size) {
            return this.buffer[i2];
        }
        return 0;
    }

    public String readAtom() {
        return readAtom(0);
    }

    public String readAtom(char c2) {
        int i2;
        byte b2;
        skipSpaces();
        int i3 = this.index;
        if (i3 >= this.size) {
            return null;
        }
        while (true) {
            i2 = this.index;
            if (i2 < this.size && (b2 = this.buffer[i2]) > 32 && b2 != 40 && b2 != 41 && b2 != 37 && b2 != 42 && b2 != 34 && b2 != 92 && b2 != Byte.MAX_VALUE && (c2 == 0 || b2 != c2)) {
                this.index = i2 + 1;
            }
        }
        return ASCIIUtility.toString(this.buffer, i3, i2);
    }

    public String readAtomString() {
        return (String) parseString(true, true);
    }

    public byte readByte() {
        int i2 = this.index;
        if (i2 >= this.size) {
            return 0;
        }
        byte[] bArr = this.buffer;
        this.index = i2 + 1;
        return bArr[i2];
    }

    public ByteArray readByteArray() {
        if (!isContinuation()) {
            return (ByteArray) parseString(false, false);
        }
        skipSpaces();
        byte[] bArr = this.buffer;
        int i2 = this.index;
        return new ByteArray(bArr, i2, this.size - i2);
    }

    public ByteArrayInputStream readBytes() {
        ByteArray readByteArray = readByteArray();
        if (readByteArray != null) {
            return readByteArray.toByteArrayInputStream();
        }
        return null;
    }

    public long readLong() {
        skipSpaces();
        int i2 = this.index;
        while (true) {
            int i3 = this.index;
            if (i3 >= this.size || !Character.isDigit((char) this.buffer[i3])) {
                int i4 = this.index;
            } else {
                this.index++;
            }
        }
        int i42 = this.index;
        if (i42 <= i2) {
            return -1;
        }
        try {
            return ASCIIUtility.parseLong(this.buffer, i2, i42);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public int readNumber() {
        skipSpaces();
        int i2 = this.index;
        while (true) {
            int i3 = this.index;
            if (i3 >= this.size || !Character.isDigit((char) this.buffer[i3])) {
                int i4 = this.index;
            } else {
                this.index++;
            }
        }
        int i42 = this.index;
        if (i42 <= i2) {
            return -1;
        }
        try {
            return ASCIIUtility.parseInt(this.buffer, i2, i42);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String readString() {
        return (String) parseString(false, true);
    }

    public String readString(char c2) {
        int i2;
        skipSpaces();
        int i3 = this.index;
        if (i3 >= this.size) {
            return null;
        }
        while (true) {
            i2 = this.index;
            if (i2 < this.size && this.buffer[i2] != c2) {
                this.index = i2 + 1;
            }
        }
        return ASCIIUtility.toString(this.buffer, i3, i2);
    }

    public String[] readStringList() {
        byte[] bArr;
        int i2;
        skipSpaces();
        byte[] bArr2 = this.buffer;
        int i3 = this.index;
        if (bArr2[i3] != 40) {
            return null;
        }
        this.index = i3 + 1;
        Vector vector = new Vector();
        do {
            vector.addElement(readString());
            bArr = this.buffer;
            i2 = this.index;
            this.index = i2 + 1;
        } while (bArr[i2] != 41);
        int size2 = vector.size();
        if (size2 <= 0) {
            return null;
        }
        String[] strArr = new String[size2];
        vector.copyInto(strArr);
        return strArr;
    }

    public void reset() {
        this.index = this.pindex;
    }

    public void skip(int i2) {
        this.index += i2;
    }

    public void skipSpaces() {
        while (true) {
            int i2 = this.index;
            if (i2 < this.size && this.buffer[i2] == 32) {
                this.index = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void skipToken() {
        while (true) {
            int i2 = this.index;
            if (i2 < this.size && this.buffer[i2] != 32) {
                this.index = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return ASCIIUtility.toString(this.buffer, 0, this.size);
    }
}
