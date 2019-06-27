<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar-wrapper">
	<div class="navbar-logo">
		<a class="mobile-menu" id="mobile-collapse" href="#!"> <i
			class="feather icon-menu"></i>
		</a> <a href='#'> <img class="img-fluid" src='assets/images/logo.png'
			alt="Theme-Logo">
		</a> <a class="mobile-options"> <i
			class="feather icon-more-horizontal"></i>
		</a>
	</div>

	<div class="navbar-container container-fluid">
		<ul class="nav-left">
			<li class="header-search">
				<div class="main-search morphsearch-search">
					<div class="input-group">
						<span class="input-group-addon search-close"><i
							class="feather icon-x"></i></span> <input type="text"
							class="form-control"> <span
							class="input-group-addon search-btn"><i
							class="feather icon-search"></i></span>
					</div>
				</div>
			</li>
		</ul>
		<ul class="nav-right">
			<li class="header-notification">
				<div class="dropdown-primary dropdown">
					<div class="dropdown-toggle" data-toggle="dropdown">
						<i class="feather icon-bell"></i> <span class="badge bg-c-pink">5</span>
					</div>
				</div>
			</li>
			<li class="header-notification">
				<div class="dropdown-primary dropdown">
					<div class="displayChatbox dropdown-toggle" data-toggle="dropdown">
						<i class="feather icon-message-square"></i> <span
							class="badge bg-c-green">3</span>
					</div>
				</div>
			</li>
			<li class="user-profile header-notification">
				<div class="dropdown-primary dropdown">
					<div class="dropdown-toggle" data-toggle="dropdown">
						<img src="assets/images/avatar-4.jpg" class="img-radius"
							alt="User-Profile-Image"> <span>John Doe</span> <i
							class="feather icon-chevron-down"></i>
					</div>
					<ul class="show-notification profile-notification dropdown-menu"
						data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
						<li><a href="#!"> <i class="feather icon-settings"></i>
								Settings
						</a></li>
						<li><a href="user-profile.htm"> <i
								class="feather icon-user"></i> Profile
						</a></li>
						<li><a href='<c:url value="/admin/logout" />'> <i
								class="feather icon-log-out"></i> Logout
						</a></li>
					</ul>

				</div>
			</li>
		</ul>
	</div>
</div>