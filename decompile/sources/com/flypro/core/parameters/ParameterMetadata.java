package com.flypro.core.parameters;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParameterMetadata implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f14458a;

    /* renamed from: b  reason: collision with root package name */
    private String f14459b;

    /* renamed from: c  reason: collision with root package name */
    private String f14460c;

    /* renamed from: d  reason: collision with root package name */
    private String f14461d;

    /* renamed from: e  reason: collision with root package name */
    private String f14462e;

    /* renamed from: f  reason: collision with root package name */
    private String f14463f;

    public String a() {
        return this.f14458a;
    }

    public void a(String str) {
        this.f14458a = str;
    }

    public String b() {
        return this.f14459b;
    }

    public void b(String str) {
        this.f14459b = str;
    }

    public String c() {
        return this.f14460c;
    }

    public void c(String str) {
        this.f14460c = str;
    }

    public String d() {
        return this.f14461d;
    }

    public void d(String str) {
        this.f14461d = str;
    }

    public String e() {
        return this.f14462e;
    }

    public void e(String str) {
        this.f14462e = str;
    }

    public String f() {
        return this.f14463f;
    }

    public void f(String str) {
        this.f14463f = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f14463f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g() {
        /*
            r1 = this;
            java.lang.String r0 = r1.f14460c
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0014
        L_0x000a:
            java.lang.String r0 = r1.f14463f
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.parameters.ParameterMetadata.g():boolean");
    }

    public double[] h() throws ParseException {
        DecimalFormat b2 = Parameter.b();
        String[] split = this.f14462e.split(" ");
        if (split.length == 2) {
            return new double[]{b2.parse(split[0]).doubleValue(), b2.parse(split[1]).doubleValue()};
        }
        throw new IllegalArgumentException();
    }

    public Map<Double, String> i() throws ParseException {
        DecimalFormat b2 = Parameter.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f14463f;
        if (str != null) {
            String[] split = str.split(",");
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String[] split2 = split[i2].split(":");
                if (split2.length == 2) {
                    linkedHashMap.put(Double.valueOf(b2.parse(split2[0].trim()).doubleValue()), split2[1].trim());
                    i2++;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return linkedHashMap;
    }
}
