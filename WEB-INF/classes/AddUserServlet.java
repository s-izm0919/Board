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
	
	//ArrayListを使用
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	private ArrayList<UserBean> database = new ArrayList<UserBean>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");
		
		//POST要求によって送信されたパラメータを取得する
		String n=req.getParameter("name");
		//nameが送信されていない場合は、自動的にNONAMEとなる
		if(n==""){
			n=new String("NONAME");
		}
		String c=req.getParameter("content");

		//Insert文の実行
		InsertData idata = new InsertData();
		idata.insertData(n, c);
		
		//SELECT分の実行
		//SelectDataクラスのインスタンスの生成
		SelectData sdata = new SelectData();
		//setDataの実行。ここでOracleデータベースにSelect文を実行する。
		sdata.setData();
		//UserBean型のデータを格納できるArrayListのdatabaseに、setDate()で作成されたリストを入れる。
		database=sdata.getDatabase();

		//HttpServletRequestの実装クラスのインスタンスに
		//databaseという名前でデータを登録する
		req.setAttribute("database",database);

		//HttpServletRequestの実装クラスのインスタンスに
		//name、contentという名前でデータを登録する
		//これは入力された名前と投稿文をresultlist画面で表示するために実行している。
		//Oracleのデータベースに入力しているわけではない。
		req.setAttribute("name",n);
		req.setAttribute("content",c);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("resultlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//SELECT分の実行
		SelectData sdata = new SelectData();
		sdata.setData();
		database=sdata.getDatabase();

		//HttpServletRequestの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("database",database);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("resultlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
