package hr;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.ui.widget.PressedImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Object> f13418a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f13419b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0098b f13420c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f13421d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f13422e;

    /* renamed from: f  reason: collision with root package name */
    private int f13423f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13424g = false;

    private class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final FrameLayout f13432a;

        a(View view) {
            super(view);
            this.f13432a = (FrameLayout) view.findViewById(R.id.fl_camera);
        }
    }

    /* renamed from: hr.b$b  reason: collision with other inner class name */
    public interface C0098b {
        void a(Integer num);

        void b(int i2, int i3);

        void d();

        void e();
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final PressedImageView f13434a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f13435b;

        /* renamed from: c  reason: collision with root package name */
        final View f13436c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f13437d;

        /* renamed from: e  reason: collision with root package name */
        final ImageView f13438e;

        c(View view) {
            super(view);
            this.f13434a = (PressedImageView) view.findViewById(R.id.iv_photo);
            this.f13435b = (TextView) view.findViewById(R.id.tv_selector);
            this.f13436c = view.findViewById(R.id.v_selector);
            this.f13437d = (TextView) view.findViewById(R.id.tv_type);
            this.f13438e = (ImageView) view.findViewById(R.id.iv_play);
        }
    }

    public b(Context context, ArrayList<Object> arrayList, C0098b bVar) {
        boolean z2 = false;
        this.f13418a = arrayList;
        this.f13420c = bVar;
        this.f13419b = LayoutInflater.from(context);
        this.f13421d = hp.a.e() == hq.a.f13380d;
        this.f13422e = hq.a.f13380d == 1 ? true : z2;
    }

    private void a(TextView textView, boolean z2, Photo photo, int i2) {
        if (z2) {
            String c2 = hp.a.c(photo);
            if (c2.equals("0")) {
                textView.setBackgroundResource(R.drawable.bg_select_false_easy_photos);
                textView.setText((CharSequence) null);
                return;
            }
            textView.setText(c2);
            textView.setBackgroundResource(R.drawable.bg_select_true_easy_photos);
            if (this.f13422e) {
                this.f13423f = i2;
                textView.setText("1");
                return;
            }
            return;
        }
        textView.setBackgroundResource(this.f13421d ? R.drawable.bg_select_false_unable_easy_photos : R.drawable.bg_select_false_easy_photos);
        textView.setText((CharSequence) null);
    }

    /* access modifiers changed from: private */
    public void a(Photo photo, int i2) {
        if (hp.a.d()) {
            hp.a.a(photo);
        } else if (hp.a.b(0).equals(photo.f20303c)) {
            hp.a.b(photo);
        } else {
            hp.a.a(0);
            hp.a.a(photo);
            notifyItemChanged(this.f13423f);
        }
        notifyItemChanged(i2);
        this.f13420c.e();
    }

    public void a() {
        this.f13421d = hp.a.e() == hq.a.f13380d;
        notifyDataSetChanged();
    }

    public void b() {
        this.f13424g = true;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f13418a.size();
    }

    public int getItemViewType(int i2) {
        if (i2 == 0) {
            if (hq.a.c()) {
                return 0;
            }
            if (hq.a.f13392p && !hq.a.e()) {
                return 1;
            }
        }
        return (1 != i2 || hq.a.e() || !hq.a.c() || !hq.a.f13392p) ? 2 : 1;
    }

    public void onBindViewHolder(final RecyclerView.v vVar, final int i2) {
        View view;
        if (vVar instanceof c) {
            final Photo photo = (Photo) this.f13418a.get(i2);
            if (photo != null) {
                c cVar = (c) vVar;
                a(cVar.f13435b, photo.f20311k, photo, i2);
                String str = photo.f20303c;
                Uri uri = photo.f20301a;
                String str2 = photo.f20304d;
                long j2 = photo.f20309i;
                boolean z2 = str.endsWith("gif") || str2.endsWith("gif");
                if (hq.a.f13397u && z2) {
                    hq.a.f13402z.b(cVar.f13434a.getContext(), uri, cVar.f13434a);
                    cVar.f13437d.setText(R.string.gif_easy_photos);
                    cVar.f13437d.setVisibility(0);
                } else if (!hq.a.f13398v || !str2.contains("video")) {
                    hq.a.f13402z.a(cVar.f13434a.getContext(), uri, cVar.f13434a);
                    cVar.f13437d.setVisibility(8);
                } else {
                    hq.a.f13402z.a(cVar.f13434a.getContext(), uri, cVar.f13434a);
                    cVar.f13437d.setText(hw.a.a(j2));
                    cVar.f13437d.setVisibility(0);
                    cVar.f13438e.setVisibility(0);
                    cVar.f13436c.setVisibility(0);
                    cVar.f13435b.setVisibility(0);
                    cVar.f13434a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            int i2 = i2;
                            if (hq.a.c()) {
                                i2--;
                            }
                            if (hq.a.f13392p && !hq.a.e()) {
                                i2--;
                            }
                            b.this.f13420c.b(i2, i2);
                        }
                    });
                    cVar.f13436c.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (b.this.f13422e) {
                                b.this.a(photo, i2);
                            } else if (!b.this.f13421d) {
                                Photo photo = photo;
                                photo.f20311k = !photo.f20311k;
                                if (photo.f20311k) {
                                    int a2 = hp.a.a(photo);
                                    if (a2 != 0) {
                                        b.this.f13420c.a(Integer.valueOf(a2));
                                        photo.f20311k = false;
                                        return;
                                    }
                                    ((c) vVar).f13435b.setBackgroundResource(R.drawable.bg_select_true_easy_photos);
                                    ((c) vVar).f13435b.setText(String.valueOf(hp.a.e()));
                                    if (hp.a.e() == hq.a.f13380d) {
                                        boolean unused = b.this.f13421d = true;
                                    }
                                    b.this.f13420c.e();
                                }
                                hp.a.b(photo);
                                if (b.this.f13421d) {
                                    boolean unused2 = b.this.f13421d = false;
                                }
                                b.this.notifyDataSetChanged();
                                b.this.f13420c.e();
                            } else if (photo.f20311k) {
                                hp.a.b(photo);
                                if (b.this.f13421d) {
                                    boolean unused3 = b.this.f13421d = false;
                                }
                                b.this.f13420c.e();
                                b.this.notifyDataSetChanged();
                            } else {
                                b.this.f13420c.a((Integer) null);
                            }
                        }
                    });
                    return;
                }
                cVar.f13438e.setVisibility(8);
                cVar.f13436c.setVisibility(0);
                cVar.f13435b.setVisibility(0);
                cVar.f13434a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        int i2 = i2;
                        if (hq.a.c()) {
                            i2--;
                        }
                        if (hq.a.f13392p && !hq.a.e()) {
                            i2--;
                        }
                        b.this.f13420c.b(i2, i2);
                    }
                });
                cVar.f13436c.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (b.this.f13422e) {
                            b.this.a(photo, i2);
                        } else if (!b.this.f13421d) {
                            Photo photo = photo;
                            photo.f20311k = !photo.f20311k;
                            if (photo.f20311k) {
                                int a2 = hp.a.a(photo);
                                if (a2 != 0) {
                                    b.this.f13420c.a(Integer.valueOf(a2));
                                    photo.f20311k = false;
                                    return;
                                }
                                ((c) vVar).f13435b.setBackgroundResource(R.drawable.bg_select_true_easy_photos);
                                ((c) vVar).f13435b.setText(String.valueOf(hp.a.e()));
                                if (hp.a.e() == hq.a.f13380d) {
                                    boolean unused = b.this.f13421d = true;
                                }
                                b.this.f13420c.e();
                            }
                            hp.a.b(photo);
                            if (b.this.f13421d) {
                                boolean unused2 = b.this.f13421d = false;
                            }
                            b.this.notifyDataSetChanged();
                            b.this.f13420c.e();
                        } else if (photo.f20311k) {
                            hp.a.b(photo);
                            if (b.this.f13421d) {
                                boolean unused3 = b.this.f13421d = false;
                            }
                            b.this.f13420c.e();
                            b.this.notifyDataSetChanged();
                        } else {
                            b.this.f13420c.a((Integer) null);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (vVar instanceof hi.b) {
            if (this.f13424g) {
                hi.b bVar = (hi.b) vVar;
                bVar.f13325a.removeAllViews();
                bVar.f13325a.setVisibility(8);
                return;
            } else if (!hq.a.f13383g) {
                ((hi.b) vVar).f13325a.setVisibility(8);
                return;
            } else {
                WeakReference weakReference = (WeakReference) this.f13418a.get(i2);
                if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                    if (view.getParent() != null && (view.getParent() instanceof FrameLayout)) {
                        ((FrameLayout) view.getParent()).removeAllViews();
                    }
                    hi.b bVar2 = (hi.b) vVar;
                    bVar2.f13325a.setVisibility(0);
                    bVar2.f13325a.removeAllViews();
                    bVar2.f13325a.addView(view);
                }
            }
        }
        if (vVar instanceof a) {
            ((a) vVar).f13432a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.f13420c.d();
                }
            });
        }
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 != 0 ? i2 != 1 ? new c(this.f13419b.inflate(R.layout.item_rv_photos_easy_photos, viewGroup, false)) : new a(this.f13419b.inflate(R.layout.item_camera_easy_photos, viewGroup, false)) : new hi.b(this.f13419b.inflate(R.layout.item_ad_easy_photos, viewGroup, false));
    }
}
