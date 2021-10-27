package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.service.CategoryService;
import Travelly.modeloVistaControlador.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryRest {
    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/categories")
    public ResponseEntity<Object> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "/categories/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }
}
