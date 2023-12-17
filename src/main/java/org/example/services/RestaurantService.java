package org.example.services;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    
    private RestaurantRepository restaurantRepository;
    
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

}
