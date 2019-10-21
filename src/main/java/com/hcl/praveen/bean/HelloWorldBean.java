package com.hcl.praveen.bean;

public class HelloWorldBean  {
  private String message;

public HelloWorldBean(String message) {
	
	this.message = message;
}

public String getMessage() {
	return message;
}

private void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "HelloWorldBean [message=" + message + "]";
}


  
}
