package com.thrillio;

import java.util.List;

import com.thrillio.constants.KidFriendlyStatus;
import com.thrillio.constants.UserType;
import com.thrillio.controllers.BookmarkController;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;

public class View {

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n" + user.getEmail() + " is bookmarking"); for (int i =
	 * 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset = (int)
	 * (Math.random() * DataStore.BOOKMARK_TYPES_COUNT); int bookmarkOffset = (int)
	 * (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */

	public static void browse(User user,List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items");
		int bookmarkCount = 0;

		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				//if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println(bookmark);
					}
				//}
				
				// Mark as kid friendly
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKOWN)) {
							System.out.println("kid friendly status: " + kidFriendlyStatus + " , " + bookmark);
						}
					}
				}
			}
		}
		/*
		 * for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset =
		 * (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT); int bookmarkOffset =
		 * (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
		 * 
		 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
		 * 
		 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
		 * 
		 * System.out.println(bookmark); }
		 */
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED:
			(Math.random() >= 0.4 && Math.random()> 0.8) ? KidFriendlyStatus.APPROVED: KidFriendlyStatus.UNKOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

}
