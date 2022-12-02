package com.akansh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.akansh.database.DatabaseClass;
import com.akansh.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World", "Akansh"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Akansh"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long id) {
		if (messages.get(id) != null) {
			return messages.get(id);
		}
		return null;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {
		if (messages.get(id) != null) {
			return messages.remove(id);
		}
		return null;

	}

	public List<Message> getMessagesPaginated(int start, int size) {
		return null;
	}

}
