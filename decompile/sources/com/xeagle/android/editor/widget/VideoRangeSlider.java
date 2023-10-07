package com.xeagle.android.editor.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.editor.widget.VideoRangeSeekBar;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.utils.y;
import jy.a;
import jz.c;

public class VideoRangeSlider extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22937a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22938b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22939c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPlayer f22940d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f22941e;

    /* renamed from: f  reason: collision with root package name */
    private VideoRangeSeekBar f22942f;

    /* renamed from: g  reason: collision with root package name */
    private c f22943g;

    /* renamed from: h  reason: collision with root package name */
    private a f22944h;

    /* renamed from: i  reason: collision with root package name */
    private long f22945i;

    public VideoRangeSlider(Context context) {
        super(context);
        a();
    }

    public VideoRangeSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public VideoRangeSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_range_slider, this);
        this.f22944h = new a();
        this.f22937a = (TextView) findViewById(R.id.tv_start_time);
        this.f22938b = (TextView) findViewById(R.id.tv_end_time);
        this.f22939c = (TextView) findViewById(R.id.tv_duration);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.video_thumbnails);
        this.f22941e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        c cVar = new c(getContext(), this.f22944h);
        this.f22943g = cVar;
        this.f22941e.setAdapter(cVar);
        this.f22942f = (VideoRangeSeekBar) findViewById(R.id.range_seek_bar);
    }

    public void a(GLImage gLImage, boolean z2) {
        if (!z2) {
            this.f22944h.a(gLImage.getPath());
        }
        long a2 = this.f22943g.a(gLImage);
        this.f22945i = a2;
        setEndTime(a2);
        setDuration(this.f22945i);
    }

    public int getLeftIndex() {
        return this.f22942f.getLeftIndex();
    }

    public int getRightIndex() {
        return this.f22942f.getRightIndex();
    }

    public long getTotalTime() {
        return this.f22945i;
    }

    public void setDataSource(String str) {
        this.f22944h.a(str);
        long a2 = this.f22943g.a();
        this.f22945i = a2;
        setEndTime(a2);
        setDuration(this.f22945i);
    }

    public void setDuration(long j2) {
        this.f22939c.setText(y.c(j2));
    }

    public void setEndTime(long j2) {
        this.f22938b.setText(y.c(j2));
    }

    public void setFrameProgress(float f2) {
        this.f22942f.a((int) (f2 * 100.0f));
    }

    public void setLeftIndex(int i2) {
        this.f22942f.c((int) this.f22942f.d(i2));
    }

    public void setOnRangeSeekBarChangeListener(VideoRangeSeekBar.a aVar) {
        this.f22942f.setOnRangeChangeListener(aVar);
    }

    public void setProgressThumbVisible(boolean z2) {
        this.f22942f.setProgressThumbVisible(z2);
    }

    public void setRightIndex(int i2) {
        this.f22942f.b(i2);
    }

    public void setStartTime(long j2) {
        this.f22937a.setText(y.c(j2));
    }

    public void setVideoView(MediaPlayer mediaPlayer) {
        this.f22940d = mediaPlayer;
    }
}
