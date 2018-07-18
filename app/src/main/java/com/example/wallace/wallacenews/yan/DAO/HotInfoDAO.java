package com.example.wallace.wallacenews.yan.DAO;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.wallace.wallacenews.peng.Global.GlobalVar;
import com.example.wallace.wallacenews.yan.JavaBean.HotInfo;

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

public class HotInfoDAO {

    private HotInfo hi = new HotInfo();


    //数据库连接
    public static void connectDB(Context context){
        //第一：默认初始化
        Bmob.initialize(context, "5eac7e65d8080c23fff499ea10d54d93");
    }
    //发布头条
    public void publishHot(HotInfo hotInfo,final Context context){
        hotInfo.setUserName(GlobalVar.nowUser.getUserName());
        hotInfo.setUserIcon(GlobalVar.nowUser.getIcon());
        hotInfo.setHotCommentNum(0);
        hotInfo.setHotLikeNum(0);
        hotInfo.setHotTransNum(0);
        hotInfo.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e == null)
                    Toast.makeText(context,"发布成功",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context,"发布失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public BmobFile imgPath2File(String path)
    {
        return  new BmobFile(new File(path));
    }

    //获取某一头条信息
    public void getHot(String userid, Integer hotid, final Context context){
        BmobQuery<HotInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<HotInfo> queryHotId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("HotId", hotid);

        List<BmobQuery<HotInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryHotId);

        BmobQuery<HotInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<HotInfo>() {
            @Override
            public void done(List<HotInfo> list, BmobException e) {
                hi = list.get(0);
                //需要用到适配器
            }
        });

    }

    //获取这个用户所有头条信息
    public void getUserAllHot(String userid,  final Context context) {
        BmobQuery<HotInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        queryUserId.findObjects(new FindListener<HotInfo>() {
            @Override
            public void done(List<HotInfo> list, BmobException e) {
                //需要用到适配器
                if(e == null) {

                }
            }
        });
    }
    //点赞某用户某头条
    public void clickLikeHot(String userid,int hotid,final Context context){
        BmobQuery<HotInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<HotInfo> queryHotId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("HotId", hotid);

        List<BmobQuery<HotInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryHotId);

        BmobQuery<HotInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<HotInfo>() {
            @Override
            public void done(List<HotInfo> list, BmobException e) {
                if(e == null){
                    hi = list.get(0);
                    hi.setHotLikeNum(hi.getHotLikeNum()+1);
                    hi.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e == null)
                                Toast.makeText(context,"点赞成功:",Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(context,"点赞出现异常",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(context,"找不到微头条"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void getAllHot(final Handler handler) {
        BmobQuery<HotInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<HotInfo>() {  //按行查询，查到的数据放到List<Goods>的集合
            @Override
            public void done(List<HotInfo> list, BmobException e) {
                if (e == null){
                        Message msg = handler.obtainMessage();
                        msg.what = 1;
                        msg.obj = list;
                        handler.sendMessage(msg);
                    } else {
                        Message msg = handler.obtainMessage();
                        msg.what = 0;
                        msg.obj = list;
                        handler.sendMessage(msg);
                    }
                }
        });
    }
    public void deleteHot(String userid, Integer hotid, final Context context){
        BmobQuery<HotInfo> queryUserId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("UserId", userid);
        BmobQuery<HotInfo> queryHotId = new BmobQuery<>();
        queryUserId.addWhereEqualTo("HotId", hotid);

        List<BmobQuery<HotInfo>> query = new ArrayList<>();
        query.add(queryUserId);
        query.add(queryHotId);

        BmobQuery<HotInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.and(query);
        bmobQuery.findObjects(new FindListener<HotInfo>() {
            @Override
            public void done(List<HotInfo> list, BmobException e) {
                if(e == null){
                    hi = list.get(0);
                    hi.delete(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e==null){
                                Toast.makeText(context,"删除成功:",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context,"删除失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
