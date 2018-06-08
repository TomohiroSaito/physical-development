package sankutyu.api.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sankutyu.model.user.User;

@Controller
@RequestMapping("/user/create")
public class CreateUserController {
	
	@ResponseBody
	@RequestMapping("/register")
	public CreateUserResponse createUser(User user){
		
		return new CreateUserResponse();
	}
	
}
