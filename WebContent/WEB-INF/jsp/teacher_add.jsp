<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Добавить педагога
</div>

<form:form modelAttribute="teacherAttribute" method="POST" action="teacher_add">

<div class="fio_field" id="fio_field_1">
<form:input path="lastName" placeholder="Фамилия"/>
</div>

<div class="fio_field" id="fio_field_2">
<form:input path="firstName" placeholder="Имя"/>
</div>

<div class="fio_field" id="fio_field_3">
<form:input path="middleName" placeholder="Отчество"/>
</div>

<div class="button_wrap" id="button_wrap_1">

<div class="ok_button" onclick="document.forms['teacherAttribute'].submit()">
Добавить
</div>

<a href="teachers">
<div class="cancel_button">
Назад
</div>
</a>

</div>

</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>