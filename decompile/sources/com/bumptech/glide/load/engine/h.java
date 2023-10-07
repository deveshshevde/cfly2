package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10301a = new h() {
        public boolean a() {
            return true;
        }

        public boolean a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean b() {
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final h f10302b = new h() {
        public boolean a() {
            return false;
        }

        public boolean a(DataSource dataSource) {
            return false;
        }

        public boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public boolean b() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final h f10303c = new h() {
        public boolean a() {
            return false;
        }

        public boolean a(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public boolean b() {
            return true;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final h f10304d = new h() {
        public boolean a() {
            return true;
        }

        public boolean a(DataSource dataSource) {
            return false;
        }

        public boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean b() {
            return false;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final h f10305e = new h() {
        public boolean a() {
            return true;
        }

        public boolean a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z2 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }

        public boolean b() {
            return true;
        }
    };

    public abstract boolean a();

    public abstract boolean a(DataSource dataSource);

    public abstract boolean a(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean b();
}
