package io.javabrains.srpingbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new Topic("id1",
	 * "name1", "desc1"), new Topic("id2", "name2", "desc2"), new Topic("id3",
	 * "name3", "desc3")));
	 */
	
	public List<Topic> getAllTopics() {
		//return this.topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return this.topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		//this.topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
}
