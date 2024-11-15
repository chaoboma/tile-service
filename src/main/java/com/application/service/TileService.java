package com.application.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TileService extends IService<String> {

    Object getTerrainType(String type,Integer z, Integer x, Integer y);
    Object getImageType(String layer,String type,String grid,Integer z, Integer x, Integer y);
}
