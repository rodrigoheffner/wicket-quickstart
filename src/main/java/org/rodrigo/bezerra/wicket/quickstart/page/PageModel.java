/*
 * Copyright 2014 Rodrigo Bezerra.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.rodrigo.bezerra.wicket.quickstart.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class PageModel implements Serializable {
    public enum MenuOrder {
        PRIMARY, SECONDARY
    }
    private String label;
    private String url;
    private MenuOrder menuOrder;
    private Class parent;
    private Class pageClass;
    private List<PageModel> children = new ArrayList<PageModel>();

    public PageModel(Class page) {
        this.url = ((Url)page.getAnnotation(Url.class)).value();
        this.label = ((PageLabel)page.getAnnotation(PageLabel.class)).value();
        this.menuOrder = ((Order)page.getAnnotation(Order.class)).value();
        this.pageClass = page;
        
        if (((Parent)page.getAnnotation(Parent.class)) != null) {
            parent = ((Parent)page.getAnnotation(Parent.class)).value();
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MenuOrder getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Class getParent() {
        return parent;
    }

    public void setParent(Class parent) {
        this.parent = parent;
    }

    public Class getPageClass() {
        return pageClass;
    }

    public void setPageClass(Class pageClass) {
        this.pageClass = pageClass;
    }

    public List<PageModel> getChildren() {
        return children;
    }

    public void setChildren(List<PageModel> children) {
        this.children = children;
    }
}