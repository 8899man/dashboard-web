package com.dianping.wed.monitor.dao;

import com.dianping.wed.monitor.dao.entity.MonitorOption;

/**
 * @author dan.shan
 * @since 2015-06-04 16:24
 */
public interface MonitorOptionDao {
    public MonitorOption loadOptionByPageId(int pageId);
}
