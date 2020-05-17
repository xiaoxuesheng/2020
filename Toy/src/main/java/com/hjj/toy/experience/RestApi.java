package com.hjj.toy.experience;

public class RestApi {


    /**
     * rest api 的命名：
     * 小写命名
     * /{version}/
     *
     *    应使用名词
     *    /../名词复数
     *    GET：查询
     *    如 GET /authors   查询所有作者
     *           /authors/2 查询id为2的作者
     *    避免多级查询
     *    除了第一级，其他级别都用查询字符串表达。
     *           /../authors/12?categories=2
     *    POST:复杂搜索search 新增insert 更新update 删除delete
     *    如 /s/author 搜索一个作者
     *       /i/author 新增一个作者
     *       /u/author 更新一个作者
     *       /d/author 删除一个作者
     *
     * rest api 的实现：
     * api层会调用service层，然后来处理service中出现的所有异常，首先，需要保证一点，一定要让api层非常轻，基本上做成一个转发的功能就好(接口参数，传递给service参数，返回给调用者数据,这三个基本功能)，然后就要在传递给service参数的那个方法调用上进行异常处理。
     *
     *
     */


    /**
     * rest api 返回信息设计
     *
     *
     {

     "status": 404,

     "code": 40483,

     "message": "Oops! It looks like that file does not exist.",

     "developerMessage": "File resource for path /uploads/foobar.txt does not exist.  Please wait 10 minutes until the upload batch completes before checking again.",

     "moreInfo": "http://www.mycompany.com/errors/40483"

     }
     *
     */



    /**
     * rest api 异常处理
     *

     1)作用于controller级别

     @RestController
     public class DemoController {

     @ExceptionHandler({NullPointerException.class})
     public String controllerExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
        }
     }

     2）作用于整个spring工程

     @ControllerAdvice
     public class GlobalExceptionHandler {
     @ExceptionHandler({Exception.class})
     @ResponseBody
     public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
        }
     }

     发生异常时处理：1）优先级大于2）

     */

    /**
     * restful api安全设计
     *
     * 参考-REST API 安全设计指南
     * 1.身份认证-http basic ; api-key ; oauth ; jwt(json web token)
     * 2.授权-角色权限
     * 3.url过滤
     * 4.功能加密传输-ssl
     * 5.速率限制
     * 6.错误处理
     * 7.重要ID不透明-比如/user/1123 可获取id=1123用户的信息，为了防止字典遍历攻击，可对id进行url62或者uuid处理
     *
     */


}
