<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<!-- <base href="/"> -->
	<title>Cream Sale</title>
	<meta name="description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Template Basic Images Start -->
	<meta property="og:image" content="">
	<link rel="icon" href="#">
	<link rel="apple-touch-icon" sizes="180x180" href="#">
	<!-- Template Basic Images End -->
	<!-- Custom Browsers Color Start -->
	<meta name="theme-color" content="#000">
	<!-- Custom Browsers Color End -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap&subset=cyrillic" rel="stylesheet">
	<link rel="stylesheet" href="<@spring.url '/css/main.min.css'/>">
</head>
<body>
<header class="header" id="header">
	<div class="container">
		<div class="row">
			<div class="log-12 nav-space">
				<nav class="nav">
					<ul class="nav__list">
						<li class="nav__item">
							<a href="#" class="nav__link">
								контакты
							</a>
						</li>
						<li class="nav__item">
							<a href="#" class="nav__link">
								адрес
							</a>
						</li>
						<li class="nav__item">
							<a href="#" class="nav__link">
								о нас
							</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</header>
<section class="main" id="main">
	<img src="<@spring.url '/img/dest/кабинет.png'/>" class="user" id="user">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<a href="/" class="main__logo">
					<img src="<@spring.url '/img/dest/cream-sale-logo.png'/>" alt="" class="main__logo-img">
				</a>
				<div class="search">
					<h1 class="search__title">
						идеальная покупка в 3 клика
					</h1>
					<form class="search__space" name="search" action="" method="POST">
						<@spring.formInput "searchForm.search" "class=search__input" "text "/>

						<div class="search__img">
							<input type="image" src="<@spring.url '/img/dest/search.png'/>" alt="Submit Form" style="border:none;"/>
						</div>
					</form>
				</div>
				<div class="icons">
					<img src="<@spring.url '/img/dest/growth.png'/>" alt="" class="icons__img">
					<img src="<@spring.url '/img/dest/gift.png'/>" alt="" class="icons__img">
					<img src="<@spring.url '/img/dest/agreement.png'/>" alt="" class="icons__img">
					<img src="<@spring.url '/img/dest/корзина.png'/>" alt="" class="icons__img">
				</div>
			</div>
		</div>
	</div>
	<img src="<@spring.url '/img/dest/CI logo.png'/>" alt="" class="main__company main__company_left">
	<img src="<@spring.url '/img/dest/unicap.png'/>" alt="" class="main__company main__company_right">
</section>
<#if searchResults??>
	<section class="goods" id="goods">
		<div class="goods__left">
			<div class="goods__open">
				<div class="goods__dot"></div>
				<div class="goods__dot"></div>
				<div class="goods__dot"></div>
			</div>
		</div>
		<div class="container">
			<#list searchResults as searchResult>
				<div class="row">
					<div class="col-lg-4">
						<div class="item">
							<img src="<@spring.url '/img/dest/корзина.png'/>" alt="" class="item__cart">
							<img src="<@spring.url '/img/dest/like.png'/>" alt="" class="item__like">

							<#if searchResult.productName == 'iphone 7'>
								<img src="<@spring.url '/image/product/iphone7.jpg'/>" alt="" class="item__img">
							<#elseif searchResult.productName == 'iphone 11'>
								<img src="<@spring.url '/image/product/iphone11.png'/>" alt="" class="item__img" style="width: 75%">
							<#elseif searchResult.productName == 'samsung s10'>
								<img src="<@spring.url '/image/product/samsung10.jpg'/>" alt="" class="item__img">
							</#if>

							<button class="item__btn">
								${searchResult.price} BYN
							</button>
							<div class="item__more">
								<div class="item__dot"></div>
								<div class="item__dot"></div>
								<div class="item__dot"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="item">
							<img src="" alt="" class="item__cart">
							<img src="" alt="" class="item__like">
							<#if searchResult.cashBackName == 'letyshops'>
								<img src="<@spring.url '/image/cashback/letyshops.jpg'/>" alt="" class="item__cash__img">
							<#elseif searchResult.cashBackName == 'backit'>
								<img src="<@spring.url '/image/cashback/backit.png'/>" alt="" class="item__cash__img">
							</#if>
							<p class="result__text">
								${searchResult.cashBackSale}%
							</p>
							<button class="item__btn">
								${searchResult.priceWithSale} BYN
							</button>
							<div class="item__more">
								<div class="item__dot"></div>
								<div class="item__dot"></div>
								<div class="item__dot"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="item">
							<img src="" alt="" class="item__cart">
							<img src="" alt="" class="item__like">
							<div class="item__more">
								<div class="item__dot"></div>
								<div class="item__dot"></div>
								<div class="item__dot"></div>
							</div>
						</div>
					</div>
				</div>
			</#list>
		</div>
	</section>
</#if>
<section class="order" id="order">
	<h2 class="order__title">
		оформление заказа
	</h2>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="form">
					<div class="form__top">
						<div class="form__left">
							<h3 class="form__title">
								Адрес доставки
							</h3>
							<input type="text" placeholder="ФИО" class="form__input" name="name">
							<input type="text" placeholder="электронная почта" class="form__input" name="email">
							<input type="text" placeholder="улица, дом, квартира" class="form__input" name="adress">
							<input type="text" placeholder="контактный номер" class="form__input" name="phone">
						</div>
						<div class="form__right">
							<h3 class="form__title">
								Способ оплаты
							</h3>
							<div class="form__choose">
								Visa
							</div>
							<div class="form__choose">
								MasterCard
							</div>
							<div class="form__choose">
								Яндекс Деньги
							</div>
							<div class="form__choose">
								ApplePay
							</div>
						</div>
					</div>
					<button class="form__btn">
						заказать
					</button>
				</div>
			</div>
		</div>
	</div>
</section>
<script src="<@spring.url '/js/scripts.min.js' />"></script>
</body>
</html>
