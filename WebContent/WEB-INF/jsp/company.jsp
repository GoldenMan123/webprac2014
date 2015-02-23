<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${company.name}<br>${company.address}
</div>

<c:forEach items="${courses}" var="course">
<a href="course?id=${course.courseId}">
<div class="student_entry" id="student_entry_${course.courseId}">
${course.name}
</div>
</a>
</c:forEach>

<a href="course_add?id=${company.companyId}">
<div class="student_entry" id="student_entry_add">
Добавить курс
</div>
</a>

<a href="company_del?id=${company.companyId}">
<div class="main_entry" id="main_entry_del_${comapny.companyId}">
Удалить компанию
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>