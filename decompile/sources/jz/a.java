package jz;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.editor.database.EditorData;
import com.xeagle.android.editor.widget.VideoRangeSeekBar;
import com.xeagle.android.editor.widget.VideoRangeSlider;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kx.d;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

public class a extends RecyclerView.Adapter<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Activity f29851a;

    /* renamed from: b  reason: collision with root package name */
    private List<GLImage> f29852b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f29853c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f29854d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f29855e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f29856f;

    /* renamed from: g  reason: collision with root package name */
    private int f29857g;

    /* renamed from: jz.a$a  reason: collision with other inner class name */
    static class C0204a extends RecyclerView.v {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public VideoRangeSlider f29863a;

        public C0204a(View view) {
            super(view);
            this.f29863a = (VideoRangeSlider) view.findViewById(R.id.video_range_slider);
        }
    }

    public interface b {
        void a(int i2, int i3);

        void a(int i2, int i3, int i4, long j2, long j3);

        void a(VideoRangeSlider videoRangeSlider, int i2);

        void a(VideoRangeSlider videoRangeSlider, int i2, float f2, float f3);
    }

    public a(Activity activity, List<GLImage> list) {
        this.f29851a = activity;
        this.f29852b = list;
        this.f29854d = 0;
    }

    private C0204a a(ViewGroup viewGroup) {
        return new C0204a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editor_multi_item, viewGroup, false));
    }

    private void a(RecyclerView.v vVar, final int i2) {
        final C0204a aVar = (C0204a) vVar;
        for (int i3 = 0; i3 <= i2; i3++) {
            this.f29852b.get(i3).getDuration();
        }
        aVar.f29863a.a(this.f29852b.get(i2), new File(d.f(this.f29851a.getApplicationContext()) + this.f29852b.get(i2).getAddTime() + File.separator).exists());
        if (this.f29854d == i2) {
            if (this.f29853c != null) {
                Log.i("editor", "bindViewForBody: ======update position===" + i2);
                this.f29853c.a(aVar.f29863a, i2);
            }
            aVar.f29863a.setProgressThumbVisible(true);
        } else {
            aVar.f29863a.setProgressThumbVisible(false);
        }
        final EditorData a2 = com.xeagle.android.editor.database.a.a(this.f29852b.get(i2).getPath());
        if (a2 != null) {
            aVar.f29863a.setLeftIndex(a2.getLeftProgress());
            aVar.f29863a.setRightIndex(a2.getRightProgress());
            Log.i("editor", "bindViewForBody: ===leftPro===" + a2.getLeftProgress() + "===rightPro===" + a2.getRightProgress());
        }
        aVar.f29863a.setOnRangeSeekBarChangeListener(new VideoRangeSeekBar.a() {
            public void a() {
                if (a.this.f29853c != null && i2 != a.this.f29854d) {
                    Log.i("editor", "onClickItem: =======" + i2);
                    a.this.f29853c.a(aVar.f29863a, i2, (float) aVar.f29863a.getLeftIndex(), (float) aVar.f29863a.getRightIndex());
                    a.this.a(i2);
                }
            }

            public void a(int i2) {
                if (a.this.f29853c != null) {
                    a.this.f29853c.a(i2, i2);
                }
            }

            public void a(int i2, int i3, int i4) {
            }

            public void a(VideoRangeSeekBar videoRangeSeekBar, int i2, int i3, int i4) {
                long unused = a.this.f29855e = (long) ((((float) i3) / 100.0f) * ((float) aVar.f29863a.getTotalTime()));
                long unused2 = a.this.f29856f = (long) ((((float) i4) / 100.0f) * ((float) aVar.f29863a.getTotalTime()));
                Log.i("editor", "onRangeChange: --leftIndex==" + i3 + "---rightIndex===" + i4);
                EditorData editorData = a2;
                if (editorData != null) {
                    editorData.setLeftProgress(i3);
                    a2.setRightProgress(i4);
                    com.xeagle.android.editor.database.a.a(a2, new UpdateOrDeleteCallback() {
                        public void onFinish(int i2) {
                            Log.i("editor", "onFinish: ---path===" + a2.getPath());
                        }
                    });
                }
                if (a.this.f29853c != null) {
                    a.this.f29853c.a(i2, i2, a.this.f29854d, a.this.f29855e, a.this.f29856f);
                }
                long d2 = a.this.f29856f - a.this.f29855e;
                aVar.f29863a.setStartTime(a.this.f29855e);
                aVar.f29863a.setEndTime(a.this.f29856f);
                aVar.f29863a.setDuration(d2);
                Log.i("editor", "onRangeChange: --position===" + i2 + "--playing===" + aVar.f29863a.getTotalTime());
            }
        });
    }

    public void a(int i2) {
        int i3 = this.f29854d;
        if (i3 != i2) {
            this.f29857g = i3;
            this.f29854d = i2;
            notifyDataSetChanged();
        }
    }

    public void a(ArrayList<GLImage> arrayList) {
        List<GLImage> list = this.f29852b;
        if (list != null) {
            list.clear();
            this.f29852b.addAll(arrayList);
        }
    }

    public void a(b bVar) {
        this.f29853c = bVar;
    }

    public int getItemCount() {
        List<GLImage> list = this.f29852b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i2) {
        return super.getItemId(i2);
    }

    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof C0204a) {
            a(vVar, i2);
        }
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return a(viewGroup);
    }
}
