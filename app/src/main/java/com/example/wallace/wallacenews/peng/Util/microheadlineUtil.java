package com.example.wallace.wallacenews.peng.Util;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class microheadlineUtil {

    private final static int maxImgNumInaRow = 3;
    private final static int ImageHeight = 100;
    private final static int ImageWidth = 100;

    //打开相册
    private static int dp2px(Context context,float dpValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    public static void addImg2LL(LinearLayout ll,List<Bitmap> imgs, Context context) {
        List<LinearLayout> rows = new ArrayList<>();
        if (imgs.size() > 0) {
            int rowNum = imgs.size() / maxImgNumInaRow + (imgs.size() % maxImgNumInaRow == 0 ? 0 : 1); //根据图片数量计算表格行数
            for (int i = 0; i < rowNum; i++) {
                LinearLayout row = new LinearLayout(context); //定义表格行
                row.setLayoutParams(new LinearLayout.LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                row.setOrientation(LinearLayout.HORIZONTAL);
                rows.add(row);
            }

            int temp = -1;
            for (int x = 0; x < imgs.size(); x++)// 循环设置表格行
            {

                if (x % maxImgNumInaRow == 0)
                { temp++;}
                ImageView image = new ImageView(context);
                image.setLayoutParams(new LinearLayout.LayoutParams(dp2px(context,ImageWidth),dp2px(context,ImageHeight))); //image的布局方式
                image.setImageBitmap(imgs.get(x));
                rows.get(temp).addView(image);
            }

            for (int i = 0; i < rowNum; i++)
            {
                ll.addView(rows.get(i));
            }
        }
    }
}
