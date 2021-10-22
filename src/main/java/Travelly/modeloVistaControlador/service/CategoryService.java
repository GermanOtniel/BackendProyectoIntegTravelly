package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryService extends CrudRepository<Category, Integer> {
}
