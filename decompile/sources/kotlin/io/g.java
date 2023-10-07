package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.h;
import mt.b;

final class g implements b<String> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f30222a;

    public static final class a implements Iterator<String>, mn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f30223a;

        /* renamed from: b  reason: collision with root package name */
        private String f30224b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f30225c;

        a(g gVar) {
            this.f30223a = gVar;
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f30224b;
                this.f30224b = null;
                h.a((Object) str);
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f30224b == null && !this.f30225c) {
                String readLine = this.f30223a.f30222a.readLine();
                this.f30224b = readLine;
                if (readLine == null) {
                    this.f30225c = true;
                }
            }
            return this.f30224b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(BufferedReader bufferedReader) {
        h.d(bufferedReader, "reader");
        this.f30222a = bufferedReader;
    }

    public Iterator<String> a() {
        return new a(this);
    }
}
