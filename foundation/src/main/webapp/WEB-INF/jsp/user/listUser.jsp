<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>사용자 리스트</title>
</head>

<script>
$(document).ready(function() {
	var currentPage = "${user.getNumber()}";
	var totalCnt = "${user.getTotalElements()}";
	var rowCnt = "${user.getNumberOfElements()}";
	var pageCnt = 10;
	
	//alert("currentPage : "+currentPage +" // totalCnt : " + totalCnt + " // rowCnt : " + rowCnt);
	
	
	printPage(currentPage, totalCnt, rowCnt, pageCnt);
	
	/*
	int getNumber();             //현재 페이지
	int getSize();               //페이지 크기
	int getTotalPages();         //전체 페이지 수
	int getNumberOfElements();   //현재 페이지에 나올 데이터 수
	long getTotalElements();     //전체 데이터 수
	boolean hasPreviousPage();   //이전 페이지 여부
	boolean isFirstPage();       //현재 페이지가 첫 페이지 인지 여부
	boolean hasNextPage();       //다음 페이지 여부
	boolean isLastPage();        //현재 페이지가 마지막 페이지 인지 여부
	Pageable nextPageable();     //다음 페이지 객체, 다음 페이지가 없으면 null
	Pageable previousPageable(); //다음 페이지 객체, 이전 페이지가 없으면 null
	List<T> getContent();        //조회된 데이터
	boolean hasContent();        //조회된 데이터 존재 여부
	Sort getSort();              //정렬정보
	*/

});

//페이지 처리
function printPage(getPage, totalCnt, rowCnt, pageCnt) {
	var currentPage = parseInt(getPage) + 1;
	var prevBtn = "";
	var nextBtn = "";
	
	totalCnt = parseInt(totalCnt);
	
	rowCnt = parseInt(rowCnt);
	pageCnt = parseInt(pageCnt);
	
	var stdPage = parseInt(Math.ceil(parseInt(currentPage)/parseInt(pageCnt)));
	
	var startPage = (stdPage - 1) * pageCnt + 1;
	var endPage = startPage + pageCnt - 1;
	var totalPageCnt = Math.ceil(totalCnt / rowCnt);
	
    if (endPage > totalPageCnt) { 
    	endPage = totalPageCnt; 
    }
    
	$('#pageNav').empty();
	var ul = $('<ul>').addClass('pagination').appendTo($('#pageNav'));
	
	if (currentPage > 1){
		prevBtn = "<li><a href='#' aria-label='Previous' onclick='setPage("+(currentPage - 1) +")'><span aria-hidden='true'>&lsaquo;</span></a>";
		ul.append(prevBtn);
	}
	
	//alert("startPage : "+startPage + "// endPage : "+ endPage);
	
	for ( var i = startPage; i <= endPage; i++) {
		var li = $('<li>').appendTo(ul);
		if (currentPage == i) {
			$('<a>').attr('href', '#').text(i).appendTo(li.addClass('active'));
		}else{
			$('<a>').attr({'href':'#', 'onclick':'setPage(' + i + ')'}).text(i).appendTo(li);
		}
	}
	
	if (currentPage < totalPageCnt){
		nextBtn = "<li><a href='#' aria-label='Next' onclick='setPage("+(currentPage + 1) +")'><span aria-hidden='true'>&rsaquo;</span></a>";
		ul.append(nextBtn);
	}
}

//페이지 처리
function setPage(currentPage, startCnt, endCnt) {
	$('#pageNav').empty();
	
 	try {
 		getList(currentPage);
 	} catch (e){
 		//
 	}
}

function getList(currentPage) {
	$("#page").val(currentPage - 1);
	$("#target").submit();
}
</script>
<body>
	
<c:forEach var="user" items="${user.content}">
	<span>${user.userId}</span>&nbsp;&nbsp;
	<span>${user.userNm}</span>&nbsp;&nbsp;
	<span>${user.userTel}</span>
	<div></div>
</c:forEach>
	<span id="pageNav"></span>
	
<form id="target" action="/getListUser" method="post">
	<input type="hidden" name="page" id="page">
</form>

</body>
</html>