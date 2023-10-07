package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;

public class FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<FragmentAnimator> CREATOR = new Parcelable.Creator<FragmentAnimator>() {
        /* renamed from: a */
        public FragmentAnimator createFromParcel(Parcel parcel) {
            return new FragmentAnimator(parcel);
        }

        /* renamed from: a */
        public FragmentAnimator[] newArray(int i2) {
            return new FragmentAnimator[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected int f31101a;

    /* renamed from: b  reason: collision with root package name */
    protected int f31102b;

    /* renamed from: c  reason: collision with root package name */
    protected int f31103c;

    /* renamed from: d  reason: collision with root package name */
    protected int f31104d;

    public FragmentAnimator() {
    }

    public FragmentAnimator(int i2, int i3, int i4, int i5) {
        this.f31101a = i2;
        this.f31102b = i3;
        this.f31103c = i4;
        this.f31104d = i5;
    }

    protected FragmentAnimator(Parcel parcel) {
        this.f31101a = parcel.readInt();
        this.f31102b = parcel.readInt();
        this.f31103c = parcel.readInt();
        this.f31104d = parcel.readInt();
    }

    public FragmentAnimator a() {
        return new FragmentAnimator(b(), c(), d(), e());
    }

    public int b() {
        return this.f31101a;
    }

    public int c() {
        return this.f31102b;
    }

    public int d() {
        return this.f31103c;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f31104d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f31101a);
        parcel.writeInt(this.f31102b);
        parcel.writeInt(this.f31103c);
        parcel.writeInt(this.f31104d);
    }
}
