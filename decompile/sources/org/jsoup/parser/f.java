package org.jsoup.parser;

import com.amap.api.mapcore.util.dt;
import com.autonavi.base.amap.mapcore.AeUtil;
import java.util.HashMap;
import java.util.Map;
import oh.b;
import org.jsoup.helper.c;

public class f implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, f> f33834a = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f33835k;

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f33836l = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", AeUtil.ROOT_DATA_PATH_OLD_NAME, "bdi", "s"};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f33837m = {"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f33838n = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};

    /* renamed from: o  reason: collision with root package name */
    private static final String[] f33839o = {"pre", "plaintext", "title", "textarea"};

    /* renamed from: p  reason: collision with root package name */
    private static final String[] f33840p = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};

    /* renamed from: q  reason: collision with root package name */
    private static final String[] f33841q = {"input", "keygen", "object", "select", "textarea"};

    /* renamed from: b  reason: collision with root package name */
    private String f33842b;

    /* renamed from: c  reason: collision with root package name */
    private String f33843c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33844d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33845e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33846f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33847g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f33848h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f33849i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f33850j = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", dt.f8292a, "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center"};
        f33835k = strArr;
        for (String fVar : strArr) {
            a(new f(fVar));
        }
        for (String fVar2 : f33836l) {
            f fVar3 = new f(fVar2);
            fVar3.f33844d = false;
            fVar3.f33845e = false;
            a(fVar3);
        }
        for (String str : f33837m) {
            f fVar4 = f33834a.get(str);
            c.a((Object) fVar4);
            fVar4.f33846f = true;
        }
        for (String str2 : f33838n) {
            f fVar5 = f33834a.get(str2);
            c.a((Object) fVar5);
            fVar5.f33845e = false;
        }
        for (String str3 : f33839o) {
            f fVar6 = f33834a.get(str3);
            c.a((Object) fVar6);
            fVar6.f33848h = true;
        }
        for (String str4 : f33840p) {
            f fVar7 = f33834a.get(str4);
            c.a((Object) fVar7);
            fVar7.f33849i = true;
        }
        for (String str5 : f33841q) {
            f fVar8 = f33834a.get(str5);
            c.a((Object) fVar8);
            fVar8.f33850j = true;
        }
    }

    private f(String str) {
        this.f33842b = str;
        this.f33843c = b.a(str);
    }

    public static f a(String str) {
        return a(str, d.f33828b);
    }

    public static f a(String str, d dVar) {
        c.a((Object) str);
        Map<String, f> map = f33834a;
        f fVar = map.get(str);
        if (fVar != null) {
            return fVar;
        }
        String a2 = dVar.a(str);
        c.a(a2);
        String a3 = b.a(a2);
        f fVar2 = map.get(a3);
        if (fVar2 == null) {
            f fVar3 = new f(a2);
            fVar3.f33844d = false;
            return fVar3;
        } else if (!dVar.a() || a2.equals(a3)) {
            return fVar2;
        } else {
            f l2 = fVar2.clone();
            l2.f33842b = a2;
            return l2;
        }
    }

    private static void a(f fVar) {
        f33834a.put(fVar.f33842b, fVar);
    }

    public String a() {
        return this.f33842b;
    }

    public String b() {
        return this.f33843c;
    }

    public boolean c() {
        return this.f33844d;
    }

    public boolean d() {
        return this.f33845e;
    }

    public boolean e() {
        return !this.f33844d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f33842b.equals(fVar.f33842b) && this.f33846f == fVar.f33846f && this.f33845e == fVar.f33845e && this.f33844d == fVar.f33844d && this.f33848h == fVar.f33848h && this.f33847g == fVar.f33847g && this.f33849i == fVar.f33849i && this.f33850j == fVar.f33850j;
    }

    public boolean f() {
        return this.f33846f;
    }

    public boolean g() {
        return this.f33846f || this.f33847g;
    }

    public boolean h() {
        return f33834a.containsKey(this.f33842b);
    }

    public int hashCode() {
        return (((((((((((((this.f33842b.hashCode() * 31) + (this.f33844d ? 1 : 0)) * 31) + (this.f33845e ? 1 : 0)) * 31) + (this.f33846f ? 1 : 0)) * 31) + (this.f33847g ? 1 : 0)) * 31) + (this.f33848h ? 1 : 0)) * 31) + (this.f33849i ? 1 : 0)) * 31) + (this.f33850j ? 1 : 0);
    }

    public boolean i() {
        return this.f33848h;
    }

    public boolean j() {
        return this.f33849i;
    }

    /* access modifiers changed from: package-private */
    public f k() {
        this.f33847g = true;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public f clone() {
        try {
            return (f) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.f33842b;
    }
}
