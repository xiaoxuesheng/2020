package com.hjj.toy.experience;


/**
 * 对于大量分支逻辑判断时的最佳优化
 */
public class Ifelse {

    /**
     * 1.卫语句
     * if (isSunshine()) {
         // 晴天时处理逻辑
         return xx;
       }
       if (isRain()) {
         // 下雨时处理逻辑
       }
       if (isOvercast()) {
         // 阴天时处理逻辑
       }
     *
     */

    /**
     * 2.定义策略模式
     * 环境(Context)角色：持有一个Strategy的引用
     * 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现
     * 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为
     *
     *
     * public class Context {
          private Strategy strategy; 策略对象

          public Context(Strategy strategy) {
              this.strategy = strategy;  具体策略
          }
          public void contextInterface() {
              strategy.strategyInterface(); 执行具体方法
          }
       }

     */
}
