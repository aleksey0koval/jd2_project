<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<#if page.getTotalPages() gt 7>
<#assign
totalPages = sensorList.
pageNumber = page.getNumber() + 1

head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
>
<#else>
<#assign body = 1..page.getTotalPages()>
</#if>



<c:choose>
<c:when test="${page.getTotalPages()>4}">
<%
    int totalPage = 1;
    int pageNumber = 10;
%>
</c:when>
<%
    int a = 5;
    int b = a + 10;
%>
model.addAttribute("sensorList", sensors);
model.addAttribute("size", listSize);
<c:otherwise>

</c:otherwise>

</c:choose>
<div>
    <ul class="pagination">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Pages</a>
        </li>
        <c:forEach items="${}" var="pageItem">
            <c:choose>
                <c:when test="${(pageItem-1) == page.getNumber()}">
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${pageItem}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${pageItem-1}&size=${page.getSize}" tabindex="-1">${pageItem - 1}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Elements</a>
        </li>
        <c:forEach items="${[4, 8, 12, 16]}" var="pageSize">
            <c:choose>
                <c:when test="${pageSize == page.getSize()}">
                    <li class="page-item active">
                        <a class="page-link" href="#">${pageSize}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${page.getNumber()}&size=${pageSize}" tabindex="-1">${pageSize}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </ul>
</div>

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||


<div>
    <ul class="pagination">
<li class="page-item disabled">
    <a class="page-link" href="#" tabindex="-1">Pages</a>
</li>
<c:forEach items="${listSize}" var="pageItem">
<c:choose>
<c:when test="${(pageItem-1) == page}">
<li class="page-item active">
    <a class="page-link" href="#" tabindex="-1">${pageItem}</a>
</li>
</c:when>
<c:when test="${pageItem == -1}">
    <li class="page-item active">
        <a class="page-link" href="#" tabindex="-1">...</a>
    </li>
</c:when>
<c:otherwise>
<li class="page-item">
    <a class="page-link" href="${url}?page=${pageItem-1}&size=${size}" tabindex="-1">${pageItem}</a>
</li>
</c:otherwise>
</c:choose>
</c:forEach>

<li class="page-item disabled">
    <a class="page-link" href="#" tabindex="-1">Elements</a>
</li>
<c:forEach items="${[4, 8, 12, 16]}" var="pageSize">
<c:choose>
<c:when test="${pageSize == size}">
<li class="page-item active">
    <a class="page-link" href="#">${pageSize}</a>
</li>
</c:when>
<c:otherwise>
<li class="page-item">
    <a class="page-link" href="${url}?page=${page}&size=${pageSize}" tabindex="-1">${pageSize}</a>
</li>
</c:otherwise>
</c:choose>
</c:forEach>

</ul>
</div>

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

<#if page.getTotalPages() gt 7>
<#assign
totalPages = page.getTotalPages()
pageNumber = page.getNumber() + 1

head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
>
<#else>
<#assign body = 1..page.getTotalPages()>
</#if>





<div class="container mt-3">
    <div class="row">
        <ul class="pagination col justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Страницы</a>
            </li>
            <#list body as p>
            <#if (p - 1) == page.getNumber()>
            <li class="page-item active">
                <a class="page-link" href="#" tabindex="-1">${p}</a>
            </li>
            <#elseif p == -1>
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">...</a>
            </li>
            <#else>
            <li class="page-item">
                <a class="page-link" href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
            </li>
        </#if>
    </#list>
    </ul>

    <ul class="pagination col justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Элементов на странице</a>
        </li>
        <#list [5, 10, 25, 50] as c>
        <#if c == page.getSize()>
        <li class="page-item active">
            <a class="page-link" href="#" tabindex="-1">${c}</a>
        </li>
        <#else>
        <li class="page-item">
            <a class="page-link" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
        </li>
    </#if>
</#list>
</ul>
</div>
</div>
