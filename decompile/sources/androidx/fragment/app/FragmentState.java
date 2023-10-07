package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: a */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final String f3260a;

    /* renamed from: b  reason: collision with root package name */
    final String f3261b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f3262c;

    /* renamed from: d  reason: collision with root package name */
    final int f3263d;

    /* renamed from: e  reason: collision with root package name */
    final int f3264e;

    /* renamed from: f  reason: collision with root package name */
    final String f3265f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f3266g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f3267h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f3268i;

    /* renamed from: j  reason: collision with root package name */
    final Bundle f3269j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f3270k;

    /* renamed from: l  reason: collision with root package name */
    final int f3271l;

    /* renamed from: m  reason: collision with root package name */
    Bundle f3272m;

    FragmentState(Parcel parcel) {
        this.f3260a = parcel.readString();
        this.f3261b = parcel.readString();
        boolean z2 = true;
        this.f3262c = parcel.readInt() != 0;
        this.f3263d = parcel.readInt();
        this.f3264e = parcel.readInt();
        this.f3265f = parcel.readString();
        this.f3266g = parcel.readInt() != 0;
        this.f3267h = parcel.readInt() != 0;
        this.f3268i = parcel.readInt() != 0;
        this.f3269j = parcel.readBundle();
        this.f3270k = parcel.readInt() == 0 ? false : z2;
        this.f3272m = parcel.readBundle();
        this.f3271l = parcel.readInt();
    }

    FragmentState(Fragment fragment) {
        this.f3260a = fragment.getClass().getName();
        this.f3261b = fragment.mWho;
        this.f3262c = fragment.mFromLayout;
        this.f3263d = fragment.mFragmentId;
        this.f3264e = fragment.mContainerId;
        this.f3265f = fragment.mTag;
        this.f3266g = fragment.mRetainInstance;
        this.f3267h = fragment.mRemoving;
        this.f3268i = fragment.mDetached;
        this.f3269j = fragment.mArguments;
        this.f3270k = fragment.mHidden;
        this.f3271l = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3260a);
        sb.append(" (");
        sb.append(this.f3261b);
        sb.append(")}:");
        if (this.f3262c) {
            sb.append(" fromLayout");
        }
        if (this.f3264e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3264e));
        }
        String str = this.f3265f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3265f);
        }
        if (this.f3266g) {
            sb.append(" retainInstance");
        }
        if (this.f3267h) {
            sb.append(" removing");
        }
        if (this.f3268i) {
            sb.append(" detached");
        }
        if (this.f3270k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3260a);
        parcel.writeString(this.f3261b);
        parcel.writeInt(this.f3262c ? 1 : 0);
        parcel.writeInt(this.f3263d);
        parcel.writeInt(this.f3264e);
        parcel.writeString(this.f3265f);
        parcel.writeInt(this.f3266g ? 1 : 0);
        parcel.writeInt(this.f3267h ? 1 : 0);
        parcel.writeInt(this.f3268i ? 1 : 0);
        parcel.writeBundle(this.f3269j);
        parcel.writeInt(this.f3270k ? 1 : 0);
        parcel.writeBundle(this.f3272m);
        parcel.writeInt(this.f3271l);
    }
}
