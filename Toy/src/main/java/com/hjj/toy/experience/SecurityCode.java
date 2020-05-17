package com.hjj.toy.experience;


public class SecurityCode {

    /**
     * 前端交互接口处
     *
     * 防止CRLF攻击
     * CRLF 类似XSS
     * CRLF 输入回车换行伪造header头
     *
     */
    public void CRLF(String var1,String var2){

        //输入参数转义
        String var11 = var1.replaceAll("[\r\n]", "");
    }

    /**
     * 前端交互接口处
     *
     * 防止XSS攻击
     * 跨站脚本
     *
     */
    public void XSS(String var1,String var2){

        //校验输入参数

        //输入参数转义
    }

    /**
     * 前端交互接口处
     *
     * 防止SQL注入
     *
     */
    public void SQL(String var1,String var2){
        //jdbc方式用preparement的防注入写法

        //mybatis用#{}方式传递参数

        //用对象映射
    }

    /**
     * 前端交互接口处
     *
     * CSRF跨站域请求伪造
     *
     */
    public void CSRF(String var1,String var2){

        //明确requestmapping的请求方法

        //添加token验证
        //1.用户名密码作为token 设置过期时间
        //2.mac地址作为token

    }

    /**
     * https接口需要配置ssl
     *
     * 1.生成证书 keytool
     * 或者通过外部证书 如crt key 转为 pkcs12证书
     *
     * 2.在spring中配置server.ssl相关选项
     *
     *
     */

}
