package org.highfives.esc.chat.controller;

import lombok.RequiredArgsConstructor;
import org.highfives.esc.chat.service.ChatRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 리스트 가져오기 - 1:1 채팅일건데 채팅방 리스트는 필요 없는거 아닌지?


    // 채팅
}
