package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

class e {

    /* renamed from: a  reason: collision with root package name */
    final Set<LiveData> f4399a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f4400b;

    e(RoomDatabase roomDatabase) {
        this.f4400b = roomDatabase;
    }
}
