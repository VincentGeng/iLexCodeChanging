package com.ilex.codingchallenge.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilex.codingchallenge.tag.entity.Tag;
import com.ilex.codingchallenge.tag.repository.TagRepository;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */

@Transactional
@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagRepository tagRepository;

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.tag.service.TagService#findAll()
	 */
	@Override
	public List<Tag> findAll() {
		return (List<Tag>) tagRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.tag.service.TagService#save(java.util.List)
	 */
	@Override
	public List<Tag> save(List<Tag> tags) {
		return (List<Tag>) tagRepository.saveAll(tags);
	}
	
}
