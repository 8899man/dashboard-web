package com.dianping.wed.monitor.web.action.monitor.ajax;

import com.dianping.wed.monitor.config.service.dto.MonitorPageConfigDTO;
import com.dianping.wed.monitor.service.MonitorService;
import com.dianping.wed.monitor.web.action.AjaxBaseAction;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 关于page的写操作
 * @author dan.shan
 * @since 2015-07-09 09:59
 */
public class PageConfigOpJsonAction extends AjaxBaseAction {

    @Setter
    private String action; // add / update / delete

    @Setter
    private String pageId;
    @Setter
    private String pageName;
    @Setter
    private String pageDesc;

    @Resource
    private MonitorService monitorService;

    @Override
    protected int doAjaxExecute(Map<String, Object> result) throws Exception {
        Assert.isTrue(StringUtils.isNotBlank(action), "action should not be null.");

        String opresult;
        if ("add".equals(action)) {
            opresult = addPageConfig();
        } else if ("update".equals(action)) {
            opresult = updatePageConfig();
        } else if ("delete".equals(action)) {
            opresult = deletePageConfig();
        } else {
            opresult = "known action";
        }

        getMsg().put("result", opresult);
        return CODE_SUCCESS;
    }

    private String deletePageConfig() {
        Assert.isTrue(StringUtils.isNotBlank(pageId), "page id should not be null.");

        return monitorService.deletePageConfigByPageId(pageId);
    }

    private String updatePageConfig() {
        Assert.isTrue(StringUtils.isNotBlank(pageId), "page id should not be null.");

        MonitorPageConfigDTO pageConfig = buildPageConfig();
        return monitorService.updatePageConfigByPageId(pageConfig);
    }

    private String addPageConfig() {
        MonitorPageConfigDTO pageConfig = buildPageConfig();
        return monitorService.addPageConfig(pageConfig);
    }

    private MonitorPageConfigDTO buildPageConfig() {
        Assert.isTrue(StringUtils.isNotBlank(pageName), "page name should not be null.");

        MonitorPageConfigDTO pageConfig = new MonitorPageConfigDTO();
        pageConfig.setPageId(pageId);
        pageConfig.setPageName(pageName.trim());
        pageConfig.setPageDesc(StringUtils.trimToEmpty(pageDesc));
        // TODO input filter

        return pageConfig;
    }
}
