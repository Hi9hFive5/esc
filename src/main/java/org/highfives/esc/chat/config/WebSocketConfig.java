package org.highfives.esc.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {

        /* 클라이언트에서 웹소켓에 접속할 수 있는 endpoint 경로 지정 */
        registry.addEndpoint("/ws")  // ex) ws://localhost:8080/our-websocket
                .setAllowedOrigins("*")          // CORS 설정(일단은 전부 통과되게)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub")      // / /app으로 시작하는 메시지만 해당 브로커에서 받아서 처리한다.
                .enableSimpleBroker("/sub");  // 해당 브로커를 구독하는 클라이언트에게 메세지를 보냄.
    }
}
