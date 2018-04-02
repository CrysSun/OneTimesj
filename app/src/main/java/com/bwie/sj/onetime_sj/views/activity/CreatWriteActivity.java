package com.bwie.sj.onetime_sj.views.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.bean.UserInfoBean;
import com.bwie.sj.onetime_sj.model.CreatModelImpl;
import com.bwie.sj.onetime_sj.presenter.CreatPresenterImpl;
import com.bwie.sj.onetime_sj.views.IShowView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class CreatWriteActivity extends BaseAcrivity implements IShowView {


    @BindView(R.id.writ_back)
    TextView writBack;
    @BindView(R.id.writ_tv)
    TextView writTv;
    @BindView(R.id.creat_start)
    TextView creatStart;
    @BindView(R.id.writ_msg)
    EditText writMsg;
    @BindView(R.id.writ_jia)
    ImageView writJia;

    private String userUid;
    private String userToken;

    //    private Button take_photo,select_photo;
    public static final int TAKE_PHOTO = 1;
    public static final int SELECT_PHOTO = 2;
    private ImageView imageview;
    private Uri imageUri;
    private static final String TAG = "CreatWriteActivity";
    private TextView photo_pop;
    private TextView camera_pop;
    private TextView cancle_pop;
    private PopupWindow popupWindow;
    private Uri imagFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creat_write);
        ButterKnife.bind(this);
        //注册eventbus
        EventBus.getDefault().register(this);
    }

    //接收eventbus传过来的值
    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onNewsEvent(UserInfoBean userInfoBean) {
        this.userUid = userInfoBean.getUid();
        this.userToken = userInfoBean.getToken();
    }

    //沉浸式绑定
    @Override
    protected int bindLayout() {
        return R.layout.creat_write;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //设置沉浸式状态栏
        setStatus(true);
        //是否显示actionbar
        setShowActionBar(false);
        //是否全屏
        setFullScreen(true);
    }

    @OnClick({R.id.writ_back, R.id.creat_start, R.id.writ_jia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.writ_back:
                //底部弹出框
//                initDialog();

                break;
            case R.id.creat_start:
                initStart();
                break;
            case R.id.writ_jia:
                //调用系统相机  从相册获取图片
                initPopCamera();
                break;
        }
    }

    //弹出框
    private void initPopCamera() {
        View contentView = LayoutInflater.from(CreatWriteActivity.this).inflate(R.layout.pop_camera, null);
        popupWindow = new PopupWindow(contentView, 500, 300, true);
        photo_pop = contentView.findViewById(R.id.photo_pop);
        camera_pop = contentView.findViewById(R.id.camera_pop);
        cancle_pop = contentView.findViewById(R.id.cancle_pop);
        //找控件   设置点击事件
        popupWindow.setContentView(contentView);
        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.creat_write, null);
        popupWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        initClick();
    }

    private void initClick() {
        photo_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用相册
                initPhoto();
            }
        });
        camera_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用相机
                initCamera();
            }
        });
        cancle_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取消pop
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 从相册中获取图片
     */
    private void initPhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            openAlbum();
        }
    }

    /**
     * 打开相册的方法
     */
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_PHOTO);
    }

    /**
     * 拍照获取图片
     **/
    private void initCamera() {
        //创建File对象，用于存储拍照后的图片
        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            imageUri = FileProvider.getUriForFile(this, "com.llk.study.activity.PhotoActivity", outputImage);
        } else {
            imageUri = Uri.fromFile(outputImage);
        }
        //启动相机程序
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        Log.d(TAG, "onActivityResult: .........." + imageUri);
                        this.imagFile=imageUri;
                        writJia.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT > 19) {
                        //4.4及以上系统使用这个方法处理图片
                        handleImgeOnKitKat(data);
                    } else {
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    //发表
    private void initStart() {
        //intent传值
        String content = writMsg.getText().toString().trim();
        //presenter的调用file:///storage/emulated/0/Android/data/com.bwie.sj.onetime_sj/cache/output_image.jpg
        CreatPresenterImpl creatPresenter = new CreatPresenterImpl();
        Log.d(TAG, "initStart: zzzzzzzzzzzzzz"+userToken+"zzzzzzzzzz" + imagFile);
        creatPresenter.showCreatToView(imagFile,userUid, userToken, content, new CreatModelImpl(), this);
    }

    //发布展示的方法
    @Override
    public void show(String msg) {
        if (msg.equals("发布成功")) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, msg + "??", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑eventbus
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 4.4以下系统处理图片的方法
     */
    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    /**
     * 4.4及以上系统处理图片的方法
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handleImgeOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                //解析出数字格式的id
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                //如果是content类型的uri，则使用普通方式处理
                imagePath = getImagePath(uri, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                //如果是file类型的uri，直接获取图片路径即可
                imagePath = uri.getPath();
            }
            //根据图片路径显示图片
            displayImage(imagePath);
        }
    }

    /**
     * 根据图片路径显示图片的方法
     */
    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            Log.d(TAG, "displayImage: ====imagePathimagePath"+imagePath);
            Log.d(TAG, "displayImage: ====bibitmapbitmapbitmaptmap"+bitmap);
            imageview.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
//            ToastUtil.showShort(this,"failed to get image");
        }
    }

    /**
     * 通过uri和selection来获取真实的图片路径
     */
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
//                    ToastUtil.showShort(this,"you need the permission");
                    Toast.makeText(this, "you need the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

}
