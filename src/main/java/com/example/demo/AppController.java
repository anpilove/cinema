package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // связь зависимотей
import org.springframework.data.repository.query.Param; // привязываем параметры
import org.springframework.stereotype.Controller; // класс управляющий
import org.springframework.ui.Model; // взаимодействия view controller
import org.springframework.web.bind.annotation.ModelAttribute; // связывание параметра и метода , который выводится в веб интейфейс
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; // название html страниц которые подвязываются к контролеру

@Controller
public class AppController {

    @Autowired
    private SessionService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Session> listSession= service.listAll(keyword);
        model.addAttribute("listSession", listSession);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewSessionForm(Model model){
        Session session = new Session();
        model.addAttribute("Session", session);
        return "new_session";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("Session") Session session){
        service.save(session);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditSessionFrom(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_session");
        Session session = service.get(id);
        mav.addObject("Session", session );
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }


}
