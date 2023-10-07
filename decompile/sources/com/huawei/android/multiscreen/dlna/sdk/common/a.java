package com.huawei.android.multiscreen.dlna.sdk.common;

import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f20729a;

    /* renamed from: b  reason: collision with root package name */
    private ESearchState f20730b;

    /* renamed from: c  reason: collision with root package name */
    private ESearchState f20731c;

    /* renamed from: d  reason: collision with root package name */
    private ESearchState f20732d;

    /* renamed from: e  reason: collision with root package name */
    private ESearchState f20733e;

    /* renamed from: f  reason: collision with root package name */
    private ESearchState f20734f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20735g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20736h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20737i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20738j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20739k = false;

    /* renamed from: l  reason: collision with root package name */
    private int f20740l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f20741m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f20742n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f20743o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f20744p = 0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20745q;

    /* renamed from: r  reason: collision with root package name */
    private int f20746r = 0;

    /* renamed from: s  reason: collision with root package name */
    private ReentrantLock f20747s = new ReentrantLock();

    /* renamed from: t  reason: collision with root package name */
    private ReentrantLock f20748t = new ReentrantLock();

    /* renamed from: u  reason: collision with root package name */
    private ReentrantLock f20749u = new ReentrantLock();

    /* renamed from: v  reason: collision with root package name */
    private ReentrantLock f20750v = new ReentrantLock();

    /* renamed from: w  reason: collision with root package name */
    private ReentrantLock f20751w = new ReentrantLock();

    public a(int i2) {
        this.f20729a = i2;
        this.f20730b = ESearchState.NO_SEARCH;
        this.f20733e = ESearchState.NO_SEARCH;
        this.f20732d = ESearchState.NO_SEARCH;
        this.f20731c = ESearchState.NO_SEARCH;
        this.f20734f = ESearchState.NO_SEARCH;
        this.f20745q = true;
    }

    public int a() {
        return this.f20729a;
    }
}
