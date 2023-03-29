package ppark.pparkproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // /hello 라고 들어오는 주소에 이 메서드를 호출한다
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";

    }

    @GetMapping("hello-mvc")
    /// @RequestParam 외부에서 파라미터 받아오기
    public String helloMvc(@RequestParam(value = "name") String params, Model model) {
        System.out.println(params);
        model.addAttribute("name", params); ///key : value
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody // http body부에 return 값을 직접 넣어주겠다
    public String helloString(@RequestParam(value = "name") String params) {
        return String.format("{ contents : %s }", params); //ppark ver
    }
    @GetMapping("hello-api")
    @ResponseBody // http body부에 return 값을 직접 넣어주겠다
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("number") String number){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNumber(number);
        return hello;

    }
    static class Hello {
        private String name;
        private String number;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
