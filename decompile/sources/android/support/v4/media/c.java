package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

class c {
    public static void a(Object obj, Parcel parcel, int i2) {
        ((MediaMetadata) obj).writeToParcel(parcel, i2);
    }
}
