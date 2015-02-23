<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${course.name}<br>${company.name}
</div>

<div class="page_title">
Добавить студента:
</div>

<c:forEach items="${students}" var="student">
<a href="student_course_add_post?course_id=${course.courseId}&student_id=${student.studentId}">
<div class="student_entry" id="student_entry_${student.studentId}">
${student.lastName} ${student.firstName} ${student.middleName}
</div>
</a>
</c:forEach>

<a href="course?id=${course.courseId}">
<div class="main_entry" id="main_entry_back">
Назад
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>