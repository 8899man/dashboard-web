package com.dianping.wed.monitor.config.dao;

import com.dianping.wed.monitor.config.dao.entity.MonitorPageConfig;

import java.util.List;

/**
 * @author dan.shan
 * @since 2015-06-03 10:10
 */
public interface MonitorPageConfigDao {

    public MonitorPageConfig loadConfigByPageId(String pageId);

    public String addPageConfig(MonitorPageConfig po);

    public String deletePageConfigByPageId(String pageId);

    public String updatePageConfigByPageId(MonitorPageConfig pageConfig);

    public List<MonitorPageConfig> findPageConfigs();
}
