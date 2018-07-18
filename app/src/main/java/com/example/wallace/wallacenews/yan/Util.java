package com.example.wallace.wallacenews.yan;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {
    public static String stream2String(InputStream is) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = is.read(buffer)) != -1) {
            baos.write(buffer,0,len);
        }
        return baos.toString("utf-8");
    }
}
