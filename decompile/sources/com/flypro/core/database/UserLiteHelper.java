package com.flypro.core.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

public class UserLiteHelper {
    /* access modifiers changed from: private */
    public static String TAG = "UserInfo";

    public interface GetKnownListenerListCallback {
        void getKnownListenrListCallback(ArrayList<ListenerInfoBeans> arrayList);
    }

    public static void deleteAllListenerList() {
        LitePal.deleteAll((Class<?>) ListenerListData.class, new String[0]);
    }

    public static void deleteAllUploadData() {
        LitePal.deleteAll((Class<?>) UploadData.class, new String[0]);
    }

    public static void deleteClass(Class<?> cls) {
        LitePal.deleteAll(cls, new String[0]);
    }

    public static void deleteData(int i2, UpdateOrDeleteCallback updateOrDeleteCallback) {
        LitePal.deleteAsync(PdfData.class, (long) i2).listen(updateOrDeleteCallback);
    }

    public static void deleteDataByFlag(String str) {
        LitePal.deleteAll((Class<?>) PdfData.class, "flag = ?", str);
    }

    public static void deleteDataByFlag(String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        LitePal.deleteAllAsync((Class<?>) PdfData.class, "flag = ?", str).listen(updateOrDeleteCallback);
    }

    public static void deleteUploadData(String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        LitePal.deleteAllAsync((Class<?>) UploadData.class, "flying_off = ?", str).listen(updateOrDeleteCallback);
    }

    public static void deleteUploadDataByName(String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        LitePal.deleteAllAsync((Class<?>) UploadData.class, "fileName = ?", str).listen(updateOrDeleteCallback);
    }

    public static int deleteUser(int i2) {
        return LitePal.delete(UserData.class, (long) i2);
    }

    public static int deleteUserByEmail(String str) {
        return LitePal.deleteAll((Class<?>) UserData.class, "email = ?", str);
    }

    public static int deleteUserByUid(String str) {
        return LitePal.deleteAll((Class<?>) UserData.class, "uid = ?", str);
    }

    public static void findUploadDataByFileName(String str, FindCallback<UploadData> findCallback) {
        LitePal.where("filename = ?", str).findFirstAsync(UploadData.class).listen(findCallback);
    }

