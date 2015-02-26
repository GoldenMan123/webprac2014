<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${course.name}<br>${company.name}
</div>

<div class="page_title">
Добавить занятие
</div>

<script type="text/javascript">

  function checkForm(form)
  {
    form.time.parentElement.className = "fio_field";
    form.duration.parentElement.className = "fio_field";
    form.date_start.parentElement.className = "fio_field";
    form.date_end.parentElement.className = "fio_field";
    if(!checkTime(form.time)) {
        form.time.parentElement.className = "fio_field_err";
        return false;
    }
    if(!checkTime(form.duration)) {
        form.duration.parentElement.className = "fio_field_err";
        return false;
    }
    if(!checkDate(form.date_start)) {
        form.date_start.parentElement.className = "fio_field_err";        
        return false;
    }
    if(!checkDate(form.date_end)) {
        form.date_end.parentElement.className = "fio_field_err";        
        return false;
    }
    return true;
  }

</script>

<form:form modelAttribute="lessonAttribute" method="POST" action="lesson_add">

<form:input type="hidden" path="courseId" value="${course.courseId}"/>

<div class="fio_field" id="fio_field_5">
<form:select path="teacherId">
<c:forEach items="${teachers}" var="teacher">
<option value="${teacher.teacherId}">${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</option>
</c:forEach>
</form:select>
</div>

<div class="fio_field" id="fio_field_1">
<form:input path="time" placeholder="Время (ЧЧ:ММ)"/>
</div>

<div class="fio_field" id="fio_field_2">
<form:input path="duration" placeholder="Продолжительность (ЧЧ:ММ)"/>
</div>

<div class="fio_field" id="fio_field_6">
<form:select path="period">
<option value="1">Раз в неделю</option>
<option value="2">Два раза в неделю</option>
<option value="0">Один раз</option>
</form:select>
</div>

<div class="fio_field" id="fio_field_3">
<form:input path="date_start" placeholder="Дата начала (ДД.ММ.ГГГГ)"/>
</div>

<div class="fio_field" id="fio_field_4">
<form:input path="date_end" placeholder="Дата конца (ДД.ММ.ГГГГ)"/>
</div>

<div class="button_wrap" id="button_wrap_1">

<div class="ok_button" onclick="if (checkForm(document.forms['lessonAttribute'])) document.forms['lessonAttribute'].submit()">
Добавить
</div>

<a href="course?id=${course.courseId}">
<div class="cancel_button">
Назад
</div>
</a>

</div>

<div class="mb"></div>

</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
