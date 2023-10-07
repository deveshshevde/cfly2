package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f15277a = new d(new int[]{2}, 8);

    /* renamed from: b  reason: collision with root package name */
    private static final d f15278b = new d(new int[]{2, 5, 6}, 8);

    /* renamed from: c  reason: collision with root package name */
    private final int[] f15279c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15280d;

    public d(int[] iArr, int i2) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f15279c = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f15279c = new int[0];
        }
        this.f15280d = i2;
    }

    public static d a(Context context) {
        return a(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static d a(Context context, Intent intent) {
        return (!b() || Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) != 1) ? (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f15277a : new d(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : f15278b;
    }

    private static boolean b() {
        return ad.f11755a >= 17 && "Amazon".equals(ad.f11757c);
    }

    public int a() {
        return this.f15280d;
    }

    public boolean a(int i2) {
        return Arrays.binarySearch(this.f15279c, i2) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Arrays.equals(this.f15279c, dVar.f15279c) && this.f15280d == dVar.f15280d;
    }

    public int hashCode() {
        return this.f15280d + (Arrays.hashCode(this.f15279c) * 31);
    }

    public String toString() {
        int i2 = this.f15280d;
        String arrays = Arrays.toString(this.f15279c);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i2);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
