package com.example.wallace.wallacenews.peng.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class microheadlineUtil {
    private final static int maxImgNumInaRow = 3;
    private final static int ImageHeight = 300;
    private final static int ImageWidth = 300;

    //参数：表格布局，要显示的Bitmap列表，上下文
    //功能：把图片放进表格布局中，最多三个为一行
    public static void addImg2Table(TableLayout tableLayout,List<Bitmap> imgs, Context context) {
        List<TableRow> rows = new ArrayList<>();
        if (imgs.size() > 0) {
            int rowNum = imgs.size() / maxImgNumInaRow + imgs.size() % maxImgNumInaRow == 0 ? 0 : 1; //根据图片数量计算表格行数
            for (int i = 0; i < rowNum; i++) {
                TableRow row = new TableRow(context); //定义表格行
                rows.add(row);
            }

            int temp = -1;
            for (int x = 0; x < imgs.size(); x++)// 循环设置表格行
            {

                if (x % maxImgNumInaRow == 0)
                    temp++;
                ImageView image = new ImageView(context);
                image.setLayoutParams(new LinearLayout.LayoutParams(ImageWidth, ImageHeight)); //image的布局方式
                image.setImageBitmap(imgs.get(x));
                rows.get(temp).addView(image);
            }

            for (int i = 0; i < rowNum; i++) {
                tableLayout.addView(rows.get(i));
            }
        }

    }
}
