package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.entity.Chat;
import com.example.chatapp.src.chat.entity.ChatImage;
import com.example.chatapp.src.chat.entity.ChatType;
import com.example.chatapp.src.chat.entity.Room;
import com.example.chatapp.src.chat.model.MessageModel;
import com.example.chatapp.src.chat.model.RoomModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Transactional
@Repository
@Primary
public class JPAChatRepository implements ChatRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public RoomModel createRoom(String name) {
        Room room = new Room();
        room.setName(name);
        room.setRoomCode(UUID.randomUUID().toString());

        em.persist(room);
        log.debug("room = {}", room);

        RoomModel model = new RoomModel();
        model.setRoomName(room.getName());
        model.setRoomCode(room.getRoomCode());
        return model;
    }

    @Override
    public List<RoomModel> findAllRooms() {
        List<Room> rooms = em.createQuery("select r from Room as r", Room.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        List<RoomModel> result = new ArrayList<>();
        for (Room r :
                rooms) {
            result.add(
                    new RoomModel(r.getId(),
                            r.getRoomCode(),
                            r.getName(),
                            r.getProfileImgUrl(),
                            r.getUpdated()
                    ));
        }
        return result;
    }

    @Override
    public RoomModel findRoomByRoomCode(String roomCode) {
        Room r = em.createQuery("select r from Room r where r.roomCode = '"+roomCode + "'",
                        Room.class)
                .getSingleResult();

        return new RoomModel(r.getId(),
                r.getRoomCode(),
                r.getName(),
                r.getProfileImgUrl(),
                r.getUpdated()
        );
    }

    @Override
    public RoomModel findRoomById(Long roomId) {
        Room r = em.find(Room.class, roomId);

        return new RoomModel(r.getId(),
                r.getRoomCode(),
                r.getName(),
                r.getProfileImgUrl(),
                r.getUpdated()
        );
    }

    @Override
    public long addChat(MessageModel messageModel) {
        Chat c;
        if (messageModel.getType() == "IMAGE")
            c = new ChatImage();
        else c= new Chat();

        Room r = em.createQuery("select r from Room r where r.roomCode = '"+ messageModel.getRoomCode() + "'",
                        Room.class)
                .getSingleResult();

        c.setRoom(r);
        ChatType type;
        try{
            type = ChatType.valueOf(messageModel.getType());
        } catch(Exception e ) {
            type = ChatType.ERROR;
        }
        c.setType(type);
        if (c instanceof ChatImage) {
            ((ChatImage) c).setImageUrl(messageModel.getMessage());
        } else {
            c.setContent(messageModel.getMessage());
        }

        //todo : user 정보 입력하기
//        User u = e.creteQuery()...;
//        c.setUser(u);

        em.persist(c);
        return c.getId();
    }
}
