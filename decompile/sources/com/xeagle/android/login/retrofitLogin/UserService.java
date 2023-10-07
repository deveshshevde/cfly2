package com.xeagle.android.login.retrofitLogin;

import com.xeagle.android.login.beans.ApkVersion;
import com.xeagle.android.login.beans.AvatarAcceptBeans;
import com.xeagle.android.login.beans.BatteryInServerBeans;
import com.xeagle.android.login.beans.DeviceInServerBeans;
import com.xeagle.android.login.beans.DroneActivationInServerBeans;
import com.xeagle.android.login.beans.DroneFwInfo;
import com.xeagle.android.login.beans.DroneInServerBeans;
import com.xeagle.android.login.beans.FlightAcceptBeans;
import com.xeagle.android.login.beans.ImageFwInfo;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.beans.LoginAcceptBeans;
import com.xeagle.android.login.beans.RegAcceptBeans;
import com.xeagle.android.login.beans.RepeaterFwInfo;
import com.xeagle.android.login.beans.ServiceBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.beans.UserInfoAcceptBeans;
import com.xeagle.android.login.beans.sochipBeans.CmdListener;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordTimeBean;
import com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean;
import com.xeagle.android.login.beans.sochipBeans.SochipStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipVersionBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ok.b;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.w;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface UserService {
    @POST("api/activate-battery")
    b<UploadAcceptBeans> activeBattery(@QueryMap HashMap<String, String> hashMap);

    @POST("api/activation")
    b<UploadAcceptBeans> activeDevice(@QueryMap HashMap<String, String> hashMap);

    @POST("api/user/drone-bound")
    b<UploadAcceptBeans> boundDroneWithUser(@QueryMap HashMap<String, String> hashMap);

    @POST("api/droneBindInsurance")
    b<UploadAcceptBeans> boundInsuranceWithDrone(@QueryMap HashMap<String, String> hashMap);

    @Streaming
    @GET
    b<ac> download(@Url String str);

    @FormUrlEncoded
    @POST("api/flightLogDetail")
    b<ac> downloadListner(@Field("token") String str, @Field("id") int i2);

    @GET
    b<ApkVersion> getApkInfo(@Url String str);

    @GET("api/batteryInfo")
    b<BatteryInServerBeans> getBatteryInServer(@QueryMap HashMap<String, String> hashMap);

    @GET("api/getdeviceinfo/")
    Call<SochipStatusBean> getCameraStatus(@Query("custom") int i2, @Query("cmd") int i3);

    @POST("api/drone")
    b<DeviceInServerBeans> getDeviceInServer(@QueryMap HashMap<String, String> hashMap);

    @GET("api/activation")
    b<DroneActivationInServerBeans> getDroneActivationInServer(@QueryMap HashMap<String, String> hashMap);

    @GET
    b<DroneFwInfo> getDroneFwInfo(@Url String str);

    @GET("api/droneInfo")
    b<DroneInServerBeans> getDroneInServer(@QueryMap HashMap<String, String> hashMap);

    @GET("api/getdeviceinfo/")
    Call<SochipVersionBean> getFirmwareVersion(@Query("custom") int i2, @Query("cmd") int i3);

    @POST("api/request/flight")
    b<FlightAcceptBeans> getFlightData(@QueryMap HashMap<String, String> hashMap);

    @GET
    b<ImageFwInfo> getImageFwInfo(@Url String str);

    @POST("api/flightLogList")
    b<ListenerListBeans> getListenerList(@QueryMap HashMap<String, String> hashMap);

    @POST("api/login")
    b<LoginAcceptBeans> getLogin(@QueryMap HashMap<String, String> hashMap);

    @POST("api/sendVerification")
    b<RegAcceptBeans> getMsgCode(@QueryMap HashMap<String, String> hashMap);

    @GET("api/getdeviceinfo/")
    Call<SochipRecordStatusBean> getRecordStatus(@Query("custom") int i2, @Query("cmd") int i3);

    @GET("api/getdeviceinfo/")
    Call<SochipRecordTimeBean> getRecordTime(@Query("custom") int i2, @Query("cmd") int i3);

    @POST("api/register")
    b<RegAcceptBeans> getReg(@QueryMap HashMap<String, String> hashMap);

    @GET
    b<RepeaterFwInfo> getRepeaterFwInfo(@Url String str);

    @GET("api/getdeviceinfo/")
    Call<SochipSdcardBean> getSdcardStatus(@Query("custom") int i2, @Query("cmd") int i3);

    @GET("api/getClientConfig")
    b<ServiceBeans> getServiceOnline(@QueryMap HashMap<String, String> hashMap);

    @GET("api/user/edit")
    Call<UserInfoAcceptBeans> getUserInfo(@Query("token") String str);

    @POST("api/user/edit")
    @Multipart
    Call<UploadAcceptBeans> getUserInfoResult(@Part List<w.b> list);

    @POST("api/setdeviceinfo/")
    b<CmdListener> remoteRecord(@Query("custom") int i2, @Query("cmd") int i3, @Query("par") int i4);

    @POST("api/setdeviceinfo/")
    b<CmdListener> remoteTakePhoto(@Query("custom") int i2, @Query("cmd") int i3, @Query("par") int i4);

    @POST("api/resetPasswordBySms")
    b<RegAcceptBeans> resetPwdByPhone(@QueryMap HashMap<String, String> hashMap);

    @POST("api/setdeviceinfo/")
    b<CmdListener> setCmdAndInt(@Query("custom") int i2, @Query("cmd") int i3, @Query("par") int i4);

    @POST("api/setdeviceinfo/")
    b<CmdListener> setCmdAndStr(@Query("custom") int i2, @Query("cmd") int i3, @Query(encoded = true, value = "str") String str);

    @POST("api/user/drone-unbound")
    b<UploadAcceptBeans> unboundDroneWithUser(@QueryMap HashMap<String, String> hashMap);

    @POST("api/droneUpdate")
    b<UploadAcceptBeans> updateDroneInfo(@QueryMap HashMap<String, String> hashMap);

    @POST("api/user/edit")
    @Multipart
    Call<AvatarAcceptBeans> uploadAvatar(@Part w.b bVar, @PartMap Map<String, aa> map);

    @POST("api/flightLog")
    @Multipart
    Call<UploadAcceptBeans> uploadFile(@Part aa aaVar, @PartMap Map<String, aa> map);

    @POST("api/flightLog")
    @Multipart
    Call<UploadAcceptBeans> uploadFile(@Part w.b bVar, @PartMap Map<String, aa> map);

    @POST("api/upload/img")
    @Multipart
    Call<UploadAcceptBeans> uploadImg(@Part w.b bVar, @Part("description") aa aaVar, @Part("token") aa aaVar2);
}
