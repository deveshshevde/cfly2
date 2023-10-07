package mq;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.h;

public final class a extends mp.a {
    public Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        h.a((Object) current, "ThreadLocalRandom.current()");
        return current;
    }
}
