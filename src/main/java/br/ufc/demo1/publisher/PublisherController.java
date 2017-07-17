package br.ufc.demo1.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuizI on 18/07/2017.
 */
@RestController
@RequestMapping("/publichers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;



}
