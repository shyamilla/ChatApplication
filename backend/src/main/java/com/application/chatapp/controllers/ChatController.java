package com.application.chatapp.controllers;

import com.application.chatapp.dto.ChatMessageDTO;
import com.application.chatapp.model.ChatMessage;
import com.application.chatapp.services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // Send a message
    @PostMapping("/send")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessageDTO messageDTO) {

        String senderId = SecurityContextHolder.getContext().getAuthentication().getName();

        ChatMessage message = new ChatMessage();
        message.setSenderId(senderId);
        message.setReceiverId(messageDTO.getReceiverId());
        message.setContent(messageDTO.getContent());
        message.setTimestamp(new Date());
        message.setRead(false);

        ChatMessage savedMessage = chatService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    // Get chat history for a receiver
    @GetMapping("/history/{receiverId}")
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable String receiverId) {
        List<ChatMessage> messages = chatService.getChatHistory(receiverId);
        return ResponseEntity.ok(messages);
    }

    // Get unread messages
    @GetMapping("/unread/{receiverId}")
    public ResponseEntity<List<ChatMessage>> getUnreadMessages(@PathVariable String receiverId) {
        List<ChatMessage> messages = chatService.getUnreadMessages(receiverId);
        return ResponseEntity.ok(messages);
    }
}
