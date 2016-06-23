<#if errorInfo?exists>
<table class="errorBox" border="0" cellspacing="0" cellpadding="0" width="100%">
<tr>
<td class="errorMessage">
<ul>
	<li>${errorInfo?default("")}</li>
</ul>
</td>
</tr>
</table>
</#if>