<#-- 解析通用链接地址 -->
<#function parseLink link>
<#switch link>
	<#case "@back"><#return "javascript:history.go(-1)"><#break>
<#default>
	<#return link>
</#switch>
</#function>