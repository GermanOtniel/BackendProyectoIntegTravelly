package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.Following;
import Travelly.modeloVistaControlador.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.Chat;
import Travelly.modeloVistaControlador.service.ChatService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatRest {
    @Autowired
    ChatService chatService;

    @GetMapping(path = "/chats")
    public ResponseEntity<Object> getChats() {

        return new ResponseEntity<>(chatService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "/chats/{id}")
    public ResponseEntity<Object> getChat(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(chatService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/chats/{id}")
    public ResponseEntity<Object>
    updateFollowing(@PathVariable("id") Integer id, @RequestBody Chat chat) {

        Chat updatedChat = chatService.findById(id).get();
        updatedChat.setSeen(chat.getSeen());
        chatService.save(updatedChat);

        return new ResponseEntity<>(" Chat is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/chats/{id}")
    public ResponseEntity<Object> deleteChat(@PathVariable("id") Integer id) {
        chatService.deleteById(id);
        return new ResponseEntity<>("Chat is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/chats")
    public ResponseEntity<Object> createChat(@RequestBody Chat chat) {
        chatService.save(chat);
        return new ResponseEntity<>("{\"text\": \"Chat is created successfully\"}", HttpStatus.CREATED);
    }

    @GetMapping(path = "/chats/user/{userId}/with/{otherUserId}")
    public ResponseEntity<Object> getChatBetweenUsers(@PathVariable("userId") Integer userId, @PathVariable("otherUserId") Integer otherUserId) {
        return new ResponseEntity<>(chatService.findConversation(userId, otherUserId), HttpStatus.OK);
    }
}
