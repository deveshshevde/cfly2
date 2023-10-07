package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new ak();

    /* renamed from: a  reason: collision with root package name */
    private final List<ActivityTransitionEvent> f18047a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f18048b;

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        this.f18048b = null;
        m.a(list, (Object) "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                m.a(list.get(i2).c() >= list.get(i2 + -1).c());
            }
        }
        this.f18047a = Collections.unmodifiableList(list);
    }

    public ActivityTransitionResult(List<ActivityTransitionEvent> list, Bundle bundle) {
        this(list);
        this.f18048b = bundle;
    }

    public List<ActivityTransitionEvent> a() {
        return this.f18047a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f18047a.equals(((ActivityTransitionResult) obj).f18047a);
    }

    public int hashCode() {
        return this.f18047a.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 1, a(), false);
        a.a(parcel, 2, this.f18048b, false);
        a.a(parcel, a2);
    }
}
