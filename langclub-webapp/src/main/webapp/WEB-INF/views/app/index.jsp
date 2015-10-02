<!DOCTYPE html>
<html ng-app="langClubApp">

<head>
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/0.11.0/angular-material.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-route.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-resource.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular-messages.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.11.0/angular-material.min.js"></script>

    <script src="js/userService.js"></script>
    <script src="js/langClubApp.js"></script>

    <%--<script src="js/ui-bootstrap-tpls-0.13.4.min.js"></script>--%>

    <meta name="viewport" content="initial-scale=1" />

</head>

<body ng-controller="generalController">

<md-toolbar layout="row">
    <md-button ng-click="toggleNavMenu()" ng-hide="mdMediaWrapper()">
        <md-icon md-font-set="material-icons">menu</md-icon>
    </md-button>
    <span flex></span>
    <div layout="row" layout-align="end center">User name</div>
</md-toolbar>

<div flex layout="row">

    <!-- Container  #3 Left -->
    <md-sidenav md-is-locked-open="mdMediaWrapper()" md-component-id="left"
                class="md-whiteframe-z2">
        <md-toolbar class="md-theme-indigo" layout="row">
            <h1 class="md-toolbar-tools">Sidenav Left</h1>
        </md-toolbar>
        <!-- Left Nav!  -->

        <md-list layout="column">
            <md-item ng-repeat="navigationItem in navigationItems">
                <!-- ng-click="switchNavView(navigationItem)" -->
                <md-button ng-href="{{navigationItem.id}}" ng-class="{'selected' : navigationItem === currentNavItem}">
                    {{navigationItem.name}}
                </md-button>
            </md-item>
        </md-list>

    </md-sidenav>

    <!-- Container #4 Right -->
    <md-content flex id="content" layout="column">
       <md-content ng-view md-scroll-y flex layout-padding></md-content>
    </md-content>
</div>
<!--
<div layout="column" tabIndex="-1" role="main" flex>
    <md-content>
        Center Content
        <md-button ng-click="openLeftMenu()">
            Open Left Menu
        </md-button>
    </md-content>

    <md-content ng-view md-scroll-y flex layout-padding></md-content>

</div>
-->
</body>

</html>