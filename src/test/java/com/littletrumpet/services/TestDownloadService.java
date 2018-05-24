package com.littletrumpet.services;

import com.littletrumpet.util.CreateKey;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/1/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestDownloadService {
    private static Logger logger = Logger.getLogger(TestDownloadService.class);

    @Autowired
    private DownloadService downloadService;

    @Test
    public void TestCreatDownloadKey(){
        for(int i=0; i<500; i++){
            String key = CreateKey.getStringRandom(8);
            logger.info("DownloadKey:" + key);
            downloadService.insertDownloadKey(key);
        }
    }

    @Test
    public void TestCreateQRCode(){
        downloadService.createQRCodeImg();
    }
}
