<%@page import="java.text.DecimalFormat"%>
<%@page import="vo.PageInfo"%>
<%@page import="java.util.Collections"%>
<%@page import="vo.ReviewDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.ProductBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<% 
ProductBoardDTO dto = (ProductBoardDTO)request.getAttribute("dto");
int reviewCount = (int)request.getAttribute("reviewCount");
double starScope = (double)request.getAttribute("starScope");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
ArrayList<ReviewDTO> list = (ArrayList<ReviewDTO>)request.getAttribute("articleList");
String member_id = (String)session.getAttribute("sessionId");
String product_code = request.getParameter("product_code");
DecimalFormat formatter = new DecimalFormat("###,###");

int pageNum = pageInfo.getPageNum();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
int listCount = pageInfo.getListCount();
System.out.println(startPage);
System.out.println(endPage);
%>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/s.css" type="text/css">
<script src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	
$(function() {
	$('.primary-btn').click(function() {
		if($('#stock').text()==0){
			alert('????????? ????????????.')
			$('#stock').css('color','red');
			$('#stock').append('<input type="button" value="????????????" onclick="confirm(\'???????????? ??? ????????? ??????????????????????\')">')
			return;
		}
		if(<%=member_id == null%>){
			alert('???????????? ?????????!');
			location.href = '../member/MemberLoginForm.me';
		} else {
			$.ajax({
				type: 'post',
				url: '../payment/CartInsert.pa',
				data: {
					product_code: $('#product_code').val(),
					product_price: $('#product_price').val(),
					product_amount: $('#product_amount').val()
				},
				dataType: 'text',
				success: function(response) {
					var isTrue = confirm('???????????? ?????? ??????!\n??????????????? ?????????????????????????');
					if(isTrue){
						location.href='../payment/CartList.pa';
					}
				},
				error: function(xhr, textStatus, errorThrown) {
					alert(xhr + "" + textStatus + "" + errorThrown);
				}
			});
		}
	});
		
	$('.icon_heart_alt').click(function() {
		if($('#stock').text()==0){
			alert('????????? ????????????.')
			return;
		}
		if(<%=member_id == null%>){
			alert('???????????? ?????????!');
			location.href = '../member/MemberLoginForm.me';
		} else {
			$.ajax({
				type: 'post',
				url: '../payment/WishlistAdd.pa',
				data: {
					product_code: $('#product_code').val(),
				},
				dataType: 'text',
				success: function(response) {
					alert('?????????????????? ?????????????????????!')
				},
				error: function(xhr, textStatus, errorThrown) { 
					alert(xhr + "" + textStatus + "" + errorThrown);
					
				}
			});
		}
	})
});

</script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <!-- Humberger Begin -->
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../img/breadcrumb.jpg">
    <input type="hidden" id="prod_code" value="<%=dto.getProduct_code()%>"> <!-- ?????? ????????? ???????????? ?????? input ?????? -->
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Vegetable???s Package</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Home</a>
                            <a href="./index.jsp">Vegetables</a>
                            <span>Vegetable???s Package</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img  class="product__details__pic__item--large"  src="<%=request.getContextPath() %>/upload/<%=dto.getProduct_img()%>" alt=" ">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="../img/product/details/product-details-2.jpg"
                                src="../img/product/details/thumb-1.jpg" alt="">
                            <img data-imgbigurl="../img/product/details/product-details-3.jpg"
                                src="../img/product/details/thumb-2.jpg" alt="">
                            <img data-imgbigurl="../img/product/details/product-details-5.jpg"
                                src="../img/product/details/thumb-3.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-4.jpg"
                                src="../img/product/details/thumb-4.jpg" alt="">
                        </div>
                    </div>
                </div>
           
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                         <h3><%=dto.getProduct_name() %></h3>
                         <h5>?????? ?????????<%=starScope %></h5>
                        <div class="product__details__rating">
                           <h4><% if(starScope >= 1 && starScope < 1.4){%>
								<span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
					   		<%} else if (starScope >= 1.5 && starScope < 2){ %>
						  		<span>???</span><span><i class="fa fa-star-half-o"></i></span><span>???</span><span>???</span><span>???</span>
					   		<%} else if (starScope >= 2 && starScope < 2.4){ %>
						  		<span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
						  	<%} else if (starScope >= 2.5 && starScope < 3){ %>
						  		<span>???</span><span>???</span><span><i class="fa fa-star-half-o"></i></span><span>???</span><span>???</span>
					   		<%} else if (starScope >= 3 && starScope < 3.4){ %>
						  		<span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
					   		<%} else if (starScope >= 3.5 && starScope < 4){ %>
						  		<span>???</span><span>???</span><span>???</span><span><i class="fa fa-star-half-o"></i></span><span>???</span>
					   		<%} else if (starScope >= 4 && starScope < 4.4){ %>
						  		<span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
							<%} else if (starScope >= 4.5 && starScope < 5){ %>
						  		<span>???</span><span>???</span><span>???</span><span>???</span><span><i class="fa fa-star-half-o"></i></span>
						  	<%} else if (starScope == 5){ %>
								<span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>	
							 <%} %></h4>
                            <span>(<%=reviewCount%> reviews)</span>
                        </div>
	                        <div class="product__details__price"><%=formatter.format(dto.getProduct_price()) %></div>
	                        <p>info1</p>
	                        <p>info2</p>
                       		<div class="product__details__quantity">
                            	<div class="quantity">
                               	  <div class="pro-qty">
                                    <input type="text" value="1" id="product_amount" >
                                  </div>
                            	</div>
                        	</div>
                        	<input type="hidden" id="product_price" value="<%=dto.getProduct_price()%>">
                        	<input type="hidden" id="product_code" value="<%=dto.getProduct_code()%>">
	                        <input type="button" class="primary-btn" value="ADD TO CARD">
	                        <a class="heart-icon"><span class="icon_heart_alt"></span></a>

                        <ul>
                            <li><b>?????? ??????</b> <span id="stock"><%=dto.getProduct_stock() %>???</span></li>
                            <li><b>??????</b> <span>???</span></li>
                            <li><b>????????????</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
             </div>
         <div class="col-lg-12">
		<div class="product__details__tab">
			<ul class="nav nav-tabs" role="tablist">
