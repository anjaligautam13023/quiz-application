package com.example.schedulequiz;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Scheduledquiz {
    @Id
    String _id;
    Integer qno;
    String title;
    String topic;
    String stdate;

    Integer questionid;

    public int getId() {
        return questionid;
    }

    public void setId(int id) {
        this.questionid = id;
    }

    String endate;

    public int getQno() {
        return qno;
    }
    private List<Integer> questionids;

    public List<Integer> getQuestionids() {
        return questionids;
    }

    public void setQuestionids(List<Integer> questionids) {
        this.questionids = questionids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStdate() {
        return stdate;
    }

    public void setStdate(String stdate) {
        this.stdate = stdate;
    }
}
