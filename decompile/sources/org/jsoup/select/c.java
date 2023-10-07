package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class c {

    public static final class a extends c {
        public boolean a(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class aa extends o {
        public aa(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public String a() {
            return "nth-last-child";
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.K().w().size() - element2.C();
        }
    }

    public static class ab extends o {
        public ab(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public String a() {
            return "nth-last-of-type";
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Elements w2 = element2.K().w();
            int i2 = 0;
            for (int C = element2.C(); C < w2.size(); C++) {
                if (((Element) w2.get(C)).s().equals(element2.s())) {
                    i2++;
                }
            }
            return i2;
        }
    }

    public static class ac extends o {
        public ac(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public String a() {
            return "nth-of-type";
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Iterator it2 = element2.K().w().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3.s().equals(element2.s())) {
                    i2++;
                    continue;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i2;
        }
    }

    public static final class ad extends c {
        public boolean a(Element element, Element element2) {
            Element v2 = element2.K();
            return v2 != null && !(v2 instanceof Document) && element2.A().isEmpty();
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class ae extends c {
        public boolean a(Element element, Element element2) {
            Element v2 = element2.K();
            if (v2 == null || (v2 instanceof Document)) {
                return false;
            }
            Iterator it2 = v2.w().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((Element) it2.next()).s().equals(element2.s())) {
                    i2++;
                }
            }
            return i2 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class af extends c {
        public boolean a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.a(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class ag extends c {
        public boolean a(Element element, Element element2) {
            if (element2 instanceof org.jsoup.nodes.l) {
                return true;
            }
            for (org.jsoup.nodes.m next : element2.y()) {
                org.jsoup.nodes.l lVar = new org.jsoup.nodes.l(org.jsoup.parser.f.a(element2.q()), element2.i(), element2.p());
                next.i((org.jsoup.nodes.j) lVar);
                lVar.a((org.jsoup.nodes.j) next);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    public static final class ah extends c {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f33897a;

        public ah(Pattern pattern) {
            this.f33897a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f33897a.matcher(element2.E()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", new Object[]{this.f33897a});
        }
    }

    public static final class ai extends c {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f33898a;

        public ai(Pattern pattern) {
            this.f33898a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f33898a.matcher(element2.F()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f33898a});
        }
    }

    public static final class aj extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33899a;

        public aj(String str) {
            this.f33899a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.r().equals(this.f33899a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f33899a});
        }
    }

    public static final class ak extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33900a;

        public ak(String str) {
            this.f33900a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.r().endsWith(this.f33900a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f33900a});
        }
    }

    public static final class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33901a;

        public b(String str) {
            this.f33901a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33901a);
        }

        public String toString() {
            return String.format("[%s]", new Object[]{this.f33901a});
        }
    }

    /* renamed from: org.jsoup.select.c$c  reason: collision with other inner class name */
    public static abstract class C0247c extends c {

        /* renamed from: a  reason: collision with root package name */
        String f33902a;

        /* renamed from: b  reason: collision with root package name */
        String f33903b;

        public C0247c(String str, String str2) {
            this(str, str2, true);
        }

        public C0247c(String str, String str2, boolean z2) {
            org.jsoup.helper.c.a(str);
            org.jsoup.helper.c.a(str2);
            this.f33902a = oh.b.b(str);
            boolean z3 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z3 ? str2.substring(1, str2.length() - 1) : str2;
            this.f33903b = z2 ? oh.b.b(str2) : oh.b.a(str2, z3);
        }
    }

    public static final class d extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33904a;

        public d(String str) {
            org.jsoup.helper.c.a(str);
            this.f33904a = oh.b.a(str);
        }

        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.a a2 : element2.p().c()) {
                if (oh.b.a(a2.getKey()).startsWith(this.f33904a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", new Object[]{this.f33904a});
        }
    }

    public static final class e extends C0247c {
        public e(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33902a) && this.f33903b.equalsIgnoreCase(element2.c(this.f33902a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", new Object[]{this.f33902a, this.f33903b});
        }
    }

    public static final class f extends C0247c {
        public f(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33902a) && oh.b.a(element2.c(this.f33902a)).contains(this.f33903b);
        }

        public String toString() {
            return String.format("[%s*=%s]", new Object[]{this.f33902a, this.f33903b});
        }
    }

    public static final class g extends C0247c {
        public g(String str, String str2) {
            super(str, str2, false);
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33902a) && oh.b.a(element2.c(this.f33902a)).endsWith(this.f33903b);
        }

        public String toString() {
            return String.format("[%s$=%s]", new Object[]{this.f33902a, this.f33903b});
        }
    }

    public static final class h extends c {

        /* renamed from: a  reason: collision with root package name */
        String f33905a;

        /* renamed from: b  reason: collision with root package name */
        Pattern f33906b;

        public h(String str, Pattern pattern) {
            this.f33905a = oh.b.b(str);
            this.f33906b = pattern;
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33905a) && this.f33906b.matcher(element2.c(this.f33905a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f33905a, this.f33906b.toString()});
        }
    }

    public static final class i extends C0247c {
        public i(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return !this.f33903b.equalsIgnoreCase(element2.c(this.f33902a));
        }

        public String toString() {
            return String.format("[%s!=%s]", new Object[]{this.f33902a, this.f33903b});
        }
    }

    public static final class j extends C0247c {
        public j(String str, String str2) {
            super(str, str2, false);
        }

        public boolean a(Element element, Element element2) {
            return element2.b(this.f33902a) && oh.b.a(element2.c(this.f33902a)).startsWith(this.f33903b);
        }

        public String toString() {
            return String.format("[%s^=%s]", new Object[]{this.f33902a, this.f33903b});
        }
    }

    public static final class k extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33907a;

        public k(String str) {
            this.f33907a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.h(this.f33907a);
        }

        public String toString() {
            return String.format(".%s", new Object[]{this.f33907a});
        }
    }

    public static final class l extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33908a;

        public l(String str) {
            this.f33908a = oh.b.a(str);
        }

        public boolean a(Element element, Element element2) {
            return oh.b.a(element2.G()).contains(this.f33908a);
        }

        public String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f33908a});
        }
    }

    public static final class m extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33909a;

        public m(String str) {
            this.f33909a = oh.b.a(str);
        }

        public boolean a(Element element, Element element2) {
            return oh.b.a(element2.F()).contains(this.f33909a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f33909a});
        }
    }

    public static final class n extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33910a;

        public n(String str) {
            this.f33910a = oh.b.a(str);
        }

        public boolean a(Element element, Element element2) {
            return oh.b.a(element2.E()).contains(this.f33910a);
        }

        public String toString() {
            return String.format(":contains(%s)", new Object[]{this.f33910a});
        }
    }

    public static abstract class o extends c {

        /* renamed from: a  reason: collision with root package name */
        protected final int f33911a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f33912b;

        public o(int i2, int i3) {
            this.f33911a = i2;
            this.f33912b = i3;
        }

        /* access modifiers changed from: protected */
        public abstract String a();

        public boolean a(Element element, Element element2) {
            Element v2 = element2.K();
            if (v2 == null || (v2 instanceof Document)) {
                return false;
            }
            int b2 = b(element, element2);
            int i2 = this.f33911a;
            if (i2 == 0) {
                return b2 == this.f33912b;
            }
            int i3 = this.f33912b;
            return (b2 - i3) * i2 >= 0 && (b2 - i3) % i2 == 0;
        }

        /* access modifiers changed from: protected */
        public abstract int b(Element element, Element element2);

        public String toString() {
            if (this.f33911a == 0) {
                return String.format(":%s(%d)", new Object[]{a(), Integer.valueOf(this.f33912b)});
            } else if (this.f33912b == 0) {
                return String.format(":%s(%dn)", new Object[]{a(), Integer.valueOf(this.f33911a)});
            } else {
                return String.format(":%s(%dn%+d)", new Object[]{a(), Integer.valueOf(this.f33911a), Integer.valueOf(this.f33912b)});
            }
        }
    }

    public static final class p extends c {

        /* renamed from: a  reason: collision with root package name */
        private String f33913a;

        public p(String str) {
            this.f33913a = str;
        }

        public boolean a(Element element, Element element2) {
            return this.f33913a.equals(element2.u());
        }

        public String toString() {
            return String.format("#%s", new Object[]{this.f33913a});
        }
    }

    public static final class q extends r {
        public q(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.C() == this.f33914a;
        }

        public String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.f33914a)});
        }
    }

    public static abstract class r extends c {

        /* renamed from: a  reason: collision with root package name */
        int f33914a;

        public r(int i2) {
            this.f33914a = i2;
        }
    }

    public static final class s extends r {
        public s(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.C() > this.f33914a;
        }

        public String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.f33914a)});
        }
    }

    public static final class t extends r {
        public t(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element != element2 && element2.C() < this.f33914a;
        }

        public String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.f33914a)});
        }
    }

    public static final class u extends c {
        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.j next : element2.M()) {
                if (!(next instanceof org.jsoup.nodes.d) && !(next instanceof org.jsoup.nodes.n) && !(next instanceof org.jsoup.nodes.f)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class v extends c {
        public boolean a(Element element, Element element2) {
            Element v2 = element2.K();
            return v2 != null && !(v2 instanceof Document) && element2.C() == 0;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class w extends ac {
        public w() {
            super(0, 1);
        }

        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class x extends c {
        public boolean a(Element element, Element element2) {
            Element v2 = element2.K();
            return v2 != null && !(v2 instanceof Document) && element2.C() == v2.w().size() - 1;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class y extends ab {
        public y() {
            super(0, 1);
        }

        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class z extends o {
        public z(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public String a() {
            return "nth-child";
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.C() + 1;
        }
    }

    protected c() {
    }

    public abstract boolean a(Element element, Element element2);
}
