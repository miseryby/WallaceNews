package com.example.wallace.wallacenews.peng.Util;

import android.os.Handler;
import android.util.Log;

import com.example.wallace.wallacenews.peng.beans.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class NetworkNewsUtil {
    private static String APPCODE = "APPCODE 6e62dc607a0c4c62b4c970fa13fa5c68";
    private static String newsType_top = "http://toutiao-ali.juheapi.com/toutiao/index?type=top";
    private static String newsType_shehui = "http://toutiao-ali.juheapi.com/toutiao/index?type=shehui";
    private static String newsType_guonei = "http://toutiao-ali.juheapi.com/toutiao/index?type=guonei";
    private static String newsType_guoji = "http://toutiao-ali.juheapi.com/toutiao/index?type=guoji";
    private static String newsType_yule = "http://toutiao-ali.juheapi.com/toutiao/index?type=yule";
    private static String newsType_tiyu = "http://toutiao-ali.juheapi.com/toutiao/index?type=tiyu";
    private static String newsType_junshi = "http://toutiao-ali.juheapi.com/toutiao/index?type=junshi";
    private static String newsType_keji = "http://toutiao-ali.juheapi.com/toutiao/index?type=keji";
    private static String newsType_caijing = "http://toutiao-ali.juheapi.com/toutiao/index?type=caijing";
    private static String newsType_shishang = "http://toutiao-ali.juheapi.com/toutiao/index?type=shishang";

    //获取军事图片
    public static List<String> GetJunshiPicture(Handler handler)
    {
        return GetPicOfNews(newsType_junshi,handler);
    }
    //获取科技图片
    public static List<String> GetkejiPicture(Handler handler)
    {
        return GetPicOfNews(newsType_keji,handler);
    }
    //获取财经图片
    public static List<String> GetcaijingPicture(Handler handler)
    {
        return GetPicOfNews(newsType_caijing,handler);
    }
    //获取时尚图片
    public static List<String> GetshishangPicture(Handler handler)
    {
        return GetPicOfNews(newsType_shishang,handler);
    }

    //获取新闻

    //头条
    public static List<Data> GetTopNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_top,handler);
    }
    //社会
    public static List<Data> GetShehuiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_shehui,handler);
    }
    //国内
    public static List<Data> GetGuoneiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_guonei,handler);
    }
    //国际
    public static List<Data> GetGuojiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_guoji,handler);
    }
    //娱乐
    public static List<Data> GetYuleNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_yule,handler);
    }
    //体育
    public static List<Data> GetTiyuNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_tiyu,handler);
    }
    //军事
    public static List<Data> GetJunshiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_junshi,handler);
    }
    //时尚
    public static List<Data> GetShishangNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_shishang,handler);
    }
    //财经
    public static List<Data> GetCaijingNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_caijing,handler);
    }
    //科技
    public static List<Data> GetKejiNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_keji,handler);
    }

    public static List<String> GetPicOfNews(String newstype,Handler handler)
    {
        List<String> picUrl = new ArrayList<>();
        try {
            URL url = new URL(newstype);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Authorization", APPCODE);

            int code =conn.getResponseCode();
            Log.i("maininfo",String.valueOf(code));
            if (code == 200) {
                //代表请求成功数据
                InputStream is = conn.getInputStream();
                String str = HttpUtils.InputStream2String(is);
                JSONObject json = new JSONObject(str);
                JSONObject result = json.getJSONObject("result");
                JSONArray arr = result.getJSONArray("data");

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject temp = arr.getJSONObject(i);
                    picUrl.add(temp.optString("thumbnail_pic_s"));
                    handler.sendEmptyMessage(0);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        finally {
            return picUrl;
        }

    }
    private static List<Data> GetNewsFromNetwork(String newstype, Handler handler) {

        List<Data> datas = new ArrayList<>();
        try {
            URL url = new URL(newstype);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Authorization", APPCODE);

           int code =conn.getResponseCode();
            Log.i("maininfo",String.valueOf(code));
            if (code == 200) {
                //代表请求成功数据
                InputStream is = conn.getInputStream();
                String str = HttpUtils.InputStream2String(is);
                JSONObject json = new JSONObject(str);
                JSONObject result = json.getJSONObject("result");
                JSONArray arr = result.getJSONArray("data");

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject temp = arr.getJSONObject(i);
                    Data data = new Data();
                    data.setTitle(temp.optString("title"));
                    data.setDate(temp.optString("date"));
                    data.setAuthor_name(temp.optString("author_name"));
                    data.setUrl(temp.optString("url"));
                    data.setThumbnail_pic_s(temp.optString("thumbnail_pic_s"));
                    datas.add(data);
                    handler.sendEmptyMessage(0);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        finally {
            return datas;
        }
    }
}
