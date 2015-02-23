<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page_title">
Наши компании:
</div>

<c:forEach items="${companies}" var="company">
<a href="company?id=${company.companyId}">
<div class="student_entry" id="student_entry_${company.companyId}">
${company.name}
</div>
</a>
</c:forEach>

<a href="company_add">
<div class="student_entry" id="student_entry_add">
Добавить компанию
</div>
</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>