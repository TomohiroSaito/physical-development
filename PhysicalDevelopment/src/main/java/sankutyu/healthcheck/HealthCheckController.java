package sankutyu.healthcheck;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/healthcheck")
public class HealthCheckController {
	
	@RequestMapping("")
	@ResponseBody
	public String healthCheck(){
		return "OK";
	}
}
