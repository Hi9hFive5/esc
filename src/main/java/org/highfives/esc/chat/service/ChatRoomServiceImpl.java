package org.highfives.esc.chat.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.chat.dto.ChatRoomDTO;
import org.highfives.esc.chat.entity.ChatRoom;
import org.highfives.esc.chat.repository.ChatRoomRepository;
import org.highfives.esc.chat.vo.ChatRoomRequestVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatRoomServiceImpl implements ChatRoomService{

    private final ChatRoomRepository chatRoomRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, ModelMapper modelMapper) {
        this.chatRoomRepository = chatRoomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatRoomDTO findChatRoom(String roomName, int hostId) {

        ChatRoom chatRoom = chatRoomRepository.findByNameAndHost(roomName, hostId);

        ChatRoomDTO result = modelMapper.map(chatRoom, ChatRoomDTO.class);

        log.info("result 로그 { }" , result);

        return result;
    }

    @Override
    @Transactional
    public ChatRoomDTO addNewRoom(ChatRoomDTO chatRoomDTO) {

        ChatRoom newChatRoom = modelMapper.map(chatRoomDTO, ChatRoom.class);
        newChatRoom.setUseStatus("Y");
        chatRoomRepository.save(newChatRoom);

        ChatRoomDTO result = modelMapper.map(
                chatRoomRepository.findByNameAndHost(chatRoomDTO.getRoomName(), chatRoomDTO.getRoomHostId()),
                ChatRoomDTO.class);

        return result;
    }
}
