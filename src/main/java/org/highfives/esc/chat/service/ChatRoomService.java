package org.highfives.esc.chat.service;

import org.highfives.esc.chat.dto.ChatRoomDTO;
import org.highfives.esc.chat.vo.ChatRoomRequestVO;
import org.springframework.stereotype.Service;

public interface ChatRoomService {
    ChatRoomDTO findChatRoom(String roomName, int hostId);

    ChatRoomDTO addNewRoom(ChatRoomDTO chatRoomDTO);
}
