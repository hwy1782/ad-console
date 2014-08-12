
<%@ page import="ad.user.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
                        <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'ID')}" />

                        <g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />

                        <g:sortableColumn property="state" title="${message(code: 'user.state.label', default: 'State')}" />

                        <g:sortableColumn property="accountstate" title="${message(code: 'user.accountstate.label', default: 'Accountstate')}" />

                        <g:sortableColumn property="createtime" title="${message(code: 'user.createtime.label', default: 'Createtime')}" />

                        <g:sortableColumn property="deleted" title="${message(code: 'user.deleted.label', default: 'Deleted')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "userid")}</g:link></td>

                        <td>${fieldValue(bean: userInstance, field: "name")}</td>

                        <td>${fieldValue(bean: userInstance, field: "state")}</td>

                        <td>${fieldValue(bean: userInstance, field: "accountstate")}</td>

                        <td><g:formatDate date="${userInstance.createtime}" /></td>

                        <td>${fieldValue(bean: userInstance, field: "deleted")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
