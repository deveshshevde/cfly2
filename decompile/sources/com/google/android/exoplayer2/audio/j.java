package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class j implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    protected AudioProcessor.a f15322b = AudioProcessor.a.f15195a;

    /* renamed from: c  reason: collision with root package name */
    protected AudioProcessor.a f15323c = AudioProcessor.a.f15195a;

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.a f15324d = AudioProcessor.a.f15195a;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.a f15325e = AudioProcessor.a.f15195a;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f15326f = f15194a;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f15327g = f15194a;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15328h;

    public final AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.f15324d = aVar;
        this.f15325e = b(aVar);
        return a() ? this.f15325e : AudioProcessor.a.f15195a;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer a(int i2) {
        if (this.f15326f.capacity() < i2) {
            this.f15326f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f15326f.clear();
        }
        ByteBuffer byteBuffer = this.f15326f;
        this.f15327g = byteBuffer;
        return byteBuffer;
    }

    public boolean a() {
        return this.f15325e != AudioProcessor.a.f15195a;
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.a b(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.a.f15195a;
    }

    public final void b() {
        this.f15328h = true;
        h();
    }

    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f15327g;
        this.f15327g = f15194a;
        return byteBuffer;
    }

    public boolean d() {
        return this.f15328h && this.f15327g == f15194a;
    }

    public final void e() {
        this.f15327g = f15194a;
        this.f15328h = false;
        this.f15322b = this.f15324d;
        this.f15323c = this.f15325e;
        i();
    }

    public final void f() {
        e();
        this.f15326f = f15194a;
        this.f15324d = AudioProcessor.a.f15195a;
        this.f15325e = AudioProcessor.a.f15195a;
        this.f15322b = AudioProcessor.a.f15195a;
        this.f15323c = AudioProcessor.a.f15195a;
        j();
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        return this.f15327g.hasRemaining();
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }
}
