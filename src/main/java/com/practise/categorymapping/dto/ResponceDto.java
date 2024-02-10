package com.practise.categorymapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponceDto {
	
	private int errorcode;
	private String message;
	private Object data;
	
	public ResponceDto(int errorcode, String message) {
		this.errorcode = errorcode;
		this.message = message;
	}

}
