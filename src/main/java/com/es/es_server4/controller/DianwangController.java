package com.es.es_server4.controller;


import com.alibaba.fastjson.JSONObject;
import com.es.es_server4.common.ApiRestResponse;
import com.es.es_server4.service.DianwangService;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;

@RestController
@CrossOrigin      //解决跨域问题
public class DianwangController {
    @Autowired
    DianwangService dianwangService;

//    public ApiRestResponse match(@RequestParam("data") String data){
//
//    }

    @GetMapping("/jsonTest")
    public JSONObject matchQuery(){
        JSONObject json = new JSONObject(dianwangService.matchAll("",""));
        return json;
    }


    @PostMapping("/jsonTestMulti")
    public JSONObject multiMatchQuery(@RequestParam("index") String index,@RequestParam("field") String field,@RequestParam("data") String data){

        JSONObject json = new JSONObject(dianwangService.multiMatchAll(index,field,data));
        return json;
    }

    //查询所有站点名称和ID
    @GetMapping("/spc")
    @ResponseBody
    public ApiRestResponse getSpc(){

        JSONObject json = new JSONObject(dianwangService.matchAll("v_spc_site_change","name"));
        return ApiRestResponse.success(json);
    }

    //查询某一个站点的详情
    @GetMapping("/spcDetail")
    @ResponseBody
    public ApiRestResponse getSpcDetail(@RequestParam("_id") String id) throws IOException {

        JSONObject json = new JSONObject(dianwangService.QueryByID("v_spc_site_change",id));
        return ApiRestResponse.success(json);
    }


    //查询所有光缆名称和ID
    @GetMapping("/fiber")
    @ResponseBody
    public ApiRestResponse getFiber(){

        JSONObject json = new JSONObject(dianwangService.matchAll("v_fiber_change","name"));
        return ApiRestResponse.success(json);
    }

    //查询某一个光缆的详情
    @GetMapping("/fiberDetail")
    @ResponseBody
    public ApiRestResponse getFiberDetail(@RequestParam("_id") String id) throws IOException {

        JSONObject json = new JSONObject(dianwangService.QueryByID("v_fiber_change",id));
        return ApiRestResponse.success(json);
    }


    //查询所有光缆名称和ID
    @GetMapping("/fiberSeg")
    @ResponseBody
    public ApiRestResponse getFiberSeg(){

        JSONObject json = new JSONObject(dianwangService.matchAll("v_fiber_seg_change","name"));
        return ApiRestResponse.success(json);
    }

    //查询某一个光缆的详情
    @GetMapping("/fiberSegDetail")
    @ResponseBody
    public ApiRestResponse getFiberSegDetail(@RequestParam("_id") String id) throws IOException {

        JSONObject json = new JSONObject(dianwangService.QueryByID("v_fiber_seg_change",id));
        return ApiRestResponse.success(json);
    }




}
