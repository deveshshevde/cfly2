package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.jsoup.SerializationException;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;

public class a implements Cloneable, Map.Entry<String, String> {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33651b = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* renamed from: a  reason: collision with root package name */
    b f33652a;

    /* renamed from: c  reason: collision with root package name */
    private String f33653c;

    /* renamed from: d  reason: collision with root package name */
    private String f33654d;

    public a(String str, String str2, b bVar) {
        c.a((Object) str);
        String trim = str.trim();
        c.a(trim);
        this.f33653c = trim;
        this.f33654d = str2;
        this.f33652a = bVar;
    }

    protected static void a(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (!a(str, str2, outputSettings)) {
            appendable.append("=\"");
            Entities.a(appendable, b.b(str2), outputSettings, true, false, false);
            appendable.append('\"');
        }
    }

    protected static boolean a(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.e() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && b(str)));
    }

    protected static boolean b(String str) {
        return Arrays.binarySearch(f33651b, str) >= 0;
    }

    /* renamed from: a */
    public String getKey() {
        return this.f33653c;
    }

    /* renamed from: a */
    public String setValue(String str) {
        String str2 = this.f33654d;
        b bVar = this.f33652a;
        if (bVar != null) {
            str2 = bVar.c(this.f33653c);
            int a2 = this.f33652a.a(this.f33653c);
            if (a2 != -1) {
                this.f33652a.f33657b[a2] = str;
            }
        }
        this.f33654d = str;
        return b.b(str2);
    }

    /* access modifiers changed from: protected */
    public void a(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        a(this.f33653c, this.f33654d, appendable, outputSettings);
    }

    /* renamed from: b */
    public String getValue() {
        return b.b(this.f33654d);
    }

    public String c() {
        StringBuilder a2 = oh.c.a();
        try {
            a(a2, new Document("").j());
            return oh.c.a(a2);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    /* renamed from: d */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f33653c;
        if (str == null ? aVar.f33653c != null : !str.equals(aVar.f33653c)) {
            return false;
        }
        String str2 = this.f33654d;
        String str3 = aVar.f33654d;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f33653c;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f33654d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return c();
    }
}
