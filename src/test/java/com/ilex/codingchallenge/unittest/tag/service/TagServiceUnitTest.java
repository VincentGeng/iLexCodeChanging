package com.ilex.codingchallenge.unittest.tag.service;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ilex.codingchallenge.tag.entity.Tag;
import com.ilex.codingchallenge.tag.repository.TagRepository;
import com.ilex.codingchallenge.tag.service.TagService;
import com.ilex.codingchallenge.unittest.utils.TagTestUtils;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@SpringBootTest
public class TagServiceUnitTest {
	
	@Autowired
    private TagService tagService;
	
	@MockBean
	private TagRepository tagRepository;
	
	@Test
    @DisplayName("Test findAll Success")
	public void testFindAll() throws Exception {
		when(tagRepository.findAll()).thenReturn(Arrays.asList(TagTestUtils.mockTag()));
		List<Tag> tags = tagService.findAll();
		
		Assertions.assertSame(tags.size(), 1);
		Assertions.assertSame(tags.get(0).getName(), "PHONE");
	}
	
	@Test
    @DisplayName("Test save Success")
	public void testSave() throws Exception {
		when(tagRepository.saveAll(anyList())).thenReturn(Arrays.asList(TagTestUtils.mockTag()));
		List<Tag> tags = tagService.save(Arrays.asList(TagTestUtils.mockTag()));
		
		Assertions.assertSame(tags.size(), 1);
		Assertions.assertSame(tags.get(0).getName(), "PHONE");
	}
	
}
