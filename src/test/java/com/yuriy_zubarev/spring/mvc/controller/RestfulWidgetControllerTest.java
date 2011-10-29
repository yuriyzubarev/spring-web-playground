package com.yuriy_zubarev.spring.mvc.controller;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kind of useless tests because I cannot get a real response from Spring Web.
 * I need response.getContentAsString() to return something real!
 *
 * @author <a href="mailto:yuriyzubarev7@gmail.com">Yuriy Zubarev</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/playground-servlet.xml"})
public class RestfulWidgetControllerTest {

    @Autowired
    private ApplicationContext applicationContext;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Autowired
    private HandlerAdapter handlerAdapter;

    private RestfulWidgetController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        // I could get the controller from the context here
        controller = new RestfulWidgetController();
    }

    @Test
    public void testDoXML() throws Exception {
        request.setMethod("GET");
        request.setRequestURI("/widget.xml");
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        Assert.assertNotNull(mav);
        System.out.println("\nXML\n");
        System.out.println("mav.view = " + mav.getView());
        System.out.println("mav.model = " + mav.getModel());
    }

    @Test
    public void testDoJSON() throws Exception {
        request.setMethod("GET");
        request.setRequestURI("/widget.json");
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        Assert.assertNotNull(mav);
        System.out.println("\nJSON\n");
        System.out.println("mav.view = " + mav.getView());
        System.out.println("mav.model = " + mav.getModel());
    }

}
