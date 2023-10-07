package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;

public class MathIllegalArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = -6024911025449780478L;

    /* renamed from: a  reason: collision with root package name */
    private final ExceptionContext f32526a;

    public MathIllegalArgumentException(Localizable localizable, Object... objArr) {
        ExceptionContext exceptionContext = new ExceptionContext(this);
        this.f32526a = exceptionContext;
        exceptionContext.a(localizable, objArr);
    }

    public String getLocalizedMessage() {
        return this.f32526a.b();
    }

    public String getMessage() {
        return this.f32526a.a();
    }
}
