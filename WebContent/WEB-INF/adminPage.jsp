<%@page import="utils.Utils"%>
<%@page import="java.util.List"%>
<%@page import="model.Categoria"%>
<%@page import="model.Utente"%>
<%@page import="model.Veicolo"%>
<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Andrea Fonte">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Admin Page</title>

<link href="${pageContext.request.contextPath}/css/theme.css">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<link href="${pageContext.request.contextPath}/css/font-face.css.css">

<!-- Fontfaces CSS-->
<link href="${pageContext.request.contextPath}/css/font-face.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">

<!-- Vendor CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/vendor/wow/animate.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/vendor/slick/slick.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="${pageContext.request.contextPath}/css/theme.css"
	rel="stylesheet" media="all">

</head>

<body class="animsition">
	<%
		HttpSession sessione = request.getSession();
		List<Utente> utenti = (List<Utente>) sessione.getAttribute("dbUtenti");
		List<Veicolo> veicoli = (List<Veicolo>) sessione.getAttribute("dbVeicoli");
		List<Categoria> categorie = (List<Categoria>) sessione.getAttribute("dbCategoria");
	%>
	<div class="page-wrapper">
		<!-- HEADER MOBILE-->
		<header class="header-mobile d-block d-lg-none">
			<div class="header-mobile__bar">
				<div class="container-fluid">
					<div class="header-mobile-inner">
						<a class="logo" href="index.html"> <img
							src="images/icon/logo.png" alt="CoolAdmin" />
						</a>
						<button class="hamburger hamburger--slider" type="button">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<nav class="navbar-mobile">
				<div class="container-fluid">
					<ul class="navbar-mobile__list list-unstyled">
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>Dashboard
						</a>
							<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
								<li><a href="index.html">Dashboard 1</a></li>
								<li><a href="index2.html">Dashboard 2</a></li>
								<li><a href="index3.html">Dashboard 3</a></li>
								<li><a href="index4.html">Dashboard 4</a></li>
							</ul></li>
						<li><a href="chart.html"> <i class="fas fa-chart-bar"></i>Charts
						</a></li>
						<li><a href="table.html"> <i class="fas fa-table"></i>Tables
						</a></li>
						<li><a href="form.html"> <i class="far fa-check-square"></i>Forms
						</a></li>
						<li><a href="calendar.html"> <i
								class="fas fa-calendar-alt"></i>Calendar
						</a></li>
						<li><a href="map.html"> <i class="fas fa-map-marker-alt"></i>Maps
						</a></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-copy"></i>Pages
						</a>
							<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
								<li><a href="login.html">Login</a></li>
								<li><a href="register.html">Register</a></li>
								<li><a href="forget-pass.html">Forget Password</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-desktop"></i>UI Elements
						</a>
							<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
								<li><a href="button.html">Button</a></li>
								<li><a href="badge.html">Badges</a></li>
								<li><a href="tab.html">Tabs</a></li>
								<li><a href="card.html">Cards</a></li>
								<li><a href="alert.html">Alerts</a></li>
								<li><a href="progress-bar.html">Progress Bars</a></li>
								<li><a href="modal.html">Modals</a></li>
								<li><a href="switch.html">Switchs</a></li>
								<li><a href="grid.html">Grids</a></li>
								<li><a href="fontawesome.html">Fontawesome Icon</a></li>
								<li><a href="typo.html">Typography</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- END HEADER MOBILE-->

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="#"> <img src="images/icon/logo.png" alt="Autonoleggio" />
				</a>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<form class="form-header" action="" method="POST">
								<input class="au-input au-input--xl" type="text" name="search"
									placeholder="Search for datas &amp; reports..." />
								<button class="au-btn--submit" type="submit">
									<i class="zmdi zmdi-search"></i>
								</button>
							</form>
							<div class="header-button">
								<div class="noti-wrap">
									<div class="noti__item js-item-menu">
										<i class="zmdi zmdi-comment-more"></i> <span class="quantity">1</span>
										<div class="mess-dropdown js-dropdown">
											<div class="mess__title">
												<p>You have 2 news message</p>
											</div>
											<div class="mess__item">
												<div class="image img-cir img-40">
													<img src="images/icon/avatar-06.jpg" alt="Michelle Moreno" />
												</div>
												<div class="content">
													<h6>Michelle Moreno</h6>
													<p>Have sent a photo</p>
													<span class="time">3 min ago</span>
												</div>
											</div>
											<div class="mess__item">
												<div class="image img-cir img-40">
													<img src="images/icon/avatar-04.jpg" alt="Diane Myers" />
												</div>
												<div class="content">
													<h6>Diane Myers</h6>
													<p>You are now connected on message</p>
													<span class="time">Yesterday</span>
												</div>
											</div>
											<div class="mess__footer">
												<a href="#">View all messages</a>
											</div>
										</div>
									</div>
									<div class="noti__item js-item-menu">
										<i class="zmdi zmdi-email"></i> <span class="quantity">1</span>
										<div class="email-dropdown js-dropdown">
											<div class="email__title">
												<p>You have 3 New Emails</p>
											</div>
											<div class="email__item">
												<div class="image img-cir img-40">
													<img src="images/icon/avatar-06.jpg" alt="Cynthia Harvey" />
												</div>
												<div class="content">
													<p>Meeting about new dashboard...</p>
													<span>Cynthia Harvey, 3 min ago</span>
												</div>
											</div>
											<div class="email__item">
												<div class="image img-cir img-40">
													<img src="images/icon/avatar-05.jpg" alt="Cynthia Harvey" />
												</div>
												<div class="content">
													<p>Meeting about new dashboard...</p>
													<span>Cynthia Harvey, Yesterday</span>
												</div>
											</div>
											<div class="email__item">
												<div class="image img-cir img-40">
													<img src="images/icon/avatar-04.jpg" alt="Cynthia Harvey" />
												</div>
												<div class="content">
													<p>Meeting about new dashboard...</p>
													<span>Cynthia Harvey, April 12,,2018</span>
												</div>
											</div>
											<div class="email__footer">
												<a href="#">See all emails</a>
											</div>
										</div>
									</div>
									<div class="noti__item js-item-menu">
										<i class="zmdi zmdi-notifications"></i> <span class="quantity">3</span>
										<div class="notifi-dropdown js-dropdown">
											<div class="notifi__title">
												<p>You have 3 Notifications</p>
											</div>
											<div class="notifi__item">
												<div class="bg-c1 img-cir img-40">
													<i class="zmdi zmdi-email-open"></i>
												</div>
												<div class="content">
													<p>You got a email notification</p>
													<span class="date">April 12, 2018 06:50</span>
												</div>
											</div>
											<div class="notifi__item">
												<div class="bg-c2 img-cir img-40">
													<i class="zmdi zmdi-account-box"></i>
												</div>
												<div class="content">
													<p>Your account has been blocked</p>
													<span class="date">April 12, 2018 06:50</span>
												</div>
											</div>
											<div class="notifi__item">
												<div class="bg-c3 img-cir img-40">
													<i class="zmdi zmdi-file-text"></i>
												</div>
												<div class="content">
													<p>You got a new file</p>
													<span class="date">April 12, 2018 06:50</span>
												</div>
											</div>
											<div class="notifi__footer">
												<a href="#">All notifications</a>
											</div>
										</div>
									</div>
								</div>
								<div class="account-wrap">
									<div class="account-item clearfix js-item-menu">
										<div class="image">
											<img src="images/icon/avatar-01.jpg" alt="Andrea Fonte" />
										</div>
										<div class="content">
											<a class="js-acc-btn" href="#">Andrea Fonte</a>
										</div>
										<div class="account-dropdown js-dropdown">
											<div class="info clearfix">
												<div class="image">
													<a href="#"> <img src="images/icon/avatar-01.jpg"
														alt="John Doe" />
													</a>
												</div>
												<div class="content">
													<h5 class="name">
														<a href="#">Andrea Fonte</a>
													</h5>
													<span class="email">johndoe@example.com</span>
												</div>
											</div>
											<div class="account-dropdown__body">
												<div class="account-dropdown__item">
													<a href="#"> <i class="zmdi zmdi-account"></i>Account
													</a>
												</div>
												<div class="account-dropdown__item">
													<a href="#"> <i class="zmdi zmdi-settings"></i>Setting
													</a>
												</div>
												<div class="account-dropdown__item">
													<a href="#"> <i class="zmdi zmdi-money-box"></i>Billing
													</a>
												</div>
											</div>
											<div class="account-dropdown__footer">
												<a id="logout"> <i class="zmdi zmdi-power"></i>Logout
												</a>
												<form action="Logout" method="post">
													<button id="logoutbutton" type="submit"
														style="display: none"></button>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- HEADER DESKTOP-->

			<!-- MAIN CONTENT-->
			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="overview-wrap">
									<h2 class="title-1">overview</h2>

									<form action="AddCategoria_View" method="post">
										<button type="submit" class="au-btn au-btn-icon au-btn--blue">
											<i class="zmdi zmdi-plus"></i>Aggiungi categoria
										</button>
									</form>

								</div>
							</div>
						</div>
						<div class="row m-t-25">
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c1">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-account-o"></i>
											</div>
											<div class="text">
												<h2><%=utenti.size()%></h2>
												<span>Utenti Registrati </span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart1"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c2">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-shopping-cart"></i>
											</div>
											<div class="text">
												<h2><%=veicoli.size()%></h2>
												<span>veicoli</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart2"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c3">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-calendar-note"></i>
											</div>
											<div class="text">
												<h2>1,086</h2>
												<span>prenotazioni questo mese</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart3"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c4">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-money"></i>
											</div>
											<div class="text">
												<h2>$1,060,386</h2>
												<span>total earnings</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart4"></canvas>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-9">
								<h2 class="title-1 m-b-25">Utenti</h2>
								<div class="table-responsive table--no-card m-b-40">
									<table
										class="table table-borderless table-striped table-earning">
										<thead>
											<tr>
												<th>id Utente</th>
												<th>Nome</th>
												<th>Cognome</th>
												<th>Email</th>
												<th>Data di Nascita</th>
												<th>Prenotazioni</th>
											</tr>
										</thead>
										<form action="VisualizzaNoleggiCliente" method="post">
											<tbody>
												<%
													for (Utente u : utenti) {
												%>
												<tr class="utente_riga">

													<td><%=u.getIdUser()%></td>
													<td><%=u.getNameUser()%></td>
													<td><%=u.getSurnameUser()%></td>
													<td><%=u.getEmailUser()%></td>
													<td><%=Utils.dateFormatter(u.getBirthdateUser())%></td>
													<td>
														<button type="submit" name="user_email"
															value="<%=u.getEmailUser()%>">Visualizza</button>
													</td>
												</tr>
												<%
													}
												%>

											</tbody>
										</form>
									</table>
								</div>
							</div>
							<div class="col-lg-3">
								<h2 class="title-1 m-b-25">Categorie</h2>
								<div
									class="au-card au-card--bg-blue au-card-top-countries m-b-40">
									<div class="au-card-inner">
										<div class="table-responsive">
											<table class="table table-top-countries">
												<form action="Categoria" method="post">
													<tbody>
														<%
															for (Categoria c : categorie) {
														%>

														<tr>
															<button
																id="button_nome_categoria<%=c.getNomeCategoria()%>"
																type="submit" style="display: none" name="categoria"
																value="<%=c.getNomeCategoria()%>"></button>

															<td class="nome_categoria"><%=c.getNomeCategoria()%></td>
														</tr>
														<%
															}
														%>

													</tbody>
												</form>
											</table>

										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="copyright">
									<p>Copyright � 2020 Andrea Fonte. All rights reserved.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT-->
			<!-- END PAGE CONTAINER-->
		</div>

	</div>

	<!-- Jquery JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script
		src="${pageContext.request.contextPath}/vendor/slick/slick.min.js">
		
	</script>
	<script src="${pageContext.request.contextPath}/vendor/wow/wow.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/animsition/animsition.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath}/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/counter-up/jquery.counterup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/circle-progress/circle-progress.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/chartjs/Chart.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>

	<script type="text/javascript">
	$(document).ready(() => {
		$(".nome_categoria").on("click", function (e) {
			let data = $.param($(this).map(function() {
        	    return {
        	        value: $(this).text().trim()
        	    };
        	}));
			let asd = "button_nome_categoria" + $(this).text();
			$("#"+asd).trigger("click")
	    })
	    
	    $("#logout").on("click", function (e) {
	    	console.log("clicked")
			$("#logoutbutton").trigger("click")
	    })   	    
	})
	
	
	
	function post(params){
    	$.ajax({
        	url: "Categoria",
        	type: "POST",
        	data: params,
        	success : function(response){
        		console.log("success" + response);
        		window.location.href = response;
        	},
        	error: function(){
        		console.log("fail");
        	}
 
    	})
	}	
	
</script>

	<!-- Main JS-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>
<!-- end document-->