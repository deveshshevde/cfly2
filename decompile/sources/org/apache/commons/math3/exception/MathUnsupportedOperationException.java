package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathUnsupportedOperationException extends UnsupportedOperationException {
    private static final long serialVersionUID = -6024911025449780478L;

    /* renamed from: a  reason: collision with root package name */
    private final ExceptionContext f32529a;

    public MathUnsupportedOperationException() {
        this(LocalizedFormats.UNSUPPORTED_OPERATION, new Object[0]);
    }

    public MathUnsupportedOperationException(Localizable localizable, Object... objArr) {
        ExceptionContext exceptionContext = new ExceptionContext(this);
        this.f32529a = exceptionContext;
        exceptionContext.a(localizable, objArr);
    }

    public String getLocalizedMessage() {
        return this.f32529a.b();
    }

    public String getMessage() {
        return this.f32529a.a();
    }
}
