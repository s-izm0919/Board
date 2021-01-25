package tera;

import java.util.ArrayList;

//Oracle�f�[�^�x�[�X�𑀍삷�邽�߂̌ŗL�N���X���Ăяo���B
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData extends UserBean{
	//ArrayList�̐����B������Select������Ԃ��Ă���f�[�^���i�[���Ă���B
    private ArrayList<UserBean> oracle = new ArrayList<UserBean>();
	
	//ArrayList��getter
	//���̕��������Ȃ���AddUserServlet�Ƀ��X�g��Ԃ����Ƃ��ł��Ȃ��B
	public ArrayList<UserBean> getDatabase(){
		return oracle;
	}

	//Oracle�f�[�^�x�[�X��Select�������s����
	public void setData(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"info","pro");
			
			//select��
			String sql="SELECT T_NUMBER , USERNAME , CONTENT , POSTING_TIME FROM THREAD_TABLE ORDER BY POSTING_TIME";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				//UserBean�𐶐����A�����Ƀf�[�^������Ă���
                UserBean bean = new UserBean();
				String n=rs.getString(1);	//1��ڂ̃f�[�^���擾
                String u=rs.getString(2);	//2��ڂ̃f�[�^���擾
                String c=rs.getString(3);	//3��ڂ̃f�[�^���擾
				String t=rs.getString(4);	//4��ڂ̃f�[�^���擾
				//UserBean��setter�𗘗p
				bean.setNumber(n);
                bean.setName(u);
                bean.setContent(c);
				bean.setTime(t);
				//List��USerBean�^�̃f�[�^���i�[����
				oracle.add(bean);

				//���̏��������[�v�����邱�ƂŁAOracle����f�[�^����s������UserBean�Ƀf�[�^�����遨1�s�X�N���[�����Ă܂�����������������J��Ԃ��B
			}
			//Oracle����ؒf����
			cn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
