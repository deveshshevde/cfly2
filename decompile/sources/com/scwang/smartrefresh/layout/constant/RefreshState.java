package com.scwang.smartrefresh.layout.constant;

public enum RefreshState {
    None(0, false, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false, false),
    PullUpToLoad(2, true, false, false, false, false),
    PullDownCanceled(1, false, false, false, false, false),
    PullUpCanceled(2, false, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false, true),
    ReleaseToLoad(2, true, false, false, false, true),
    ReleaseToTwoLevel(1, true, false, false, true, true),
    TwoLevelReleased(1, false, false, false, true, false),
    RefreshReleased(1, false, false, false, false, false),
    LoadReleased(2, false, false, false, false, false),
    Refreshing(1, false, true, false, false, false),
    Loading(2, false, true, false, false, false),
    TwoLevel(1, false, true, false, true, false),
    RefreshFinish(1, false, false, true, false, false),
    LoadFinish(2, false, false, true, false, false),
    TwoLevelFinish(1, false, false, true, true, false);
    

    /* renamed from: r  reason: collision with root package name */
    public final boolean f12077r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f12078s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f12079t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f12080u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f12081v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f12082w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f12083x;

    private RefreshState(int i2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7 = false;
        this.f12077r = i2 == 1;
        this.f12078s = i2 == 2 ? true : z7;
        this.f12080u = z2;
        this.f12081v = z3;
        this.f12082w = z4;
        this.f12079t = z5;
        this.f12083x = z6;
    }

    public RefreshState a() {
        return (!this.f12077r || this.f12079t) ? this : values()[ordinal() + 1];
    }

    public RefreshState b() {
        return (!this.f12078s || this.f12079t) ? this : values()[ordinal() - 1];
    }
}
