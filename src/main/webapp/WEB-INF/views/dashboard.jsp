<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="sidebar" data-color="blue" data-image="gerant/img/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="logo">
                <a href="#" class="simple-text">
                    Administration
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                  
                	<sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <li class="active">
                        <a href="/createadmin">
                            <i class="material-icons">person_add</i>
                            <p>Nouveau Admin</p>
                        </a>
                    </li>
                    <li class="active">
                        <a href="/disponibilite">
                            <i class="material-icons">check</i>
                            <p>Voir les disponibilités</p>
                        </a>
                    </li>
                    </sec:authorize>
                     <li class="active">
                        <a href="/afficherempl">
                            <i class="material-icons">view_module</i>
                            <p>Consulter l'Emploi</p>
                        </a>
                    </li>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <li class="active">
                        <a href="/insertemploi">
                            <i class="material-icons">library_add</i>
                            <p>Insérer dans l'emploi</p>
                        </a>
                    </li>
                    </sec:authorize>
                    <li class="active">
                        <a href="/reporttwo">
                            <i class="material-icons">file_download</i>
                            <p>Télécharger l'emploi</p>
                        </a>
                    </li>

                    <li class="active">
                        <a href="/afficherpargrp">
                            <i class="material-icons">view_compact</i>
                            <p>Emploi par groupe</p>
                        </a>
                    </li>
 
                     <li class="active">
                        <a href="/afficherparmat">
                            <i class="material-icons">view_compact</i>
                            <p>Emploi par matière</p>
                        </a>
                    </li>
                    
                     <li class="active">
                        <a href="/afficherparprof">
                            <i class="material-icons">view_compact</i>
                            <p>Emploi par professeur</p>
                        </a>
                    </li>
 
                     <li class="active">
                        <a href="/afficherparsalle">
                            <i class="material-icons">view_compact</i>
                            <p>Emploi par salle</p>
                        </a>
                    </li> 
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">                                                        
                    <li class="active">
                        <a href="/addfiliere">
                            <i class="material-icons">add_cercle</i>
                            <p>Ajouter une filière</p>
                        </a>
                    </li>
                    
                     <li class="active">
                        <a href="/deletefiliere">
                            <i class="material-icons">delete</i>
                            <p>Supprimer une filière</p>
                        </a>
                    </li>         
                    <li class="active">
                        <a href="/addgroup">
                            <i class="material-icons">add_cercle</i>
                            <p>Ajouter un groupe</p>
                        </a>
                    </li>
                    
                     <li class="active">
                        <a href="/deletegroup">
                            <i class="material-icons">delete</i>
                            <p>Supprimer un groupe</p>
                        </a>
                    </li>

                    <li class="active">
                        <a href="/addsalle">
                            <i class="material-icons">add_cercle</i>
                            <p>Ajouter une salle</p>
                        </a>
                    </li>
                    
                    <li class="active">
                        <a href="/deletesalle">
                            <i class="material-icons">delete</i>
                            <p>Supprimer une salle</p>
                        </a>
                    </li>
                    
                    <li class="active">
                        <a href="/addmatiere">
                            <i class="material-icons">add_cercle</i>
                            <p>Ajouter une matière</p>
                        </a>
                    </li>
                    
                    <li class="active">
                        <a href="/deletematiere">
                            <i class="material-icons">delete</i>
                            <p>Supprimer une matière</p>
                        </a>
                    </li>
                    </sec:authorize>

                    
                    <li class="active">
                        <a href="logout">
                            <i class="material-icons">backspace</i>
                            <p>Logout</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        
   