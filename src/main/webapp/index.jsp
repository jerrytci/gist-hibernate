<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 默认的导航栏</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        .home_main_content {
            background-color: #0E2D5F;
            width: 855px;
            height: inherit;
            text-align: center;
            padding: 5px 10px 15px 20px;
        }
        .home_main_side {
            background-color: #52d689;
            width: 285px;
            height: 600px;
            text-align: center;
            padding-left: 20px;
        }

        .home_main_content, .home_main_side {
            /*float:left;*/
            display:inline;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Wiki</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">iOS</a>
                </li>
                <li>
                    <a href="#">SVN</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div align="center">
    <div class="home_main_side" align="center">
        side
    </div>
    <div class="home_main_content" align="center">
        test
    </div>
</div>
</body>
</html>