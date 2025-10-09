package com.application.chatapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class AttachmentDTO {

    @NotBlank
    private String senderId;

    @NotBlank
    private String receiverId;

    private MultipartFile file; // Actual uploaded file

    public AttachmentDTO() {}

    public AttachmentDTO(String senderId, String receiverId, MultipartFile file) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.file = file;
    }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }
}
