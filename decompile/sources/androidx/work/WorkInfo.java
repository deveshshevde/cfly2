package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {

    /* renamed from: a  reason: collision with root package name */
    private UUID f5071a;

    /* renamed from: b  reason: collision with root package name */
    private State f5072b;

    /* renamed from: c  reason: collision with root package name */
    private d f5073c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f5074d;

    /* renamed from: e  reason: collision with root package name */
    private d f5075e;

    /* renamed from: f  reason: collision with root package name */
    private int f5076f;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(UUID uuid, State state, d dVar, List<String> list, d dVar2, int i2) {
        this.f5071a = uuid;
        this.f5072b = state;
        this.f5073c = dVar;
        this.f5074d = new HashSet(list);
        this.f5075e = dVar2;
        this.f5076f = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f5076f == workInfo.f5076f && this.f5071a.equals(workInfo.f5071a) && this.f5072b == workInfo.f5072b && this.f5073c.equals(workInfo.f5073c) && this.f5074d.equals(workInfo.f5074d)) {
            return this.f5075e.equals(workInfo.f5075e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f5071a.hashCode() * 31) + this.f5072b.hashCode()) * 31) + this.f5073c.hashCode()) * 31) + this.f5074d.hashCode()) * 31) + this.f5075e.hashCode()) * 31) + this.f5076f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f5071a + '\'' + ", mState=" + this.f5072b + ", mOutputData=" + this.f5073c + ", mTags=" + this.f5074d + ", mProgress=" + this.f5075e + '}';
    }
}
