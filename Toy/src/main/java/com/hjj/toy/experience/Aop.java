package com.hjj.toy.experience;

public class Aop {

    // https://www.cnblogs.com/lx-1024/p/8033765.html
    //单个aspect 正常执行顺序
    /*
      [Aspect1] around advise 1
      [Aspect1] before advise
           test OK
      [Aspect1] around advise2
      [Aspect1] after advise
      [Aspect1] afterReturning advise
     */

    //单个aspect 异常执行顺序
    /*
      [Aspect1] around advise 1
      [Aspect1] before advise
       throw an exception
        [Aspect1] after advise
     [Aspect1] afterThrowing advise
     */


}
