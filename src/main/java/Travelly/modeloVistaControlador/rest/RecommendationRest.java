package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.Media;
import Travelly.modeloVistaControlador.service.MediaService;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.Recommendation;
import Travelly.modeloVistaControlador.service.RecommendationService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecommendationRest {
    @Autowired
    RecommendationService recommendationService;

    @Autowired
    MediaService mediaService;

    @GetMapping(path = "/recommendations")
    public ResponseEntity<Object> getRecommendations() {

        return new ResponseEntity<>(recommendationService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "/recommendations/{id}")
    public ResponseEntity<Object> getRecommendation(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(recommendationService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/recommendations/{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Integer id, @RequestBody Recommendation recommendation) {

        Recommendation updatedRecommendation= recommendationService.findById(id).get();
        updatedRecommendation.setSummary(recommendation.getSummary());

        return new ResponseEntity<>("Recommendation is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/recommendations/{id}")
    public ResponseEntity<Object> deleteRecommendation(@PathVariable("id") Integer id) {
        recommendationService.deleteById(id);
        return new ResponseEntity<>("Recommendations is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/recommendations")
    public ResponseEntity<Object> createRecommendation(@RequestBody Recommendation recommendation) {
        Recommendation recomm = recommendationService.save(recommendation);
        for (Media media: recommendation.getUploadedMedia()) {
            media.setRecommendationId(recomm.getRecommID());
            mediaService.save(media);
        }
        //String basePath = "src/main/resources/public/";
//        for (Media media : recommendation.getUploadedMedia()) {
//            byte[] data = Base64.decodeBase64(media.getContent());
//            Date date = new Date();
//            String fileName = "media-uploaded/" + date.getTime() + ".png";
//            try (OutputStream stream = new FileOutputStream(basePath + fileName)) {
//                stream.write(data);
//                media.setContent(fileName);
//                media.setRecommendationId(recomm.getRecommID());
//                mediaService.save(media);
//            } catch (Exception e) {
//                return new ResponseEntity<>("{\"text\": \"Unable to save some images\"}", HttpStatus.CONFLICT);
//            }
//        }

        return new ResponseEntity<>("{\"text\": \"Recommendation is created successfully\"}", HttpStatus.CREATED);
    }

    @GetMapping(path= "/recommendations/category/{name}")
    public ResponseEntity<Object> getRecommendationsByCategory(@PathVariable("name") String category) {
        List<Recommendation> recommendations = recommendationService.findAllByCategory(category);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }

}
