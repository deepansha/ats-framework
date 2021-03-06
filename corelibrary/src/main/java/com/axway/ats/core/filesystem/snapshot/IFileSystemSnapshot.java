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
package com.axway.ats.core.filesystem.snapshot;

public interface IFileSystemSnapshot {

    public IFileSystemSnapshot newSnapshot(
                                            String newSnapshotName );

    public void setName(
                         String newName );

    public void addDirectory(
                              String directoryAlias,
                              String directoryPath );

    public void skipDirectory(
                               String rootDirectoryAlias,
                               String relativeDirectoryPath );

    public void skipFile(
                          String rootDirectoryAlias,
                          String relativeFilePath,
                          int... skipRules );

    public void skipFileByRegex(
                                 String rootDirectoryAlias,
                                 String relativeFilePath,
                                 int... skipRules );

    public void checkFile(
                           String rootDirectoryAlias,
                           String relativeFilePath,
                           int... checkRules );

    public void takeSnapshot();

    public void loadFromFile(
                              String sourceFile );

    public void toFile(
                        String backupFile );

    public String toString();

}
