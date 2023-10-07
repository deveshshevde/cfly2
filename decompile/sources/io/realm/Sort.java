package io.realm;

public enum Sort {
    ASCENDING(true),
    DESCENDING(false);
    

    /* renamed from: c  reason: collision with root package name */
    private final boolean f28925c;

    private Sort(boolean z2) {
        this.f28925c = z2;
    }

    public boolean a() {
        return this.f28925c;
    }
}
