package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class Lambda<R> implements Serializable, g<R> {
    private final int arity;

    public Lambda(int i2) {
        this.arity = i2;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = j.a(this);
        h.b(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
