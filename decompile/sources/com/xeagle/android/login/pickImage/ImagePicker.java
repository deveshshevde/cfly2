package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.graphics.Bitmap;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.CropImageView;
import com.xeagle.android.login.pickImage.ImagePickerOption;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.data.ImageFolder;
import com.xeagle.android.login.pickImage.loader.ImageLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImagePicker {
    public static final String TAG = "ImagePicker";
    private static ImagePicker mInstance;
    public Bitmap cropBitmap;
    private ImageFolder mCurrentImageFolder = null;
    private int mCurrentImageFolderPosition = 0;
    private List<ImageFolder> mImageFolders;
    private List<OnImageSelectedListener> mImageSelectedListeners;
    private ArrayList<GLImage> mSelectedImages = new ArrayList<>();
    private ImagePickerOption option = DefaultImagePickerOption.getInstance();
    private File takeImageFile;

    public interface OnImageSelectedListener {
        void onImageSelected(GLImage gLImage, boolean z2);
    }

    private ImagePicker() {
    }

    public static ImagePicker getInstance() {
        if (mInstance == null) {
            synchronized (ImagePicker.class) {
                if (mInstance == null) {
                    mInstance = new ImagePicker();
                }
            }
        }
        return mInstance;
    }

    private void notifyImageSelectedChanged(GLImage gLImage, boolean z2) {
        List<OnImageSelectedListener> list = this.mImageSelectedListeners;
        if (list != null) {
            for (OnImageSelectedListener onImageSelected : list) {
                onImageSelected.onImageSelected(gLImage, z2);
            }
        }
    }

    private void resetSelectImageFolder(List<ImageFolder> list) {
        int currentImageFolderPosition = getCurrentImageFolderPosition();
        if (currentImageFolderPosition != 0) {
            ImageFolder currentImageFolder = getCurrentImageFolder();
            ImageFolder imageFolder = list.get(currentImageFolderPosition);
            if (currentImageFolder == imageFolder || (currentImageFolder != null && currentImageFolder.equals(imageFolder))) {
                setCurrentImageFolderPosition(0);
            }
        }
    }

    public void addOnImageSelectedListener(OnImageSelectedListener onImageSelectedListener) {
        if (this.mImageSelectedListeners == null) {
            this.mImageSelectedListeners = new ArrayList();
        }
        this.mImageSelectedListeners.add(onImageSelectedListener);
    }

    public void addSelectedImageItem(GLImage gLImage, boolean z2) {
        ArrayList<GLImage> arrayList = this.mSelectedImages;
        if (!z2) {
            arrayList.remove(gLImage);
        } else if (!arrayList.contains(gLImage)) {
            this.mSelectedImages.add(gLImage);
        }
        notifyImageSelectedChanged(gLImage, z2);
    }

    public void clear() {
        List<OnImageSelectedListener> list = this.mImageSelectedListeners;
        if (list != null) {
            list.clear();
            this.mImageSelectedListeners = null;
        }
        List<ImageFolder> list2 = this.mImageFolders;
        if (list2 != null) {
            list2.clear();
            this.mImageFolders = null;
        }
        ArrayList<GLImage> arrayList = this.mSelectedImages;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mCurrentImageFolderPosition = 0;
    }

    public void clearSelectedImages() {
        ArrayList<GLImage> arrayList = this.mSelectedImages;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public File getCropCacheFolder(Context context) {
        return this.option.getCropCacheFolder(context);
    }

    public ImageFolder getCurrentImageFolder() {
        return this.mCurrentImageFolder;
    }

    public ArrayList<GLImage> getCurrentImageFolderItems() {
        return this.mImageFolders.get(this.mCurrentImageFolderPosition).images;
    }

    public int getCurrentImageFolderPosition() {
        return this.mCurrentImageFolderPosition;
    }

    public int getFocusHeight() {
        return this.option.getFocusHeight();
    }

    public int getFocusWidth() {
        return this.option.getFocusWidth();
    }

    public List<ImageFolder> getImageFolders() {
        return this.mImageFolders;
    }

    public ImageLoader getImageLoader() {
        return this.option.getImageLoader();
    }

    public ImagePickerOption getOption() {
        return this.option;
    }

    public int getOutPutX() {
        return this.option.getOutPutX();
    }

    public int getOutPutY() {
        return this.option.getOutPutY();
    }

    public ImagePickerOption.PickType getPickType() {
        return this.option.getPickType();
    }

    public int getSelectImageCount() {
        return this.mSelectedImages.size();
    }

    public int getSelectImageLeftCount() {
        return getSelectMax() - this.mSelectedImages.size();
    }

    public long getSelectImageSize() {
        Iterator<GLImage> it2 = this.mSelectedImages.iterator();
        long j2 = 0;
        while (it2.hasNext()) {
            j2 += it2.next().getSize();
        }
        return j2;
    }

    public int getSelectMax() {
        return this.option.getSelectMax();
    }

    public int getSelectMin() {
        return this.option.getSelectMin();
    }

    public ArrayList<GLImage> getSelectedImages() {
        return this.mSelectedImages;
    }

    public CropImageView.Style getStyle() {
        return this.option.getStyle();
    }

    public File getTakeImageFile() {
        return this.takeImageFile;
    }

    public String getTitle() {
        return this.option.getTitle();
    }

    public boolean imageOnly() {
        return this.option.imageOnly();
    }

    public boolean isCrop() {
        return this.option.isCrop();
    }

    public boolean isMaxLimitOk() {
        return getSelectImageLeftCount() > 0;
    }

    public boolean isMinLimitOk() {
        return getSelectImageCount() > getSelectMin();
    }

    public boolean isMultiMode() {
        return this.option.isMultiMode();
    }

    public boolean isSaveRectangle() {
        return this.option.isSaveRectangle();
    }

    public boolean isSelect(GLImage gLImage) {
        return this.mSelectedImages.contains(gLImage);
    }

    public boolean isSelectAll(List<GLImage> list) {
        return this.mSelectedImages.containsAll(list);
    }

    public String isSelectEnable(Context context, GLImage gLImage) {
        boolean z2;
        if (!isMaxLimitOk()) {
            return context.getString(R.string.choose_max_num, new Object[]{Integer.valueOf(getSelectMax())});
        } else if (!this.option.isMixMode()) {
            Iterator<GLImage> it2 = this.mSelectedImages.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().isVideo()) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            boolean z3 = !z2 && this.mSelectedImages.size() > 0;
            if (z2 && gLImage.isVideo()) {
                return context.getString(R.string.choose_max_num_video, new Object[]{1});
            } else if (z2 && !gLImage.isVideo()) {
                return context.getString(R.string.choose_video_photo);
            } else {
                if (z3 && gLImage.isVideo()) {
                    return context.getString(R.string.choose_video_photo);
                }
                if (gLImage.isVideo() && gLImage.getDuration() < ((long) (getOption().getMinVideoDuration() * 1000))) {
                    return context.getString(R.string.choose_video_duration_min_tip);
                }
                if (!gLImage.isVideo() || gLImage.getDuration() <= ((long) (getOption().getMaxVideoDuration() * 1000))) {
                    return null;
                }
                return context.getString(R.string.choose_video_duration_max_tip, new Object[]{Integer.valueOf(getOption().getMaxVideoDuration())});
            }
        } else if (!gLImage.isVideo() || gLImage.getDuration() <= ((long) (getOption().getMaxVideoDuration() * 1000))) {
            return null;
        } else {
            return context.getString(R.string.choose_video_duration_max_tip, new Object[]{Integer.valueOf(getOption().getMaxVideoDuration())});
        }
    }

    public boolean isShowCamera() {
        return this.option.isShowCamera();
    }

    public boolean isShowSection() {
        return this.option.isShowSection();
    }

    public boolean needCheckNetwork() {
        return this.option.needCheckNetwork();
    }

    public void removeOnImageSelectedListener(OnImageSelectedListener onImageSelectedListener) {
        List<OnImageSelectedListener> list = this.mImageSelectedListeners;
        if (list != null) {
            list.remove(onImageSelectedListener);
        }
    }

    public int selectOrder(GLImage gLImage) {
        Iterator<GLImage> it2 = this.mSelectedImages.iterator();
        int i2 = 1;
        while (it2.hasNext() && !it2.next().equals(gLImage)) {
            i2++;
        }
        if (i2 > this.mSelectedImages.size()) {
            return 0;
        }
        return i2;
    }

    public void setCurrentImageFolderPosition(int i2) {
        this.mCurrentImageFolderPosition = i2;
        List<ImageFolder> list = this.mImageFolders;
        this.mCurrentImageFolder = (list == null || list.size() <= this.mCurrentImageFolderPosition) ? null : this.mImageFolders.get(i2);
    }

    public void setImageFolders(List<ImageFolder> list) {
        this.mImageFolders = list;
        resetSelectImageFolder(list);
    }

    public void setOption(ImagePickerOption imagePickerOption) {
        imagePickerOption.checkParams();
        this.option = imagePickerOption;
    }

    public void setTakeImageFile(File file) {
        this.takeImageFile = file;
    }

    public boolean videoEnable() {
        return !this.option.imageOnly();
    }

    public boolean videoOnly() {
        return this.option.videoOnly();
    }
}
