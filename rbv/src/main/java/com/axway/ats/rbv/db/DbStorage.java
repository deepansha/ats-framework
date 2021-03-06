/*
 * Copyright 2017 Axway Software
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.axway.ats.rbv.db;

import org.apache.log4j.Logger;

import com.axway.ats.core.dbaccess.DbProvider;
import com.axway.ats.rbv.model.RbvStorageException;
import com.axway.ats.rbv.storage.Matchable;
import com.axway.ats.rbv.storage.SearchTerm;
import com.axway.ats.rbv.storage.Storage;

public class DbStorage implements Storage {

    private static final Logger log = Logger.getLogger( DbStorage.class );

    private DbProvider          dbProvider;

    public DbStorage( DbProvider dbProvider ) {

        this.dbProvider = dbProvider;

        log.debug( "DB storage successfully initialized" );
    }

    public Matchable getFolder(
                                SearchTerm searchTerm ) throws RbvStorageException {

        if( searchTerm == null ) {
            throw new RbvStorageException( "Search term is null" );
        }

        if( ! ( searchTerm instanceof DbSearchTerm ) ) {
            throw new RbvStorageException( "Search term " + searchTerm.getClass().getSimpleName()
                                           + " is not supported" );
        }

        return new DbFolder( ( DbSearchTerm ) searchTerm, dbProvider );
    }
}
