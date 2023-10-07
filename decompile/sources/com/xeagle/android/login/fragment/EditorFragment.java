package com.xeagle.android.login.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.editor.activity.EditorSelectorActivity;
import com.xeagle.android.editor.widget.a;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.ImagePickerOption;
import com.xeagle.android.login.pickImage.data.AbsDataSource;
import com.xeagle.android.login.pickImage.data.DataSourceFactory;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.data.ImageFolder;
import com.xeagle.android.login.pickImage.data.VideoDataSource;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jz.b;
import kx.d;

public class EditorFragment extends Fragment implements View.OnClickListener, AbsDataSource.OnImagesLoadedListener {
    private static final String KEY_PICKER_OPTION = "picker_option";
    /* access modifiers changed from: private */
    public ArrayList<String> arrays;
    private VideoDataSource dataSource;
    private ArrayList<GLImage> glImages;
    private IImageButton ib_editor_freedom;
    private IImageButton ib_editor_one_key;
    /* access modifiers changed from: private */
    public ImagePicker imagePicker;
    private RecyclerView list_editor_video;
    private List<ImageFolder> mImageFolders;
    /* access modifiers changed from: private */
    public HostManagerActivity parent;
    /* access modifiers changed from: private */
    public a popUpWindow;
    /* access modifiers changed from: private */
    public TextView pop_editor_type;
    /* access modifiers changed from: private */
    public int selectedPosition = 0;
    private TextView tv_editor_works;
    private b typeAdapter;

    private void createPopupFolderList() {
        if (this.popUpWindow == null) {
            this.pop_editor_type.setText(this.arrays.get(this.imagePicker.getCurrentImageFolderPosition()));
            this.popUpWindow = new a(this.parent, new a.C0145a() {
                public void onItemClick(int i2) {
                    EditorFragment editorFragment;
                    ImagePickerOption option;
                    String l2;
                    String str;
                    int unused = EditorFragment.this.selectedPosition = i2;
                    EditorFragment.this.imagePicker.setCurrentImageFolderPosition(i2);
                    EditorFragment.this.pop_editor_type.setText((CharSequence) EditorFragment.this.arrays.get(i2));
                    if (i2 == 1) {
                        editorFragment = EditorFragment.this;
                        option = editorFragment.imagePicker.getOption();
                        l2 = d.l(EditorFragment.this.parent.getApplicationContext());
                        str = "free";
                    } else if (i2 == 2) {
                        editorFragment = EditorFragment.this;
                        option = editorFragment.imagePicker.getOption();
                        l2 = d.l(EditorFragment.this.parent.getApplicationContext());
                        str = "oneKey";
                    } else {
                        editorFragment = EditorFragment.this;
                        option = editorFragment.imagePicker.getOption();
                        l2 = d.l(EditorFragment.this.parent.getApplicationContext());
                        str = null;
                    }
                    editorFragment.loadVideoData(option, l2, str);
                    EditorFragment.this.popUpWindow.dismiss();
                }
            });
        }
    }

    private void initOption(Bundle bundle) {
        ImagePicker instance = ImagePicker.getInstance();
        this.imagePicker = instance;
        instance.clear();
        this.imagePicker.setOption(new ImagePickerOption().setPickType(ImagePickerOption.PickType.Video));
    }

    private void initView(View view) {
        this.ib_editor_freedom = (IImageButton) view.findViewById(R.id.ib_editor_freedom);
        this.ib_editor_one_key = (IImageButton) view.findViewById(R.id.ib_editor_one_key);
        this.pop_editor_type = (TextView) view.findViewById(R.id.pop_editor_type);
        this.list_editor_video = (RecyclerView) view.findViewById(R.id.list_editor_video);
        TextView textView = (TextView) view.findViewById(R.id.tv_editor_works);
        this.tv_editor_works = textView;
        textView.setText(String.format(Locale.US, getString(R.string.tv_editor_works), new Object[]{0}));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.parent.getApplicationContext());
        linearLayoutManager.b(1);
        this.list_editor_video.setLayoutManager(linearLayoutManager);
        this.glImages = new ArrayList<>();
        b bVar = new b(this.parent.getApplicationContext(), this.glImages);
        this.typeAdapter = bVar;
        this.list_editor_video.setAdapter(bVar);
        this.typeAdapter.a((b.C0205b) new b.C0205b() {
            public void onClick(int i2) {
            }

            public void onItemClick(int i2) {
            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        this.arrays = arrayList;
        arrayList.add(this.parent.getString(R.string.editor_all));
        this.arrays.add(this.parent.getString(R.string.editor_freedom));
        this.arrays.add(this.parent.getString(R.string.editor_one_key));
        createPopupFolderList();
        loadVideoData(this.imagePicker.getOption(), d.l(this.parent), (String) null);
        this.ib_editor_one_key.setOnClickListener(this);
        this.ib_editor_freedom.setOnClickListener(this);
        this.pop_editor_type.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void loadVideoData(ImagePickerOption imagePickerOption, String str, String str2) {
        VideoDataSource videoDataSource = this.dataSource;
        if (videoDataSource == null) {
            VideoDataSource videoDataSource2 = (VideoDataSource) DataSourceFactory.create(this.parent, (String) null, imagePickerOption.getPickType());
            this.dataSource = videoDataSource2;
            videoDataSource2.setLoadedListener(this);
        } else {
            videoDataSource.restartLoad();
        }
        this.dataSource.setFilePath(str);
        this.dataSource.setType(str2);
        this.dataSource.reload();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (HostManagerActivity) activity;
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ib_editor_freedom) {
            this.imagePicker.setOption(new ImagePickerOption().setPickType(ImagePickerOption.PickType.Video).setCrop(false).setMixMode(true).setMultiMode(true).setSelectMax(9).setMaxVideoDuration(600));
            this.parent.startActivity(new Intent(this.parent, EditorSelectorActivity.class));
        } else if (id2 == R.id.pop_editor_type) {
            if (this.popUpWindow.isShowing()) {
                this.popUpWindow.dismiss();
                return;
            }
            this.popUpWindow.a(this.imagePicker.getCurrentImageFolderPosition());
            this.popUpWindow.showAsDropDown(this.pop_editor_type, 48, 0, 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.video_editor_layout, viewGroup, false);
    }

    public void onImagesLoaded(List<ImageFolder> list) {
        this.mImageFolders = list;
        if (list.size() > 0) {
            this.tv_editor_works.setText(String.format(Locale.US, getString(R.string.tv_editor_works), new Object[]{Integer.valueOf(list.get(0).images.size())}));
            this.typeAdapter.a(this.mImageFolders.get(0).images);
            return;
        }
        this.tv_editor_works.setText(String.format(Locale.US, getString(R.string.tv_editor_works), new Object[]{0}));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initOption(bundle);
        initView(view);
    }
}
