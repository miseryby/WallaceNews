package com.example.wallace.wallacenews.yang.test;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsLab {
    private  static  NewsLab sNewsLab;
    private List<News> mList;

    public  static  NewsLab get(Context context){
        if(sNewsLab ==null){
            sNewsLab =new NewsLab(context);
        }
        return  sNewsLab;

    }

    public List<News> getNews() {
        return mList;
    }

    public News getNewsOne(UUID mUUID) {
        for(News news:mList){
            if(news.getUUID().equals( mUUID )){
                return news;
            }
        }
        return null;
    }

    private NewsLab(Context context){
      mList =new ArrayList<>(  );

        for (int i = 0; i < 100; i++) {
            String string =new String( "hello  "+i );
            News news = new News();
            news.setTitle( "WallaceNews"+i );
            news.setDetail( "谈笑风生" );
            mList.add( news);
        }
    }

}
