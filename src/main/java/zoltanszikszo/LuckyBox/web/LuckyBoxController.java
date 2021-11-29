package zoltanszikszo.LuckyBox.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zoltanszikszo.LuckyBox.domain.UserRepository;
import zoltanszikszo.LuckyBox.domain.Userboxes;
import zoltanszikszo.LuckyBox.domain.UserboxesRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class LuckyBoxController {

    @Autowired
    private UserboxesRepository boxRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/boxeslist")
    public String getUserBoxes(Model model){
        model.addAttribute("boxes", boxRepository.findAll());
        return "boxeslist";
    }

    @RequestMapping(value="/boxes", method = RequestMethod.GET)
    public @ResponseBody List<Userboxes> userboxesListRest() {
        return (List<Userboxes>) boxRepository.findAll();
    }

    @RequestMapping(value="/boxes/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Userboxes> findUserboxesRest(@PathVariable("id") Long userboxesid) {
        return boxRepository.findById(userboxesid);
    }

    @RequestMapping("/addBox")
    public String addBox(Model model){
        model.addAttribute("userboxes", new Userboxes());
        return "addBox";
    }

    @PostMapping(value = "/save")
    public String saveBox(Userboxes userboxes){
        boxRepository.save(userboxes);
        return "redirect:boxeslist";
    }

    @RequestMapping(value="/purchase/{id}", method = RequestMethod.GET)
        public String purchaseBox(@PathVariable("id") Long userboxesid, Model model){
        model.addAttribute("userboxes", boxRepository.findById(userboxesid));
        return "purchaseBox";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
        public String deleteBox(@PathVariable("id") Long userboxesid, Model model){
        boxRepository.deleteById(userboxesid);
        return "redirect:../boxeslist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
        public String editBox(@PathVariable("id") Long userboxesid, Model model){
        model.addAttribute("userboxes", boxRepository.findById(userboxesid));
        return "editBox";
    }
}
