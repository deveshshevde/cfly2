package org.jsoup.parser;

abstract class Token {

    /* renamed from: a  reason: collision with root package name */
    TokenType f33725a;

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    static final class a extends b {
        a(String str) {
            a(str);
        }

        public String toString() {
            return "<![CDATA[" + o() + "]]>";
        }
    }

    static class b extends Token {

        /* renamed from: b  reason: collision with root package name */
        private String f33733b;

        b() {
            super();
            this.f33725a = TokenType.Character;
        }

        /* access modifiers changed from: package-private */
        public b a(String str) {
            this.f33733b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Token b() {
            this.f33733b = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f33733b;
        }

        public String toString() {
            return o();
        }
    }

    static final class c extends Token {

        /* renamed from: b  reason: collision with root package name */
        boolean f33734b = false;

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f33735c = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        private String f33736d;

        c() {
            super();
            this.f33725a = TokenType.Comment;
        }

        private void p() {
            String str = this.f33736d;
            if (str != null) {
                this.f33735c.append(str);
                this.f33736d = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final c a(char c2) {
            p();
            this.f33735c.append(c2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final c a(String str) {
            p();
            if (this.f33735c.length() == 0) {
                this.f33736d = str;
            } else {
                this.f33735c.append(str);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Token b() {
            a(this.f33735c);
            this.f33736d = null;
            this.f33734b = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            String str = this.f33736d;
            return str != null ? str : this.f33735c.toString();
        }

        public String toString() {
            return "<!--" + o() + "-->";
        }
    }

    static final class d extends Token {

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f33737b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        String f33738c = null;

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f33739d = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        final StringBuilder f33740e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        boolean f33741f = false;

        d() {
            super();
            this.f33725a = TokenType.Doctype;
        }

        /* access modifiers changed from: package-private */
        public Token b() {
            a(this.f33737b);
            this.f33738c = null;
            a(this.f33739d);
            a(this.f33740e);
            this.f33741f = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f33737b.toString();
        }

        /* access modifiers changed from: package-private */
        public String p() {
            return this.f33738c;
        }

        /* access modifiers changed from: package-private */
        public String q() {
            return this.f33739d.toString();
        }

        public String r() {
            return this.f33740e.toString();
        }

        public boolean s() {
            return this.f33741f;
        }
    }

    static final class e extends Token {
        e() {
            super();
            this.f33725a = TokenType.EOF;
        }

        /* access modifiers changed from: package-private */
        public Token b() {
            return this;
        }
    }

    static final class f extends h {
        f() {
            this.f33725a = TokenType.EndTag;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("</");
            sb.append(this.f33742b != null ? this.f33742b : "(unset)");
            sb.append(">");
            return sb.toString();
        }
    }

    static final class g extends h {
        g() {
            this.f33725a = TokenType.StartTag;
        }

        /* access modifiers changed from: package-private */
        public g a(String str, org.jsoup.nodes.b bVar) {
            this.f33742b = str;
            this.f33745e = bVar;
            this.f33743c = oh.b.a(this.f33742b);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public h b() {
            super.b();
            this.f33745e = null;
            return this;
        }

        public String toString() {
            StringBuilder sb;
            String r2;
            if (this.f33745e == null || this.f33745e.a() <= 0) {
                sb = new StringBuilder();
                sb.append("<");
                r2 = r();
            } else {
                sb = new StringBuilder();
                sb.append("<");
                sb.append(r());
                sb.append(" ");
                r2 = this.f33745e.toString();
            }
            sb.append(r2);
            sb.append(">");
            return sb.toString();
        }
    }

    static abstract class h extends Token {

        /* renamed from: b  reason: collision with root package name */
        protected String f33742b;

        /* renamed from: c  reason: collision with root package name */
        protected String f33743c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33744d = false;

        /* renamed from: e  reason: collision with root package name */
        org.jsoup.nodes.b f33745e;

        /* renamed from: f  reason: collision with root package name */
        private String f33746f;

        /* renamed from: g  reason: collision with root package name */
        private StringBuilder f33747g = new StringBuilder();

        /* renamed from: h  reason: collision with root package name */
        private String f33748h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f33749i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f33750j = false;

        h() {
            super();
        }

        private void w() {
            this.f33750j = true;
            String str = this.f33748h;
            if (str != null) {
                this.f33747g.append(str);
                this.f33748h = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final h a(String str) {
            this.f33742b = str;
            this.f33743c = oh.b.a(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void a(char c2) {
            b(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void a(int[] iArr) {
            w();
            for (int appendCodePoint : iArr) {
                this.f33747g.appendCodePoint(appendCodePoint);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(char c2) {
            c(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void b(String str) {
            String str2 = this.f33742b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f33742b = str;
            this.f33743c = oh.b.a(str);
        }

        /* access modifiers changed from: package-private */
        public final void c(char c2) {
            w();
            this.f33747g.append(c2);
        }

        /* access modifiers changed from: package-private */
        public final void c(String str) {
            String str2 = this.f33746f;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f33746f = str;
        }

        /* access modifiers changed from: package-private */
        public final void d(String str) {
            w();
            if (this.f33747g.length() == 0) {
                this.f33748h = str;
            } else {
                this.f33747g.append(str);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public h b() {
            this.f33742b = null;
            this.f33743c = null;
            this.f33746f = null;
            a(this.f33747g);
            this.f33748h = null;
            this.f33749i = false;
            this.f33750j = false;
            this.f33744d = false;
            this.f33745e = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void p() {
            if (this.f33745e == null) {
                this.f33745e = new org.jsoup.nodes.b();
            }
            String str = this.f33746f;
            if (str != null) {
                String trim = str.trim();
                this.f33746f = trim;
                if (trim.length() > 0) {
                    this.f33745e.a(this.f33746f, this.f33750j ? this.f33747g.length() > 0 ? this.f33747g.toString() : this.f33748h : this.f33749i ? "" : null);
                }
            }
            this.f33746f = null;
            this.f33749i = false;
            this.f33750j = false;
            a(this.f33747g);
            this.f33748h = null;
        }

        /* access modifiers changed from: package-private */
        public final void q() {
            if (this.f33746f != null) {
                p();
            }
        }

        /* access modifiers changed from: package-private */
        public final String r() {
            String str = this.f33742b;
            org.jsoup.helper.c.b(str == null || str.length() == 0);
            return this.f33742b;
        }

        /* access modifiers changed from: package-private */
        public final String s() {
            return this.f33743c;
        }

        /* access modifiers changed from: package-private */
        public final boolean t() {
            return this.f33744d;
        }

        /* access modifiers changed from: package-private */
        public final org.jsoup.nodes.b u() {
            if (this.f33745e == null) {
                this.f33745e = new org.jsoup.nodes.b();
            }
            return this.f33745e;
        }

        /* access modifiers changed from: package-private */
        public final void v() {
            this.f33749i = true;
        }
    }

    private Token() {
    }

    static void a(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: package-private */
    public abstract Token b();

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.f33725a == TokenType.Doctype;
    }

    /* access modifiers changed from: package-private */
    public final d d() {
        return (d) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return this.f33725a == TokenType.StartTag;
    }

    /* access modifiers changed from: package-private */
    public final g f() {
        return (g) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.f33725a == TokenType.EndTag;
    }

    /* access modifiers changed from: package-private */
    public final f h() {
        return (f) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f33725a == TokenType.Comment;
    }

    /* access modifiers changed from: package-private */
    public final c j() {
        return (c) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f33725a == TokenType.Character;
    }

    /* access modifiers changed from: package-private */
    public final boolean l() {
        return this instanceof a;
    }

    /* access modifiers changed from: package-private */
    public final b m() {
        return (b) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean n() {
        return this.f33725a == TokenType.EOF;
    }
}
