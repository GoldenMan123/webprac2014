<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Учебный Центр "Ромашка"</title>
    <link rel="stylesheet" href="resources/styles/main.css">
    <link rel="shortcut icon" href="resources/favicon.ico" type="image/x-icon">
    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
    <script type="text/javascript">
    $(document).ready(function(){
	
	    $(".acc1 .acc2").eq(2).addClass("active");
	    $(".acc1 .acc3").eq(2).show();

	    $(".acc1 .acc2").click(function(){
		    $(this).next(".acc3").slideToggle("slow")
		    .siblings(".acc3:visible").slideUp("slow");
		    $(this).toggleClass("active");
		    $(this).siblings(".acc2").removeClass("active");
	    });

    });
    </script>
    <style type="text/css">
    .acc2 {
        cursor: pointer;    
    }
    .acc1 .acc3 {
	    display: none;
    }
    </style>
</head>
<body>

<a href="index">
<div class="header">
Учебный Центр "Ромашка"
</div>
</a>