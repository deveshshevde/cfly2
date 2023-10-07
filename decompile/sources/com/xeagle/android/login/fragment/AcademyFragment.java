package com.xeagle.android.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.fragment.AcademyFragment;
import com.xeagle.android.newUI.fragment.a;
import com.xeagle.android.newUI.fragment.c;
import java.util.ArrayList;
import mz.d;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class AcademyFragment extends Fragment {
    /* access modifiers changed from: private */
    public ViewPager mViewPager;
    /* access modifiers changed from: private */
    public int[] tabList = {R.string.newui_instruction, R.string.newui_video};

    private void initFragment(View view) {
        this.mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a());
        arrayList.add(new c());
        this.mViewPager.setAdapter(new kk.c(getChildFragmentManager(), arrayList));
    }

    private void initMagicIndicator(View view) {
        MagicIndicator magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setScrollPivotX(0.35f);
        commonNavigator.setAdapter(new mz.a() {
            public int getCount() {
                if (AcademyFragment.this.tabList == null) {
                    return 0;
                }
                return AcademyFragment.this.tabList.length;
            }

            public mz.c getIndicator(Context context) {
                WrapPagerIndicator wrapPagerIndicator = new WrapPagerIndicator(context);
                wrapPagerIndicator.setFillColor(AcademyFragment.this.getResources().getColor(R.color.colorAccent_blue));
                return wrapPagerIndicator;
            }

            public d getTitleView(Context context, int i2) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(AcademyFragment.this.tabList[i2]);
                simplePagerTitleView.setNormalColor(AcademyFragment.this.getResources().getColor(R.color.grayDark));
                simplePagerTitleView.setSelectedColor(AcademyFragment.this.getResources().getColor(R.color.white));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener(i2) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        AcademyFragment.AnonymousClass1.this.lambda$getTitleView$0$AcademyFragment$1(this.f$1, view);
                    }
                });
                return simplePagerTitleView;
            }

            public /* synthetic */ void lambda$getTitleView$0$AcademyFragment$1(int i2, View view) {
                AcademyFragment.this.mViewPager.setCurrentItem(i2);
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        net.lucode.hackware.magicindicator.c.a(magicIndicator, this.mViewPager);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.academy_fragment_layout, (ViewGroup) null);
        initFragment(inflate);
        initMagicIndicator(inflate);
        return inflate;
    }
}
