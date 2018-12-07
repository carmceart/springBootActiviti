package org.cgenh.springBoot.activiti;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/world")
public class WorldHello {
    @RequestMapping("world")
    @ResponseBody
    public String gaga(){
        return "worldhello";
    }
}
