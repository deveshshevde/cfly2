package com.xeagle.android.widgets.adapterViews;

import com.flypro.core.parameters.Parameter;
import com.flypro.core.parameters.ParameterMetadata;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;

public class ParamsAdapterItem implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final DecimalFormat f25690a = Parameter.b();

    /* renamed from: b  reason: collision with root package name */
    private final Parameter f25691b;

    /* renamed from: c  reason: collision with root package name */
    private ParameterMetadata f25692c;

    /* renamed from: d  reason: collision with root package name */
    private String f25693d;

    /* renamed from: e  reason: collision with root package name */
    private Validation f25694e;

    public enum Validation {
        NA,
        INVALID,
        VALID
    }

    public ParamsAdapterItem(Parameter parameter, ParameterMetadata parameterMetadata) {
        this.f25691b = parameter;
        this.f25692c = parameterMetadata;
    }

    private Validation b(String str) {
        ParameterMetadata parameterMetadata = this.f25692c;
        return parameterMetadata == null ? Validation.NA : parameterMetadata.e() != null ? c(str) : this.f25692c.f() != null ? d(str) : Validation.NA;
    }

    private Validation c(String str) {
        try {
            double doubleValue = f25690a.parse(str).doubleValue();
            double[] h2 = this.f25692c.h();
            return (doubleValue < h2[0] || doubleValue > h2[1]) ? Validation.INVALID : Validation.VALID;
        } catch (ParseException unused) {
            return Validation.NA;
        }
    }

    private Validation d(String str) {
        try {
            return this.f25692c.i().keySet().contains(Double.valueOf(f25690a.parse(str).doubleValue())) ? Validation.VALID : Validation.INVALID;
        } catch (ParseException unused) {
            return Validation.NA;
        }
    }

    public Parameter a() {
        String str = this.f25693d;
        if (str == null) {
            return this.f25691b;
        }
        try {
            return new Parameter(this.f25691b.f14455a, f25690a.parse(str).doubleValue(), this.f25691b.f14457c);
        } catch (ParseException unused) {
            return this.f25691b;
        }
    }

    public void a(ParameterMetadata parameterMetadata) {
        this.f25692c = parameterMetadata;
    }

    public void a(String str) {
        if (this.f25691b.a().equals(str)) {
            str = null;
        }
        this.f25693d = str;
        if (str != null) {
            this.f25694e = b(str);
        }
    }

    public ParameterMetadata b() {
        return this.f25692c;
    }

    public void c() {
        try {
            this.f25691b.f14456b = f25690a.parse(this.f25693d).doubleValue();
            this.f25693d = null;
        } catch (ParseException unused) {
        }
    }

    public boolean d() {
        return this.f25693d != null;
    }

    public Validation e() {
        return this.f25694e;
    }

    public String toString() {
        String str;
        Parameter a2 = a();
        if (a2 != null) {
            str = a2.f14455a + ": ";
        } else {
            str = "";
        }
        ParameterMetadata b2 = b();
        if (b2 == null) {
            return str;
        }
        return str + b2.b();
    }
}
