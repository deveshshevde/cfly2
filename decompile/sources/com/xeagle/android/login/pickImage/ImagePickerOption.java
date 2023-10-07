package com.xeagle.android.login.pickImage;

import android.content.Context;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.CropImageView;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import com.xeagle.android.login.pickImage.loader.ImageLoader;
import java.io.File;
import java.io.Serializable;

public class ImagePickerOption implements Serializable {
    private static final int FEED_VIDEO_DURATION_MAX = 15;
    private static final int FEED_VIDEO_DURATION_MIN = 3;
    private boolean checkNetwork = false;
    private boolean crop = false;
    private File cropCacheFolder;
    private int focusHeight = Constants.PORTRAIT_IMAGE_WIDTH;
    private int focusWidth = Constants.PORTRAIT_IMAGE_WIDTH;
    private ImageLoader imageLoader = new GlideImageLoader();
    private boolean isSaveRectangle = false;
    private String mTitle;
    private int maxVideoDuration = 15;
    private int minVideoDuration = 3;
    private boolean mixMode = false;
    private boolean multiMode = false;
    private int outPutX = 800;
    private int outPutY = 800;
    private PickType pickType;
    private boolean section = false;
    private int selectMax = 99;
    private int selectMin = 0;
    private boolean showCamera = false;
    private CropImageView.Style style = CropImageView.Style.RECTANGLE;

    public enum PickType {
        Image(R.string.pick_image),
        Video(R.string.pick_video),
        All(R.string.pick_album);
        
        private final int title;

        private PickType(int i2) {
            this.title = i2;
        }

        public int getTitle() {
            return this.title;
        }
    }

    public ImagePickerOption asSection() {
        this.section = true;
        return this;
    }

    public void checkParams() {
    }

    public File getCropCacheFolder(Context context) {
        if (this.cropCacheFolder == null) {
            this.cropCacheFolder = new File(context.getCacheDir() + "/ImagePicker/cropTemp/");
        }
        return this.cropCacheFolder;
    }

    public int getFocusHeight() {
        return this.focusHeight;
    }

    public int getFocusWidth() {
        return this.focusWidth;
    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public int getMaxVideoDuration() {
        return this.maxVideoDuration;
    }

    public int getMinVideoDuration() {
        return this.minVideoDuration;
    }

    public int getOutPutX() {
        return this.outPutX;
    }

    public int getOutPutY() {
        return this.outPutY;
    }

    public PickType getPickType() {
        return this.pickType;
    }

    public int getSelectMax() {
        return this.selectMax;
    }

    public int getSelectMin() {
        return this.selectMin;
    }

    public CropImageView.Style getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean imageOnly() {
        return this.pickType == PickType.Image;
    }

    public boolean isCrop() {
        return this.crop;
    }

    public boolean isMixMode() {
        return this.mixMode;
    }

    public boolean isMultiMode() {
        return this.multiMode;
    }

    public boolean isSaveRectangle() {
        return this.isSaveRectangle;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    public boolean isShowSection() {
        return this.section;
    }

    public boolean needCheckNetwork() {
        return this.checkNetwork;
    }

    public ImagePickerOption setCheckNetwork(boolean z2) {
        this.checkNetwork = z2;
        return this;
    }

    public ImagePickerOption setCrop(boolean z2) {
        this.crop = z2;
        return this;
    }

    public ImagePickerOption setCropCacheFolder(File file) {
        this.cropCacheFolder = file;
        return this;
    }

    public ImagePickerOption setFocusHeight(int i2) {
        this.focusHeight = i2;
        return this;
    }

    public ImagePickerOption setFocusWidth(int i2) {
        this.focusWidth = i2;
        return this;
    }

    public ImagePickerOption setImageLoader(ImageLoader imageLoader2) {
        this.imageLoader = imageLoader2;
        return this;
    }

    public ImagePickerOption setMaxVideoDuration(int i2) {
        this.maxVideoDuration = i2;
        return this;
    }

    public void setMinVideoDuration(int i2) {
        this.minVideoDuration = i2;
    }

    public ImagePickerOption setMixMode(boolean z2) {
        this.mixMode = z2;
        return this;
    }

    public ImagePickerOption setMultiMode(boolean z2) {
        this.multiMode = z2;
        return this;
    }

    public ImagePickerOption setOutPutX(int i2) {
        this.outPutX = i2;
        return this;
    }

    public ImagePickerOption setOutPutY(int i2) {
        this.outPutY = i2;
        return this;
    }

    public ImagePickerOption setPickType(PickType pickType2) {
        this.pickType = pickType2;
        return this;
    }

    public ImagePickerOption setSaveRectangle(boolean z2) {
        this.isSaveRectangle = z2;
        return this;
    }

    public ImagePickerOption setSelectMax(int i2) {
        this.selectMax = i2;
        return this;
    }

    public ImagePickerOption setSelectMin(int i2) {
        this.selectMin = i2;
        return this;
    }

    public ImagePickerOption setShowCamera(boolean z2) {
        this.showCamera = z2;
        return this;
    }

    public ImagePickerOption setStyle(CropImageView.Style style2) {
        this.style = style2;
        return this;
    }

    public ImagePickerOption setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public boolean videoOnly() {
        return this.pickType == PickType.Video;
    }
}
