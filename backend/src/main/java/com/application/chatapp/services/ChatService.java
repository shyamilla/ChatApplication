package com.application.chatapp.services;

import com.application.chatapp.model.ChatMessage;
import com.application.chatapp.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(String receiverId) {
        return chatMessageRepository.findByReceiverIdOrderByTimestampAsc(receiverId);
    }

    public List<ChatMessage> getUnreadMessages(String receiverId) {
        return chatMessageRepository.findByReceiverIdAndReadFalse(receiverId);
    }

    public Optional<ChatMessage> getMessageById(String messageId) {
        return chatMessageRepository.findById(messageId);
    }
}
