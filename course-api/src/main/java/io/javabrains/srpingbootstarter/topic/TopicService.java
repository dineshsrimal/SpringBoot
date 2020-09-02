package io.javabrains.srpingbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("id1", "name1", "desc1"), 
			new Topic("id2", "name2", "desc2"),
			new Topic("id3", "name3", "desc3")));
	
	public List<Topic> getAllTopics() {
		return this.topics;
	}
	
	public Topic getTopic(String id) {
		return this.topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}
}
