package dev.castle.contentcalendar.repository;

import dev.castle.contentcalendar.model.Content;
import dev.castle.contentcalendar.model.Status;
import dev.castle.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content>findAll() {
        return contentList;
    }

    public Optional<Content> findById (Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();

    }

    public void save(Content content) {
        contentList.add(content);
    }

    public void update(Content content){
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }

    public void delete(Integer id) {contentList.removeIf(content -> content.id().equals(id));}


    @PostConstruct
    private void init () {
     Content c = new Content(
       1,
        "My First Blog Post",
        "my first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(c);

    }

    public boolean existsById (Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }
}
