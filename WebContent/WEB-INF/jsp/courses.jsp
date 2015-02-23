<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Наши курсы:
</div>

<c:forEach items="${courses}" var="course">
<a href="course?id=${course.courseId}">
<div class="student_entry" id="student_entry_${course.courseId}">
${course.name}
</div>
</a>
</c:forEach>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>