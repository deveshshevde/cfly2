package com.google.android.gms.tagmanager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

final class zzcc extends Thread {
    private final LinkedBlockingQueue<Runnable> zzb;
    private volatile boolean zzc;
    private volatile boolean zzd;

    public final void run() {
        while (true) {
            try {
                Runnable take = this.zzb.take();
                if (!this.zzc) {
                    take.run();
                }
            } catch (InterruptedException e2) {
                try {
                    zzdh.zzb.zzb(e2.toString());
                } catch (Exception e3) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    e3.printStackTrace(printStream);
                    printStream.flush();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    zzdh.zza(str.length() != 0 ? "Error on Google TagManager Thread: ".concat(str) : new String("Error on Google TagManager Thread: "));
                    zzdh.zza("Google TagManager is shutting down.");
                    this.zzc = true;
                }
            }
        }
    }

    public final void zze(Runnable runnable) {
        this.zzb.add(runnable);
    }
}
