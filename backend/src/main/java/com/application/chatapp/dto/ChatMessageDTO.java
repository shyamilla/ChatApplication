package com.application.chatapp.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatMessageDTO {

    @NotBlank
    private String senderId;

    @NotBlank
    private String receiverId;

    @NotBlank
    private String content;

    private String attachmentId; // Optional, for messages with attachments

    public ChatMessageDTO() {}

    public ChatMessageDTO(String senderId, String receiverId, String content, String attachmentId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.attachmentId = attachmentId;
    }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAttachmentId() { return attachmentId; }
    public void setAttachmentId(String attachmentId) { this.attachmentId = attachmentId; }
}
