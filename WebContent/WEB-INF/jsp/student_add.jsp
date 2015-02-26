<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Добавить студента
</div>

<form:form modelAttribute="studentAttribute" method="POST" action="student_add">

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

<div class="ok_button" onclick="document.forms['studentAttribute'].submit()">
Добавить
</div>

<a href="students">
<div class="cancel_button">
Назад
</div>
</a>

</div>

<div class="mb"></div>

</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>