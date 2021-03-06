package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminChartAction;
import action.AdminMemberListAction;
import action.AdminOrderListAction;
import action.AdminProductContentAction;
import action.AdminProductDeleteProAction;
import action.AdminProductListAction;
import action.AdminProductModifyFormAction;
import action.AdminProductModifyProAction;
//import action.AdminProductModifyProAction;
import action.AdminProductWriteProAction;
import vo.ActionForward;

@WebServlet("*.ad")
public class AdminFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AdminFrontController");

		request.setCharacterEncoding("UTF-8");

		Action action = null;

		ActionForward forward = null;

		String command = request.getServletPath();
		System.out.println("command : " + command);

		// =========================== admin_page ===================================

		if (command.equals("/admin/AdminMain.ad")) {
			action = new AdminMemberListAction();
 			try {
 				forward = action.execute(request, response);
 			} catch (Exception e) {
 				e.printStackTrace();
 			}

		}

		// =========================== product ================================

		if (command.equals("/admin/Popup/AdminProductWriteForm.ad")) {
			forward = new ActionForward();
			forward.setPath("./product_popup.jsp");
			forward.setRedirect(false);

		} else if (command.equals("/admin/Popup/AdminProductWritePro.ad")) {
			action = new AdminProductWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/admin/AdminProductList.ad")) {
			action = new AdminProductListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/admin/AdminProductContent.ad")) {
			action = new AdminProductContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/admin/AdminProductDeletePro.ad")) {
			action = new AdminProductDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/admin/AdminProductModifyForm.ad")) {
			action = new AdminProductModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/admin/Popup/AdminProductModifyPro.ad")) {
			action = new AdminProductModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	

	 // =========================== member ===================================
		
 	 	if(command.equals("/admin/MemberList.ad")) {
 	 		action = new AdminMemberListAction();
 			try {
 				forward = action.execute(request, response);
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		} 
 	 // =========================== sales ===================================
		
 	 	if(command.equals("/admin/AdminChart.ad")) {
 	 		action = new AdminChartAction();
 			try {
 				forward = action.execute(request, response);
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 	 	
 	// =========================== payment ===================================
 	 	
 		if(command.equals("/admin/OrderList.ad")) { // ????????????
			
			action = new AdminOrderListAction(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

 	 	// ============================ ????????????==============================

	 	if (forward != null) {
	 		if (forward.isRedirect()) { // Redirect ????????? ??????
	 			// Redirect ???????????? ????????? => response ????????? sendRedirect() ????????? ??????
	 			response.sendRedirect(forward.getPath());
	 		} else { // Dispatcher ????????? ??????
	 			// RequestDispatcher ????????? forward() ????????? ??????
	 			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
	 			dispatcher.forward(request, response);
	 		}
	 	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
