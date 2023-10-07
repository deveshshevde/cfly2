package com.xeagle.android.widgets.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class i {
    public static View a(Context context) {
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.divider_height));
        layoutParams.addRule(12);
        view.setLayoutParams(layoutParams);
        view.setClickable(true);
        view.setBackgroundColor(context.getResources().getColor(R.color.divider_color));
        return view;
    }

    public static ImageView a(Context context, Drawable drawable) {
        ImageButton imageButton = new ImageButton(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageButton.setLayoutParams(layoutParams);
        imageButton.setPadding((int) context.getResources().getDimension(R.dimen.menu_item_padding), (int) context.getResources().getDimension(R.dimen.menu_item_padding), (int) context.getResources().getDimension(R.dimen.menu_item_padding), (int) context.getResources().getDimension(R.dimen.menu_item_padding));
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setBackgroundColor(context.getResources().getColor(17170445));
        imageButton.setImageDrawable(drawable);
        imageButton.setClickable(false);
        imageButton.setFocusable(false);
        return imageButton;
    }

    public static RelativeLayout a(Context context, int i2, int i3, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.menu_item_background));
        relativeLayout.setOnClickListener(onClickListener);
        relativeLayout.setOnLongClickListener(onLongClickListener);
        relativeLayout.addView(a(context, i3 > 0 ? context.getResources().getDrawable(i3) : null));
        relativeLayout.addView(a(context));
        return relativeLayout;
    }

    public static TextView a(Context context, String str, int i2) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, i2));
        textView.setTextSize(0, context.getResources().getDimension(R.dimen.menu_text_size));
        textView.setTextColor(context.getResources().getColor(17170443));
        textView.setText(str);
        textView.setPadding(0, 0, (int) context.getResources().getDimension(R.dimen.text_right_padding), 0);
        textView.setGravity(16);
        return textView;
    }
}
