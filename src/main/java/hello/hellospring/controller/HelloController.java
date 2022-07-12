package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        System.out.println("asdas " + model);
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        System.out.println(model);
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "<p>hello " + name+"</p>";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public List<Hello> helloApi(@RequestParam("name") String name){
        List<Hello> hello = new ArrayList<>();
        Hello a = new Hello();
        a.setName(name);
        hello.add(a);
        hello.add(a);
        hello.add(a);
        hello.add(a);
        hello.add(a);
        hello.add(a);

        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
