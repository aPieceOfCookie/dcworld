package com.dc.dcworld.utils.qqMap;

import com.dc.dcworld.utils.http.HttpUtils;
import okhttp3.OkHttpClient;

/**
 * @Author {一块儿小饼干}
 * @ProjectName dcworld
 * @Description 腾讯地图工具包
 * @Date 2021/8/15 21:41
 **/
public class QQMapUtils {

    //腾讯地图码
    private static final String CODE="XMCBZ-R4HLV-ZPBPB-UF7DI-F3QAJ-VOBXF";

    private static final String BASE_URL="https://apis.map.qq.com/ws/geocoder/v1/";
    private static final String BASE_URL_LOCATION="https://apis.map.qq.com/ws/location/v1/ip";

    private static final String LOCATION="location=";
    private static final String ADDRESS="address=";
    private static final String IP="ip=";

    /**
     * 根据Ip获取物理地址
     * @param ip ip
     * @return 1
     */
    public static String getLocationByIp(String ip){
        String url=BASE_URL_LOCATION+"?"+IP+ip+"&key="+ CODE;
        return HttpUtils.sendPost(url, HttpUtils.METHOD_GET);
    }

    public static String getLocationByLonAndLat(String lon,String lat){
        String url=BASE_URL+"?"+LOCATION+lon+","+lat+"&key="+CODE;
        System.out.println(url);
        OkHttpClient client = new OkHttpClient();
        return "";
    }
}
