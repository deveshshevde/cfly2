package com.xeagle.android.login.pickImage.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.Utils;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.ImageFolder;
import com.xeagle.android.login.pickImage.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class ImageFolderAdapter extends BaseAdapter {
    private List<ImageFolder> imageFolders;
    private ImagePicker imagePicker;
    private int lastSelected = 0;
    private Activity mActivity;
    private int mImageSize;
    private LayoutInflater mInflater;

    private static class ViewHolder {
        ImageView cover;
        TextView folderName;
        TextView imageCount;

        public ViewHolder(View view) {
            this.cover = (ImageView) view.findViewById(R.id.iv_cover);
            this.folderName = (TextView) view.findViewById(R.id.tv_folder_name);
            this.imageCount = (TextView) view.findViewById(R.id.tv_image_count);
            view.setTag(this);
        }
    }

    public ImageFolderAdapter(Activity activity, List<ImageFolder> list) {
        this.mActivity = activity;
        this.imageFolders = (list == null || list.size() <= 0) ? new ArrayList<>() : list;
        this.imagePicker = ImagePicker.getInstance();
        this.mImageSize = Utils.getImageItemWidth(this.mActivity);
        this.mInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.imageFolders.size();
    }

    public ImageFolder getItem(int i2) {
        return this.imageFolders.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getSelectIndex() {
        return this.lastSelected;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.adapter_folder_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ImageFolder item = getItem(i2);
        if (item != null) {
            viewHolder.folderName.setText(item.name);
            viewHolder.imageCount.setText(this.mActivity.getString(R.string.folder_image_count, new Object[]{Integer.valueOf(item.images.size())}));
            ImageLoader imageLoader = this.imagePicker.getImageLoader();
            Activity activity = this.mActivity;
            String path = item.cover.getPath();
            ImageView imageView = viewHolder.cover;
            int i3 = this.mImageSize;
            imageLoader.displayImage(activity, path, imageView, i3, i3);
        }
        view.setBackgroundResource(this.lastSelected == i2 ? R.color.white_pressed : R.color.white);
        return view;
    }

    public void refreshData(List<ImageFolder> list) {
        if (list == null || list.size() <= 0) {
            this.imageFolders.clear();
        } else {
            this.imageFolders = list;
        }
        setSelectIndex(this.imagePicker.getCurrentImageFolderPosition());
        notifyDataSetChanged();
    }

    public void setSelectIndex(int i2) {
        if (this.lastSelected != i2) {
            this.lastSelected = i2;
            notifyDataSetChanged();
        }
    }
}
