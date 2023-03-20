package com.shoping.repository.base;
import com.shoping.entity.base.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {
//    Product findByName(String name);
}
