package com.projectmanager.services;



import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.projectmanager.models.LoginUser;
import com.projectmanager.models.User;
import com.projectmanager.repositories.UserRepository;

    

    
@Service
public class UserService {
	

	@Autowired
	private UserRepository userRepository;



	public User register(User newUser, BindingResult result) {
		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue( "email" ,"Unique" ,"This email is already in use! " );
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result. rejectValue("confirm", "Matches", "The Confirm password must match password");
		}
		String Pattern = newUser.getFirstName();
    	if (!Pattern.matches("[a-zA-Z]+")) {
    		 result.rejectValue("FirstName", "Matches", "Must contain letters only");
		}
    	String Patternl = newUser.getLastName();
    	if (!Patternl.matches("[a-zA-Z]+")) {
   		 result.rejectValue("LastName", "Matches", "Must contain letters only");
		}
		if(result.hasErrors()) {
				return null;
		}else{
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt. gensalt());
			newUser.setPassword(hashed);
			return userRepository.save(newUser) ;	
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepository.findByEmail(newLogin. getEmail());
		if( !potentialUser.isPresent()) {
			result.rejectValue("email" , "Unique" ,"Unknown email!");
			return null;
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue( "password" , "Matches","Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		}else {
			return user;
		}	
	}
	
	
	public User findUserById(Long id) {
		Optional <User> u = userRepository.findById(id);
	
		if(u.isPresent()){
		return u.get();
		}else {
		return null;
		}
	}
	
	
	public void deleteUser(Long id) {
		User user = this.findUserById(id);
		userRepository.delete(user);

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

}