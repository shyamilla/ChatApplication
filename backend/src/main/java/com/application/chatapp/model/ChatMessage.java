package com.application.chatapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chat_messages")
public class ChatMessage {

    @Id
    private String id;

    private String senderId;
    private String receiverId;
    private String content;
    private String attachmentId; // Optional
    private Date timestamp;
    private boolean read;

    public ChatMessage() {
        this.timestamp = new Date();
        this.read = false;
    }

    public ChatMessage(String senderId, String receiverId, String content, String attachmentId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.attachmentId = attachmentId;
        this.timestamp = new Date();
        this.read = false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }
}
