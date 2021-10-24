package com.chat.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	String sql_chat = "SELECT * FROM chat";
	
	@GetMapping
	public ResponseEntity<List<ChatData>> getProduct() {
		List<ChatData> listChat = jdbc.query(sql_chat, new RowMapper<ChatData>() {

			@Override
			public ChatData mapRow(ResultSet rs, int rowNum) throws SQLException {
				ChatData chat = new ChatData();
				chat.setId(rs.getInt("id"));
				chat.setUserId(rs.getString("userId"));
				chat.setUserName(rs.getString("userId"));
				chat.setUserAvatar(rs.getString("userAvatar"));
				chat.setTime(rs.getString("time"));
				chat.setMessage(rs.getString("message"));
				return chat;
			}
			
		});
		return ResponseEntity.ok(listChat);
	}
}
