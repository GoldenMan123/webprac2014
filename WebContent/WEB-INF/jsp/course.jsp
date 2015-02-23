<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${course.name}<br>${company.name}
</div>

<div class="acc1">
<div class="acc2">
<div class="main_entry">
Студенты
</div>
</div>
<div class="acc3">

<c:forEach items="${students}" var="student">
<div class="button_wrap">
<a href="student?id=${student.studentId}">
<div class="student_entry_short_left" id="student_entry_shl_stu_${student.studentId}">
${student.lastName} ${student.firstName} ${student.middleName}
</div>
</a>
<a href="student_course_del?course_id=${course.courseId}&student_id=${student.studentId}">
<div class="student_entry_short_right" id="student_entry_shr_stu_${student.studentId}">
Удалить
</div>
</a>
</div>
</c:forEach>

<div class="mb"></div>

<a href="student_course_add?id=${course.courseId}">
<div class="student_entry" id="student_entry_add">
Добавить студента
</div>
</a>

</div>

<div class="acc2">
<div class="main_entry">
Педагоги
</div>
</div>
<div class="acc3">

<c:forEach items="${teachers}" var="teacher">
<a href="teacher?id=${teacher.teacherId}">
<div class="student_entry" id="student_entry_tea_${teacher.teacherId}">
${teacher.lastName} ${teacher.firstName} ${teacher.middleName}
</div>
</a>
</c:forEach>

</div>

<div class="acc2">
<div class="main_entry">
Занятия
</div>
</div>
<div class="acc3">

</div>
</div>

<a href="course_del?id=${course.courseId}">
<div class="main_entry" id="main_entry_del">
Удалить курс
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>