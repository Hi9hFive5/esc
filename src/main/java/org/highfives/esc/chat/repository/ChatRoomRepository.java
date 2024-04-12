package org.highfives.esc.chat.repository;


import org.highfives.esc.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

    @Query("SELECT r FROM chat_room r WHERE r.roomName = :roomName AND r.roomHostId = :hostId")
    ChatRoom findByNameAndHost(@Param("roomName") String roomName, @Param("hostId") int hostId);
}
