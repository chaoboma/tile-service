package com.application.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.application.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
//@Api(value = "TestController", tags = { "TestController" })
public class TestController {
    /**
     * query
     * @param id
     * @return
     */
    //@ApiOperation("query")
    //@UserLoginToken
    @GetMapping(value = "/query")
    public Result<Object> queryCountry(@RequestParam String id) {
        return Result.success(id);
    }
}