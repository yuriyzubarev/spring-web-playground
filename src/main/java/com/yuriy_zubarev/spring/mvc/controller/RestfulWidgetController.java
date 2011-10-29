package com.yuriy_zubarev.spring.mvc.controller;

import com.yuriy_zubarev.spring.mvc.model.Widget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:yuriyzubarev7@gmail.com">Yuriy Zubarev</a>
 */
@Controller
public class RestfulWidgetController {


    @RequestMapping(value="/widget", method = RequestMethod.GET)
    public ModelAndView getWidget() {
        ModelAndView mav = new ModelAndView("foo", "bar", new Widget());

        return mav;
    }
}
