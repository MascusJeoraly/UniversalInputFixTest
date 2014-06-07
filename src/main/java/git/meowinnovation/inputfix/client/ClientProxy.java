/*
 * Copyright (C) 2014  Fang0716
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package git.meowinnovation.inputfix.client;

import cpw.mods.fml.common.FMLCommonHandler;
import git.meowinnovation.inputfix.common.CommonProxy;
import git.meowinnovation.inputfix.common.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import git.meowinnovation.inputfix.common.CommonProxy;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
//        FMLCommonHandler.instance().bus().register(new KeyHandler());
        MinecraftForge.EVENT_BUS.register(EventHandler.instance);
    }
}
