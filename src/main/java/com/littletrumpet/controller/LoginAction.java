package com.littletrumpet.controller;

import com.littletrumpet.models.DownloadKey;
import com.littletrumpet.models.Result;
import com.littletrumpet.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by C.D on 2017/6/4.
 */
@Controller
public class LoginAction {

    @Value("#{dir['password']}")
    private String loginpw;

    @Autowired
    private LoginService service;

    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String doLogin(@RequestParam("password")String password, Model model){
        if (loginpw.equals(password)){
            return "true";
        }

        return "false";
    }

    @RequestMapping(value = "/listpage.do", method = RequestMethod.GET)
    public String list(Model model){
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "/data.do", method = RequestMethod.GET)
    public Result getDataList(@RequestParam("pageSize")int pageSize,
                              @RequestParam("pageNumber")int pageNumber,
                              Model model){
        List<DownloadKey> list = service.getDataList(pageNumber, pageSize);
        int total = service.getCount();

        Result result = new Result();
        result.setRows(list);
        result.setTotal(total);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/isSell.do", method = RequestMethod.GET)
    public String isSell(@RequestParam("issell")int issell,
                         @RequestParam("id")int id,
                         Model model){
        service.changeIsSell(issell, id);

        return "success";
    }
}
