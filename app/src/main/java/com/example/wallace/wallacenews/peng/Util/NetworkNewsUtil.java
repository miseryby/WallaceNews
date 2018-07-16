package com.example.wallace.wallacenews.peng.Util;

import android.os.Handler;

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


    private static String APPCODE = "APPCODE 1c47f03bc4324e638195a51a124ab4c1";
    private static String baseUrl = "http://toutiao-ali.juheapi.com/toutiao/index?type=";

    private static String newsType_top = "top";
    private static String newsType_shehui = "shehui";
    private static String newsType_guonei = "guonei";
    private static String newsType_guoji = "guoji";
    private static String newsType_yule = "yule";
    private static String newsType_tiyu = "tiyu";
    private static String newsType_junshi = "junshi";
    private static String newsType_keji = "keji";
    private static String newsType_caijing = "caijing";
    private static String newsType_shishang = "shishang";

    public static List<Data> GetTopNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_top,handler);
    }
    public static List<Data> GetShehuiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_shehui,handler);
    }
    public static List<Data> GetGuoneiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_guonei,handler);
    }
    public static List<Data> GetGuojiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_guoji,handler);
    }
    public static List<Data> GetYuleNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_yule,handler);
    }
    public static List<Data> GetTiyuNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_tiyu,handler);
    }
    public static List<Data> GetJunshiNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_junshi,handler);
    }
    public static List<Data> GetShishangNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_shishang,handler);
    }
    public static List<Data> GetCaijingNewsFromNetwork(Handler handler) {
        return GetNewsFromNetwork(newsType_caijing,handler);
    }
    public static List<Data> GetKejiNewsFromNetwork(Handler handler)
    {
        return GetNewsFromNetwork(newsType_keji,handler);
    }

    private static List<Data> GetNewsFromNetwork(String newstype, Handler handler) {

        List<Data> datas = new ArrayList<>();
        try {
            URL url = new URL(baseUrl+newstype);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Authorization", APPCODE);

            int code = conn.getResponseCode();
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
