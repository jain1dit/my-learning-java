package com.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: porn in URL -- false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For porn in url - isKidFriendlyEligible() returns false");
		
		//Test 2: porn in title -- false
		
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For porn in title - isKidFriendlyEligible() returns false");

		
		//Test 3: adult in host -- false 
		
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");

		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For adult in host - isKidFriendlyEligible() returns false");
		
		//Test 4: adult in url, but not in  host part -- true
		
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue(isKidFriendlyEligible,"For adult in url, but not in  host part - isKidFriendlyEligible() returns true");
		
		//Test 5: adult in title only -- true
		
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue(isKidFriendlyEligible,"For adult in url, but not in  host part - isKidFriendlyEligible() returns true");
		
	}

}
