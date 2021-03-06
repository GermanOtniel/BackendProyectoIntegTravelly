package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.Likes;
import Travelly.modeloVistaControlador.service.LikesService;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @DeleteMapping(path = "/likes/user/{userId}/recommendation/{recommId}")
    public ResponseEntity<Object> deleteLikeByUser(
            @PathVariable("userId") Integer userId,
            @PathVariable("recommId") Integer recommId) {
        List<Likes> likesToDelete = likesService.findByUserIdAndRecommendationId(userId, recommId);
        for(Likes like: likesToDelete) {
            likesService.deleteById(like.getLikesId());
        }
        return new ResponseEntity<>("{\"text\":\"Unliked successfully\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/likes")
    public ResponseEntity<Object> createLike(@RequestBody Likes like) {
        likesService.save(like);
        return new ResponseEntity<>("{\"text\":\"Like is created successfully\"}", HttpStatus.CREATED);
    }
}
