package com.application.chatapp.repository;

import com.application.chatapp.model.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
    List<Attachment> findByReceiverIdOrderByUploadedAtAsc(String receiverId);
    List<Attachment> findBySenderIdOrderByUploadedAtDesc(String senderId);
}
