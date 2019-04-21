<!DOCTYPE html>
<html lang="zh-CN">
  <head>
      <meta charset="utf-8">
      <!--不支持老版本IE-->
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!--device-width自适应移动端宽度，initial-scale=1不进行缩放-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>mr_notright主页</title>
    <!-- Bootstrap 核心样式文件 -->
      <link href="CSS/bootstrap.min.css" rel="stylesheet">
      <style type="text/css">
          /*设置body，不要让导航条（默认50px）压到下面的内容*/
           body { padding-top: 70px; }

           /*下拉菜单颜色*/
          .dropdowncolor {
              background-color: #202020;
              color: white;
              font-weight: bold;
          }
          /*轮播图片设置大小*/
          .carousel-inner .item img {
              height: 400px;
              width: 100%;
          }
          /*调整圆角图片大小*/
          .img-circle {
              width: 250px;  
          }
          /*版权信息*/
          #copyright {
              background-color: #202020;
              height: 100px;
              color: #524f4f;
              text-align: center;
              font-size: 10px;
              padding-top: 6px;
          }
          .img-thumbnail{
          	height:200px;
          	width:260px;
          }
      </style>
  </head>
   <body>
       <!-----------------------------------------导航条设计开始--------------------------------->
       <!--黑色导航条样式为navbar-inverse，白色样式为default  ， .navbar-fixed-top导航条固定在顶端-->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <!------button为实现响应式布局，如果在手机上查看，点击button就可以弹出菜单---->
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">mr_notright</a><!---方log的地方-->
                </div>

                <!-- 当浏览器小于某个值时，点击button图标显示导航条的内容（注意这里的id与button 的id对应）-->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <!--具体菜单项-->
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li><!--普通菜单-->
                        <li class="dropdown"><!--下拉菜单-->
                            <a class="dropdown-toggle" href="#" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                技术博客
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu dropdowncolor" aria-labelledby="dropdownMenu1">
                                <li><a href="#">机器学习数学基础</a></li><!--下拉菜单项-->
                                <li><a href="#">.机器学习常用算法</a></li>
                                <li><a href="#">深度学习</a></li>
                            </ul>
                        </li>
                        <li><a href="#">我的生活</a></li>
                        <li><a href="#">留言板</a></li>
                        <li><a href="#">关于我</a></li>
                    </ul>
                    <!--搜索表单-->
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn navbar-btn">搜索</button>
                    </form>
                    <!--导航栏右部，一般的登录 注册-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="./login_register.jsp">登录/注册</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
       <!------------------------------------------导航条结束-------------------------------->
       
          <!--------------------------------------------------轮播开始-------------------------------------------->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- ol指示器  ol标签与ul标签不同 ol为是有序列表 ul为是无序列表 -->
            <ol class="carousel-indicators">
                  <!-- 指示器 -->
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            </ol>

            <!-- 包装的轮播图片-->
            <div class="carousel-inner" role="listbox">
                <!--图片-->
                <div class="item active">
                    <img src="./Images/1.jpg" alt="风景1">
                    <div class="carousel-caption">
                        <!--h4中的内容显示到图片上面，-->
                        <h4>真正的才智是刚毅的志向。 —— 拿破仑</h4>
                    </div>
                </div>
                <div class="item">
                    <img src="./Images/2.jpg" alt="风景2">
                    <div class="carousel-caption">
                        <h4>志向不过是记忆的奴隶，生气勃勃地降生，但却很难成长。 —— 莎士比亚</h4>
                    </div>
                </div>
                <div class="item">
                    <img src="./Images/3.jpg" alt="风景3">
                    <div class="carousel-caption">
                        <h4>志向和热爱是伟大行为的双翼。 —— 歌德</h4>
                    </div>
                </div>
                <div class="item">
                    <img src="./Images/4.jpg" alt="风景4">
                    <div class="carousel-caption">
                        <h4>生活有度，人生添寿。 —— 书摘</h4>
                    </div>
                </div>
            </div>

