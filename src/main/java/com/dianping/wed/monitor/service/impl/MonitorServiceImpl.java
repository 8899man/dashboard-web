package com.dianping.wed.monitor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dianping.wed.monitor.dao.MonitorDao;
import com.dianping.wed.monitor.dao.MonitorPageConfigDao;
import com.dianping.wed.monitor.dao.MonitorQueryTemplateDao;
import com.dianping.wed.monitor.dao.entity.MonitorPageConfig;
import com.dianping.wed.monitor.dao.entity.MonitorQueryTemplate;
import com.dianping.wed.monitor.service.MonitorService;
import com.dianping.wed.monitor.service.bean.MonitorPageConfigDTO;
import com.dianping.wed.monitor.service.bean.MonitorQueryDTO;
import com.dianping.wed.monitor.util.BeanListUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author dan.shan
 * @since 2015-06-03 10:08
 */
public class MonitorServiceImpl implements MonitorService {

    private static final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);

    @Resource
    private MonitorDao monitorDao;
    @Resource
    private MonitorQueryTemplateDao monitorQueryTemplateDao;
    @Resource
    private MonitorPageConfigDao monitorPageConfigDao;

    @Override
    public List<List<String>> findDataByQuery(String collectionName, MonitorQueryDTO query) {
        Assert.notNull(query, "query should not be empty");
        Assert.isTrue(StringUtils.isNotBlank(query.getQuery()), "query.query should not be empty");
        Assert.isTrue(StringUtils.isNotBlank(query.getKeys()), "query.keys should not be empty");
        Assert.isTrue(StringUtils.isNotBlank(collectionName), "collection name should not be empty");

        List<JSONObject> list = monitorDao.findByQuery(collectionName, query);
        List<String> result = Lists.newLinkedList();
        JSONObject keys = JSONObject.parseObject(query.getKeys());
        for (JSONObject jsonObject : list) {
        }
        return new LinkedList<List<String>>();
    }

    @Override
    public MonitorQueryDTO loadQueryTemplateByPageId(int pageId) {
        MonitorQueryTemplate template = monitorQueryTemplateDao.loadQueryTemplateByPageId(pageId);
        if (template == null) {
            return new MonitorQueryDTO();
        }

        return BeanListUtil.copyProperties(template, MonitorQueryDTO.class);
    }

    @Override
    public MonitorQueryDTO renderQuery(MonitorQueryDTO queryTemplate, Map<String, String> filterMap) {
        // TODO 渲染
        return queryTemplate;
    }

    @Override
    public MonitorPageConfigDTO loadPageConfigByPageId(int pageId) {
        MonitorPageConfig config = monitorPageConfigDao.loadConfigByPageId(pageId);
        if (config == null) {
            return new MonitorPageConfigDTO();
        }

        return BeanListUtil.copyProperties(config, MonitorPageConfigDTO.class);
    }
}
