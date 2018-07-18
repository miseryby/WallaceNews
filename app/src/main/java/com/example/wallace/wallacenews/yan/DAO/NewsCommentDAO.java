package com.example.wallace.wallacenews.yan.DAO;

import android.content.Context;
import android.widget.Toast;

import com.example.wallace.wallacenews.yan.JavaBean.NewsComment;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class NewsCommentDAO {

    //发布新闻评论
    public void publishNewsComment(String userid, String newscomment, final Context context){
        NewsComment newsComment = new NewsComment();
        newsComment.setUserId(userid);
        newsComment.setNewsComment(newscomment);
        newsComment.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e == null)
                    Toast.makeText(context,"发布成功",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context,"发布失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //获取新闻评论
    public void getNewsComment(String newsid, final Context context){
        NewsComment newsComment = new NewsComment();
        BmobQuery<NewsComment> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("NewsId",newsid);
        bmobQuery.findObjects(new FindListener<NewsComment>() {
            @Override
            public void done(List<NewsComment> list, BmobException e) {
                //需要用到适配器
                if(e == null) {

                }
            }
        });
    }
}
