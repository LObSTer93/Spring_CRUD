package controllers;

import Data.Info;
import Data.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Должна использоваться rest-архитектура
 */
@Controller
public class MainController {

    private Repo repo;

    @Autowired
    public MainController(Repo repo) {
        this.repo = repo;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("infoList", repo.getAll());
        return "showAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(Model model) {
        model.addAttribute("isEdit", false);
        return "add_edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAdd(Info info) {
        repo.save(info);
        return "redirect:/showAll";
    }

    @RequestMapping(value = "/delete/{infoId}", method = RequestMethod.GET)
    public String delete(@PathVariable("infoId") String infoId) {
        repo.delete(Long.parseLong(infoId));
        return "redirect:/showAll";
    }

    @RequestMapping(value = "/edit/{infoId}", method = RequestMethod.GET)
        public String showEdit(Model model, @PathVariable("infoId") String infoId) {
        Info editedInfo = repo.getById(Long.parseLong(infoId));
        model.addAttribute("isEdit", true);
        model.addAttribute("info", editedInfo);
        return "add_edit";
    }

    @RequestMapping(value = "/edit/{infoId}", method = RequestMethod.POST)
    public String processEdit(Info info) {
        repo.edit(info);
        return "redirect:/showAll";
    }
}