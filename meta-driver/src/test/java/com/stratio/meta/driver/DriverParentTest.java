/*
 * Stratio Meta
 *
 * Copyright (c) 2014, Stratio, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package com.stratio.meta.driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.stratio.meta.server.MetaServer;

public class DriverParentTest extends ParentCassandraTest {
    private static final long SLEEP_TIME = 5000;

    BasicDriver driver;

    MetaServer metaServer;

    @BeforeClass
    public void init(){
        driver=new BasicDriver();

        metaServer=new MetaServer();
        metaServer.init(null);
        metaServer.start();

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void finish(){
        driver.close();
        metaServer.stop();
        metaServer.destroy();
    }
}
