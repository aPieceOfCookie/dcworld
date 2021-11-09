package com.dc.dcworld.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Author {一块儿小饼干}
 * @ProjectName dcworld
 * @Description http工具包
 * @Date 2021/8/15 21:40
 **/
public class HttpUtils {

    public final static String BASE_URL="https://";
    public final static String ENCODING="utf-8";
    public final static String CONTENT_TYPE="application/x-www-form-urlencoded";
    public final static String METHOD_POST="POST";
    public final static String METHOD_GET="GET";

    public static String sendPost(String urlStr,String method){
        StringBuilder buffer = new StringBuilder();
        buffer.append(urlStr);
        BufferedReader buffer1 = null;
        StringBuilder resultBuffer=null;

        HttpURLConnection connection=null;
        try {
            URL url=new URL(buffer.toString());
            connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("content-type",CONTENT_TYPE);
            //connection.connect();
            //得到响应码
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = connection.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuilder();
                String line;
                buffer1 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while ((line = buffer1.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
