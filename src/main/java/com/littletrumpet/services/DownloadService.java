package com.littletrumpet.services;

import com.littletrumpet.dao.DownloadDao;
import com.littletrumpet.models.DownloadKey;
import com.littletrumpet.util.CreateKey;
import com.littletrumpet.util.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by C.D on 2017/5/25.
 */
@Service
public class DownloadService {

    @Value("#{dir['serverUrl']}")
    private String url;
//    @Value("#{dir['clientPath']}")
//    private String path;
//    @Value("#{dir['fileName']}")
//    private String fileName;
    @Value("#{dir['requestUrl']}")
    private String requestUrl;

    @Autowired
    public DownloadDao downloadDao;

    public DownloadKey getInfo(String key){
        return downloadDao.getOne(key);
    }

    public int insertDownloadKey(String key){
        String url = requestUrl + key;
        return downloadDao.insert(key, url);
    }

    public int updateDownloadKey(String key){
        return downloadDao.updateDownloadByKey(key);
    }

    public String downloadAPK() throws Exception{
        //URL urlpath = new URL(url);
        //new Download().downloadFile(url);
        return url;
    }

    public void createQRCodeImg(){
        List<DownloadKey> list = downloadDao.getAll();
        if(list!=null && !list.isEmpty()){
            for(int i=0; i<list.size(); i++){
                String url = list.get(i).getUrl();
                String key = list.get(i).getKey();
                CreateKey.createQRCode(key, url);
            }
        }

    }

}
