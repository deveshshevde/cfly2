package org.apache.commons.math3.exception.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;

    /* renamed from: a  reason: collision with root package name */
    private Throwable f32537a;

    /* renamed from: b  reason: collision with root package name */
    private List<Localizable> f32538b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<Object[]> f32539c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f32540d = new HashMap();

    public ExceptionContext(Throwable th) {
        this.f32537a = th;
    }

    private String a(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        int size = this.f32538b.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            sb.append(new MessageFormat(this.f32538b.get(i3).a(locale), locale).format(this.f32539c.get(i3)));
            i2++;
            if (i2 < size) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public String a() {
        return a(Locale.US);
    }

    public String a(Locale locale) {
        return a(locale, ": ");
    }

    public void a(Localizable localizable, Object... objArr) {
        this.f32538b.add(localizable);
        this.f32539c.add(a.a(objArr));
    }

    public String b() {
        return a(Locale.getDefault());
    }
}
