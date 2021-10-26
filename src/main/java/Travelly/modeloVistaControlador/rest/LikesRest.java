package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.Likes;
import Travelly.modeloVistaControlador.service.LikesService;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LikesRest {

    @Autowired
    LikesService likesService;

    @GetMapping(path = "/likes")
    public ResponseEntity<Object> getLikes() {
        return new ResponseEntity<>(likesService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/likes/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        likesService.deleteById(id);
        return new ResponseEntity<>("Like is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/likes")
    public ResponseEntity<Object> createLike(@RequestBody Likes like) {

        likesService.save(like);
        return new ResponseEntity<>("Like is created successfully", HttpStatus.CREATED);
    }
}
