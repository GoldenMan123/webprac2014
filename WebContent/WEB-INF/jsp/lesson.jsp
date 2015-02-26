<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${course.name}<br>${company.name}
</div>

<div class="page_title" id="page_title_teacher">
Педагог:<br>${teacher.lastName} ${teacher.firstName} ${teacher.middleName}
</div>

<fmt:formatDate value="${lesson.time}" var="time_str" pattern="HH:mm" />
<fmt:formatDate value="${lesson.duration}" var="duration_str" pattern="HH:mm" />
<fmt:formatDate value="${lesson.date_start}" var="date_start" pattern="dd.MM.yyyy" />
<fmt:formatDate value="${lesson.date_end}" var="date_end" pattern="dd.MM.yyyy" />

<div class="page_title" id="page_title_time">
Время: ${time_str}<br>
Продолжительность: ${duration_str}<br>
Периодичность:
<c:choose>
    <c:when test="${lesson.period == 1}">Раз в неделю</c:when>
    <c:when test="${lesson.period == 2}">Два раза в неделю</c:when>
    <c:otherwise>Один раз</c:otherwise>
</c:choose>
</div>

<div class="page_title" id="page_title_ds">
Дата начала: ${date_start}
</div>

<div class="page_title" id="page_title_de">
Дата конца: ${date_end}
</div>

<a href="course?id=${course.courseId}">
<div class="main_entry" id="main_entry_del">
Назад
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>