<!-- 				<li class="nav-item"><a class="nav-link active" -->
<!-- 					data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">????????????</a> -->
<!-- 				</li> -->
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#tabs-2" role="tab" aria-selected="false">????????????</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#tabs-3" role="tab" aria-selected="false">?????? <span>
					</span></a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane" id="tabs-2" role="tabpanel">
					<div class="product__details__tab__desc">
						<h6>????????????</h6>
						<img  class="product__details__pic__item--large"  src="<%=request.getContextPath() %>/upload/<%=dto.getProduct_info_img()%>" alt=" ">
					</div>
				</div>
				<div class="tab-pane" id="tabs-3" role="tabpanel">
					<div class="product__details__tab__desc">
						<article>
							<div class="container">
								<h6>??????</h6>
								<div>
									<ul>
										<li><span class="ico"></span>
										<p class="txt">????????? ?????? ????????? ????????? ???????????????. ?????? ???????????? ????????? ?????? ??????
												???????????? ?????? ?????? ??????????????? ????????? ??? ????????????.</p></li>
										<li><span class="ico"></span>
										<p class="txt">
												????????????, ??????(??????/??????/??????)?????? ?????? ??? ??????????????? ???????????? ??? <a href="#none"
													onclick="window.parent.location.href = '../center/QnAList.bo'">1:1
													??????</a>??? ???????????????.
											</p></li>
									</ul>
								</div>
								<table class="table table-hover">
									<tr>
										<th>??????</th>
										<th>?????????</th>
										<th>??????</th>
										<th>??????</th>
										<th>?????????</th>
									</tr>
									<%
									for (ReviewDTO review : list) {
									%>
									<tr>
										<td><%=review.getReview_idx()%></td>
										<td><%=review.getMember_id()%></td>
										<td><a
											href="../product/ReviewContent.bo?review_idx=<%=review.getReview_idx()%>"><%=review.getReview_subject()%></a></td>
										<td>
											<%
											if (review.getStar_scope() == 1) {
											%> <span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
											<%
											} else if (review.getStar_scope() == 2) {
											%> <span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
											<%
											} else if (review.getStar_scope() == 3) {
											%> <span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
											<%
											} else if (review.getStar_scope() == 4) {
											%> <span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
											<%
											} else if (review.getStar_scope() == 5) {
											%> <span>???</span><span>???</span><span>???</span><span>???</span><span>???</span>
											<%
											}
											%>
										</td>
										<td><%=review.getReview_date()%></td>
										<%
										}
										%>
									</tr>
								</table>
								<div class="clear"></div>
								<div class="container">
									<div id="page_control"
										style="text-align: center; font-size: 16px;">
										
										<%if(pageNum == startPage) { %>
										
												<input type="button" id="next" value="&lt;">
												
										<%} else { %>
											
											<input type="button" id="next" value="&lt;" 
											onclick="location.href='./BoardProductContent.bo?page=<%=pageNum - 1%>&product_code=<%=product_code%>'">

									    <%} %>
									    
										<%for (int i=startPage; i<=endPage; i++) {%>
										
											<%if (i == pageNum) {%>
											
												<input type="button" id="current" value="<%=i%>">
													
											<%} else {%>
												<input type="button" id="current" value="<%=i%>"
												onclick="location.href='./BoardProductContent.bo?page=<%=i%>&product_code=<%=product_code%>'">
											<%} %>
										<%}%>
										
										<%if (pageNum == endPage) {%>
										
											<input type="button" id="next" value=">">
										
										<%} else {%>
										
											<input type="button" id="next" value=">" 
											onclick="location.href='./BoardProductContent.bo?page=<%=pageNum + 1%>&product_code=<%=product_code%>'"> 
												
										<%}%>
									</div>
								</div>
							</div>
						</article>
					</div>
				</div>
			</div>
		</div>
	</div>
    </div>
</section>

	<jsp:include page="../inc/bottom.jsp"></jsp:include>

    <!-- Js Plugins -->
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/jquery-3.6.0.js"></script>


</body>

</html>