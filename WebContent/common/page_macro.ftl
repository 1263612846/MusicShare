<#include "config.ftl">
<#include "common_function.ftl">

<#macro page navi=[] title=macro_config.default_title body="" head="" setReferUrl=false>
<#if setReferUrl>${action.setReferUrl()}</#if>
<#if navi?has_content>
	<#if title==macro_config.default_title>
		<#local title = navi?last>
	</#if>
</#if>
<html>
<head>
	<title>	<#if request.servletPath?starts_with("/photo")>
		${macro_config.common_title1} -
		<#elseif request.servletPath?starts_with("/book")>
		${macro_config.common_title2} -
		<#elseif request.servletPath?starts_with("/pcms")>
		${macro_config.common_title3} -
		<#else>${macro_config.common_title}</#if>
		 ${title?html}</title>
	<link href="${base}${macro_config.css_path}" rel="stylesheet" type="text/css">
	<link href="${base}/components/calendar/skins/aqua/theme.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="${base}${macro_config.js_path}"></script>
	<script language="javascript" src="${base}/components/calendar/calendar.js"></script>
	<script language="javascript" src="${base}/components/calendar/calendar-setup.js"></script>
	<script language="javascript" src="${base}/components/calendar/lang/calendar-zh_CN.js"></script>
	
	<meta http-equiv="Content-type" content="text/html; charset=${macro_config.charset}">
	${head}
</head>
<#if !request.servletPath?starts_with("/login_view")&&!request.servletPath?starts_with("/login")>
<body ${body} style="margin:0;background:#FFFFFF" >
<table width="778px" height="100%" cellSpacing="0" cellPadding="0" border="0" align="center">
<tr><td height="35px">
<table  style="width:100%;border:0" width="100%" border="0" align="center" cellpadding="0" cellspacing="0"  height="34">
<tr><td align="center"  style="font-size:10pt"><#if request.servletPath?starts_with("/photo")><img src="${base}/images/zpgld.jpg"><#elseif request.servletPath?starts_with("/book")><img src="${base}/images/zpgl.jpg"><#else><img src="${base}/images/txl.jpg"></#if></td></tr>
</table>
</td>
</tr>
<tr>
<td valign="top" style="background:#F0F8FC;padding:10px" >
<table style="width:100%;border:0" align="center">
<tr>
<td>
<#list navi as item><@p.menuMark/> ${item} </#list>
<#nested>
</td>
</tr>
</table>
</td>
</tr>
<tr><td height="26px">
<table  style="width:778px;border:0"  border="0" align="center" cellpadding="0" cellspacing="0" background="${base}/images/btm_bg.gif">
  <tr>
    <td height="26" align="center" style="color:white;font-size:8pt">Copyright &#169; 2016 在线音乐共享系统 All rights reserved.&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</td></tr>
</table>
</body>
<#else>
<body ${body} style="margin:0;background:Silver">
<table width="100%" height="100%">
<tr><td valign="middle">
<#nested>
</td></tr>
</table>
</body>
</#if>
</html>
</#macro>

<#macro intro tasks={}>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="explain">
<tr>
	<td><#nested></td>
</tr>
</table>
<#if (tasks?size > 0)>
<div style="margin-top:5px">
<#assign keys = tasks?keys>
<#list keys as key><a href="${parseLink(tasks[key])}" class="navlink">${key}</a> </#list>
</div>
</#if>
</#macro>

<#macro trClass>
<#if lineNumber?exists>
<#assign lineNumber=lineNumber+1/>
<#else>
<#assign lineNumber=1/>
</#if>
class="style${lineNumber%2}"
</#macro>

<#macro explain width="100%" align="center">
<table class="explain" width="${width}" align="${align}">
<tr>
	<td>
	<#nested>
	</td>
</tr>
</table>
</#macro>

<#macro mustMark><span class="notNull">*</span></#macro>

<#macro menuMark><span style="font-family:Webdings;color:#FF3300;font-weight:normal;">4</span></#macro>

<#macro chartColumn width height="8" color="#0066CC"><span style="background:${color};height:${height};width:${width}"></span></#macro>

<#macro trChangeColor>
 onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#BFDFFF'"
</#macro>

<#-- 处理分页参数 -->
<#function getPageUrl pageNum>
<#local pageUrl=base+fullUrlWithoutPageNum>
<#if pageUrl?ends_with("?")>
<#return pageUrl + "pageNum=" + pageNum>
<#else>
<#return pageUrl + "&pageNum=" + pageNum>
</#if>
</#function>

<#-- 分页信息 -->
<#macro paging pagingList>
<#local pageCount=pagingList.pageCount>
<#local rowCount=pagingList.rowCount>
<#local pageNum=pagingList.pageNum>
<#local pageSize=pagingList.pageSize>
<#if rowCount == 0>
	<#if useFlag?exists>
	<div style="border:1px solid #666;padding:2 5 2 5;background:#efefef;color:#333">没有相关记录</div>
	<#else>
	<#assign useFlag = 1>
	</#if>
<#else>
<table>
<tr>
	<td style="line-height:150%">
	共 ${rowCount} 条记录 ${pageCount} 页
	<#if (pageCount <= 11)>
		<#local startPage = 1>
		<#local endPage = pageCount>
	<#elseif (pageNum + 5 > pageCount)>
		<#local startPage = pageCount - 10>
		<#local endPage = pageCount>
	<#elseif (pageNum - 5 < 1)>
		<#local startPage = 1>
		<#local endPage = 11>
	<#else>
		<#local startPage = pageNum - 5>
		<#local endPage = pageNum + 5>
	</#if>
	<#if (pageCount > 1)><#if (pageNum != 1)><#if (pageCount > 11)><a class="page" href="${getPageUrl(1)}" style="font-family:Webdings" title="首页">9</a></#if><a class="page" href="${getPageUrl(pageNum-1)}" style="font-family:Webdings" title="上页">3</a><#else><#if (pageCount > 11)><span style="font-family:Webdings;color:#999">9</span></#if><span style="font-family:Webdings;color:#999">3</span></#if><#list startPage..endPage as x><#if x=pageNum><span class="selectedPage">${x}</span><#else><span class="noSelectedPage"><a class="page" href="${getPageUrl(x)}">${x}</a></span></#if></#list><#if (pageCount != pageNum)><a class="page" href="${getPageUrl(pageNum+1)}" style="font-family:Webdings" title="下页">4</a><#if (pageCount > 11)><a class="page" href="${getPageUrl(pageCount)}" style="font-family:Webdings" title="尾页">:</a></#if><#else><span style="font-family:Webdings;color:#999">4</span><#if (pageCount > 11)><span style="font-family:Webdings;color:#999">:</span></#if></#if></#if>
	</#if>
	</td>
</tr>
</table>
</#macro>
<#-- 日历控件 -->
<#macro cal name format="%Y-%m-%d" text="选择日期">
<#if calcount?exists>
<#assign calcount=calcount+1/>
<#else>
<#assign calcount=0/>
</#if>
<img id="cal${calcount}" src="${base}/components/calendar/skins/aqua/cal.gif" border="0" alt="${text}" style="cursor:pointer">
<script language="JavaScript">var cal${calcount} = calendar("${name}", "cal${calcount}", "${format}");</script>
</#macro>