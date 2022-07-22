<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<li>
		<%-- <a href="${store_admin }/detail/${storeList.id }"> --%>
		
		<div class="img_box">
		<!-- img src 부분은 현재 tostring으로 분리가 되어있기에 부분 수정이 필요함. ${storeList.storeImg } -->
			<a href="${store_admin }/${storeList.id }/detail"><img src="/img/pizza.png" alt="이미지"></a>
		</div>

		<div class="info_box">
		
			<h2><a href="${store_admin }/${storeList.id }/detail">${storeList.storeName }</a></h2>
			
			<a href="${store_admin }/${storeList.id }/detail">
<%-- 				<span>
					<span>평점 ${storeList.score }</span>
					
					<span class="score_box">
						<c:forEach begin="0" end="4" var="i">
							<c:if test="${Math.round(storeList.score) > i }">
								<i class="far fas fa-star"></i>
							</c:if>
							<c:if test="${Math.round(storeList.score) <= i }">
								<i class="far fa-star"></i>
							</c:if>
						</c:forEach>
					</span>
				</span> --%>
				
<%-- 			<span>
				<span>리뷰 ${storeList.reviewCount }</span>
				<span>사장님 댓글 ${storeList.bossCommentCount }</span>
			</span> --%>
			
 			<span> 
			<span>최소주문금액 <fm:formatNumber value="${storeList.minDelivery }" pattern="###,###" />원</span> 
 				<span>배달팁 <fm:formatNumber value="${storeList.deliveryTip }" pattern="###,###" />원</span> 
 			</span> 
			<span>배달시간 ${storeList.deliveryTime }분</span>
			</a>
		</div>
		
		
<%-- 	<c:if test="${!storeList.isOpen}">
		<div class="is_open">
			<a href="/store/detail/${storeList.id }">지금은 준비중입니다</a>
		</div>
	</c:if> --%>
</li>