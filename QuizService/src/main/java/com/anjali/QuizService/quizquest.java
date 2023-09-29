package com.anjali.QuizService;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;


public class quizquest {
	@Id
    String _id; 
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	int qno;
	String diff;
	String topic;
	String a;
	String b;
	String c;
	String d;
	String question;
	String answer;
	
	@Override
	public String toString() {
		return "quizquest [qno=" + qno + ", diff=" + diff + ", topic=" + topic + ", a=" + a + ", b=" + b + ", c=" + c
				+ ", d=" + d + ", question=" + question + ", answer=" + answer + "]";
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

}
