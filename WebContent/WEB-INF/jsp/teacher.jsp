<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
${teacher.lastName} ${teacher.firstName} ${teacher.middleName}
</div>

<a href="teacher_del?id=${teacher.teacherId}">
<div class="main_entry" id="main_entry_del_${teacher.teacherId}">
Удалить педагога
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>