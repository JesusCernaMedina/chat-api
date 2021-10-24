package com.chat.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatData {
	
	private int id;
	private String userId;
	private String userName;
	private String userAvatar;
	private String time;
	private String message;

}
