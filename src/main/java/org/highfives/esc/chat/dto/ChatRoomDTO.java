package org.highfives.esc.chat.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatRoomDTO {

    private int id; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private int roomHostId; // 채팅방 호스트 id
    private int roomGuestId;
    private LocalDateTime createdDate;

    public ChatRoomDTO(String roomName, int roomHostId, LocalDateTime createdDate) {
        this.roomName = roomName;
        this.roomHostId = roomHostId;
        this.createdDate = createdDate;
    }

    public ChatRoomDTO(int id, String roomName, int roomHostId) {
        this.id = id;
        this.roomName = roomName;
        this.roomHostId = roomHostId;
    }

    public ChatRoomDTO(String roomName, int roomHostId, int roomGuestId, LocalDateTime createdDate) {
        this.roomName = roomName;
        this.roomHostId = roomHostId;
        this.roomGuestId = roomGuestId;
        this.createdDate = createdDate;
    }
}
