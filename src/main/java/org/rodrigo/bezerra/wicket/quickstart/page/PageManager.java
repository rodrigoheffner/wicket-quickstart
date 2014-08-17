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
import java.util.List;
import org.rodrigo.bezerra.wicket.quickstart.HomePage;

/**
 *
 * @author rodrigo
 */
public class PageManager {
    private static PageManager manager;
    private List<PageModel> pages = new ArrayList<PageModel>();
    
    private PageManager() {
//        pages.add(new PageModel(HomePage.class));
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
}
