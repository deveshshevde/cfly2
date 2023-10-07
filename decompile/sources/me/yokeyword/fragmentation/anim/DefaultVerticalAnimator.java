package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;
import me.yokeyword.fragmentation.R;

public class DefaultVerticalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultVerticalAnimator> CREATOR = new Parcelable.Creator<DefaultVerticalAnimator>() {
        /* renamed from: a */
        public DefaultVerticalAnimator createFromParcel(Parcel parcel) {
            return new DefaultVerticalAnimator(parcel);
        }

        /* renamed from: a */
        public DefaultVerticalAnimator[] newArray(int i2) {
            return new DefaultVerticalAnimator[i2];
        }
    };

    public DefaultVerticalAnimator() {
        this.f31101a = R.anim.v_fragment_enter;
        this.f31102b = R.anim.v_fragment_exit;
        this.f31103c = R.anim.v_fragment_pop_enter;
        this.f31104d = R.anim.v_fragment_pop_exit;
    }

    protected DefaultVerticalAnimator(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
