package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: a */
        public ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final c f4895a;

    protected ParcelImpl(Parcel parcel) {
        this.f4895a = new b(parcel).j();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).a(this.f4895a);
    }
}
