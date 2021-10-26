package Travelly.modeloVistaControlador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.Following;
import Travelly.modeloVistaControlador.service.FollowingService;

@Controller
public class FollowingRest {
    @Autowired
    FollowingService followingService;

    @GetMapping(path = "/followings")
    public ResponseEntity<Object> getFollowings() {

        return new ResponseEntity<>(followingService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "/followings/{id}")
    public ResponseEntity<Object> getFollowing(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(followingService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/followings/{id}")
    public ResponseEntity<Object>
    updateFollowing(@PathVariable("id") Integer id, @RequestBody Following following) {

        Following updatedFollowing = followingService.findById(id).get();
        updatedFollowing.setUser(following.getUser());
        updatedFollowing.setFollowedUser(following.getFollowedUser());
        followingService.save(updatedFollowing);

        return new ResponseEntity<>(" Following is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/followings/{id}")
    public ResponseEntity<Object> deleteFollowing(@PathVariable("id") Integer id) {
        followingService.deleteById(id);
        return new ResponseEntity<>("Following is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/followings")
    public ResponseEntity<Object> createCFollowing(@RequestBody Following following) {
        followingService.save(following);
        return new ResponseEntity<>("Following is created successfully", HttpStatus.CREATED);
    }
}
