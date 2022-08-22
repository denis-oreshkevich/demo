package by.denis.project.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	private static final String HI = "Hi, ";
	private static final String GIVEN_NAME = "given_name";

	@GetMapping("/")
	public ResponseEntity<String> index(@AuthenticationPrincipal OAuth2User user) {
		return ResponseEntity.ok(HI + user.getAttribute(GIVEN_NAME));
	}

}
