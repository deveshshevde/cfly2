package com.sun.activation.registries;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class MailcapTokenizer {
    public static final int EOI_TOKEN = 5;
    public static final int EQUALS_TOKEN = 61;
    public static final int SEMICOLON_TOKEN = 59;
    public static final int SLASH_TOKEN = 47;
    public static final int START_TOKEN = 1;
    public static final int STRING_TOKEN = 2;
    public static final int UNKNOWN_TOKEN = 0;
    private char autoquoteChar;
    private int currentToken;
    private String currentTokenValue;
    private String data;
    private int dataIndex = 0;
    private int dataLength;
    private boolean isAutoquoting;

    public MailcapTokenizer(String str) {
        this.data = str;
        this.dataLength = str.length();
        this.currentToken = 1;
        this.currentTokenValue = "";
        this.isAutoquoting = false;
        this.autoquoteChar = ';';
    }

    private static String fixEscapeSequences(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '\\' && i2 < length - 1) {
                i2++;
                charAt = str.charAt(i2);
            }
            stringBuffer.append(charAt);
            i2++;
        }
        return stringBuffer.toString();
    }

    private static boolean isControlChar(char c2) {
        return Character.isISOControl(c2);
    }

    private static boolean isSpecialChar(char c2) {
        if (!(c2 == '\"' || c2 == ',' || c2 == '/' || c2 == '(' || c2 == ')')) {
            switch (c2) {
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    break;
                default:
                    switch (c2) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    private static boolean isStringTokenChar(char c2) {
        return !isSpecialChar(c2) && !isControlChar(c2) && !isWhiteSpaceChar(c2);
    }

    private static boolean isWhiteSpaceChar(char c2) {
        return Character.isWhitespace(c2);
    }

    public static String nameForToken(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 47 ? i2 != 59 ? i2 != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : "string" : "start" : IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
    }

    private void processAutoquoteToken() {
        int i2;
        int i3 = this.dataIndex;
        boolean z2 = false;
        while (true) {
            i2 = this.dataIndex;
            if (i2 >= this.dataLength || z2) {
                this.currentToken = 2;
                this.currentTokenValue = fixEscapeSequences(this.data.substring(i3, i2));
            } else if (this.data.charAt(i2) != this.autoquoteChar) {
                this.dataIndex++;
            } else {
                z2 = true;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = fixEscapeSequences(this.data.substring(i3, i2));
    }

    private void processStringToken() {
        int i2 = this.dataIndex;
        while (true) {
            int i3 = this.dataIndex;
            if (i3 >= this.dataLength || !isStringTokenChar(this.data.charAt(i3))) {
                this.currentToken = 2;
                this.currentTokenValue = this.data.substring(i2, this.dataIndex);
            } else {
                this.dataIndex++;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = this.data.substring(i2, this.dataIndex);
    }

    public int getCurrentToken() {
        return this.currentToken;
    }

    public String getCurrentTokenValue() {
        return this.currentTokenValue;
    }

    public int nextToken() {
        Character ch2;
        if (this.dataIndex < this.dataLength) {
            while (true) {
                int i2 = this.dataIndex;
                if (i2 >= this.dataLength || !isWhiteSpaceChar(this.data.charAt(i2))) {
                    int i3 = this.dataIndex;
                } else {
                    this.dataIndex++;
                }
            }
            int i32 = this.dataIndex;
            if (i32 < this.dataLength) {
                char charAt = this.data.charAt(i32);
                if (this.isAutoquoting) {
                    if (charAt == ';' || charAt == '=') {
                        this.currentToken = charAt;
                        ch2 = new Character(charAt);
                    } else {
                        processAutoquoteToken();
                        return this.currentToken;
                    }
                } else if (isStringTokenChar(charAt)) {
                    processStringToken();
                    return this.currentToken;
                } else if (charAt == '/' || charAt == ';' || charAt == '=') {
                    this.currentToken = charAt;
                    ch2 = new Character(charAt);
                } else {
                    this.currentToken = 0;
                    ch2 = new Character(charAt);
                }
                this.currentTokenValue = ch2.toString();
                this.dataIndex++;
                return this.currentToken;
            }
        }
        this.currentToken = 5;
        this.currentTokenValue = null;
        return this.currentToken;
    }

    public void setIsAutoquoting(boolean z2) {
        this.isAutoquoting = z2;
    }
}
