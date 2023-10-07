package com.xeagle.android.activities;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;
import com.xeagle.android.camera.widgets.RoundImageView;
import com.xeagle.android.widgets.HackyViewPager;

public class HelpActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private a f22173a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PhotoView f22174b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f22175c = {R.drawable.avchat_call_bg, R.drawable.avchat_call_bg, R.drawable.avchat_call_bg, R.drawable.avchat_call_bg, R.drawable.avchat_call_bg};
    @BindView(2131297301)
    ImageButton goBack;
    @BindView(2131297479)
    ImageButton indicatorLeft;
    @BindView(2131297480)
    ImageButton indicatorRight;
    @BindView(2131299801)
    HackyViewPager viewPager;

    class a extends androidx.viewpager.widget.a {

        /* renamed from: b  reason: collision with root package name */
        private int[] f22177b;

        public a(int[] iArr) {
            this.f22177b = iArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f22177b.length;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            PhotoView unused = HelpActivity.this.f22174b = new PhotoView(viewGroup.getContext());
            RoundImageView roundImageView = new RoundImageView(viewGroup.getContext());
            if (Build.VERSION.SDK_INT >= 21) {
                roundImageView.setBackground(HelpActivity.this.getResources().getDrawable(HelpActivity.this.f22175c[i2], HelpActivity.this.getTheme()));
            } else {
                roundImageView.setBackgroundDrawable(HelpActivity.this.getResources().getDrawable(HelpActivity.this.f22175c[i2]));
            }
            roundImageView.setType(1);
            roundImageView.setBorderRadius(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            viewGroup.addView(roundImageView, layoutParams);
            return roundImageView;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r3.setCurrentItem(r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        android.widget.Toast.makeText(r2, r3, 0).show();
     */
    @butterknife.OnClick({2131297301, 2131297479, 2131297480})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r3 = r3.getId()
            r0 = 0
            switch(r3) {
                case 2131297301: goto L_0x0042;
                case 2131297479: goto L_0x0023;
                case 2131297480: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            com.xeagle.android.widgets.HackyViewPager r3 = r2.viewPager
            int r3 = r3.getCurrentItem()
            int[] r1 = r2.f22175c
            int r1 = r1.length
            int r1 = r1 + -1
            if (r3 != r1) goto L_0x001a
            r3 = 2131821567(0x7f1103ff, float:1.927588E38)
            goto L_0x002e
        L_0x001a:
            com.xeagle.android.widgets.HackyViewPager r3 = r2.viewPager
            int r1 = r3.getCurrentItem()
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0023:
            com.xeagle.android.widgets.HackyViewPager r3 = r2.viewPager
            int r3 = r3.getCurrentItem()
            if (r3 != 0) goto L_0x0036
            r3 = 2131821365(0x7f110335, float:1.9275471E38)
        L_0x002e:
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)
            r3.show()
            goto L_0x004f
        L_0x0036:
            com.xeagle.android.widgets.HackyViewPager r3 = r2.viewPager
            int r1 = r3.getCurrentItem()
            int r1 = r1 + -1
        L_0x003e:
            r3.setCurrentItem(r1, r0)
            goto L_0x004f
        L_0x0042:
            r2.finish()
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r0 = com.xeagle.android.activities.MainViewActivity.class
            r3.<init>(r2, r0)
            r2.startActivity(r3)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.HelpActivity.onClick(android.view.View):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.exgallery_help_activity);
        ButterKnife.bind((Activity) this);
        a aVar = new a(this.f22175c);
        this.f22173a = aVar;
        this.viewPager.setAdapter(aVar);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        finish();
    }
}
