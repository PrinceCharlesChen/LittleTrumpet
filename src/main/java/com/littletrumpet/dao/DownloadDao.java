package com.littletrumpet.dao;


import com.littletrumpet.models.DownloadKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DownloadDao {

    int insert(@Param("key") String key, @Param("url") String url);

    int updateDownloadByKey(@Param("key") String key);

    DownloadKey getOne(@Param(("key")) String key);

    List<DownloadKey> getAll();

    List<DownloadKey> getList(@Param("number")int numbet, @Param("size")int size);

    int getCount();

    int updateStatusByID(@Param("status")int status, @Param("id")int id);

    int updateIsSellByID(@Param("issell")int issell, @Param("id")int id);
}
