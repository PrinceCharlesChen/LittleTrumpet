package com.littletrumpet.controller;

import com.littletrumpet.models.DownloadKey;
import com.littletrumpet.services.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by C.D on 2017/1/17.
 */
@Controller
public class DownloadAction {

    private static Logger log = LoggerFactory.getLogger(DownloadAction.class);

    @Autowired
    public DownloadService downloadService;

    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public String downloadAPK(@RequestParam("key") String key, Model model){
        DownloadKey info = downloadService.getInfo(key);
        model.addAttribute("key", key);
        //数据库有下载码
        if(info != null){
            int status = info.getStatus();
            model.addAttribute("status", status);

            if(status == 1){//1:下载码已使用过 0:未使用(下载成功)

                return "downloadkey";
            } else {//未使用过
                try{
                    String downloadUrl = downloadService.downloadAPK();
                    model.addAttribute("downloadUrl", downloadUrl);
                }catch (Exception e){
                    e.printStackTrace();
                    log.error(" -- download error -- ", e.getMessage());
                    model.addAttribute("status", 2);//下载失败

                    return "downloadkey";
                }

                downloadService.updateDownloadKey(key);//更新状态为已使用
            }
        //未查找到该下载码
        } else {
            model.addAttribute("status", 9);//下载码无效
        }

        return "downloadkey";
    }


}
