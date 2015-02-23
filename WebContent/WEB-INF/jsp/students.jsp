<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Наши студенты:
</div>

<c:forEach items="${students}" var="student">
<a href="student?id=${student.studentId}">
<div class="student_entry" id="student_entry_${student.studentId}">
${student.lastName} ${student.firstName} ${student.middleName}
</div>
</a>
</c:forEach>

<a href="student_add">
<div class="student_entry" id="student_entry_add">
Добавить студента
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>