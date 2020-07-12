<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.registration"
	var="registration_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.authorization"
	var="authorization_button" />
<fmt:message bundle="${loc}" key="local.locfield.name.name"
	var="name_field" />
<fmt:message bundle="${loc}" key="local.locfield.name.surname"
	var="surname_field" />
<fmt:message bundle="${loc}" key="local.locfield.name.login"
	var="login_field" />
<fmt:message bundle="${loc}" key="local.locfield.name.password"
	var="password_field" />
<fmt:message bundle="${loc}" key="local.locfield.name.telephone"
	var="telephone_field" />
<fmt:message bundle="${loc}" key="local.locfield.name.email"
	var="email_field" />
<fmt:message bundle="${loc}" key="local.signIn.notFound"
	var="user_notfound" />
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
<fmt:message bundle="${loc}" key="local.registration.uncorrect"
	var="registration_uncorrect" />

<link rel="stylesheet" href="style.css">

</head>

<body>
	<c:set var="user" value="${userData}" />
	
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
			<div class="login-btn__open">${authorization_button}</div>
			<div class="signUp-btn__open">${registration_button}</div>
			<div>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="localization" /> <input
						type="hidden" name="local" value="ru" />
					<button class="btn-local">
						<img class="img-btn" src="image/russia.png">
					</button>
				</form>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="localization" /> <input
						type="hidden" name="local" value="en" />
					<button class="btn-local">
						<img class="img-btn" src="image/english.png">
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
			<div class="modal">
				<div class="modal-login">
					<div class="modal-login__close" title="close">&times;</div>
					<div class=login-image-wrapper>
						<img class="modal-login__img" src="image/avatar.png" alt="avatar">
					</div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="authorization" /> <input
							type="text" name="login" placeholder="${login_field}" /> <input
							type="password" name="password" placeholder="${password_field}" />
						<input type="submit" value="${authorization_button}" />
					</form>
				</div>
			</div>
			<div class="modal-signUp">
				<div class="modal-signUp__close" title="close">&times;</div>
				<div class=login-image-wrapper>
					<img class="modal-login__img" src="image/avatar.png" alt="avatar">
				</div>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="registration" /> 
					<input type="text" name="login" value="" placeholder="${login_field}" required/>
					<input type="password" name="password" value="" placeholder="${password_field}" required/> 
					<input type="text" name="name" value="" placeholder="${name_field}" required/> 
					<input type="text" name="surname" value="" placeholder="${surname_field}" required/> 
					<input type="email" name="email" value="" placeholder="${email_field}" required/>
					<input type="tel" name="telephone" value="" placeholder="${telephone_field}" required/> 
					<input type="submit" value="${registration_button}" />
				</form>
			</div>
			<div class="btn-cat">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="exit" />
					<button class="btn-cat">
						<img class="img-cat" src="image/exitCat.png">
					</button>
				</form>
			</div>
		</div>



		<div class="content-menu">
			<div class="btn-menu">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="search_goods" /> <input
						type="hidden" name="groupSearchName" value="Goods"> <input
						type="hidden" name="searchCriteria" value="type_animal=Cats" /> <input
						type="submit" value="${cats_button}" />
				</form>
			</div>
			<div class="btn-menu">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="search_goods" /> <input
						type="hidden" name="groupSearchName" value="Goods"> <input
						type="hidden" name="searchCriteria" value="type_animal=Dogs" /> <input
						type="submit" value="${dogs_button}" />
				</form>
			</div>
			<div class="btn-menu">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="search_goods" /> <input
						type="hidden" name="groupSearchName" value="Goods"> <input
						type="hidden" name="searchCriteria" value="type_animal=Birds" />
					<input type="submit" value="${birds_button}" />
				</form>
			</div>
			<div class="btn-menu">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="search_goods" /> <input
						type="hidden" name="groupSearchName" value="Goods"> <input
						type="hidden" name="searchCriteria" value="type_animal=Fish" /> <input
						type="submit" value="${fish_button}" />
				</form>
			</div>
			<div class="btn-menu">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="search_goods" /> <input
						type="hidden" name="groupSearchName" value="Goods"> <input
						type="hidden" name="searchCriteria" value="type_animal=Rodents" />
					<input type="submit" value="${rodents_button}" />
				</form>
			</div>
			<div class="user-field">

				<c:choose>
					<c:when test="${user.userId ne null}">
						<c:out value="${user.userName}" />
					</c:when>
					<c:when test="${user.userName == 'uncorrect'}">
						<c:out value="${user_notfound}" />
					</c:when>
				</c:choose>
		
				
			</div>
		</div>

		<div class="content">
			<div>
				<c:forEach items="${listGoods}" var="goods">
					<div class="product">
						<div class="product-title">
							<c:out value="${goods.title}" />
						</div>
						<div class="product-picture">
							<img alt="pic" src="${goods.picture}">
						</div>
						<div class="product-price">
							<c:out value="${goods.price}" />
						</div>
						<div class="buttom-add-goods">
							<form action="Controller" method="post">
								<input type="hidden" name="command" value="add_goods_to_order" />
								<input type="hidden" name="goodsId" value="${goods.goodsId}" />
								<input type="hidden" name="quantityGoods" value="1" /> <input
									type="submit" value="${add_godds_buttom}" />
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="script.js"></script>
</body>
</html>