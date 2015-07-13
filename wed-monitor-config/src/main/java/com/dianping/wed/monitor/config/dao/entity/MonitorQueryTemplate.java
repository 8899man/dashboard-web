package com.dianping.wed.monitor.config.dao.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * @author dan.shan
 * @since 2015-06-03 13:55
 */
@Entity(noClassnameStored = true)
@Data
public class MonitorQueryTemplate {
    @Id
    private ObjectId id = new ObjectId();

    private String pageId;
    private String query;
    private String xaxis;
    /** 数据源 */
    private String datasource;

    private int isDeleted;
    private Date addTime;
    private Date updateTime;
}
