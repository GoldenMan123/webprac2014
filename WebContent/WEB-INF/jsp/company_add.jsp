<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Добавить компанию
</div>

<form:form modelAttribute="companyAttribute" method="POST" action="company_add">

<div class="fio_field" id="fio_field_1">
<form:input path="name" placeholder="Название"/>
</div>

<div class="fio_field" id="fio_field_2">
<form:input path="address" placeholder="Адрес"/>
</div>

<div class="button_wrap" id="button_wrap_1">

<div class="ok_button" onclick="document.forms['companyAttribute'].submit()">
Добавить
</div>

<a href="companies">
<div class="cancel_button">
Назад
</div>
</a>

</div>

<div class="mb"></div>

</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>