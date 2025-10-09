package com.application.chatapp.services;

import com.application.chatapp.model.Attachment;
import com.application.chatapp.repository.AttachmentRepository;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final GridFSBucket gridFSBucket;

    public AttachmentService(AttachmentRepository attachmentRepository, @Value("${spring.data.mongodb.uri}") String mongoUri) {
        this.attachmentRepository = attachmentRepository;

        MongoClient mongoClient = MongoClients.create(mongoUri);
        MongoDatabase database = mongoClient.getDatabase("chatapp");
        this.gridFSBucket = GridFSBuckets.create(database, "attachments");
    }

    public Attachment saveAttachment(InputStream inputStream, String senderId, String receiverId,
                                     String fileName, String fileType, long fileSize) {
        GridFSUploadOptions options = new GridFSUploadOptions();
        ObjectId fileId = gridFSBucket.uploadFromStream(fileName, inputStream, options);

        Attachment attachment = new Attachment();
        attachment.setSenderId(senderId);
        attachment.setReceiverId(receiverId);
        attachment.setFileName(fileName);
        attachment.setFileType(fileType);
        attachment.setFileSize(fileSize);
        attachment.setFileUrl(fileId.toHexString());

        return attachmentRepository.save(attachment);
    }

    public Optional<Attachment> getAttachment(String attachmentId) {
        return attachmentRepository.findById(attachmentId);
    }

    public List<Attachment> getAttachmentsForReceiver(String receiverId) {
        return attachmentRepository.findByReceiverIdOrderByUploadedAtAsc(receiverId);
    }
}
