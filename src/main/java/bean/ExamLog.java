package bean;

/**
 * 用于存放返回给用户的数据
 */
public class ExamLog {
    private String exam_id;
    private String start_date;
    private String class_name;
    private String stu_id;
    private String stu_name;
    private String true_rate;
    private String stage;
    private String question_difficulty;

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getTrue_rate() {
        return true_rate;
    }

    public void setTrue_rate(String true_rate) {
        this.true_rate = true_rate;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getQuestion_difficulty() {
        return question_difficulty;
    }

    public void setQuestion_difficulty(String question_difficulty) {
        this.question_difficulty = question_difficulty;
    }

    @Override
    public String toString() {
        return "ExamLog{" +
                "exam_id='" + exam_id + '\'' +
                ", start_date='" + start_date + '\'' +
                ", class_name='" + class_name + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", true_rate='" + true_rate + '\'' +
                ", stage='" + stage + '\'' +
                ", question_difficulty='" + question_difficulty + '\'' +
                '}';
    }
}
