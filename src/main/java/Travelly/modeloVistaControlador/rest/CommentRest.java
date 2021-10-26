package Travelly.modeloVistaControlador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.Comment;
import Travelly.modeloVistaControlador.service.CommentService;

@Controller
public class CommentRest {
    @Autowired
    CommentService commentService;

    @GetMapping(path = "/comments")
    public ResponseEntity<Object> getComments() {

        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "/comments/{id}")
    public ResponseEntity<Object> getComment(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/comments/{id}")
    public ResponseEntity<Object>
    updateComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {

      Comment updatedComment= commentService.findById(id).get();
        updatedComment.setComment(comment.getComment());
        commentService.save(updatedComment);

        return new ResponseEntity<>(" Comment is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/comments/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        commentService.deleteById(id);
        return new ResponseEntity<>("Comment is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/comments")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<>("Comment is created successfully", HttpStatus.CREATED);
    }
}
