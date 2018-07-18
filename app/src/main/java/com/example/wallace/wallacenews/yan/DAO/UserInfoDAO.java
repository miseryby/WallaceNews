package com.example.wallace.wallacenews.yan.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.wallace.wallacenews.yan.JavaBean.UserInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

public class UserInfoDAO {

    private UserInfo keeploginui = new UserInfo();
    private UserInfo ui =new UserInfo();
    private String getusername;

    public String getGetusername() {
        return getusername;
    }

    public UserInfo getKeeploginui() {
        return keeploginui;
    }

    //数据库连接
    public void connectDB(Context context){
        //第一：默认初始化
        Bmob.initialize(context, "5eac7e65d8080c23fff499ea10d54d93");
    }

    //添加用户，通过注册账号密码
    public void insertUser(String userid, String password, final Context context){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userid);
        userInfo.setUserPwd(password);
        userInfo.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Toast.makeText(context,"添加数据成功，返回objectId为："+objectId,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"创建数据失败：" + e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //添加用户，通过手机号，名字，和密码注册
    public void insertUser(String name,String password ,String phone, final Context context){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        userInfo.setUserPwd(password);
        userInfo.setUserPhone(phone);
        //生成随机数，作为用户10位的账号id
        String strRand="" ;
        for(int i=0;i<10;i++){
            strRand += String.valueOf((int)(Math.random() * 10)) ;
        }
        userInfo.setUserId(strRand);

        userInfo.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Toast.makeText(context,"添加数据成功,objectId为："+objectId,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"创建数据失败:" + e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //删除用户,根据账号,密码来删除一个用户
    public void deleteUser(String userid, String userpwd, final Context context){
        BmobQuery<UserInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<UserInfo> queryUserPwd = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserPwd", userpwd);

        List<BmobQuery<UserInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryUserPwd);

        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size() == 1){
                    ui=list.get(0);
                    if (ui.getObjectId() != null)
                    //Log.d("dasd",ui.getObjectId());
                    //ui.setObjectId(ui.getObjectId());
                    //str = ui.getObjectId();
                    ui.delete(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e==null){
                                Toast.makeText(context,"删除成功:"+ui.getUpdatedAt(),Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context,"删除失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
//        ui.delete(new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if(e==null){
//                    Toast.makeText(context,"删除成功:"+ui.getUpdatedAt(),Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(context,"删除失败"+e.getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    //更新用户姓名
    public void upDateName(String userid, final String name, final Context context){
        final UserInfo userInfo=new UserInfo();
        BmobQuery<UserInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        queryUserId.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size() == 1)
                    ui=list.get(0);
                userInfo.setUserName(name);
                userInfo.update(ui.getObjectId(), new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(context,"更新成功:"+userInfo.getUpdatedAt(),Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(context,"更新失败："+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
    //更新用户密码
    public void upDatePassword(String userid, String formuserpwd, final String userpwd, final Context context){
        final UserInfo userInfo=new UserInfo();
        BmobQuery<UserInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<UserInfo> queryUserPwd = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserPwd", formuserpwd);

        List<BmobQuery<UserInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryUserPwd);

        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size() == 1)
                    ui=list.get(0);
                userInfo.setUserPwd(userpwd);
                userInfo.update(ui.getObjectId(), new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(context,"更新成功:"+userInfo.getUpdatedAt(),Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(context,"更新失败："+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    //查找用户的昵称
    public void findName(String userid, final Context context){
        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("UserId", userid);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size() == 1) {
                    Message message = Message.obtain();
                    message.what = 0;
                    //以消息为载体
                    message.obj = list.get(0);//这里的list就是查询出list
                    handler.sendMessage(message);
                    //ui = list.get(0);
                    //Toast.makeText(context, "测试1，用户名为" + ui.getUserName(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, "测试2，用户名为" + getusername, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //用户上传头像图片，并且把图片存储到服务器数据库
    public void uploadIcon(String userid,final String imagePath,final Context context){
        final String icon_path;
        icon_path = imagePath;//此处为填写图片地址，前端选中图片后获得
        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("UserId", userid);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size() == 1) {
                    ui = list.get(0);
                    final BmobFile bmobfile = new BmobFile(new File(icon_path));
                    ui.setIcon(bmobfile);
                    Log.i("test",icon_path);
                    bmobfile.upload(new UploadFileListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {//为空说明没有异常
                                Toast.makeText(context, "文件上传成功", Toast.LENGTH_SHORT).show();
                                ui.setIcon(bmobfile);
                                ui.update(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                    }
                                });
                            }else {
                                Toast.makeText(context, "文件上传失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    //用户从服务器上下载图片，获取图片
    public void downloadIcon(String userid,final Context context){
        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("UserId", userid);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if (e == null){
                    //System.out.println("查询成功"+list.get(0).getName()+list.get(0).getPrice()+list.get(0).getDesc());
                    //listView.setAdapter(new MyAdapter(context , list));

                }
            }
        });
    }

    //用户登录
    public void login(String userid, String userpwd, final Context context){
        BmobQuery<UserInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<UserInfo> queryUserPwd = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserPwd", userpwd);

        List<BmobQuery<UserInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryUserPwd);

        BmobQuery<UserInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if(list.size()==1) {
                    ui = list.get(0);
                    keeploginui = list.get(0);
                    Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    UserInfo info = (UserInfo) msg.obj;
                    Log.i("maintest",info.getUserName());
                    getusername = info.getUserName();
                    break;
            }
        }
    };
}
