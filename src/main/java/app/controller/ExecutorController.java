package app.controller;

import app.dto.ExecutorDTO;
import app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "executor")
public class ExecutorController {

    private IMusicService musicService;

    @Autowired
    public ExecutorController(IMusicService musicService){
        this.musicService =  musicService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExecutorDTO getExec(@PathVariable Integer id){
        return musicService.getExec(id);
    }



}
