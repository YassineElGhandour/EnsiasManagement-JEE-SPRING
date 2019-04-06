<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header id="main-header">
		<div class="inner-container container">
			<div class="left-sec col-sm-4 col-md-2 clearfix">
				<!-- Top Logo -->
				<div id="top-logo">
					<div class="title"><span>ENSIAS</span> SCHEDULE</div>
				</div>
			</div>
			<div class="right-sec col-sm-8 col-md-10 clearfix">


				<!-- Main Menu -->
				<nav id="main-menu">
					<ul class="list-inline">
						<li class="active"><a href="/">Accueil</a> 
						</li>
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
					       	 <li>
					        	<a href="#"><c:out value="${pageContext.request.remoteUser}"></c:out></a>
									<ul>
										<li><a href="insertemploi">Insérer dans l'emploi du temps</a></li>
										<li><a href="afficherempl">Consulter l'emploi du temps</a></li>
										<li><a href="addgroup">Ajouter un Groupe</a></li>
										<li><a href="deletegroup">Supprimer un Groupe</a></li>
										<li><a href="addfiliere">Ajouter une Fillière</a></li>
										<li><a href="deletefiliere">Supprimer une Fillière</a></li>
										<li><a href="addsalle">Ajouter une Salle</a></li>
										<li><a href="deletesalle">Supprimer une Salle</a></li>
										<li><a href="addmatiere">Ajouter une matière</a></li>
										<li><a href="deletematiere">Supprimer une matiere</a></li>
										<li><a href="logout">Se déconnectez</a></li>
									</ul>
								</li>
					    </sec:authorize>
					    <sec:authorize ifAnyGranted="ROLE_PROF">
					       	 <li>
					        	<a href="#"><c:out value="${pageContext.request.remoteUser}"></c:out></a>
									<ul>
										<li><a href="afficherempl">Consulter l'emploi du temps</a></li>
										<li><a href="userListTwo">Télécharger l'emploi du temps</a></li>
										<li><a href="afficherpargrp">Consulter par groupe</a></li>
										<li><a href="afficherparmat">Consulter par matière</a></li>
										<li><a href="afficherparsalle">Consulter par salle</a></li>
										<li><a href="afficherparprof">Consulter par professeur</a></li>
										<li><a href="logout">Se déconnectez</a></li>										
									</ul>
								</li>
					    </sec:authorize>
					    <sec:authorize ifNotGranted="ROLE_PROF">
					       		<li><a href="/login">Connectez-vous en tant que Professeur</a></li>
					    </sec:authorize>
					    <sec:authorize ifNotGranted="ROLE_ADMIN">
					       		<li><a href="/login">Connectez-vous en tant qu'administrateur</a></li>
					    </sec:authorize>
						
						<sec:authorize ifNotGranted="ROLE_PROF">
					       	 
								<li><a href="/signup">Créez compte</a></li>
									
					    </sec:authorize>

						<li><a href="#">Contact</a>
						</li>
					</ul>
				</nav>
				<!-- Menu Handel -->
				<div id="main-menu-handle" class="hidden-md hidden-lg"><i class="fa fa-bars"></i></div>
			</div>
		</div>
		<div id="mobile-menu-container" class="hidden-md hidden-lg"></div>
	</header>