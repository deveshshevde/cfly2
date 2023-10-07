package com.sun.mail.imap;

import java.util.Vector;

public class Rights implements Cloneable {
    private boolean[] rights;

    public static final class Right {
        public static final Right ADMINISTER = getInstance('a');
        public static final Right CREATE = getInstance('c');
        public static final Right DELETE = getInstance('d');
        public static final Right INSERT = getInstance('i');
        public static final Right KEEP_SEEN = getInstance('s');
        public static final Right LOOKUP = getInstance('l');
        public static final Right POST = getInstance('p');
        public static final Right READ = getInstance('r');
        public static final Right WRITE = getInstance('w');
        private static Right[] cache = new Right[128];
        char right;

        private Right(char c2) {
            if (c2 < 128) {
                this.right = c2;
                return;
            }
            throw new IllegalArgumentException("Right must be ASCII");
        }

        public static synchronized Right getInstance(char c2) {
            Right right2;
            synchronized (Right.class) {
                if (c2 < 128) {
                    Right[] rightArr = cache;
                    if (rightArr[c2] == null) {
                        rightArr[c2] = new Right(c2);
                    }
                    right2 = cache[c2];
                } else {
                    throw new IllegalArgumentException("Right must be ASCII");
                }
            }
            return right2;
        }

        public String toString() {
            return String.valueOf(this.right);
        }
    }

    public Rights() {
        this.rights = new boolean[128];
    }

    public Rights(Right right) {
        boolean[] zArr = new boolean[128];
        this.rights = zArr;
        zArr[right.right] = true;
    }

    public Rights(Rights rights2) {
        boolean[] zArr = new boolean[128];
        this.rights = zArr;
        System.arraycopy(rights2.rights, 0, zArr, 0, zArr.length);
    }

    public Rights(String str) {
        this.rights = new boolean[128];
        for (int i2 = 0; i2 < str.length(); i2++) {
            add(Right.getInstance(str.charAt(i2)));
        }
    }

    public void add(Right right) {
        this.rights[right.right] = true;
    }

    public void add(Rights rights2) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights2.rights;
            if (i2 < zArr.length) {
                if (zArr[i2]) {
                    this.rights[i2] = true;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public Object clone() {
        Rights rights2 = null;
        try {
            Rights rights3 = (Rights) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                rights3.rights = zArr;
                boolean[] zArr2 = this.rights;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return rights3;
            } catch (CloneNotSupportedException unused) {
                rights2 = rights3;
            }
        } catch (CloneNotSupportedException unused2) {
            return rights2;
        }
    }

    public boolean contains(Right right) {
        return this.rights[right.right];
    }

    public boolean contains(Rights rights2) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights2.rights;
            if (i2 >= zArr.length) {
                return true;
            }
            if (zArr[i2] && !this.rights[i2]) {
                return false;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rights)) {
            return false;
        }
        Rights rights2 = (Rights) obj;
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights2.rights;
            if (i2 >= zArr.length) {
                return true;
            }
            if (zArr[i2] != this.rights[i2]) {
                return false;
            }
            i2++;
        }
    }

    public Right[] getRights() {
        Vector vector = new Vector();
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                Right[] rightArr = new Right[vector.size()];
                vector.copyInto(rightArr);
                return rightArr;
            }
            if (zArr[i2]) {
                vector.addElement(Right.getInstance((char) i2));
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                return i3;
            }
            if (zArr[i2]) {
                i3++;
            }
            i2++;
        }
    }

    public void remove(Right right) {
        this.rights[right.right] = false;
    }

    public void remove(Rights rights2) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = rights2.rights;
            if (i2 < zArr.length) {
                if (zArr[i2]) {
                    this.rights[i2] = false;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.rights;
            if (i2 >= zArr.length) {
                return stringBuffer.toString();
            }
            if (zArr[i2]) {
                stringBuffer.append((char) i2);
            }
            i2++;
        }
    }
}
