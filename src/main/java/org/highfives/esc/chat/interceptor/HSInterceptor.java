package org.highfives.esc.chat.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
public class HSInterceptor implements HandshakeInterceptor {

    //    @Override
//    public boolean beforeHandshake(ServerHttpRequest request,
//                                   ServerHttpResponse response, WebSocketHandler wsHandler,
//                                   Map<String, Object> attributes) throws Exception {
//        String path = request.getURI().getPath();
//
//        System.out.println("path = " + path);
//        String roomId = path.substring(path.lastIndexOf('/') + 1);
//        System.out.println("roomId = " + roomId);
//        attributes.put("roomId", roomId);
//        return true;
//    }
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response,
                                   WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        String path = request.getURI().getPath();
        String roomId = path.substring(path.lastIndexOf('/') + 1);

        /* http://~/chat/{roomId} 에서 roomId부분을 따로 떼서 Map으로 저장*/
        attributes.put("roomId", roomId);

        System.out.println("uri = " + request.getURI());
        System.out.println("path = " + path);
        System.out.println("roomId = " + roomId);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response,
                               WebSocketHandler wsHandler,
                               Exception exception) {

    }
}