package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

public class MathIllegalNumberException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7447085893598031110L;

    /* renamed from: a  reason: collision with root package name */
    private final Number f32527a;

    protected MathIllegalNumberException(Localizable localizable, Number number, Object... objArr) {
        super(localizable, number, objArr);
        this.f32527a = number;
    }
}
