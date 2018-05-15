package com.meklit.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;



@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model){

        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
        actorRepository.save(a);

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        movie.addActor(a);
        movieRepository.save(movie);

        a.addMovie(movie);
        actorRepository.save(a);



        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
