package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.m;

public abstract class RemoteCreator<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f17986a;

    /* renamed from: b  reason: collision with root package name */
    private T f17987b;

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.f17986a = str;
    }

    /* access modifiers changed from: protected */
    public final T a(Context context) throws RemoteCreatorException {
        if (this.f17987b == null) {
            m.a(context);
            Context e2 = f.e(context);
            if (e2 != null) {
                try {
                    this.f17987b = a((IBinder) e2.getClassLoader().loadClass(this.f17986a).newInstance());
                } catch (ClassNotFoundException e3) {
                    throw new RemoteCreatorException("Could not load creator class.", e3);
                } catch (InstantiationException e4) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e4);
                } catch (IllegalAccessException e5) {
                    throw new RemoteCreatorException("Could not access creator.", e5);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.f17987b;
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);
}
