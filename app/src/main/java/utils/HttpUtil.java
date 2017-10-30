package utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/9/22.
 */

public class HttpUtil {
    //HttpUrlConnection获取数据方法
    public  String getHttp(String Url)
    {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String st ="";
        try {
            url = new URL(Url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.setReadTimeout(2000);
            int code = httpURLConnection.getResponseCode();
            if(code == 200)
            {

                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] b = new byte[1024];
                int len =0;
                while ((len = inputStream.read(b))!= -1)
                {
                    st += new String(b,0,len);
                }


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return  st;
        //qiuyu

    }
}
