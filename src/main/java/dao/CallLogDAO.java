package dao;

import bean.ExamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CallLogDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ExamLog> getCallLogList(HashMap<String, String> paramsMap) {
        //按照年统计：统计某个用户，1年12个月的所有的数据（不精确到day）
        //String sql = "SELECT `call_sum`, `call_duration_sum`, `telephone`, `name`, `year` , `month`, `day` FROM tb_dimension_date t4 INNER JOIN ( SELECT `id_date_dimension`, `call_sum`, `call_duration_sum`, `telephone`, `name` FROM tb_call t2 INNER JOIN ( SELECT `id`, `telephone`, `name` FROM tb_contacts WHERE telephone = :telephone ) t1 ON t2.id_contact = t1.id ) t3 ON t4.id = t3.id_date_dimension WHERE `year` = :year and `month` != -1 ORDER BY `year`, `month`;";
        String class_name = paramsMap.get("class_name");
       String sql="select `stu_id`,`class_name`,`true_rate` from `all` where `class_name`= \""+class_name+"\" order by `true_rate` limit 5";
        System.out.println(sql);
        BeanPropertyRowMapper<ExamLog> beanPropertyRowMapper = new BeanPropertyRowMapper<>(ExamLog.class);
        List<ExamLog> list = namedParameterJdbcTemplate.query(sql, paramsMap, beanPropertyRowMapper);
        return list;
    }
}
