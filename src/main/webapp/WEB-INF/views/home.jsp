<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ENSIAS SCHEDULE</title><!-- Website's title ( it will be shown in browser's tab ), Change the website's title based on your Hotel information -->
	<meta name="description" content="Pinar is Hotel and Resort HTML template."><!-- Add your Hotel short description -->
	<meta name="keywords" content="Responsive,HTML5,CSS3,XML,JavaScript"><!-- Add some Keywords based on your Hotel and your business and separate them by comma -->
	<meta name="author" content="Joseph a, ravistheme@gmail.com">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=no">
	<link href='https://fonts.googleapis.com/css?family=Lobster%7cRaleway:400,300,100,600,700,800' rel='stylesheet' type='text/css'><!-- Attach Google fonts -->
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css"><!-- Attach the main stylesheet file -->
</head>
<body class="homepage trans-header sticky white-datepicker">
	
	

	<!-- Main Header -->
	<c:import url="header.jsp"></c:import>
	<!-- End of Main Header -->

	<!-- Top Slider and Booking form -->
	<div id="home-top-section">
		
		<!-- Main Slider -->
		<div id="main-slider">
			<div class="items">
	            <a href="http://google.com">
	            	<img src="assets/img/slider/ensias1.jpg" alt="3"/><!-- Change the URL section based on your image\'s name -->
	            </a>
	        </div>
	        <div class="items">
	            <a href="http://google.com">
	            	<img src="assets/img/slider/ensias3.jpg" alt="3"/>
	            </a>
	        </div>
	        <div class="items">
	            <a href="http://google.com">
	            	<img src="assets/img/slider/ensias4.jpg" alt="4"/>
	            </a>
	        </div>
	        <div class="items">
	            <a href="http://google.com">
	            	<img src="assets/img/slider/ensias2.jpg" alt="2"/>
	            </a>
	        </div>
	    </div>
	    
	    <sec:authorize ifAnyGranted="ROLE_PROF">
		<!-- Booking Form -->
		<div class="booking-form-container container">
			<div class="booking-form-inner-container">
				<div id="main-booking-form" class="style-2">
					<h2><small>Ajouter les disponiblités</small></h2>
					<form class="booking-form clearfix" action="/home" method="post">
						<div class="booking-fields col-xs-6 col-md-12">			            
			            <div class="booking-fields col-xs-6 col-md-12">
			                <select name="heureDispo">
			                    <option value="8h-10h">8h-10h</option>
			                    <option value="10h-12h">10h-12h</option>
			                    <option value="14h-16h">14h-16h</option>
			                    <option value="16h-18h">16h-18h</option>
			                </select>
			            </div>
			            <div class="booking-fields col-xs-6 col-md-12">
				              	<select name="jourDispo">
			                    	<option value="Lundi">Lundi</option>
			                    	<option value="Mardi">Mardi</option>
			                    	<option value="Mercredi">Mercredi</option>
			                    	<option value="Jeudi">Jeudi</option>
			                    	<option value="Vendredi">Vendredi</option>
			                	</select> 
				            </div>
						</div>
						<div class="input-daterange clearfix">
				            <div class="booking-fields col-xs-6 col-md-12">
				                <input type="date" name="dateDispo">
				                <i class="fa fa-calendar"></i>
				            </div>
				            <div class="booking-fields col-xs-6 col-md-12">
				              	<select name="semaineDispo">
			                    	<option value="Semaine 1">Semaine 1</option>
			                    	<option value="Semaine 2">Semaine 2</option>
			                    	<option value="Semaine 3">Semaine 3</option>
			                    	<option value="Semaine 4">Semaine 4</option>
			                    	<option value="Semaine 5">Semaine 5</option>
			                    	<option value="Semaine 6">Semaine 6</option>
			                    	<option value="Semaine 7">Semaine 7</option>
			                    	<option value="Semaine 8">Semaine 8</option>
			                    	<option value="Semaine 9">Semaine 9</option>
			                    	<option value="Semaine 10">Semaine 10</option>
			                    	<option value="Semaine 11">Semaine 11</option>
			                    	<option value="Semaine 12">Semaine 12</option>
			                    	<option value="Semaine 13">Semaine 13</option>
			                    	<option value="Semaine 14">Semaine 14</option>
			                    	<option value="Semaine 15">Semaine 15</option>
			                    	<option value="Semaine 16">Semaine 16</option>
			                	</select> 
				            </div>

				        </div>
				        
				       

			            <div class="booking-button-container">
			                <input class="btn btn-default" value="Ajouter les disponibilités" type="submit"/><!-- Submit button -->
			            </div>
			        </form>
				</div>
			</div>
		</div>
	</div>
	</sec:authorize>
				</div>
			</div>
		</div>
	    
	<!-- Top Footer -->
	<c:import url="footer.jsp"></c:import>
	<!-- End of Top Footer -->



	<!-- Include the js files  -->
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="assets/js/isotope.pkgd.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="assets/js/imagesloaded.pkgd.min.js"></script>
	<script type="text/javascript" src="assets/js/helper.js"></script>
	<script type="text/javascript" src="assets/js/template.js"></script>
	<script type="text/javascript">
	jQuery(document).ready(function($) {
		"use strict";
		// Init the Wow plugin
    	new WOW({mobile: false}).init();
	});
	</script>

	<!-- End of js files and codes -->
</body>
</html>
