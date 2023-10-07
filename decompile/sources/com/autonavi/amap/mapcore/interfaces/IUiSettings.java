package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

public interface IUiSettings {
    float getLogoMarginRate(int i2) throws RemoteException;

    int getLogoPosition() throws RemoteException;

    int getZoomPosition() throws RemoteException;

    boolean isCompassEnabled() throws RemoteException;

    boolean isGestureScaleByMapCenter() throws RemoteException;

    boolean isIndoorSwitchEnabled() throws RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScaleControlsEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    boolean isZoomInByScreenCenter() throws RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean z2) throws RemoteException;

    void setCompassEnabled(boolean z2) throws RemoteException;

    void setGestureScaleByMapCenter(boolean z2) throws RemoteException;

    void setIndoorSwitchEnabled(boolean z2) throws RemoteException;

    void setLogoBottomMargin(int i2) throws RemoteException;

    void setLogoEnable(boolean z2);

    void setLogoLeftMargin(int i2) throws RemoteException;

    void setLogoMarginRate(int i2, float f2) throws RemoteException;

    void setLogoPosition(int i2) throws RemoteException;

    void setMyLocationButtonEnabled(boolean z2) throws RemoteException;

    void setRotateGesturesEnabled(boolean z2) throws RemoteException;

    void setScaleControlsEnabled(boolean z2) throws RemoteException;

    void setScrollGesturesEnabled(boolean z2) throws RemoteException;

    void setTiltGesturesEnabled(boolean z2) throws RemoteException;

    void setZoomControlsEnabled(boolean z2) throws RemoteException;

    void setZoomGesturesEnabled(boolean z2) throws RemoteException;

    void setZoomInByScreenCenter(boolean z2) throws RemoteException;

    void setZoomPosition(int i2) throws RemoteException;
}
