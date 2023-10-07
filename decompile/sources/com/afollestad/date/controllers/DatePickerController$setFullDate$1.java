package com.afollestad.date.controllers;

import java.util.Calendar;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class DatePickerController$setFullDate$1 extends Lambda implements a<Calendar> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Calendar f7381a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerController$setFullDate$1(Calendar calendar) {
        super(0);
        this.f7381a = calendar;
    }

    /* renamed from: b */
    public final Calendar e_() {
        Object clone = this.f7381a.clone();
        if (clone != null) {
            return (Calendar) clone;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }
}
