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
	

	String id = null;	//th_idの初期値はnull

	private String check="";	//多重投稿禁止用のプロパティ

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");

		//POST要求によって送信されたパラメータを取得する
		String checknumber = req.getParameter("checknumber");

		id = req.getParameter("reid");
		String name = req.getParameter("rename");

		//nameが送信されていない場合は、自動的にNONAMEとなる
		if(name==""){
			name=new String("NONAME");
		}
		
		String _content=req.getParameter("recontent");
		//改行記号をhtml用の改行記号に変換する。
		String content=_content.replaceAll("\n", "<br>");

		//空文の場合は、自動的に投稿文はありませんとなる。

		if(content==""){
			content=new String("投稿文はありません。");
		}
		String voting = req.getParameter("revoting");

		//多重投稿禁止用のチェックプログラム
		if(check.equals(checknumber)){}else{

			CreateSQL cre = new CreateSQL();
			String insert_sql = cre.insertResThread(id, name, content, voting);
			OracleDBAccess odba = new OracleDBAccess();
			odba.insertDB(insert_sql);
			check=checknumber;}

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

		//投票数を集計するプログラム

		Stream<Integer> stream1 = votingdata.stream();
		Stream<Integer> stream2 = votingdata.stream();

		long agreement = stream1.filter(number -> number == 1).count();
		long disagreement = stream2.filter(number -> number == 2).count();

		//改ページを作成するプログラム
		int pages = resdatabase.size()/10;
		if(resdatabase.size() %10 !=0){
			pages +=1;
		}

		int allpages[] = new int[pages];
		for(int i=0;i<pages;i++){
			allpages[i] = i+1;
		}

		ArrayList<ResThreadBean> array = new ArrayList<ResThreadBean>();

		int page;
		String _page = req.getParameter("page");
		if(_page == null){
			page = 1;
		}else{
			page = Integer.parseInt(_page);
		}

		int time = 10*(page-1);

		for(int i=0;i<resdatabase.size();i++){
			if(i>=time){
				ResThreadBean resbean = resdatabase.get(i);
				array.add(resbean);
			}

			if(array.size()==10){
				break;
			}
		}
		//改ページプログラムはここまで

		req.setAttribute("agreement", agreement);
		req.setAttribute("disagreement", disagreement);

		req.setAttribute("data",bean);
		req.setAttribute("resdata",array);
		req.setAttribute("id",id);
		req.setAttribute("page",allpages);

		//idを初期化する。そうしないと複数投稿を受け付けなくなる。
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