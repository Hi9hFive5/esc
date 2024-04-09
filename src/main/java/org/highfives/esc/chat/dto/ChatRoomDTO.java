package org.highfives.esc.chat.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ChatRoomDTO {

    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private long userCount; // 채팅방 인원수
    private HashMap<String, String> userlist = new HashMap<String, String>();

    public ChatRoomDTO create(String roomName){
        ChatRoomDTO chatRoom = new ChatRoomDTO();
        chatRoom.roomId = UUID.randomUUID().toString(); // 채팅방 ID 무작위 생성
        chatRoom.roomName = roomName;                   // 입력한 채팅방 이름

        return chatRoom;
    }
}
