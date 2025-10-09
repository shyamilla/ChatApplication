package com.application.chatapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chat_rooms")
public class ChatRoom {

    @Id
    private String id;

    private String name;
    private String description;
    private List<String> participantIds; // List of user IDs

    public ChatRoom() {}

    public ChatRoom(String name, String description, List<String> participantIds) {
        this.name = name;
        this.description = description;
        this.participantIds = participantIds;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getParticipantIds() { return participantIds; }
    public void setParticipantIds(List<String> participantIds) { this.participantIds = participantIds; }
}
