package com.xeagle.android.login.pickImage.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.s;

public class ImageItemDecoration extends RecyclerView.g {
    private Context context;
    private int dividerSize = s.a(1.0f);
    private Paint paint;

    public ImageItemDecoration(Context context2) {
        Paint paint2 = new Paint();
        this.paint = paint2;
        this.context = context2;
        paint2.setColor(context2.getResources().getColor(R.color.dark_title_bg));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.onDraw(canvas, recyclerView, sVar);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.onDrawOver(canvas, recyclerView, sVar);
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt.getWidth() != s.a(this.context)) {
                int left = childAt.getLeft();
                int right = childAt.getRight();
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                float f2 = (float) right;
                float f3 = (float) bottom;
                canvas.drawRect((float) left, (float) (bottom - this.dividerSize), f2, f3, this.paint);
                canvas.drawRect((float) (right - this.dividerSize), (float) top, f2, f3, this.paint);
            }
        }
    }
}
