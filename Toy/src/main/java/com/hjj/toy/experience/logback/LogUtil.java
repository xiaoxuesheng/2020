package com.hjj.toy.experience.logback;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class LogUtil {
    //推荐大家用 SLF4J 的门面接口
    //分级记录日志 appender 通过filter分级写文件 logger通过level 级包名分开记录
    //日志上下文，具体业务过程中某个时间点的状态
    //结构化日志，以用于监控统计告警




    //调试阶段启用的级别 需要在logback.xml开启debug级别,参数用占位符{},[]起标识分割作用
    class Debug {

        private String message;//log.debug("Save order with order no：[{}], and order amount：[{}]");

        public void write() {
            log.debug(message);
        }
    }

    //把用户行为(user-driven)和系统的特定行为(例如计划任务…)；
    //系统中核心角色触发的业务动作是需要多加关注的，是衡量系统正常运行的重要指标，建议记录INFO级别日志，比如电商系统用户从登录到下单的整个流程；微服务各服务节点交互；核心数据表增删改；核心组件运行等等，如果日志频度高或者打印量特别大，可以提炼关键点INFO记录，其余酌情考虑DEBUG级别
    //系统初始化：系统或者服务的启动参数。核心模块或者组件初始化过程中往往依赖一些关键配置，根据参数不同会提供不一样的服务。务必在这里记录INFO日志，打印出参数以及启动完成态服务表述。
    class Info {

        private String systemBehavior;//系统行为 如数据新增任务

        private Long time;//用时 如数据新增任务耗时

        private JSONObject extend;//扩展数据，依具体情况展开。
                                  //如数据新增任务 userName:li1,tableName:md_security

        public void statisticWrite(){
            JSONObject logModel = new JSONObject(true);
            Instant updateStart = Instant.now();
            Instant updateEnd = Instant.now();
            logModel.put("systemBehavior","data");
            logModel.put("time",Duration.between(updateStart,updateEnd).toMillis());
            log.info(logModel.toJSONString());
        }

        public void infoWrite(){
            log.info("方法执行开始的入参");//格式:>>>执行描述 [user:{?}]
            log.info("流程控制进入时");//格式:---执行描述 [user:{?}]
            log.info("方法执行结束的出参");//根据后续操作判断是否需要加此时日志 格式:<<<执行描述完成 [result:{?}]
        }

    }
    //业务预期不符合时记录.如外部参数不正确，数据处理问题导致返回码不在合理范围等
    class Warn {

    }

    //exception时记录
    class Error {

        private String systemBehavior;//系统行为 如数据新增任务

        private Long time;//用时 如数据新增任务耗时

        private String message;//错误信息

        private JSONObject extend;//扩展数据，依具体情况展开。
        //如数据新增任务 userName:li1,tableName:md_security

        public void statisticWrite(){
            try {

            } catch (Exception e){
                JSONObject logModel = new JSONObject(true);
                Instant updateStart = Instant.now();
                Instant updateEnd = Instant.now();
                logModel.put("systemBehavior","data");
                logModel.put("time",Duration.between(updateStart,updateEnd).toMillis());
                log.error(logModel.toJSONString(),e);
            }

        }
    }
}
