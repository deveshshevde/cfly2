package com.xeagle.android.login.listener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.flypro.core.database.UploadData;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UploadCallBack;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.prefs.a;
import io.reactivex.disposables.b;
import io.reactivex.f;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kx.d;
import okhttp3.aa;
import okhttp3.v;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import retrofit2.Call;
import retrofit2.Response;

public class UploadListenerService extends Service implements RegContract.lLoadView {
    private b disposable;
    /* access modifiers changed from: private */

    /* renamed from: info  reason: collision with root package name */
    public UserInfo f23802info;
    /* access modifiers changed from: private */
    public boolean isUpload;
    private a prefs;
    /* access modifiers changed from: private */
    public RegPresenter presenter;

    /* access modifiers changed from: private */
    public void handleListener() {
        UserLiteHelper.getUploadListener(new FindMultiCallback<UploadData>() {
            public void onFinish(final List<UploadData> list) {
                if (list == null || list.size() <= 0) {
                    boolean unused = UploadListenerService.this.isUpload = false;
                    UploadListenerService.this.stopSelf();
                    return;
                }
                Log.i("ServeTest", "onFinish:---list size--- " + list.size());
                Log.i("ServeTest", "onFinish:---list name--- " + list.get(0).getFileName());
                if (list.get(0).getFlying_off() == null || list.get(0).getFileName() == null) {
                    UserLiteHelper.deleteUploadDataByName(list.get(0).getFileName(), new UpdateOrDeleteCallback() {
                        public void onFinish(int i2) {
                            if (i2 != 0) {
                                UploadListenerService.this.handleListener();
                            } else {
                                UserLiteHelper.deleteAllUploadData();
                            }
                        }
                    });
                    return;
                }
                final String str = d.d(UploadListenerService.this.getApplicationContext()) + list.get(0).getFileName();
                HashMap hashMap = new HashMap();
                Log.i("ServeTest", "onFinish:---token--- " + UploadListenerService.this.f23802info.getToken());
                if (list.get(0).getFly_total_time() == null || list.get(0).getMileage() == null) {
                    UserLiteHelper.deleteUploadDataByName(list.get(0).getFileName(), new UpdateOrDeleteCallback() {
                        public void onFinish(int i2) {
                            if (i2 != 0) {
                                UploadListenerService.this.handleListener();
                            } else {
                                UserLiteHelper.deleteAllUploadData();
                            }
                        }
                    });
                } else if (UploadListenerService.this.f23802info != null) {
                    boolean unused2 = UploadListenerService.this.isUpload = true;
                    UploadListenerService uploadListenerService = UploadListenerService.this;
                    hashMap.put("token", uploadListenerService.toRequestBody(uploadListenerService.f23802info.getToken()));
                    hashMap.put("flying_off", UploadListenerService.this.toRequestBody(list.get(0).getFlying_off()));
                    hashMap.put("fly_total_time", UploadListenerService.this.toRequestBody(list.get(0).getFly_total_time()));
                    hashMap.put("mileage", UploadListenerService.this.toRequestBody(list.get(0).getMileage()));
                    if (list.get(0).getDroneSn() != null) {
                        hashMap.put("drone_sn", UploadListenerService.this.toRequestBody(list.get(0).getDroneSn()));
                    }
                    if (list.get(0).getBatterySn() != null) {
                        hashMap.put("battery_sn", UploadListenerService.this.toRequestBody(list.get(0).getBatterySn()));
                    }
                    hf.d.b("LOOK_LOGzzz", "上传地址：" + str);
                    UploadListenerService.this.presenter.uploadFile(UserGlobal.BASE_URL, str, hashMap, new UploadCallBack<UploadAcceptBeans>() {
                        public void onFailure(Call<UploadAcceptBeans> call, Throwable th) {
                            hf.d.b("LOOK_LOGzzz", "上传失败" + th.getMessage());
                            boolean unused = UploadListenerService.this.isUpload = false;
                            if (!new File(str).exists()) {
                                UserLiteHelper.deleteUploadDataByName(((UploadData) list.get(0)).getFileName(), new UpdateOrDeleteCallback() {
                                    public void onFinish(int i2) {
                                        hf.d.b("LOOK_LOGzzz", "上传失败删除本地文件成功");
                                        if (i2 != 0) {
                                            UploadListenerService.this.handleListener();
                                        } else {
                                            UserLiteHelper.deleteAllUploadData();
                                        }
                                    }
                                });
                            }
                        }

                        public void onLoading(long j2, long j3) {
                            super.onLoading(j2, j3);
                            Log.i("ServeTest", String.format(Locale.US, "onLoading---upload listener progress--%d / %d", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}));
                        }

                        public void onSuccess(Call<UploadAcceptBeans> call, Response<UploadAcceptBeans> response) {
                            hf.d.b("LOOK_LOGzzz", "上传成功");
                            UserLiteHelper.deleteUploadData(((UploadData) list.get(0)).getFlying_off(), new UpdateOrDeleteCallback() {
                                public void onFinish(int i2) {
                                    hf.d.b("LOOK_LOGzzz", "上传成功删除本地文件成功");
                                    boolean unused = UploadListenerService.this.isUpload = false;
                                    UploadListenerService.this.handleListener();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public aa toRequestBody(String str) {
        return aa.create(v.b("text/plain"), str);
    }

    public /* synthetic */ void lambda$onCreate$0$UploadListenerService(Long l2) throws Exception {
        if (!this.isUpload && kw.b.a(this)) {
            handleListener();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        a j2 = ((XEagleApp) getApplication()).j();
        this.prefs = j2;
        this.f23802info = UserLiteHelper.getUserInfo(j2.aE());
        this.presenter = new RegPresenter(this);
        Log.i("LOOK_LOG", "onCreate: 启动上传飞行日志服务");
        this.disposable = f.a(0, 3, TimeUnit.SECONDS).b(lz.a.b()).a(lu.a.a()).a(new lv.d() {
            public final void accept(Object obj) {
                UploadListenerService.this.lambda$onCreate$0$UploadListenerService((Long) obj);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("LOOK_LOG", "onCreate: 关闭上传飞行日志服务");
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
        stopSelf();
        this.isUpload = false;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    public void regError(int i2, String str) {
        Log.i("ServeTest", "regError: =====" + str);
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
    }
}
