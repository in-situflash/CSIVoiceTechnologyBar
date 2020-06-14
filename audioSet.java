package com.chinasoft.pojo;

//import java.util.Date;

public class audioSet {
	
	private int v_id;
	private String username;
	private String voicetype;
	//private Date create_time;
	private int speed;
	private int tone;
	private int volume;
	//private int userid;
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVoicetype() {
		return voicetype;
	}
	public void setVoicetype(String voicetype) {
		this.voicetype = voicetype;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getTone() {
		return tone;
	}
	public void setTone(int tone) {
		this.tone = tone;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public audioSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public audioSet(int v_id, String username, String voicetype, int speed, int tone, int volume) {
		super();
		this.v_id = v_id;
		this.username = username;
		this.voicetype = voicetype;
		this.speed = speed;
		this.tone = tone;
		this.volume = volume;
	}
	public audioSet(String username, String voicetype, int speed, int tone, int volume) {
		super();
		this.username = username;
		this.voicetype = voicetype;
		this.speed = speed;
		this.tone = tone;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "audioSet [v_id=" + v_id + ", username=" + username + ", voicetype=" + voicetype + ", speed=" + speed
				+ ", tone=" + tone + ", volume=" + volume + "]";
	}
	
	
}
