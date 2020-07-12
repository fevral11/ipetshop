<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.add.goods"
	var="add_godds_buttom" />
<fmt:message bundle="${loc}" key="local.locbutton.name.cats"
	var="cats_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.dogs"
	var="dogs_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.birds"
	var="birds_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.fish"
	var="fish_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.rodents"
	var="rodents_button" />
<fmt:message bundle="${loc}" key="local.locfield.title"
	var="field_title" />
<fmt:message bundle="${loc}" key="local.locfield.price"
	var="field_price" />
<fmt:message bundle="${loc}" key="local.locfield.total"
	var="field_total" />

<link rel="stylesheet" href="style.css">

</head>
<body>
	<c:set var="user" value="${userData}"/>	
<div class="main">
	<div class="header">
		<div class="btn-cat">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="go_to_main_page" /> 
					<button class="btn-cat">
						<img class="img-cat" src="image/home.png">
					</button>
				</form>
		</div>
		
		<div class="btn-cat">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="place_order" /> 
					<button class="btn-cat">
						<img class="img-cat" src="image/basket.png">
					</button>
			</form>
		</div>
	</div>
	
	<div class="content-menu">
		<div class="btn-menu">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="search_goods" /> 
				<input type="hidden" name="groupSearchName" value="Goods"> 
				<input type="hidden" name="searchCriteria" value="type_animal=Cats" /> 
				<input type="submit" value="${cats_button}" />
			</form>
		</div>
		<div class="btn-menu">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="search_goods" /> 
				<input type="hidden" name="groupSearchName" value="Goods"> 
				<input type="hidden" name="searchCriteria" value="type_animal=Dogs" /> 
				<input type="submit" value="${dogs_button}" />
			</form>
		</div>
		<div class="btn-menu">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="search_goods" /> 
				<input type="hidden" name="groupSearchName" value="Goods"> 
				<input type="hidden" name="searchCriteria" value="type_animal=Birds" /> 
				<input type="submit" value="${birds_button}" />
			</form>
		</div>
		<div class="btn-menu">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="search_goods" /> 
				<input type="hidden" name="groupSearchName" value="Goods"> 
				<input type="hidden" name="searchCriteria" value="type_animal=Fish" /> 
				<input type="submit" value="${fish_button}" />
			</form>
		</div>
		<div class="btn-menu">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="search_goods" /> 
				<input type="hidden" name="groupSearchName" value="Goods"> 
				<input type="hidden" name="searchCriteria" value="type_animal=Rodents" /> 
				<input type="submit" value="${rodents_button}" />
			</form>
		</div>
		<div class="user-field">
			<c:if test="${user ne null}">
				<c:out value="${user.userName}" />
			</c:if>
		</div>
	</div>

	<div class="content">
		<div class="table-basket">
			<table>
			<c:set var="total" value="${0 }"/>
            	<tr>
                	<th><c:out value="${field_title}"/></th> <th><c:out value="${field_price}"/></th>
            	</tr>
            		<c:forEach items="${userBasket}" var="goods">
            	<tr>
                	<td><c:out value="${goods.title}" /></td> <td><c:out value="${goods.price}" /></td>
                	 <c:set var="total" value="${total + goods.price}" />
            	</tr>
         			</c:forEach>
         		<tr>
         			<th><c:out value="${field_total}"/></th> <th><c:out value="${total}"/></th>
            	</tr>
         	</table>
		</div>
	</div>
</div>

	<script type="text/javascript" src="script.js"></script>

</body>
</html>