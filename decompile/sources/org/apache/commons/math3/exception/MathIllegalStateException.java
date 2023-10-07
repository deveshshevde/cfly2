package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathIllegalStateException extends IllegalStateException {
    private static final long serialVersionUID = -6024911025449780478L;

    /* renamed from: a  reason: collision with root package name */
    private final ExceptionContext f32528a;

    public MathIllegalStateException() {
        this(LocalizedFormats.ILLEGAL_STATE, new Object[0]);
    }

    public MathIllegalStateException(Localizable localizable, Object... objArr) {
        ExceptionContext exceptionContext = new ExceptionContext(this);
        this.f32528a = exceptionContext;
        exceptionContext.a(localizable, objArr);
    }

    public ExceptionContext a() {
        return this.f32528a;
    }

    public String getLocalizedMessage() {
        return this.f32528a.b();
    }

    public String getMessage() {
        return this.f32528a.a();
    }
}
