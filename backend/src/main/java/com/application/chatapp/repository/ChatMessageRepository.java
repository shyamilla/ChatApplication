package com.application.chatapp.repository;

import com.application.chatapp.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByReceiverIdOrderByTimestampAsc(String receiverId);
    List<ChatMessage> findByReceiverIdAndReadFalse(String receiverId);
    List<ChatMessage> findBySenderIdOrderByTimestampDesc(String senderId);
}
