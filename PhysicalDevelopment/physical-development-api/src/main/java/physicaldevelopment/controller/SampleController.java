package physicaldevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	@RequestMapping("/sample")
	public String checkedMemberRegister(Model model) {

		return "sample";
	}

}
