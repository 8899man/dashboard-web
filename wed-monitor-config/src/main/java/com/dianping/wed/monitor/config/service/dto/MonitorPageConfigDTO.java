package com.dianping.wed.monitor.config.service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author dan.shan
 * @since 2015-06-03 17:05
 */
@Data
public class MonitorPageConfigDTO {

    private String pageId;
    private String pageName;
    private String pageDesc;
    /** 可选搜索条件 */
    private List<InputFilterDTO> inputFilters;
    /** 时间筛选条件, 如果该列不为空, 那么页面应该有针对dateFilter的startTime和endTime筛选功能 */
    private String timeFilter;

    private int isDeleted;
    private Date addTime;
    private Date updateTime;

    @Data
    public static final class InputFilterDTO {
        private String desc;
        private String name;
        private String value;
    }
}
