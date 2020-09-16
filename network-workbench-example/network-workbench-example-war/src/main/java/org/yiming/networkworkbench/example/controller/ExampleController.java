package org.yiming.networkworkbench.example.controller;

import org.yiming.networkworkbench.example.service.ExampleService;
import org.yiming.networkworkbench.framework.beans.annotation.Autowirted;
import org.yiming.networkworkbench.framework.beans.annotation.Controller;
import org.yiming.networkworkbench.framework.beans.annotation.RequestMapping;
import org.yiming.networkworkbench.framework.beans.annotation.RequestParam;

@Controller
@RequestMapping
public class ExampleController {

    @Autowirted
    private ExampleService exampleService;

    @RequestMapping
    public String example(@RequestParam("name") String name){
        return exampleService.example(name);
    }

}
