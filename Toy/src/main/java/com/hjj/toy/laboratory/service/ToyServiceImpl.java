package com.hjj.toy.laboratory.service;

import com.alibaba.fastjson.JSONObject;
import com.hjj.toy.laboratory.dao.ToyDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "toyServiceImpl")
@Slf4j
public class ToyServiceImpl implements ToyService {


    @Resource
    private ToyDao toyDao;


    @Override
    public JSONObject call() {
        JSONObject jsonObject = new JSONObject(true);
        List<Map<String,Object>> list = toyDao.queryData();
        jsonObject.put("data",list);
        return jsonObject;
    }

    @Override
    public void testLog() {

        log.info(">>>log service {}",1);
        log.info(">>>log service {}",2);
    }
}
