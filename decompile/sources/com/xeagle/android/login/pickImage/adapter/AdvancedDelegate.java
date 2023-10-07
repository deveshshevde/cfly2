package com.xeagle.android.login.pickImage.adapter;

public abstract class AdvancedDelegate extends BaseDelegate<BaseViewHolderData> {
    private static final int sTypeBase = 569100;
    public static final int sTypeEmpty = 569101;
    public static final int sTypeLoading = 569102;
    public static final int sTypeLoadingMore = 569103;
    public static final int sTypeToolbarHeight = 569104;

    public int getItemViewType(BaseViewHolderData baseViewHolderData, int i2) {
        return baseViewHolderData.getViewType();
    }
}
