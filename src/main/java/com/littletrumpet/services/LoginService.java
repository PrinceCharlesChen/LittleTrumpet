package com.littletrumpet.services;

import com.littletrumpet.dao.DownloadDao;
import com.littletrumpet.models.DownloadKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by C.D on 2017/6/4.
 */
@Service
public class LoginService {

    @Autowired
    private DownloadDao dao;

    public List<DownloadKey> getDataList(int pageNumber, int pageSize){
        List<DownloadKey> list = dao.getList((pageNumber-1)*pageSize, pageSize);
        return list;
    }

    public int getCount(){
        int count = dao.getCount();
        return count;
    }

    public void changeStatus(int status, int id){
        dao.updateStatusByID(status, id);
    }

    public void changeIsSell(int issell, int id){
        dao.updateIsSellByID(issell, id);
    }

}
