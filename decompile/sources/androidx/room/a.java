package androidx.room;

import ag.c;
import android.content.Context;
import androidx.room.RoomDatabase;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.C0004c f4382a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f4383b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4384c;

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase.c f4385d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RoomDatabase.b> f4386e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4387f;

    /* renamed from: g  reason: collision with root package name */
    public final RoomDatabase.JournalMode f4388g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f4389h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f4390i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f4391j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f4392k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f4393l;

    /* renamed from: m  reason: collision with root package name */
    public final String f4394m;

    /* renamed from: n  reason: collision with root package name */
    public final File f4395n;

    /* renamed from: o  reason: collision with root package name */
    private final Set<Integer> f4396o;

    public a(Context context, String str, c.C0004c cVar, RoomDatabase.c cVar2, List<RoomDatabase.b> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file) {
        this.f4382a = cVar;
        this.f4383b = context;
        this.f4384c = str;
        this.f4385d = cVar2;
        this.f4386e = list;
        this.f4387f = z2;
        this.f4388g = journalMode;
        this.f4389h = executor;
        this.f4390i = executor2;
        this.f4391j = z3;
        this.f4392k = z4;
        this.f4393l = z5;
        this.f4396o = set;
        this.f4394m = str2;
        this.f4395n = file;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f4393l) && this.f4392k && ((set = this.f4396o) == null || !set.contains(Integer.valueOf(i2)));
    }
}
