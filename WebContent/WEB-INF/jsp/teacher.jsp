<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${teacher.lastName} ${teacher.firstName} ${teacher.middleName}
</div>

<div class="button_wrap" id="button_wrap_1">

<a href="teacher?id=${teacher.teacherId}&week_id=${week_id - 1}">
<div class="ok_button">
Предыдующая неделя
</div>
</a>

<a href="teacher?id=${teacher.teacherId}&week_id=${week_id + 1}">
<div class="cancel_button">
Следующая неделя
</div>
</a>

</div>

<div class="mb"></div>

<c:forEach items="${lessons}" var="lesson">
<a href="lesson?id=${lesson.lessonId}">
<div class="student_entry" id="student_entry_less_${lesson.lessonId}">
<fmt:formatDate value="${lesson.time_start}" var="time_str1" pattern="HH:mm" />
<fmt:formatDate value="${lesson.time_end}" var="time_str2" pattern="HH:mm" />
<fmt:formatDate value="${lesson.date}" var="date_str" pattern="dd.MM.yyyy" />
${lesson.courseName}<br>
${date_str}<br>
${time_str1} &mdash; ${time_str2}
</div>
</a>
</c:forEach>

<a href="teacher_del?id=${teacher.teacherId}">
<div class="main_entry" id="main_entry_del_${teacher.teacherId}">
Удалить педагога
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>