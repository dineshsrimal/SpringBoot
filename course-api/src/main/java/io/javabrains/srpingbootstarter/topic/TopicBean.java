package io.javabrains.srpingbootstarter.topic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TopicBean {
	
	private String name;
	private int version;	
	
	public TopicBean() {
		this.name = "My Bean";
		this.version = 1;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "TopicBean [name=" + name + ", version=" + version + "]";
	}

}
