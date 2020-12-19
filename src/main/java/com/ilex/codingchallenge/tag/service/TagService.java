package com.ilex.codingchallenge.tag.service;

import java.util.List;

import com.ilex.codingchallenge.tag.entity.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface TagService {

	/**
	 * @return
	 */
	List<Tag> findAll();

	/**
	 * @param tags
	 */
	List<Tag> save(List<Tag> tags);

}
