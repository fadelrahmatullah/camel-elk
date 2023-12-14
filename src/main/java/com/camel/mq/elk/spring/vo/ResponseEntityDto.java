package com.camel.mq.elk.spring.vo;


import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ResponseEntityDto<T> implements Serializable {
	private static final long serialVersionUID = -720807478055084231L;
	public static final String RESPONSE_OK = "1"; 
	public static final String RESPONSE_ERROR = "0"; 
	
	private String processFinishDate;
	private String errorCode;
	private String msg;
	private T data;

	public ResponseEntityDto(){
		
	}
	
	
	public ResponseEntityDto(String errorCode, String msg, T data){
		this.processFinishDate = dateFormat();
		this.errorCode = errorCode;
		this.msg = msg;
		this.data = data;
	}

	private String dateFormat(){

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		Date date = new Date();

		return sdf.format(date);
	}
	
	public <T> ResponseEntityDto<T> succesResponse(T data) {
		return new ResponseEntityDto<>(RESPONSE_OK, "Success", data);
	}

	public <T> ResponseEntityDto<T> errorResponse(String msg) {
		return new ResponseEntityDto<>(RESPONSE_ERROR, msg, null);
	}


}
