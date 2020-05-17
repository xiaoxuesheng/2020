package com.hjj.toy.experience;

/**
 * 字段校验
 *
 * 1、使用GUAVA的 Preconditions
 * 2、使用hibernate-validator
 */
public class Validate {


    /**
     * spring的validate
     *
     * 1.引入
     * spring-boot-starter-validation
     *
     * 2.定义参数对象
     * @Data
     * public class LoginForm{
     *     @NotBlank(message="用户名不能为空")        注： 1 @NotEmpty :不能为null，且Size>0
     *     @Email                                    2  @NotNull:不能为null，但可以为empty,没有Size的约束
     *     private String username;                  3  @NotBlank:只用于String,不能为null且trim()之后size>0
     *
     * }
     *
     * 3.使用@valid校验，并将校验结果放到BindingResult对象中    注：阅读@Validated和@Valid的区别：分组校验和嵌套校验
     *                                                           默认情况下，如果校验失败会抛javax.validation
     *                                                           .ConstraintViolationException异常，可以用统一异常
     *                                                           处理去对这些异常做处理
     * @RequestMapping("/v")
       @ResponseBody
       public String v(@Valid User user,BindingResult result){
            if(result.hasErrors()){
              for(ObjectError error:result.getAllErrors()){
               return error.getDefaultMessage();
              }
            }
           return "success";
       }


     *  4.自定义校验规则
     *
     *  5.校验模式：可以设置都进行校验还是遇到校验错误就结束
     *
     *
     */


    /**
     * 2.GUAVA的 Preconditions
     * 需自己编写类
     *
     */
}
