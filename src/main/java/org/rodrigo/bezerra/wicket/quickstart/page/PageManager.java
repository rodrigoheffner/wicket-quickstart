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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.rodrigo.bezerra.wicket.quickstart.HomePage;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel.MenuOrder;
import org.rodrigo.bezerra.wicket.quickstart.sitemap.SitemapPage;
import org.rodrigo.bezerra.wicket.quickstart.test.TestFirstChildPage;
import org.rodrigo.bezerra.wicket.quickstart.test.TestParentPage;
import org.rodrigo.bezerra.wicket.quickstart.test.TestSecondChildPage;

/**
 *
 * @author rodrigo
 */
public class PageManager {

    private static PageManager manager;
    private static List<PageModel> pages = new ArrayList<PageModel>();

    private PageManager() {
        pages.add(new PageModel(HomePage.class));
        pages.add(new PageModel(TestParentPage.class));
        pages.add(new PageModel(TestFirstChildPage.class));
        pages.add(new PageModel(TestSecondChildPage.class));
        
        // Leave the Sitemap page as the last page model, so it's always displayed as the rightmost menu item
        pages.add(new PageModel(SitemapPage.class));
        
        for (PageModel pageModel : pages) {
            if (pageModel.getParent() != null) {
                getPageModel(pageModel.getParent()).getChildren().add(pageModel);
            }
        }
    }

    public static PageManager getInstance() {
        if (manager == null) {
            manager = new PageManager();
        }

        return manager;
    }

    public List<PageModel> getPages() {
        return pages;
    }
    
    public List<List<PageModel>> getPagesByParent() {
        List<List<PageModel>> pagesByParent = new ArrayList<List<PageModel>>();

        for (PageModel pageModel : pages) {
            if (pageModel.getMenuOrder().equals(MenuOrder.PRIMARY)) {
                List<PageModel> pageModelList = new ArrayList<PageModel>();
                pageModelList.add(pageModel);
                pageModelList.addAll(pageModel.getChildren());
                
                pagesByParent.add(pageModelList);
            }
        }
        
        return pagesByParent;
    }

    public static PageModel getPageModel(Class className) {
        PageModel targetPageModel = null;

        for (PageModel pageModel : pages) {
            if (pageModel.getPageClass().equals(className)) {
                targetPageModel = pageModel;
                break;
            }
        }
        
        return targetPageModel;
    }
}