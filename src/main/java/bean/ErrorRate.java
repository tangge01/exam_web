package bean;

public class ErrorRate {
   private String question_id;
    private String state;
    private String question_diffculty;
    private String error_rate;

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQuestion_diffculty() {
        return question_diffculty;
    }

    public void setQuestion_diffculty(String question_diffculty) {
        this.question_diffculty = question_diffculty;
    }

    public String getError_rate() {
        return error_rate;
    }

    public void setError_rate(String error_rate) {
        this.error_rate = error_rate;
    }

    @Override
    public String toString() {
        return "ErrorRate{" +
                "question_id='" + question_id + '\'' +
                ", state='" + state + '\'' +
                ", question_diffculty='" + question_diffculty + '\'' +
                ", error_rate='" + error_rate + '\'' +
                '}';
    }
}
