package org.highfives.esc.chat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.highfives.esc.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class ChatHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = new HashSet<>();
    private final ChatService chatService;

    @Autowired
    public ChatHandler(ChatService chatService) {
        this.chatService = chatService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessions.add(session);

    }

    //양방향 데이터 통신할 떄 해당 메서드가 call 된다.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println("message = " + message.getPayload());
        //do something
        final String sessionId = session.getId();
//        sessions.values().forEach((s) -> {
//
//            if (!s.getId().equals(sessionId) && s.isOpen()) {
//                try {
//                    s.sendMessage(message);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
        /* 저장된 세션 중 현재 WebSession 의 getId와 같은 세션에 대해서는 메세지를 보내지 않고, 나머지 세션에는 메세지를 보냄 */
        for (WebSocketSession connectedSession : sessions) {
            if(!connectedSession.getId().equals(session.getId()))
                connectedSession.sendMessage(message);
        }



    }

    //웹소켓 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        final String sessionId = session.getId();
        final String leaveMessage = sessionId + "님이 떠났습니다.";
        sessions.remove(session); // 삭제
        System.out.println("유저가 떠남");
        //메시지 전송
//        sessions.values().forEach((s) -> {
//
//            if (!s.getId().equals(sessionId) && s.isOpen()) {
//                try {
//                    s.sendMessage(new TextMessage(leaveMessage));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });



    }

    //통신 에러 발생 시
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {


    }

}
