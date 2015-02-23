<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Наши педагоги:
</div>

<c:forEach items="${teachers}" var="teacher">
<a href="teacher?id=${teacher.teacherId}">
<div class="student_entry" id="student_entry_${teacher.teacherId}">
${teacher.lastName} ${teacher.firstName} ${teacher.middleName}
</div>
</a>
</c:forEach>

<a href="teacher_add">
<div class="student_entry" id="student_entry_add">
Добавить педагога
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>