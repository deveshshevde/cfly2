package org.jcodec.containers.mp4;

import java.util.Arrays;
import org.jcodec.containers.mp4.boxes.s;

public enum Brand {
    MOV("qt  ", 512, new String[]{"qt  "}),
    MP4("isom", 512, new String[]{"isom", "iso2", "avc1", "mp41"});
    

    /* renamed from: c  reason: collision with root package name */
    private s f33261c;

    private Brand(String str, int i2, String[] strArr) {
        this.f33261c = new s(str, i2, Arrays.asList(strArr));
    }

    public s a() {
        return this.f33261c;
    }
}
