package com.beltexam.services;

import java.util.Optional;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.beltexam.models.LoginUser;
import com.beltexam.models.User;
import com.beltexam.repositories.UserRepository;





@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {

		String Pattern = newUser.getName();
    	if (!Pattern.matches("[a-zA-Z]+")) {
    		 result.rejectValue("name", "Matches", "Must contain letters only");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password do not match!");
		}

		Optional<User> checkUser = userRepository.findByEmail(newUser.getEmail());
		if (checkUser.isPresent()) {
			result.rejectValue("email", "Matches", "A user with this email already exists!");
		}

		if (result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		userRepository.save(newUser);
		return newUser;
	}

	public User login(LoginUser newLoginObject, BindingResult result) {

		Optional<User> u = userRepository.findByEmail(newLoginObject.getEmail());

		if (!u.isPresent()) {

			result.rejectValue("email", "Matches", "Invalid Email or Password!");
		} else if (!BCrypt.checkpw(newLoginObject.getPassword(), u.get().getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Email or Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		return u.get();

	}

	public User findUserByEmail(String email) {
		Optional<User> u = userRepository.findByEmail(email);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}

	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}

	public void deleteUser(Long id) {
		User user = this.findUserById(id);
		userRepository.delete(user);

	}

}
