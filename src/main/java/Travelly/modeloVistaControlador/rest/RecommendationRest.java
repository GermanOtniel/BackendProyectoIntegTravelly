package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.model.User;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.Recommendation;
import Travelly.modeloVistaControlador.service.RecommendationService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecommendationRest {
    @Autowired
    RecommendationService recommendationService;

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
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        recommendationService.deleteById(id);
        return new ResponseEntity<>("Recommendations is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/recommendations")
    public ResponseEntity<Object> createUser(@RequestBody Recommendation recommendation) {
        /*User newUser = new User();
        newUser.setBirthday(user.getBirthday());
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setProfilePicture(user.getProfilePicture());
        newUser.setTelephone(user.getTelephone());*/
        recommendationService.save(recommendation);
        return new ResponseEntity<>("Recommendation is created successfully", HttpStatus.CREATED);
    }

}
