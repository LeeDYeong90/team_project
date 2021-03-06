package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminEventModifyAction;
import action.AdminEventModifyProAction;
import action.BoardEventCommentDeleteAction;
import action.BoardEventCommentProAction;
import action.BoardEventContentAction;
import action.BoardEventDeleteProAction;
import action.BoardEventListAction;
import action.BoardEventModifyAction;
import action.BoardEventModifyProAction;
import action.BoardEventWriteProAction;
import action.BoardNoticeContentAction;
import action.BoardNoticeDeleteProAction;
import action.BoardNoticeListAction;
import action.BoardNoticeModifyAction;
import action.BoardNoticeModifyProAction;
import action.BoardNoticeWriteProAction;
import action.BoardProductContentAction;
import action.BoardProductListAction;
import action.BoardQnAAnswerFormAction;
import action.BoardQnAAnswerProAction;
import action.BoardQnAContentAction;
import action.BoardQnADeleteProAction;
import action.BoardQnAListAction;
import action.BoardQnAModifyAction;
import action.BoardQnAModifyProAction;
import action.BoardQnAReplyWriteProAction;
import action.BoardQnAWriteProAction;
import action.ReviewContentAction;
import action.ReviewDeleteProAction;
import action.ReviewListAction;
import action.ReviewModifyFormAction;
import action.ReviewModifyProAction;
import action.ReviewWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardFrontController");

		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		System.out.println("command : " + command);
		Action action = null;

		ActionForward forward = null;

		// =========================== Notice ===================================

		if (command.equals("/center/NoticeList.bo")) {
			action = new BoardNoticeListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/center/NoticeWriteForm.bo")) {
			forward = new ActionForward();

			forward.setPath("./noticeWriteForm.jsp");

			forward.setRedirect(false);
		} else if (command.equals("/center/NoticeWritePro.bo")) {
			action = new BoardNoticeWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardNoticeWriteProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/NoticeContent.bo")) {
			action = new BoardNoticeContentAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardNoticeContentAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/NoticeModify.bo")) {
			action = new BoardNoticeModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardNoticeModifyAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/NoticeModifyPro.bo")) {
			action = new BoardNoticeModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardNoticeModifyProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/NoticeDeletePro.bo")) {
			action = new BoardNoticeDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardNoticeDeleteAction() ?????? ??????!");
				e.printStackTrace();
			}

		}

		// =========================== Event ===================================

		if (command.equals("/center/EventList.bo")) {
			action = new BoardEventListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventListAction() ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/EventWriteForm.bo")) {
			forward = new ActionForward();

			forward.setPath("./eventWriteForm.jsp");

			forward.setRedirect(false);
		} else if (command.equals("/center/EventWritePro.bo")) {
			action = new BoardEventWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventWriteProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/EventContent.bo")) {
			action = new BoardEventContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventContentAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/EventModify.bo")) {
			action = new BoardEventModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventModifyAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/EventModifyPro.bo")) {
			action = new BoardEventModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventModifyProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/EventDeletePro.bo")) {
			action = new BoardEventDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventDeleteProAction() ?????? ??????!");
				e.printStackTrace();
			}

		} else if (command.equals("/center/EventCommentPro.bo")) {
			action = new BoardEventCommentProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventCommentProAction() ?????? ??????!");
				e.printStackTrace();
			}

		} else if (command.equals("/center/EventCommentDelete.bo")) {
			action = new BoardEventCommentDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardEventCommentDeleteAction() ?????? ??????!");
				e.printStackTrace();
			}

		}

		// =========================== QnA ===================================

		if (command.equals("/center/QnAList.bo")) {
			action = new BoardQnAListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("QnAListAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAWriteForm.bo")) {
			forward = new ActionForward();

			forward.setPath("./QnAWriteForm.jsp");

			forward.setRedirect(false);
		} else if (command.equals("/center/QnAWritePro.bo")) {
			action = new BoardQnAWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("QnAWriteProAction() ?????? ??????!");
				e.printStackTrace();
			}

		} else if (command.equals("/center/QnAContent.bo")) {
			action = new BoardQnAContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAContentAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAModify.bo")) {
			action = new BoardQnAModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAModifyAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAModifyPro.bo")) {
			action = new BoardQnAModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAModifyProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnADeletePro.bo")) {
			action = new BoardQnADeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnADeleteProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAAnswerForm.bo")) {
			action = new BoardQnAAnswerFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAAnswerFormAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAAnswerPro.bo")) {
			action = new BoardQnAAnswerProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAAnswerProAction() ?????? ??????!");
				e.printStackTrace();
			}
		} else if (command.equals("/center/QnAReply.bo")) {
			action = new BoardQnAReplyWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("BoardQnAReplyWriteProAction() ?????? ??????!");
				e.printStackTrace();
			}
		}

		// =========================== product ===================================

		if (command.equals("/product/BoardProductList.bo")) {
			System.out.println("BoardFrontController - /product/BoardProductList.bo ?????? ?????????");
			action = new BoardProductListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/BoardProductContent.bo")) {
			System.out.println("BoardFrontController - /product/BoardProductContent.bo ?????? ?????????");

			action = new BoardProductContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// =========================== review ===================================

		if (command.equals("/product/ReviewList.bo")) {
			System.out.println("ReviewListAction");

			action = new ReviewListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// =========================== review ===================================

		} else if (command.equals("/product/ReviewForm.bo")) {
			forward = new ActionForward();
			forward.setPath("./review_write.jsp");
			forward.setRedirect(false);

		} else if (command.equals("/product/ReviewWritePro.bo")) {
			action = new ReviewWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/product/ReviewDeletePro.bo")) {
			action = new ReviewDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/ReviewContent.bo")) {
			action = new ReviewContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/ReviewModifyPro.bo")) {
			action = new ReviewModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/ReviewModifyForm.bo")) {
			action = new ReviewModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/ReviewList.bo")) {
			action = new ReviewListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/center/Contact.bo")) { // contact ?????????
	         forward = new ActionForward();
	         forward.setPath("../center/contact.jsp");
	         forward.setRedirect(true);
	         
	      }
		// ========================== ???????????? ===========================

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
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
