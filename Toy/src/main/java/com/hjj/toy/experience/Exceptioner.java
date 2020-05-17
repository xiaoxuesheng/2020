package com.hjj.toy.experience;

import org.springframework.cglib.proxy.UndeclaredThrowableException;

public class Exceptioner {

    /**
     * exception的父类throwable的getMessage方法返回的是detailMessage信息,即异常信息;
     * 而getCause().getMessage()返回的是引起此异常的message信息
     *
     *
     * 通过 throw new Exception("message")等方式 在代码里自己抛出的异常由于会被
     * spring包裹成UndeclaredThrowableException 所以通过catch时的getMessage获取结果为null
     * 此时需要使用getCause().getMessage()获取
     * 如果一个异常是Exception异常并且没有在动态代理的接口处声明，那么它将会被包装成UndeclaredThrowableException.
     *
     *
     */

    /**
     * 自定义异常
     *
     */
    public class 自定义异常 extends RuntimeException {

        public 自定义异常() {
        }

        public 自定义异常(String message) {
            super(message);
        }

        public 自定义异常(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * 带异常码的自定义异常
     *
     */
    public class 异常码自定义异常超类 extends RuntimeException {
        protected Long errorCode;
        protected Object data;
        public 异常码自定义异常超类(Long errorCode,String message,Object data,Throwable e){
            super(message,e);
            this.errorCode = errorCode ;
            this.data = data ;
        }
        public 异常码自定义异常超类(Long errorCode,String message,Object data){
            this(errorCode,message,data,null);
        }
        public 异常码自定义异常超类(Long errorCode,String message){
            this(errorCode,message,null,null);
        }
        public 异常码自定义异常超类(String message,Throwable e){
            this(null,message,null,e);
        }
        public 异常码自定义异常超类(){
        }
        public 异常码自定义异常超类(Throwable e){
            super(e);
        }
        public Long getErrorCode() {
            return errorCode;
        }
        public void setErrorCode(Long errorCode) {
            this.errorCode = errorCode;
        }
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
    }

    public class ExceptionUtil {
        public String getMessage(Exception e){
            String msg = e.getMessage();
            if(null == msg){
                msg = e.getCause().getMessage();
            }
            if(null == msg){
                if(e instanceof UndeclaredThrowableException){
                    msg = ((UndeclaredThrowableException)e).getUndeclaredThrowable().getMessage();
                }
            }

            return msg;
        }
    }

    /**
     * 一般面向在api层(和web中的controller层类似)和service层进行异常设计
     *
     * 考虑几个场景的异常设计：添加、删除、展示列表
     *
     * dao层异常
     * 1.一般不进行处理
     * 2.涉及批量数据问题，对每一条单独操作时，具体情况具体分析是否进行捕获后记录
     *
     * service层异常
     * 1.验证入参时抛出运行时异常（一般使用验证框架）
     * 2.流程中获取中间结果不符合预期时抛出运行时异常（自定义异常）
     * 3.如果没有特殊情况不要在此catch异常
     *
     * api层异常
     * 一般是外部调用的api需要提供异常码和异常信息。定义带异常码自定义异常超类，然后实现具体异常；
     * 1.验证入参，抛出自定义具体异常
     * 2.调用service时，判断异常类型，然后将service异常转化成api异常。最后在通过统一异常处理，转化为DTO对象返回。
     *
     *
     *
     */

}
