package org.highfives.esc.chat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomRequestVO {
    private int roomId;
    private String roomName;
    private int roomHostId;
}
