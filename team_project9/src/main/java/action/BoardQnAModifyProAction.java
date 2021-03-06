package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardQnAModifyProService;
import vo.ActionForward;
import vo.QnADTO;

public class BoardQnAModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardQnAModifyProAction");
		
		ActionForward forward = null;
		
		
		String uploadPath = "/upload";
		int fileSize = 1024 * 1024 * 10;
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath(uploadPath); 

		MultipartRequest multi = new MultipartRequest(
			request,
			realPath,
			fileSize,
			"UTF-8", 
			new DefaultFileRenamePolicy() 
		);
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("sessionId");
		QnADTO board = new QnADTO();
		board.setQuestion_idx(Integer.parseInt(multi.getParameter("idx")));
		board.setMember_id(memberId);
		board.setQuestion_password(multi.getParameter("pass"));
		board.setQuestion_subject(multi.getParameter("subject"));
		board.setQuestion_content(multi.getParameter("content"));
		
		String fileElement = multi.getFileNames().nextElement().toString();
		
		String file = multi.getFilesystemName(fileElement);
		
		board.setQuestion_img(file);
		
		BoardQnAModifyProService boardQnAModifyProService = new BoardQnAModifyProService();
		boolean isArticleWriter = 
				boardQnAModifyProService.isArticleWriter(board.getQuestion_password());
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		boolean isModifySuccess = boardQnAModifyProService.modifyArticle(board);
		
		if(!isModifySuccess) { 
			out.println("<script>"); 
			out.println("alert('??? ?????? ??????!')");
			out.println("history.back()");
			out.println("</script>"); 
		} else { 
			forward = new ActionForward();
			forward.setPath("./QnAList.bo");
//			forward.setPath("QnAContent.bo?idx=" + board.getQuestion_idx() + "&page=" + request.getParameter("page"));
			forward.setRedirect(true); 
			
		}
		
		return forward;
	}

}
