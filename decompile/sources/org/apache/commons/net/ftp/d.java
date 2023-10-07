package org.apache.commons.net.ftp;

import com.amap.api.maps.AMap;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class d {

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Object> f32857i;

    /* renamed from: a  reason: collision with root package name */
    private final String f32858a;

    /* renamed from: b  reason: collision with root package name */
    private String f32859b;

    /* renamed from: c  reason: collision with root package name */
    private String f32860c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32861d;

    /* renamed from: e  reason: collision with root package name */
    private String f32862e;

    /* renamed from: f  reason: collision with root package name */
    private String f32863f;

    /* renamed from: g  reason: collision with root package name */
    private String f32864g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f32865h;

    static {
        TreeMap treeMap = new TreeMap();
        f32857i = treeMap;
        treeMap.put(AMap.ENGLISH, Locale.ENGLISH);
        treeMap.put("de", Locale.GERMAN);
        treeMap.put("it", Locale.ITALIAN);
        treeMap.put("es", new Locale("es", "", ""));
        treeMap.put("pt", new Locale("pt", "", ""));
        treeMap.put("da", new Locale("da", "", ""));
        treeMap.put("sv", new Locale("sv", "", ""));
        treeMap.put("no", new Locale("no", "", ""));
        treeMap.put("nl", new Locale("nl", "", ""));
        treeMap.put("ro", new Locale("ro", "", ""));
        treeMap.put("sq", new Locale("sq", "", ""));
        treeMap.put("sh", new Locale("sh", "", ""));
        treeMap.put("sk", new Locale("sk", "", ""));
        treeMap.put("sl", new Locale("sl", "", ""));
        treeMap.put("fr", "jan|fév|mar|avr|mai|jun|jui|aoû|sep|oct|nov|déc");
    }

    public d() {
        this("UNIX");
    }

    public d(String str) {
        this.f32861d = true;
        this.f32858a = str;
    }

    public d(String str, String str2, String str3) {
        this(str);
        this.f32859b = str2;
        this.f32860c = str3;
    }

    d(String str, d dVar) {
        this.f32861d = true;
        this.f32858a = str;
        this.f32859b = dVar.f32859b;
        this.f32861d = dVar.f32861d;
        this.f32860c = dVar.f32860c;
        this.f32865h = dVar.f32865h;
        this.f32862e = dVar.f32862e;
        this.f32864g = dVar.f32864g;
        this.f32863f = dVar.f32863f;
    }

    public d(d dVar) {
        this.f32861d = true;
        this.f32858a = dVar.f32858a;
        this.f32859b = dVar.f32859b;
        this.f32861d = dVar.f32861d;
        this.f32860c = dVar.f32860c;
        this.f32865h = dVar.f32865h;
        this.f32862e = dVar.f32862e;
        this.f32864g = dVar.f32864g;
        this.f32863f = dVar.f32863f;
    }

    public static DateFormatSymbols c(String str) {
        Object obj = f32857i.get(str);
        if (obj != null) {
            if (obj instanceof Locale) {
                return new DateFormatSymbols((Locale) obj);
            }
            if (obj instanceof String) {
                return d((String) obj);
            }
        }
        return new DateFormatSymbols(Locale.US);
    }

    public static DateFormatSymbols d(String str) {
        String[] e2 = e(str);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.US);
        dateFormatSymbols.setShortMonths(e2);
        return dateFormatSymbols;
    }

    private static String[] e(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        if (12 == stringTokenizer.countTokens()) {
            String[] strArr = new String[13];
            int i2 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                strArr[i2] = stringTokenizer.nextToken();
                i2++;
            }
            strArr[i2] = "";
            return strArr;
        }
        throw new IllegalArgumentException("expecting a pipe-delimited string containing 12 tokens");
    }

    public String a() {
        return this.f32858a;
    }

    public void a(String str) {
        this.f32859b = str;
    }

    public String b() {
        return this.f32859b;
    }

    public void b(String str) {
        this.f32860c = str;
    }

    public String c() {
        return this.f32860c;
    }

    public String d() {
        return this.f32864g;
    }

    public String e() {
        return this.f32863f;
    }

    public String f() {
        return this.f32862e;
    }

    public boolean g() {
        return this.f32861d;
    }

    public boolean h() {
        return this.f32865h;
    }
}
