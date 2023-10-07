package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NumberIsTooSmallException extends MathIllegalNumberException {
    private static final long serialVersionUID = -6100997100383932834L;

    /* renamed from: a  reason: collision with root package name */
    private final Number f32533a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32534b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NumberIsTooSmallException(Number number, Number number2, boolean z2) {
        this(z2 ? LocalizedFormats.NUMBER_TOO_SMALL : LocalizedFormats.NUMBER_TOO_SMALL_BOUND_EXCLUDED, number, number2, z2);
    }

    public NumberIsTooSmallException(Localizable localizable, Number number, Number number2, boolean z2) {
        super(localizable, number, number2);
        this.f32533a = number2;
        this.f32534b = z2;
    }
}
