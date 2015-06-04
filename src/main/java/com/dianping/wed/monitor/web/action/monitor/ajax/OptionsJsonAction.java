package com.dianping.wed.monitor.web.action.monitor.ajax;

import com.alibaba.fastjson.JSON;
import com.dianping.wed.monitor.service.MonitorService;
import com.dianping.wed.monitor.service.bean.MonitorOptionDTO;
import com.dianping.wed.monitor.web.action.AjaxBaseAction;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author dan.shan
 * @since 2015-06-02 16:04
 */
public class OptionsJsonAction extends AjaxBaseAction {

    @Setter
    private int pageId;

    @Resource
    private MonitorService monitorService;

    @Override
    protected int doAjaxExecute(Map<String, Object> result) throws Exception {
        Assert.isTrue(pageId > 0, "page id should be positive number.");
        MonitorOptionDTO option = monitorService.loadOptionByPageId(pageId);
        Map<String, Object> optionObj = JSON.parseObject(option.getOption());

        getMsg().put("option", optionObj);
        return CODE_SUCCESS;
    }

}
