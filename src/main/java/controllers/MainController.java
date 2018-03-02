package controllers;

import Data.Info;
import Data.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Должна использоваться rest-архитектура
 */
@Controller
public class MainController {

    @Autowired
    Repo repo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model){
        model.addAttribute("infoList", repo.getAll());
        return "showAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(Model model){
        model.addAttribute("isEdit", false);
        return "add_edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAdd(Info info){
        repo.save(info);
        return "redirect:/showAll";
    }

    /**
     * Страница со всеми записями + ссылка на переход к странице добавления записей
     */

    /**
     * Страница добавления записей. После добавления переадресция на страницу со всеми записями
     */
}