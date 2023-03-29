package com.shoping.controller;

import com.shoping.entity.TagEntity;
import com.shoping.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TagController {
    @Autowired
    private TagService service;

    @PostMapping("/tag")
    public TagEntity createTag(@RequestBody TagEntity tagEntity) {
        return service.saveTag(tagEntity);
    }

    @PostMapping("/tags")
    public List<TagEntity> createTags(@RequestBody List<TagEntity> tagEntities) {
        return service.saveTags(tagEntities);
    }

    @GetMapping("/tag")
    public List<TagEntity> getAllTags() {
        return service.getAllTag();
    }

    @GetMapping("/tag/{id}")
    public TagEntity getTagById(@PathVariable int id) {
        return service.getTagById(id);
    }

    @PutMapping("/tag")
    public TagEntity updateTagByName(@RequestBody TagEntity tagEntity) {
        return service.updateTag(tagEntity);
    }

    @DeleteMapping("/tag/{id}")
    public String deleteTag(@PathVariable int id) {
        return service.deleteTag(id);
    }
}
