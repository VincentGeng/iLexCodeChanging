package com.ilex.codingchallenge.tag.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilex.codingchallenge.tag.entity.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface TagRepository extends CrudRepository<Tag, Long> {

}
