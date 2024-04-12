package org.highfives.esc.chat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ChatHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        final String sessionId = session.getId();
        final String enteredMessage = sessionId + "님이 입장하셨습니다.";
        sessions.put(sessionId, session);

        sessions.values().forEach((s) -> {

            try {
                if(!s.getId().equals(sessionId) && s.isOpen()) {

                    s.sendMessage(new TextMessage(enteredMessage));
                }
            } catch ( IOException e ) {}
        });
    }

    //양방향 데이터 통신할 떄 해당 메서드가 call 된다.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        //do something
        final String sessionId = session.getId();
        sessions.values().forEach((s) -> {

            if (!s.getId().equals(sessionId) && s.isOpen()) {
                try {
                    s.sendMessage(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    //웹소켓 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        final String sessionId = session.getId();
        final String leaveMessage = sessionId + "님이 떠났습니다.";
        sessions.remove(sessionId); // 삭제

        //메시지 전송
        sessions.values().forEach((s) -> {

            if (!s.getId().equals(sessionId) && s.isOpen()) {
                try {
                    s.sendMessage(new TextMessage(leaveMessage));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }

    //통신 에러 발생 시
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {


    }

}
