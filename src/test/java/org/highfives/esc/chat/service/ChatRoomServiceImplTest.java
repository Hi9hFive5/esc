package org.highfives.esc.chat.service;

import jakarta.transaction.Transactional;
import org.highfives.esc.chat.dto.ChatRoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatRoomServiceImplTest {

    @Autowired
    private ChatRoomService chatRoomService;

    static Stream<Arguments> chatRoomInfo() {

        return Stream.of(
                Arguments.of("토익 990점 목표방!!", 1),
                Arguments.of("IELTS 보실 분 모아봐요", 3)
        );
    }

    static Stream<Arguments> chatRoomDTO() {

        return Stream.of(
                Arguments.of(new ChatRoomDTO("토익 990점 목표방!!", 1, 2, LocalDateTime.now())),
                Arguments.of(new ChatRoomDTO("IELTS 보실 분 모아봐요", 3, 4, LocalDateTime.now()))
        );
    }

    @DisplayName("채팅방 제목과 호스트 ID로 채팅방 조회")
    @ParameterizedTest
    @MethodSource("chatRoomInfo")
    void findChatRoomTest(String roomName, int hostId) {

        Assertions.assertDoesNotThrow(
                () -> chatRoomService.findChatRoom(roomName, hostId)
        );
    }

    @DisplayName("ChatRoomDTO 가지고 새 채팅방 생성")
    @ParameterizedTest
    @MethodSource("chatRoomDTO")
    @Transactional
    void addNewRoomTest(ChatRoomDTO chatRoomDTO) {

        Assertions.assertDoesNotThrow(
                () -> chatRoomService.addNewRoom(chatRoomDTO)
        );
    }
}