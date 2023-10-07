package com.xeagle.android.dialogs;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;

public class aa extends Fragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sport_warn_layout, viewGroup, false);
        inflate.findViewById(R.id.ib_close).setOnClickListener($$Lambda$aa$RiSzyUsm8sjmV96fqVczX9p6WLE.INSTANCE);
        SpannableString spannableString = new SpannableString(getString(R.string.sport_is_opened));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00BDFF")), spannableString.length() - 3, spannableString.length(), 17);
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(spannableString);
        return inflate;
    }
}
