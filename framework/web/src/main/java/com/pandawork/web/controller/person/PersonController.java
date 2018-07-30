package com.pandawork.web.controller.person;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.service.PersonService;
import com.pandawork.web.spring.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Collections;
import java.util.List;

/**
 * @Author:liangll
 * @Description: PersonController
 * @Date: 16:24 2018/7/29
 */
@Controller
@RequestMapping("/person")
public class PersonController extends AbstractController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String personList(Model model) {
        try {
            List<Person> list = Collections.emptyList();
            list = personService.listAllPerson();
            //此即为foreach循环的item
            model.addAttribute("personList", list);
            return "home";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAddPerson(Model model) {
        try {
            List<Person> list = Collections.emptyList();
            list = personService.listAllPerson();
            model.addAttribute("personList", list);
            return "add";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public String addPerson(Person person, RedirectAttributes redirectAttributes) {
        System.out.println("aaaaaaaaa"+person);
        try {
            personService.addPerson(person);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
            return "redirect:/person/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delPerson(@PathVariable("id") int id) {
        try {
            personService.delPerson(id);
            //删除后还需重定向页面才可获取最新列表
            return "redirect:/person/list";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id , Model model){
        try{
            Person person = new Person();
            person = personService.selectById(id);
            model.addAttribute("person",person);
            return "update";
        }catch(SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(Person person ,@PathVariable("id")int id, Model model){
        try{
            if(Assert.isNull(person)){
                return null;
            }
            person.setId(id);
            model.addAttribute("person",person);
            personService.updatePerson(person);
            return "redirect:/person/list";
        }catch(SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String select(@RequestParam String keyword, Model model){
        try{
            List<Person> list = Collections.emptyList();
            list = personService.select(keyword);
            model.addAttribute("list",list);
            return "select";
        }catch(SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
