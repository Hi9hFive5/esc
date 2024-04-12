package org.highfives.esc.chat.controller;

import lombok.RequiredArgsConstructor;
import org.highfives.esc.chat.dto.ChatRoomDTO;
import org.highfives.esc.chat.entity.Chat;
import org.highfives.esc.chat.service.ChatRoomService;
import org.highfives.esc.chat.vo.ChatResponseVO;
import org.highfives.esc.chat.vo.ChatRoomRequestVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/chat/room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ModelMapper modelMapper;


    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService, ModelMapper modelMapper) {
        this.chatRoomService = chatRoomService;
        this.modelMapper = modelMapper;
    }

    /* 채팅방 조회
     *  채팅하기 클릭 시 기존 채팅방이 있는지 DB에서 확인 후 결과 반환
    * */
    @GetMapping("/{roomId}")
    public ResponseEntity<ChatRoomRequestVO> findChatRoom(@PathVariable("roomName") String roomName) {

        // hostId 는 JWT 토큰으로부터 가져오기
        int hostId = 0;

        ChatRoomDTO chatRoomDTO = chatRoomService.findChatRoom(roomName, hostId);
        ChatRoomRequestVO result = modelMapper.map(chatRoomDTO, ChatRoomRequestVO.class);



        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    /* 채팅방 생성
     * 채팅하기 클릭 시 게시글 제목 + 생성자 Id 가지고 와서 채팅방 만듬
    * */
    @PostMapping("/{roomId}")
    public ResponseEntity<ChatRoomRequestVO> addNewRoom(@PathVariable("roomName") String roomName) {

        // hostId 는 토큰에서 가져오기
        // guestId 는 어디서 가져와야하지 고민좀 해봐야함
        int hostId = 0;

        ChatRoomDTO chatRoomDTO = new ChatRoomDTO(
                roomName,
                hostId,
                LocalDateTime.now()
        );

        chatRoomDTO = chatRoomService.addNewRoom(chatRoomDTO);

        ChatRoomRequestVO result = modelMapper.map(chatRoomDTO, ChatRoomRequestVO.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);

    }

}
