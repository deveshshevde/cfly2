package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f360a;

    /* renamed from: b  reason: collision with root package name */
    private final float f361b;

    RatingCompat(int i2, float f2) {
        this.f360a = i2;
        this.f361b = f2;
    }

    public int describeContents() {
        return this.f360a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f360a);
        sb.append(" rating=");
        float f2 = this.f361b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f360a);
        parcel.writeFloat(this.f361b);
    }
}
