package com.littletrumpet.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by C.D on 2017/5/25.
 * serverUrl服务器下载链接
 * clientPath客户端保存地址
 */
public class Download {

    public void downloadFile(String serverUrl)throws IOException{

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(serverUrl).build();
        Response response = httpClient.newCall(request).execute();

//        File dirFile = new File(clientPath);
//        if(!dirFile.exists()){
//            dirFile.mkdir();
//        }

        //从服务器获取文件
//        URLConnection connection = serverUrl.openConnection();
//        InputStream in = connection.getInputStream();
//        FileOutputStream out = new FileOutputStream(clientPath + fileName);
//        byte[] buffer = new byte[4 * 1024];
//        int read;
//        while((read = in.read(buffer)) > 0){
//            out.write(buffer, 0 , read);
//        }
//        out.close();
//        in.close();
    }

}
