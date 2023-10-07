package com.bumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f10533f;

        private RequestState(boolean z2) {
            this.f10533f = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f10533f;
        }
    }

    boolean b(e eVar);

    boolean c(e eVar);

    boolean d(e eVar);

    void e(e eVar);

    void f(e eVar);

    boolean g();

    RequestCoordinator h();
}
