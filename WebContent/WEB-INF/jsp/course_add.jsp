<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${company.name}<br>${company.address}
</div>

<form:form modelAttribute="courseAttribute" method="POST" action="course_add">

<form:input type="hidden" path="companyId" value="${company.companyId}"/>

<div class="fio_field" id="fio_field_1">
<form:input path="name" placeholder="Название"/>
</div>

<div class="button_wrap" id="button_wrap_1">

<div class="ok_button" onclick="document.forms['courseAttribute'].submit()">
Добавить
</div>

<a href="company?id=${company.companyId}">
<div class="cancel_button">
Назад
</div>
</a>

</div>

</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>