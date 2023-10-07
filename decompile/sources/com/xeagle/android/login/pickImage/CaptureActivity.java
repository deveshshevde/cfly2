package com.xeagle.android.login.pickImage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.a;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.CameraPreview;
import com.xeagle.android.login.common.CameraUtils;
import com.xeagle.android.login.common.CircleProgressView;
import com.xeagle.android.login.common.ConfirmationDialog;
import com.xeagle.android.login.common.ErrorDialog;
import com.xeagle.android.login.common.ImageUtil;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CaptureActivity extends AppCompatActivity {
    public static final String PERMISSIONS_FRAGMENT_DIALOG = "permission_dialog";
    public static int RECORD_MAX_TIME = 15;
    public static int RECORD_MIN_TIME = 1;
    public static final int REQUEST_VIDEO_PERMISSIONS = 1;
    /* access modifiers changed from: private */
    public static final String TAG = "CaptureActivity";
    public static final String[] VIDEO_PERMISSIONS = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    public static final int VIDEO_PERMISSIONS_REQUEST_CODE = 1;
    private int cameraId;
    private TextView cameraTip;
    private View captureButton;
    /* access modifiers changed from: private */
    public ImageView capturebg;
    /* access modifiers changed from: private */
    public int currentTime;
    /* access modifiers changed from: private */
    public boolean isAction = false;
    private boolean isCameraFront = false;
    /* access modifiers changed from: private */
    public boolean isRecording = false;
    private ImageView ivClose;
    private ImageView ivSwitchCamera;
    /* access modifiers changed from: private */
    public LongPressRunnable longPressRunnable;
    private Camera mCamera;
    private MediaRecorder mMediaRecorder;
    private OrientationEventListener mOrientationListener;
    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] bArr, Camera camera) {
            String str;
            String str2;
            StringBuilder sb;
            long now_millisecond = TimeUtil.getNow_millisecond();
            File outputMediaFile = CameraUtils.getOutputMediaFile(CaptureActivity.this.getApplicationContext(), 1, String.valueOf(now_millisecond));
            if (outputMediaFile == null) {
                Log.d(CaptureActivity.TAG, "Error creating media file, check storage permissions");
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(outputMediaFile);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                String unused = CaptureActivity.this.pictureSavePath = outputMediaFile.getAbsolutePath();
                String name = outputMediaFile.getName();
                BitmapFactory.Options options = ImageUtil.getOptions(CaptureActivity.this.pictureSavePath);
                ImagePreviewRetakeActivity.start((Activity) CaptureActivity.this, GLImage.Builder.newBuilder().setWidth(options.outWidth).setHeight(options.outHeight).setMimeType(options.outMimeType).setPath(CaptureActivity.this.pictureSavePath).setName(name).setSize(outputMediaFile.length()).setAddTime(now_millisecond).build());
                return;
            } catch (FileNotFoundException e2) {
                str = CaptureActivity.TAG;
                sb = new StringBuilder();
                sb.append("File not found: ");
                str2 = e2.getMessage();
            } catch (IOException e3) {
                str = CaptureActivity.TAG;
                sb = new StringBuilder();
                sb.append("Error accessing file: ");
                str2 = e3.getMessage();
            }
            sb.append(str2);
            Log.d(str, sb.toString());
        }
    };
    private CameraPreview mPreview;
    /* access modifiers changed from: private */
    public CircleProgressView mProgressView;
    /* access modifiers changed from: private */
    public Handler mainHandler;
    /* access modifiers changed from: private */
    public String pictureSavePath;
    private Runnable progressRunnable = new Runnable() {
        public void run() {
            CaptureActivity.access$1208(CaptureActivity.this);
            String access$100 = CaptureActivity.TAG;
            Log.i(access$100, "recordRunnable currentTime:" + CaptureActivity.this.currentTime);
            CaptureActivity.this.mProgressView.setVisibility(0);
            CaptureActivity.this.mProgressView.setIsStart(true);
            CaptureActivity.this.tvBalanceTime.setVisibility(0);
            TextView access$1400 = CaptureActivity.this.tvBalanceTime;
            access$1400.setText((CaptureActivity.RECORD_MAX_TIME - CaptureActivity.this.currentTime) + "s");
            if (CaptureActivity.this.currentTime > CaptureActivity.RECORD_MAX_TIME) {
                boolean unused = CaptureActivity.this.isAction = false;
                CaptureActivity.this.stopMediaRecorder();
                return;
            }
            CaptureActivity.this.mainHandler.postDelayed(this, 1000);
        }
    };
    /* access modifiers changed from: private */
    public TextView tvBalanceTime;
    private int videoHeight;
    private String videoSavePath;
    private int videoWidth;

    private class LongPressRunnable implements Runnable {
        private LongPressRunnable() {
        }

        public void run() {
            if (CaptureActivity.this.prepareVideoRecorder()) {
                CaptureActivity.this.startMediaRecorder();
            } else {
                CaptureActivity.this.releaseMediaRecorder();
            }
        }
    }

    static /* synthetic */ int access$1208(CaptureActivity captureActivity) {
        int i2 = captureActivity.currentTime;
        captureActivity.currentTime = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void handleActionUpByState() {
        this.mainHandler.removeCallbacks(this.longPressRunnable);
        if (this.isRecording) {
            stopMediaRecorder();
        } else {
            takePicture();
        }
    }

    private boolean hasPermissionsGranted(String[] strArr) {
        for (String b2 : strArr) {
            if (a.b((Context) this, b2) != 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean prepareVideoRecorder() {
        String str;
        StringBuilder sb;
        String message;
        this.mMediaRecorder = new MediaRecorder();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setAudioSource(5);
        this.mMediaRecorder.setVideoSource(1);
        setupProfile();
        String absolutePath = CameraUtils.getOutputMediaFile(getApplicationContext(), 3, String.valueOf(TimeUtil.getNow_millisecond())).getAbsolutePath();
        this.videoSavePath = absolutePath;
        this.mMediaRecorder.setOutputFile(absolutePath);
        this.mMediaRecorder.setPreviewDisplay(this.mPreview.getHolder().getSurface());
        int displayOrientation = CameraUtils.getDisplayOrientation(this, this.cameraId, this.mCamera, true);
        this.mMediaRecorder.setOrientationHint(displayOrientation);
        if (displayOrientation == displayOrientation || displayOrientation == 270) {
            int i2 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i2;
        }
        try {
            this.mMediaRecorder.prepare();
            return true;
        } catch (IllegalStateException e2) {
            str = TAG;
            sb = new StringBuilder();
            sb.append("IllegalStateException preparing MediaRecorder: ");
            message = e2.getMessage();
            sb.append(message);
            Log.d(str, sb.toString());
            releaseMediaRecorder();
            return false;
        } catch (IOException e3) {
            str = TAG;
            sb = new StringBuilder();
            sb.append("IOException preparing MediaRecorder: ");
            message = e3.getMessage();
            sb.append(message);
            Log.d(str, sb.toString());
            releaseMediaRecorder();
            return false;
        }
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
        }
    }

    /* access modifiers changed from: private */
    public void releaseMediaRecorder() {
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
            this.mCamera.lock();
        }
    }

    private void requestVideoPermissions() {
        String[] strArr = VIDEO_PERMISSIONS;
        if (shouldShowRequestPermissionRationale(strArr)) {
            new ConfirmationDialog().show(getFragmentManager(), PERMISSIONS_FRAGMENT_DIALOG);
        } else {
            a.a(this, strArr, 1);
        }
    }

    private void setupCamera() {
        Pair<Camera, Integer> cameraInstance = CameraUtils.getCameraInstance(this.isCameraFront);
        this.mCamera = (Camera) cameraInstance.first;
        this.cameraId = ((Integer) cameraInstance.second).intValue();
        if (this.mCamera == null) {
            ToastHelper.showToast((Context) this, getString(R.string.device_abnormal));
            finish();
        }
        Camera.Parameters parameters = this.mCamera.getParameters();
        if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        }
        CameraUtils.Size choosePictureSize = CameraUtils.choosePictureSize(parameters.getSupportedPictureSizes());
        parameters.setPictureSize(choosePictureSize.getWidth(), choosePictureSize.getHeight());
        parameters.setPictureFormat(256);
        parameters.setRotation(CameraUtils.getPictureRotation(this, this.cameraId));
        this.mCamera.setDisplayOrientation(CameraUtils.getDisplayOrientation(this, this.cameraId, this.mCamera, false));
        this.mCamera.setParameters(parameters);
        this.mPreview.setCamera(this.mCamera, this.isCameraFront);
    }

    private void setupProfile() {
        int i2 = 5;
        if (!CamcorderProfile.hasProfile(5)) {
            i2 = 4;
            if (!CamcorderProfile.hasProfile(4)) {
                i2 = 7;
                if (!CamcorderProfile.hasProfile(7)) {
                    i2 = 3;
                    if (!CamcorderProfile.hasProfile(3)) {
                        this.videoWidth = 960;
                        this.videoHeight = 540;
                        this.mMediaRecorder.setOutputFormat(0);
                        this.mMediaRecorder.setVideoFrameRate(30);
                        this.mMediaRecorder.setVideoSize(this.videoWidth, this.videoHeight);
                        this.mMediaRecorder.setVideoEncodingBitRate(1500000);
                        this.mMediaRecorder.setVideoEncoder(0);
                        this.mMediaRecorder.setAudioEncodingBitRate(96000);
                        this.mMediaRecorder.setAudioChannels(1);
                        this.mMediaRecorder.setAudioSamplingRate(48000);
                        this.mMediaRecorder.setAudioEncoder(0);
                        return;
                    }
                }
            }
        }
        CamcorderProfile camcorderProfile = CamcorderProfile.get(i2);
        this.mMediaRecorder.setProfile(camcorderProfile);
        this.mMediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate / 8);
        this.videoWidth = camcorderProfile.videoFrameWidth;
        this.videoHeight = camcorderProfile.videoFrameHeight;
    }

    private void setupSurfaceIfNeeded() {
        if (this.mPreview == null) {
            this.mPreview = new CameraPreview(this);
            ((FrameLayout) findViewById(R.id.camera_preview)).addView(this.mPreview);
        }
    }

    private void setupTouchListener() {
        this.longPressRunnable = new LongPressRunnable();
        this.captureButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    boolean unused = CaptureActivity.this.isAction = true;
                    boolean unused2 = CaptureActivity.this.isRecording = false;
                    CaptureActivity.this.mainHandler.postDelayed(CaptureActivity.this.longPressRunnable, 500);
                } else if ((action == 1 || action == 3) && CaptureActivity.this.isAction) {
                    boolean unused3 = CaptureActivity.this.isAction = false;
                    CaptureActivity.this.handleActionUpByState();
                }
                return true;
            }
        });
    }

    private boolean shouldShowRequestPermissionRationale(String[] strArr) {
        for (String a2 : strArr) {
            if (a.a((Activity) this, a2)) {
                return true;
            }
        }
        return false;
    }

    public static void start(Activity activity) {
        start(activity, Constants.RESULT_CODE_RECORD_VIDEO);
    }

    public static void start(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            ToastHelper.showToast((Context) activity, activity.getString(R.string.system_not_support_camera));
        } else {
            activity.startActivityForResult(new Intent(activity, CaptureActivity.class), i2);
        }
    }

    /* access modifiers changed from: private */
    public void startMediaRecorder() {
        this.mMediaRecorder.start();
        this.isRecording = true;
        startButtonAnimation();
        this.currentTime = 0;
        this.mainHandler.postDelayed(this.progressRunnable, 0);
    }

    /* access modifiers changed from: private */
    public void stopMediaRecorder() {
        try {
            this.mMediaRecorder.stop();
        } catch (RuntimeException unused) {
        }
        releaseMediaRecorder();
        this.mCamera.lock();
        this.isRecording = false;
        this.mainHandler.removeCallbacks(this.progressRunnable);
        stopButtonAnimation();
        this.tvBalanceTime.setVisibility(8);
        this.mProgressView.reset();
        String str = TAG;
        Log.i(str, "stopMediaRecorder currentTime:" + this.currentTime);
        if (this.currentTime <= RECORD_MIN_TIME) {
            Toast.makeText(this, getString(R.string.record_time_short), 1).show();
        } else {
            GLVideoConfirmActivity.start(this, Uri.fromFile(new File(this.videoSavePath)), (long) (this.currentTime * 1000));
        }
    }

    /* access modifiers changed from: private */
    public void switchCamera() {
        this.mCamera.stopPreview();
        releaseCamera();
        this.isCameraFront = !this.isCameraFront;
        setupCamera();
        this.mCamera.startPreview();
    }

    private void takePicture() {
        this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this.mPicture);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        File file;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1008) {
            if (i3 == -1) {
                GLImage build = GLImage.Builder.newBuilder().setAddTime(TimeUtil.getNow_millisecond()).setDuration((long) (this.currentTime * 1000)).setSize(new File(this.videoSavePath).length()).setHeight(this.videoHeight).setWidth(this.videoWidth).setMimeType("video/mp4").setPath(this.videoSavePath).build();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(build);
                Intent intent2 = new Intent();
                intent2.putExtra(Constants.EXTRA_RESULT_ITEMS, arrayList);
                setResult(-1, intent2);
            } else {
                file = new File(this.videoSavePath);
                file.delete();
                return;
            }
        } else if (i2 != 1009) {
            return;
        } else {
            if (i3 == -1) {
                Intent intent3 = new Intent();
                intent3.putExtra(Constants.EXTRA_RESULT_ITEMS, (ArrayList) intent.getSerializableExtra(Constants.RESULT_EXTRA_CONFIRM_IMAGES));
                setResult(-1, intent3);
            } else {
                file = new File(this.pictureSavePath);
                file.delete();
                return;
            }
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        setContentView((int) R.layout.camera_activity);
        this.mainHandler = new Handler();
        this.captureButton = findViewById(R.id.button_capture);
        setupTouchListener();
        this.mProgressView = (CircleProgressView) findViewById(R.id.progressView);
        this.tvBalanceTime = (TextView) findViewById(R.id.tv_balanceTime);
        this.ivSwitchCamera = (ImageView) findViewById(R.id.iv_switchCamera);
        this.cameraTip = (TextView) findViewById(R.id.camera_tip);
        this.ivClose = (ImageView) findViewById(R.id.iv_close);
        this.capturebg = (ImageView) findViewById(R.id.button_capture_bg);
        this.ivSwitchCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CaptureActivity.this.switchCamera();
            }
        });
        this.ivClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CaptureActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        releaseMediaRecorder();
        releaseCamera();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Log.d(TAG, "onRequestPermissionsResult");
        if (i2 == 1) {
            if (iArr.length == VIDEO_PERMISSIONS.length) {
                int length = iArr.length;
                int i3 = 0;
                while (i3 < length) {
                    if (iArr[i3] == 0) {
                        i3++;
                    }
                }
                return;
            }
            ErrorDialog.newInstance(getString(R.string.permission_request)).show(getFragmentManager(), PERMISSIONS_FRAGMENT_DIALOG);
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!hasPermissionsGranted(VIDEO_PERMISSIONS)) {
            requestVideoPermissions();
            return;
        }
        setupSurfaceIfNeeded();
        setupCamera();
    }

    public void startButtonAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.capturebg, "scaleX", new float[]{1.0f, 1.4f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.capturebg, "scaleY", new float[]{1.0f, 1.4f});
        animatorSet.setDuration(100);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                CaptureActivity.this.capturebg.setVisibility(4);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
        this.cameraTip.setVisibility(4);
    }

    public void stopButtonAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.capturebg, "scaleX", new float[]{1.4f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.capturebg, "scaleY", new float[]{1.4f, 1.0f});
        this.capturebg.setVisibility(0);
        animatorSet.setDuration(100);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        this.cameraTip.setVisibility(0);
    }
}
