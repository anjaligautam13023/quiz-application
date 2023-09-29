package com.example.questionService;

import org.springframework.data.annotation.Id;

public class QuestionWrapper {
	@Id
    String _id; 
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	} 
	int qno;
    String a;
	String b;
	String c;
	String d;
	String question;
	
	public QuestionWrapper() {
		super();
		this._id = _id;
		this.qno = qno;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "QuestionWrapper [qno=" + qno + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", question=" + question + "]";
	}

	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
