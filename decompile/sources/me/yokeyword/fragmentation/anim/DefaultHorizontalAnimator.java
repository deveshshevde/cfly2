package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;
import me.yokeyword.fragmentation.R;

public class DefaultHorizontalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultHorizontalAnimator> CREATOR = new Parcelable.Creator<DefaultHorizontalAnimator>() {
        /* renamed from: a */
        public DefaultHorizontalAnimator createFromParcel(Parcel parcel) {
            return new DefaultHorizontalAnimator(parcel);
        }

        /* renamed from: a */
        public DefaultHorizontalAnimator[] newArray(int i2) {
            return new DefaultHorizontalAnimator[i2];
        }
    };

    public DefaultHorizontalAnimator() {
        this.f31101a = R.anim.h_fragment_enter;
        this.f31102b = R.anim.h_fragment_exit;
        this.f31103c = R.anim.h_fragment_pop_enter;
        this.f31104d = R.anim.h_fragment_pop_exit;
    }

    protected DefaultHorizontalAnimator(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
