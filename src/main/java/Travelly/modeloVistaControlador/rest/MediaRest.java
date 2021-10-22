package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.Media;
import Travelly.modeloVistaControlador.service.MediaService;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MediaRest {
  @Autowired
  MediaService mediaService;

  @GetMapping(path = "/media")
    public ResponseEntity<Object> getMedia() {
        return new ResponseEntity<>(mediaService.findAll(), HttpStatus.OK);
    }
  
    @PutMapping(path = "/media/{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Integer id, @RequestBody Media media) {

        Media updatedMedia= mediaService.findById(id).get();
        updatedMedia.setContent(media.getContent());
        updatedMedia.setMediaType(media.getMediaType());

        return new ResponseEntity<>("Media is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/media/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        mediaService.deleteById(id);
        return new ResponseEntity<>("Media is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/media")
    public ResponseEntity<Object> createMedia(@RequestBody Media media) {

        mediaService.save(media);
        return new ResponseEntity<>("Media is created successfully", HttpStatus.CREATED);
    }
}
