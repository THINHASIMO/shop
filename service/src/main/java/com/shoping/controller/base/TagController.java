package com.shoping.controller.base;

import com.shoping.entity.base.Tag;
import com.shoping.services.base.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TagController {
    @Autowired
    private TagService service;

    @PostMapping("/tag")
    public Tag createTag(@RequestBody Tag tag) {
        return service.saveTag(tag);
    }

    @PostMapping("/tags")
    public List<Tag> createTags(@RequestBody List<Tag> tags) {
        return service.saveTags(tags);
    }

    @GetMapping("/tag")
    public List<Tag> getAllTags() {
        return service.getAllTag();
    }

    @GetMapping("/tag/{id}")
    public Tag getTagById(@PathVariable int id) {
        return service.getTagById(id);
    }

    @PutMapping("/tag")
    public Tag updateTagByName(@RequestBody Tag tag) {
        return service.updateTag(tag);
    }

    @DeleteMapping("/tag/{id}")
    public String deleteTag(@PathVariable int id) {
        return service.deleteTag(id);
    }
}
