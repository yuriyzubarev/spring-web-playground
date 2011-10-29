package com.yuriy_zubarev.spring.mvc.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="mailto:yuriyzubarev7@gmail.com">Yuriy Zubarev</a>
 */
@XmlRootElement(name = "widget")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Widget {

    @XmlAttribute
    private long id;

    @XmlElement
    private String name;

    @XmlElement
    private String description;

    public Widget() {
        this.id = 101l;
        this.name = "iPad";
        this.description = "Surf the web, check email, watch movies, play games, and more.";
    }
}
