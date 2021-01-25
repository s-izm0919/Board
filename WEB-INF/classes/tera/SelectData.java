package tera;

import java.util.ArrayList;

//Oracleデータベースを操作するための固有クラスを呼び出す。
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData extends UserBean{
	//ArrayListの生成。ここにSelect文から返ってくるデータを格納している。
    private ArrayList<UserBean> oracle = new ArrayList<UserBean>();
	
	//ArrayListのgetter
	//この文を書かないとAddUserServletにリストを返すことができない。
	public ArrayList<UserBean> getDatabase(){
		return oracle;
	}

	//OracleデータベースにSelect文を実行する
	public void setData(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"info","pro");
			
			//select文
			String sql="SELECT T_NUMBER , USERNAME , CONTENT , POSTING_TIME FROM THREAD_TABLE ORDER BY POSTING_TIME";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				//UserBeanを生成し、ここにデータをいれていく
                UserBean bean = new UserBean();
				String n=rs.getString(1);	//1列目のデータを取得
                String u=rs.getString(2);	//2列目のデータを取得
                String c=rs.getString(3);	//3列目のデータを取得
				String t=rs.getString(4);	//4列目のデータを取得
				//UserBeanのsetterを利用
				bean.setNumber(n);
                bean.setName(u);
                bean.setContent(c);
				bean.setTime(t);
				//ListにUSerBean型のデータを格納する
				oracle.add(bean);

				//この処理をループさせることで、Oracleからデータを一行抜く→UserBeanにデータを入れる→1行スクロールしてまた同じ処理をするを繰り返す。
			}
			//Oracleから切断する
			cn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
