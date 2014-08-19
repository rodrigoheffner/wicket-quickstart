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
package org.rodrigo.bezerra.wicket.quickstart.menu;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.rodrigo.bezerra.wicket.quickstart.page.PageManager;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel.MenuOrder;
import org.rodrigo.bezerra.wicket.quickstart.panel.BasePanel;

/**
 *
 * @author rodrigo
 */
public class MenuPanel extends BasePanel {

    public MenuPanel(String id) {
        super(id);

        setRenderBodyOnly(true);

        add(new ListView<PageModel>("menuItemsListView", PageManager.getInstance().getPages()) {
//        add(new ListView<PageModel>("menuItemsListView", new ArrayList()) {

            @Override
            protected void populateItem(final ListItem<PageModel> li) {
                final PageModel pageModel = li.getModelObject();
                final boolean hasChildren = !pageModel.getChildren().isEmpty();

                PageModel selectedPageModel = MenuPanel.this.getSession().getSelectedPageModel();
                li.setVisible(pageModel.getMenuOrder().equals(MenuOrder.PRIMARY));

                if (selectedPageModel != null && selectedPageModel.equals(pageModel)) {
                    li.add(new AttributeAppender("class", "active"));
                }
                WebMarkupContainer pageLink = new AjaxFallbackLink("pageLink") {

                    @Override
                    public void onClick(AjaxRequestTarget art) {
                        MenuPanel.this.getSession().setSelectedPageModel(pageModel);
                        setResponsePage(pageModel.getPageClass());
                    }
                };

                if (hasChildren) {
                    pageLink = new WebMarkupContainer("pageLink");
                    pageLink.add(new AttributeModifier("class", "dropdown-toggle"));
                    pageLink.add(new AttributeModifier("data-toggle", "dropdown"));
                    li.add(new AttributeAppender("class", " dropdown"));
                    pageLink.add(new AttributeModifier("href", "#"));
                }

                pageLink.add(new Label("pageLabel", pageModel.getLabel()));
                pageLink.add(new WebMarkupContainer("caretContainer").setVisible(hasChildren));
                li.add(pageLink);
                
                li.add(new ListView<PageModel>("dropdownMenu", pageModel.getChildren()) {

                    @Override
                    protected void populateItem(final ListItem<PageModel> childListItem) {
                        childListItem.setRenderBodyOnly(true);
                        childListItem.add(new AjaxFallbackLink("pageLink") {

                            @Override
                            public void onClick(AjaxRequestTarget art) {
                                MenuPanel.this.getSession().setSelectedPageModel(childListItem.getModelObject());
                                setResponsePage(childListItem.getModelObject().getPageClass());
                            }
                        }.add(new Label("pageLabel", childListItem.getModelObject().getLabel())));
                    }
                }.setVisible(hasChildren));
            }
        }.setRenderBodyOnly(true));
    }
}
