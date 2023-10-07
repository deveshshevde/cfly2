package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f3718a;

    /* renamed from: b  reason: collision with root package name */
    public int f3719b = -1;

    AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f3718a.equals(((AudioAttributesImplApi21) obj).f3718a);
    }

    public int hashCode() {
        return this.f3718a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3718a;
    }
}
