package androidx.media;

import androidx.versionedparcelable.a;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3720a = aVar.b(audioAttributesImplBase.f3720a, 1);
        audioAttributesImplBase.f3721b = aVar.b(audioAttributesImplBase.f3721b, 2);
        audioAttributesImplBase.f3722c = aVar.b(audioAttributesImplBase.f3722c, 3);
        audioAttributesImplBase.f3723d = aVar.b(audioAttributesImplBase.f3723d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.a(false, false);
        aVar.a(audioAttributesImplBase.f3720a, 1);
        aVar.a(audioAttributesImplBase.f3721b, 2);
        aVar.a(audioAttributesImplBase.f3722c, 3);
        aVar.a(audioAttributesImplBase.f3723d, 4);
    }
}
