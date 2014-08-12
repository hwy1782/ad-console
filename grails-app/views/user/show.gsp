
<%@ page import="ad.user.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.accountstate}">
				<li class="fieldcontain">
					<span id="accountstate-label" class="property-label"><g:message code="user.accountstate.label" default="Accountstate" /></span>
					
						<span class="property-value" aria-labelledby="accountstate-label"><g:fieldValue bean="${userInstance}" field="accountstate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.createtime}">
				<li class="fieldcontain">
					<span id="createtime-label" class="property-label"><g:message code="user.createtime.label" default="Createtime" /></span>
					
						<span class="property-value" aria-labelledby="createtime-label"><g:formatDate date="${userInstance?.createtime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.deleted}">
				<li class="fieldcontain">
					<span id="deleted-label" class="property-label"><g:message code="user.deleted.label" default="Deleted" /></span>
					
						<span class="property-value" aria-labelledby="deleted-label"><g:fieldValue bean="${userInstance}" field="deleted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="user.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${userInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				%{--<g:if test="${userInstance?.signstate}">
				<li class="fieldcontain">
					<span id="signstate-label" class="property-label"><g:message code="user.signstate.label" default="Signstate" /></span>
					
						<span class="property-value" aria-labelledby="signstate-label"><g:fieldValue bean="${userInstance}" field="signstate"/></span>
					
				</li>
				</g:if>--}%
			
				<g:if test="${userInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="user.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${userInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.updatetime}">
				<li class="fieldcontain">
					<span id="updatetime-label" class="property-label"><g:message code="user.updatetime.label" default="Updatetime" /></span>
					
						<span class="property-value" aria-labelledby="updatetime-label"><g:formatDate date="${userInstance?.updatetime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.userid}">
				<li class="fieldcontain">
					<span id="userId-label" class="property-label"><g:message code="user.userid.label" default="User Id" /></span>
					
						<span class="property-value" aria-labelledby="userId-label"><g:fieldValue bean="${userInstance}" field="userid"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:userInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
