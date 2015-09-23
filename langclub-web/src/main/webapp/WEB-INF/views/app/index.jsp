<!DOCTYPE html>
<html ng-app="langClubApp">

<head>
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.11.0/angular-material.min.js"></script>
    <%--<script src="js/ui-bootstrap-tpls-0.13.4.min.js"></script>--%>
    <script src="../js/langClubApp.js"></script>
</head>

<body ng-controller="generalController">

<md-sidenav class="md-sidenav-left md-whiteframe-z2" md-component-id="left" md-is-locked-open="$mdMedia('gt-md')">
    <md-toolbar class="md-theme-indigo">
        <h1 class="md-toolbar-tools">Sidenav Left</h1>
    </md-toolbar>
    <md-toolbar class="md-theme-indigo">
        <h1 class="md-toolbar-tools">Sidenav Left1</h1>
    </md-toolbar>
    <md-content layout-padding ng-controller="LeftCtrl">
        <md-button ng-click="close()" class="md-primary" hide-gt-md>
            Close Sidenav Left
        </md-button>
        <p hide-md show-gt-md>
            This sidenav is locked open on your device. To go back to the default behavior,
            narrow your display.
        </p>
    </md-content>
</md-sidenav>

    <tabset vertical="true" type="pills">
        <tab heading="Dashboard"></tab>
        <tab heading="Account"></tab>
        <tab heading="Conference"></tab>
        <tab heading="White screen"></tab>
        <tab heading="Donate"></tab>
    </tabset>

</body>

</html>