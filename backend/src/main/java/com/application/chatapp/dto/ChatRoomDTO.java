package com.application.chatapp.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatRoomDTO {

    @NotBlank
    private String name;

    private String description; // Optional

    public ChatRoomDTO() {}

    public ChatRoomDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
