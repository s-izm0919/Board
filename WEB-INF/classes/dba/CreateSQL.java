package dba;

public class CreateSQL{
    public String selectAll(String sort){
        String sql="SELECT * FROM BOARD_THREAD ORDER BY th_time DESC";
        switch(sort){
            case "1":
            sql = "SELECT * FROM BOARD_THREAD ORDER BY th_time DESC";
            break;
            
            case "2":
            sql = "SELECT * FROM BOARD_THREAD ORDER BY th_time ASC";
            break;
            
            case "3":
            sql = 
            "SELECT th.th_id, th_name, th_content, th_title, th_time AS time, th_question, th_choice1, th_choice2, count(re_voting) AS count FROM BOARD_THREAD th LEFT OUTER JOIN BOARD_RESPONSE re ON th.th_id = re.th_id GROUP BY th.th_id, th_name, th_content, th_title, th_time, th_question, th_choice1, th_choice2 UNION ALL SELECT th.th_id, th_name, th_content, th_title, th_time AS time, th_question, th_choice1, th_choice2, 0 AS count FROM BOARD_THREAD th JOIN BOARD_RESPONSE re ON th.th_id = re.th_id WHERE th.th_id NOT IN (SELECT th_id FROM BOARD_RESPONSE GROUP BY th_id HAVING count(re_voting)>0) ORDER BY count desc,time desc";
            break;
        }      
        return sql;
    }

    public String selectResAll(String th_id){
        String sql = "SELECT * FROM BOARD_RESPONSE WHERE th_id = "+th_id+" ORDER BY re_time";
        return sql;
    }

    public String selectOne(String id){
        String sql = "SELECT * FROM BOARD_THREAD WHERE th_id = "+id+"";
        return sql;
    }

    public String insertThread(String name, String title, String content, String question, String choice1, String choice2){
        String sql = "INSERT INTO BOARD_THREAD(th_id, th_name, th_content, th_title, th_question, th_choice1, th_choice2) VALUES(S_ORD_BOARD_THREAD.NEXTVAL, '"+name+"', '"+content+"', '"+title+"', '"+question+"', '"+choice1+"', '"+choice2+"')";
        return sql;
    }

    public String insertResThread(String th_id, String name, String content, String voting){
        String sql = "INSERT INTO BOARD_RESPONSE(th_id, re_id, re_name, re_content, re_voting) VALUES("+th_id+",S_ORD_BOARD_RESPONSE.NEXTVAL, '"+name+"','"+content+"',"+voting+")";
        //String sql = "INSERT INTO BOARD_RESPONSE(th_id, re_id, re_name, re_content, re_voting) VALUES(5,S_ORD_BOARD_RESPONSE.NEXTVAL, 'òaêÚ','ÉTÉìÉvÉãÇ≈ì¸ÇÍÇÈ',1)";
        return sql;
    }

}
