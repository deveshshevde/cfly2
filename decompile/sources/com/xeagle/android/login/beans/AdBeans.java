package com.xeagle.android.login.beans;

import java.util.List;

public class AdBeans {
    private int adIndex = 0;
    private int ad_id;
    private List<AdContent> advertisement;
    private int count_down;
    private String end_at;
    private LittleAd little_ad;
    private int show_count;
    private int skip_count;
    private String start_at;
    private boolean status;

    public static class AdContent {
        private String btnUrl;
        private int currentShowCount = -2;
        private String detail_url;
        private boolean hide_btn;
        private String imageUrl;
        private int isReady;
        private String pixelUrl;
        private int show_count;

        public void decShowCount() {
            this.currentShowCount--;
        }

        public String getBtnUrl() {
            return this.btnUrl;
        }

        public String getDetailUrl() {
            return this.detail_url;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public String getPixelUrl() {
            return this.pixelUrl;
        }

        public int getShowCount() {
            if (this.currentShowCount == -2) {
                this.currentShowCount = this.show_count;
            }
            return this.currentShowCount;
        }

        public boolean isHideBtn() {
            return this.hide_btn;
        }

        public boolean isReady() {
            return this.isReady == 2;
        }

        public void ready() {
            synchronized (AdContent.class) {
                this.isReady++;
            }
        }

        public void resetShowCount() {
            this.currentShowCount = this.show_count;
        }
    }

    public static class LittleAd {
        private int adIndex = 0;
        private List<AdContent> advertisement;
        private String end_at;
        private String start_at;
        private boolean status;

        public void adIndexMoveDown() {
            this.adIndex++;
        }

        public List<AdContent> getAdvertisement() {
            return this.advertisement;
        }

        public String getEndAt() {
            return this.end_at;
        }

        public String getStartAt() {
            return this.start_at;
        }

        public boolean isStatus() {
            return this.status;
        }

        public AdContent nextAd() {
            List<AdContent> list = this.advertisement;
            if (list == null || this.adIndex >= list.size()) {
                return null;
            }
            return this.advertisement.get(this.adIndex);
        }
    }

    public void adIndexMoveDown() {
        this.adIndex++;
    }

    public void decShowCount() {
        this.show_count--;
    }

    public int getAdId() {
        return this.ad_id;
    }

    public List<AdContent> getAdvertisement() {
        return this.advertisement;
    }

    public int getCountDown() {
        return this.count_down;
    }

    public String getEndAt() {
        return this.end_at;
    }

    public LittleAd getLittleAd() {
        return this.little_ad;
    }

    public int getShowCount() {
        return this.show_count;
    }

    public int getSkipCount() {
        return this.skip_count;
    }

    public String getStartAt() {
        return this.start_at;
    }

    public boolean isStatus() {
        return this.status;
    }

    public AdContent nextAd() {
        List<AdContent> list = this.advertisement;
        if (list == null || this.adIndex >= list.size()) {
            return null;
        }
        return this.advertisement.get(this.adIndex);
    }

    public void skipCountDec() {
        this.skip_count--;
    }
}
