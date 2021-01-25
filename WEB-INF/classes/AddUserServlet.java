import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.InsertData;
import tera.SelectData;
import tera.UserBean;

public class AddUserServlet extends HttpServlet {
	
	//ArrayList���g�p
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	private ArrayList<UserBean> database = new ArrayList<UserBean>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
		//�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");
		
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
		String n=req.getParameter("name");
		//name�����M����Ă��Ȃ��ꍇ�́A�����I��NONAME�ƂȂ�
		if(n==""){
			n=new String("NONAME");
		}
		String c=req.getParameter("content");

		//Insert���̎��s
		InsertData idata = new InsertData();
		idata.insertData(n, c);
		
		//SELECT���̎��s
		//SelectData�N���X�̃C���X�^���X�̐���
		SelectData sdata = new SelectData();
		//setData�̎��s�B������Oracle�f�[�^�x�[�X��Select�������s����B
		sdata.setData();
		//UserBean�^�̃f�[�^���i�[�ł���ArrayList��database�ɁAsetDate()�ō쐬���ꂽ���X�g������B
		database=sdata.getDatabase();

		//HttpServletRequest�̎����N���X�̃C���X�^���X��
		//database�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("database",database);

		//HttpServletRequest�̎����N���X�̃C���X�^���X��
		//name�Acontent�Ƃ������O�Ńf�[�^��o�^����
		//����͓��͂��ꂽ���O�Ɠ��e����resultlist��ʂŕ\�����邽�߂Ɏ��s���Ă���B
		//Oracle�̃f�[�^�x�[�X�ɓ��͂��Ă���킯�ł͂Ȃ��B
		req.setAttribute("name",n);
		req.setAttribute("content",c);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("resultlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//SELECT���̎��s
		SelectData sdata = new SelectData();
		sdata.setData();
		database=sdata.getDatabase();

		//HttpServletRequest�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("database",database);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("resultlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}
