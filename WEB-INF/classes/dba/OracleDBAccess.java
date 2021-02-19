package dba;

import java.util.ArrayList;

//Oracleデータベースを操作するための固有クラスを呼び出す。
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.ThreadBean;
import bean.ResThreadBean;

public class OracleDBAccess{
	//ArrayListの生成。ここにSelect文から返ってくるデータを格納している。
	private ArrayList<ThreadBean> oracle = new ArrayList<ThreadBean>();
	private ArrayList<ResThreadBean> resoracle = new ArrayList<ResThreadBean>();
	private ArrayList<Integer> votingdata = new ArrayList<Integer>();

	private ThreadBean thbean = new ThreadBean();

	public ArrayList<ThreadBean> getDatabase(){
		return oracle;
	}

	public ArrayList<ResThreadBean> getResDatabase(){
		return resoracle;
	}

	public ThreadBean getThreadBean(){
		return thbean;
	}

	public ArrayList<Integer> getVotingData(){
		return votingdata;
	}


	//OracleデータベースにSelect文を実行する
	public void selectDB(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"info","pro");
			
			//select文
			String _sql= sql;

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(_sql);

			int number=0;

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				//UserBeanを生成し、ここにデータをいれていく
                ThreadBean bean = new ThreadBean();
				String id=rs.getString(1);	//1列目のデータを取得
                String name=rs.getString(2);	//2列目のデータを取得
                String content=rs.getString(3);	//3列目のデータを取得
				String title=rs.getString(4);	//4列目のデータを取得
				String time=rs.getString(5);	//5列目のデータを取得
				String question=rs.getString(6);	//6列目のデータを取得
				String choice1=rs.getString(7);	//7列目のデータを取得
				String choice2=rs.getString(8);	//8列目のデータを取得
				//UserBeanのsetterを利用
				bean.setId(id);
                bean.setName(name);
				bean.setContent(content);
				bean.setTitle(title);
				bean.setTime(time);
				bean.setQuestion(question);
				bean.setChoice1(choice1);
				bean.setChoice2(choice2);
				//ListにUSerBean型のデータを格納する

				
				bean.setNumber(++number);

				oracle.add(bean);


				if(oracle.size() < 2){
					thbean = bean;
				}

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

	public void selectResDB(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"info","pro");
			
			//select文
			String _sql= sql;

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(_sql);

			int number=0;

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				//UserBeanを生成し、ここにデータをいれていく
                ResThreadBean bean = new ResThreadBean();
				String re_id=rs.getString(2);	//2列目のデータを取得
                String name=rs.getString(3);	//3列目のデータを取得
                String content=rs.getString(4);	//4列目のデータを取得
				String time=rs.getString(5);	//5列目のデータを取得
				String voting=rs.getString(6);	//6列目のデータを取得
				//UserBeanのsetterを利用
				bean.setRe_id(re_id);
                bean.setName(name);
				bean.setContent(content);
				bean.setTime(time);
				bean.setVoting(voting);
				//ListにUSerBean型のデータを格納する
				
				bean.setNumber(++number);

				resoracle.add(bean);

				votingdata.add(rs.getInt(6));

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
	
	public void insertDB(String sql){
        try{
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"info","pro");
			
			//自動コミットをOFFにする
			cn.setAutoCommit(false);
			
			//SQL文を変数に格納する
			String _sql=sql;
			
			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			Statement st=cn.createStatement();
			
			//SQLを実行しトランザクションが開始される。処理件数が返される
			int count=st.executeUpdate(_sql);
			
			//トランザクションをコミットする
			cn.commit();
			
			//ステートメントをクローズする
			st.close();
			
			//RDBMSから切断する
			cn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

    }
}
