package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f4343a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f4344b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<c> f4345c = new RemoteCallbackList<c>() {
        /* renamed from: a */
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.f4344b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final d.a f4346d = new d.a() {
        public int a(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4345c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.f4343a + 1;
                multiInstanceInvalidationService.f4343a = i2;
                if (MultiInstanceInvalidationService.this.f4345c.register(cVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f4344b.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4343a--;
                return 0;
            }
        }

        public void a(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4345c) {
                String str = MultiInstanceInvalidationService.this.f4344b.get(Integer.valueOf(i2));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f4345c.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f4345c.getBroadcastCookie(i3)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f4344b.get(Integer.valueOf(intValue));
                        if (i2 != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.f4345c.getBroadcastItem(i3).a(strArr);
                        }
                    } catch (RemoteException e2) {
                        Log.w("ROOM", "Error invoking a remote callback", e2);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f4345c.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f4345c.finishBroadcast();
            }
        }

        public void a(c cVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f4345c) {
                MultiInstanceInvalidationService.this.f4345c.unregister(cVar);
                MultiInstanceInvalidationService.this.f4344b.remove(Integer.valueOf(i2));
            }
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f4346d;
    }
}
