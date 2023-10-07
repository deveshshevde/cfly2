package com.flypro.core.mission.survey.grid;

import ef.a;
import ef.c;
import eg.b;
import java.util.ArrayList;
import java.util.List;

public class CircumscribedGrid {

    /* renamed from: a  reason: collision with root package name */
    List<b> f14436a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private a f14437b;

    /* renamed from: c  reason: collision with root package name */
    private double f14438c;

    /* renamed from: d  reason: collision with root package name */
    private Double f14439d;

    public class GridWithTooManyLines extends Exception {
        private static final long serialVersionUID = 1;

        public GridWithTooManyLines() {
        }
    }

    public CircumscribedGrid(List<a> list, Double d2, Double d3) throws Exception {
        this.f14439d = d2;
        a(list);
        a(d3);
    }

    private void a(Double d2) throws GridWithTooManyLines {
        a aVar = this.f14437b;
        int i2 = 0;
        do {
            double d3 = (double) i2;
            double doubleValue = d2.doubleValue();
            Double.isNaN(d3);
            if (d3 * doubleValue < this.f14438c) {
                this.f14436a.add(new b(aVar, eg.a.a(aVar, this.f14439d.doubleValue(), this.f14438c)));
                aVar = eg.a.a(aVar, this.f14439d.doubleValue() + 90.0d, d2.doubleValue());
                i2++;
            } else {
                return;
            }
        } while (i2 <= 200);
        throw new GridWithTooManyLines();
    }

    private void a(List<a> list) {
        c cVar = new c(list);
        this.f14437b = eg.a.a(cVar.b(), this.f14439d.doubleValue() - 135.0d, cVar.a());
        this.f14438c = cVar.a() * 1.5d;
    }

    public List<b> a() {
        return this.f14436a;
    }
}
