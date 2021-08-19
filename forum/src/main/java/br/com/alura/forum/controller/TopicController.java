package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @GetMapping(value = "/api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TopicBriefOutputDto> listTopics(){
        Category subcategory = new Category("Java", new Category(("Programação")));
        Course course = new Course("Java e JSF", subcategory);
        Topic topic = new Topic("Problemas com o JSF",
                "Erro ao fazer conversão de data",
                new User("Fulano","fulano@gmail.com","12345"), course);
        List<Topic> topics = Arrays.asList(topic, topic, topic,topic,topic);
        return TopicBriefOutputDto.listFromTopics(topics);
    }
}
