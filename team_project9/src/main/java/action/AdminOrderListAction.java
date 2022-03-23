package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminOrderListService;
import svc.BoardNoticeListService;
import svc.PaymentOrderListService;
import vo.ActionForward;
import vo.BoardDTO;
import vo.PageInfo;
import vo.PaymentDTO;

public class AdminOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("PaymentOrderListAction");
		ActionForward forward = null;

		AdminOrderListService adminOrderListService = new AdminOrderListService();
		int pageNum = 1; 
		
		if(request.getParameter("page") != null) {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		
		int listCount = adminOrderListService.getListCount(); 
		
		int listLimit = 10;
		int pageLimit = 10; 
		
		ArrayList<PaymentDTO> paymentDTO = adminOrderListService.selectOrderList(pageNum,listLimit);
		
		int maxPage = (int)Math.ceil((double)listCount / listLimit);	
		
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
		
		request.setAttribute("pageInfo", pageInfo);
		
		if(paymentDTO == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문 내역이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.flush();
		} else {
			
			forward = new ActionForward();
			request.setAttribute("paymentDTO", paymentDTO);
			
			forward.setPath("./management/order_list_management.jsp");
			forward.setRedirect(false);
		}
		
		
		return forward;
	}

}
