package ku.message.service;

import ku.message.dto.MessageDto;
import ku.message.model.Message;
import ku.message.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MessageService
{
	@Autowired
	private MessageRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	// we are mapping DAO → DTO
	public List<MessageDto> getMessages()
	{
		List<Message> messages = repository.findAll();

		List<MessageDto> dtos = messages
				.stream()
				.map(message -> modelMapper.map(message, MessageDto.class))
				.collect(Collectors.toList());

		return dtos;
	}

	// we are mapping DTO → DAO
	public void createMessage(MessageDto messageDto, String username)
	{
		Message message = modelMapper.map(messageDto, Message.class);
		message.setUser(username);
		message.setCreatedAt(Instant.now());
		repository.save(message);
	}
}
