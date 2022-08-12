package com.kh.mybatis.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private int no;
	
	private int boardNo;
	
	private int writerNo;
	
	private String writerId;
	
	private String content;	
	
	private Data createDate;
	
	private Data modifyDate;
}
