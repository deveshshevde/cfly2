package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jcodec.common.model.ChannelLabel;
import org.jcodec.containers.mp4.boxes.channel.Label;

public class b extends aq {
    private static Map<Label, ChannelLabel> A = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public static int f33377a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f33378b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f33379c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static int f33380d = 8;

    /* renamed from: e  reason: collision with root package name */
    public static int f33381e = 16;

    /* renamed from: f  reason: collision with root package name */
    public static int f33382f = 32;

    /* renamed from: g  reason: collision with root package name */
    public static int f33383g = 64;

    /* renamed from: h  reason: collision with root package name */
    public static Set<String> f33384h;

    /* renamed from: l  reason: collision with root package name */
    private static final a f33385l = new a();

    /* renamed from: z  reason: collision with root package name */
    private static Map<Label, ChannelLabel> f33386z = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private short f33387m;

    /* renamed from: n  reason: collision with root package name */
    private short f33388n;

    /* renamed from: o  reason: collision with root package name */
    private float f33389o;

    /* renamed from: p  reason: collision with root package name */
    private short f33390p;

    /* renamed from: q  reason: collision with root package name */
    private int f33391q;

    /* renamed from: r  reason: collision with root package name */
    private int f33392r;

    /* renamed from: s  reason: collision with root package name */
    private int f33393s;

    /* renamed from: t  reason: collision with root package name */
    private int f33394t;

    /* renamed from: u  reason: collision with root package name */
    private int f33395u;

    /* renamed from: v  reason: collision with root package name */
    private int f33396v;

    /* renamed from: w  reason: collision with root package name */
    private int f33397w;

    /* renamed from: x  reason: collision with root package name */
    private short f33398x;

    /* renamed from: y  reason: collision with root package name */
    private int f33399y;

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Class<? extends c>> f33400a;

        public a() {
            HashMap hashMap = new HashMap();
            this.f33400a = hashMap;
            hashMap.put(bk.a(), bk.class);
            this.f33400a.put(e.a(), e.class);
            this.f33400a.put("esds", z.class);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f33384h = hashSet;
        hashSet.add("raw ");
        f33384h.add("twos");
        f33384h.add("sowt");
        f33384h.add("fl32");
        f33384h.add("fl64");
        f33384h.add("in24");
        f33384h.add("in32");
        f33384h.add("lpcm");
        f33386z.put(Label.Left, ChannelLabel.STEREO_LEFT);
        f33386z.put(Label.Right, ChannelLabel.STEREO_RIGHT);
        f33386z.put(Label.HeadphonesLeft, ChannelLabel.STEREO_LEFT);
        f33386z.put(Label.HeadphonesRight, ChannelLabel.STEREO_RIGHT);
        f33386z.put(Label.LeftTotal, ChannelLabel.STEREO_LEFT);
        f33386z.put(Label.RightTotal, ChannelLabel.STEREO_RIGHT);
        f33386z.put(Label.LeftWide, ChannelLabel.STEREO_LEFT);
        f33386z.put(Label.RightWide, ChannelLabel.STEREO_RIGHT);
        A.put(Label.Left, ChannelLabel.FRONT_LEFT);
        A.put(Label.Right, ChannelLabel.FRONT_RIGHT);
        A.put(Label.LeftCenter, ChannelLabel.FRONT_CENTER_LEFT);
        A.put(Label.RightCenter, ChannelLabel.FRONT_CENTER_RIGHT);
        A.put(Label.Center, ChannelLabel.CENTER);
        A.put(Label.CenterSurround, ChannelLabel.REAR_CENTER);
        A.put(Label.CenterSurroundDirect, ChannelLabel.REAR_CENTER);
        A.put(Label.LeftSurround, ChannelLabel.REAR_LEFT);
        A.put(Label.LeftSurroundDirect, ChannelLabel.REAR_LEFT);
        A.put(Label.RightSurround, ChannelLabel.REAR_RIGHT);
        A.put(Label.RightSurroundDirect, ChannelLabel.REAR_RIGHT);
        A.put(Label.RearSurroundLeft, ChannelLabel.SIDE_LEFT);
        A.put(Label.RearSurroundRight, ChannelLabel.SIDE_RIGHT);
        A.put(Label.LFE2, ChannelLabel.LFE);
        A.put(Label.LFEScreen, ChannelLabel.LFE);
        A.put(Label.LeftTotal, ChannelLabel.STEREO_LEFT);
        A.put(Label.RightTotal, ChannelLabel.STEREO_RIGHT);
        A.put(Label.LeftWide, ChannelLabel.STEREO_LEFT);
        A.put(Label.RightWide, ChannelLabel.STEREO_RIGHT);
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        int i2;
        super.a(byteBuffer);
        byteBuffer.putShort(this.f33398x);
        byteBuffer.putShort(this.f33390p);
        byteBuffer.putInt(this.f33391q);
        short s2 = this.f33398x;
        if (s2 < 2) {
            byteBuffer.putShort(this.f33387m);
            if (this.f33398x == 0) {
                byteBuffer.putShort(this.f33388n);
            } else {
                byteBuffer.putShort(16);
            }
            byteBuffer.putShort((short) this.f33392r);
            byteBuffer.putShort((short) this.f33393s);
            double d2 = (double) this.f33389o;
            Double.isNaN(d2);
            byteBuffer.putInt((int) Math.round(d2 * 65536.0d));
            if (this.f33398x == 1) {
                byteBuffer.putInt(this.f33394t);
                byteBuffer.putInt(this.f33395u);
                byteBuffer.putInt(this.f33396v);
                i2 = this.f33397w;
            }
            c(byteBuffer);
        }
        if (s2 == 2) {
            byteBuffer.putShort(3);
            byteBuffer.putShort(16);
            byteBuffer.putShort(-2);
            byteBuffer.putShort(0);
            byteBuffer.putInt(65536);
            byteBuffer.putInt(72);
            byteBuffer.putLong(Double.doubleToLongBits((double) this.f33389o));
            byteBuffer.putInt(this.f33387m);
            byteBuffer.putInt(2130706432);
            byteBuffer.putInt(this.f33388n);
            byteBuffer.putInt(this.f33399y);
            byteBuffer.putInt(this.f33396v);
            i2 = this.f33394t;
        }
        c(byteBuffer);
        byteBuffer.putInt(i2);
        c(byteBuffer);
    }
}
