package com.example.wallace.wallacenews.peng.Util;

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

    public static List<Data> GetTopNewsFromNetwork()
    {
        return GetNewsFromNetwork(newsType_top);
    }
    public static List<Data> GetShehuiNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_shehui);
    }
    public static List<Data> GetGuoneiNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_guonei);
    }
    public static List<Data> GetGuojiNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_guoji);
    }
    public static List<Data> GetYuleNewsFromNetwork()
    {
        return GetNewsFromNetwork(newsType_yule);
    }
    public static List<Data> GetTiyuNewsFromNetwork()
    {
        return GetNewsFromNetwork(newsType_tiyu);
    }
    public static List<Data> GetJunshiNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_junshi);
    }
    public static List<Data> GetShishangNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_shishang);
    }
    public static List<Data> GetCaijingNewsFromNetwork() {
        return GetNewsFromNetwork(newsType_caijing);
    }
    public static List<Data> GetKejiNewsFromNetwork()
    {
        return GetNewsFromNetwork(newsType_keji);
    }

    public static List<Data> GetNewsFromNetwork(String newstype) {

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
                }
                return datas;
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