    public static void getKnownListenerList(final GetKnownListenerListCallback getKnownListenerListCallback) {
        LitePal.findAllAsync(ListenerListData.class, new long[0]).listen(new FindMultiCallback<ListenerListData>() {
            public void onFinish(List<ListenerListData> list) {
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (ListenerListData next : list) {
                        ListenerInfoBeans listenerInfoBeans = new ListenerInfoBeans();
                        listenerInfoBeans.setId(Integer.parseInt(next.getId()));
                        listenerInfoBeans.setFly_total_time(next.getFly_total_time());
                        listenerInfoBeans.setFlying_off(next.getFlying_off());
                        listenerInfoBeans.setMileage(next.getMileage());
                        listenerInfoBeans.setName(next.getName());
                        listenerInfoBeans.setSize(next.getSize());
                        arrayList.add(listenerInfoBeans);
                    }
                    GetKnownListenerListCallback.this.getKnownListenrListCallback(arrayList);
                }
            }
        });
    }

    public static void getTotalFlightData(FindCallback<ListenerTotalData> findCallback) {
        LitePal.findFirstAsync(ListenerTotalData.class).listen(findCallback);
    }

    public static ArrayList<UploadInfo> getUploadInfo() {
        ArrayList<UploadInfo> arrayList = new ArrayList<>();
        List<UploadData> findAll = LitePal.findAll(UploadData.class, new long[0]);
        if (findAll == null || findAll.size() <= 0) {
            Log.i(TAG, "getUploadInfo: ---- upload lite is null");
        } else {
            for (UploadData next : findAll) {
                arrayList.add(new UploadInfo(next.getFlying_off(), next.getFly_total_time(), next.getMileage(), next.getFileName()));
            }
        }
        return arrayList;
    }

    public static void getUploadListener(FindMultiCallback<UploadData> findMultiCallback) {
        LitePal.findAllAsync(UploadData.class, new long[0]).listen(findMultiCallback);
    }

    public static UserInfo getUserInfo(int i2) {
        UserData userData = (UserData) LitePal.find(UserData.class, (long) i2);
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(userData.getUid());
        userInfo.setUserName(userData.getUserName());
        userInfo.setIconPath(userData.getIconPath());
        userInfo.setUserMale(userData.getUserMale());
        userInfo.setEmail(userData.getEmail());
        userInfo.setPhone(userData.getPhone());
        userInfo.setToken(userData.getToken());
        userInfo.setCountry(userData.getCountry());
        userInfo.setTotalFlightTime(userData.getTotalFlightTime());
        userInfo.setTotalMileage(userData.getTotalMileage());
        userInfo.setTotalCount(userData.getTotalCount());
        return userInfo;
    }

    public static UserInfo getUserInfo(String str) throws SQLiteCantOpenDatabaseException {
        UserInfo userInfo = new UserInfo();
        UserData userData = (UserData) LitePal.where("uid = ?", str).findFirst(UserData.class);
        if (userData == null || userData.getUid() == null) {
            return null;
        }
        userInfo.setUid(userData.getUid());
        userInfo.setUserName(userData.getUserName());
        userInfo.setIconPath(userData.getIconPath());
        userInfo.setUserMale(userData.getUserMale());
        userInfo.setEmail(userData.getEmail());
        userInfo.setPhone(userData.getPhone());
        userInfo.setPassword(userData.getPassword());
        userInfo.setToken(userData.getToken());
        userInfo.setCountry(userData.getCountry());
        userInfo.setTotalFlightTime(userData.getTotalFlightTime());
        userInfo.setTotalMileage(userData.getTotalMileage());
        userInfo.setTotalCount(userData.getTotalCount());
        return userInfo;
    }

    public static ArrayList<UserInfo> readDatabase() {
        ArrayList<UserInfo> arrayList = new ArrayList<>();
        List<UserData> findAll = LitePal.findAll(UserData.class, new long[0]);
        if (findAll == null || findAll.size() <= 0) {
            Log.i(TAG, "readDatabase: -----  litepal is null");
        } else {
            Iterator<UserData> it2 = findAll.iterator();
            while (it2.hasNext()) {
                UserData next = it2.next();
                Iterator<UserData> it3 = it2;
                UserInfo userInfo = r3;
                UserInfo userInfo2 = new UserInfo(next.getUid(), next.getUserName(), next.getIconPath(), next.getEmail(), next.getPhone(), next.getToken(), next.getPassword(), next.getUserMale(), next.getCountry(), next.getTotalFlightTime(), next.getTotalMileage(), next.getTotalCount());
                arrayList.add(userInfo);
                it2 = it3;
            }
        }
        return arrayList;
    }

    public static ArrayList<PdfInfo> readDatabase(Context context) {
        ArrayList<PdfInfo> arrayList = new ArrayList<>();
        List<PdfData> findAll = LitePal.findAll(PdfData.class, new long[0]);
        if (findAll != null && findAll.size() > 0) {
            for (PdfData next : findAll) {
                arrayList.add(new PdfInfo(next.getName(), next.getPdf_url(), next.getFile_size(), next.getImage_url(), next.getVersion(), next.isUpdate(), next.getFlag()));
            }
        }
        return arrayList;
    }

    public static void requestBatteryInfo(FindMultiCallback<BatteryInfoData> findMultiCallback) {
        LitePal.findAllAsync(BatteryInfoData.class, new long[0]).listen(findMultiCallback);
    }

    public static void requestBatteryInfoWithSn(String str, FindMultiCallback<BatteryInfoData> findMultiCallback) {
        LitePal.where("batterySnId = ?", str).findAsync(BatteryInfoData.class).listen(findMultiCallback);
    }

    public static void requestDroneInfo(FindMultiCallback<DroneInfoData> findMultiCallback) {
        LitePal.findAllAsync(DroneInfoData.class, new long[0]).listen(findMultiCallback);
    }

    public static void requestDroneInfoWithSn(String str, FindMultiCallback<DroneInfoData> findMultiCallback) {
        LitePal.where("droneSnId = ?", str).findAsync(DroneInfoData.class).listen(findMultiCallback);
    }

    public static void requestFwVersionInfo(FindMultiCallback<FirmwareInfoData> findMultiCallback) {
        LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(findMultiCallback);
    }

    public static BatteryInfoData requestLastBatteryInfo() {
        return (BatteryInfoData) LitePal.findLast(BatteryInfoData.class);
    }

    public static DroneInfoData requestLastDroneInfo() {
        return (DroneInfoData) LitePal.findLast(DroneInfoData.class);
    }

    public static void saveBatteryInfo(String str, String str2, String str3, String str4) {
        BatteryInfoData batteryInfoData = new BatteryInfoData();
        batteryInfoData.setBatterySnId(str);
        batteryInfoData.setBatteryActiveTime(str2);
        batteryInfoData.setBatteryVersion(str3);
        batteryInfoData.setBatteryType(str4);
        batteryInfoData.save();
    }

    public static boolean saveData(PdfInfo pdfInfo) {
        PdfData pdfData = new PdfData();
        pdfData.setName(pdfInfo.getName());
        pdfData.setPdf_url(pdfInfo.getPdf_url());
        pdfData.setFile_size(pdfInfo.getFile_size());
        pdfData.setImage_url(pdfInfo.getImage_url());
        pdfData.setVersion(pdfInfo.getVersion());
        pdfData.setUpdate(pdfInfo.isUpdate());
        pdfData.setFlag(pdfInfo.getFlag());
        return pdfData.save();
    }

    public static void saveDroneInfo(String str, String str2, String str3, String str4) {
        DroneInfoData droneInfoData = new DroneInfoData();
        droneInfoData.setDroneSnId(str);
        droneInfoData.setDroneActiveTime(str2);
        droneInfoData.setuId(str3);
        droneInfoData.setInsuranceTime(str4);
        droneInfoData.saveOrUpdate(new String[0]);
    }

    public static void saveFwVersionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        FirmwareInfoData firmwareInfoData = new FirmwareInfoData();
        firmwareInfoData.setDroneVersion(str);
        firmwareInfoData.setImageVersion(str2);
        firmwareInfoData.setDroneChipType(str3);
        firmwareInfoData.setImageChipType(str4);
        firmwareInfoData.setDroneType(str5);
        firmwareInfoData.setDroneMd5(str6);
        firmwareInfoData.setImageMd5(str7);
        firmwareInfoData.setRepeaterVersion(str8);
        firmwareInfoData.setRepeaterChipType(str9);
        firmwareInfoData.setRepeaterMd5(str10);
        firmwareInfoData.save();
    }

    public static void saveNewList(ArrayList<ListenerInfoBeans> arrayList, SaveCallback saveCallback) {
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ListenerInfoBeans> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ListenerInfoBeans next = it2.next();
                ListenerListData listenerListData = new ListenerListData();
                listenerListData.setId(String.valueOf(next.getId()));
                listenerListData.setFly_total_time(next.getFly_total_time());
                listenerListData.setFlying_off(next.getFlying_off());
                listenerListData.setMileage(next.getMileage());
                listenerListData.setName(next.getName());
                listenerListData.setSize(next.getSize());
                arrayList2.add(listenerListData);
            }
            LitePal.saveAllAsync(arrayList2).listen(saveCallback);
        }
    }

    public static void saveTotalFlightData(String str, String str2, String str3) {
        ListenerTotalData listenerTotalData = new ListenerTotalData();
        listenerTotalData.setTotalDegree(str);
        listenerTotalData.setTotalMileage(str2);
        listenerTotalData.setTotalFlightTime(str3);
        listenerTotalData.save();
    }

    public static boolean saveUploadInfo(UploadData uploadData) {
        if (uploadData != null) {
            return uploadData.save();
        }
        return false;
    }

    public static synchronized boolean saveUserData(UserInfo userInfo) throws SQLiteCantOpenDatabaseException {
        boolean saveOrUpdate;
        synchronized (UserLiteHelper.class) {
            UserData userData = new UserData();
            userData.setUid(userInfo.getUid());
            userData.setUserName(userInfo.getUserName());
            userData.setIconPath(userInfo.getIconPath());
            userData.setEmail(userInfo.getEmail());
            userData.setPassword(userInfo.getPassword());
            userData.setPhone(userInfo.getPhone());
            userData.setToken(userInfo.getToken());
            userData.setCountry(userInfo.getCountry());
            userData.setTotalFlightTime(userInfo.getTotalFlightTime());
            userData.setTotalMileage(userInfo.getTotalMileage());
            userData.setTotalCount(userInfo.getTotalCount());
            saveOrUpdate = userData.saveOrUpdate(new String[0]);
        }
        return saveOrUpdate;
    }

    public static void updateAllVersion(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("version", str2);
        LitePal.updateAllAsync((Class<?>) PdfData.class, contentValues, "version = ?", str).listen(new UpdateOrDeleteCallback() {
            public void onFinish(int i2) {
                Log.i(UserLiteHelper.TAG, "onFinish: ----update all version num");
            }
        });
    }

    public static void updateBatActiveTime(BatteryInfoData batteryInfoData, String str, String str2) {
        if (!str2.equalsIgnoreCase(batteryInfoData.getBatteryActiveTime())) {
            batteryInfoData.setBatteryActiveTime(str2);
            batteryInfoData.saveOrUpdate("batterySnId = ?", str);
        }
    }

    public static void updateBatType(BatteryInfoData batteryInfoData, String str, String str2) {
        if (!str2.equalsIgnoreCase(batteryInfoData.getBatteryType())) {
            batteryInfoData.setBatteryType(str2);
            batteryInfoData.saveOrUpdate("batterySnId = ?", str);
        }
    }

    public static void updateBatVersion(BatteryInfoData batteryInfoData, String str, String str2) {
        if (!str2.equalsIgnoreCase(batteryInfoData.getBatteryVersion())) {
            batteryInfoData.setBatteryVersion(str2);
            batteryInfoData.saveOrUpdate("batterySnId = ?", str);
        }
    }

    public static void updateBatteryInfo(BatteryInfoData batteryInfoData, String str, String str2, String str3, String str4) {
        boolean z2;
        if (!str2.equalsIgnoreCase(batteryInfoData.getBatteryActiveTime())) {
            batteryInfoData.setBatteryActiveTime(str2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!str3.equalsIgnoreCase(batteryInfoData.getBatteryVersion())) {
            batteryInfoData.setBatteryVersion(str3);
            z2 = true;
        }
        if (!str4.equalsIgnoreCase(batteryInfoData.getBatteryType())) {
            batteryInfoData.setBatteryType(str4);
            z2 = true;
        }
        if (z2) {
            batteryInfoData.saveOrUpdate("batterySnId = ?", str);
        }
    }

    public static void updateData(int i2, PdfInfo pdfInfo, UpdateOrDeleteCallback updateOrDeleteCallback) {
        PdfData pdfData = new PdfData();
        pdfData.setName(pdfInfo.getName());
        pdfData.setPdf_url(pdfInfo.getPdf_url());
        pdfData.setFile_size(pdfInfo.getFile_size());
        pdfData.setVersion(pdfInfo.getVersion());
        pdfData.setUpdate(pdfInfo.isUpdate());
        pdfData.setFlag(pdfInfo.getFlag());
        pdfData.updateAsync((long) i2).listen(updateOrDeleteCallback);
    }

    public static void updateDroneActiveTime(DroneInfoData droneInfoData, String str, String str2) {
        if (!str2.equalsIgnoreCase(droneInfoData.getDroneActiveTime())) {
            droneInfoData.setDroneActiveTime(str2);
            droneInfoData.saveOrUpdate("droneSnId = ?", str);
        }
    }

    public static void updateDroneChipType(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getDroneChipType())) {
                            firmwareInfoData.setDroneChipType(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getDroneChipType())) {
            firmwareInfoData.setDroneChipType(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateDroneMd5(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getDroneMd5())) {
                            firmwareInfoData.setDroneMd5(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getDroneMd5())) {
            firmwareInfoData.setDroneMd5(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateDroneType(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getDroneType())) {
                            firmwareInfoData.setDroneType(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getDroneType())) {
            firmwareInfoData.setDroneType(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateDroneVersion(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getDroneVersion())) {
                            firmwareInfoData.setDroneVersion(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getDroneVersion())) {
            firmwareInfoData.setDroneVersion(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateFileSize(int i2, String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        PdfData pdfData = new PdfData();
        pdfData.setFile_size(str);
        pdfData.updateAsync((long) i2).listen(updateOrDeleteCallback);
    }

    public static void updateImageChipType(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getImageChipType())) {
                            firmwareInfoData.setImageChipType(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getImageChipType())) {
            firmwareInfoData.setImageChipType(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateImageMd5(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getImageMd5())) {
                            firmwareInfoData.setImageMd5(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getImageMd5())) {
            firmwareInfoData.setImageMd5(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateImageUrl(int i2, String str) {
        PdfData pdfData = new PdfData();
        pdfData.setImage_url(str);
        pdfData.updateAsync((long) i2).listen(new UpdateOrDeleteCallback() {
            public void onFinish(int i2) {
                String access$000 = UserLiteHelper.TAG;
                Log.i(access$000, "onFinish: ---update image url----" + i2);
            }
        });
    }

    public static void updateImageVersion(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getImageVersion())) {
                            firmwareInfoData.setImageVersion(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getImageVersion())) {
            firmwareInfoData.setImageVersion(str);
            firmwareInfoData.update(1);
        }
    }

    public static int updateInfo(int i2, UserInfo userInfo) {
        UserData userData = new UserData();
        userData.setUid(userInfo.getUid());
        userData.setUserName(userInfo.getUserName());
        userData.setUserMale(userInfo.getUserMale());
        userData.setIconPath(userInfo.getIconPath());
        userData.setEmail(userInfo.getEmail());
        userData.setPhone(userInfo.getPhone());
        userData.setToken(userInfo.getToken());
        userData.setPassword(userInfo.getPassword());
        userData.setCountry(userInfo.getCountry());
        userData.setTotalFlightTime(userInfo.getTotalFlightTime());
        userData.setTotalMileage(userInfo.getTotalMileage());
        userData.setTotalCount(userInfo.getTotalCount());
        return userData.update((long) i2);
    }

    public static synchronized void updateIsUpdate(int i2, boolean z2) {
        synchronized (UserLiteHelper.class) {
            PdfData pdfData = new PdfData();
            pdfData.setUpdate(z2);
            pdfData.updateAsync((long) i2).listen(new UpdateOrDeleteCallback() {
                public void onFinish(int i2) {
                    String access$000 = UserLiteHelper.TAG;
                    Log.i(access$000, "onFinish: ---update pdf updateState----" + i2);
                }
            });
        }
    }

    public static void updatePdfName(int i2, String str, UpdateOrDeleteCallback updateOrDeleteCallback) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        LitePal.updateAsync(PdfData.class, contentValues, (long) i2).listen(updateOrDeleteCallback);
    }

    public static void updatePdfUrl(int i2, String str) {
        PdfData pdfData = new PdfData();
        pdfData.setPdf_url(str);
        pdfData.updateAsync((long) i2).listen(new UpdateOrDeleteCallback() {
            public void onFinish(int i2) {
                String access$000 = UserLiteHelper.TAG;
                Log.i(access$000, "onFinish: ---update pdf_url----" + i2);
            }
        });
    }

    public static void updateRepeaterChipType(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getRepeaterChipType())) {
                            firmwareInfoData.setRepeaterChipType(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getRepeaterChipType())) {
            firmwareInfoData.setRepeaterChipType(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateRepeaterMd5(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getRepeaterMd5())) {
                            firmwareInfoData.setRepeaterMd5(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getRepeaterMd5())) {
            firmwareInfoData.setRepeaterMd5(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateRepeaterVersion(FirmwareInfoData firmwareInfoData, final String str) {
        if (firmwareInfoData == null) {
            LitePal.findAllAsync(FirmwareInfoData.class, new long[0]).listen(new FindMultiCallback<FirmwareInfoData>() {
                public void onFinish(List<FirmwareInfoData> list) {
                    if (list != null && list.size() > 0) {
                        FirmwareInfoData firmwareInfoData = list.get(0);
                        if (!str.equals(firmwareInfoData.getRepeaterVersion())) {
                            firmwareInfoData.setRepeaterVersion(str);
                            firmwareInfoData.update(1);
                        }
                    }
                }
            });
        } else if (!str.equals(firmwareInfoData.getRepeaterVersion())) {
            firmwareInfoData.setRepeaterVersion(str);
            firmwareInfoData.update(1);
        }
    }

    public static void updateTotalFlightData(int i2, String str, String str2, String str3) {
        ListenerTotalData listenerTotalData = new ListenerTotalData();
        listenerTotalData.setTotalDegree(str);
        listenerTotalData.setTotalMileage(str2);
        listenerTotalData.setTotalFlightTime(str3);
        listenerTotalData.update((long) i2);
    }

    public static void updateUploadInfo(UploadData uploadData, UpdateOrDeleteCallback updateOrDeleteCallback) {
        if (uploadData != null) {
            uploadData.updateAllAsync("filename = ?", uploadData.getFileName()).listen(updateOrDeleteCallback);
        }
    }

    public static void updateUserEmail(String str, String str2, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setEmail(str2);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserFlight(String str, float f2, float f3, float f4, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setTotalFlightTime(f2);
        userData.setTotalMileage(f3);
        userData.setTotalCount(f4);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserIcon(String str, String str2, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setIconPath(str2);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserInfoByUid(String str, UserInfo userInfo, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setUserName(userInfo.getUserName());
        userData.setUserMale(userInfo.getUserMale());
        userData.setIconPath(userInfo.getIconPath());
        userData.setEmail(userInfo.getEmail());
        userData.setPhone(userInfo.getPhone());
        userData.setToken(userInfo.getToken());
        userData.setPassword(userInfo.getPassword());
        userData.setCountry(userInfo.getCountry());
        userData.setTotalFlightTime(userInfo.getTotalFlightTime());
        userData.setTotalMileage(userInfo.getTotalMileage());
        userData.setTotalCount(userInfo.getTotalCount());
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserName(String str, String str2, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setUserName(str2);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserPassword(String str, String str2, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setPassword(str2);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static void updateUserPhone(String str, String str2, SaveCallback saveCallback) {
        UserData userData = new UserData();
        userData.setPhone(str2);
        userData.saveOrUpdateAsync("uid = ?", str).listen(saveCallback);
    }

    public static boolean updateUserToken(String str, String str2) {
        Log.i("ServeTest", "updateUserToken:===uid=== " + str);
        UserData userData = (UserData) LitePal.where("uid=?", str).findFirst(UserData.class);
        if (userData == null) {
            return false;
        }
        userData.setToken(str2);
        userData.saveOrUpdate("uid=?", str);
        return true;
    }

    public static void updateVersion(int i2, String str) {
        PdfData pdfData = new PdfData();
        pdfData.setVersion(str);
        pdfData.updateAsync((long) i2).listen(new UpdateOrDeleteCallback() {
            public void onFinish(int i2) {
                String access$000 = UserLiteHelper.TAG;
                Log.i(access$000, "onFinish: ---update pdf version----" + i2);
            }
        });
    }
}
