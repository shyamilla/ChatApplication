package com.application.chatapp.controllers;

import com.application.chatapp.model.Attachment;
import com.application.chatapp.services.AttachmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    // Upload a file
    @PostMapping("/upload")
    public ResponseEntity<Attachment> uploadAttachment(@RequestParam("file") MultipartFile file,
                                                       @RequestParam String senderId,
                                                       @RequestParam String receiverId) throws IOException {
        Attachment savedAttachment = attachmentService.saveAttachment(
                file.getInputStream(),
                senderId,
                receiverId,
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize()
        );
        return ResponseEntity.ok(savedAttachment);
    }

    // Get all attachments for a receiver
    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<Attachment>> getAttachmentsForReceiver(@PathVariable String receiverId) {
        List<Attachment> attachments = attachmentService.getAttachmentsForReceiver(receiverId);
        return ResponseEntity.ok(attachments);
    }

    // Get a single attachment metadata by ID
    @GetMapping("/{attachmentId}")
    public ResponseEntity<Optional<Attachment>> getAttachment(@PathVariable String attachmentId) {
        return ResponseEntity.ok(attachmentService.getAttachment(attachmentId));
    }

    // Optionally, add endpoint to download file from GridFS (stream)
}
