package org.apache.commons.net;

import java.util.EventObject;

public class ProtocolCommandEvent extends EventObject {
    private static final long serialVersionUID = 403743538418947240L;

    /* renamed from: a  reason: collision with root package name */
    private final int f32752a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32753b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32754c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32755d;

    public ProtocolCommandEvent(Object obj, int i2, String str) {
        super(obj);
        this.f32752a = i2;
        this.f32754c = str;
        this.f32753b = false;
        this.f32755d = null;
    }

    public ProtocolCommandEvent(Object obj, String str, String str2) {
        super(obj);
        this.f32752a = 0;
        this.f32754c = str2;
        this.f32753b = true;
        this.f32755d = str;
    }

    public String a() {
        return this.f32755d;
    }

    public String b() {
        return this.f32754c;
    }
}
