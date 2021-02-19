import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadBean;
import bean.ResThreadBean;
import dba.CreateSQL;
import dba.OracleDBAccess;
import deal.CountAggrement;

public class ResThreadServlet extends HttpServlet {
	
	//ArrayListを使用
	private ArrayList<ThreadBean> database = new ArrayList<ThreadBean>();
	private ArrayList<ResThreadBean> resdatabase = new ArrayList<ResThreadBean>();

	private ArrayList<Integer> votingdata = new ArrayList<Integer>();
	

	String id = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");

		id = req.getParameter("reid");

		//POST要求によって送信されたパラメータを取得する
		String name = req.getParameter("rename");
		//nameが送信されていない場合は、自動的にNONAMEとなる
		
		if(name==""){
			name=new String("NONAME");
		}
		
		
		String content = req.getParameter("recontent");

		if(content==""){
			content=new String("投稿文はありません。");
		}
		String voting = req.getParameter("revoting");

		CreateSQL cre = new CreateSQL();
		String insert_sql = cre.insertResThread(id, name, content, voting);

		OracleDBAccess odba = new OracleDBAccess();
		odba.insertDB(insert_sql);

		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("Windows-31J");
        
        if(id == null){		
			id = req.getParameter("id");
		}

		//SELECT分の実行
		CreateSQL cre = new CreateSQL();
		String select_sql = cre.selectOne(id);
		String resselect_sql = cre.selectResAll(id);

		OracleDBAccess odba = new OracleDBAccess();
		odba.selectDB(select_sql);
		ThreadBean bean = odba.getThreadBean();

		odba.selectResDB(resselect_sql);
		resdatabase = odba.getResDatabase();

		votingdata = odba.getVotingData();

		Stream<Integer> stream1 = votingdata.stream();
		Stream<Integer> stream2 = votingdata.stream();

		long agreement = stream1.filter(number -> number == 1).count();
		long disagreement = stream2.filter(number -> number == 2).count();

		req.setAttribute("agreement", agreement);
		req.setAttribute("disagreement", disagreement);

		//HttpServletRequestの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("data",bean);
		req.setAttribute("resdatabase",resdatabase);

		id = null;
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("resthreadlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}