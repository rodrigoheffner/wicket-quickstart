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
package org.rodrigo.bezerra.wicket.quickstart.sitemap;

import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.rodrigo.bezerra.wicket.quickstart.BootstrapPage;
import org.rodrigo.bezerra.wicket.quickstart.page.Order;
import org.rodrigo.bezerra.wicket.quickstart.page.PageLabel;
import org.rodrigo.bezerra.wicket.quickstart.page.PageManager;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel;
import org.rodrigo.bezerra.wicket.quickstart.page.Url;

/**
 *
 * @author rodrigo
 */
@Url("/sitemap.html")
@PageLabel("Sitemap")
@Order(PageModel.MenuOrder.PRIMARY)
public class SitemapPage extends BootstrapPage {

    public SitemapPage() {

        add(new ListView<List<PageModel>>("pageGroupListView", PageManager.getInstance().getPagesByParent()) {
            @Override
            protected void populateItem(ListItem<List<PageModel>> li) {
                li.add(new ListView<PageModel>("pagesListView", li.getModelObject()) {

                    @Override
                    protected void populateItem(ListItem<PageModel> item) {
                        // TODO: Separate into different groups by parent page
                        item.add(new BookmarkablePageLink("pageLink", item.getModelObject().getPageClass())
                                .add(new Label("pageLabel", item.getModelObject().getLabel())));
                    }
                });
            }
        });
    }
}