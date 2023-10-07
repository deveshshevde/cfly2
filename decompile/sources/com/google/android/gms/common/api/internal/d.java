package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.m;

public class d {

    public static abstract class a<R extends g, A extends a.b> extends BasePendingResult<R> implements b<R> {
        private final com.google.android.gms.common.api.a<?> mApi;
        private final a.c<A> mClientKey;

        @Deprecated
        protected a(a.c<A> cVar, com.google.android.gms.common.api.d dVar) {
            super((com.google.android.gms.common.api.d) m.a(dVar, (Object) "GoogleApiClient must not be null"));
            this.mClientKey = (a.c) m.a(cVar);
            this.mApi = null;
        }

        protected a(com.google.android.gms.common.api.a<?> aVar, com.google.android.gms.common.api.d dVar) {
            super((com.google.android.gms.common.api.d) m.a(dVar, (Object) "GoogleApiClient must not be null"));
            m.a(aVar, (Object) "Api must not be null");
            this.mClientKey = aVar.b();
            this.mApi = aVar;
        }

        protected a(BasePendingResult.a<R> aVar) {
            super(aVar);
            this.mClientKey = new a.c<>();
            this.mApi = null;
        }

        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        /* access modifiers changed from: protected */
        public abstract void doExecute(A a2) throws RemoteException;

        public final com.google.android.gms.common.api.a<?> getApi() {
            return this.mApi;
        }

        public final a.c<A> getClientKey() {
            return this.mClientKey;
        }

        /* access modifiers changed from: protected */
        public void onSetFailedResult(R r2) {
        }

        public final void run(A a2) throws DeadObjectException {
            try {
                doExecute(a2);
            } catch (DeadObjectException e2) {
                setFailedResult((RemoteException) e2);
                throw e2;
            } catch (RemoteException e3) {
                setFailedResult(e3);
            }
        }

        public final void setFailedResult(Status status) {
            m.a(!status.e(), (Object) "Failed result must not be success");
            g createFailedResult = createFailedResult(status);
            setResult(createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((g) obj);
        }
    }

    public interface b<R> {
        void setResult(R r2);
    }
}
