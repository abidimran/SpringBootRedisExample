package com.abid.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value="person", timeToLive = 600L)
public class Person implements Serializable{
	
	private static final long serialVersionUID = -1370089557407175473L;
	@Id
	@Indexed
	private Integer Id;
	private String name;
	private String city;
	
	

}
