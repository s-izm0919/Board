//�Ђ����烋�[�v��250�s�̃f�[�^��}������v���O����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

class insert {
    public static void insertDB(){
        for(int i=0;i<250;i++){
            try{
			//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X��Ԃ�
			    Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"panda","passpanda");
			
			//�����R�~�b�g��OFF�ɂ���
			    cn.setAutoCommit(false);
			
			//SQL����ϐ��Ɋi�[����
			    String _sql="INSERT INTO BOARD_THREAD(th_id, th_name, th_content, th_title, th_question, th_choice1, th_choice2) VALUES(S_ORD_BOARD_THREAD.NEXTVAL, 'test', '����̓e�X�g�ł�', '�e�X�g�̕�', '���܂��ł���', '�ł���', '�ł��Ȃ�')";
			
			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����

			    Statement st=cn.createStatement();
			
			//SQL�����s���g�����U�N�V�������J�n�����B�����������Ԃ����
			    int count=st.executeUpdate(_sql);
			
			//�g�����U�N�V�������R�~�b�g����
			    cn.commit();
			
			//�X�e�[�g�����g���N���[�Y����
			    st.close();
			
			//RDBMS����ؒf����
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