<!-- 这里的翻译button显示不了 -->
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
       <!--------------------------------------------------轮播结束-------------------------------------------->
        <!---------主体 container居中------------------>
       <div class="container">
           <!--声明行-->
           <div class="row">
               <h2>我的作品</h2>
           </div>
           <div class="row">
               <!--为3的栅格系统，相对于一行放四个-->
               <div class="col-sm-3">
                   <!--img-thumbnail 方形加外边框-->
                   <img src="./Images/灵泉寺.png" class="img-thumbnail" alt="灵泉寺"/>
                   <h3>灵泉寺</h3>
                   <p>灵泉寺，国家AAAA旅游风景区，位于遂宁城东4公里，与广德寺隔涪江相望，灵泉寺始建于隋开皇年间（581-600），
                   远在一千多年前就已成为佛教圣地历称：西方圣</p>
                   <p><a href="#" class="btn btn-success" role="button">详细</a></p>
               </div>
               <div class="col-sm-3">
                   <img src="./Images/湿地公园.png" class="img-thumbnail" alt="湿地公园" />
                   <h3>湿地公园</h3>
                   <p>观音湖生态湿地公园，地处涪江中游，纵贯遂宁城区，水域面积达14.8平方公里。湖中有五个岛屿。
                   分为五彩缤纷路景观带和观音文化园两大部分。</p>
                   <p><a href="#" class="btn btn-success" role="button">详细</a></p>
               </div>
               <div class="col-sm-3">
                   <img src="./Images/中国死海.png" class="img-thumbnail" alt="中国死海"/>  
                   <h3>中国死海</h3>
                   <p>来自于一亿五千万年前地球的两次造山运动在大英县形成的地下古盐湖盆地，其海水（盐卤水）的储量十分丰富，
                   已探明的储量就高达42亿吨。“中国死海”海水含盐</p>
                   <p><a href="#" class="btn btn-success" role="button">详细</a></p>
               </div>
               <div class="col-sm-3">
                   <img src="./Images/宋瓷.png" class="img-thumbnail" alt="宋瓷博物馆"/>  
                   <h3>宋瓷博物馆</h3>
                   <p>宋瓷博物馆又名宋朝青瓷博物馆，该馆所拥有的宋代瓷器，与广汉三星自贡恐龙并称四川文物旅游三大著名品牌；2005年被评定为国家3A级景区</p>
                   <p><a href="#" class="btn btn-success" role="button">详细</a></p>
               </div>
           </div>
 
           <!-------------------------标签页开始----------------------------->
           <div>
               <div class="row">
                   <h2>技术分类</h2>
               </div>
               <!-- Nav tabs页签 -->
               <ul class="nav nav-tabs" role="tablist">
                   <!--注意这里的#home与下面的div role="tabpanel" class="tab-pane active" id="home" 的id对应实现页签-->
                   <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">机器学习数学基础</a></li>
                   <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">常用机器学习算法</a></li>
                   <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">深度学习</a></li>
               </ul>

               <!-- Tab panes -->
               <div class="tab-content">
                   <!--active当前选中项-->
                   <div role="tabpanel" class="tab-pane active" id="home">
                       <div class="row">
                           <div class="col-sm-8">
                               <h3>机器学习数学基础</h3>
                               <p style="font-size:14px">我们知道，机器学习的特点就是：以计算机为工具和平台，
                               以数据为研究对象，以学习方法为中心；是概率论、线性代数、数值计算、信息论、最优化理论
                               和计算机科学等多个领域的交叉学科。所以本文就先介绍一下机器学习涉及到的一些最常用的的
                               数学知识。</p>
                               <a href="#" class="btn btn-success" role="button">详细了解</a></p>
                           </div>
                           <div class="col-sm-4">
                               <img src="./Images/math.jpg" class="img-thumbnail" alt="数学基础"/> 
                           </div>
                       </div> 
                   </div>
                   <div role="tabpanel" class="tab-pane" id="profile">
                       <div class="row">
                           <div class="col-sm-8">
                               <h3>机器学习常用算法</h3>
                               <p style="font-size:14px">机器学习无疑是当前数据分析领域的一个热点内容。
                               很多人在平时的工作中都或多或少会用到机器学习的算法。本文总结一下常见的机器学习算法，
                               以供参考。机器学习的算法很多，很多算法是一类算法，而有些算法又是从其他算法中延伸出来的。</p>
                               <p><a href="#" class="btn btn-success" role="button">详细了解</a></p>
                           </div>
                           <div class="col-sm-4">
                               <img src="./Images/machine_learning.png" class="img-thumbnail" alt="机器学习"/> 
                           </div>
                       </div> 
                   </div>
                   <div role="tabpanel" class="tab-pane" id="messages">
                       <div class="row">
                           <div class="col-sm-8">
                               <h3>深度学习</h3>
                               <p style="font-size:14px">深度学习的概念源于人工神经网络的研究。含多隐层的
                               多层感知器就是一种深度学习结构。深度学习通过组合低层特征形成更加抽象的高层表示属
                               性类别或特征，以发现数据的分布式特征表示。</p>
                               <p><a href="#" class="btn btn-success" role="button">详细了解</a></p>
                           </div>
                           <div class="col-sm-4">
                               <img src="./Images/deep_learning.jpeg" class="img-thumbnail" alt="深度学习"/> 
                           </div>
                       </div> 
                   </div>
               </div>

           </div>
           <!-------------------------标签页结束----------------------------->
       </div>
       <div  id="copyright">
           <p style="margin-top:10px">个人博客 </p>
           <p> 西南大学 mr_notright </p>
            <p> 联系方式：qq:764690274    邮箱：764690274@qq.com </p>
       </div>
       <!-- jQuery CDN加速 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!--bootstrap核心JS文件 （必须放在在jQuery，以为bootstrap基于必须放在在jQuery） -->
    <script src="JS/bootstrap.min.js"></script>
  </body>
</html>
