package pl.mygames.hackandslash.controller.website.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class UserCommon {
	private static final Logger logger = LoggerFactory.getLogger(UserCommon.class);

	protected Boolean authenticateUser(String login) {
		if (getActualLoggedUser().getUsername().equals(login)) {
			logger.info("User " + login + " is logged in");
			return true;
		}
		return false;
	}

	protected UserDetails getActualLoggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("Authentication exist in SecurityContextHolder");
		if (auth != null) {
			Object principal = auth.getPrincipal();
			logger.info("getting principal..");
			if (principal instanceof UserDetails) {
				UserDetails user = (UserDetails) principal;
				logger.info("Username in actual session: " + user.getUsername());
				return user;
			}
		}

		return null;
	}
	
	protected UserDetails getActualLogoutUser() {
		logger.info("Username in actual session: was logged out");
		SecurityContextHolder.clearContext();
		return null;
	}

}
