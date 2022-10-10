<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/5/2022
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            box-sizing: border-box;
        }

        .container-web {
            background: url('240_F_274929177_Q6xgPROMWP3yCxL4LQgpzIOVJ98p76eN.jpg') ;
            background-size: cover;
        }

        .guide {
            font-size: 50px;
            color: antiquewhite;
        }

        .wrapper{
            margin-top: -24px;

        }
        .menu{
            display: flex;
            justify-content: center;
            list-style: none;
            padding: 0;
            margin: 0;
            padding: 16px 0;

        }
        .menu-item{
            background: transparent;
            margin: 0 12px;
            padding: 12px 24px;
            position: relative;
            border-radius: 3px;
            border: 1px solid white;
        }
        .menu-link{
            text-decoration: none;
            color: white;
            text-transform: uppercase;
            font-weight: bold;
        }
        .sub-menu{
            position: absolute;
            display: none;
            padding: 0;
            list-style: none;
            border: 1px solid white;
            background: transparent;
            background-color: white;
            left: 0;
            right: 0;
            top:99%;
        }
        .sub-menu-item{
            text-transform: uppercase;
            background-color: #3B5998 ;
            font-size: 13px;
            padding: 12px;
            margin: 0;
        }
        .menu-item:hover .sub-menu{
            display: block;
        }

        .logo {
            text-align: center;
        }

        *{
            margin: 0;
            padding: 0;
            transition: all 0.3s;
        }
        #mainnav{
            padding: 10px;
            margin: 10px;
        }
        #mainnav ul{
            background: #3B5998;
            list-style: none;
            padding: 0px;
            width: 200px;
            text-align: left;
        }
        #mainnav ul li{
            position: relative;
            width: 200px;
            height: 40px;
            line-height: 40px;
            border-bottom: 1px solid #fff;
        }
        #mainnav ul .thefirst{
            background: #1D1F20;
        }
        #mainnav ul li a{
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            padding: 0 16px;
            display: block;
        }
        #mainnav li:hover{
            background: #17306E;
        }
        #mainnav .sub-menu{
            position: absolute;
            left: 200px;
            top: 0px;
            width: 200px;
            display: none;
            text-align: left;
            border-left: 1px solid #fff;
            font-size: 90%;
            border-radius: 0px 10px 10px 0px;
        }
        #mainnav li:hover .sub-menu{
            display: block;
            background: #3B5998;
            color: red;
        }
        #mainnav .sub-menu2{
            position: absolute;
            left: 200px;
            top: 0;
            width: 200px;
            border-left: 1px solid #fff;
            border-radius: 0px 10px 10px 0px;
            border: transparent;
            display: none;
        }
        #mainnav .sub-menu li:hover .sub-menu2{
            display: block;
        }
        #mainnav .sub-menu3{
            position: absolute;
            left: 200px;
            top: 0;
            width: 200px;
            border-left: 1px solid #fff;
            border-radius: 0px 10px 10px 0px;
            display: none;
        }
        #mainnav .sub-menu2 li:hover .sub-menu3{
            display: block;
        }

        .search input#search {
            width: 160px;
            height: 20px;
            background: white;
            border: none;
            font-size: 10pt;
            float: left;
            color: black;
            padding-left: 45px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container-web">
    <div class="logo"><img width="200px" height="200px" ;
                           >
    </div>

    <div class="wrapper">
        <ul class="menu">
            <li class="menu-item"><a href="" class="menu-link">Home</a>
                <ul class="sub-menu">
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub1</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub2</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub3</a></li>
                </ul>
            </li>
            <li class="menu-item"><a href="" class="menu-link">Customer</a>
                <ul class="sub-menu">
                    <li class="sub-menu-item"><a href="/customer" class="sub-menu-link">Customer List</a></li>
                    <li class="sub-menu-item"><a href="/customer?action=create" class="sub-menu-link">add customer</a></li>
                    <li class="sub-menu-item"><a href="/customer" class="sub-menu-link">search customer</a></li>
<%--                    <li class="sub-menu-item"><a href="" class="sub-menu-link">edit customer</a></li>--%>
<%--                    <li class="sub-menu-item"><a href="" class="sub-menu-link">delete customer</a></li>--%>
                </ul>
            </li>
            <li class="menu-item"><a href="" class="menu-link">Employee</a>
                <ul class="sub-menu">
                    <li class="sub-menu-item"><a href="/employee" class="sub-menu-link">Employee List</a></li>
                    <li class="sub-menu-item"><a href="/employee?action=create" class="sub-menu-link">add service</a></li>
                    <li class="sub-menu-item"><a href="/employee" class="sub-menu-link">search service</a></li>
<%--                    <li class="sub-menu-item"><a href="" class="sub-menu-link">delete service</a></li>--%>
                </ul>
            </li>
            <li class="menu-item"><a href="" class="menu-link">Contact</a>
                <ul class="sub-menu">
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">reception</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">guide tour</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">restaurants</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link"></a></li>
                </ul></li>
            <li class="menu-item"><a href="" class="menu-link">Help</a>
                <ul class="sub-menu">
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub1</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub2</a></li>
                    <li class="sub-menu-item"><a href="" class="sub-menu-link">Sub3</a></li>
                </ul></li>
        </ul>
    </div>
    <div id="mainnav">
        <ul>
            <li class="thefirst"><a href="#">Service</a>
                <ul class="sub-menu">
                    <li><a href="#">ADD NEW SERVICE</a>
                        <ul class="sub-menu2">
                            <li><a href="#">VILLA</a></li>
                            <li><a href="#">ROOM</a></li>
                            <li><a href="#">HOUSE</a></li>
                        </ul></li>
                    <li><a href="#">SEARCH INFO SERVICE</a>
                        <ul class="sub-menu2">
                            <li><a href="#">VILLA</a></li>
                            <li><a href="#">ROOM</a></li>
                            <li><a href="#">HOUSE</a></li>
                        </ul>
                    </li>
                    <li><a href="#">SERVICE LIST</a>
                        <ul class="sub-menu2">
                            <li><a href="#">VILLA</a></li>
                            <li><a href="#">ROOM</a></li>
                            <li><a href="#">HOUSE</a></li>
                        </ul>
                    </li>
                    <li><a href="#">item 2</a></li>
                    <li><a href="#">item 3</a></li>
                    <li><a href="#">item 4</a></li>
                    <li><a href="#">item 5</a></li>
                    <li><a href="#">item 6</a>
                        <ul class="sub-menu2">
                            <li><a href="#">item 1</a></li>
                            <li><a href="#"> tem 2</a>
                                <ul class="sub-menu3">
                                    <li><a href="#">item 1.a</a></li>
                                    <li><a href="#">item 2.a</a></li>
                                    <li><a href="#">item 3.a</a></li>
                                </ul>
                            </li>
                            <li><a href="#">item 3</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">item 1</a></li>
            <li><a href="#">item 2</a></li>
            <li><a href="#">item 3</a></li>
            <li><a href="#">item 4</a></li>
            <li><a href="#">item 5</a></li>
        </ul>
    </div>
    <footer>
        By - Viết Huy
    </footer>
</div>
</body>
</html>
