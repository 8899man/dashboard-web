<#include "/WEB-INF/pages/common/navbar.ftl" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Monitor Chart Preview</title>

    <link href="/static/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/codemirror/codemirror.css" rel="stylesheet">
    <link href="/static/css/codemirror/monokai.css" rel="stylesheet">

    <script src="/static/js/jquery/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.js"></script>
    <script src="/static/js/echarts/echarts-2.2.3.js"></script>
    <script src="/static/js/codemirror/codemirror.js"></script>
    <script src="/static/js/codemirror/javascript.js"></script>
</head>
<body>

<@navbar/>

<!-- container start -->
<div class="container-fluid">
    <div class="row-fluid">
        <div id="sidebar-code" class="col-md-4">
            <div class="well sidebar-nav">
                <label class="control-label">测试数据</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="J_dataapi" value="/ajax/monitor/data?pageId=${pageId}">
                    <div type="button" class="input-group-addon" onclick="checkDataApi()">Check</div>
                </div>
                <div class="nav-header">
                    <a href="#" onclick="autoResize()" class="glyphicon glyphicon-resize-full" id ="icon-resize" ></a>option
                </div>
                <textarea id="code" name="code">${(chartOption.option)!demoOption}</textarea>
            </div><!--/.well -->
        </div><!--/span-->
        <input hidden="hidden" class="J_pageId" value="${pageId}">
        <div id="graphic" class="col-md-8">
            <div id="main" class="main" style="height:400px"></div>
            <div>
                <button type="button" class="btn btn-sm btn-success" onclick="refresh(true)">
                    <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷 新
                </button>
                <button type="button" class="btn btn-sm btn-success" onclick="saveQueryTemplate()">
                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>保 存
                </button>
                <span id='wrong-message' style="color:red"></span>
            </div>
        </div><!--/span-->
    </div><!--/row-->

</div><!--/.fluid-container-->
<!-- container end -->

<script src="/static/js/monitor/chartfactory.js"></script>
<script src="/static/js/monitor/optionpreview.js"></script>
</body>
</html>