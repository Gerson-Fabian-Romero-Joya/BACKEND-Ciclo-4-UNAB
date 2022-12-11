/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Client;
import com.app.movie.entities.Score;
import com.app.movie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    ScoreService service;

    @GetMapping("")
    public Iterable<Score> get() {
        return service.get();
    }

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseDto create(@RequestBody Score request) {
//       return service.create(request);
//    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> create(@RequestBody Score request) {
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> responseS = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);

        if(responseDto.status.booleanValue()==true){
            responseS = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }
        return responseS;
    }
    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Score update(@RequestBody Score request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}