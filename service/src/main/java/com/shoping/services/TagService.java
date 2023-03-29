package com.shoping.services;

import com.shoping.entity.TagEntity;
import com.shoping.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagService {
    @Autowired
    private TagRepository repository;

    public TagEntity saveTag(TagEntity tagEntity) {
        return repository.save(tagEntity);
    }

    public List<TagEntity> saveTags(List<TagEntity> products) {
        return repository.saveAll(products);
    }

    public List<TagEntity> getAllTag() {
        return repository.findAll();
    }

    public TagEntity getTagById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteTag(int id) {
        repository.deleteById(id);
        return "tag is deleted" + id;
    }

    public TagEntity updateTag(TagEntity tagEntity) {
        TagEntity exitsTagEntity = repository.findById(tagEntity.getId()).orElse(null);
//        exitsProduct.setName(tag.getName());
//        exitsProduct.setPrice(tag.getPrice());
//        exitsProduct.setPrice(tag.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
