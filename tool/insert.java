//ひたすらループで250行のデータを挿入するプログラム

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

class insert {
    public static void insertDB(){
        for(int i=0;i<250;i++){
            try{
			//Driverインターフェイスを実装するクラスをロードする
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			    Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"panda","passpanda");
			
			//自動コミットをOFFにする
			    cn.setAutoCommit(false);
			
			//SQL文を変数に格納する
			    String _sql="INSERT INTO BOARD_THREAD(th_id, th_name, th_content, th_title, th_question, th_choice1, th_choice2) VALUES(S_ORD_BOARD_THREAD.NEXTVAL, 'test', 'これはテストです', 'テストの文', 'うまくできた', 'できた', 'できない')";
			
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

    public static void main(String args[]){
        insertDB();
    }
}
