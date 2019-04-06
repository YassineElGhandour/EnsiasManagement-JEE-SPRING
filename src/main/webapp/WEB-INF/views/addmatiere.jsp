<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="apple-touch-icon" sizes="76x76" href="gerant/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="gerant/img/favicon.png" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Ajouter une matière</title>
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
                                    <h4 class="title">Ajouter une nouvelle matière</h4>
                                </div>
                                <div class="card-content">
                                    <form action="/addmatiere" method="POST">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Nom de la matière</label>
                                                    <input class="form-control" name="nomMatiere" type="text" autofocus="" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Professeur </label>
                                                    <select name="DropBoxProf" class ="form-control">
                                                        <c:forEach items="${professeurs}" var="professeur">
                                                             <option value="${professeur.email}">${professeur.prenomProfesseur} ${professeur.nomProfesseur}</option>
                                                        </c:forEach>
                                                    </select>                                  
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Semestre </label>
                                                    <select name="DropBoxSemestre" class ="form-control">
                                                        <c:forEach items="${semestres}" var="semestre">
                                                            <option value="${semestre.idSemestre}">${semestre.nomSemestre}</option>
                                                        </c:forEach>
                                                    </select>                                        
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Semestre </label>
                                                    <select name="DropBoxGroupe" class ="form-control">
                                                        <c:forEach items="${groupes}" var="groupe">
                                                            <option value="${groupe.idGroupe}">${groupe.nomGroupe}</option>
                                                        </c:forEach>
                                                    </select>                                       
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <br>
                                        <button type="submit" class="btn btn-info pull-right">Ajouter</button>
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