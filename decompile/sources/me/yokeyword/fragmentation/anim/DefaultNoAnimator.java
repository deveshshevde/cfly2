package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;

public class DefaultNoAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultNoAnimator> CREATOR = new Parcelable.Creator<DefaultNoAnimator>() {
        /* renamed from: a */
        public DefaultNoAnimator createFromParcel(Parcel parcel) {
            return new DefaultNoAnimator(parcel);
        }

        /* renamed from: a */
        public DefaultNoAnimator[] newArray(int i2) {
            return new DefaultNoAnimator[i2];
        }
    };

    public DefaultNoAnimator() {
        this.f31101a = 0;
        this.f31102b = 0;
        this.f31103c = 0;
        this.f31104d = 0;
    }

    protected DefaultNoAnimator(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
