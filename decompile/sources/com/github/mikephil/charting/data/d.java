package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import fc.e;
import fd.a;
import fg.i;
import java.util.List;

public abstract class d<T extends Entry> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f14998a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Integer> f14999b;

    /* renamed from: c  reason: collision with root package name */
    protected a f15000c;

    /* renamed from: d  reason: collision with root package name */
    protected List<a> f15001d;

    /* renamed from: e  reason: collision with root package name */
    protected List<Integer> f15002e;

    /* renamed from: f  reason: collision with root package name */
    protected YAxis.AxisDependency f15003f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f15004g;

    /* renamed from: h  reason: collision with root package name */
    protected transient ez.d f15005h;

    /* renamed from: i  reason: collision with root package name */
    protected Typeface f15006i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f15007j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f15008k;

    /* renamed from: l  reason: collision with root package name */
    protected fg.e f15009l;

    /* renamed from: m  reason: collision with root package name */
    protected float f15010m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f15011n;

    /* renamed from: o  reason: collision with root package name */
    private Legend.LegendForm f15012o;

    /* renamed from: p  reason: collision with root package name */
    private float f15013p;

    /* renamed from: q  reason: collision with root package name */
    private float f15014q;

    /* renamed from: r  reason: collision with root package name */
    private DashPathEffect f15015r;

    public int a(int i2) {
        List<Integer> list = this.f14999b;
        return list.get(i2 % list.size()).intValue();
    }

    public void a(ez.d dVar) {
        if (dVar != null) {
            this.f15005h = dVar;
        }
    }

    public a b(int i2) {
        List<a> list = this.f15001d;
        return list.get(i2 % list.size());
    }

    public List<Integer> b() {
        return this.f14999b;
    }

    public int c() {
        return this.f14999b.get(0).intValue();
    }

    public int c(int i2) {
        List<Integer> list = this.f15002e;
        return list.get(i2 % list.size()).intValue();
    }

    public a d() {
        return this.f15000c;
    }

    public List<a> e() {
        return this.f15001d;
    }

    public String f() {
        return this.f14998a;
    }

    public boolean g() {
        return this.f15004g;
    }

    public ez.d h() {
        return i() ? i.a() : this.f15005h;
    }

    public boolean i() {
        return this.f15005h == null;
    }

    public Typeface j() {
        return this.f15006i;
    }

    public float k() {
        return this.f15010m;
    }

    public Legend.LegendForm l() {
        return this.f15012o;
    }

    public float m() {
        return this.f15013p;
    }

    public float n() {
        return this.f15014q;
    }

    public DashPathEffect o() {
        return this.f15015r;
    }

    public boolean p() {
        return this.f15007j;
    }

    public boolean q() {
        return this.f15008k;
    }

    public fg.e r() {
        return this.f15009l;
    }

    public boolean s() {
        return this.f15011n;
    }

    public YAxis.AxisDependency t() {
        return this.f15003f;
    }
}
