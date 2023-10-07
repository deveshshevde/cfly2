package androidx.media;

import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3717a = (AudioAttributesImpl) aVar.b(audioAttributesCompat.f3717a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        aVar.a(false, false);
        aVar.a((c) audioAttributesCompat.f3717a, 1);
    }
}
