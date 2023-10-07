package com.flypro.core.gcs.follow;

import android.content.Context;
import aq.d;
import ej.c;
import en.a;
import fg.i;

public abstract class FollowAlgorithm {

    /* renamed from: a  reason: collision with root package name */
    protected Context f14418a;

    /* renamed from: b  reason: collision with root package name */
    protected a f14419b;

    /* renamed from: c  reason: collision with root package name */
    protected c f14420c;

    /* renamed from: com.flypro.core.gcs.follow.FollowAlgorithm$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14421a;

        static {
            int[] iArr = new int[FollowModes.values().length];
            f14421a = iArr;
            try {
                iArr[FollowModes.RELATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum FollowModes {
        RELATE("Relate");
        

        /* renamed from: b  reason: collision with root package name */
        private String f14424b;

        private FollowModes(String str) {
            this.f14424b = str;
        }

        public FollowAlgorithm a(a aVar, Context context) {
            d.a(context.getApplicationContext());
            if (AnonymousClass1.f14421a[ordinal()] != 1) {
                return null;
            }
            d.a("follow_type_key", "Relate");
            return new a(context, aVar, new c(5.0d));
        }

        public String toString() {
            return this.f14424b;
        }
    }

    public FollowAlgorithm(Context context, a aVar, c cVar) {
        this.f14419b = aVar;
        this.f14420c = cVar;
        this.f14418a = context;
    }

    public abstract FollowModes a();

    public abstract void a(ed.a aVar);

    public void a(Double d2) {
        this.f14420c = new c(Math.max(i.f27244a, d2.doubleValue()));
    }
}
