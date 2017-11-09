package controllers;

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
        model.addAttribute("infoList", repo.getInfo());
        return "showAll";
    }

    /**
     * Страница со всеми записями + ссылка на переход к странице добавления записей
     */

    /**
     * Страница добавления записей. После добавления переадресция на страницу со всеми записями
     */
}