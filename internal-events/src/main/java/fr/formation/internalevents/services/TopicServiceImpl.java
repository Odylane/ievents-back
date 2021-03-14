package fr.formation.internalevents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.internalevents.dtos.TopicCreateDto;
import fr.formation.internalevents.dtos.TopicDto;
import fr.formation.internalevents.entities.Topic;
import fr.formation.internalevents.repositories.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	private final TopicRepository topicRepo;

	public TopicServiceImpl(TopicRepository topicRepo) {
		this.topicRepo = topicRepo;
	}

	@Override
	public List<TopicDto> getAll() {
		return topicRepo.getAllProjected();
	}

	@Override
	public void create(TopicCreateDto dto) {

		Topic topic = new Topic();
		topic.setName(dto.getName());
		topicRepo.save(topic);
	}

	@Override
	public boolean uniqueName(String value) {

		return !topicRepo.existsByName(value);
	}

}
