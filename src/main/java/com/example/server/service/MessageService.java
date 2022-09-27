package com.example.server.service;


import com.example.server.model.Message;
import com.example.server.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@AllArgsConstructor
public class MessageService {
    MessageRepository repository;

    public void saveMessage(Message message) {
        repository.save(message);
    }

    public List<Message> getMessages() {
        return repository.findAll();
    }

    public Message getMessageById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Message with id= " + id + " not found!"));
    }

    public void updateMessage(Long id, Message message) {
        getMessageById(id);
        repository.save(message);
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }
}