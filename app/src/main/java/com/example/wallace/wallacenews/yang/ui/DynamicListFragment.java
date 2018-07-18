package com.example.wallace.wallacenews.yang.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.Util.PhotoUtils;
import com.example.wallace.wallacenews.peng.Util.ToastUtils;
import com.example.wallace.wallacenews.yan.DAO.HotInfoDAO;
import com.example.wallace.wallacenews.yan.JavaBean.HotInfo;
import com.example.wallace.wallacenews.yang.adapter.MyFragmentPagerAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.viewpagerindicator.TabPageIndicator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class DynamicListFragment extends  android.support.v4.app.Fragment {
    private RecyclerView mRecyclerView;
    private DynamicAdapter mDynamicAdapter;
    private List<Bitmap> bmpList;

    private static final String TAG = "PhotoImageFragment";

    Button bt_release;
    ImageView bt_takepic;
    ImageView bt_gallary;
    EditText mhText;
    Context mContext;
    HotInfoDAO hotInfoDAO;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;

    private static Handler handler;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mContext = getActivity();

        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    updateUI((List<HotInfo>) msg.obj);
                } else if (msg.what == 0) {
                    Toast.makeText(mContext, "获取微头条失败了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "未知错误", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_dynamic, container, false );
        mRecyclerView = (RecyclerView) v.findViewById( R.id.rcdy );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        hotInfoDAO = new HotInfoDAO();
        hotInfoDAO.connectDB(mContext);

        bmpList = new ArrayList<>();
        bt_gallary = (ImageView) v.findViewById(R.id.imageView5);
        bt_takepic = (ImageView) v.findViewById(R.id.imageView3);
        bt_release = (Button)v.findViewById(R.id.button2) ;
        EditText mhText = (EditText)v.findViewById(R.id.mh_text);

        //从服务器获得微头条
        hotInfoDAO.getAllHot(handler);

        //监听上传图片
        bt_takepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewClicked(view);
            }
        });
        bt_gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewClicked(view);
            }
        });
        bt_release.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReleaseClicked(view);
            }
        });

        //下拉刷新
        RefreshLayout refreshLayout = (RefreshLayout)v.findViewById(R.id.refresh_mh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mRecyclerView.removeAllViews();
                hotInfoDAO.getAllHot(handler);
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
        return v;

    }
    private void onReleaseClicked(View view) {
        if(true/*用户没登录*/)
        { Toast.makeText(mContext,"请先登录",Toast.LENGTH_SHORT);}
        else {
            if (mhText.getText().length() == 0)
            { Toast.makeText(mContext, "输入不能为空", Toast.LENGTH_SHORT).show(); } else {

                hotInfoDAO.publishHot("344616766+", mhText.getText().toString(), mContext);
                //加入文本
                //加入图片
                //发送到数据库
                //将微头条显示到界面
                //清空图片数组
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView3:
                autoObtainCameraPermission();
                break;
            case R.id.imageView5:
                autoObtainStoragePermission();
                break;
            default:
        }
    }

    /**
     * 动态申请sdcard读写权限
     */
    private void autoObtainStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
            } else {
                PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
            }
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }
    }

    /**
     * 申请访问相机权限
     */
    private void autoObtainCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                    ToastUtils.showShort(getActivity(), "您已经拒绝过一次");
                }
                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
            } else {//有权限直接调用系统相机拍照
                if (hasSdcard()) {
                    imageUri = Uri.fromFile(fileUri);
                    //通过FileProvider创建一个content类型的Uri
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        imageUri = FileProvider.getUriForFile(getActivity(), "com.wallace.fileprovider", fileUri);
                    }
                    PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                } else {
                    ToastUtils.showShort(getActivity(), "设备没有SD卡！");
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: ");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            //调用系统相机申请拍照权限回调
            case CAMERA_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            //通过FileProvider创建一个content类型的Uri
                            imageUri = FileProvider.getUriForFile(getActivity(), "com.wallace.fileprovider", fileUri);
                        }
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(getActivity(), "设备没有SD卡！");
                    }
                } else {
                    ToastUtils.showShort(getActivity(), "请允许打开相机！！");
                }
                break;
            }
            //调用系统相册申请Sdcard权限回调
            case STORAGE_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {
                    ToastUtils.showShort(getActivity(), "请允许打操作SDCard！！");
                }
                break;
            default:
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode + "  resultCode:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            Log.e(TAG, "onActivityResult: resultCode!=RESULT_OK");
            return;
        }
        switch (requestCode) {
            //相机返回
            case CODE_CAMERA_REQUEST:
                cropImageUri = Uri.fromFile(fileCropUri);
                PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                break;
            //相册返回
            case CODE_GALLERY_REQUEST:

                if (hasSdcard()) {
                    cropImageUri = Uri.fromFile(fileCropUri);
                    Uri newUri = Uri.parse(PhotoUtils.getPath(getActivity(), data.getData()));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        newUri = FileProvider.getUriForFile(getActivity(), "com.wallace.fileprovider", new File(newUri.getPath()));
                    }
                    PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                } else {
                    ToastUtils.showShort(getActivity(), "设备没有SD卡！");
                }
                break;
            //裁剪返回
            case CODE_RESULT_REQUEST:
                Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, getActivity());
                if (bitmap != null) {
                    getImages(bitmap);
                }
                break;
            default:
        }
    }

    private void getImages(Bitmap bitmap) {
        bmpList.add(bitmap);
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }
    private void updateUI(List<HotInfo> list) {

        mDynamicAdapter =new DynamicAdapter(list);
        mRecyclerView.setAdapter( mDynamicAdapter );
    }
    private class DynamicHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView releaseTime;
        private TextView showText;
        private TextView admireCount;
        private TextView commentCount;
        private TextView transmitCount;
        ImageView mh_img;

        public DynamicHolder(LayoutInflater inflater, ViewGroup parent) {

            super( inflater.inflate( R.layout.dynamic_condition_fragment_item, parent, false ) );
            userName = (TextView) itemView.findViewById( R.id.dyname );
            releaseTime = (TextView) itemView.findViewById( R.id.dyTime );
            admireCount = (TextView) itemView.findViewById( R.id.admireCount );
            commentCount = (TextView) itemView.findViewById( R.id.commentCount );
            transmitCount = (TextView) itemView.findViewById( R.id.transmitCount );
            showText = (TextView) itemView.findViewById( R.id.dyText );
            mh_img = (ImageView) itemView.findViewById(R.id.mh_image);
        }

        public void bind(HotInfo hotInfo) {
            userName.setText(hotInfo.getUserName());
            releaseTime.setText(hotInfo.getCreatedAt());
            showText.setText(hotInfo.getHot());
            admireCount.setText(""+hotInfo.getHotLikeNum());
            commentCount.setText(""+hotInfo.getHotCommentNum());
            transmitCount.setText(""+hotInfo.getHotTransNum());
//            mh_img.setImageBitmap((Bitmap) hotInfo.getHotIcon());
        }
    }

    private class DynamicAdapter extends RecyclerView.Adapter<DynamicHolder> {
        List<HotInfo> mList = new ArrayList<>();

        public DynamicAdapter(List<HotInfo> hotInfos) {
            mList = hotInfos;
        }

        @Override
        public DynamicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            return new DynamicHolder( layoutInflater, parent );
        }

        @Override
        public void onBindViewHolder(DynamicHolder holder, int position) {
            HotInfo hots = mList.get( position );
            holder.bind( hots );
        }


        @Override
        public int getItemCount() {
            return mList.size();
        }
    }

}
