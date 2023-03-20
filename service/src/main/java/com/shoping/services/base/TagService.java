package com.shoping.services.base;

import com.shoping.entity.base.Tag;
import com.shoping.repository.base.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagService {
    @Autowired
    private TagRepository repository;

    public Tag saveTag(Tag tag) {
        return repository.save(tag);
    }

    public List<Tag> saveTags(List<Tag> products) {
        return repository.saveAll(products);
    }

    public List<Tag> getAllTag() {
        return repository.findAll();
    }

    public Tag getTagById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteTag(int id) {
        repository.deleteById(id);
        return "tag is deleted" + id;
    }

    public Tag updateTag(Tag tag) {
        Tag exitsTag = repository.findById(tag.getId()).orElse(null);
//        exitsProduct.setName(tag.getName());
//        exitsProduct.setPrice(tag.getPrice());
//        exitsProduct.setPrice(tag.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
