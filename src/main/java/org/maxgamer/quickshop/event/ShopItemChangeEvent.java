/*
 * This file is a part of project QuickShop, the name is ShopItemChangeEvent.java
 *  Copyright (C) PotatoCraft Studio and contributors
 *
 *  This program is free software: you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *  for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.maxgamer.quickshop.event;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.maxgamer.quickshop.shop.Shop;

/**
 * Calling when shop item was changed
 */
public class ShopItemChangeEvent extends QSEvent implements Cancellable {
    @Getter
    private final ItemStack oldItem;

    @Getter
    private final ItemStack newItem;

    @Getter
    @NotNull
    private final Shop shop;

    private boolean cancelled;

    /**
     * Will call when shop price was changed.
     * All the item will be passed with a copy, so you can't change them
     *
     * @param shop    Target shop
     * @param oldItem The old shop item
     * @param newItem The new shop item
     */
    public ShopItemChangeEvent(@NotNull Shop shop, ItemStack oldItem, ItemStack newItem) {
        this.shop = shop;
        this.oldItem = oldItem.clone();
        this.newItem = newItem.clone();
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
