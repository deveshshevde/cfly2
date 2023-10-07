package io.realm.internal;

import io.realm.j;
import java.util.Set;

public abstract class i {
    public abstract Set<Class<? extends j>> a();

    public boolean b() {
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        return a().equals(((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }
}
