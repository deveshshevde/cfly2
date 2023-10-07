package com.xeagle.android.utils;

import android.os.CountDownTimer;
import com.xeagle.android.dialogs.i;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static CountDownTimer f24390a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f24391b = 60000;

    public interface a {
        void a();

        void a(long j2);
    }

    public static void a() {
        CountDownTimer countDownTimer = f24390a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public static void a(i iVar, int i2, a aVar) {
        final a aVar2 = aVar;
        final i iVar2 = iVar;
        final int i3 = i2;
        AnonymousClass1 r0 = new CountDownTimer((long) i2, 1000) {
            public void onFinish() {
                a aVar = aVar2;
                if (aVar != null) {
                    aVar.a();
                }
                iVar2.dismiss();
            }

            public void onTick(long j2) {
                a aVar = aVar2;
                if (aVar != null) {
                    aVar.a(j2);
                }
                i iVar = iVar2;
                int i2 = i3;
                iVar.a(((((long) i2) - j2) * 100) / ((long) i2));
            }
        };
        f24390a = r0;
        r0.start();
    }
}
