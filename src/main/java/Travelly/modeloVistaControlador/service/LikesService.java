package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Likes;

import org.springframework.data.repository.CrudRepository;

public interface LikesService extends CrudRepository<Likes, Integer> {
}
