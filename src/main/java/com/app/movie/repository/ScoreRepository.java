/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;


import com.app.movie.entities.Score;
import com.app.movie.interfaces.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ScoreRepository {
    
    @Autowired
    IScoreRepository repository;
    
    public Iterable<Score> getAll(){
        return repository.findAll();
    }
    
    public Optional<Score> findById(String id){
        Optional<Score> response= repository.findById(id);
        return response;
    }

    public List<Score>getByMoviesAndClient(String name, String email){
        return repository.getScoreByMoviesAndClient(name, email);
    }
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Score save(Score score){
        return repository.save(score);
    }
    
}