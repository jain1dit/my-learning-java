package com.thrillio;

import java.util.List;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManager;
import com.thrillio.managers.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	private static void loadData() {
		System.out.println("1. Loading Data..");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		/*
		 * System.out.println("Printing Data .. "); printUserData();
		 * printBookmarkData();
		 */
	}

	private static void printBookmarkData() {
		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}

	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void start() {
		System.out.println("\n 2. Bookmarking ... ");
		for (User user : users) {
			View.browse(user, bookmarks);
		}

	}

	public static void main(String[] args) {
		loadData();
		start();

	}

}
