package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.PaymentDAO;
import vo.PaymentDTO;

public class AdminOrderListService {

	public int getListCount() {
		System.out.println("BoardListService - getListCount()");
		
		int listCount = 0;
		
		Connection con = getConnection();
		
		PaymentDAO paymentDAO = PaymentDAO.getInstance();		
		
		paymentDAO.setConnection(con);
		
		listCount = paymentDAO.selectListCount();
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<PaymentDTO> selectOrderList(int pageNum,int listLimit) {
		
		System.out.println("PaymentOrderListService - selectOrderList() 메서드 호출");
		
		ArrayList<PaymentDTO> orderList = null;
		
		Connection con = getConnection();
		PaymentDAO paymentDAO = PaymentDAO.getInstance();
		paymentDAO.setConnection(con);
		
		orderList = paymentDAO.selectOrderList(pageNum, listLimit);

		close(con);
		
		
		return orderList;
		
	}
	
}
