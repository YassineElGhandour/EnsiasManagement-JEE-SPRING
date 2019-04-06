<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="apple-touch-icon" sizes="76x76" href="gerant/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="gerant/img/favicon.png" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Consulter l'emploi par Salle</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- Bootstrap core CSS     -->
    <link href="gerant/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="gerant/css/material-dashboard.css" rel="stylesheet" />
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="gerant/css/demo.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body>
    <div class="wrapper">
        <c:import url="dashboard.jsp"></c:import>
        <div class="main-panel">
            <nav class="navbar navbar-transparent navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="material-icons">person</i>
                                    <p class="hidden-lg hidden-md">Profile</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="blue">
                                    <h4 class="title">Emploi du temps</h4>
                                </div>
                                <div class="card-content">
                                <form action="/afficherparsalle" method="POST">
                                	<div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Salle </label>
                                                    <select name="DropBoxSalle" class ="form-control">
                                                        <c:forEach items="${salles}" var="salle">
                                                            <option value="${salle.idSalle}">${salle.nomSalle}</option>
                                                        </c:forEach>
                                                    </select>                                       
                                                </div>
                                            </div>
                                           	<div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Semaine </label>
                                                    <select name="DropBoxSemaine" class ="form-control">
                                                            <option value="Semaine 1">Semaine 1</option>
                                                            <option value="Semaine 2">Semaine 2</option>
                                                            <option value="Semaine 3">Semaine 3</option>
                                                            <option value="Semaine 4">Semaine 4</option>
                                                            <option value="Semaine 5">Semaine 5</option>
                                                    </select>                                       
                                                </div>
                                            </div>
                                        </div>


<table>
  <tr>
  	<th></th>
    <th>8h-10h</th>
    <th>10h-12h</th> 
    <th>12h-14h</th> 
    <th>14h-16h</th>
    <th>16h-12h</th>
  </tr>
  <tr>
    <td>Lundi</td>
    <td>
      	
      	<c:forEach items="${emploiTempsLundiPerOne}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerOne}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerOne}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
       
        <c:forEach items="${emploiTempsLundiPerOne}" var="empl">
        	 Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/>               
    </td> 
   		
	<td>
      	
      	<c:forEach items="${emploiTempsLundiPerTwo}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerTwo}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerTwo}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsLundiPerTwo}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/>               
    </td> 
    
    <td> </td> 
     <td>
      	
      	<c:forEach items="${emploiTempsLundiPerThree}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
       
        <c:forEach items="${emploiTempsLundiPerThree}" var="empl">
        	 Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerThree}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsLundiPerThree}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/>               
    </td>
 
     <td>
      	
      	<c:forEach items="${emploiTempsLundiPerFour}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerFour}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsLundiPerFour}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsLundiPerFour}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/>               
    </td>    
  </tr>
  <tr>
    <td>Mardi</td>
     <td>
      	
      	<c:forEach items="${emploiTempsMardiPerOne}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
       
        <c:forEach items="${emploiTempsMardiPerOne}" var="empl">
        	 Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerOne}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMardiPerOne}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsMardiPerTwo}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerTwo}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerTwo}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMardiPerTwo}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

	<td></td>
	
     <td>
      	
      	<c:forEach items="${emploiTempsMardiPerThree}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerThree}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerThree}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMardiPerThree}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsMardiPerFour}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerFour}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMardiPerFour}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMardiPerFour}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 
    
  </tr>
    <tr>
    <td>Mercredi</td>
         <td>
      	
      	<c:forEach items="${emploiTempsMercrediPerOne}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerOne}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerOne}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
       
        <c:forEach items="${emploiTempsMercrediPerOne}" var="empl">
        	 Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
       
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	 Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

	<td></td>
	
     <td>
      	
      	<c:forEach items="${emploiTempsMercrediPerThree}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerThree}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerThree}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMercrediPerThree}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsMercrediPerFour}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerFour}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerFour}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMercrediPerFour}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 
  </tr>
    <tr>
    <td>Jeudi</td>
         <td>
      	
      	<c:forEach items="${emploiTempsJeudiPerOne}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsJeudiPerOne}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsJeudiPerOne}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsJeudiPerOne}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsMercrediPerTwo}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

	<td></td>
	
     <td>
      	
      	<c:forEach items="${emploiTempsJeudiPerThree}" var="empl">
        	Salle :	${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsJeudiPerThree}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsJeudiPerThree}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsJeudiPerThree}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsJeudiPerFour}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsJeudiPerFour}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
       
        <c:forEach items="${emploiTempsJeudiPerFour}" var="empl">
        	 Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsJeudiPerFour}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 
  </tr>
    <tr>
    <td>Vendredi</td>
         <td>
      	
      	<c:forEach items="${emploiTempsVendrediPerOne}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerOne}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerOne}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsVendrediPerOne}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsVendrediPerTwo}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerTwo}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerTwo}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsVendrediPerTwo}" var="empl">
        	Filière : ${empl.filiere.nomFiliere} 
        </c:forEach><br/> 
    </td> 

	<td></td>
	
     <td>
      	
      	<c:forEach items="${emploiTempsVendrediPerThree}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerThree}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerThree}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsVendrediPerThree}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 

     <td>
      	
      	<c:forEach items="${emploiTempsVendrediPerFour}" var="empl">
        	Salle : ${empl.salle.nomSalle}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerFour}" var="empl">
        	Matière : ${empl.matiere.nomMatiere}
        </c:forEach><br/>
        
        <c:forEach items="${emploiTempsVendrediPerFour}" var="empl">
        	Professeur : ${empl.professeur.nomProfesseur} ${empl.professeur.prenomProfesseur}
        </c:forEach><br/> 
        
        <c:forEach items="${emploiTempsVendrediPerFour}" var="empl">
        	Filière : ${empl.filiere.nomFiliere}
        </c:forEach><br/> 
    </td> 
  </tr>
</table>                
					<button type="submit" class="btn btn-info pull-right">Afficher</button>
                                        <div class="clearfix"></div>
                    
                                        <div class="clearfix"></div>
                                    </form>  
                                </div>
                            </div>
                        </div>
                    
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </div>
            </footer>
        </div>
    </div>
</body>
<!--   Core JS Files   -->
<script src="gerant/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="gerant/js/bootstrap.min.js" type="text/javascript"></script>
<script src="gerant/js/material.min.js" type="text/javascript"></script>
<!--  Charts Plugin -->
<script src="gerant/js/chartist.min.js"></script>
<!--  Dynamic Elements plugin -->
<script src="gerant/js/arrive.min.js"></script>
<!--  PerfectScrollbar Library -->
<script src="gerant/js/perfect-scrollbar.jquery.min.js"></script>
<!--  Notifications Plugin    -->
<script src="gerant/js/bootstrap-notify.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Material Dashboard javascript methods -->
<script src="gerant/js/material-dashboard.js?v=1.2.0"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="gerant/js/demo.js"></script>
</html>