<%@ page import="ad.user.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountstate', 'error')} required">
	<label for="accountstate">
		<g:message code="user.accountstate.label" default="Accountstate" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="accountstate" required="" value="${userInstance?.accountstate}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'createtime', 'error')} required">
	<label for="createtime">
		<g:message code="user.createtime.label" default="Createtime" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createtime" precision="day"  value="${userInstance?.createtime}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'deleted', 'error')} required">
	<label for="deleted">
		<g:message code="user.deleted.label" default="Deleted" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="deleted" type="number" value="${userInstance.deleted}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'signstate', 'error')} required">
	<label for="signstate">
		<g:message code="user.signstate.label" default="Signstate" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="signstate" required="" value="${userInstance?.signstate}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="user.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" required="" value="${userInstance?.state}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'updatetime', 'error')} required">
	<label for="updatetime">
		<g:message code="user.updatetime.label" default="Updatetime" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="updatetime" precision="day"  value="${userInstance?.updatetime}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userId', 'error')} required">
	<label for="userId">
		<g:message code="user.userId.label" default="User Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="userId" type="number" value="${userInstance.userId}" required=""/>

</div>

