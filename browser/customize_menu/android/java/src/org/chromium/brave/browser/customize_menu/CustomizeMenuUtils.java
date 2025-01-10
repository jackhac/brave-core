/* Copyright (c) 2025 The Brave Authors. All rights reserved.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/. */

package org.chromium.brave.browser.customize_menu;

import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.PopupMenu;
import org.chromium.base.Log;
import android.content.Context;
import org.chromium.brave.browser.customize_menu.R;

public class CustomizeMenuUtils {

    private static final String TAG = "CustomizeMenuUtils";

    /**
     * Gets a list of menu items belonging to a specific group ID.
     * 
     * @param context Android context needed to create PopupMenu
     * @param groupId The group ID to filter menu items by
     * @return List of MenuItem objects that belong to the specified group
     */
    public static List<MenuItem> getMenuItemsByGroup(Context context, int groupId) {
        List<MenuItem> filteredItems = new ArrayList<>();
        Menu menu = createPopupMenu(context);
        
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getGroupId() == groupId) {
                logMenuItemDetails(menuItem);
                filteredItems.add(menuItem);
            }
        }

        return filteredItems;
    }

    /**
     * Creates and initializes a PopupMenu with the brave_main_menu inflated.
     */
    private static Menu createPopupMenu(Context context) {
        PopupMenu popupMenu = new PopupMenu(context, null);
        Menu menu = popupMenu.getMenu();
        popupMenu.getMenuInflater().inflate(R.menu.brave_main_menu, menu);
        return menu;
    }

    /**
     * Logs details about a menu item for debugging purposes.
     */
    private static void logMenuItemDetails(MenuItem menuItem) {
        Log.e(TAG, "Menu item: " + menuItem.getTitle());
        Log.e(TAG, "Menu item: " + menuItem.getItemId());
    }
}
