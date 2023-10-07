package com.xeagle.android.login.pickImage.data;

import androidx.fragment.app.FragmentActivity;
import com.xeagle.android.login.pickImage.ImagePickerOption;

public class DataSourceFactory {

    /* renamed from: com.xeagle.android.login.pickImage.data.DataSourceFactory$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType[] r0 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType = r0
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Image     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Video     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.All     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.data.DataSourceFactory.AnonymousClass2.<clinit>():void");
        }
    }

    public static AbsDataSource create(FragmentActivity fragmentActivity, String str, ImagePickerOption.PickType pickType) {
        int i2 = AnonymousClass2.$SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType[pickType.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new AbsDataSource() {
            public void reload() {
            }

            public void restartLoad() {
            }
        } : new AllDataSource(fragmentActivity, str) : new VideoDataSource(fragmentActivity, str) : new ImageDataSource(fragmentActivity, str);
    }
}
