package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3718a = (AudioAttributes) aVar.b(audioAttributesImplApi21.f3718a, 1);
        audioAttributesImplApi21.f3719b = aVar.b(audioAttributesImplApi21.f3719b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, a aVar) {
        aVar.a(false, false);
        aVar.a((Parcelable) audioAttributesImplApi21.f3718a, 1);
        aVar.a(audioAttributesImplApi21.f3719b, 2);
    }
}
