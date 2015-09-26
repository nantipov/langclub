<!DOCTYPE html>
<html ng-app="langClubApp">

<head>
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/0.11.0/angular-material.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">


    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-aria.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-route.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.11.0/angular-material.min.js"></script>

	<script src="js/langClubApp.js"></script>

    <%--<script src="js/ui-bootstrap-tpls-0.13.4.min.js"></script>--%>

	<meta name="viewport" content="initial-scale=1" />

</head>

<body ng-controller="generalController">

<!-- 
  <md-button class="md-primary md-hue-2">
    Hello World
  </md-button>
 -->
 
  <md-sidenav md-component-id="left" class="site-sidenav md-sidenav-left md-whiteframe-z2" md-is-locked-open="$mdMedia('gt-sm')">

      <md-toolbar class="md-theme-indigo">
        <h1 class="md-toolbar-tools">Sidenav Left</h1>
      </md-toolbar>
    <!-- Left Nav!  -->
    
	  <md-content>
	    <menu-link>menu1</menu-link>
	    <menu-link>menu2</menu-link>
	  </md-content>
    
  </md-sidenav>
  
  
  <div layout="column" tabIndex="-1" role="main" flex>  
	  <md-content>
	    Center Content
	    <md-button ng-click="openLeftMenu()">
	      Open Left Menu
	    </md-button>
	  </md-content>
	  
	  <md-content ng-view md-scroll-y flex layout-padding></md-content>
	  
  </div>
 


</body>

</html>