package com.hjj.toy.experience.SpringMVCParam;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * mvc 前后端请求接受情况
 */

@RestController
@RequestMapping
public class SpringMVCParam {

    /**
     * @RequestParam
     * 1.常用来处理简单类型的绑定
     * 2.用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容，提交方式GET、POST（表单提交）
     *
     * @RequestBody
     * 常用来处理Content-Type: 不是application/x-www-form-urlencoded编码的内容，例如application/json, application/xml等
     */




    /**
     * form表单提交
     *
     * 用@RequestParam 接收类型 不需要设置contentType
     * 默认content-type=application/x-www-form-urlencoded
     * tomcat对content-type=application/x-www-form-urlencode的POST请求进行了特殊处理，放入request parameter map中
     *
     */

    @RequestMapping(value = "/param1")
    public void param1(@RequestParam int i){

    }

    @RequestMapping(value = "/param2")
    public void param2(@RequestParam Map<String,String> map){

    }

    /* var arr = [1,2,3];
      $.jBox.confirm("确定要删除数据吗？", "warning",function () {
        $.ajax({
                type: 'get',
                url: '${base.contextPath}/giving/index/del',
                dataType: 'json',
                data: {ids: arr},
        success: function (result) {
            …
        },
        error: function (result) {
            …
        }
        })
     })
    */
    @RequestMapping(value = "/param3" ,method = RequestMethod.GET)
    public void param3(@RequestParam(value = "ids[]") List<Integer> ids){

    }


    /**
     * application/json
     *
     * 需设置 contentType : 'application/json;charset=utf-8',
     * 用@RequestParam处理简单类型
     * 用@RequestBody处理复杂类型
     * @param
     */

    @RequestMapping(value = "/param11")
    public void param11(@RequestBody Param param){

    }

    /*
      var userList = new Array();
      userList.push({name: "张三",pwd: "123"});
      userList.push({name: "李四",pwd: "223"});
      $.ajax({
       type: "POST",
       url: "${base.contextPath}/user/index/add",
       data: JSON.stringify(userList),//将对象序列化成JSON字符串
       dataType:"json",
       contentType : 'application/json;charset=utf-8', //设置请求头信息
       success: function(result){
        …
     },
        error: function(result){
        …
       }
      });
     */

    @RequestMapping(value = "/param12")
    public void param12(@RequestBody List<Param> params){

    }

    //数组形式
    @RequestMapping(value = "/param122")
    public void param122(@RequestBody Param[] params){

    }


}
