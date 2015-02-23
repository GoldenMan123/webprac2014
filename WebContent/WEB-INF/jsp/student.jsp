<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${student.lastName} ${student.firstName} ${student.middleName}
</div>

<a href="student_del?id=${student.studentId}">
<div class="student_entry" id="student_entry_del_${student.studentId}">
Удалить студента
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>