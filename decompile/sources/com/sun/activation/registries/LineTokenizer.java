package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

class LineTokenizer {
    private static final String singles = "=";
    private int currentPosition = 0;
    private int maxPosition;
    private Vector stack = new Vector();
    private String str;

    public LineTokenizer(String str2) {
        this.str = str2;
        this.maxPosition = str2.length();
    }

    private void skipWhiteSpace() {
        while (true) {
            int i2 = this.currentPosition;
            if (i2 < this.maxPosition && Character.isWhitespace(this.str.charAt(i2))) {
                this.currentPosition++;
            } else {
                return;
            }
        }
    }

    public boolean hasMoreTokens() {
        if (this.stack.size() > 0) {
            return true;
        }
        skipWhiteSpace();
        return this.currentPosition < this.maxPosition;
    }

    public String nextToken() {
        int size = this.stack.size();
        if (size > 0) {
            int i2 = size - 1;
            String str2 = (String) this.stack.elementAt(i2);
            this.stack.removeElementAt(i2);
            return str2;
        }
        skipWhiteSpace();
        int i3 = this.currentPosition;
        if (i3 < this.maxPosition) {
            char charAt = this.str.charAt(i3);
            if (charAt != '\"') {
                if (singles.indexOf(charAt) < 0) {
                    while (true) {
                        int i4 = this.currentPosition;
                        if (i4 >= this.maxPosition || singles.indexOf(this.str.charAt(i4)) >= 0 || Character.isWhitespace(this.str.charAt(this.currentPosition))) {
                            break;
                        }
                        this.currentPosition++;
                    }
                } else {
                    this.currentPosition++;
                }
            } else {
                this.currentPosition++;
                boolean z2 = false;
                while (true) {
                    int i5 = this.currentPosition;
                    if (i5 >= this.maxPosition) {
                        break;
                    }
                    String str3 = this.str;
                    this.currentPosition = i5 + 1;
                    char charAt2 = str3.charAt(i5);
                    if (charAt2 == '\\') {
                        this.currentPosition++;
                        z2 = true;
                    } else if (charAt2 == '\"') {
                        if (!z2) {
                            return this.str.substring(i3 + 1, this.currentPosition - 1);
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i6 = i3 + 1; i6 < this.currentPosition - 1; i6++) {
                            char charAt3 = this.str.charAt(i6);
                            if (charAt3 != '\\') {
                                stringBuffer.append(charAt3);
                            }
                        }
                        return stringBuffer.toString();
                    }
                }
            }
            return this.str.substring(i3, this.currentPosition);
        }
        throw new NoSuchElementException();
    }

    public void pushToken(String str2) {
        this.stack.addElement(str2);
    }
}
