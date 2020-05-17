package com.hjj.toy.experience;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BatchDomain {

    private List<BatchDomainItem> data;

    @Data
    public static class BatchDomainItem {
        private Long tableId;
        private String tableName;
        private Integer actionType;
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date actionTime;
    }
}

