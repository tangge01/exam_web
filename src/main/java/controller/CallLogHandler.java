package controller;

import bean.ErrorRate;
import bean.ExamLog;
import bean.Contact;
import bean.QueryInfo;
import com.google.gson.Gson;
import dao.CallLogDAO;
import dao.ContactDAO;
import dao.ExamDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class CallLogHandler {

    @RequestMapping("/queryCallLogList")
    public String queryCallLog(Model model, ExamLog ExamInfo){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CallLogDAO callLogDAO = applicationContext.getBean(CallLogDAO.class);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("class_name", ExamInfo.getClass_name());
        hashMap.put("true_rate", ExamInfo.getTrue_rate());
        hashMap.put("stage", ExamInfo.getStage());
        hashMap.put("stu_id", ExamInfo.getStu_id());

        List<ExamLog> list = callLogDAO.getCallLogList(hashMap);
        String class_name="";
        String true_rate="";
        String stage="";
        String stu_id="";


        for (int i=0;i<list.size();i++){
            if(i==list.size()-1){
                class_name+=list.get(i).getClass_name();
                true_rate+=list.get(i).getTrue_rate();
                stage+=list.get(i).getStage();
                stu_id+=list.get(i).getStu_id();
            }else{
                class_name+=list.get(i).getClass_name()+",";
                true_rate+=list.get(i).getTrue_rate()+",";
                stage+=list.get(i).getStage()+",";
                stu_id+=list.get(i).getStu_id()+",";
            }
        }
        //通过model返回数据
        model.addAttribute("class_name",class_name);
        model.addAttribute("true_rate",true_rate );
        model.addAttribute("stage", stage);
        model.addAttribute("stu_id",stu_id );

        return "jsp/CallLogListEchart";
    }
    @RequestMapping("/queryCallLogList0")
    public String queryCallLog(Model model, ErrorRate errorRate){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExamDAO examDAO = applicationContext.getBean(ExamDAO.class);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("question_id", errorRate.getQuestion_id());
        hashMap.put("stage", errorRate.getState());
        hashMap.put("question_diffculty", errorRate.getQuestion_diffculty());
        hashMap.put("error_rate", errorRate.getError_rate());

        List<ErrorRate> list = examDAO.getCallLogList(hashMap);
        String question_id="";
        String stage="";
        String question_diffculty="";
        String error_rate="";


        for (int i=0;i<list.size();i++){
            if(i==list.size()-1){
                question_id+=list.get(i).getQuestion_id();
                //stage+=list.get(i).getTrue_rate();
                stage+=list.get(i).getState();
                error_rate+=list.get(i).getError_rate();
            }else{
                question_id+=list.get(i).getQuestion_id()+",";
                question_diffculty+=list.get(i).getQuestion_diffculty()+",";
                stage+=list.get(i).getState()+",";
                error_rate+=list.get(i).getError_rate()+",";
            }
        }
        //通过model返回数据
        model.addAttribute("question_id",question_id);
        model.addAttribute("question_diffculty",question_diffculty );
        model.addAttribute("stage", stage);
        model.addAttribute("error_rate",error_rate );

        return "jsp/errorRate";
    }


    @RequestMapping("/queryCallLogList2")
    public ModelAndView queryCallLog(QueryInfo queryInfo){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CallLogDAO callLogDAO = applicationContext.getBean(CallLogDAO.class);



        HashMap<String, String> paramMap = new HashMap<>(); paramMap.put("telephone", String.valueOf(queryInfo.getTelephone()));
        paramMap.put("year", String.valueOf(queryInfo.getYear())); paramMap.put("day", String.valueOf(queryInfo.getDay()));


        List<ExamLog> examLogList = callLogDAO.getCallLogList(paramMap);

        Gson gson = new Gson();
        String resultList = gson.toJson(examLogList);



        ModelAndView modelAndView = new ModelAndView(); modelAndView.setViewName("jsp/examLogList");
        modelAndView.addObject("callLogList", resultList); return modelAndView;

    }


        @RequestMapping("/queryContact")
    public ModelAndView query(Contact contact) { ApplicationContext applicationContext = new
            ClassPathXmlApplicationContext("applicationContext.xml");

        ContactDAO contactDAO = applicationContext.getBean(ContactDAO.class);

        HashMap<String, String> paramMap = new HashMap<>(); paramMap.put("id", String.valueOf(contact.getId()));
        List<Contact> contactList = contactDAO.getContactWithId(paramMap);



        ModelAndView modelAndView = new ModelAndView(); modelAndView.setViewName("jsp/queryContact");
        modelAndView.addObject("contacts", contactList); return modelAndView;
    }



    @RequestMapping("/queryContactList") public ModelAndView querylist() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ContactDAO contactDAO = applicationContext.getBean(ContactDAO.class); List<Contact> contactList = contactDAO.getContacts();
        ModelAndView modelAndView = new ModelAndView(); modelAndView.setViewName("jsp/queryContact");
        modelAndView.addObject("contacts", contactList); return modelAndView;
    }
}
