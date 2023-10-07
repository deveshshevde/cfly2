package fw;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f28242a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<i> f28243b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<a> f28244c;

    /* renamed from: d  reason: collision with root package name */
    private a f28245d;

    /* renamed from: e  reason: collision with root package name */
    private long f28246e;

    /* renamed from: f  reason: collision with root package name */
    private long f28247f;

    private static final class a extends h implements Comparable<a> {
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f28248g;

        private a() {
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            if (isEndOfStream() != aVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j2 = this.f13101d - aVar.f13101d;
            if (j2 == 0) {
                j2 = this.f28248g - aVar.f28248g;
                if (j2 == 0) {
                    return 0;
                }
            }
            return j2 > 0 ? 1 : -1;
        }
    }

    private final class b extends i {
        private b() {
        }

        public final void release() {
            e.this.a((i) this);
        }
    }

    public e() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f28242a.add(new a());
        }
        this.f28243b = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f28243b.add(new b());
        }
        this.f28244c = new PriorityQueue<>();
    }

    private void a(a aVar) {
        aVar.clear();
        this.f28242a.add(aVar);
    }

    public void a(long j2) {
        this.f28246e = j2;
    }

    /* access modifiers changed from: protected */
    public abstract void a(h hVar);

    /* access modifiers changed from: protected */
    public void a(i iVar) {
        iVar.clear();
        this.f28243b.add(iVar);
    }

    /* renamed from: b */
    public void a(h hVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.a(hVar == this.f28245d);
        if (hVar.isDecodeOnly()) {
            a(this.f28245d);
        } else {
            a aVar = this.f28245d;
            long j2 = this.f28247f;
            this.f28247f = 1 + j2;
            long unused = aVar.f28248g = j2;
            this.f28244c.add(this.f28245d);
        }
        this.f28245d = null;
    }

    public void c() {
        this.f28247f = 0;
        this.f28246e = 0;
        while (!this.f28244c.isEmpty()) {
            a(this.f28244c.poll());
        }
        a aVar = this.f28245d;
        if (aVar != null) {
            a(aVar);
            this.f28245d = null;
        }
    }

    public void d() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    public abstract com.google.android.exoplayer2.text.e f();

    /* renamed from: g */
    public i b() throws SubtitleDecoderException {
        i pollFirst;
        if (this.f28243b.isEmpty()) {
            return null;
        }
        while (!this.f28244c.isEmpty() && this.f28244c.peek().f13101d <= this.f28246e) {
            a poll = this.f28244c.poll();
            if (poll.isEndOfStream()) {
                pollFirst = this.f28243b.pollFirst();
                pollFirst.addFlag(4);
            } else {
                a((h) poll);
                if (e()) {
                    com.google.android.exoplayer2.text.e f2 = f();
                    if (!poll.isDecodeOnly()) {
                        pollFirst = this.f28243b.pollFirst();
                        pollFirst.a(poll.f13101d, f2, Long.MAX_VALUE);
                    }
                }
                a(poll);
            }
            a(poll);
            return pollFirst;
        }
        return null;
    }

    /* renamed from: h */
    public h a() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.b(this.f28245d == null);
        if (this.f28242a.isEmpty()) {
            return null;
        }
        a pollFirst = this.f28242a.pollFirst();
        this.f28245d = pollFirst;
        return pollFirst;
    }
}
