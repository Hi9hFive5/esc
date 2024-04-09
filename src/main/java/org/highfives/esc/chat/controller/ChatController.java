package org.highfives.esc.chat.controller;

import org.highfives.esc.chat.service.ChatService;
import org.highfives.esc.chat.service.ChatServiceImpl;
import org.highfives.esc.chat.vo.ChatResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /* /pub/~ 받아서 후처리를 할 수 있다. (MVC구조로 DB에 저장하는 부분이 여기?)  */
    @MessageMapping("/message")
    @SendTo("/sub/message")
    public ResponseEntity<ChatResultVO> getMessageHandler() {



        return null;
    }

    @SendTo("/sub")        // WebsocketConfig - SimpleMessageBroker
    public void sendMEssageHandler() {

    }
}
