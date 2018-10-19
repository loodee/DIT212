package com.example.ohimarc.marc.service;

/**
 * @author Gustav Albertsson
 *
 * This class is a factory for creating different kinds of objects implementing UserStorage
 * */
public class UserStorageFactory {

    /**
     * Creates a new LocalUserStorage objects with the given filePath
     * @param filePath The filepath to which the files should be saved
     * @return a LocalUserStorage object
     * */
    public static UserStorage createLocalUserStorage(String filePath){
        return new LocalUserStorage(filePath);
    }

}
