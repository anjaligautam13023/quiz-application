package com.anjali.QuizService;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;

public class quiz {
	@Id
    String _id; 
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
    private Integer no;
    private String title;
 
    private List<Integer>questionids;
	public Integer getId() {
		return no;
	}
	public void setId(Integer id) {
		this.no = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestion() {
		return questionids;
	}
	public void setQuestion(List<Integer> question) {
		this.questionids = question;
	}
	@Override
	public String toString() {
		return "quiz [id=" + no + ", title=" + title + ", question=" + questionids + "]";
	}
}
