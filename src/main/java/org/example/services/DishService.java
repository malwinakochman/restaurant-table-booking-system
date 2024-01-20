package org.example.services;

import org.example.models.Dish;
import org.example.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;


    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish getDish(Integer id) {
        return dishRepository.findById(id).orElse(null);
    }

    public void deleteDish(Integer id) {
        dishRepository.deleteById(id);
    }

    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    public Dish getDishByName(String name) {
        return dishRepository.findByDishName(name);
    }
}
