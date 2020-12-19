package com.ilex.codingchallenge.unittest.utils;

import com.ilex.codingchallenge.tag.entity.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class TagTestUtils {
	public static Tag mockTag(){
		Tag tag = new Tag();
		tag.setTagId(1l);
		tag.setName("PHONE");
		return tag;
	}
}
