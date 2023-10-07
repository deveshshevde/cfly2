package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new aj();

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<ActivityTransition> f18043a = new ai();

    /* renamed from: b  reason: collision with root package name */
    private final List<ActivityTransition> f18044b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18045c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ClientIdentity> f18046d;

    public ActivityTransitionRequest(List<ActivityTransition> list, String str, List<ClientIdentity> list2) {
        m.a(list, (Object) "transitions can't be null");
        m.a(list.size() > 0, (Object) "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(f18043a);
        for (ActivityTransition next : list) {
            m.a(treeSet.add(next), (Object) String.format("Found duplicated transition: %s.", new Object[]{next}));
        }
        this.f18044b = Collections.unmodifiableList(list);
        this.f18045c = str;
        this.f18046d = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            return l.a(this.f18044b, activityTransitionRequest.f18044b) && l.a(this.f18045c, activityTransitionRequest.f18045c) && l.a(this.f18046d, activityTransitionRequest.f18046d);
        }
    }

    public int hashCode() {
        int hashCode = this.f18044b.hashCode() * 31;
        String str = this.f18045c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f18046d;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f18044b);
        String str = this.f18045c;
        String valueOf2 = String.valueOf(this.f18046d);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 1, this.f18044b, false);
        a.a(parcel, 2, this.f18045c, false);
        a.c(parcel, 3, this.f18046d, false);
        a.a(parcel, a2);
    }
}
